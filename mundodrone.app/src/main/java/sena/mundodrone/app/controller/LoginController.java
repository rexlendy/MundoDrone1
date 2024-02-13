package sena.mundodrone.app.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sena.mundodrone.app.presentation.SpringFxmlLoader;
import sena.mundodrone.app.servicio.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
@Component
public class IndexController implements Initializable {
                                        //me fuerza a colocar la conversion (logger) explicitamente
    //private static final Logger logger = (Logger) new LoggerFactory().getLogger(IndexController.class);
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    public Button ProveedorButton;

    @Autowired
    private LoginService loginService;
    @Autowired
    private SpringFxmlLoader springFxmlLoader;

    @FXML
    private Button loginButton;
    @FXML
    private TextField cajaUsuario;
    @FXML
    private PasswordField cajaContrasena;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    //private void configurarTable(){
        //setCellValueFactory() método para configurar la forma en que se muestran los datos en una columna
        // de una tabla en JavaFX, permitiendo personalizar la lógica de obtención de valores según las necesidades específicas de la aplicación.
    //}

    public void iniciarSesion(ActionEvent actionEvent) throws IOException {
        String usuario = cajaUsuario.getText();
        String contrasena = cajaContrasena.getText();
        if (loginService.autenticar(usuario, contrasena)){
            mostrarAlerta("Excelente!" , "Inicio de sesion exitoso");

        // Cargamos la vista de menu
        Parent root = springFxmlLoader.load("Menu.fxml");

        Stage stage = new Stage();
        stage.setTitle("Menu Principal");


        // nueva escena y la configuramos con la vista de Menu.fxml
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Mostramos la ventana de menu
        stage.show();

        // Cerramos la hp ventana actual (si es necesario)
        // Obtenemos la ventana actual (inicio de sesión) y la cerramos
        Stage loginStage = (Stage) loginButton.getScene().getWindow();
        loginStage.close();
        }else {
            mostrarAlerta("Inicio de sesion fallido", "Nombre de usuario o contraseña incorrectos.");
        }
    }

    public void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void abrirMenu(ActionEvent actionEvent) {
    }
}

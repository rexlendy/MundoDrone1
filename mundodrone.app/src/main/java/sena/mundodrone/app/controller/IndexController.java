package sena.mundodrone.app.controller;

import com.sun.org.slf4j.internal.LoggerFactory;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sena.mundodrone.app.servicio.LoginService;

import java.net.URL;
import java.util.ResourceBundle;
@Component
public class IndexController implements Initializable {
                                        //me fuerza a colocar la conversion (logger) explicitamente
    private static final Logger logger = (Logger) new LoggerFactory().getLogger(IndexController.class);
    @Autowired
    private LoginService loginService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void configurarTable(){
        //setCellValueFactory() método para configurar la forma en que se muestran los datos en una columna
        // de una tabla en JavaFX, permitiendo personalizar la lógica de obtención de valores según las necesidades específicas de la aplicación.
    }
}

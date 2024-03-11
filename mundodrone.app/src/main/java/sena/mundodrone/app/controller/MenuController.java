package sena.mundodrone.app.controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sena.mundodrone.app.model.*;
import sena.mundodrone.app.presentation.SpringFxmlLoader;
import sena.mundodrone.app.servicio.CategoriaService;
import sena.mundodrone.app.servicio.ClienteService;
import sena.mundodrone.app.servicio.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.*;

@Component
public class MenuController implements Initializable  {


    @FXML
    private PieChart pieChartVentasPorCategoria;


    @FXML
    private ComboBox<CategoriaEntity> categoriaComboBox;

    public Button btnGestionProveedor;
    public Button btnGestionProductos;
    public Button btnGestionVenta;
    public Button btnGestionClientes;
    @FXML
    private Label ventasDelDiaLabel;
    @FXML
    private Label clientesDelDiaLabel;
    @FXML
    private Label facturacionDelDiaLabel;

    @Autowired
    private SpringFxmlLoader springFxmlLoader;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VentaService ventaService;
    @Autowired
    private CategoriaService categoriaService;

    @FXML
    private VBox labelsContainer; // Un VBox en el FXML para contener las etiquetas personalizadas

    @FXML
    private Label labelCategoria1;

    @FXML
    private Label labelCategoria2;

    @FXML
    private Label labelCategoria3;

    @FXML
    private Label labelCategoria4;

    @FXML
    private Label labelCategoria5;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        grafico();
        List<String> nombresCategorias = obtenerNombresCategorias();
        asignarNombresEtiquetas(nombresCategorias);
        actualizarPanelesDelDia();

    }

    private void actualizarPanelesDelDia() {
        //obtenemos ls clientes del dia
        List<ClienteEntity> clientesDelDia = clienteService.obtenerClientesDelDia(LocalDate.now());
        clientesDelDiaLabel.setText(String.valueOf(clientesDelDia.size()));
        //obtenemos las ventas del dia.
        List<VentaEntity> ventasDelDia = ventaService.obtenerVentasDelDia(LocalDateTime.now().toLocalDate());
        ventasDelDiaLabel.setText(String.valueOf(ventasDelDia.size()));

        // Calcular facturación del día
        BigDecimal facturacionDelDia = ventaService.calcularFacturacionDelDia(LocalDateTime.now().toLocalDate());
        facturacionDelDiaLabel.setText(facturacionDelDia.toString());
        // Formatear la facturación del día como moneda colombiana
        Locale localeColombia = new Locale("es", "CO");
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(localeColombia);
        String facturacionDelDiaFormateada = formatoMoneda.format(facturacionDelDia);

        facturacionDelDiaLabel.setText(facturacionDelDiaFormateada);
    }

    public void grafico(){
        // Desactivar la visualización predeterminada de los nombres y colores de las secciones
        pieChartVentasPorCategoria.setLegendVisible(false);
        pieChartVentasPorCategoria.setLabelsVisible(false);
        // Obtener todas las ventas del mes actual
        LocalDate inicioMes = LocalDate.now().withDayOfMonth(1);
        LocalDate finMes = inicioMes.withDayOfMonth(inicioMes.lengthOfMonth());
        List<VentaEntity> ventasDelMes = ventaService.obtenerVentasDelMes(inicioMes, finMes);

        // Calcular la cantidad de ventas por categoría
        Map<CategoriaEntity, Integer> ventasPorCategoria = new HashMap<>();
        for (VentaEntity venta : ventasDelMes) {
            for (DetalleVentaEntity detalleVenta : venta.getDetallesventa()) {
                CategoriaEntity categoria = detalleVenta.getProducto().getCategoria();
                ventasPorCategoria.put(categoria, ventasPorCategoria.getOrDefault(categoria, 0) + detalleVenta.getVenta().getCantidad());
            }
        }

        // Calcular el total de ventas del mes
        int totalVentas = ventasDelMes.stream().mapToInt(VentaEntity::getCantidad).sum();

        // Crear los datos para el PieChart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<CategoriaEntity, Integer> entry : ventasPorCategoria.entrySet()) {
            CategoriaEntity categoria = entry.getKey();
            int cantidadVentas = entry.getValue();
            double porcentaje = (double) cantidadVentas / totalVentas * 100;
            pieChartData.add(new PieChart.Data(categoria.getNombre() + " (" + String.format("%.2f", porcentaje) + "%)", porcentaje));
        }

        // Establecer los datos en el PieChart
        pieChartVentasPorCategoria.setData(pieChartData);
        // Llamar al método para configurar los colores
        configurarColores();
    }

    // Método para configurar los colores en el PieChart
    private void configurarColores() {
        ObservableList<PieChart.Data> pieChartData = pieChartVentasPorCategoria.getData();
        String[] colores = {"#CEA66D", "#CE2D4F", "#357E8F", "#24264B"};
        for (int i = 0; i < pieChartData.size(); i++) {
            PieChart.Data data = pieChartData.get(i);
            data.getNode().setStyle("-fx-pie-color: " + colores[i] + ";");
        }
    }



    // Método para obtener los nombres de las categorías desde el gráfico de pastel
    private List<String> obtenerNombresCategorias() {
        ObservableList<PieChart.Data> datosGrafico = pieChartVentasPorCategoria.getData();
        List<String> nombresCategorias = new ArrayList<>();
        for (PieChart.Data data : datosGrafico) {
            nombresCategorias.add(data.getName());
        }
        return nombresCategorias;
    }

    // Método para asignar los nombres de las categorías a las etiquetas
    private void asignarNombresEtiquetas(List<String> nombresCategorias) {
        // Limpiar las etiquetas existentes en el VBox
        labelsContainer.getChildren().clear();
        String[] colores = {"#CEA66D", "#CE2D4F", "#357E8F", "#24264B"};
        for (int i = 0; i < nombresCategorias.size() && i < colores.length; i++) {
            Label label = obtenerLabelCategoria(i + 1); // Obtener el Label correspondiente según el índice
            if (label != null) {
                String nombreCategoria = nombresCategorias.get(i);
                label.setText(nombreCategoria); // Asignar el nombre de la categoría al Label
                Circle circle = new Circle(8); // Crear un círculo
                circle.setStyle("-fx-fill: " + colores[i] + ";"); // Establecer el color del círculo
                label.setGraphic(circle); // Asignar el círculo como gráfico al Label
                // Agregar la etiqueta al VBox
                labelsContainer.getChildren().add(label);
            }
        }
    }


    // Método para obtener el color de una categoría
    private String obtenerColorCategoria(String nombreCategoria) {
        // Implementa la lógica para asociar cada nombre de categoría con su respectivo color
        switch (nombreCategoria) {
            case "DJI":
                return "#CE2D4F"; //ROJO
            case "INICIACION":
                return "#357E8F";
            case "JJRC":
                return "#24264B";
            case "XIAOMI":
                return "#CEA66D";
            default:
                return "#000000"; // Color por defecto si el nombre de la categoría no coincide
        }
    }



    // Método para obtener un icono representativo del color de la categoría
    private Node obtenerIconoCategoria(String color) {
        Circle circle = new Circle(8); // Círculo para representar el color
        circle.setFill(Color.web(color)); // Establecer el color del círculo basado en el color de la categoría
        return circle;
    }


    // Método para obtener el Label de categoría según el índice
    private Label obtenerLabelCategoria(int indice) {
        switch (indice) {
            case 1:
                return labelCategoria1;
            case 2:
                return labelCategoria2;
            case 3:
                return labelCategoria3;
            case 4:
                return labelCategoria4;
            case 5:
                return labelCategoria5;
            default:
                return null;
        }
    }




    public void abrirProveedor(ActionEvent actionEvent) {
        try {

            // Cargamos la vista de productos.fxml
            Parent root = springFxmlLoader.load("Proveedor.fxml");

            Stage stage = new Stage();
            stage.setTitle("Ventana de proveedor");


            // Creamos una nueva escena y la configuramos con la vista de Proveedor.fxml
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Mostramos la ventana de Proveedor
            stage.show();

            // Cerramos la ventana actual (si es necesario)
            // Obtenemos la ventana actual (inicio de sesión) y la cerramos
            Stage menuStage = (Stage) btnGestionProveedor.getScene().getWindow();
            menuStage.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }


    public void abrirProductos(ActionEvent actionEvent) {

        try {

            // Cargamos la vista de productos.fxml
            Parent root = springFxmlLoader.load("Productos.fxml");

            Stage stage = new Stage();
            stage.setTitle("Gestion de productos");


            // Creamos una nueva escena y la configuramos con la vista de Productos.fxml
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Mostramos la ventana de productos
            stage.show();

            // Cerramos la ventana actual (si es necesario)
            // Obtenemos la ventana actual (inicio de sesión) y la cerramos
            Stage menuStage = (Stage) btnGestionProductos.getScene().getWindow();
            menuStage.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public void abrirPuntoVenta(ActionEvent actionEvent) {

        try {

            // Cargamos la vista de venta.fxml
            Parent root = springFxmlLoader.load("Venta.fxml");

            Stage stage = new Stage();
            stage.setTitle("Gestion de Ventas");


            // Creamos una nueva escena y la configuramos con la vista de Venta.fxml
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Mostramos la ventana de Venta
            stage.show();

            // Cerramos la ventana actual (si es necesario)
            // Obtenemos la ventana actual (inicio de sesión) y la cerramos
            Stage menuStage = (Stage) btnGestionVenta.getScene().getWindow();
            menuStage.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public void abrirClientes(ActionEvent actionEvent) {
        try {

            // Cargamos la vista de productos.fxml
            Parent root = springFxmlLoader.load("Cliente.fxml");

            Stage stage = new Stage();
            stage.setTitle("Gestion de Clientes");


            // Creamos una nueva escena y la configuramos con la vista de Proveedor.fxml
            Scene scene = new Scene(root);
            stage.setScene(scene);

            // Mostramos la ventana de Proveedor
            stage.show();

            // Cerramos la ventana actual (si es necesario)
            // Obtenemos la ventana actual (inicio de sesión) y la cerramos
            Stage clientesStage = (Stage) btnGestionClientes.getScene().getWindow();
            clientesStage.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}

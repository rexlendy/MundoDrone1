package sena.mundodrone.app.presentation;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import sena.mundodrone.app.MundodroneApplication;

import java.io.IOException;

public class SistemaMundodroneFx extends Application {
    /*public static void main(String[] args) {
        launch(args);  este main es que normalmente se  utiliza en una aplicacion con javaFx
        pero si se usa este no podriamos utilizar sringboot
    }*/

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init(){

        this.applicationContext= new SpringApplicationBuilder(MundodroneApplication.class).run();
    }
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(MundodroneApplication.class.getResource("/Templates/index.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        //En resumen, la línea de código loader.setControllerFactory(applicationContext::getBean)
        // está configurando un cargador de archivos FXML para que utilice el contenedor de Spring (applicationContext)
        // para obtener instancias de controladores administrados por Spring. Esto permite que los
        // controladores definidos en los archivos FXML accedan a los servicios y componentes administrados por Spring.
            Scene escena = new Scene(loader.load());
            stage.setScene(escena);
            stage.show();
        }
    @Override public void stop(){
        applicationContext.stop();
        Platform.exit();
    }
}

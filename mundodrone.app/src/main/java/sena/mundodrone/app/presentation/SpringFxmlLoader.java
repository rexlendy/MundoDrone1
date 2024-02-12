package sena.mundodrone.app.presentation;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
@Component
public class SpringFxmlLoader extends FXMLLoader {

    private final ApplicationContext applicationContext;

    public SpringFxmlLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <T> T load(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        // La ruta base de archivos FXML
        String fxmlBasePath = "/templates/";
        URL location = getClass().getResource(fxmlBasePath + fxmlFileName);
        loader.setLocation(location);
        loader.setControllerFactory(applicationContext::getBean);
        return loader.load();
    }

}


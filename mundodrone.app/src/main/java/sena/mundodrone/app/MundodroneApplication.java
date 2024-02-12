package sena.mundodrone.app;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sena.mundodrone.app.presentation.SistemaMundodroneFx;

@SpringBootApplication
public class MundodroneApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MundodroneApplication.class, args);
		Application.launch(SistemaMundodroneFx.class);
	}

}

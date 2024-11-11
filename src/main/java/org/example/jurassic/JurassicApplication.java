package org.example.jurassic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class JurassicApplication {

    public static void main(String[] args) {
        SpringApplication.run(JurassicApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void openBrowser() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                // Windows
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://localhost:8080/principal");
            } else if (os.contains("mac")) {
                // Mac
                Runtime.getRuntime().exec("open http://localhost:8080/principal");
            } else if (os.contains("nix") || os.contains("nux")) {
                // Linux
                Runtime.getRuntime().exec("xdg-open http://localhost:8080/principal");
            } else {
                System.err.println("Sistema operativo no soportado para abrir el navegador.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

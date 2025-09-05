package pe.edu.vallegrande.quality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class VgQualityChallengeApplication {

    // Definir un logger para esta clase
    private static final Logger log = LoggerFactory.getLogger(VgQualityChallengeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VgQualityChallengeApplication.class, args);
        log.info("✅ App started...");
    }
}


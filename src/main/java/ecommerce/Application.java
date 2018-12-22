package ecommerce;

import ecommerce.domain.Client;
import ecommerce.domain.Commande;
import ecommerce.domain.Livre;
import ecommerce.repository.ClientRepository;
import ecommerce.repository.CommandeRepository;
import ecommerce.repository.LivreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Date;

@SpringBootApplication(scanBasePackages = "ecommerce")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initializer(ClientRepository clientRepo, CommandeRepository commandeRepo, LivreRepository livreRepo)
    {
        return args -> {


        };
    }
}
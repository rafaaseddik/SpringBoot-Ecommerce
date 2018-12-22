package ecommerce.service;

import ecommerce.domain.Client;
import ecommerce.domain.Commande;
import ecommerce.domain.Panier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommandeService {
    Commande createCommande(Commande commande);
    Commande updateCommande(Commande commande);
    void deleteCommande(Commande commande);
    Commande getCommandeById(Long id);
    List<Commande> getAllCommandes();
    Commande createCommandeFromPanier(Panier panier, Client client);

}

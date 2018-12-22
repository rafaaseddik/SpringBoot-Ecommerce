package ecommerce.service.implementation;

import ecommerce.domain.Client;
import ecommerce.domain.Commande;
import ecommerce.domain.Livre;
import ecommerce.domain.Panier;
import ecommerce.repository.CommandeRepository;
import ecommerce.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Commande commande) {
        commandeRepository.delete(commande);
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.getOne(id);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
    /*TODO*/
    @Override
    public Commande createCommandeFromPanier(Panier panier, Client client) {
        Commande commande = new Commande();
        commande.getLivres().addAll(panier.getLivres());
        commande.setClient(client);
        BigDecimal sum = new BigDecimal(0);
        for(Livre livre:panier.getLivres())
            sum = sum.add(livre.getPrixOriginal());
        commande.setTotal(sum);
        commande.setDate(new Date(new java.util.Date().getTime()));
        return commandeRepository.save(commande);
    }

}

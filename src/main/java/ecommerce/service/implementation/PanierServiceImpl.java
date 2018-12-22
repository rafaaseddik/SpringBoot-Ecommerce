package ecommerce.service.implementation;

import ecommerce.domain.Livre;
import ecommerce.domain.Panier;
import ecommerce.repository.PanierRepository;
import ecommerce.service.PanierService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierServiceImpl implements PanierService {

    @Autowired
    PanierRepository panierRepository;

    @Override
    public Panier createPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    @Override
    public Panier updatePanier(Panier panier) {
        return panierRepository.save(panier);
    }

    @Override
    public void deletePanier(Panier panier) {
        panierRepository.delete(panier);
    }

    @Override
    public Panier getPanierById(Long id) {
        return panierRepository.getOne(id);
    }

    @Override
    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    @Override
    public Panier addLivreToPanier(Panier panier, Livre livre) {
        panier.addLivre(livre);
        return panierRepository.save(panier);

    }

    @Override
    public Panier addLivresToPanier(Panier panier, List<Livre> livres) {
        for(Livre livre:livres)
            panier.addLivre(livre);
        return panierRepository.save(panier);
    }

    @Override
    public Panier deleteLivreFromPanier(Panier panier, Livre livre) throws NotFoundException{
        try{
            panier.removeLivre(livre);
        }catch (NotFoundException e){
            throw e;
        }
        return panierRepository.save(panier);
    }
}

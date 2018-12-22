package ecommerce.service;

import ecommerce.domain.Livre;
import ecommerce.domain.Panier;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PanierService {
    Panier createPanier(Panier panier);
    Panier updatePanier(Panier panier);
    void deletePanier(Panier panier);
    Panier getPanierById(Long id);
    List<Panier> getAllPaniers();
    Panier addLivreToPanier(Panier panier, Livre livre);
    Panier addLivresToPanier(Panier panier, List<Livre> livres);
    Panier deleteLivreFromPanier(Panier panier, Livre livre) throws NotFoundException;

}

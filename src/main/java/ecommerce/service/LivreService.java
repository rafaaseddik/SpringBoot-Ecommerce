package ecommerce.service;

import ecommerce.domain.Livre;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface LivreService {

    Livre createLivre(Livre livre);
    Livre updateLivre(Livre livre);
    void deleteLivre(Livre livre);
    Livre getLivreById(Long id);
    Livre getLivreByLibelle(String libelle);
    List<Livre> getLivresByAuteur(String auteur);
    List<Livre> getAllLivres();
    List<Livre> getLivresByPriceRange(BigDecimal min, BigDecimal max);
}

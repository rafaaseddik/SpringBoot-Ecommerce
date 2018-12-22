package ecommerce.service.implementation;

import ecommerce.domain.Livre;
import ecommerce.repository.LivreRepository;
import ecommerce.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    @Autowired
    LivreRepository livreRepository;


    @Override
    public Livre createLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre updateLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public void deleteLivre(Livre livre) {
        livreRepository.delete(livre);
    }

    @Override
    public Livre getLivreById(Long id) {
        return livreRepository.getOne(id);
    }

    @Override
    public Livre getLivreByLibelle(String libelle) {
        return livreRepository.getLivreByLibelle(libelle);
    }

    @Override
    public List<Livre> getLivresByAuteur(String auteur) {
        return livreRepository.getLivresByAuteur(auteur);
    }

    @Override
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    @Override
    public List<Livre> getLivresByPriceRange(BigDecimal min, BigDecimal max) {
        return livreRepository.getLivresByPrixOriginalBetween(min,max);
    }
}

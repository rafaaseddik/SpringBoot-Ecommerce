package ecommerce.repository;

import ecommerce.domain.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface LivreRepository extends JpaRepository<Livre,Long> {
    public Livre getLivreByLibelle(String libelle);
    public List<Livre> getLivresByAuteur(String auteur);
    public List<Livre> getLivresByPrixOriginalBetween(BigDecimal min, BigDecimal max);
}

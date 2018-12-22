package ecommerce.repository;

import ecommerce.domain.Commande;
import ecommerce.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande> getCommandesByTotalBetween(BigDecimal min, BigDecimal max);
    List<Commande> getCommandesByPromotion(Promotion promotion);
    List<Commande> getCommandesByDate(Date date);
}

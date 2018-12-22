package ecommerce.repository;

import ecommerce.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    List<Promotion> getPromotionsByDateDebutAfterAndDateFinBefore(Date debut, Date fin);
}

package ecommerce.service;

import ecommerce.domain.Promotion;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface PromotionService {
    Promotion createPromotion(Promotion promotion);
    Promotion updatePromotion(Promotion promotion);
    void deletePromotion(Promotion promotion);
    Promotion getPromotionById(Long id);
    List<Promotion> getAllPromotions();
    List<Promotion> getPromotionsByDateInInterval(Date min, Date max);
}

package ecommerce.service.implementation;

import ecommerce.domain.Promotion;
import ecommerce.repository.PromotionRepository;
import ecommerce.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion updatePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotion(Promotion promotion) {
        promotionRepository.delete(promotion);
    }

    @Override
    public Promotion getPromotionById(Long id) {
        return promotionRepository.getOne(id);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public List<Promotion> getPromotionsByDateInInterval(Date min, Date max) {
        return promotionRepository.getPromotionsByDateDebutAfterAndDateFinBefore(min,max);
    }
}

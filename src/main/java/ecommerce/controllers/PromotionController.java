package ecommerce.controllers;

import ecommerce.domain.Promotion;
import ecommerce.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("promotion/")
public class PromotionController {

    @Autowired
    PromotionService promotionService;

    @PostMapping("createPromotion")
    ResponseEntity createPromotion(@RequestBody Promotion promotion){
        try{
            return new ResponseEntity(promotionService.createPromotion(promotion),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("updatePromotion")
    ResponseEntity updatePromotion(@RequestBody Promotion promotion){
        try{
            Promotion currentPromotion = promotionService.getPromotionById(promotion.getId());
            if(currentPromotion==null)
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity(promotionService.updatePromotion(promotion),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("deletePromotion")
    ResponseEntity deletePromotion(@RequestBody Promotion promotion){
        try{
            if(promotionService.getPromotionById(promotion.getId())==null)
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            else{
                promotionService.deletePromotion(promotion);
                return new ResponseEntity(HttpStatus.OK);
            }

        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getPromotionById")
    ResponseEntity getPromotionById(@RequestAttribute Long id){
        try{
            return new ResponseEntity(promotionService.getPromotionById(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getAllPromotions")
    ResponseEntity getAllPromotions(){
        try{
            return new ResponseEntity(promotionService.getAllPromotions(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getPromotionsByDateInInterval")
    ResponseEntity getPromotionsByDateInInterval(@RequestParam Date min,@RequestParam Date max){
        try{
            return new ResponseEntity(promotionService.getPromotionsByDateInInterval(min,max),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

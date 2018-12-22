package ecommerce.controllers;


import ecommerce.domain.Livre;
import ecommerce.domain.Panier;
import ecommerce.dto.PanierListLivresDTO;
import ecommerce.dto.PanierLivreDTO;
import ecommerce.service.PanierService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("panier/")
public class PanierController {

    @Autowired
    PanierService panierService;


    @PostMapping("createPanier")
    ResponseEntity createPanier(@RequestBody Panier panier){
        try{
            return new ResponseEntity(panierService.createPanier(panier),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("updatePanier")
    ResponseEntity updatePanier(@RequestBody Panier panier){
        try{
            if(panierService.getPanierById(panier.getId())==null)
                return new ResponseEntity("Panier introuvable",HttpStatus.NOT_FOUND);
            return new ResponseEntity(panierService.updatePanier(panier),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("deletePanier")
    ResponseEntity deletePanier(@RequestBody Panier panier){
        try{
            Panier currentPanier = panierService.getPanierById(panier.getId());
            if(currentPanier==null)
                return new ResponseEntity("Panier introuvable",HttpStatus.NOT_FOUND);
            panierService.deletePanier(currentPanier);
            return new ResponseEntity("Panier supprimé",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("deletePanierById")
    ResponseEntity deletePanierById(@RequestParam Long id){
        try{
            Panier currentPanier = panierService.getPanierById(id);
            if(currentPanier==null)
                return new ResponseEntity("Panier introuvable",HttpStatus.NOT_FOUND);
            panierService.deletePanier(currentPanier);
            return new ResponseEntity("Panier supprimé",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getPanierById")
    ResponseEntity getPanierById(Long id){
        try{
            return new ResponseEntity(panierService.getPanierById(id),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getAllPaniers")
    ResponseEntity getAllPaniers(){
        try{
            return new ResponseEntity(panierService.getAllPaniers(),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("addLivreToPanier")
    ResponseEntity addLivreToPanier(@RequestBody PanierLivreDTO panierLivreDTO){
        try{
            return new ResponseEntity(panierService.addLivreToPanier(panierLivreDTO.panier,panierLivreDTO.livre),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("addLivresToPanier")
    ResponseEntity addLivresToPanier(@RequestBody PanierListLivresDTO panierListLivresDTO){
        try{
            return new ResponseEntity(panierService.addLivresToPanier(panierListLivresDTO.panier,panierListLivresDTO.livres),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("deleteLivreFromPanier")
    ResponseEntity deleteLivreFromPanier(@RequestBody PanierLivreDTO panierLivreDTO) throws NotFoundException{
        try{
            return new ResponseEntity(panierService.deleteLivreFromPanier(panierLivreDTO.panier,panierLivreDTO.livre),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}

package ecommerce.controllers;

import ecommerce.domain.Client;
import ecommerce.domain.Commande;
import ecommerce.domain.Panier;
import ecommerce.dto.PanierClientDTO;
import ecommerce.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commande/")
public class CommandeController {
    @Autowired
    CommandeService commandeService;

    @PostMapping("createCommande")
    ResponseEntity createCommande(@RequestBody Commande commande){
        try{
            return new ResponseEntity(commandeService.createCommande(commande), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("updateCommande")
    ResponseEntity updateCommande(@RequestBody Commande commande){
        try{
            Commande currentCommand = commandeService.getCommandeById(commande.getId());
            return new ResponseEntity(commandeService.updateCommande(commande),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("deleteCommande")
    ResponseEntity deleteCommande(@RequestBody Commande commande){
        try{
            if(commandeService.getCommandeById(commande.getId())==null)
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            else{
                commandeService.deleteCommande(commande);
                return new ResponseEntity(HttpStatus.OK);
            }
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("deleteCommandeById")
    ResponseEntity deleteCommandeById(@RequestParam Long id){
        try{
            Commande currentCommand = commandeService.getCommandeById(id);
            if(currentCommand==null)
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            else{
                commandeService.deleteCommande(currentCommand);
                return new ResponseEntity(HttpStatus.OK);
            }
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getCommandeById")
    ResponseEntity getCommandeById(@RequestParam Long id){
        try{
            return new ResponseEntity(commandeService.getCommandeById(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getAllCommandes")
    ResponseEntity getAllCommandes(){
        try{
            return new ResponseEntity(commandeService.getAllCommandes(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("createCommandeFromPanier")
    ResponseEntity createCommandeFromPanier(@RequestBody PanierClientDTO panierClientDTO){
        try{
            return new ResponseEntity(commandeService.createCommandeFromPanier(panierClientDTO.panier, panierClientDTO.client),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}

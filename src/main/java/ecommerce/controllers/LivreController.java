package ecommerce.controllers;

import ecommerce.domain.Livre;
import ecommerce.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("livre/")
public class LivreController {

    @Autowired
    LivreService livreService;
    @PostMapping("createLivre")
    ResponseEntity createLivre(@RequestBody Livre livre){
        try{
            return new ResponseEntity(livreService.createLivre(livre),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("updateLivre")
    ResponseEntity updateLivre(@RequestBody Livre livre){
        try{
            if(livreService.getLivreById(livre.getId()) == null){
                return new ResponseEntity("Livre introuvable",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(livreService.updateLivre(livre),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("deleteLivre")
    ResponseEntity deleteLivre(@RequestBody Livre livre){
        try{
            if(livreService.getLivreById(livre.getId()) == null){
                return new ResponseEntity("Livre untrouvable",HttpStatus.NOT_FOUND);
            }
            livreService.deleteLivre(livre);
            return new ResponseEntity("Livre supprimé",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("deleteLivreById")
    ResponseEntity deleteLivre(@RequestParam Long id){
        try{
            Livre currentLivre = livreService.getLivreById(id);
            if(currentLivre == null){
                return new ResponseEntity("Livre untrouvable",HttpStatus.NOT_FOUND);
            }
            livreService.deleteLivre(currentLivre);
            return new ResponseEntity("Livre supprimé",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("getLivreById")
    ResponseEntity getLivreById(@RequestParam Long id){
        return null;
    }

    @GetMapping("getLivreByLibelle")
    ResponseEntity getLivreByLibelle(@RequestParam String libelle){
        try{
            return new ResponseEntity(livreService.getLivreByLibelle(libelle), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("getLivresByAuteur")
    ResponseEntity getLivresByAuteur(@RequestParam String auteur){
        try{
            return new ResponseEntity(livreService.getLivresByAuteur(auteur),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("getAllLivres")
    ResponseEntity getAllLivres(){
        try{
            return new ResponseEntity(livreService.getAllLivres(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("getLivresByPriceRange")
    ResponseEntity getLivresByPriceRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        try{
            return new ResponseEntity(livreService.getLivresByPriceRange(min, max),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}

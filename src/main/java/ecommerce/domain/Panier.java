package ecommerce.domain;

import javassist.NotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Livre> livres;

    public void addLivre(Livre livre){
        this.livres.add(livre);
    }

    public void removeLivre(Livre livre) throws NotFoundException{
        if(this.livres.contains(livre))
            this.livres.remove(livre);
        else
            throw new NotFoundException("Livre introuvable");
    }



}
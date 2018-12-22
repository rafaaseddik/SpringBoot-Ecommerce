package ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String auteur;
    private BigDecimal prixOriginal;

    @JsonIgnore
    @ManyToMany(mappedBy="livres")
    protected List<Commande> commandes = new ArrayList<Commande>();
    @JsonIgnore
    @ManyToMany(mappedBy="livres")
    protected List<Panier> paniers = new ArrayList<Panier>();

    public Livre(String libelle, String auteur, BigDecimal prixOriginal) {
        this.libelle = libelle;
        this.auteur = auteur;
        this.prixOriginal = prixOriginal;
    }
}
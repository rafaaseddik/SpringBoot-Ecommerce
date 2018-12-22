package ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer pourcentage;
    private Date dateDebut;
    private Date dateFin;

    @JsonIgnore
    @OneToMany(mappedBy = "promotion")
    protected List<Commande> commandes;

}
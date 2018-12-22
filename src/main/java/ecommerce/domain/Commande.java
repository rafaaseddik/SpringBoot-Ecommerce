package ecommerce.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private BigDecimal total;
    
    @ManyToMany
    protected List<Livre> livres = new ArrayList<Livre>();
    
    @ManyToOne
    protected Client client;

    @ManyToOne
    protected Promotion promotion;

    public Commande(Date date, BigDecimal total, Client client, Promotion promotion) {
        this.date = date;
        this.total = total;
        this.livres = livres;
        this.client = client;
        this.promotion = promotion;
    }
}
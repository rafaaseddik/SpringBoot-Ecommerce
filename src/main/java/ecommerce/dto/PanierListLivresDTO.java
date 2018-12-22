package ecommerce.dto;

import ecommerce.domain.Livre;
import ecommerce.domain.Panier;

import java.util.List;

public class PanierListLivresDTO {
    public Panier panier;
    public List<Livre> livres;
}

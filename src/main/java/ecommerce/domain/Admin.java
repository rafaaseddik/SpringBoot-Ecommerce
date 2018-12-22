package ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Inheritance
@Data
@NoArgsConstructor
public class Admin extends User {

    public Admin(String nom, String email, String mdp) {
        super(nom, email, mdp);
    }

}

package ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client extends User{
    @JsonIgnore
	@OneToMany(mappedBy = "client")
	protected List<Commande> commandes;

	public Client(String nom,String email, String mdp) {
		super(nom, email, mdp);
	}

	@Override
	public String toString() {
		return "CLIENT : " + super.toString();
	}
}
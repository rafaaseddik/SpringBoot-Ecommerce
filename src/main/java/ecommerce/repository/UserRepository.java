package ecommerce.repository;

import ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T,Long> {
    List<T> getUsersByNomContaining(String nom);
    T getUserByEmailEquals(String email);
}

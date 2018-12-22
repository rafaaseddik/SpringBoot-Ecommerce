package ecommerce.service;

import ecommerce.domain.Admin;
import ecommerce.domain.Client;
import ecommerce.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    boolean deleteUser(User user);
    boolean deleteUserById(Long id);
    List<User> getUsersByNom(String nom);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    List<Client> getAllClients();
    List<Admin> getAllAdmins();

}

package ecommerce.service.implementation;

import ecommerce.domain.Admin;
import ecommerce.domain.Client;
import ecommerce.domain.User;
import ecommerce.repository.UserRepository;
import ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository<Client> clientRepository;

    @Autowired
    UserRepository<Admin> adminRepository;

    @Autowired
    UserRepository<User> userRepository;

    @Override
    public User createUser(User user) {
        if (user.getClass() == Client.class)
            return clientRepository.save((Client) user);
        else if (user.getClass() == Admin.class)
            return adminRepository.save((Admin) user);
        else
            return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (user.getClass() == Client.class)
            return clientRepository.save((Client) user);
        else if (user.getClass() == Admin.class)
            return adminRepository.save((Admin) user);
        else
            return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            if (user.getClass() == Client.class)
                clientRepository.delete((Client) user);
            else if (user.getClass() == Admin.class)
                adminRepository.delete((Admin) user);
            else
                userRepository.delete(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public List<User> getUsersByNom(String nom) {
        return userRepository.getUsersByNomContaining(nom);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmailEquals(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

}

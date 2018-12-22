package ecommerce.controllers;

import ecommerce.domain.Admin;
import ecommerce.domain.Client;
import ecommerce.domain.User;
import ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("createUser")
    ResponseEntity<User> createUser(@RequestBody User user){
        User currentUser = userService.getUserByEmail(user.getEmail());
        if(currentUser==null)
            return new ResponseEntity<User>(userService.createUser(user),HttpStatus.OK);
        else
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
    }
    @PostMapping("createClient")
    ResponseEntity<User> createClient(@RequestBody Client user){
        User currentUser = userService.getUserByEmail(user.getEmail());
        if(currentUser==null)
            return new ResponseEntity<User>(userService.createUser((Client)user),HttpStatus.OK);
        else
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
    }
    @PostMapping("createAdmin")
    ResponseEntity<User> createAdmin(@RequestBody Admin user){
        User currentUser = userService.getUserByEmail(user.getEmail());
        if(currentUser==null)
            return new ResponseEntity<User>(userService.createUser((Admin)user),HttpStatus.OK);
        else
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
    }
    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("getUserById")
    public User getUserById(@RequestParam Long id){
        return (User)userService.getUserById(id);
    }

    @GetMapping("getUserByEmail")
    public User getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping("deleteUser")
    public ResponseEntity deleteUser(@RequestBody User user){
        try{
            userService.deleteUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("deleteUserById")
    public ResponseEntity deleteUserById(@RequestParam Long id){
        try{
            userService.deleteUserById(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("updateUser")
    ResponseEntity<User> updateUser(@RequestBody User user){
        try{
            User currentUser = userService.getUserById(user.getId());
            if(currentUser==null){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity(userService.updateUser(user),HttpStatus.OK);
            }
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getUsersByNom")
    List<User> getUsersByNom(@RequestParam String nom){
        return userService.getUsersByNom(nom);
    }
    @GetMapping("getAllClients")
    List<Client> getAllClients(){
        return userService.getAllClients();
    }
    @GetMapping("getAllAdmins")
    List<Admin> getAllAdmins(){
        return userService.getAllAdmins();
    }
}

package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Login;
import Eco3DPrint.BackendEco3DPrint.model.LoginMessage;
import Eco3DPrint.BackendEco3DPrint.model.User;
import Eco3DPrint.BackendEco3DPrint.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "new User added";
    }

    @CrossOrigin(origins = "https://localhost:5173")
    @GetMapping("/getUser")
    public Optional<User> getUserbyId(@RequestParam int id){return userService.getUserbyId(id);}

    @CrossOrigin(origins = "https://localhost:5173")
    @GetMapping("/getUserByEmail")
    public Optional<User> getUserByEmail(@RequestParam String email){return userService.getUserByEmail(email);}


    @DeleteMapping("/deleteUser")
    public String deleteUserbyId(@RequestParam int id){
        userService.deleteUserbyId(id);
        return "User deleted";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        Optional<User> optionalUser = userService.getUserbyId(user.getId());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getLastname() != null) {
                existingUser.setLastname(user.getLastname());
            }
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.getUsername() != null) {
                existingUser.setUsername(user.getUsername());
            }
            if (user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }
            userService.saveUser(existingUser);
            return "User updated";
        } else {
            return "No User found";
        }
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Login login) {
        // Validate credentials and get user information
        LoginMessage signingIn = userService.loginUser(login);
        Optional<User> user = userService.getUserByEmail(login.getEmail());

        if (signingIn.getStatus()) {
            signingIn.setUser(user.orElse(null));
        }

        return ResponseEntity.ok(signingIn);
    }
}

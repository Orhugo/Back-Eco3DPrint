package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.User;
import Eco3DPrint.BackendEco3DPrint.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "new User added";
    }
    @GetMapping("/getUser")
    public Optional<User> getUserbyId(@RequestParam int id){return userService.getUserbyId(id);}

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
}

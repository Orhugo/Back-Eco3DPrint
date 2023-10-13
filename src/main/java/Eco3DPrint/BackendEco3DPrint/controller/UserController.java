package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.User;
import Eco3DPrint.BackendEco3DPrint.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

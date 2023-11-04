package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Login;
import Eco3DPrint.BackendEco3DPrint.model.LoginMessage;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.service.userService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    public String add(@RequestBody Usuario user) {
        usuarioService.saveUser(user);
        return "new User added";
    }

    @CrossOrigin(origins = "https://localhost:5173")
    @GetMapping("/getUser")
    public Optional<Usuario> getUserbyId(@RequestParam int id){return usuarioService.getUserbyId(id);}

    @CrossOrigin(origins = "https://localhost:5173")
    @GetMapping("/getUserByEmail")
    public Optional<Usuario> getUserByEmail(@RequestParam String email){return usuarioService.getUserByEmail(email);}


    @DeleteMapping("/deleteUser")
    public String deleteUserbyId(@RequestParam int id){
        usuarioService.deleteUserbyId(id);
        return "User deleted";
    }

    @GetMapping("/getAll")
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Login login) {
        // Validate credentials and get user information
        LoginMessage signingIn = usuarioService.loginUser(login);
        Optional<Usuario> usuario = usuarioService.getUserByEmail(login.getEmail());

        if (signingIn.getStatus()) {
            signingIn.setUser(usuario.orElse(null));
        }

        return ResponseEntity.ok(signingIn);
    }
}

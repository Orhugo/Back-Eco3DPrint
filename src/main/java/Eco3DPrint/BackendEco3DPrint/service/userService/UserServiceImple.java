package Eco3DPrint.BackendEco3DPrint.service.userService;

import Eco3DPrint.BackendEco3DPrint.model.Login;
import Eco3DPrint.BackendEco3DPrint.model.LoginMessage;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImple implements UsuarioService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UsuarioRepository userRepository;
    @Override
    public Usuario saveUser(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<Usuario> getUserbyId(int id) {return userRepository.findById(id);}

    @Override
    public void deleteUserbyId(int id) {userRepository.deleteById(id);}

    @Override
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public LoginMessage loginUser(Login login){
        Optional<Usuario> userOptional = userRepository.findByEmail(login.getEmail());
        if(userOptional.isPresent()){
            Usuario usuario = userOptional.get();
            String rawPassword = login.getPassword();
            String databasePassword = usuario.getPassword();
            boolean isPasswordRight = rawPassword.equals(databasePassword);
            if(isPasswordRight){
                return new LoginMessage("Login Success", true, usuario);
            }
        }

        return new LoginMessage("Login Failed", false, null);
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email){return userRepository.findByEmail(email);}

}

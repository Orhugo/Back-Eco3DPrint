package Eco3DPrint.BackendEco3DPrint.service.userService;

import Eco3DPrint.BackendEco3DPrint.model.Login;
import Eco3DPrint.BackendEco3DPrint.model.LoginMessage;
import Eco3DPrint.BackendEco3DPrint.model.User;
import Eco3DPrint.BackendEco3DPrint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImple implements UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserbyId(int id) {return userRepository.findById(id);}

    @Override
    public void deleteUserbyId(int id) {userRepository.deleteById(id);}

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public LoginMessage loginUser(Login login){
        Optional<User> userOptional = userRepository.findByEmail(login.getEmail());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            String rawPassword = login.getPassword();
            String encodedPassword = user.getPassword();
            boolean isPasswordRight = passwordEncoder.matches(rawPassword, encodedPassword);
            if(isPasswordRight){
                return new LoginMessage("Login Success", true, user);
            }
        }

        return new LoginMessage("Login Failed", false, null);
    }

    @Override
    public Optional<User> getUserByEmail(String email){return userRepository.findByEmail(email);}

}

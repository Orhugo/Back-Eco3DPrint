package Eco3DPrint.BackendEco3DPrint.service.userService;

import Eco3DPrint.BackendEco3DPrint.model.Login;
import Eco3DPrint.BackendEco3DPrint.model.LoginMessage;
import Eco3DPrint.BackendEco3DPrint.model.User;
import Eco3DPrint.BackendEco3DPrint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImple implements UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
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
        User user1 = userRepository.findByEmail(login.getEmail());
        String password = login.getPassword();
        String passwordInDatabase = user1.getPassword();
        boolean isPasswordRight = password.equals(passwordInDatabase);
        if(isPasswordRight){
            Optional<User> user = userRepository.findOneByEmailAndPassword(login.getEmail(), passwordInDatabase);
            return new LoginMessage("Login Success", true);
        }
        return new LoginMessage("Login Failed", false);
    }

}

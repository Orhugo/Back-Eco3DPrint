package Eco3DPrint.BackendEco3DPrint.service;

import Eco3DPrint.BackendEco3DPrint.model.User;
import Eco3DPrint.BackendEco3DPrint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImple implements UserService{

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
}

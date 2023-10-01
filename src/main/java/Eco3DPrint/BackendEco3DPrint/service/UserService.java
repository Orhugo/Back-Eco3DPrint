package Eco3DPrint.BackendEco3DPrint.service;

import Eco3DPrint.BackendEco3DPrint.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
}

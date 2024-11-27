package lk.ijse.notetaker.Service;

import lk.ijse.notetaker.customobj.UserResponse;
import lk.ijse.notetaker.dto.impl.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String id);
    UserResponse getSelectedUser(String id);
    List<UserDTO> getAllUsers();
}

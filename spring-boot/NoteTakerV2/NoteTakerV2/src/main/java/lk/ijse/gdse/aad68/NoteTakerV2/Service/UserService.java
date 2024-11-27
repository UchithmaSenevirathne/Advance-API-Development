package lk.ijse.gdse.aad68.NoteTakerV2.Service;

import lk.ijse.gdse.aad68.NoteTakerV2.customobj.UserResponse;
import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void deleteUser(String id);
    UserResponse getSelectedUser(String id);
    List<UserDTO> getAllUsers();
    UserDetailsService userDetailsService();
}

package lk.ijse.notetaker.Service;

import jakarta.transaction.Transactional;
import lk.ijse.notetaker.customobj.UserErrorResponse;
import lk.ijse.notetaker.customobj.UserResponse;
import lk.ijse.notetaker.dao.UserDAO;
import lk.ijse.notetaker.dto.impl.UserDTO;
import lk.ijse.notetaker.entity.UserEntity;
import lk.ijse.notetaker.exception.DataPersistFailedException;
import lk.ijse.notetaker.exception.UserNotFoundException;
import lk.ijse.notetaker.util.AppUtil;
import lk.ijse.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());
        UserEntity savedUser = userDAO.save(mapping.convertToUserEntity(userDTO));

        if (savedUser == null && savedUser.getUserId() == null) {
            throw new DataPersistFailedException("User not saved");
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<UserEntity> tmpUserEntity = userDAO.findById(userDTO.getUserId());
       if(!tmpUserEntity.isPresent()){
           throw new UserNotFoundException("User Not Found");
       }else {
           tmpUserEntity.get().setFirstName(userDTO.getFirstName());
           tmpUserEntity.get().setLastName(userDTO.getLastName());
           tmpUserEntity.get().setEmail(userDTO.getEmail());
           tmpUserEntity.get().setPassword(userDTO.getPassword());
           tmpUserEntity.get().setProfilePicture(userDTO.getProfilePicture());
//           tmpUserEntity.get().setNotes(userDTO.getNotes());
       }
    }

    @Override
    public void deleteUser(String id) {
        Optional<UserEntity> tmpUserEntity = userDAO.findById(id);
        if(!tmpUserEntity.isPresent()){
            throw new UserNotFoundException("User Not Found");
        }else {
            userDAO.deleteById(id);
        }
    }

    @Override
    public UserResponse getSelectedUser(String id) {
        if(userDAO.existsById(id)){
            return mapping.convertToUserDTO(userDAO.getUserEntitiesByUserId(id));
        }else {
            return new UserErrorResponse(0, "User Not Found");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.convertToUserDTOList(userDAO.findAll());
    }
}

package lk.ijse.notetaker.controller;

import lk.ijse.notetaker.Service.UserService;
import lk.ijse.notetaker.customobj.UserResponse;
import lk.ijse.notetaker.dto.impl.UserDTO;
import lk.ijse.notetaker.exception.DataPersistFailedException;
import lk.ijse.notetaker.exception.UserNotFoundException;
import lk.ijse.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    //save user
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName")String lastName,
            @RequestPart("email")String email,
            @RequestPart("password")String password,
            @RequestPart("profilePicture") MultipartFile profilePicture
    ){
        try {
            //handle profile pic
            byte[] bytes = profilePicture.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(bytes);

            //build the user object
            var buidUserDto = new UserDTO();
            buidUserDto.setFirstName(firstName);
            buidUserDto.setLastName(lastName);
            buidUserDto.setEmail(email);
            buidUserDto.setPassword(password);
            buidUserDto.setProfilePicture(base64ProfilePic);

            //send to the service layer
            userService.saveUser(buidUserDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletUser(@PathVariable ("id") String userId){
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return userService.deleteUser(userId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getSelectedUser(@PathVariable ("id") String userId){
        return userService.getSelectedUser(userId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateUser
            (@PathVariable ("id") String id,
             @RequestPart("firstName") String updateFirstName,
             @RequestPart("lastName")String updateLastName,
             @RequestPart("email")String updateEmail,
             @RequestPart("password")String updatePassword,
             @RequestPart("profilePicture")MultipartFile updateProfilePicture){

        try {
            byte[] updateBytes = updateProfilePicture.getBytes();
            String updateBase64ProfilePic = AppUtil.toBase64ProfilePic(updateBytes);

            var updateBuidUserDto = new UserDTO();
            updateBuidUserDto.setUserId(id);
            updateBuidUserDto.setFirstName(updateFirstName);
            updateBuidUserDto.setLastName(updateLastName);
            updateBuidUserDto.setEmail(updateEmail);
            updateBuidUserDto.setPassword(updatePassword);
            updateBuidUserDto.setProfilePicture(updateBase64ProfilePic);

            userService.updateUser(updateBuidUserDto);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

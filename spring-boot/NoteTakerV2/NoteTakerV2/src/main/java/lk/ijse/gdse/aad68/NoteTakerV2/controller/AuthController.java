package lk.ijse.gdse.aad68.NoteTakerV2.controller;

import lk.ijse.gdse.aad68.NoteTakerV2.Service.AuthenticationService;
import lk.ijse.gdse.aad68.NoteTakerV2.Service.AuthenticationServiceIMPL;
import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.UserDTO;
import lk.ijse.gdse.aad68.NoteTakerV2.exception.DataPersistFailedException;
import lk.ijse.gdse.aad68.NoteTakerV2.jwtmodels.JWTResponse;
import lk.ijse.gdse.aad68.NoteTakerV2.jwtmodels.SignIn;
import lk.ijse.gdse.aad68.NoteTakerV2.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/signin")
    public ResponseEntity<JWTResponse> signIn(@RequestBody SignIn signIn){
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }

    @PostMapping(value = "/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<JWTResponse> signUp(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName")String lastName,
            @RequestPart("email")String email,
            @RequestPart("password")String password,
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @RequestPart ("role") String role
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
            buidUserDto.setPassword(passwordEncoder.encode(password));
            buidUserDto.setProfilePicture(base64ProfilePic);
            buidUserDto.setRole(role);

            //send to the service layer
            return ResponseEntity.ok(authenticationService.signUp(buidUserDto));
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("refresh")
    public ResponseEntity<JWTResponse> refreshToken (@RequestParam ("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}

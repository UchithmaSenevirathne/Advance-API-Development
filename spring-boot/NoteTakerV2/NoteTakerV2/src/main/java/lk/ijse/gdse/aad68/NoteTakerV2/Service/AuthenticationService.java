package lk.ijse.gdse.aad68.NoteTakerV2.Service;

import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.UserDTO;
import lk.ijse.gdse.aad68.NoteTakerV2.jwtmodels.JWTResponse;
import lk.ijse.gdse.aad68.NoteTakerV2.jwtmodels.SignIn;

public interface AuthenticationService {
    JWTResponse signIn(SignIn signIn);
    JWTResponse signUp(UserDTO signUp);
    JWTResponse refreshToken(String accessToken);
}

package lk.ijse.gdse.aad68.NoteTakerV2.Service;


import lk.ijse.gdse.aad68.NoteTakerV2.dao.UserDAO;
import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.UserDTO;
import lk.ijse.gdse.aad68.NoteTakerV2.jwtmodels.JWTResponse;
import lk.ijse.gdse.aad68.NoteTakerV2.jwtmodels.SignIn;
import lk.ijse.gdse.aad68.NoteTakerV2.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDAO userDao;
    private final JWTService jwtService;
    private final Mapping mapping;
    //utils
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var userByEmail = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(userByEmail);
        return JWTResponse.builder().token(generatedToken).build() ;
    }


    @Override
    public JWTResponse signUp(UserDTO signUpUser) {
        var savedUser = userDao.save(mapping.convertToUserEntity(signUpUser));
        var genToken = jwtService.generateToken(savedUser);
        return JWTResponse.builder().token(genToken).build();
    }

    @Override
    public JWTResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity =
                userDao.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.refreshToken(userEntity);
        return JWTResponse.builder().token(refreshToken).build();
    }
}


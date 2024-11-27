package lk.ijse.gdse.aad68.NoteTakerV2.dto.impl;

import lk.ijse.gdse.aad68.NoteTakerV2.customobj.UserResponse;
import lk.ijse.gdse.aad68.NoteTakerV2.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements SuperDTO, UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePicture;
    private String role;
    private List<NoteDTO> notes = new ArrayList<>();
}

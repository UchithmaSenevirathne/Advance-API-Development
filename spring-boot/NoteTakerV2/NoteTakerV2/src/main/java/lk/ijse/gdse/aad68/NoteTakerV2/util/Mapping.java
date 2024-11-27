package lk.ijse.gdse.aad68.NoteTakerV2.util;

import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.NoteDTO;
import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.UserDTO;
import lk.ijse.gdse.aad68.NoteTakerV2.entity.NoteEntity;
import lk.ijse.gdse.aad68.NoteTakerV2.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    //matters of NoteEntity and dto
    public NoteDTO convertToNoteDTO(NoteEntity noteEntity) {
        return modelMapper.map(noteEntity, NoteDTO.class);
    }

    public NoteEntity convertToNoteEntity(NoteDTO note) {
        return modelMapper.map(note, NoteEntity.class);
    }

    public List<NoteDTO> convertToNoteDTOList(List<NoteEntity> noteEntityList) {
        return modelMapper.map(noteEntityList, new TypeToken<List<NoteDTO>>() {}.getType());
    }

    //user matters mapping
    public UserDTO convertToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity convertToUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public List<UserDTO> convertToUserDTOList(List<UserEntity> userEntityList) {
        return modelMapper.map(userEntityList, new TypeToken<List<UserDTO>>() {}.getType());
    }

}

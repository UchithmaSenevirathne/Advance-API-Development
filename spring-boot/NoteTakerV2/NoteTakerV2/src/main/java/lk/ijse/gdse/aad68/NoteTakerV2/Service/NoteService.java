package lk.ijse.gdse.aad68.NoteTakerV2.Service;

import lk.ijse.gdse.aad68.NoteTakerV2.customobj.NoteResponse;
import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO note);
    void updateNote(String id, NoteDTO note);
    void deleteNote(String id);
    NoteResponse getSelectedNote(String id);
    List<NoteDTO> getAllNotes();
}

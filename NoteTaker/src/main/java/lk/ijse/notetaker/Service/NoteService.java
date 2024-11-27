package lk.ijse.notetaker.Service;

import lk.ijse.notetaker.customobj.NoteResponse;
import lk.ijse.notetaker.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO note);
    void updateNote(String id, NoteDTO note);
    void deleteNote(String id);
    NoteResponse getSelectedNote(String id);
    List<NoteDTO> getAllNotes();
}

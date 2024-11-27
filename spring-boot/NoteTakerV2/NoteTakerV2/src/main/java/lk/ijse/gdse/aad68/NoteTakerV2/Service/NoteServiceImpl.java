package lk.ijse.gdse.aad68.NoteTakerV2.Service;

import lk.ijse.gdse.aad68.NoteTakerV2.customobj.NoteResponse;
import lk.ijse.gdse.aad68.NoteTakerV2.dao.NoteDAO;
import lk.ijse.gdse.aad68.NoteTakerV2.dto.impl.NoteDTO;
import lk.ijse.gdse.aad68.NoteTakerV2.entity.NoteEntity;
import lk.ijse.gdse.aad68.NoteTakerV2.exception.DataPersistFailedException;
import lk.ijse.gdse.aad68.NoteTakerV2.exception.NoteNotFoundException;
import lk.ijse.gdse.aad68.NoteTakerV2.util.AppUtil;
import lk.ijse.gdse.aad68.NoteTakerV2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDAO noteDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.convertToNoteEntity(noteDTO);
        NoteEntity save = noteDAO.save(noteEntity);
        if (save == null) {
            throw new DataPersistFailedException("cannot save note");
        }
    }

    @Override
    public void updateNote(String id, NoteDTO note) {
        Optional<NoteEntity> tmpNoteEntity = noteDAO.findById(id);
        if (!tmpNoteEntity.isPresent()) {
            throw new NoteNotFoundException("Note not found");
        }else {
            tmpNoteEntity.get().setNoteDesc(note.getNoteDesc());
            tmpNoteEntity.get().setNoteTitle(note.getNoteTitle());
            tmpNoteEntity.get().setCreateDate(note.getCreateDate());
            tmpNoteEntity.get().setPriorityLevel(note.getPriorityLevel());
        }
    }

    @Override
    public void deleteNote(String id) {
        Optional<NoteEntity> findId = noteDAO.findById(id);
        if(!findId.isPresent()){
            throw new NoteNotFoundException("Note not found");
        }else {
            noteDAO.deleteById(id);
        }
    }

    @Override
    public NoteResponse getSelectedNote(String id) {
        if (noteDAO.existsById(id)) {
            return mapping.convertToNoteDTO(noteDAO.getReferenceById(id));
        }else{
            throw new NoteNotFoundException("Note not found");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return mapping.convertToNoteDTOList(noteDAO.findAll());
    }
}

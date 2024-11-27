package lk.ijse.gdse.aad68.NoteTakerV2.dao;

import lk.ijse.gdse.aad68.NoteTakerV2.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDAO extends JpaRepository<NoteEntity, String> {
}

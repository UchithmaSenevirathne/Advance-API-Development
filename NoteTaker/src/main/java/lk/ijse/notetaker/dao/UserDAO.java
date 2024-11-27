package lk.ijse.notetaker.dao;

import lk.ijse.notetaker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, String> {

    UserEntity getUserEntitiesByUserId(String userId);
}

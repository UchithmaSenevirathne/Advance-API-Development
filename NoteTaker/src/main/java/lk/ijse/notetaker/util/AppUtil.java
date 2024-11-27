package lk.ijse.notetaker.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.UUID;
public class AppUtil {

    public static String createNoteId(){
        return UUID.randomUUID().toString();
    }

    public static String createUserId(){
        return UUID.randomUUID().toString();
    }

    public static String toBase64ProfilePic(byte[] profilePic){
        return Base64.getEncoder().encodeToString(profilePic); //profile pic eke bytes tika aragena(profilepic eka string wunata eke byte type eka thamai ganne) eka Base64 bawata path karanawa
    }
}

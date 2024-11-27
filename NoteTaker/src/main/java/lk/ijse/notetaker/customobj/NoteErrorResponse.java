package lk.ijse.notetaker.customobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteErrorResponse implements Serializable, NoteResponse {
    private int errorCode;
    private String errorMessage;
}

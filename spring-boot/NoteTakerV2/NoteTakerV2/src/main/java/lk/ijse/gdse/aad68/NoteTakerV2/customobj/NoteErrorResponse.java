package lk.ijse.gdse.aad68.NoteTakerV2.customobj;

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

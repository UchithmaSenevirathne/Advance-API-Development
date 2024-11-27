package lk.ijse.gdse68.introspringweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    private List<String> [] id;
    private List<String> [] desc;
}

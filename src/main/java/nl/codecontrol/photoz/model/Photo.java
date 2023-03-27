package nl.codecontrol.photoz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Photo {

    private long id;
    private String filename;
}

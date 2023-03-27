package nl.codecontrol.photoz.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Photo {

    private Long id;

    @NotEmpty
    private String filename;
}

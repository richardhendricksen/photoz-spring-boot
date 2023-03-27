package nl.codecontrol.photoz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    private Long id;

    @NotEmpty
    private String filename;

    @NotEmpty
    @JsonIgnore
    private byte[] data;
}

package nl.codecontrol.photoz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {

    private Long id;

    @NotEmpty
    private String filename;

    @NotEmpty
    private String contentType;

    @NotEmpty
    @JsonIgnore
    private byte[] data;
}

package nl.codecontrol.photoz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("PHOTOZ")
public class Photo {

    @Id
    private Long id;

    @NotEmpty
    private String fileName;

    @NotEmpty
    private String contentType;

    @NotEmpty
    @JsonIgnore
    private byte[] data;
}

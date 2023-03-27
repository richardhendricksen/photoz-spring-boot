package nl.codecontrol.photoz.rest;

import nl.codecontrol.photoz.model.Photo;
import nl.codecontrol.photoz.service.PhotozService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;

@RestController
public class DownloadController {

    private final PhotozService photozService;

    public DownloadController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable long id) {

        final Photo photo = photozService.get(id);
        if (isNull(photo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        headers.setContentDisposition(ContentDisposition.attachment().filename(photo.getFileName()).build());

        return new ResponseEntity<>(photo.getData(), headers, HttpStatus.OK);
    }
}

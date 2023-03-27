package nl.codecontrol.photoz.rest;

import nl.codecontrol.photoz.model.Photo;
import nl.codecontrol.photoz.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    @Autowired
    private PhotozService photozService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable long id) {

        final Photo photo = photozService.get(id);
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(photo.getData(), headers, HttpStatus.OK);
    }
}

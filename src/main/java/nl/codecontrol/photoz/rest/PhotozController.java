package nl.codecontrol.photoz.rest;

import nl.codecontrol.photoz.model.Photo;
import nl.codecontrol.photoz.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

import static java.util.Objects.isNull;

@RestController
public class PhotozController {

    @Autowired
    private PhotozService photozService;

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable long id) {
        final Photo photo = photozService.get(id);
        if (isNull(photo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable long id) {
        final Photo photo = photozService.delete(id);
        if (isNull(photo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photozService.save(file.getOriginalFilename(), file.getBytes());
    }
}

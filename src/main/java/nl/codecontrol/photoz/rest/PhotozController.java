package nl.codecontrol.photoz.rest;

import jakarta.validation.Valid;
import nl.codecontrol.photoz.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

@RestController
public class PhotozController {

    private final Map<Long, Photo> db = new HashMap<>(){{
        put(1L, new Photo(1L, "hello.jpg"));
    }};

    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return db.values();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable long id) {
        final Photo photo = db.get(id);
        if (isNull(photo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable long id) {
        final Photo photo = db.remove(id);
        if (isNull(photo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photoz")
    public Photo create(@RequestBody @Valid Photo photo) {

        final var id = db.keySet().stream().max(Long::compare).get() + 1;
        photo.setId(id);
        db.put(photo.getId(), photo);
        return photo;
    }
}

package nl.codecontrol.photoz.rest;

import nl.codecontrol.photoz.model.Photo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotozController {

    private final List<Photo> db = List.of(new Photo(1, "hello.jpg"));

    @GetMapping("/photoz")
    public List<Photo> get() {
        return db;
    }
}

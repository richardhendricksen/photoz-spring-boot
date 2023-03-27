package nl.codecontrol.photoz.service;

import nl.codecontrol.photoz.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PhotozService {

    private final Map<Long, Photo> db = new HashMap<>(){{
        put(1L, new Photo(1L, "hello.jpg", "", null));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(long id) {
        return db.get(id);
    }

    public Photo delete(long id) {
        return db.remove(id);
    }

    public Photo save(String filename, String contentType, byte[] data) {
        final var id = db.keySet().stream().max(Long::compare).get() + 1;
        final var photo = Photo.builder()
                .id(id)
                .filename(filename)
                .contentType(contentType)
                .data(data)
                .build();

        db.put(photo.getId(), photo);
        return photo;
    }
}

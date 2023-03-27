package nl.codecontrol.photoz.service;

import nl.codecontrol.photoz.model.Photo;
import nl.codecontrol.photoz.repository.PhotozRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotozService {

    private final PhotozRepository photozRepository;

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(long id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String filename, String contentType, byte[] data) {
        final var photo = Photo.builder()
                .fileName(filename)
                .contentType(contentType)
                .data(data)
                .build();

        photozRepository.save(photo);
        return photo;
    }
}

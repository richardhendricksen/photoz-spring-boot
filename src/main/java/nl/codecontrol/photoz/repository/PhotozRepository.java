package nl.codecontrol.photoz.repository;

import nl.codecontrol.photoz.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Long> {

}

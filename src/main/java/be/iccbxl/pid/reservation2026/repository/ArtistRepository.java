package be.iccbxl.pid.reservation2026.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import be.iccbxl.pid.reservation2026.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist,Long> {
    List<Artist> findByLastname(String lastname);
    Artist findById(long id);
}

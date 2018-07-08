package ee.lapikud.springboot.members;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LapikRepository extends CrudRepository<Lapik, Integer> {

    List<Lapik> findAll();
}

package ee.lapikud.springboot.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LapikService {

    @Autowired
    private LapikRepository lapikRepository;

    public Lapik addMember(Lapik lapik) {
        //TODO: 1) add missing value to make saving possible
        //TODO: 2) add error handling for all @NotNull and @NotEmpty fields on Lapik
        return lapikRepository.save(lapik);
    }

    public List<Lapik> findAll() {
        return lapikRepository.findAll();
    }


    /*
     * RESTRICTED METHODS
     */

    private void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}

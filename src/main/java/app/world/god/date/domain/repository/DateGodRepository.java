package app.world.god.date.domain.repository;

import app.world.god.date.domain.model.DateGod;
import org.joda.time.LocalDate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DateGodRepository extends MongoRepository<DateGod, String> {
    public List<DateGod> findByDateIn(List<LocalDate> dateList);
}

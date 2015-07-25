package app.world.common.domain.repository;

import app.world.common.domain.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {
    public Tag findOneByName(String name);
}

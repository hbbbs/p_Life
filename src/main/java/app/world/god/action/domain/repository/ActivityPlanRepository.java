package app.world.god.action.domain.repository;

import app.world.god.action.domain.ActivityPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityPlanRepository extends MongoRepository<ActivityPlan, String> {
    public ActivityPlan findOneByName(String name);
}

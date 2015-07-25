package app.world.society.organization.company.domain.repository;

import app.world.society.organization.company.domain.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {

}

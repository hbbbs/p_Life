package app.init.data.company;

import app.world.society.organization.company.domain.Company;
import app.world.society.organization.company.domain.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitCompany {

    @Autowired
    private CompanyRepository repository;

    public void init() {
        deleteAll();
        save();
    }

    public void save(){
        List<Company> list = new ArrayList<Company>();

        Company company = new Company();
        company.setName("啦啦好");
        list.add(company);

        company = new Company();
        company.setName("神农城");
        list.add(company);

        repository.save(list);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}

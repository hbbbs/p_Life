package zen.frame.web.controller;

import app.user.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by HB on 14-3-15.
 */
public abstract class BaseController<T> {

    public MongoRepository<T, String> dao;

    @RequestMapping()
    public List<T> queryList() {
        return dao.findAll();
    }

    @RequestMapping("/{id}")
    public T query(@PathVariable("id") String id) {
        return dao.findOne(id);
    }

    @RequestMapping("/add")
    public T add(HttpServletRequest request, @RequestBody T T) {
        User loginUser = (User) (request.getSession().getAttribute("curUser"));
        if (loginUser != null && loginUser.isAdmin()) {
            return dao.save(T);
        } else {
            return null;
        }
    }

    @RequestMapping("/delete/{id}")
    public void delete(HttpServletRequest request, @PathVariable("id") String id) {
        User loginUser = (User) (request.getSession().getAttribute("curUser"));
        if (loginUser != null && loginUser.isAdmin()) {
            dao.delete(id);
        }
    }

}

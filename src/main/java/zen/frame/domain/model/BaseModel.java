package zen.frame.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;

/**
 * Created by HB on 14-3-23.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class BaseModel {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

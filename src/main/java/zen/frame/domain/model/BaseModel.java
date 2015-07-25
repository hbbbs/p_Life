package zen.frame.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import zen.frame.domain.model.dic.YesNo;

/**
 * Created by HB on 14-3-23.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class BaseModel {
    @Id
    private String id;
    private YesNo isDel = YesNo.否; 								// 是否被删除

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

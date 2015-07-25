package app.frame.manager.user.domain;

import zen.frame.domain.model.BaseModel;

/**
 * Created by HB on 2015/7/20.
 */
public class User extends BaseModel{
    private String name;						//姓名
    private String loginname;				//登录名
    private String password;					//密码
    private String description;				//用户描述


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!getClass().isAssignableFrom(obj.getClass()))
            return false;
        final User other = (User) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

}

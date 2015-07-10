package app.world.common.base.model.karma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by HB on 2015/7/1.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Karma {
    private String classStr;
    private Object karmaKey;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((classStr == null) ? 0 : classStr.hashCode());
        result = prime * result + ((karmaKey == null) ? 0 : karmaKey.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Karma other = (Karma) obj;
        if (!classStr.equals(other.getClassStr()))
            return false;
        if (classStr == null) {
            if (other.classStr != null)
                return false;
        } else if (!classStr.equals(other.classStr))
            return false;
        if (karmaKey == null) {
            if (other.karmaKey != null)
                return false;
        } else if (!karmaKey.equals(other.karmaKey))
            return false;
        return true;
    }


    public String getClassStr() {
        return classStr;
    }

    public void setClassStr(String classStr) {
        this.classStr = classStr;
    }

    public Object getKarmaKey() {
        return karmaKey;
    }

    public void setKarmaKey(Object karmaKey) {
        this.karmaKey = karmaKey;
    }

}

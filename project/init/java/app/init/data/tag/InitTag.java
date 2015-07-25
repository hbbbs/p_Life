package app.init.data.tag;

import app.world.common.dic.RequiredLevelType;
import app.world.common.domain.Tag;
import app.world.common.domain.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitTag {

    @Autowired
    private TagRepository repository;

    public void init() {
        deleteAll();
        save();
    }

    public void save(){
        List<Tag> list = new ArrayList<Tag>();

        Tag tag = new Tag();
        tag.setName("市内活动");
        tag.getBackPack().put("钥匙", RequiredLevelType.require);
        tag.getBackPack().put("钱", RequiredLevelType.require);
        tag.getBackPack().put("眼镜", RequiredLevelType.require);
        tag.getBackPack().put("手机", RequiredLevelType.require);
        list.add(tag);

        repository.save(list);
    }

    public void deleteAll(){
        repository.deleteAll();
    }
}

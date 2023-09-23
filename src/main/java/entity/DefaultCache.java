package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class DefaultCache extends Cache{

    HashMap<Object, Object> cacheMap;

    public DefaultCache(){
        super(0);
        cacheMap = new HashMap<>();
        cacheType = CacheType.DEFAULT;
    }
}

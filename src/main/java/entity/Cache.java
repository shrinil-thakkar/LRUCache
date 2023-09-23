package entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Cache {
    int cacheLimit;
    CacheType cacheType;

    public Cache(int limit){
        cacheLimit = limit;
    }
}

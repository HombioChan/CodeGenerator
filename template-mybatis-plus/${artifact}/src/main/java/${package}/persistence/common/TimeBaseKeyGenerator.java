package ${package}.persistence.common;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.datastax.driver.core.utils.UUIDs;

public class TimeBaseKeyGenerator implements IdentifierGenerator {
    @Override
    public String nextUUID(Object entity) {
        return UUIDs.timeBased().toString();
    }

    @Override
    public Number nextId(Object entity) {
        return null;
    }
}

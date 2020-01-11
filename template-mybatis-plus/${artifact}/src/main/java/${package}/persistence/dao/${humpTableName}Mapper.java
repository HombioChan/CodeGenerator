package ${package}.persistence.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${package}.persistence.po.${humpTableName}Po;

@Mapper
public interface ${humpTableName}Mapper extends BaseMapper<${humpTableName}Po> {
}

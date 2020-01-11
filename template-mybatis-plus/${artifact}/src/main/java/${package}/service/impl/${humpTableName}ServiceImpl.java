package ${package}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${package}.persistence.dao.${humpTableName}Mapper;
import ${package}.persistence.po.${humpTableName}Po;
import ${package}.service.${humpTableName}Service;

@Service
public class ${humpTableName}ServiceImpl extends ServiceImpl<${humpTableName}Mapper, ${humpTableName}Po> implements ${humpTableName}Service{
}

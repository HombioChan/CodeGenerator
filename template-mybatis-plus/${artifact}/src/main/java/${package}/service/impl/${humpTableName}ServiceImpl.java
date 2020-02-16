package ${package}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${package}.persistence.dao.${humpTableName}Mapper;
import ${package}.persistence.po.${humpTableName}Po;
import ${package}.service.${humpTableName}Service;
import ${package}.assembler.${humpTableName}Assembler;
import ${package}.dto.req.${humpTableName}ReqDto;
import java.util.Arrays;

@Service
public class ${humpTableName}ServiceImpl extends ServiceImpl<${humpTableName}Mapper, ${humpTableName}Po> implements ${humpTableName}Service{
    @Override
    public boolean doSave(${humpTableName}ReqDto reqDto) {
        return save(${humpTableName}Assembler.convertReqDtoToPo(reqDto));
    }

    @Override
    public boolean doUpdate(String id, ${humpTableName}ReqDto reqDto) {
        return updateById(${humpTableName}Assembler.convertReqDtoToPo(id,reqDto));
    }

    @Override
    public boolean doDelete(String[] ids) {
        return removeByIds(Arrays.asList(ids));
    }
}

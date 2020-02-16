package ${package}.service;


import com.baomidou.mybatisplus.extension.service.IService;
import ${package}.persistence.po.${humpTableName}Po;
import ${package}.dto.req.${humpTableName}ReqDto;
public interface ${humpTableName}Service extends IService<${humpTableName}Po> {
    boolean doSave(${humpTableName}ReqDto reqDto);
    boolean doUpdate(String id, ${humpTableName}ReqDto reqDto);
    boolean doDelete(String[] ids);
}

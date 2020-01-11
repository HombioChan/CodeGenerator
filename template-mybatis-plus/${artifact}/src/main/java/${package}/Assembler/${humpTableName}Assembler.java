package ${package}.Assembler;

import ${package}.dto.requset.${humpTableName}ReqDto;
import ${package}.dto.response.${humpTableName}ResDto;
import ${package}.persistence.po.${humpTableName}Po;

public class ${humpTableName}Assembler {

    public static ${humpTableName}Po convert${humpTableName}ReqDtoTo${humpTableName}Po( ${humpTableName}ReqDto req){
        return convert${humpTableName}ReqDtoTo${humpTableName}Po(null,req);
    }

    public static ${humpTableName}Po convert${humpTableName}ReqDtoTo${humpTableName}Po(<#list commonFields as field><#if field.name == "id">${field.type}</#if></#list> id, ${humpTableName}ReqDto req){
        ${humpTableName}Po po = new ${humpTableName}Po();
        po.setId(id);
        <#list fields as field>
        po.set${field.name?cap_first}(req.get${field.name?cap_first+"()"});
        </#list>
        return po;
    }

    public static ${humpTableName}ResDto convert${humpTableName}PoTo${humpTableName}ResDto(${humpTableName}Po po){
        if(po == null){
            return null;
        }
        ${humpTableName}ResDto res = new ${humpTableName}ResDto();
        res.setId(po.getId());
        <#list fields as field>
        res.set${field.name?cap_first}(po.get${field.name?cap_first+"()"});
        </#list>
        return res;
    }

}

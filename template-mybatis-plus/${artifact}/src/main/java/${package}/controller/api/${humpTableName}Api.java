package ${package}.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ${package}.dto.ResultDto;
import ${package}.dto.requset.${humpTableName}ReqDto;

import java.util.Map;

@Api("${humpTableName}Api")
public interface ${humpTableName}Api {

    @ApiOperation(value = "save ${humpTableName}",tags = {"${humpTableName}"})
    ResultDto save(${humpTableName}ReqDto reqDto);

    @ApiOperation(value = "delete ${humpTableName}",tags = {"${humpTableName}"})
    ResultDto delete(String[] ids);

//    @ApiOperation(value = "检索产品",tags = {"product"}, notes = "检索哈哈哈")
//    ResultDto query(Map<String,String> queryString);

    @ApiOperation(value = "update ${humpTableName}",tags = {"${humpTableName}"})
    ResultDto update(<#list commonFields as field><#if field.name == "id">${field.type}</#if></#list> id, ${humpTableName}ReqDto reqDto);

}

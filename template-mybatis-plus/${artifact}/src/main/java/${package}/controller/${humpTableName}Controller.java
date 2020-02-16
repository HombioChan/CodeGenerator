package ${package}.controller;

import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${package}.dto.ResultDto;
import ${package}.dto.req.${humpTableName}ReqDto;
import ${package}.service.${humpTableName}Service;
import ${package}.util.ResultUtil;



@ApiModel
@RestController
@RequestMapping("/${humpTableName?lower_case}")
public class ${humpTableName}Controller{

    @Autowired
    ${humpTableName}Service ${humpTableName?lower_case}Service;

    @PostMapping(value = "")
    public ResultDto save(@RequestBody ${humpTableName}ReqDto reqDto) {
        return ResultUtil.success(${humpTableName?lower_case}Service.doSave(reqDto));
    }

    @DeleteMapping(value = "")
    public ResultDto delete(@RequestBody String[] ids) {
        return ResultUtil.success(${humpTableName?lower_case}Service.doDelete(ids));
    }

    @PutMapping("/{id}")
    public ResultDto update(@PathVariable("id")<#list commonFields as field><#if field.name == "id">${field.type}</#if></#list> id, @RequestBody ${humpTableName}ReqDto reqDto) {
        return ResultUtil.success(${humpTableName?lower_case}Service.doUpdate(id, reqDto));
    }
}

package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ${package}.Assembler.${humpTableName}Assembler;
import ${package}.controller.api.${humpTableName}Api;
import ${package}.dto.ResultDto;
import ${package}.dto.requset.${humpTableName}ReqDto;
import ${package}.persistence.po.${humpTableName}Po;
import ${package}.service.${humpTableName}Service;
import ${package}.util.ResultUtil;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/${humpTableName?lower_case}")
public class ${humpTableName}Controller implements ${humpTableName}Api {

    @Autowired
    ${humpTableName}Service productService;

    @PostMapping(value = "")
    @Override
    public ResultDto save(@RequestBody ${humpTableName}ReqDto reqDto) {
        ${humpTableName}Po po = ${humpTableName}Assembler.convert${humpTableName}ReqDtoTo${humpTableName}Po(reqDto);
        productService.save(po);
        return ResultUtil.success(${humpTableName}Assembler.convert${humpTableName}PoTo${humpTableName}ResDto(po));
    }

    @DeleteMapping(value = "")
    @Override
    public ResultDto delete(@RequestBody String[] ids) {
        productService.removeByIds(Arrays.asList(ids));
        return ResultUtil.success();
    }

//    @GetMapping
//    @Override
//    public ResultDto query(@RequestParam Map<String,String> queryString) {
//        return ResultUtil.success();
//    }

    @PutMapping("/{id}")
    @Override
    public ResultDto update(@PathVariable("id")<#list commonFields as field><#if field.name == "id">${field.type}</#if></#list> id, @RequestBody ${humpTableName}ReqDto reqDto) {
        ${humpTableName}Po po = ${humpTableName}Assembler.convert${humpTableName}ReqDtoTo${humpTableName}Po(id,reqDto);
        productService.updateById(po);
        return ResultUtil.success(${humpTableName}Assembler.convert${humpTableName}PoTo${humpTableName}ResDto(productService.getById(id)));
    }
}

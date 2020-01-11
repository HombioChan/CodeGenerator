package ${package}.dto.requset;

<#list fields as field>
<#if field.type == "Date">
import java.util.Date;
</#if>
</#list>
import lombok.Data;

@Data
public class ${humpTableName}ReqDto {
    <#list fields as field>
    private ${field.type} ${field.name};
    </#list>
}

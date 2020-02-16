package ${package}.dto.res;
<#list fields as field>
<#if field.type == "Date">
import java.util.Date;
</#if>
</#list>
import lombok.Data;

@Data
public class ${humpTableName}ResDto {
    <#list commonFields as field>
    <#if field.name == "id">
    private ${field.type} ${field.name};
    </#if>
    </#list>

    <#list fields as field>
    private ${field.type} ${field.name};
    </#list>
}

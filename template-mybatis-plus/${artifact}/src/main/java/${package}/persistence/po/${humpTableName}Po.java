package ${package}.persistence.po;

<#list fields as field>
<#if field.type == "Date">
import java.util.Date;
</#if>
</#list>
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import ${package}.persistence.common.BasePo;

@Data
@TableName("${tableName}")
public class ${humpTableName}Po extends BasePo {
    <#list fields as field>
        private ${field.type} ${field.name};
    </#list>
}

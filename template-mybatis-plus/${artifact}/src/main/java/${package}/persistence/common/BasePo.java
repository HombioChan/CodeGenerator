package ${package}.persistence.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class BasePo {
    <#list commonFields as field>
    <#if field.name == "id">
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    <#elseif field.name == "deleted">
    @TableLogic
    </#if>
    private ${field.type} ${field.name};
    </#list>

}

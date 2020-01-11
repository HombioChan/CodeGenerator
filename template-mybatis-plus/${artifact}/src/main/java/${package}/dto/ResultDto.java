package ${package}.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDto<T> {
    private String code;
    private String msg;
    private T data;
}

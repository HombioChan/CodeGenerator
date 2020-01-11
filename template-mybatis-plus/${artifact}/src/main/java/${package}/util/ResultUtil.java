package ${package}.util;

import ${package}.dto.ResultDto;

public class ResultUtil {

    public static ResultDto success(){
        return success(null);
    }

    public static <T> ResultDto success(T data){
        return ResultDto.builder().code("000000").msg("success").data(data).build();
    }

    public static <T> ResultDto fail(String msg){
        return ResultDto.builder().code("111111").msg(msg).data(null).build();
    }

}

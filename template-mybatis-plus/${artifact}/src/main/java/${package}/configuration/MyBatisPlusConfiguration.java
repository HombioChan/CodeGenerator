package ${package}.configuration;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ${package}.persistence.common.TimeBaseKeyGenerator;

@Component
public class MyBatisPlusConfiguration {
    /*
    分页插件：进行分页查询时，自动更新total等字段
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /*
    若使用自带的请注释
     */
//    @Bean
//    public IdentifierGenerator idGenerator() {
//        return new TimeBaseKeyGenerator();
//    }
}

package cn.magikarpll.smsemailclient.common.result;

import cn.magikarpll.smsemailclient.common.GlobalDefaultProperties;
import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;

/**
 * {@link IgnoreReponseAdvice} 处理解析 {@link CommonResponseDataAdvice} 统一返回包装器
 *
 * @author purgeyao
 * @since 1.0
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    @Resource
    private GlobalDefaultProperties globalDefaultProperties;

    public CommonResponseDataAdvice(GlobalDefaultProperties globalDefaultProperties){
        this.globalDefaultProperties = globalDefaultProperties;
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return filter(methodParameter);
    }

    @Override
    @Nullable
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // o is null -> return response
        if (o == null) {
            return ResultBody.success();
        }
        // o is instanceof ConmmonResponse -> return o
        if (o instanceof ResultBody) {
            return (ResultBody) o;
        }
        // string 特殊处理
        if (o instanceof String) {
            return JSON.toJSON(ResultBody.success(o)).toString();
        }
        return ResultBody.success(o);
    }

    private Boolean filter(MethodParameter methodParameter) {
        Class<?> declaringClass = methodParameter.getDeclaringClass();
        // 检查过滤包路径
        long count = globalDefaultProperties.getAdviceFilterPackage().stream()
                .filter(l -> declaringClass.getName().contains(l)).count();
        if (count > 0) {
            return false;
        }
        // 检查<类>过滤列表
        if (globalDefaultProperties.getAdviceFilterClass().contains(declaringClass.getName())) {
            return false;
        }
        // 检查注解是否存在
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreReponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreReponseAdvice.class)) {
            return false;
        }
        return true;
    }

}

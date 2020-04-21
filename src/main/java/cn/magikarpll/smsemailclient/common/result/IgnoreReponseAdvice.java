package cn.magikarpll.smsemailclient.common.result;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统一返回包装标识注解
 *  可添加到类或者方法上，标志这个类下面的所有方法  或者 这个方法不会被拦截
 * @author purgeyao
 * @since 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreReponseAdvice {
}

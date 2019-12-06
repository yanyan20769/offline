package per.yan.offline;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yan.gao
 * @date 2019/12/5 7:23 下午
 */
@Import(OfflineAspect.class)
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableOffline {

    OfflinePolicy policy() default OfflinePolicy.END;
}

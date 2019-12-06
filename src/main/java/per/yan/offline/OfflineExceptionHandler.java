package per.yan.offline;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author yan.gao
 * @date 2019/12/6 10:19 上午
 */
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@RestControllerAdvice
public class OfflineExceptionHandler implements ApplicationContextAware {

    private ApplicationContext context;

    @ExceptionHandler(value = {OfflineException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ModelAndView handle(OfflineException ignore) {
        ModelAndView modelAndView = new ModelAndView();

        switch (parse2Policy()) {
            case CUSTOM:
                executeCustomStrategy(modelAndView);
                break;
            default:
                modelAndView.setViewName("/end");
        }
        return modelAndView;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private OfflinePolicy parse2Policy() {
        Map<String, Object> beanMap = context.getBeansWithAnnotation(EnableOffline.class);
        OfflinePolicy policy = null;
        if (!beanMap.isEmpty()) {
            policy = beanMap.values().stream().findFirst().map(v -> {
                EnableOffline enableOffline = v.getClass().getAnnotation(EnableOffline.class);
                return enableOffline.policy();
            }).get();
        }
        return policy;
    }

    private void executeCustomStrategy(ModelAndView view) {
        HandleStrategy handleStrategy = context.getBean(HandleStrategy.class);
        handleStrategy.handle(view);
    }
}

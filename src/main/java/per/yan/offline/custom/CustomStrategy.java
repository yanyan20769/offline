package per.yan.offline.custom;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import per.yan.offline.HandleStrategy;

/**
 * @author yan.gao
 * @date 2019/12/6 10:16 上午
 */
@Component
public class CustomStrategy implements HandleStrategy {

    @Override
    public void handle(ModelAndView modelAndView) {

        //可以用这种方式将页面所需值注入
//        modelAndView.addObject("key", "value");


        modelAndView.setViewName("/custom");
    }
}

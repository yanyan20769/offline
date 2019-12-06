package per.yan.offline;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author yan.gao
 * @date 2019/12/6 10:14 上午
 */
public interface HandleStrategy {

    void handle(ModelAndView view);
}

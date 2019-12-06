package per.yan.offline;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author yan.gao
 * @date 2019/12/5 7:22 下午
 */
@Aspect
public class OfflineAspect {

    @Before(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.PostMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.PutMapping)" +
            " || @annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object offline() {

        throw new OfflineException();
    }

}

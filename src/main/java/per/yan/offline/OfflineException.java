package per.yan.offline;

/**
 * @author yan.gao
 * @date 2019/12/5 9:40 下午
 */
public class OfflineException extends RuntimeException {

    private static final long serialVersionUID = -8502385996267165615L;

    private String message;

    public OfflineException() {
        super();
    }

    public OfflineException(String message) {
        super(message);
    }

    public OfflineException(Throwable throwable) {
        super(throwable);
    }

    public OfflineException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

package CustomException;

/**
 * @ClassName CommonRuntimeException
 * @Author lizhanxu
 * @Date 2019/9/12  11:56
 * @Version V1.0.0
 */
public class CommonRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -3719130907537246390L;

    public CommonRuntimeException() {
    }

    public CommonRuntimeException(String message) {
        super(message);
    }
}

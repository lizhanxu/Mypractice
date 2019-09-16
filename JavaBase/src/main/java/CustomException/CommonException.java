package CustomException;

/**
 * @ClassName CommonException
 * @Author lizhanxu
 * @Date 2019/9/12  10:34
 * @Version V1.0.0
 */
public class CommonException extends Exception{

    private static final long serialVersionUID = -5713364854913368466L;

    public CommonException() {
    }

    public CommonException(String message) {
        super(message);
    }
}

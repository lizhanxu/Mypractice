package Collection;

import javax.management.relation.Role;
import java.util.Comparator;

/**
 * @ClassName CollectionTest
 * @Author lizhanxu
 * @Date 2019/9/20  10:32
 * @Version V1.0.0
 */
public class CollectionTest {
    public static void main(String[] args) {
        Comparator<Role> a = (Role b, Role c) -> {
            return 0;
        };
        System.out.println(a.hashCode());
    }
}

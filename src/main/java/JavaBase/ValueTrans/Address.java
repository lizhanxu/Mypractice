package JavaBase.ValueTrans;

import java.util.Objects;

/**
 * @ClassName Address
 * @Author lizhanxu
 * @Date 2019/9/10  11:08
 * @Version V1.0.0
 */
public class Address implements Immutable {
    private final String detail;
    private final String postCode;
    private final int num;

    public Address() {
        detail = "";
        postCode = "";
        num = 0;
    }

    public Address(String detail, String postCode,int num) {
        this.detail = detail;
        this.postCode = postCode;
        this.num = num;
    }

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return postCode;
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return num == address.num &&
                Objects.equals(detail, address.detail) &&
                Objects.equals(postCode, address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detail, postCode, num);
    }

    @Override
    public String toString() {
        return "Address{" +
                "detail='" + detail + '\'' +
                ", postCode='" + postCode + '\'' +
                ", num=" + num +
                '}';
    }
}

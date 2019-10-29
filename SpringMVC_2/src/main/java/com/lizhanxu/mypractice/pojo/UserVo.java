package com.lizhanxu.mypractice.pojo;

/**
 * @ClassName UserVo
 * @Description
 * @Date 2019/10/29
 * @Created by lizhanxu
 */
public class UserVo {

    private User user;

    private PageParams pageParams;

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "user=" + user.toString() +
                ", pageParams=" + pageParams.toString() +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }
}

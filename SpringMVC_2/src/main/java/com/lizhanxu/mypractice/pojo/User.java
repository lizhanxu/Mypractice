package com.lizhanxu.mypractice.pojo;

/**
 * @ClassName User
 * @Description
 * @Date 2019/10/28
 * @Created by lizhanxu
 */
public class User {
    private String id = "123";
    private String name = "李展旭";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}


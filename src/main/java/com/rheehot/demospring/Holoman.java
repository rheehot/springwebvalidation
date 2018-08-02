package com.rheehot.demospring;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Holoman {

    @Min(0)
    private Integer age;

    @NotEmpty
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Holoman{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

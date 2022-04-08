package com.cs138185169.entity;

public class ProjectManager {
    // pmid*, name age, sex, salary, pid#
    private String name;
    private int age;
    private char sex;
    private String pmid;

    public ProjectManager(String name, int age, char sex, String pmid) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.pmid = pmid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPmid() {
        return this.pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", sex='" + getSex() + "'" +
            ", pmid='" + getPmid() + "'" +
            "}";
    }

}

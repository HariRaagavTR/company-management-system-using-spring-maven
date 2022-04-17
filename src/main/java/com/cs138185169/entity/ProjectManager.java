package com.cs138185169.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projectmanager")
public class ProjectManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pmid;
    private String name;
    private int age;
    private float salary;
    private char sex;
    private int pid;

    public ProjectManager() {
        super();
    }

    public int getPmid() {
        return this.pmid;
    }

    public void setPmid(int pmid) {
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

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "{" +
                " pmid='" + getPmid() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", salary='" + getSalary() + "'" +
                ", sex='" + getSex() + "'" +
                ", pid='" + getPid() + "'" +
                "}";
    }

}
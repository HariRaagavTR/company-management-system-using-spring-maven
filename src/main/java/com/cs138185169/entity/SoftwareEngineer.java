package com.cs138185169.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "softwareengineer")
public class SoftwareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seid;
    private String name;
    private int age;
    private float salary;
    private char sex;

    public SoftwareEngineer() {
        super();
    }

    public int getSeid() {
        return this.seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
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

    @Override
    public String toString() {
        return "{" +
                " seid='" + getSeid() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", salary='" + getSalary() + "'" +
                ", sex='" + getSex() + "'" +
                "}";
    }

}
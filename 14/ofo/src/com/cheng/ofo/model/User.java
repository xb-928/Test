package com.cheng.ofo.model;

public class User {
    //用户ID
    private  int id;
    //用户姓名
    private String name;
    //用户余额
    private float balance;
    //用户里程
    private float mileage;

    public User(int id, String name, float balance, float mileage) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.mileage = mileage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", mileage=" + mileage +
                '}';
    }
}

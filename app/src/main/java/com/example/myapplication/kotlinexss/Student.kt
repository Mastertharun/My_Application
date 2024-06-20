package com.example.myapplication.kotlinexss;


public class Student(abhay: String, i: Int, vit: String) {
    String name;
    int age;
    String postalAddress;

    public Student(String name, int age, String postalAddress)
    private var postalAddress: Any
    private var age: Nothing?
        get() {
            TODO()
        }
        set(value) {}
    val name: String
        get() = TODO("initialize me")

    {
        this.name = name;
        val age = null
        this.age = age;
        this.postalAddress = postalAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}
class Student(var name: String, var age: Int, var postalAddress: String)
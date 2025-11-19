package com.leetcode.io.amphora;

class Parent {
    static void display() {  // Static method in com.leetcode.io.amphora.Parent
        System.out.println("Static method in com.leetcode.io.amphora.Parent");
    }
}

class Child extends Parent {
    static void display() {  // This does NOT override, but hides com.leetcode.io.amphora.Parent's method
        System.out.println("Static method in com.leetcode.io.amphora.Child");
    }
}

class Main {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        Parent.display();  // Calls com.leetcode.io.amphora.Parent's display()

        Child obj2 = new Child();
        Child.display();  // Calls com.leetcode.io.amphora.Child's display()

        Parent obj3 = new Child();
        Parent.display();  // Calls com.leetcode.io.amphora.Parent's display() (Method Hiding)
    }
}
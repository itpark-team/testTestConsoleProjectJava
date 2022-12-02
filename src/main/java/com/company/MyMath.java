package com.company;

public class MyMath {
    private double a, b;

    public MyMath(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getSum() {
        return a + b;
    }

    public double getSub() {
        return a - b;
    }

    public double getMul() {
        return a * b;
    }

    public double getDiv() throws Exception {
        if (b == 0) {
            throw new Exception("error! division by zero");
        }
        return a / b;
    }
}

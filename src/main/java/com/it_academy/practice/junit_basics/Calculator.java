package com.it_academy.practice.junit_basics;

public class Calculator {

    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public float calculate(char operation) {
        switch(operation) {
            default: {
                return 0;
            }
            case '-': {
                return a - b;
            }
            case '+': {
                return a + b;
            }
            case '/': {
                return a / b;
            }
            case '*': {
                return a * b;
            }
            case 'e': {
                float result = 1;
                if (b>0) {
                    for (int i=1; i<(b+1); i++) {
                        result = result * a;
                    }
                }
                if (b==0) {
                    result = 1;
                }
                if (b<0){
                    for (int i=-1; i>(b-1); i--) {
                        result = result * a;
                    }
                    result = 1/result;
                }
                return result;
            }
            case 's': {
                float result = (float) Math.sqrt(a);
                return result;
            }
        }
    }


}

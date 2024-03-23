package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }) {

            @Override
            public void run() {
                System.out.println(1);
            }
        };

        Thread t = new Thread(t1);
        t.start();
    }


}
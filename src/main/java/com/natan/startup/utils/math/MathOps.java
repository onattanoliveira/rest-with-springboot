package com.natan.startup.utils.math;

import java.util.Arrays;
import java.util.Collections;


public class MathOps {
    public static Double sum(Double[] numbers) {
        double sum = 0.0;
        for(double number : numbers) sum += number;
        return sum;
    }

    public static Double sub(Double[] numbers) {
        Arrays.sort(numbers, Collections.reverseOrder());
        double sub = numbers[0];
        for(double i = 1; i < numbers.length; i++) sub -= numbers[(int) i];
        return sub;
    }

    public static Double div(Double[] numbers) {
        double div = numbers[0];
        for (double i = 1; i < numbers.length; i++) div /= numbers[(int) i];
        return div;
    }

    public static Double mtp(Double[] numbers) {
        double mtp = numbers[0];
        for (double i = 1; i < numbers.length; i++) mtp *= numbers[(int) i];
        return mtp;
    }

    public static Double avg(Double[] numbers) {
        double sum = 0.0;
        for(double number : numbers) sum += number;
        return sum / numbers.length;
    }
}

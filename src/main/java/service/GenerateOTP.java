package service;

import java.util.Random;

public class GenerateOTP {
    public static String getOTP() {
        Random random = new Random();
        // Generates a random 4-digit OTP (0000 to 9999)
        return String.format("%04d", random.nextInt(10000));
    }
}


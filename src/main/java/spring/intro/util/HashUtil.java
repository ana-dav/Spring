package spring.intro.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import spring.intro.exception.DataProcessingException;

public class HashUtil {
    private static final String CRYPTOGRAPHY = "SHA-512";

    public static byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static String hashPassword(String password, byte[] salt) {
        StringBuilder hashedPassword = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(CRYPTOGRAPHY);
            messageDigest.update(salt);
            byte[] digest = messageDigest.digest(password.getBytes());
            for (byte b: digest) {
                hashedPassword.append(String.format("%02x", b));
            }
        } catch (Exception e) {
            throw new DataProcessingException("can't hash pass", e);
        }
        return hashedPassword.toString();
    }
}

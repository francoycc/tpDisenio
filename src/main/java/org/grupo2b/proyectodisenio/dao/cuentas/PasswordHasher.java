package org.grupo2b.proyectodisenio.dao.cuentas;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordHasher {
    private static final MessageDigest digest;
    private static final String allowedSaltCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
    private static final int saltLength = 16;

    static {
        try {
            digest = MessageDigest.getInstance("SHA3-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hash(String pass, String salt){
        final byte[] hashbytes = digest.digest((salt+pass).getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashbytes);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String generateSalt(){
        Random r = new Random();
        StringBuilder s = new StringBuilder();
        for (int i=0;i<saltLength;i++){
            s.append(allowedSaltCharacters.charAt(Math.abs(r.nextInt())%allowedSaltCharacters.length()));
        }
        return s.toString();
    }
}
package gg.renz;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CryptUtil {

    private final String cryptoKey;
    private static final String ALGORITHM = "AES";

    public CryptUtil(String cryptoKey){
        this.cryptoKey = cryptoKey;
    }

    public String encrypt(String data) {
        try{
            SecretKeySpec key = new SecretKeySpec(cryptoKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getUrlEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error encriptando" + e.getMessage());
        }
    }

    public String decrypt(String encryptedData) {
        try{
            SecretKeySpec key = new SecretKeySpec(cryptoKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(Base64.getUrlDecoder().decode(encryptedData));
            return new String(decrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error desencriptando" + e.getMessage());
        }
    }
}

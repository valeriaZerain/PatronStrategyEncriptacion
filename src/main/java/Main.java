import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        EncryptionStrategy caesarStrategy = new CaesarStrategy();
        StrategyContext context = new StrategyContext(caesarStrategy);

        String textCesar = "Aplicando el patron strategy con estrategias de encriptacion con Cesar";
        byte[] encryptedCesar = context.encryptText(textCesar);
        String encryptedTextBase64 = Base64.getEncoder().encodeToString(encryptedCesar);
        String decryptedCesar = context.decryptText(encryptedCesar);
        System.out.println(encryptedTextBase64);
        System.out.println(decryptedCesar);

        System.out.println("************************************************************");
        EncryptionStrategy aesStrategy = new AESStrategy();
        context.setStrategy(aesStrategy);

        String textAES = "Aplicando el patron strategy con estrategias de encriptacion con AES";
        byte[] encryptedAES = context.encryptText(textAES);
        encryptedTextBase64 = Base64.getEncoder().encodeToString(encryptedAES);
        String decryptedAES = context.decryptText(encryptedAES);
        System.out.println(encryptedTextBase64);
        System.out.println(decryptedAES);
    }
}
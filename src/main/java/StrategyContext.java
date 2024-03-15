import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class StrategyContext {
    EncryptionStrategy strategy;
    public StrategyContext(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }
    public byte[] encryptText(String text) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return strategy.encrypt(text);
    }
    public String decryptText(byte[] encripted) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return  strategy.decrypt(encripted);
    }

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }
}

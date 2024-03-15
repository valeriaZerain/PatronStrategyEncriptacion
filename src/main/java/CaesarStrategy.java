import java.util.Random;

public class CaesarStrategy implements EncryptionStrategy{
    int shift = 20;
    @Override
    public byte[] encrypt(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                chars[i] = (char) (((c - base + shift) % 26) + base);
            }
        }
        return new String(chars).getBytes();
    }

    @Override
    public String decrypt(byte[] encrypted) {
        String encryptedText = new String(encrypted);
        char[] chars = encryptedText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                chars[i] = (char) (((c - base - shift + 26) % 26) + base);
            }
        }
        return new String(chars);
    }

}

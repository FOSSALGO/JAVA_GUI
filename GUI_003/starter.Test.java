package fosalgo;

public class Test {

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";   

    public static void main(String[] args) {
        int n = 23;
        int size = ALPHABET.length();//26

        //encrypt
        String plaintext = "THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
        plaintext = plaintext.toUpperCase();        
        for (int i = 0; i < plaintext.length(); i++) {
            char cin = plaintext.charAt(i);
            int x = ALPHABET.indexOf(cin);
            int ex = (x + n) % size;   
            char cout = ALPHABET.charAt(ex); 
            System.out.print(cout);
        }
        System.out.println("");

        //decrypt
        String ciphertext = "QEBNRFZHYOLTKCLUGRJMPLSBOQEBIXWVALD";
        ciphertext = ciphertext.toUpperCase();        
        for (int i = 0; i < ciphertext.length(); i++) {
            char cin = ciphertext.charAt(i);
            int x = ALPHABET.indexOf(cin);
            int dx = (x - n) % size;   
            if (dx < 0){   
                dx = size + dx;   
            } 
            char cout = ALPHABET.charAt(dx); 
            System.out.print(cout);
        }
        
        System.out.println("");
       
    }
}

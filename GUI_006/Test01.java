import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test01 {

    public static void main(String[] args) {

        try {
            String sURL = "https://zetcode.com/javaswing/";
            Document document = Jsoup.connect(sURL).get();
            String judul = document.title();
            System.out.println(judul);

            String isiDocument = document.text();
            System.out.println(isiDocument);

        } catch (IOException ex) {
            Logger.getLogger(Test01.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

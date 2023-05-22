import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class sitting {
    public static void main(String[] args) throws Exception {
        String url = "https://library.donga.ac.kr/libaray-services/facilities/reading-room/";
        Document doc = Jsoup.connect(url).get();

        //Elements e1 = doc.select("tr");
        //Elements e2 = e1.select("td");
        doc.text();
        //System.out.println(e1);
    }
}
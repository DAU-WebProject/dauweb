import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class sitting {
    public static void main(String[] args) throws Exception {
        String url = "https://library.donga.ac.kr/libaray-services/facilities/reading-room/";
        Document doc = Jsoup.connect(url).get();

        Elements e1 = doc.select("thead");
        System.out.println(e1.text());
        
        Elements e2 = doc.getElementsByClass("align-center");
        for (Element e3 : e2) {
            System.out.println(e3);
        }
        /*
        tbody - tr - td - a 
        */
    }
}

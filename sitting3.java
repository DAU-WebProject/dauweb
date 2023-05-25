import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.StringBuilder;
import java.lang.String;

public class sitting3 {
    public static void main(String[] args) {
        //드라이버 설치 후 경로 수정 필요
        System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://library.donga.ac.kr/libaray-services/facilities/reading-room/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String html = driver.getPageSource();
        Document doc = Jsoup.parse(html);
        //  동아대 도서관 열람실 이용 홈페이지 불러오기

        Elements e0 = doc.getElementsByAttributeValue("class", "con-title");
        System.out.println(e0.text()+'\n');
        // 대주제

        Elements e1 = doc.getElementsByAttributeValue("class", "data-title line");
        System.out.println(e1.get(0).text()+'\n');
        // 소주제

        Elements e2 = doc.getElementsByAttributeValue("scope","col");
        System.out.println(e2.text());
        // 표의 첫 줄 내용

        Elements TableBody = doc.select("div>table>tbody");
        StringBuilder t_body = new StringBuilder();
        
        for (Element element : TableBody) {
            int count = 0;
            for (Element td : element.select("tr")) {
                t_body.append(td.text()+'\n');
                count++;
                if (count >= 7)
                    break;
            }
            if (count >= 7)
                break;
        }
        System.out.println(t_body);
        // 표의 나머지 내용, 승학까지만 출력

        Elements e3 = TableBody.select("[href]");
        StringBuilder link = new StringBuilder();
        int count = 0;
        for(Element element : e3) {
            link.append(element.attr("href") + '\n');
            count ++;
            if (count >= 7)
                break;
        }
        System.out.println(link);
        // 열람실별 좌석배정현황, 승학까지만 출력

        // 열람실 이용 안내 내용
        driver.quit();
    }
}
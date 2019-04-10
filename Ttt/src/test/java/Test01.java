import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

/**
 * @author niyueyeee
 * @create 2019-04-07 12:00
 */
public class Test01 {
    @Test
    public void testURL() throws Exception {
        Document parse = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);
        String title = parse.getElementsByTag("title").first().text();
        System.out.println(title);
    }
    @Test
    public void testDom() throws IOException {
        Document parse = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);
        System.out.println(parse.getElementById("qimo_badge"));
    }
}

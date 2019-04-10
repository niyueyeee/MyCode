package test001;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-04-07 10:41
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        final int[] i = {0};

        while (true) {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://www.itcast.cn");
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                try {
                    System.out.println(EntityUtils.toString(entity, "utf-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(i[0]++);
            }
        }
    }
}

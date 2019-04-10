package test001;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author niyueyeee
 * @create 2019-04-07 10:41
 */
public class Test02 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");
        uriBuilder.setParameter("keys", "java");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, "utf-8"));
        }
    }
}

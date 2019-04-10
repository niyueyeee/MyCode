package utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

public class DownLoadUtils {

    public static String encodeFileName(HttpServletRequest request, String fileName) {
        String name = "";

        String agent = request.getHeader("User-Agent");
        System.out.println(agent);
        try {
            if (agent.contains("Firefox")) {
//                BASE64Encoder base64Encoder = new BASE64Encoder();

                Base64.Encoder encoder = Base64.getEncoder();
                name = "=?UTF-8?B?" + new String(encoder.encode(fileName.getBytes("UTF-8"))) + "?=";
            } else {
                name = URLEncoder.encode(fileName, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       System.out.println(name);
        return name;
    }
}

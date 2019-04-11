package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author niyueyeee
 * @create 2019-04-10 14:52
 */
@Controller
@RequestMapping("upload")
public class uploadFileController {
    @RequestMapping("uploadFile")
    private String uploadFile(Model model, MultipartFile uploadFile) throws IOException {
        String filename = uploadFile.getOriginalFilename();
        File file = new File("D://upload/" + filename);
        uploadFile.transferTo(file);
        model.addAttribute("message", "ok");
        return "result";
    }

    @RequestMapping("uploadFile2")
    private String uploadFile2(Model model, MultipartFile uploadFile) throws IOException {
        String filename = uploadFile.getOriginalFilename();
        Client client = Client.create();
        String romoteUrl = "http://localhost:80/fileserver/upload/";
        WebResource resource = client.resource(romoteUrl + filename);
        String put = resource.put(String.class, uploadFile.getBytes());
        model.addAttribute("message", "ok" + put);
        return "result";
    }
}

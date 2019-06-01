package com.itheima.web.servlet;

import com.itheima.constant.Constant;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;
import com.itheima.web.view.Result;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niyueyeee
 * @create 2019-03-24 20:44
 */
@WebServlet(urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {
    private ProductService productService = BeanFactory.newInstance(ProductService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = getParameterMap(request);

        Product product = new Product();

        try {
            BeanUtils.populate(product, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        product.setPid(UUIDUtils.getUUID());
        product.setPdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        product.setPflag(Constant.WEI_XIA_JIA);

        productService.saveProduct(product);

        //给前端响应
        response.setContentType("text/html;charset=utf-8");

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS, "商品信息添加成功！");

        response.getWriter().write(JSONObject.fromObject(result).toString());

    }

    private Map<String, String[]> getParameterMap(HttpServletRequest request) {
        HashMap<String, String[]> map = new HashMap<>();
        try {
            DiskFileItemFactory itemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");
                    map.put(name, new String[]{value});
                } else {
                    String name = item.getName();
                    File uploadFile = getUPloadFile(name);

                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(uploadFile);
                    IOUtils.copy(in, out);
                    IOUtils.closeQuietly(out);
                    IOUtils.closeQuietly(in);

                    String path = uploadFile.getAbsolutePath();
                    int resources = path.indexOf("resources");
                    String substring = path.substring(resources);
                    map.put("pimage", new String[]{substring});
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private File getUPloadFile(String name) {
        int i = name.lastIndexOf(".");
        String substring = name.substring(i);

        name = substring = UUIDUtils.getUUID();

        String uploadDir = "C:\\Users\\wwy23\\Documents\\HBuilderProjects\\web\\resources\\products";
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        File dir = new File(uploadDir, today);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(dir, name);
        return file;
    }
}

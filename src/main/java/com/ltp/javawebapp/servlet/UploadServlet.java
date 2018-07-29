package com.ltp.javawebapp.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

public class UploadServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String count = config.getInitParameter("count1");
        System.out.println(count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        Part backgroundImg = request.getPart("background-img");
        InputStream inputStream = backgroundImg.getInputStream();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        String realPath = request.getServletContext().getRealPath("/upload");

        File file = new File(realPath, backgroundImg.getSubmittedFileName());

        if(!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buffer = new byte[2048];
        int len = 0;
        while((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, len);
        }

        bufferedOutputStream.close();
        bufferedInputStream.close();
    }
}

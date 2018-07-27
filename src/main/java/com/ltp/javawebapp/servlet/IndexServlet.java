package com.ltp.javawebapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Writer out = response.getWriter();
        out.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>欢迎页面</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Wecome to JavaWeb !</h1> "+
                        "当前时间为: " + (new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())) +
                "</body>\n" +
                "</html>");
    }
}

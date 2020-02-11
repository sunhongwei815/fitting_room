package com.wlw.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created 孙弘炜 Administrator on 2016/1/29 0029.
 */

public class CodeServlet extends HttpServlet {

    public CodeServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma","No-cache");

        int width=60;
        int height=20;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g=image.getGraphics();

        Random random=new Random();
        String s=String.valueOf(random.nextInt(9000)+1000);
        HttpSession session=request.getSession();
        session.setAttribute("checkcode",s);

        Color color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        String a=null;
        Font font=new Font(a,Font.ITALIC,18);
        g.setColor(color);
        g.setFont(font);
        g.drawString(s,10,height-5);
        g.dispose();

        ServletOutputStream output=response.getOutputStream();
        ImageIO.write(image,"JPEG",output);
        output.flush();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                     doPost(request,response);
     }
}

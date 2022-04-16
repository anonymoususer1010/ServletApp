package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import model.BucketList;
import service.BucketListDao;

public class ViewList extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        List<BucketList> bl=BucketListDao.viewList();
        System.out.println(bl);
        pw.write("<h1>Bucket List</h1>");
        pw.write("<table>");
        for(BucketList b:bl){
            pw.write("<tr><td>"+b.getListId()+"</td>");
            pw.write("<tr><td>"+b.getListType()+"</td>");
            pw.write("<tr><td>"+b.getDescription()+"</td>");
            pw.write("<tr><td>"+b.getPriority()+"</td>");
        }
        pw.write("</table>");
    }
}

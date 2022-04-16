package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BucketList;
import service.BucketListDao;

public class EditList extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int listId=Integer.parseInt(request.getParameter("id"));
        String listType=request.getParameter("type");
        String description=request.getParameter("desc");
        int priority=Integer.parseInt(request.getParameter("prio"));
        BucketList bl=new BucketList();
        bl.setListId(listId);
        bl.setListType(listType);
        bl.setDescription(description);
        bl.setPriority(priority);
        BucketListDao.addList(bl);
        PrintWriter pw=response.getWriter();
        pw.write("<script>alert('Done')</script>");
    }
}

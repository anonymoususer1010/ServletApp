package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import model.BucketList;
import utility.ConnectionManager;

public class BucketListDao {
    public static void addList(BucketList bl){
        Connection con=null;
        PreparedStatement ps=null;
        try{
            con=ConnectionManager.getConnection();
            ps=con.prepareStatement("insert into BucketList values(?,?,?,?)");
            ps.setInt(1, bl.getListId());
            ps.setString(2, bl.getListType());
            ps.setString(3, bl.getDescription());
            ps.setInt(4, bl.getPriority());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            ConnectionManager.closeAll(null, ps, con);
        }
    }
    public static void editList(BucketList bl){
        Connection con=null;
        PreparedStatement ps=null;
        try{
            con=ConnectionManager.getConnection();
            String sql="update BucketList set listType=? , description=?, priority=? where listId=?";
            ps=con.prepareStatement(sql);            
            ps.setString(1, bl.getListType());
            ps.setString(2, bl.getDescription());
            ps.setInt(3, bl.getPriority());
            ps.setInt(4, bl.getListId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            ConnectionManager.closeAll(null, ps, con);
        }
    }
    public static void deleteList(BucketList bl) {
        Connection con=null;
        PreparedStatement ps=null;
        try{
            con=ConnectionManager.getConnection();
            ps=con.prepareStatement("delete * from BucketList where listId=?");
            ps.setInt(1, bl.getListId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            ConnectionManager.closeAll(null, ps, con);
        }
    }
    public static List<BucketList> viewList(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BucketList> bl=new ArrayList<>();
        try{
            con=ConnectionManager.getConnection();       
            String sql="select * from BucketList";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                BucketList b=new BucketList();
                b.setListId(rs.getInt(1));
                b.setListType(rs.getString(2));
                b.setDescription(rs.getString(3));
                b.setPriority(rs.getInt(4));
                bl.add(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            ConnectionManager.closeAll(rs, ps, con);
        }
        return bl;
    }
    public static List<BucketList> viewListByType(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BucketList> bl=new ArrayList<>();
        try{
            con=ConnectionManager.getConnection();       
            String sql="select * from BucketList order by listType, priority DESC";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                BucketList b=new BucketList();
                b.setListId(rs.getInt(1));
                b.setListType(rs.getString(2));
                b.setDescription(rs.getString(3));
                b.setPriority(rs.getInt(4));
                bl.add(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            ConnectionManager.closeAll(rs, ps, con);
        }
        return bl;
    }
}

package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 
import model.BucketList;
import service.BucketListDao;
 
class BucketListDaoTest {
     
    private static BucketListDao dao;
     
    @BeforeAll
    static void init() {
        Connection conn = ConnectionManager.getConnection();
        try {
            // set auto commit false so any operation in this test will be discarded.
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao = new BucketListDao(conn);
    }
     
    @AfterAll
    static void teardown() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    @Test
    void addListTest() {
        BucketList list = new BucketList();
        list.setlistType("travle");
        list.setDescription("wanna visit paris");
        list.setPriority(1);
        dao.addList(list);
        BucketList listFromDb = dao.viewListByType("travel");
        assertEquals(1, listFromDb.getPriority(), "Priority must be equal");
    }
     
    @Test
    void deleteListTest() {
        dao.deleteList("travel");
        BucketList listFromDb = dao.viewListByType("travel");
        assertNull(listFromDb.getListType(), "List type should be null");
    }
     
    @Test
    void updateListTest() {
        BucketList list = new BucketList();
        list.setlistType("travle");
        list.setDescription("wanna visit paris");
        list.setPriority(1);
        dao.addUser(user);
        list.setPriority(2);
        dao.updateList(list);
        BucketList listFromDb = dao.viewListByType("travel");
        assertEquals(2, listFromDb.getPriority(), "Priority must be equal");
    }
 
}
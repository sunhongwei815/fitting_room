package com.wlw.dao;
   import com.wlw.domain.Source;

   import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by 牟国宏 on 2016/1/23 0023.
 */
public class SourceDao extends BaseDao {
    /*
    * 添加数据
    *
    */
    public void add(Source source) throws SQLException {
        java.sql.Connection connection = getCurrentConnection();
        PreparedStatement ps = connection.prepareStatement("insert into source (source_id,source_name) values(?,?)");
        ps.setInt(1, source.getSource_id());
        ps.setString(2, source.getSource_name());
        ps.executeUpdate();
        closePreparedStatement(ps);
        closeConnection(connection);
    }

    /*
    * 查找全部
    *
    */
    public List<Source> queryAllTests() throws SQLException {
        List<Source> sources = new ArrayList<Source>();
        java.sql.Connection connection = getCurrentConnection();
        PreparedStatement ps = connection.prepareStatement("select *from source");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Source source = new Source();
            source.setSource_id(rs.getInt("source_id"));
            source.setSource_name(rs.getString("source_name"));
            sources.add(source);
        }
        closeAll(connection, ps, rs);
        return sources;
    }

    /*
    * 通过Id查找
    *
    */
    public List<Source> queryById(int source_id) throws SQLException {
        List<Source> sources = new ArrayList<Source>();
        java.sql.Connection connection = getCurrentConnection();
        PreparedStatement ps = connection.prepareStatement("select *from source where source_id = "+source_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Source source = new Source();
            source.setSource_id(rs.getInt("source_id"));
            source.setSource_name(rs.getString("source_name"));
        }
        closeAll(connection, ps, rs);
        return sources;
    }

    /*
    * 删除
    *
    * */
    public void delete(Integer id) throws SQLException {
        java.sql.Connection connection = getCurrentConnection();

        PreparedStatement ps = connection.prepareStatement("delete from source where source_id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        closePreparedStatement(ps);
        closeConnection(connection);

    }
}


package com.wang;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxl on 2015/10/1.
 */

public class BaseDao1 {
    private JdbcTemplate jdbcTemplate;

    /**
     *  首先使用PreparedStatementCreator创建一个预编译语句，其次由JdbcTemplate通过PreparedStatementCallback回调传回，
     *  由用户决定如何执行该PreparedStatement。此处我们使用的是execute方法。
     * @return
     */
    public long getSysUserCount(){
        long count = jdbcTemplate.execute(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                return connection.prepareStatement("select count(*) from tb_user");
            }
        }, new PreparedStatementCallback<Long>() {
            public Long doInPreparedStatement(PreparedStatement preparedStatement)
                    throws SQLException, DataAccessException {
                preparedStatement.execute();
                ResultSet rs = preparedStatement.getResultSet();
                rs.next();
                return rs.getLong(1);
            }
        });
        return count;
    }

    /**
     *  通过JdbcTemplate的 update(String sql,PreparedStatementSetter pass)执行预编译SQL,这个SQL有一个占位符，
     *  需要在执行前进行赋值，PreparedStatementSetter实现就是为了赋值，使用setValues(PreparedStatement st)回调方法设置相应的
     *  占位符的值。JdbcTemplate也提供了一种更简单的方法update(String sql,Object... args)来实现设值，所以，只要当使用该方法不满足
     *  需求时，才使用PreparedStatementSetter;
     * @param name
     */
    public void addSysUser(final String name){
        String insertSql = "insert into tb_user(real_name) values (?)";
        jdbcTemplate.update(insertSql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setObject(1, name);
            }
        });
    }

    public void deleteById(Long id){
        String deleteSql = "delete from tb_user where id =? ";
        jdbcTemplate.update(deleteSql,new Object[]{id});
    }


    /**
     * RowMapper接口提供mapRow(ResultSet rs, int rowNum)方法将结果集的每一行转换为一个Map，
     * 当然可以转换为其他类，如表的对象画形式。
     * @return
     */



    public void executeFunction(){
        final String callFunctionSql = "{call fun_test(?)}";
        List<SqlParameter> params = new ArrayList<SqlParameter>();
        params.add(new SqlParameter(Types.VARCHAR));
        params.add(new SqlReturnResultSet("result", new ResultSetExtractor<Long>() {
            public Long extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                while(resultSet.next()) {
                    return resultSet.getLong(1);
                }
                return 0L;
            }
        }));
        jdbcTemplate.call(new CallableStatementCreator() {
            public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                CallableStatement statement = connection.prepareCall(callFunctionSql);

                return null;
            }
        },params);
    }

}

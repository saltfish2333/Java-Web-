package com.zzf.dao.impl;

import com.zzf.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zzf
 * @create 2021-08-18 16:29
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();
    /*
    * 更
    *
    * */
    public int update(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnetion();
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /*
    * 查询返回一条记录
    * */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnetion();
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /*
    * 查询返回多条记录
    *
    * */
    public <T> List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnetion();
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /*
    * 查询特殊值
    *
    * */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnetion();
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

package com.lagou.sqlSession;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;

import java.sql.SQLException;
import java.util.List;

public interface Executor {

    public <E> List<E> query(Configuration configuration,MappedStatement mappedStatement,Object... params) throws Exception;

    Long  update(Configuration configuration,MappedStatement mappedStatement,Object...args) throws SQLException, ClassNotFoundException, NoSuchFieldException, Exception;

    Long delete(Configuration configuration,MappedStatement mappedStatement,Object...args) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException;
}

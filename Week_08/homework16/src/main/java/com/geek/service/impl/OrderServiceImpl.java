package com.geek.service.impl;

import com.geek.service.OrderService;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import io.shardingsphere.transaction.api.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class OrderServiceImpl implements OrderService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderServiceImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 第一条SQL数据正常，可正常插入ds1库的t_order表，
     * 第二条SQL数据异常，插入ds0库的t_order表，
     * 最终结果是两个库的数据插入都失败
     */
    @Override
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void inserData() {
        jdbcTemplate.execute("INSERT INTO demo_ds.t_order (user_id, status) VALUES (?, ?)", (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            preparedStatement.setObject(1, 1);
            preparedStatement.setObject(2, "a");
            preparedStatement.executeUpdate();//成功

            preparedStatement.setObject(1, 2);
            preparedStatement.setObject(2, "bb");
            preparedStatement.executeUpdate();//失败
            //最终失败
            return null;
        });
    }

}

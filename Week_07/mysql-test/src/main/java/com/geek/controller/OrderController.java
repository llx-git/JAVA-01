package com.geek.controller;

import com.geek.entity.OrderEntity;
import com.geek.service.OrderService;
import com.geek.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: luolixi
 * @date: 2021-03-02
 */
@RestController
@RequestMapping("/test")
public class OrderController {
    private ExecutorService threadPool = Executors.newFixedThreadPool(5);

    @Autowired
    private OrderService orderService;

    @GetMapping
    public void list() {

        orderService.list();
    }

    @GetMapping("1")
    public void test() {
        long start = System.currentTimeMillis();
        System.out.println("-------------" + start);
        List<OrderEntity> result = new ArrayList<>();
        for (int i = 1; i < 1000001; i++) {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderId(String.valueOf(i));
            orderEntity.setGoodsId("1");
            orderEntity.setMoney(42.2);
            orderEntity.setUserId("aaa");
            orderEntity.setCreateTime(new Date());
            result.add(orderEntity);

        }
        orderService.saveBatch(result, 300);
        System.out.println("-------------" + (System.currentTimeMillis() - start));
    }

    @GetMapping("2")
    public void jdbcTest() {
        try {
            long start = System.currentTimeMillis();
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1.com:3306/mysql_test?rewriteBatchedStatements=true";
            Connection conn = DriverManager.getConnection(url, "root", "root");
            String sql = "insert into mysql_test.`t_order`(`order_id`, `user_id`, `goods_id`, `money`, `status`) values(?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            for (int i = 1; i < 1000001; i++) {
                pstm.setString(1, UUID.randomUUID().toString().replace("-", ""));
                pstm.setString(2, "1");
                pstm.setString(3, "AAA");
                pstm.setDouble(4, 242.33);
                pstm.setString(5, "1");
                pstm.addBatch();
            }
            pstm.executeBatch();
            pstm.clearBatch();
            pstm.close();
            conn.close();
            System.out.println("-------------" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("3")
    public void jdbcTest2() throws InterruptedException {
        System.out.println("------------");
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    insertData(countDownLatch);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            threadPool.execute(runnable);
        }
        countDownLatch.await();
        System.out.println("-------------" + (System.currentTimeMillis() - start));
    }

    private void insertData(CountDownLatch countDownLatch) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/mysql_test?rewriteBatchedStatements=true";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        String sql = "insert into mysql_test.`t_order`(`order_id`, `user_id`, `goods_id`, `money`, `status`) values(?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        for (int i = 0; i < 100000; i++) {
//            pstm.setString(1, String.valueOf(UUID.randomUUID().toString().replace("-", "")));
            pstm.setString(1, String.valueOf(SnowflakeIdWorker.getId()));
            pstm.setString(2, "1");
            pstm.setString(3, "AAA");
            pstm.setDouble(4, 242.33);
            pstm.setString(5, "1");
            pstm.addBatch();
            if (i % 10000 == 0) {
                pstm.executeBatch();
                pstm.clearBatch();
            }
        }
        pstm.executeBatch();
        pstm.clearBatch();
        pstm.close();
        conn.close();
        countDownLatch.countDown();
    }

    @GetMapping("4")
    public void loadData() {
        String filePath = "D:\\ssl\\data.txt";
        orderService.loadData(filePath);
    }
}

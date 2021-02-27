-- 用户表
CREATE TABLE `cruzr`.`t_user`(  
  `user_id` VARCHAR(32) NOT NULL COMMENT '用户ID',
  `user_name` VARCHAR(32) COMMENT '用户名称',
  `password` VARCHAR(32) COMMENT '密码',
  `nick_name` VARCHAR(20) COMMENT '昵称',
  `id_card` VARCHAR(32) COMMENT '身份证',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 订单表
CREATE TABLE `cruzr`.`t_order`(  
  `order_id` VARCHAR(32) NOT NULL COMMENT '订单ID',
  `user_id` VARCHAR(32) COMMENT '用户ID',
  `goods_id` VARCHAR(32) COMMENT '商品ID',
  `money` DOUBLE COMMENT '金额',
  `status` CHAR(1) COMMENT '状态',
  PRIMARY KEY (`order_id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 商品表
CREATE TABLE `cruzr`.`t_goods`(  
  `goods_id` VARCHAR(32) NOT NULL COMMENT '商品ID',
  `goods_code` VARCHAR(32) COMMENT '商品编码',
  `goods_name` VARCHAR(32) COMMENT '商品名称',
  `goods_price` DOUBLE COMMENT '商品价格',
  `goods_type` CHAR(1) COMMENT '商品类型',
  `goods_weight` DOUBLE COMMENT '商品重量',
  PRIMARY KEY (`goods_id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 商品类型表
CREATE TABLE `cruzr`.`t_goods_type`(  
  `goods_type_id` INT NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
  `goods_type_name` VARCHAR(32) COMMENT '商品类型名称',
  PRIMARY KEY (`goods_type_id`)
) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
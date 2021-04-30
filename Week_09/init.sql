USE `hmily`;

/*Table structure for table `account` */

CREATE TABLE `account` (
  `account_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `money_usd` double DEFAULT NULL,
  `money_cny` double DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `account` */

insert  into `account`(`account_id`,`user_id`,`money_usd`,`money_cny`) values (1,1,9,17);
insert  into `account`(`account_id`,`user_id`,`money_usd`,`money_cny`) values (2,2,11,3);

/*Table structure for table `freeze_account` */

CREATE TABLE `freeze_account` (
  `freeze_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `money_usd` double DEFAULT NULL,
  `money_cny` double DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`freeze_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
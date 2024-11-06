-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        9.0.1 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 klaatus.tbl_age_month_stat 구조 내보내기
DROP TABLE IF EXISTS `tbl_age_month_stat`;
CREATE TABLE IF NOT EXISTS `tbl_age_month_stat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age_group` varchar(2) NOT NULL,
  `year` varchar(4) NOT NULL,
  `month` varchar(2) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_age_quarter_stat 구조 내보내기
DROP TABLE IF EXISTS `tbl_age_quarter_stat`;
CREATE TABLE IF NOT EXISTS `tbl_age_quarter_stat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age_group` varchar(2) NOT NULL,
  `year` varchar(4) NOT NULL,
  `quarter` varchar(1) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_age_year_stat 구조 내보내기
DROP TABLE IF EXISTS `tbl_age_year_stat`;
CREATE TABLE IF NOT EXISTS `tbl_age_year_stat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age_group` varchar(2) NOT NULL,
  `year` varchar(4) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.



-- 테이블 klaatus.tbl_member 구조 내보내기
DROP TABLE IF EXISTS `tbl_member`;
CREATE TABLE IF NOT EXISTS `tbl_member` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_email` varchar(120) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(15) NOT NULL,
  `mobile_no` varchar(11) NOT NULL,
  `phone_no` varchar(11) DEFAULT NULL,
  `birthday` varchar(10) NOT NULL,
  `age_group` varchar(2) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `mileage` bigint NOT NULL,
  `address` varchar(150) DEFAULT NULL,
  `post_code` varchar(5) DEFAULT NULL,
  `member_state` varchar(2) NOT NULL DEFAULT '01',
  `is_blacklist` tinyint(1) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 테이블 klaatus.tbl_product 구조 내보내기
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE IF NOT EXISTS `tbl_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pno` varchar(12) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `product_detail` varchar(1000) DEFAULT NULL,
  `retail_price` decimal(10,2) NOT NULL,
  `sale_price` decimal(10,2) NOT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `category` varchar(4) NOT NULL,
  `sale_company` varchar(50) NOT NULL,
  `sale_company_info` varchar(1000) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `caution` varchar(1000) DEFAULT NULL,
  `manufacture` varchar(50) NOT NULL,
  `manufacture_date` date NOT NULL,
  `expiration_date` date NOT NULL,
  `material` varchar(50) NOT NULL,
  `nutrition` varchar(1000) DEFAULT NULL,
  `origin` varchar(20) NOT NULL,
  `package_quantity` int DEFAULT NULL,
  `volume` int DEFAULT NULL,
  `quantity` bigint NOT NULL,
  `wish_count` int NOT NULL DEFAULT '0',
  `is_visible` tinyint(1) NOT NULL DEFAULT '1',
  `is_soldout` tinyint(1) NOT NULL DEFAULT '0',
  `is_gmo` tinyint(1) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `tbl_product_chk_1` CHECK ((`is_visible` in (0,1))),
  CONSTRAINT `tbl_product_chk_2` CHECK ((`is_soldout` in (0,1))),
  CONSTRAINT `tbl_product_chk_3` CHECK ((`is_gmo` in (0,1))),
  CONSTRAINT `tbl_product_chk_4` CHECK ((`is_deleted` in (0,1)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- 테이블 klaatus.tbl_subscribe 구조 내보내기
DROP TABLE IF EXISTS `tbl_subscribe`;
CREATE TABLE IF NOT EXISTS `tbl_subscribe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `subscribe_price` decimal(10,2) NOT NULL,
  `subscribe_quantity` bigint NOT NULL,
  `subscribe_state_code` varchar(2) NOT NULL DEFAULT '01',
  `subscribe_suspend_date` date DEFAULT NULL,
  `subscribe_date` date NOT NULL,
  `payment_date` date NOT NULL,
  `shipping_date` date NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tbl_subscribe_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`),
  CONSTRAINT `tbl_subscribe_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 테이블 klaatus.tbl_cart 구조 내보내기
DROP TABLE IF EXISTS `tbl_cart`;
CREATE TABLE IF NOT EXISTS `tbl_cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `tbl_cart_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_cart_item 구조 내보내기
DROP TABLE IF EXISTS `tbl_cart_item`;
CREATE TABLE IF NOT EXISTS `tbl_cart_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_price` decimal(10,2) NOT NULL,
  `quantity` bigint NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `cart_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cart_id` (`cart_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tbl_cart_item_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `tbl_cart` (`id`),
  CONSTRAINT `tbl_cart_item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_common_code 구조 내보내기
DROP TABLE IF EXISTS `tbl_common_code`;
CREATE TABLE IF NOT EXISTS `tbl_common_code` (
  `common_code` varchar(20) NOT NULL,
  `common_code_name` varchar(50) NOT NULL,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `common_group_code` varchar(20) NOT NULL,
  PRIMARY KEY (`common_code`,`common_group_code`),
  KEY `common_group_code` (`common_group_code`),
  CONSTRAINT `tbl_common_code_ibfk_1` FOREIGN KEY (`common_group_code`) REFERENCES `tbl_common_group_code` (`common_group_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_common_group_code 구조 내보내기
DROP TABLE IF EXISTS `tbl_common_group_code`;
CREATE TABLE IF NOT EXISTS `tbl_common_group_code` (
  `common_group_code` varchar(20) NOT NULL,
  `common_group_code_name` varchar(50) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`common_group_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_delivery 구조 내보내기
DROP TABLE IF EXISTS `tbl_delivery`;
CREATE TABLE IF NOT EXISTS `tbl_delivery` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) NOT NULL,
  `delivery_addr` varchar(150) NOT NULL,
  `delivery_no` varchar(20) NOT NULL,
  `delivery_state` varchar(2) NOT NULL DEFAULT '01',
  `dly_post_no` varchar(5) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `subscribe_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subscribe_id` (`subscribe_id`),
  CONSTRAINT `tbl_delivery_ibfk_1` FOREIGN KEY (`subscribe_id`) REFERENCES `tbl_subscribe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_event 구조 내보내기
DROP TABLE IF EXISTS `tbl_event`;
CREATE TABLE IF NOT EXISTS `tbl_event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `contents` varchar(1000) NOT NULL,
  `event_state` varchar(2) NOT NULL DEFAULT '02',
  `file_name` varchar(255) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_exchange 구조 내보내기
DROP TABLE IF EXISTS `tbl_exchange`;
CREATE TABLE IF NOT EXISTS `tbl_exchange` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ex_addr` varchar(150) NOT NULL,
  `ex_company_name` varchar(50) NOT NULL,
  `ex_post_no` varchar(5) NOT NULL,
  `ex_reason` varchar(150) NOT NULL,
  `ex_shipping_no` varchar(20) NOT NULL,
  `exchange_state` varchar(2) NOT NULL DEFAULT '01',
  `file_name` varchar(255) NOT NULL,
  `reject_reason` varchar(150) DEFAULT NULL,
  `ret_company_name` varchar(50) NOT NULL,
  `ret_shipping_no` varchar(20) NOT NULL,
  `return_addr` varchar(150) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `subscribe_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subscribe_id` (`subscribe_id`),
  CONSTRAINT `tbl_exchange_ibfk_1` FOREIGN KEY (`subscribe_id`) REFERENCES `tbl_subscribe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_main_category 구조 내보내기
DROP TABLE IF EXISTS `tbl_main_category`;
CREATE TABLE IF NOT EXISTS `tbl_main_category` (
  `main_cate_code` varchar(20) NOT NULL,
  `main_cate_name` varchar(50) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`main_cate_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_member_card 구조 내보내기
DROP TABLE IF EXISTS `tbl_member_card`;
CREATE TABLE IF NOT EXISTS `tbl_member_card` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `card_name` varchar(150) NOT NULL,
  `card_no` varchar(16) NOT NULL,
  `card_user_name` varchar(150) NOT NULL,
  `valid_date` varchar(4) NOT NULL,
  `valid_state` varchar(2) NOT NULL DEFAULT '01',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `member_id` (`member_id`,`card_no`),
  CONSTRAINT `tbl_member_card_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_member_role 구조 내보내기
DROP TABLE IF EXISTS `tbl_member_role`;
CREATE TABLE IF NOT EXISTS `tbl_member_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` varchar(7) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `tbl_member_role_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`),
  CONSTRAINT `tbl_member_role_chk_1` CHECK ((`role` in (_utf8mb4'user',_utf8mb4'manager',_utf8mb4'admin')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

DROP TABLE IF EXISTS `tbl_member_shipping_address`;
create table tbl_member_shipping_address
(
    `id`    bigint NOT NULL AUTO_INCREMENT primary key,
    `address`            varchar(150)         not null,
    `post_code`          varchar(16)          not null,
    `is_activated`       tinyint(1) default 0 not null,
    `is_deleted`         tinyint(1) default 0 not null,
    `created_by`         varchar(120)         not null,
    `created_date`       timestamp            not null,
    `last_modified_by`   varchar(120)         not null,
    `last_modified_date` timestamp            not null,
    `member_id`          bigint                  not null,
    CONSTRAINT `tbl_member_shipping_address_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`)
);


-- 테이블 klaatus.tbl_notice 구조 내보내기
DROP TABLE IF EXISTS `tbl_notice`;
CREATE TABLE IF NOT EXISTS `tbl_notice` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contents` varchar(1000) NOT NULL,
  `title` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_order 구조 내보내기
DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE IF NOT EXISTS `tbl_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `total_order_price` decimal(10,2) DEFAULT NULL,
  `order_date` date NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `tbl_order_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_order_item 구조 내보내기
DROP TABLE IF EXISTS `tbl_order_item`;
CREATE TABLE IF NOT EXISTS `tbl_order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_quantity` bigint NOT NULL,
  `product_price` decimal(10,2) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `order_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tbl_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`id`),
  CONSTRAINT `tbl_order_item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_payment 구조 내보내기
DROP TABLE IF EXISTS `tbl_payment`;
CREATE TABLE IF NOT EXISTS `tbl_payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apply_num` varchar(1000) DEFAULT NULL,
  `bank_name` varchar(150) DEFAULT NULL,
  `buyer_addr` varchar(255) DEFAULT NULL,
  `buyer_email` varchar(255) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `buyer_postcode` varchar(7) DEFAULT NULL,
  `buyer_tel` varchar(13) DEFAULT NULL,
  `card_name` varchar(255) DEFAULT NULL,
  `card_number` varchar(19) DEFAULT NULL,
  `card_quota` varchar(2) DEFAULT '00',
  `custom_data` varchar(1000) DEFAULT NULL,
  `currency` varchar(10) DEFAULT NULL,
  `customer_uid` varchar(50) DEFAULT NULL,
  `imp_uid` varchar(20) DEFAULT NULL,
  `merchant_uid` varchar(50) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `paid_amount` int DEFAULT NULL,
  `paid_at` timestamp NULL DEFAULT NULL,
  `paid_method` varchar(15) DEFAULT NULL,
  `pg_provider` varchar(15) DEFAULT NULL,
  `pg_tid` varchar(30) DEFAULT NULL,
  `pg_type` varchar(15) DEFAULT NULL,
  `receipt_url` varchar(255) DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `status` varchar(12) DEFAULT '01',
  `success` tinyint(1) DEFAULT NULL,
  `fail_reason` varchar(1000) DEFAULT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `order_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `tbl_payment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_prd_month_stat 구조 내보내기
DROP TABLE IF EXISTS `tbl_prd_month_stat`;
CREATE TABLE IF NOT EXISTS `tbl_prd_month_stat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_no` varchar(12) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `year` varchar(4) NOT NULL,
  `month` varchar(2) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_prd_quarter_stat 구조 내보내기
DROP TABLE IF EXISTS `tbl_prd_quarter_stat`;
CREATE TABLE IF NOT EXISTS `tbl_prd_quarter_stat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_no` varchar(12) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `year` varchar(4) NOT NULL,
  `quarter` varchar(1) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `created_date` timestamp NOT NULL,
  `updated_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_prd_year_stat 구조 내보내기
DROP TABLE IF EXISTS `tbl_prd_year_stat`;
CREATE TABLE IF NOT EXISTS `tbl_prd_year_stat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_no` varchar(12) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `year` varchar(4) NOT NULL,
  `sale_total_price` decimal(10,2) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_product_image 구조 내보내기
DROP TABLE IF EXISTS `tbl_product_image`;
CREATE TABLE IF NOT EXISTS `tbl_product_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_type` varchar(4) NOT NULL,
  `product_file_name` varchar(255) NOT NULL,
  `sort_num` bigint NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tbl_product_image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`),
  CONSTRAINT `tbl_product_image_chk_1` CHECK ((`is_deleted` in (0,1)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_product_review 구조 내보내기
DROP TABLE IF EXISTS `tbl_product_review`;
CREATE TABLE IF NOT EXISTS `tbl_product_review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `contents` varchar(1000) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tbl_product_review_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`),
  CONSTRAINT `tbl_product_review_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_product_review_image 구조 내보내기
DROP TABLE IF EXISTS `tbl_product_review_image`;
CREATE TABLE IF NOT EXISTS `tbl_product_review_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `product_review_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_review_id` (`product_review_id`),
  CONSTRAINT `tbl_product_review_image_ibfk_1` FOREIGN KEY (`product_review_id`) REFERENCES `tbl_product_review` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_qanda 구조 내보내기
DROP TABLE IF EXISTS `tbl_qanda`;
CREATE TABLE IF NOT EXISTS `tbl_qanda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `contents` varchar(1000) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tbl_qanda_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`),
  CONSTRAINT `tbl_qanda_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_qanda_comment 구조 내보내기
DROP TABLE IF EXISTS `tbl_qanda_comment`;
CREATE TABLE IF NOT EXISTS `tbl_qanda_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contents` varchar(1000) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `qanda_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `qanda_id` (`qanda_id`),
  CONSTRAINT `tbl_qanda_comment_ibfk_1` FOREIGN KEY (`qanda_id`) REFERENCES `tbl_qanda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_qanda_image 구조 내보내기
DROP TABLE IF EXISTS `tbl_qanda_image`;
CREATE TABLE IF NOT EXISTS `tbl_qanda_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `qanda_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `qanda_id` (`qanda_id`),
  CONSTRAINT `tbl_qanda_image_ibfk_1` FOREIGN KEY (`qanda_id`) REFERENCES `tbl_qanda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_sub_category 구조 내보내기
DROP TABLE IF EXISTS `tbl_sub_category`;
CREATE TABLE IF NOT EXISTS `tbl_sub_category` (
  `sub_cate_code` varchar(20) NOT NULL,
  `sub_cate_name` varchar(50) NOT NULL,
  `main_cate_code` varchar(20) NOT NULL,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  PRIMARY KEY (`sub_cate_code`),
  KEY `main_cate_code` (`main_cate_code`),
  CONSTRAINT `tbl_sub_category_ibfk_1` FOREIGN KEY (`main_cate_code`) REFERENCES `tbl_main_category` (`main_cate_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 klaatus.tbl_wish_list 구조 내보내기
DROP TABLE IF EXISTS `tbl_wish_list`;
CREATE TABLE IF NOT EXISTS `tbl_wish_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(120) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_by` varchar(120) NOT NULL,
  `last_modified_date` timestamp NOT NULL,
  `member_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `member_id` (`member_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tbl_wish_list_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_member` (`id`),
  CONSTRAINT `tbl_wish_list_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

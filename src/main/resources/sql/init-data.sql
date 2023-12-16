DELIMITER $$

USE `test`$$

DROP PROCEDURE IF EXISTS `insert_data`$$

CREATE DEFINER=`root`@`%` PROCEDURE `insert_data`(IN min_num BIGINT (20), IN max_num BIGINT (20))
BEGIN
# 使用方式 call insert_data(100,200);commit;
# 生成之后的卡号和密码一样：yyyyMMdd + 100
    DECLARE i BIGINT DEFAULT min_num ;
    # set autocommit = 0  把 autocommit设置为0
    SET autocommit = 0 ;
    REPEAT
        SET i = i + 1 ;
        INSERT INTO tbl_metal_card (
            name,
            age
        )
        VALUES
            (
                CONCAT('name',i),
                i
            ) ;
    UNTIL i = max_num
    END REPEAT ;
    COMMIT ;
    END$$

DELIMITER ;
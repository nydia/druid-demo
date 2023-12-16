-- init t_user data
DELIMITER $$

USE `test`$$

DROP PROCEDURE IF EXISTS `insert_data_user`$$

CREATE DEFINER=`root`@`%` PROCEDURE `insert_data_user`(IN min_num BIGINT (20), IN max_num BIGINT (20))
BEGIN
    DECLARE i BIGINT DEFAULT min_num ;
    SET autocommit = 0 ;
    REPEAT

        INSERT INTO t_user (
            name,
            user_id,
            age
        )
        VALUES
            (
                CONCAT('name',i),
                i,
                i
            ) ;
        SET i = i + 1 ;
    UNTIL i = max_num
    END REPEAT ;
    COMMIT ;
    END$$

DELIMITER ;


-- init t_order data
DELIMITER $$

USE `test`$$

DROP PROCEDURE IF EXISTS `insert_data_order`$$

CREATE DEFINER=`root`@`%` PROCEDURE `insert_data_order`(IN min_num BIGINT (20), IN max_num BIGINT (20))
BEGIN
    DECLARE i BIGINT DEFAULT min_num ;
    SET autocommit = 0 ;
    REPEAT
        INSERT INTO t_order (
            order_no,
            user_id
        )
        VALUES
            (
                CONCAT('no',i),
                i
            ) ;
        SET i = i + 1 ;
    UNTIL i = max_num
    END REPEAT ;
    COMMIT ;
    END$$

DELIMITER ;
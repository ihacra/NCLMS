-------------------------------
-- 创建序列表：用于获取数据表的id
-------------------------------

-- 创建序列表
CREATE TABLE `sys_sequence` (
	`name` VARCHAR(64) NOT NULL COLLATE 'utf8_bin',
	`current_value` SMALLINT(6) UNSIGNED NULL DEFAULT '0',
	`increment` SMALLINT(6) UNSIGNED NULL DEFAULT '0',
	PRIMARY KEY (`name`)
)
COLLATE='utf8_bin'
ENGINE=InnoDB;

-- 获取当前序列值
DELIMITER $$
DROP FUNCTION IF EXISTS `currval`;
CREATE FUNCTION `currval`(seq_name VARCHAR(64)) RETURNS VARCHAR(64)
READS SQL DATA DETERMINISTIC
BEGIN
	DECLARE VALUE INTEGER;
	SET VALUE = -1;
	SELECT current_value INTO VALUE FROM sys_sequence WHERE NAME = seq_name;
	RETURN VALUE;
END$$
DELIMITER ;

-- 获取下一序列值
DELIMITER $$
DROP FUNCTION IF EXISTS `nextval`;
CREATE FUNCTION `nextval`(seq_name VARCHAR(64)) RETURNS VARCHAR(64)
READS SQL DATA DETERMINISTIC
BEGIN
	DECLARE VALUE INTEGER;
	SET VALUE = currval(seq_name);
	IF VALUE = '-1' THEN
		INSERT INTO sys_sequence VALUES(seq_name, 1, 1);
	ELSE
		UPDATE sys_sequence SET current_value = current_value + increment WHERE NAME = seq_name;
	END IF;
	RETURN currval(seq_name);
END$$
DELIMITER ;

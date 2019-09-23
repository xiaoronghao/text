
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `TB_${objectNameUpper}`
-- ----------------------------
DROP TABLE IF EXISTS `tb_${objectNameLower}`;
CREATE TABLE `tb_${objectNameUpper}` (
 		`id` varchar(100) NOT NULL,
	<#list fieldList as var>
		<#if var[1] == 'Integer'>
		`${var[0]}` int(11) NOT NULL COMMENT '${var[2]}',
		<#else>
		`${var[0]}` varchar(255) DEFAULT NULL COMMENT '${var[2]}',
		</#if>
	</#list>
	`create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` varchar(255) DEFAULT NULL COMMENT '创建用户',
	`modify_user` varchar(255) DEFAULT NULL COMMENT '修改用户',
	`modify_time` timestamp NULL DEFAULT NULL,
	`columns1` varchar(255) DEFAULT NULL COMMENT 'columns1',
	`columns2` varchar(255) DEFAULT NULL COMMENT 'columns2',
	`columns3` varchar(255) DEFAULT NULL COMMENT 'columns3',
	`columns4` varchar(255) DEFAULT NULL COMMENT 'columns4',
	`columns5` varchar(255) DEFAULT NULL COMMENT 'columns5',
  		PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

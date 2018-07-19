/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:44:23
*/

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `sys_acl`;
CREATE TABLE `sys_acl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `code` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '权限码',
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '权限名字',
  `acl_module_id` int(11) NOT NULL DEFAULT '0' COMMENT '权限所在的权限模块的id',
  `url` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '请求的url,可以填正则表达式',
  `type` int(11) NOT NULL DEFAULT '3' COMMENT '类型，1：菜单；2：按钮；3：其他',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '权限在当前模块下的顺序，有小到大',
  `remark` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '备注',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `operate_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_acl
-- ----------------------------
/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:44:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_acl_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl_module`;
CREATE TABLE `sys_acl_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限模块id',
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '权限模块名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上级权限模块id',
  `level` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '权限模块层级',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '权限模块在当前层级下的顺序，由小到大',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态，1：正常；0冻结',
  `remark` varchar(200) COLLATE utf8_bin DEFAULT '' COMMENT '备注',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operator_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operator_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_acl_module
-- ----------------------------
/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:44:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上级部门id',
  `level` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '部门层级',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '部门在当前层级下的顺序，由小到大',
  `remark` varchar(200) COLLATE utf8_bin DEFAULT '' COMMENT '备注',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operator_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operator_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:45:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '权限更新的类型，1：部门；2：用户；3：权限模块；4：权限；5：角色；6：角色用户关系；7：角色权限关系',
  `target_id` int(11) NOT NULL COMMENT '基于type后指定的对象id,比如用户、权限、角色等表的主键',
  `old_value` text COLLATE utf8_bin COMMENT '旧值',
  `new_value` text COLLATE utf8_bin COMMENT '新值',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '当前是否复原过，0：没有；1：复原过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:45:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '角色名称',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '角色类型，1：管理员角色；2：其他',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：可用；0：冻结',
  `remark` varchar(200) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '备注',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:45:18
*/

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `sys_role_acl`;
CREATE TABLE `sys_role_acl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `acl_id` int(11) NOT NULL COMMENT '权限id',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `operate_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:45:27
*/

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次操作者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


/*
Navicat MySQL Data Transfer

Source Server         : diviner
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : mmall_permission

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-07-19 18:45:36
*/

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `telephone` varchar(13) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '手机号',
  `mail` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(40) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '加密后的密码',
  `dept_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户所在部门的id',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常；0：冻结状态；2：删除',
  `remark` varchar(200) COLLATE utf8_bin DEFAULT '' COMMENT '备注',
  `operator` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `operate_ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '最后一次更新的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



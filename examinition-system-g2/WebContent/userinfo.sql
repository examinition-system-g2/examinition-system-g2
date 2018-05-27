/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-12-08 15:28:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `e_name` varchar(20) NOT NULL COMMENT '闂備礁鍚嬪姗�宕幎鑺ュ剨妞ゆ牜鍋涚憴锔撅拷骞垮劚濞夛箓鏁撻敓锟�',
  `e_starttime` varchar(30) NOT NULL COMMENT '闂備礁鍚嬪姗�宕幎鑺ュ剨妞ゆ牗鍑归崵鏇㈡煥閻旇袚闁逛究鍔庨敓鏂ょ秵閸嬪懘藝瑜斿濠氬磼閿旇棄顏�',
  `e_teacher` varchar(20) NOT NULL COMMENT '闁告帗绋戠紓鎾寸閿燂拷',
  `e_examination` varchar(50) DEFAULT 'null' COMMENT '闂佽崵濮村ú锕�煤閺嵮呮殼闁跨噦鎷�',
  `e_isend` tinyint(1) NOT NULL COMMENT '闂佸搫瀚烽崹浼村箚娴ｈ櫣纾奸柟鎯х摠鐏忥拷',
  `e_autostart` tinyint(1) NOT NULL COMMENT '闁哄嫷鍨伴幆渚�鎳涢鍕楃�殿噯鎷峰┑顕嗘嫹',
  `e_file` tinyint(1) NOT NULL COMMENT '鐟滅増甯楅妴鍌炴晬閿燂拷',
  `e_clear` tinyint(1) NOT NULL COMMENT '婵炴挸鎳愰幃锟�?',
  `e_isstart` tinyint(1) NOT NULL DEFAULT '0' COMMENT '鏄惁宸插紑濮�',
  PRIMARY KEY (`e_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `info` varchar(250) NOT NULL,
  `times` varchar(250) NOT NULL,
  PRIMARY KEY (`times`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` varchar(20) NOT NULL COMMENT '闂佽瀛╅崘鑽ょ不閹达絻浜归柨鐕傛嫹',
  `stu_name` varchar(20) NOT NULL COMMENT '闂佽瀛╅崘缁樹繆閸ヮ剙鏋侀柟鎯х摠閸欏繘鏌熼幑鎰彧闁稿鎷�',
  `stu_class` varchar(20) DEFAULT NULL COMMENT '闂佽瀛╅崘缁樹繆閸ヮ剙鏋侀柟鍓х帛閸嬬喐銇勯幘璺衡枅闁绘冻鎷�',
  `stu_submit` varchar(21746) DEFAULT 'null' COMMENT '闂備礁鎼�氱兘宕规导鏉戠畾濞撴熬鎷锋鐐存崌楠炲洭顢旈崨顓熸暘',
  `stu_ip` varchar(15) DEFAULT 'null' COMMENT '缂傚倸鍊烽悞锕傚垂閻㈠憡鍋╃紒璺哄煢',
  `stu_exam` varchar(20) NOT NULL COMMENT '闁圭鎷烽悘鐐靛仩閿熻棄鍟抽惁锟�',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_username` varchar(20) NOT NULL COMMENT '闂備浇妗ㄩ悞锕傛偡閵壯呯當闁跨喍绮欓幃褰掑箛閸撲胶鏆犻悷婊冨簻閹凤拷',
  `t_pwd` varchar(20) NOT NULL COMMENT '闂備浇妗ㄩ悞锕傛偡閵壯呯當闁跨喍绮欓幃妤呮濞戞瑯妫ら梺缁樼壄閹凤拷',
  `t_name` varchar(20) NOT NULL COMMENT '闂備焦妞挎禍鐐哄窗鎼淬劍鍋柛鏇ㄥ墯閸欏繘鏌熼幑鎰彧闁稿鎷�',
  `t_manager` tinyint(1) NOT NULL COMMENT '闂備礁鎼�氱兘宕规导鏉戠畾濞达絽婀遍埢鏃堟煣韫囨凹鍤冮柛姘炬嫹闂備浇宕甸崑娑樜涘Δ鍛疅闁跨噦鎷�',
  PRIMARY KEY (`t_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('123', 'b75008b29d7a6728', '123', '1');
INSERT INTO `teacher` VALUES ('admin', 'ff0ad942f3afc7a5', 'admin', '1');

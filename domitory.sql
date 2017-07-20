/*
SQLyog v10.2 
MySQL - 5.5.47 : Database - domitory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`domitory` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `domitory`;

/*Table structure for table `dorm` */

DROP TABLE IF EXISTS `dorm`;

CREATE TABLE `dorm` (
  `dorm_id` char(10) DEFAULT NULL COMMENT '宿舍号',
  `bed_num` int(2) DEFAULT NULL COMMENT '床位',
  `people_num` int(2) DEFAULT NULL COMMENT '人数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dorm` */

insert  into `dorm`(`dorm_id`,`bed_num`,`people_num`) values ('KYA301',4,4),('KYA302',4,4),('KYB201',4,2),('KYB203',4,3),('KYB501',4,3),('KYB502',4,2),('9#C119',4,3),('9#C120',4,3),('9#D116',4,3),('KYA222',1,2),('KYB110',4,2),('KYB111',4,2),('KYA310',4,1);

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `grade_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dorm_id` char(10) NOT NULL COMMENT '宿舍号',
  `discipline` int(3) NOT NULL COMMENT '纪律分',
  `checks` int(3) NOT NULL COMMENT '考勤分',
  `health` int(3) NOT NULL COMMENT '卫生分',
  `grade` int(3) NOT NULL COMMENT '总分',
  `dates` date NOT NULL COMMENT '评分时间',
  `managers_id` int(11) NOT NULL COMMENT '评分人',
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`grade_id`,`dorm_id`,`discipline`,`checks`,`health`,`grade`,`dates`,`managers_id`) values (1,'KYA301',2,2,3,7,'2015-10-07',100001),(2,'KYA302',3,3,3,9,'2015-10-07',100001),(3,'KYB201',2,3,4,9,'2015-10-07',100001),(4,'KYB203',3,2,3,8,'2015-10-07',100002),(5,'KYB501',3,3,3,9,'2015-10-07',100002),(6,'KYB502',3,3,4,10,'2015-10-07',100002),(7,'9#C119',3,3,4,10,'2015-10-07',100003),(8,'9#C120',3,3,3,9,'2015-10-07',100003),(9,'9#D116',3,2,3,8,'2015-10-07',100003),(10,'9#A101',1,2,4,7,'2015-11-01',100001),(17,'KYA301',2,2,2,6,'2016-03-06',100001),(18,'KYA301',2,2,2,6,'2016-03-06',100001);

/*Table structure for table `lived` */

DROP TABLE IF EXISTS `lived`;

CREATE TABLE `lived` (
  `student_id` int(11) DEFAULT NULL COMMENT '学号',
  `dorm_id` char(10) DEFAULT NULL COMMENT '宿舍号',
  `bed_id` int(1) DEFAULT NULL COMMENT '床号',
  `livingdate` date DEFAULT NULL COMMENT '入住时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lived` */

insert  into `lived`(`student_id`,`dorm_id`,`bed_id`,`livingdate`) values (131515104,'科研B211',3,'2013-09-01'),(131515105,'科研B201',3,'2013-09-01'),(131515106,'科研B201',4,'2013-09-01'),(131515107,'科研B203',1,'2013-09-01'),(131515108,'科研B203',2,'2013-09-01'),(131515109,'科研B203',3,'2013-09-01'),(131515110,'9#D116',3,'2013-09-01'),(141554101,'9#C119',1,'2014-09-05'),(141554102,'9#C119',2,'2014-09-05'),(141554103,'科研A301',1,'2014-09-05'),(141554104,'科研A301',2,'2014-09-05'),(141554105,'科研A301',3,'2014-09-05'),(141554106,'科研A301',4,'2014-09-05'),(141554107,'科研A302',1,'2014-09-05'),(141554108,'科研A302',2,'2014-09-05'),(141554109,'9#C119',3,'2014-09-05'),(141554110,'9#C119',4,'2014-09-05'),(151666101,'科研B501',1,'2015-09-12'),(151666102,'科研B501',2,'2015-09-12'),(151666103,'科研B501',3,'2015-09-12'),(151666104,'科研B501',4,'2015-09-12'),(151666105,'9#C120',1,'2015-09-12'),(151666106,'9#C120',2,'2015-09-12'),(151666107,'9#C120',3,'2015-09-12'),(151666108,'科研B502',1,'2015-09-12'),(151666109,'科研B502',2,'2015-09-12'),(151666110,'9#C120',4,'2015-09-12');

/*Table structure for table `managers` */

DROP TABLE IF EXISTS `managers`;

CREATE TABLE `managers` (
  `manager_name` char(20) NOT NULL COMMENT '姓名',
  `manager_id` int(11) NOT NULL COMMENT '员工号',
  `contact` char(11) NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`manager_id`),
  UNIQUE KEY `UNIQUE` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `managers` */

insert  into `managers`(`manager_name`,`manager_id`,`contact`) values ('卢然',100001,'15547125811'),('李丽',100002,'15798763214'),('王晓',100003,'13527899874');

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `identity` int(1) NOT NULL COMMENT '身份(0为管理员，1为宿管，2为学生)',
  `account` int(15) NOT NULL COMMENT '账号',
  `password` char(12) NOT NULL DEFAULT '000' COMMENT '密码',
  PRIMARY KEY (`account`),
  UNIQUE KEY `UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `register` */

insert  into `register`(`identity`,`account`,`password`) values (0,1,'1'),(1,3,'222'),(1,100001,'000'),(1,100002,'000'),(1,100003,'000'),(0,666666,'000'),(0,888888,'000'),(0,999999,'000'),(2,131515101,'000000'),(2,131515102,'000'),(2,131515103,'000'),(2,131515104,'000'),(2,131515105,'000'),(2,131515106,'000'),(2,131515107,'000'),(2,131515108,'000'),(2,131515109,'000'),(2,131515110,'000'),(2,141554101,'000'),(2,141554102,'000'),(2,141554103,'000'),(2,141554104,'000'),(2,141554105,'000'),(2,141554106,'000'),(2,141554107,'000'),(2,141554108,'000'),(2,141554109,'000'),(2,141554110,'000'),(2,151166106,'000'),(2,151666101,'000'),(2,151666102,'000'),(2,151666103,'000'),(2,151666104,'000'),(2,151666105,'000'),(2,151666107,'000'),(2,151666108,'000'),(2,151666109,'000'),(2,151666110,'000'),(2,154852354,'000');

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `name` char(10) NOT NULL COMMENT '姓名',
  `sex` char(2) NOT NULL COMMENT '性别',
  `birthday` bigint(15) NOT NULL COMMENT '出生日期',
  `addresss` char(20) NOT NULL COMMENT '地址',
  `contact` char(11) NOT NULL COMMENT '联系方式',
  `student_id` int(9) NOT NULL COMMENT '学号',
  `college` char(20) NOT NULL COMMENT '学院',
  `major` char(20) NOT NULL COMMENT '专业',
  `classes` char(10) NOT NULL COMMENT '班级',
  `dorm_id` char(10) NOT NULL COMMENT '宿舍楼号',
  `bed_id` int(1) NOT NULL COMMENT '床号',
  `status` smallint(1) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `UNIQUE` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `students` */

insert  into `students`(`name`,`sex`,`birthday`,`addresss`,`contact`,`student_id`,`college`,`major`,`classes`,`dorm_id`,`bed_id`,`status`) values ('李毅','男',925488000,'郑州','13838381438',131515101,'信息工程学院','生命科学与技术','生科151','KYB201',1,0),('王丽','女',767761871,'北京','13511111111',131515102,'信息工程学院','计算机科学与技术','计科131','9#D116',1,0),('李伟','男',767761871,'上海','18298745621',131515103,'信息工程学院','计算机科学与技术','计科131','KYB201',2,0),('赵微雅','女',767761871,'辽宁','18321597562',131515104,'信息工程学院','计算机科学与技术','计科131','9#D116',2,0),('王强','男',767761871,'新乡','15963257415',131515105,'信息工程学院','计算机科学与技术','计科131','KYB201',3,0),('肖帅','男',755020800,'新乡','15798762153',131515106,'信息工程学院','计算机科学与技术','计科131','KYB201',4,0),('张进','男',767761871,'新乡','15547845632',131515107,'信息工程学院','计算机科学与技术','计科131','KYB203',1,0),('王彬','男',767761871,'新乡','18795423816',131515108,'信息工程学院','计算机科学与技术','计科131','KYB203',2,0),('温首睿','男',767761871,'新乡','17954128796',131515109,'信息工程学院','计算机科学与技术','计科131','KYB203',3,0),('田若琳','女',767761871,'郑州','13547821469',131515110,'信息工程学院','计算机科学与技术','计科131','9#D116',3,0),('乔梦晨','女',767761871,'郑州','13596324784',141554101,'信息工程学院','物联网工程','物联141','9#C119',1,0),('李云','女',767761871,'郑州','15798745136',141554102,'信息工程学院','物联网工程','物联141','9#C119',2,0),('周旭','男',767761871,'郑州','18255549874',141554103,'信息工程学院','物联网工程','物联141','KYA301',1,0),('王建','男',767761871,'洛阳','13587478964',141554104,'信息工程学院','物联网工程','物联141','KYA301',2,0),('王彬','男',767761871,'郑州','18236925814',141554105,'信息工程学院','物联网工程','物联141','KYA301',3,0),('宋宗博','男',767761871,'洛阳','18245678912',141554106,'信息工程学院','物联网工程','物联141','KYA301',4,0),('樊宁波','男',767761871,'洛阳','18325874169',141554107,'信息工程学院','物联网工程','物联141','KYA302',1,0),('王威','男',767761871,'洛阳','17965412585',141554108,'信息工程学院','物联网工程','物联141','KYA302',2,0),('侯文倩','女',767761871,'洛阳','17321456987',141554109,'信息工程学院','物联网工程','物联141','9#C119',3,0),('李薇','女',767761871,'洛阳','17965485237',141554110,'信息工程学院','物联网工程','物联141','9#C119',4,0),('张杰','男',820425600,'郑州','15560109727',151515101,'信息工程学院','计算机科学与技术','计科151','KYA302',3,0),('君邪','男',767761871,'洛阳','18236547895',151666101,'生命科学学院','生命科学与技术','生科151','KYB501',1,0),('楚阳','男',767761871,'洛阳','18321312321',151666102,'生命科学学院','生命科学与技术','生科151','KYB501',2,0),('杨云飞','男',767761871,'周口','18323258525',151666103,'生命科学学院','生命科学与技术','生科151','KYB501',3,0),('李浩然','男',767761871,'周口','18296547414',151666104,'生命科学学院','生命科学与技术','生科151','KYB501',4,0),('墨泪儿','女',767761871,'周口','13528514796',151666105,'生命科学学院','生命科学与技术','生科151','9#C120',1,0),('李冰','女',767761871,'周口','13547965445',151666106,'生命科学学院','生命科学与技术','生科151','9#C120',2,0),('吴茜','女',767761871,'周口','18236547896',151666107,'生命科学学院','生命科学与技术','生科151','9#C120',3,0),('楚展鹏','男',767761871,'周口','13846798461',151666108,'生命科学学院','生命科学与技术','生科151','KYB502',1,0),('李莉','女',767761871,'开封','15984762319',151666110,'生命科学学院','生命科学与技术','生科151','9#C120',4,0),('股哈哈','男',915465600,'河南','13588545219',152458495,'信息工程学院','计算机科学与技术','计科111','KYA302',4,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

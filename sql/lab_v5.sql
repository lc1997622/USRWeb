-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lab
-- ------------------------------------------------------
-- Server version	5.7.8-rc-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成果id',
  `achievement_flag` int(11) NOT NULL COMMENT '0：教学，1：科研',
  `name` varchar(100) NOT NULL COMMENT '成果名',
  `type` int(11) NOT NULL COMMENT '层级。0：校级，1：省级，2：国家级',
  `year` year(4) NOT NULL COMMENT '发表年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成果表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `start_time` datetime NOT NULL COMMENT '签入时间',
  `end_time` datetime NOT NULL COMMENT '签出时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='签到表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `book_id` varchar(8) NOT NULL COMMENT '图书编号，7位数字',
  `name` varchar(45) NOT NULL COMMENT '书名',
  `author` varchar(45) NOT NULL COMMENT '作者',
  `publication_year` year(4) NOT NULL COMMENT '出版年份',
  `location` varchar(45) NOT NULL COMMENT '存放地点',
  `borrow_flag` int(11) NOT NULL DEFAULT '0' COMMENT '1：已被借出，0：未被借出',
  `genre_type` int(11) NOT NULL DEFAULT '2' COMMENT '图书类型id，与字典类型表对应，默认为2',
  `genre_item` int(11) NOT NULL COMMENT '所属类别，与字典项目表对应',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图书表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `book_id` varchar(8) NOT NULL COMMENT '图书id',
  `start_time` datetime NOT NULL COMMENT '借书时间',
  `end_time` datetime NOT NULL COMMENT '还书时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借阅表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contribution`
--

DROP TABLE IF EXISTS `contribution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contribution` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '稿件id',
  `type` int(11) NOT NULL COMMENT '0：新闻动态，1：通知通告，2：学术活动',
  `time` datetime NOT NULL COMMENT '发稿时间',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='稿件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contribution`
--

LOCK TABLES `contribution` WRITE;
/*!40000 ALTER TABLE `contribution` DISABLE KEYS */;
/*!40000 ALTER TABLE `contribution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contribution_has_data`
--

DROP TABLE IF EXISTS `contribution_has_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contribution_has_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `contribution_id` int(11) NOT NULL COMMENT '稿件id',
  `data_id` int(11) NOT NULL COMMENT '资料id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='稿件资料关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contribution_has_data`
--

LOCK TABLES `contribution_has_data` WRITE;
/*!40000 ALTER TABLE `contribution_has_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `contribution_has_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contribution_has_image`
--

DROP TABLE IF EXISTS `contribution_has_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contribution_has_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `contribution_id` int(11) NOT NULL COMMENT '稿件id',
  `image_id` int(11) NOT NULL COMMENT '图片id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='稿件图片关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contribution_has_image`
--

LOCK TABLES `contribution_has_image` WRITE;
/*!40000 ALTER TABLE `contribution_has_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `contribution_has_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copyright`
--

DROP TABLE IF EXISTS `copyright`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `copyright` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '著作权id',
  `number` varchar(45) NOT NULL COMMENT '编号',
  `register_number` varchar(45) NOT NULL COMMENT '登记号',
  `name` varchar(100) NOT NULL COMMENT '软件名称信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='著作权表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copyright`
--

LOCK TABLES `copyright` WRITE;
/*!40000 ALTER TABLE `copyright` DISABLE KEYS */;
/*!40000 ALTER TABLE `copyright` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(20) NOT NULL COMMENT '课程编号',
  `name` varchar(20) NOT NULL COMMENT '课程名',
  `type` int(11) NOT NULL COMMENT '课程性质。1：必修，0：选修',
  `student_type` int(11) NOT NULL COMMENT '学生性质。0：本科生，1：硕士研究生，2：博士研究生',
  `course_time` varchar(100) NOT NULL COMMENT '上课时间（100字符以内）',
  `comment` varchar(100) DEFAULT NULL COMMENT '备注（100字符以内）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_has_student`
--

DROP TABLE IF EXISTS `course_has_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_has_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` varchar(11) NOT NULL COMMENT '学生学号',
  `course_id` varchar(20) NOT NULL COMMENT '课程编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生课程关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_has_student`
--

LOCK TABLES `course_has_student` WRITE;
/*!40000 ALTER TABLE `course_has_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_has_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资料id',
  `type` int(11) NOT NULL COMMENT '0：其他，1：开题，2：中期，3：答辩，4：学位论文，5：专利，6：会议，7：上级文件，8：稿件内的文件',
  `path` varchar(100) NOT NULL COMMENT '资料存储路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资料表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_item`
--

DROP TABLE IF EXISTS `dictionary_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dic_value` int(11) NOT NULL COMMENT '类型id',
  `item_value` int(11) NOT NULL COMMENT '配置项id',
  `item_name` varchar(45) NOT NULL COMMENT '配置项名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='字典项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_item`
--

LOCK TABLES `dictionary_item` WRITE;
/*!40000 ALTER TABLE `dictionary_item` DISABLE KEYS */;
INSERT INTO `dictionary_item` VALUES (1,1,1,'宇航学院'),(2,1,2,'机电学院'),(3,1,3,'机械与车辆学院'),(4,1,4,'光电学院'),(5,1,5,'信息与电子学院'),(6,1,6,'自动化学院'),(7,1,7,'计算机学院'),(8,1,8,'材料学院'),(9,1,9,'化学与化工学院'),(10,1,10,'生命学院'),(11,1,11,'数学与统计学院'),(12,1,12,'物理学院'),(13,1,13,'管理与经济学院'),(14,1,14,'人文与社会科学学院'),(15,1,15,'马克思主义学院'),(16,1,16,'法学院'),(17,1,17,'外国语学院'),(18,1,18,'设计与艺术学院'),(19,2,1,'小说'),(20,2,2,'文学'),(21,2,3,'成功'),(22,2,4,'营销管理'),(23,2,5,'经济'),(24,2,6,'计算机'),(25,2,7,'科普'),(26,2,8,'社科'),(27,2,9,'政军法'),(28,2,10,'哲学'),(29,2,11,'心理'),(30,2,12,'文化'),(31,2,13,'历史'),(32,2,14,'传记'),(33,2,15,'古籍'),(34,2,16,'艺术'),(35,2,17,'婚恋'),(36,2,18,'旅游'),(37,2,19,'生活'),(38,2,20,'时尚'),(39,2,21,'医学保健'),(40,2,22,'亲子教育'),(41,2,23,'童书'),(42,2,24,'教材'),(43,2,25,'通俗'),(44,2,26,'外语');
/*!40000 ALTER TABLE `dictionary_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictionary_type`
--

DROP TABLE IF EXISTS `dictionary_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dic_value` int(11) NOT NULL COMMENT '类型id',
  `dic_name` varchar(45) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary_type`
--

LOCK TABLES `dictionary_type` WRITE;
/*!40000 ALTER TABLE `dictionary_type` DISABLE KEYS */;
INSERT INTO `dictionary_type` VALUES (1,1,'学院'),(2,2,'分类');
/*!40000 ALTER TABLE `dictionary_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edu_reform`
--

DROP TABLE IF EXISTS `edu_reform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edu_reform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教改id',
  `name` varchar(100) NOT NULL COMMENT '教改名',
  `type` int(11) NOT NULL COMMENT '0：校级，1：省部，2：国家',
  `year` year(4) NOT NULL COMMENT '发表年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教改表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edu_reform`
--

LOCK TABLES `edu_reform` WRITE;
/*!40000 ALTER TABLE `edu_reform` DISABLE KEYS */;
/*!40000 ALTER TABLE `edu_reform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `path` varchar(200) NOT NULL COMMENT '图片存储路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `international`
--

DROP TABLE IF EXISTS `international`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `international` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '国际合作项目id',
  `name` varchar(45) NOT NULL COMMENT '大学/企业名称',
  `nation` varchar(45) NOT NULL COMMENT '所属国家',
  `project` varchar(45) NOT NULL COMMENT '项目名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国际交流信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `international`
--

LOCK TABLES `international` WRITE;
/*!40000 ALTER TABLE `international` DISABLE KEYS */;
/*!40000 ALTER TABLE `international` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper`
--

DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '论文id',
  `paper_flag` int(11) NOT NULL COMMENT '0：教学，1：科研',
  `type` int(11) NOT NULL COMMENT '论文类型。0：期刊，1：会议',
  `title` varchar(100) NOT NULL COMMENT '论文标题',
  `year` year(4) NOT NULL COMMENT '发表年份',
  `journal` varchar(45) NOT NULL COMMENT '期刊/会议名称',
  `number` varchar(45) DEFAULT NULL COMMENT '刊号',
  `date` date DEFAULT NULL COMMENT '会议时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论文表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper`
--

LOCK TABLES `paper` WRITE;
/*!40000 ALTER TABLE `paper` DISABLE KEYS */;
/*!40000 ALTER TABLE `paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patent`
--

DROP TABLE IF EXISTS `patent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专利id',
  `number` varchar(45) NOT NULL COMMENT '专利申请号',
  `name` varchar(100) NOT NULL COMMENT '发明创造名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专利表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patent`
--

LOCK TABLES `patent` WRITE;
/*!40000 ALTER TABLE `patent` DISABLE KEYS */;
/*!40000 ALTER TABLE `patent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '科研项目id',
  `name` varchar(100) NOT NULL COMMENT '项目名',
  `type` int(11) NOT NULL COMMENT '项目性质，需求中未具体说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruit`
--

DROP TABLE IF EXISTS `recruit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '招生信息id',
  `type` int(11) NOT NULL COMMENT '0：本科生，1：硕士生，2：博士生，3：留学生',
  `requirement` varchar(500) NOT NULL COMMENT '500字以内',
  `work_time` varchar(100) NOT NULL COMMENT '工作时间（100字以内）',
  `others` varchar(500) DEFAULT NULL COMMENT '其他要求，500字以内',
  `contact` varchar(45) NOT NULL COMMENT '联系人',
  `contact_way` varchar(45) NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruit`
--

LOCK TABLES `recruit` WRITE;
/*!40000 ALTER TABLE `recruit` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_id` varchar(11) NOT NULL COMMENT '学生学号，10位',
  `chinese_name` varchar(20) NOT NULL COMMENT '中文名',
  `english_firstname` varchar(45) NOT NULL COMMENT '中国学生填汉语拼音',
  `english_lastname` varchar(45) NOT NULL COMMENT '中国学生填汉语拼音',
  `sex` int(11) NOT NULL COMMENT '1：男，0：女',
  `type` int(11) NOT NULL COMMENT '学生类别。0：本科，1：学术硕士，2：专业硕士，3：学术博士，4：专业硕士',
  `nationality` varchar(45) NOT NULL COMMENT '国籍',
  `enrollment_time` date NOT NULL COMMENT '入学时间。系统只需要年月，日期默认为1号',
  `graduation_time` date DEFAULT NULL COMMENT '毕业时间。系统只需要年月，日期默认为1号',
  `tutor` varchar(45) NOT NULL COMMENT '导师',
  `vice_tutor` varchar(45) DEFAULT NULL COMMENT '副导师',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `moblie_phone` varchar(45) DEFAULT NULL COMMENT '手机电话，11位。考虑到后期扩展，建议添加国家代码并考虑到各国移动电话的不同编码方式',
  `comment` varchar(100) DEFAULT NULL COMMENT '备注（100字符以内）',
  `image_id` int(11) DEFAULT NULL COMMENT '照片，2M限制',
  `credit` int(11) DEFAULT '0' COMMENT '未按时还书的次数，默认为0',
  `first_company` varchar(45) DEFAULT NULL COMMENT '初次就业单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_has_teacher`
--

DROP TABLE IF EXISTS `student_has_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_has_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teacher_id` varchar(11) NOT NULL COMMENT '教师工号',
  `student_id` varchar(11) NOT NULL COMMENT '学生学号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师学生关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_has_teacher`
--

LOCK TABLES `student_has_teacher` WRITE;
/*!40000 ALTER TABLE `student_has_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_has_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` varchar(11) NOT NULL COMMENT '老师工号。共10位，校内事业编制全职教师以61201开头；校内校聘非事业编制全职教师以72201开头；校内院聘非事业编制全职教师以74201开头；兼职教师没有工号',
  `chinese_name` varchar(20) NOT NULL COMMENT '中文名',
  `english_firstname` varchar(45) NOT NULL COMMENT '中国老师填汉语拼音',
  `english_lastname` varchar(45) NOT NULL COMMENT '中国老师填汉语拼音',
  `sex` int(11) NOT NULL COMMENT '1：男，0：女',
  `type` int(11) NOT NULL COMMENT '老师类型。1：专职，0：兼职',
  `nationality` varchar(45) NOT NULL COMMENT '国籍',
  `department_type` int(11) NOT NULL DEFAULT '1' COMMENT '单位类型id，与字典类型表对应，默认为1',
  `department_item` int(11) NOT NULL COMMENT '所属单位（学院）,与字典项目表对应',
  `title` int(11) NOT NULL COMMENT '职称。4：正高，3：副高，2：中级，1：初级，0：无',
  `tutor_qualification` int(11) NOT NULL COMMENT '导师资格。2：博导，1：硕导，0：无',
  `lab_job` varchar(45) DEFAULT NULL COMMENT '实验室职务',
  `institute_job` varchar(45) DEFAULT NULL COMMENT '学院行政职务',
  `part-time_job` varchar(45) DEFAULT NULL COMMENT '兼职职务',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `moblie_phone` varchar(45) DEFAULT NULL COMMENT '手机电话，11位。考虑到后期扩展，建议添加国家代码并考虑到各国移动电话的不同编码方式',
  `office_phone` varchar(45) DEFAULT NULL COMMENT '办公电话，3（区号）、8（号码），11位。考虑到后期扩展，建议添加国家代码并考虑到各国、各地区固定电话的不同编码方式',
  `comment` varchar(100) DEFAULT NULL COMMENT '备注（100字符以内）',
  `image_id` int(11) DEFAULT NULL COMMENT '照片，2M限制',
  `credit` int(11) DEFAULT '0' COMMENT '未按时还书的次数，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_has_course`
--

DROP TABLE IF EXISTS `teacher_has_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_has_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `teacher_id` varchar(11) NOT NULL COMMENT '教师工号',
  `course_id` varchar(20) NOT NULL COMMENT '课程编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师课程关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_has_course`
--

LOCK TABLES `teacher_has_course` WRITE;
/*!40000 ALTER TABLE `teacher_has_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_has_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `textbook`
--

DROP TABLE IF EXISTS `textbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `textbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教材id',
  `name` varchar(100) NOT NULL COMMENT '教材名',
  `year` year(4) NOT NULL COMMENT '出版年份',
  `type` int(11) NOT NULL COMMENT '层次。0：校级，1：省部，2：国家',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教材表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `textbook`
--

LOCK TABLES `textbook` WRITE;
/*!40000 ALTER TABLE `textbook` DISABLE KEYS */;
/*!40000 ALTER TABLE `textbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(11) NOT NULL COMMENT '用户id，10位',
  `password` varchar(20) NOT NULL COMMENT '密码，20位以内',
  `user_flag` int(11) NOT NULL COMMENT '0：管理员，1：学生，2：老师，3：办公室主任，4：资料管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_achievement`
--

DROP TABLE IF EXISTS `user_has_achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `achievement_id` int(11) NOT NULL COMMENT '成果id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户成果关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_achievement`
--

LOCK TABLES `user_has_achievement` WRITE;
/*!40000 ALTER TABLE `user_has_achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_copyright`
--

DROP TABLE IF EXISTS `user_has_copyright`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_copyright` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `copyright_id` int(11) NOT NULL COMMENT '著作权id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户著作权关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_copyright`
--

LOCK TABLES `user_has_copyright` WRITE;
/*!40000 ALTER TABLE `user_has_copyright` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_copyright` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_data`
--

DROP TABLE IF EXISTS `user_has_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `data_id` int(11) NOT NULL COMMENT '资料id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户资料关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_data`
--

LOCK TABLES `user_has_data` WRITE;
/*!40000 ALTER TABLE `user_has_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_edu_reform`
--

DROP TABLE IF EXISTS `user_has_edu_reform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_edu_reform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `edu_reform_id` int(11) NOT NULL COMMENT '教改id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户教改关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_edu_reform`
--

LOCK TABLES `user_has_edu_reform` WRITE;
/*!40000 ALTER TABLE `user_has_edu_reform` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_edu_reform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_international`
--

DROP TABLE IF EXISTS `user_has_international`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_international` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `international_id` int(11) NOT NULL COMMENT '国际合作项目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户国际交流信息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_international`
--

LOCK TABLES `user_has_international` WRITE;
/*!40000 ALTER TABLE `user_has_international` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_international` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_paper`
--

DROP TABLE IF EXISTS `user_has_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `paper_id` int(11) NOT NULL COMMENT '论文id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户论文关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_paper`
--

LOCK TABLES `user_has_paper` WRITE;
/*!40000 ALTER TABLE `user_has_paper` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_patent`
--

DROP TABLE IF EXISTS `user_has_patent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_patent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `patent_id` int(11) NOT NULL COMMENT '专利id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户专利关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_patent`
--

LOCK TABLES `user_has_patent` WRITE;
/*!40000 ALTER TABLE `user_has_patent` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_patent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_project`
--

DROP TABLE IF EXISTS `user_has_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户项目关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_project`
--

LOCK TABLES `user_has_project` WRITE;
/*!40000 ALTER TABLE `user_has_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_recruit`
--

DROP TABLE IF EXISTS `user_has_recruit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `recruit_id` int(11) NOT NULL COMMENT '招生信息id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户招生信息关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_recruit`
--

LOCK TABLES `user_has_recruit` WRITE;
/*!40000 ALTER TABLE `user_has_recruit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_recruit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_textbook`
--

DROP TABLE IF EXISTS `user_has_textbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_has_textbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `textbook_id` int(11) NOT NULL COMMENT '教材id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户教材管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_textbook`
--

LOCK TABLES `user_has_textbook` WRITE;
/*!40000 ALTER TABLE `user_has_textbook` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_textbook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 17:28:16

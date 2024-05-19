# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: quote
# ------------------------------------------------------
# Server version 5.0.67-community-nt

#
# Table structure for table tb_customer
#

DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer` (
  `customerNO` varchar(20) NOT NULL default '',
  `address` varchar(30) default '(NULL)',
  `customerName` varchar(15) default '(NULL)',
  `otherInfo` varchar(30) default '(NULL)',
  `phone` varchar(15) default '(NULL)',
  `relationman` varchar(15) default '(NULL)',
  PRIMARY KEY  (`customerNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tb_customer` VALUES ('0201305','�����г�����XXX','���Ϲ���','��ע1','123456789','������');
INSERT INTO `tb_customer` VALUES ('0201306','�����г�����XXX','���Ϲ���','��ע','123456789','������');
INSERT INTO `tb_customer` VALUES ('0201307','�����г�����XXX','���Ϲ���','��ע','123456789','������');
INSERT INTO `tb_customer` VALUES ('0201308','�����г�����XXX','���Ϲ���','��ע','123456789','������');
INSERT INTO `tb_customer` VALUES ('0201309','�����г�����XXX','���Ϲ���','��ע','123456789','������');
INSERT INTO `tb_customer` VALUES ('0201310','�����г�����XXX','���Ϲ���','��ע��Ϣ','123456789','������');

#
# Table structure for table tb_order
#

DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `orderNO` varchar(10) NOT NULL default '',
  `orderTime` datetime default NULL,
  `otherInfo` varchar(50) default '(NULL)',
  `quantity` varchar(10) default '(NULL)',
  `customerNO` varchar(20) default '(NULL)',
  `productNO` varchar(15) default '(NULL)',
  PRIMARY KEY  (`orderNO`),
  KEY `FKFA98EE3DD96DD882` (`customerNO`),
  KEY `FKFA98EE3D652AF8BA` (`productNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tb_order` VALUES ('1010121','2009-11-08','6��10��֮ǰ���뷢��','100','0201305','0104578');
INSERT INTO `tb_order` VALUES ('1010122','2009-11-08','6��10��֮ǰ���뷢��','500','0201307','0104579');
INSERT INTO `tb_order` VALUES ('1010123','2009-11-08','6��13��֮ǰ���뷢��','500','0201310','0104578');
INSERT INTO `tb_order` VALUES ('1010124','2009-11-08','6��14��֮ǰ���뷢��','223','0201308','0104588');

#
# Table structure for table tb_product
#

DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `productNO` varchar(15) NOT NULL default '',
  `otherInfo` varchar(50) default '(NULL)',
  `price` decimal(10,2) default '0.00',
  `producingArea` varchar(20) default '(NULL)',
  `productName` varchar(20) default '(NULL)',
  `productOwner` varchar(20) default '(NULL)',
  `quantity` int(11) default '0',
  `unit` varchar(20) default '(NULL)',
  `producttypeNO` varchar(15) default '(NULL)',
  PRIMARY KEY  (`productNO`),
  KEY `FKED97341E7C52804E` (`producttypeNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tb_product` VALUES ('0104578','��ע',2999,'�й���½','��ë��̤����','��ë�ȹ�˾',100,'̨','15487');
INSERT INTO `tb_product` VALUES ('0104579','��ע',1888,'����','����̤����','��������',50,'̨','15487');
INSERT INTO `tb_product` VALUES ('0104587','��ע',2500,'�й���½','�Ŵ��ܲ���','�Ŵ�Ƽ�',150,'̨','17894');
INSERT INTO `tb_product` VALUES ('0104588','��ע',5000,'����','�����ܲ���','����Ƽ�',20,'̨','17894');

#
# Table structure for table tb_producttype
#

DROP TABLE IF EXISTS `tb_producttype`;
CREATE TABLE `tb_producttype` (
  `producttypeNO` varchar(15) NOT NULL default '',
  `producttypeName` varchar(20) default '(NULL)',
  PRIMARY KEY  (`producttypeNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tb_producttype` VALUES ('09','����');
INSERT INTO `tb_producttype` VALUES ('12456','������');
INSERT INTO `tb_producttype` VALUES ('15123','������');
INSERT INTO `tb_producttype` VALUES ('15474','����');
INSERT INTO `tb_producttype` VALUES ('15487','̤����');
INSERT INTO `tb_producttype` VALUES ('17894','�ܲ���');

#
# Table structure for table tb_quotation
#

DROP TABLE IF EXISTS `tb_quotation`;
CREATE TABLE `tb_quotation` (
  `quotationNO` varchar(15) NOT NULL default '',
  `otherInfo` varchar(50) default '(NULL)',
  `quotationMan` varchar(15) default '(NULL)',
  `quotationTime` datetime default NULL,
  `customerNO` varchar(20) default '(NULL)',
  `productNO` varchar(15) default '',
  PRIMARY KEY  (`quotationNO`),
  KEY `FKCABDECFBD96DD882` (`customerNO`),
  KEY `FKCABDECFB652AF8BA` (`productNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tb_quotation` VALUES ('01020304','�Ժ������','С��','2009-11-08','0201305','0104578');
INSERT INTO `tb_quotation` VALUES ('01020305','�Ժ������','С��','2009-11-08','0201306','0104579');
INSERT INTO `tb_quotation` VALUES ('01020306','�Ժ������','С��','2009-11-08','0201310','0104588');
INSERT INTO `tb_quotation` VALUES ('01020307','�Ժ������','�','2009-11-08','0201308','0104578');

#
# Table structure for table tb_user
#

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `username` varchar(18) NOT NULL default '',
  `grade` int(11) NOT NULL default '0',
  `password` varchar(18) default '(NULL)',
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tb_user` VALUES ('2222',1,'2222');
INSERT INTO `tb_user` VALUES ('3',3,'3');
INSERT INTO `tb_user` VALUES ('admin',3,'admin');
INSERT INTO `tb_user` VALUES ('daa',1,'22sa');

#
#  Foreign keys for table tb_order
#

ALTER TABLE `tb_order`
ADD CONSTRAINT `FKFA98EE3DD96DD882` FOREIGN KEY (`customerNO`) REFERENCES `tb_customer` (`customerNO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FKFA98EE3D652AF8BA` FOREIGN KEY (`productNO`) REFERENCES `tb_product` (`productNO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table tb_product
#

ALTER TABLE `tb_product`
ADD CONSTRAINT `FKED97341E7C52804E` FOREIGN KEY (`producttypeNO`) REFERENCES `tb_producttype` (`producttypeNO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table tb_quotation
#

ALTER TABLE `tb_quotation`
ADD CONSTRAINT `FKCABDECFBD96DD882` FOREIGN KEY (`customerNO`) REFERENCES `tb_customer` (`customerNO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FKCABDECFB652AF8BA` FOREIGN KEY (`productNO`) REFERENCES `tb_product` (`productNO`) ON DELETE NO ACTION ON UPDATE NO ACTION;


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

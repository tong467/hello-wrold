DROP TABLE Goods;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '商品名',
  `price` int(11) NOT NULL COMMENT '商品价格',
  `describe` varchar(200) NOT NULL DEFAULT '' COMMENT '商品描述',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0:不可用 1:以上架',
  `createTime` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '更新时间',
  `userId` int(11) NOT NULL COMMENT '操作人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
CREATE TABLE `t_student` (
  `id` int(100) NOT NULL DEFAULT '0',
  `name` varchar(110) DEFAULT NULL,
  `age` int(100) DEFAULT NULL,
  `classname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_teacher` (
  `id` int(100) NOT NULL DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `age` int(20) DEFAULT NULL,
  `subject` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

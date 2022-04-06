CREATE  TABLE  user(
  id  int  PRIMARY KEY  auto_increment,
  name  VARCHAR(20)  NOT NULL,
  sex  int DEFAULT 1 ,
  nameID VARCHAR(20) NOT NULL,
  password VARCHAR(50) NOT NULL,
  salt  VARCHAR(5)  NOT NULL,
  createTime datetime  ,
  updateTime datetime
)
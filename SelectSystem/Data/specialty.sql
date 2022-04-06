CREATE TABLE specialty(
  id  int  PRIMARY KEY auto_increment,
  name  VARCHAR(20) NOT NULL,
  specialtyclass int,
  admitscore int DEFAULT 0,
  admitamount  int  DEFAULT 0,
  createTime datetime,
  updateTime datetime
)
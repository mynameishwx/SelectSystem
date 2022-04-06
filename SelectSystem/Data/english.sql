CREATE TABLE english(
id  int  PRIMARY KEY  auto_increment,
user_Id int not null,
english_Score int DEFAULT 0 not null,
createTime datetime,
updateTime datetime
)
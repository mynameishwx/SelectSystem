CREATE TABLE computer(
id INT  PRIMARY KEY  auto_increment,
user_Id INT not null,
computer_Score  int  DEFAULT 0 not null,
createTime datetime,
updateTime datetime
)
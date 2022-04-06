CREATE TABLE language(
 id INT PRIMARY KEY auto_increment,
 user_Id  int NOT null,
 language_Score int DEFAULT 0  NOT null,
 createTime datetime,
 updateTime datetime
)
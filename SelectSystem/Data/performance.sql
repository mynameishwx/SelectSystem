CREATE TABLE performance(

 id INT PRIMARY KEY auto_increment,

 user_Id  int NOT null,

 performance_Score int DEFAULT 0  NOT null,

 createTime datetime,

 updateTime datetime
)
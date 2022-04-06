CREATE  TABLE  user_role(
  id  int primary key auto_increment,

  userid int not null,

  roleid int not null,

  createTime datetime,

  updateTime datetime
)
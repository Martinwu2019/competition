create table teacher
(
    id         int auto_increment
        primary key,
    userName   varchar(255) null,
    password   varchar(255) null,
    realName   varchar(255) null,
    phone      varchar(255) null,
    email      varchar(255) null,
    createTime datetime     null
);

INSERT INTO competition.teacher (id, userName, password, realName, phone, email, createTime) VALUES (1, 'test', '123', '老实人', '1559487512', '123456789@qq.com', '2024-01-06 00:00:00');
INSERT INTO competition.teacher (id, userName, password, realName, phone, email, createTime) VALUES (2, 'haha', '123', '赵怀真', '15475512545', '123456789@qq.com', '2024-01-06 00:00:00');
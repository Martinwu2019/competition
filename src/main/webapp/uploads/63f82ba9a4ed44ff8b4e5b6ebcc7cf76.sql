create table user
(
    id        int auto_increment
        primary key,
    userName  varchar(20)                   not null,
    password  varchar(30)                   not null,
    sex       varchar(2)                    null comment '性别',
    age       int                           null comment '年龄',
    telephone varchar(20)                   null comment '电话',
    Email     varchar(30)                   null comment 'Email',
    address   varchar(50)                   null comment '地址',
    pic       varchar(100) default 't0.jpg' null,
    topicid   int          default 0        null comment '是否已经选题： 值为选题id。0为未选题'
)
    charset = utf8mb3;

INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (1, '张三丰', 'zsf123', '男', 100, '13809182091', '2425549281@qq.com', '湖北武当山', 't1.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (2, '宋远桥', 'syq123', '男', 50, '13908457344', '2425549281@qq.com', '湖北武当山', 't2.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (3, '俞莲舟', 'ylz123', '男', 45, '13903827601', '2425549281@qq.com', '湖北武当山', 't3.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (4, '俞岱岩', 'ydy123', '男', 43, '13903822001', '2425549281@qq.com', '湖北武当山', 't4.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (5, '赵敏', 'zm123', '女', 23, '13903810621', '2425549281@qq.com', '蒙古科尔沁', 't5.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (6, '张松溪', 'zsx123', '男', 40, '13903819146', '2425549281@qq.com', '湖北武当山', 't6.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (7, '张翠山', 'zcs123', '男', 38, '13903819301', '2425549281@qq.com', '湖北武当山', 't7.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (8, '殷素素', 'yss123', '女', 35, '13123819301', '2425549281@qq.com', '光明顶', 't8.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (9, '殷梨亭', 'ylt123', '男', 35, '13123249301', '2425549281@qq.com', '湖北武当山', 't9.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (10, '莫声谷', 'msg123', '男', 32, '13123249892', '2425549281@qq.com', '湖北武当山', 't10.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (11, '张无忌', 'zwj123', '男', 21, '15797959509', '2425549281@qq.com', '光明顶', 't11.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (12, '杨逍', '123', '男', 45, '15797959509', '2425549281@qq.com', '光明顶', 't12.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (13, '白眉鹰王', '8888', '男', 75, '15797959509', '2425549281@qq.com', '光明顶', 't13.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (14, '觉远大师', '8888', '男', 145, '15797959509', '2425549281@qq.com', '嵩山少林寺', 't14.jpg', 1);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (15, '包拯', '1111', '男', 19, '15797959509', '2425549281@qq.com', '开封', 't15.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (16, '展昭', '2222', '男', 31, '15797959509', '2425549281@qq.com', '开封', 't16.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (17, '小龙女', '4444', '女', 32, '15797959509', '2425549281@qq.com', '古墓', 't17.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (18, '王语嫣', '7777', '女', 45, '15797959509', '2425549281@qq.com', '云南大理', 't18.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (19, '段誉', '1111', '男', 26, '15797959509', '2425549281@qq.com', '江西省南昌市', 't19.jpg', 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (22, '122', '123', null, null, '123', '123', null, null, 0);
INSERT INTO ssm.user (id, userName, password, sex, age, telephone, Email, address, pic, topicid) VALUES (23, '123', '123', null, null, '123', '123', null, null, null);
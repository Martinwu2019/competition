create table admin
(
    id       int auto_increment
        primary key,
    userName varchar(255) null,
    password varchar(255) null
);

INSERT INTO competition.admin (id, userName, password) VALUES (1, 'admin', '123');

create table competition
(
    id            int auto_increment
        primary key,
    title         varchar(255) null,
    content       varchar(255) null,
    teamRegTimeFm datetime     null,
    teamRegTimeTo datetime     null,
    worksTimeFm   datetime     null,
    worksTimeTo   datetime     null,
    checkTimeFm   datetime     null,
    checkTimeTo   datetime     null,
    createTime    datetime     null
);

INSERT INTO competition.competition (id, title, content, teamRegTimeFm, teamRegTimeTo, worksTimeFm, worksTimeTo, checkTimeFm, checkTimeTo, createTime) VALUES (3, '来比赛', '什么比赛，你看看', '2024-01-04 00:00:00', '2024-01-07 00:00:00', '2024-01-04 00:00:00', '2024-01-08 00:00:00', '2024-01-06 00:00:00', '2024-01-10 00:00:00', '2024-01-06 00:00:00');


create table notice
(
    id         int auto_increment
        primary key,
    title      varchar(255) null,
    content    varchar(255) null,
    img        varchar(255) null,
    createTime datetime     null
);

INSERT INTO competition.notice (id, title, content, img, createTime) VALUES (3, '公告1', '这条公告准备发布最新的比赛时间', '123', '2024-01-06 00:00:00');
INSERT INTO competition.notice (id, title, content, img, createTime) VALUES (4, '432', '42', 'D:\\myApplication\\learning\\javaProject\\xianyu\\competition0105\\Competition\\target\\Competition-1.0-SNAPSHOT\\\\uploads\\联想截图_20230409010833.png', '2024-01-06 00:00:00');
INSERT INTO competition.notice (id, title, content, img, createTime) VALUES (5, 'è¯·é®', 'å¡å¡å¡', 'D:\\myApplication\\learning\\javaProject\\xianyu\\competition0105\\Competition\\target\\Competition-1.0-SNAPSHOT\\\\uploads\\dcaC6qtcEc.png', '2024-01-06 00:00:00');
INSERT INTO competition.notice (id, title, content, img, createTime) VALUES (6, 'tt', 'tt', 'uploads/990f842205b441b297929e5bb4e611fd.png', '2024-01-06 00:00:00');
INSERT INTO competition.notice (id, title, content, img, createTime) VALUES (7, '33', '33', '/uploads/e81fae51f2e0443e959ddc7b8e1bace1.png', '2024-01-06 00:00:00');
INSERT INTO competition.notice (id, title, content, img, createTime) VALUES (8, 'å·å¡', '23', '/uploads/159d7b38d8da4fcc8ebd858cf3172937.png', '2024-01-06 00:00:00');
INSERT INTO competition.notice (id, title, content, img, createTime) VALUES (9, '烦烦烦', '的', '/uploads/d4406cc59ffb4b51af37d612a6659f8e.png', '2024-01-06 00:00:00');


create table student
(
    id           int auto_increment
        primary key,
    userName     varchar(255) null,
    password     varchar(255) null,
    realName     varchar(255) null,
    age          int          null,
    phone        varchar(11)  null,
    email        varchar(255) null,
    grade        varchar(255) null,
    major        varchar(255) null,
    identityCode varchar(255) null,
    createTime   datetime     null
);

INSERT INTO competition.student (id, userName, password, realName, age, phone, email, grade, major, identityCode, createTime) VALUES (1, 'admin', '123456', 'test', 1, '1', '1', '1', '1', '1', '2024-01-04 00:00:00');
INSERT INTO competition.student (id, userName, password, realName, age, phone, email, grade, major, identityCode, createTime) VALUES (2, 'test', '123456', '123', 123, '123', '123', '123', '123', '123', '2024-01-04 00:00:00');
INSERT INTO competition.student (id, userName, password, realName, age, phone, email, grade, major, identityCode, createTime) VALUES (3, '123', '111', '111', 111, '111', '111', '111', '111', '111', '2024-01-04 00:00:00');
INSERT INTO competition.student (id, userName, password, realName, age, phone, email, grade, major, identityCode, createTime) VALUES (4, 'admin', '222', '222', 222, '222', '222', '222', '222', '222', '2024-01-04 00:00:00');
INSERT INTO competition.student (id, userName, password, realName, age, phone, email, grade, major, identityCode, createTime) VALUES (5, 'new', '123', '哈哈哈', 23, '123', '123', '123', '123', '2223', '2024-01-05 00:00:00');


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


create table team
(
    id             int auto_increment
        primary key,
    teamName       varchar(255) null,
    loginName      varchar(255) null,
    password       varchar(255) null,
    teacherId      int          null,
    teacherName    varchar(255) null,
    teacherId2     int          null,
    teacherName2   varchar(255) null,
    studentId      int          null,
    studentName    varchar(255) null,
    upload         varchar(255) null,
    fileName       varchar(255) null,
    audit          varchar(255) null,
    createTime     datetime     null,
    competitionId  int          null,
    checkTeacherId int          null
);

INSERT INTO competition.team (id, teamName, loginName, password, teacherId, teacherName, teacherId2, teacherName2, studentId, studentName, upload, fileName, audit, createTime, competitionId, checkTeacherId) VALUES (4, 'test', 'test', '123456', null, 'test', null, '', 1, 'test', null, null, null, '2024-01-05 00:00:00', 1, null);
INSERT INTO competition.team (id, teamName, loginName, password, teacherId, teacherName, teacherId2, teacherName2, studentId, studentName, upload, fileName, audit, createTime, competitionId, checkTeacherId) VALUES (5, '我得团队', 'team', '123', null, '我得团队', null, '', 1, 'test', '/uploads/63f82ba9a4ed44ff8b4e5b6ebcc7cf76.sql', null, '通过', '2024-01-06 00:00:00', 3, 1);
create table teammember
(
    id            int auto_increment
        primary key,
    teamId        int null,
    studentId     int null,
    competitionId int null
);

INSERT INTO competition.teammember (id, teamId, studentId, competitionId) VALUES (3, 4, 1, 1);
INSERT INTO competition.teammember (id, teamId, studentId, competitionId) VALUES (5, 4, 5, 1);
INSERT INTO competition.teammember (id, teamId, studentId, competitionId) VALUES (6, 5, 1, 3);


create table works
(
    id         int auto_increment
        primary key,
    worksName  varchar(255) null,
    category   varchar(255) null,
    subclass   varchar(255) null,
    worksCode  varchar(255) null,
    filePath   varchar(255) null,
    audit      varchar(255) null,
    createTime datetime     null,
    teamId     int          null
);

INSERT INTO competition.works (id, worksName, category, subclass, worksCode, filePath, audit, createTime, teamId) VALUES (1, '小城故事', '生活', '乡村', '9c64d4f8159a4ad7b0d262b4d1b98145', '日日日', '未审核', '2024-01-05 00:00:00', 4);
INSERT INTO competition.works (id, worksName, category, subclass, worksCode, filePath, audit, createTime, teamId) VALUES (2, '等待', '  的都是', '等待', '1014f9e64d984268acc4e10773d67037', '/uploads/1f3de982062f45e198b2c7485a10e616.sql', '未审核', '2024-01-06 00:00:00', 5);
INSERT INTO competition.works (id, worksName, category, subclass, worksCode, filePath, audit, createTime, teamId) VALUES (3, '让人', '让人', '让人', '017f45a402e54f6b81567e51a08c9996', '/uploads/63f82ba9a4ed44ff8b4e5b6ebcc7cf76.sql', '未审核', '2024-01-06 00:00:00', 5);
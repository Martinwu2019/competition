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
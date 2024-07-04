create table userexam
(
    id          int auto_increment
        primary key,
    examId      int          null,
    examName    varchar(255) null,
    teacherName varchar(255) null,
    subjectName varchar(255) null,
    createTime  datetime     null,
    userId      int          null,
    userName    varchar(255) null,
    score       int          null,
    examNum     int          null
);

INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (2, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 1, '张三丰', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (3, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 2, '宋远桥', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (4, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 3, '俞莲舟', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (5, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 4, '俞岱岩', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (6, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 5, '赵敏', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (7, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 6, '张松溪', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (8, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 7, '张翠山', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (9, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 8, '殷素素', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (10, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 9, '殷梨亭', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (11, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 10, '莫声谷', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (12, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 11, '张无忌', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (13, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 12, '杨逍', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (14, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 13, '白眉鹰王', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (15, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 14, '觉远大师', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (16, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 15, '包拯', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (17, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 16, '展昭', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (18, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 17, '小龙女', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (19, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 18, '王语嫣', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (20, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 19, '段誉', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (21, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 22, '122', 100, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (22, 3, 'test', '贝尔2', '数学', '2023-12-30 15:06:35', 23, '123', null, 3);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (23, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 1, '张三丰', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (24, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 2, '宋远桥', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (25, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 3, '俞莲舟', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (26, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 4, '俞岱岩', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (27, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 5, '赵敏', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (28, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 6, '张松溪', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (29, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 7, '张翠山', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (30, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 8, '殷素素', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (31, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 9, '殷梨亭', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (32, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 10, '莫声谷', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (33, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 11, '张无忌', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (34, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 12, '杨逍', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (35, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 13, '白眉鹰王', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (36, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 14, '觉远大师', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (37, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 15, '包拯', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (38, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 16, '展昭', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (39, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 17, '小龙女', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (40, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 18, '王语嫣', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (41, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 19, '段誉', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (42, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 22, '122', null, 1);
INSERT INTO ssm.userexam (id, examId, examName, teacherName, subjectName, createTime, userId, userName, score, examNum) VALUES (43, 4, '哈哈随便', '贝尔2', '逻辑题', '2023-12-30 16:36:14', 23, '123', null, 1);
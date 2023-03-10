INSERT INTO employee (id, name, age)
VALUES('1', 'Tom', 30);

/* ユーザーマスタ */
INSERT INTO m_user (
    user_id
  , password
  , user_name
  , birthday
  , age
  , gender
  , address
  , telephone_number
  , department_id
  , role
) VALUES
('system@co.jp', '$2a$10$gzUbSxiL1zC4JIGeyJdowOn8g.GLkxvH8y1malGhm.0bmEtqmkkwW', 'システム管理者', '2000-01-01', 21, 1, '東京都港区芝公園４丁目２−８','08011112222',1, 'ROLE_ADMIN')
, ('user@co.jp', '$2a$10$gzUbSxiL1zC4JIGeyJdowOn8g.GLkxvH8y1malGhm.0bmEtqmkkwW', 'ユーザー1', '2000-01-01', 21, 2,'東京都墨田区押上１丁目１−２','09033334444' ,2, 'ROLE_GENERAL')
;

/* 部署マスタ */
INSERT INTO m_department (
    department_id
  , department_name
) VALUES
(1, 'システム管理部')
, (2, '営業部')
;

/* 給料テーブル */
INSERT INTO t_salary (
    user_id
  , year_month
  , salary
) VALUES
('user@co.jp', '2020/11', 280000)
, ('user@co.jp', '2020/12', 290000)
, ('user@co.jp', '2021/01', 300000)
;
SELECT @@autocommit;

show databases;

show tables from project_spring_jpa_shop;

create table if not exists project_spring_jpa_shop.db_setting_test(id int);

start transaction ;
insert into project_spring_jpa_shop.db_setting_test values(1);
insert into project_spring_jpa_shop.db_setting_test values(2);
commit;

SELECT * FROM project_spring_jpa_shop.db_setting_test;

start transaction ;
insert into project_spring_jpa_shop.db_setting_test values(3);
Select * from project_spring_jpa_shop.db_setting_test;
rollback ;
Select * from project_spring_jpa_shop.db_setting_test;

drop table if exists project_spring_jpa_shop.db_setting_test ;

show tables from project_spring_jpa_shop;


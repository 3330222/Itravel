
insert into tb_sys_code_type values('0c6117bd8ef841769993c93f00faff4d','UserTypeCd','用户类型');
insert into tb_sys_code_type values('cc6117bd8ef841769993c93f00eaff4d','GenderCd','性别');
insert into tb_sys_code_type values('fc6117bd8ef841769993c93f00eaff4d','RouteStatusCd','路线状态');
insert into tb_sys_code_type values('1c6117bd8ef841769993c93f00eaff4d','TourTypeCd','发团类型');
insert into tb_sys_code_type values('fc6117bd8ef84176a993c93f00eaff4d','OrderStatusCd','订单状态');
insert into tb_sys_code_type values('ff6117bd8ef84176a993c93f00eaff4d','UserRealInfoCd','用户实名认证状态');

------------------------------------------------------------------------------------------
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('cc611fff8ef841701993c93ca0faffee','游客','UserTypeCd','1',null,'0c6117bd8ef841769993c93f00faff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('cc621fff8ef841701993c93ca0faffee','客栈','UserTypeCd','2',null,'0c6117bd8ef841769993c93f00faff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('cc631fff8ef841701993c93ca0faffee','系统','UserTypeCd','3',null,'0c6117bd8ef841769993c93f00faff4d');

insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('1c611fff8ef841701993c93ca0faffee','男','UserTypeCd','1',null,'cc6117bd8ef841769993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('2c621fff8ef841701993c93ca0faffee','女','UserTypeCd','2',null,'cc6117bd8ef841769993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('3c631fff8ef841701993c93ca0faffee','未知','UserTypeCd','3',null,'cc6117bd8ef841769993c93f00eaff4d');

insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('a1611fff8ef841701993c93ca0faffee','审核中','RouteStatusCd','1',null,'fc6117bd8ef841769993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('b2621fff8ef841701993c93ca0faffee','已上架','RouteStatusCd','2',null,'fc6117bd8ef841769993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('c3631fff8ef841701993c93ca0faffee','仓库中','RouteStatusCd','3',null,'fc6117bd8ef841769993c93f00eaff4d');


insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('b26211ff8ef841701993c13ca0faffee','整团','TourTypeCd','1',null,'1c6117bd8ef841769993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('c36312ff8ef841701993c13ca0faffee','散团','TourTypeCd','2',null,'1c6117bd8ef841769993c93f00eaff4d');

insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('bc6107bd8ef84176a993c93f00eaff41','待付款','OrderStatusCd','1',null,'fc6117bd8ef84176a993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('bc6107bd8ef84176a993c93f00eaff42','已付款','OrderStatusCd','2',null,'fc6117bd8ef84176a993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('bc6107bd8ef84176a993c93f00eaff43','退款中','OrderStatusCd','3',null,'fc6117bd8ef84176a993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('bc6107bd8ef84176a993c93f00eaff44','已关闭','OrderStatusCd','4',null,'fc6117bd8ef84176a993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('bc6107bd8ef84176a993c93f00eaff45','已完成','OrderStatusCd','5',null,'fc6117bd8ef84176a993c93f00eaff4d');

insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('dc61071d8ef84176a993c93f00eaff42','未认证','UserRealInfoCd','1',null,'ff6117bd8ef84176a993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('dc61072d8ef84176a993c93f00eaff43','认证审核中','UserRealInfoCd','2',null,'ff6117bd8ef84176a993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('dc61073d8ef84176a993c93f00eaff44','审核通过','UserRealInfoCd','3',null,'ff6117bd8ef84176a993c93f00eaff4d');
insert into tb_sys_codes(code_id,code_name, code_type_cd, code_value, status, code_type_id) values ('dc61074d8ef84176a993c93f00eaff45','审核失败','UserRealInfoCd','4',null,'ff6117bd8ef84176a993c93f00eaff4d');

CREATE TABLE `persistent_logins` (
	`username` VARCHAR(100) NOT NULL,
	`series` VARCHAR(64) NOT NULL,
	`token` VARCHAR(64) NOT NULL,
	`last_used` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`series`)
);

INSERT INTO TB_CSM_USER (user_id, address, email, password, phone, user_name, user_Status_Cd, account, create_time, update_time,user_type_cd) values('3747364DA789938a8867fabc637898c3','Beijing','admin@gmail.com','c4ca4238a0b923820dcc509a6f75849b',
'66666666','admin','1','admin',null,null,'1');
INSERT INTO TB_CSM_USER (user_id, address, email, password, phone, user_name, user_Status_Cd, account, create_time, update_time,user_type_cd) values('3747364DA789938a8867fabc63789843','Beijing','user1@gmail.com','c4ca4238a0b923820dcc509a6f75849b',
'66666666','user1','1','user1',null,null,'3');


insert into tb_sys_role (role_id,role_name,role_status_cd) values('374736437789938a8867fabc637898c1','ROLE_ADMIN','1');
insert into tb_sys_role (role_id,role_name,role_status_cd) values('374736437789938a8867fabc637898c2','ROLE_USER','1');
insert into tb_sys_role (role_id,role_name,role_status_cd) values('374736437789938a8867fabc637898c3','ROLE_HOSTEL','1');

insert into tb_csm_user_role (user_id, role_id) values('3747364DA789938a8867fabc637898c3','374736437789938a8867fabc637898c1');
insert into tb_csm_user_role (user_id, role_id)  values('3747364DA789938a8867fabc637898c3','374736437789938a8867fabc637898c2');
insert into tb_csm_user_role  (user_id, role_id) values('3747364DA789938a8867fabc63789843','374736437789938a8867fabc637898c2');




create database ASM;
use ASM;
CREATE TABLE users (

                       username VARCHAR(50)  primary key,
                       password VARCHAR(50),
                       full_name NVARCHAR(50)
);
create table departs(
                        departid varchar(10) primary key,
                        departname nvarchar(50)
);
create table staffs(
                       staffid varchar(10) primary key,
                       staffname nvarchar(50),
                       gender bit,
                       birthday date,
                       phone varchar(20),
                       email varchar(50),
                       salary float,
                       notes nvarchar(255),
                       departid varchar(10),
                       foreign key(departid) references departs(departid)
);

create table records(
                        recordid int primary key auto_increment,
                        type bit,
                        reason nvarchar(255),
                        date date,
                        staffid varchar(50),
                        foreign key(staffid) references staffs(staffid)
);
insert into Users values('ti','123',N'Tâm');

insert into Users values('trinh','123',N'Trinh');

insert into Users values('admin','123',N'Admin');

insert into Users values('dung','123',N'Dũng');


insert into Departs values('IT','IT');

insert into Departs values('MK',N'Marketing ');

insert into Departs values('HR',N'Tuyển dụng');

insert into Departs values('KT',N'Kinh tế');

insert into Departs values('KD',N'Kinh doanh');

insert into Staffs values('NV001',N'Nguyên Văn Nam',1,'2000/2/14','123','a@gmail.com','123','','IT');
insert into Staffs values('NV002',N'Teo',1,'1999/3/12',123,'a@gmail.com',123,'','MK');
insert into Staffs values('NV003',N'Em',0,'1995/7/16',123,'a@gmail.com',123,'','HR');
insert into Staffs values('NV004',N'Phạm',1,'2001/2/18',123,'a@gmail.com',123,'','KT');
insert into Staffs values('NV005',N'Qúy',0,'2000/1/12',123,'a@gmail.com',123,'','KD');
insert into Staffs values('NV006',N'Hương',0,'2000/1/12',123,'a@gmail.com',123,'','KD');


insert into Records(type,reason,date,staffid) values(1,N'Hoàn tất','1997/12/03','NV001');

insert into Records(type,reason,date,staffid) values(1,N'Hoàn tất','1997/12/03','NV002');
insert into Records(type,reason,date,staffid) values(0,N'Chưa hoàn tất','1997-12-03','NV003');


insert into Records(type,reason,date,staffid) values(1,N'Hoàn tất','1997-12-03','NV004');

insert into Records(type,reason,date,staffid) values(0,N'HoÃ n thÃ nh chÆ°a tá»‘t','1997-12-03','NV005');

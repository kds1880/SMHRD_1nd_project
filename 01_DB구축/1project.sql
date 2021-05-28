DROP TABLE member CASCADE CONSTRAINTS;
DROP TABLE nutrients CASCADE CONSTRAINTS;
DROP TABLE recommendation CASCADE CONSTRAINTS;
DROP TABLE alarm CASCADE CONSTRAINTS;

CREATE TABLE member
(member_id VARCHAR2(12),
member_pw VARCHAR2(12) NOT NULL,
member_name VARCHAR2(20) NOT NULL,
member_age NUMBER(4) NOT NULL,
CONSTRAINT member_mbid_pk PRIMARY KEY(member_id));

CREATE TABLE nutrients
(nutrient VARCHAR2(40),
efficacy VARCHAR2(800) NOT NULL,
precautions VARCHAR2(1000) NOT NULL,
body_classification VARCHAR2(40) NOT NULL,
nutrition_classification VARCHAR2(20) NOT NULL,
CONSTRAINT nutrients_nutri_pk PRIMARY KEY(nutrient));

CREATE TABLE recommendation
(nutrient VARCHAR2(40),
pt_nutrient VARCHAR2(40),
interaction VARCHAR2(700) NOT NULL,
classification VARCHAR2(10) NOT NULL,
CONSTRAINT rmmd_renu_repnu_reclass_pk PRIMARY KEY(nutrient,pt_nutrient,classification),
CONSTRAINT rmmd_renu_fk FOREIGN KEY(nutrient) REFERENCES nutrients(nutrient));

CREATE TABLE alarm
(id VARCHAR2(12) NOT NULL,
alarm_name VARCHAR2(40) NOT NULL,
time timestamp with local time zone NOT NULL,
CONSTRAINT time_tmid_fk FOREIGN KEY(id) REFERENCES member(member_id));

alter session set nls_timestamp_format = 'YYYY-MM-DD HH24:MI:SS';

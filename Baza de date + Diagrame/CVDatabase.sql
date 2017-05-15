ALTER TABLE Experience DROP CONSTRAINT fk_exp;
/
ALTER TABLE Studies DROP CONSTRAINT fk_std;
/
ALTER TABLE LanguageSkills DROP CONSTRAINT fk_lng;
/
ALTER TABLE Hobbies DROP CONSTRAINT fk_hob;
/
ALTER TABLE SoftSkills DROP CONSTRAINT fk_ssk;
/

DROP TABLE CurriculumVitae;
/
DROP TABLE Experience;
/
DROP TABLE Studies;
/
DROP TABLE LanguageSkills;
/
DROP TABLE Hobbies;
/
DROP TABLE SoftSkills;
/
DROP TABLE Clustering;


CREATE TABLE CurriculumVitae(
  ID NUMBER primary key,
  CLUSTER_ID VARCHAR2(3),
  NAME VARCHAR2(256),
  DATE_OF_BIRTH DATE,
  ADDRESS VARCHAR2(256),
  PHONE_NUMBER NUMBER(10),
  EMAIL VARCHAR2(256),
  EXPERIENCE_YEARS NUMBER,
  IDEAL_JOB VARCHAR2(256)
);
/

CREATE TABLE Experience(
  CV_ID NUMBER,
  JOB_TITLE VARCHAR2(256),
  EXPERIENCE_YEARS NUMBER,
  
  CONSTRAINT fk_exp
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/

CREATE TABLE Studies(
  CV_ID NUMBER,
--  0 - LICEU; 
--  2 - LICENTA
--  4 - MASTER
--  6 - DOCTORAT
  CERTIFICATE NUMBER,
  STUDY_YEARS NUMBER,
  
  CONSTRAINT fk_std
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/

CREATE TABLE LanguageSkills(
  CV_ID NUMBER not null,
  LANGUAGE CLOB,
  
  CONSTRAINT fk_lng
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/

CREATE TABLE Hobbies(
  CV_ID NUMBER not null,
  HOBBY CLOB,
  
  CONSTRAINT fk_hob
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/

CREATE TABLE SoftSkills(
  CV_ID NUMBER,
  SKILL CLOB,
  VALOARE NUMBER,
  
  CONSTRAINT fk_ssk
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/

CREATE TABLE Clustering(
  CLUSTER_ID NUMBER,
  CENTER_OF_GRAVITY NUMBER
);
/

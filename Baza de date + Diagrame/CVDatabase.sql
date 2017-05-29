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
ALTER TABLE TechnicalSkills DROP CONSTRAINT fk_tsk;
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
DROP TABLE TechnicalSkills;
/
DROP TABLE Clustering;


CREATE TABLE CurriculumVitae(
  ID NUMBER primary key,
  CLUSTER_ID NUMBER,
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
  VALUE NUMBER,
  
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
  VALUE NUMBER,
  
  CONSTRAINT fk_std
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/

CREATE TABLE SoftSkills(
  CV_ID NUMBER,
  SKILL CLOB,
  VALUE NUMBER,
  
  CONSTRAINT fk_ssk
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/
CREATE TABLE TechnicalSkills(
  CV_ID NUMBER,
  SKILL CLOB,
  VALUE NUMBER,

  CONSTRAINT fk_tsk
     FOREIGN KEY (CV_ID)
     REFERENCES CurriculumVitae(ID)
);
/
CREATE TABLE Clustering(
  CLUSTER_ID NUMBER,
  CENTER_OF_GRAVITY NUMBER
);
/

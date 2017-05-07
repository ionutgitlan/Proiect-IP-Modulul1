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
ALTER TABLE Technical_Skills DROP CONSTRAINT fk_tec;
/
ALTER TABLE Social_Skills DROP CONSTRAINT fk_soc;
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
DROP TABLE Technical_skills;
/
DROP TABLE Social_skills;
/
DROP TABLE SoftSkills;
/


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
  TECHNICAL_SKILL_ID NUMBER unique not null,
  SOCIAL_SKILL_ID NUMBER unique not null,
  
  CONSTRAINT fk_ssk
    FOREIGN KEY (CV_ID)
    REFERENCES CurriculumVitae(ID)
);
/

CREATE TABLE TECHNICAL_SKILLS(
   TECHNICAL_SKILL_ID NUMBER not null,
   SKILL CLOB,
   
   CONSTRAINT fk_tec
    FOREIGN KEY (TECHNICAL_SKILL_ID)
    REFERENCES SoftSkills(TECHNICAL_SKILL_ID)
);
/

CREATE TABLE SOCIAL_SKILLS(
  SOCIAL_SKILL_ID NUMBER not null,
  SKILL CLOB,
  
  CONSTRAINT fk_soc
    FOREIGN KEY (SOCIAL_SKILL_ID)
    REFERENCES SoftSkills(SOCIAL_SKILL_ID)
);
/
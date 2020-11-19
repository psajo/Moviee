--moveDB SQL

--member 테이블
CREATE TABLE member(
    m_email VARCHAR2(100) primary key,
    m_pwd VARCHAR2(30) NOT NULL,
    m_nick VARCHAR2(30) UNIQUE NOT NULL,
    m_profile VARCHAR2(200) NULL,
    m_fav1 VARCHAR2(30) NOT NULL,
    m_fav2 VARCHAR2(30) NOT NULL,
    m_fav3 VARCHAR2(30) NOT NULL
);
--review 시퀀스
create SEQUENCE r_reviewId_seq start with 1;

--review 테이블
CREATE TABLE review(
    r_reviewId NUMBER(8) primary key,
    m_nick VARCHAR2(30) NOT NULL,
    mv_id  NUMBER(8) NOT NULL,
    r_contents VARCHAR(100) NOT NULL,
    r_star VARCHAR(5) NOT NULL,
    r_date CHAR(20) NOT NULL,
    CONSTRAINT fk_r_m FOREIGN KEY(m_nick)
         REFERENCES member(m_nick) ON DELETE CASCADE,
    CONSTRAINT fk_r_mv FOREIGN KEY(mv_id)
         REFERENCES movie(mv_id) ON DELETE CASCADE
);

--movie 시퀀스
create SEQUENCE mv_id_seq start with 1;

--movie 테이블
create table movie(
    mv_id NUMBER(8) primary key,
    mv_title varchar2(100) not null,
    mv_posterPath varchar2(200) null,
    mv_snapshotPath varchar2(200) null,
    mv_casting varchar2(100) null ,
    mv_crew varchar2(100) null,
    mv_genres varchar2(100) null,
    mv_overview varchar2(3000) null,
    mv_releaseDate date null,
    mv_voteCount number(7) null
);

--member 테스트데이터
insert into member(m_email,m_pwd,m_nick,m_fav1,m_fav2,m_fav3) values('admin@admin.com','1234','관리자','공포','액션','멜로');
insert into member(m_email,m_pwd,m_nick,m_fav1,m_fav2,m_fav3) values('test1@test.com','1234','테스터1','SF','추리','범죄');
insert into member(m_email,m_pwd,m_nick,m_fav1,m_fav2,m_fav3) values('test2@test.com','1234','테스터2','전쟁','코미디','로맨틱코미디');
insert into member(m_email,m_pwd,m_nick,m_fav1,m_fav2,m_fav3) values('test3@test.com','1234','테스터3','전쟁','코미디','로맨틱코미디');
commit;
select * from member;
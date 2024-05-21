package com.travelmaker.board.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Member {
  private Long managementId;    //  MANAGEMENT_ID	NUMBER(10,0)
  private String memberId;    //  MEMBER_ID	VARCHAR2(12 BYTE)
  private String pw;    //  PW	VARCHAR2(20 BYTE)
  private String tel;    //  TEL	VARCHAR2(11 BYTE)
  private String nickname;    //  NICKNAME	VARCHAR2(36 BYTE)
  private String gender;    //  GENDER	VARCHAR2(3 BYTE)
  private String address;    //  ADDRESS	VARCHAR2(120 BYTE)
  private LocalDateTime udate;    //  UDATE	TIMESTAMP(6)
  private LocalDateTime cdate;    //  CDATE	TIMESTAMP(6)
  private Long codeId;    //  CODE_ID	VARCHAR2(6 BYTE)
  private LocalDateTime birthday;    //  BIRTHDAY	DATE
  private String email;    //  EMAIL	VARCHAR2(100 BYTE)

}

package com.travelmaker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
@Getter
@Setter
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long managementId; //MANAGEMENT_ID;                 //	NUMBER(10,0)
  String memberId;   // MEMBER_ID;                 //	VARCHAR2(12 BYTE)
  String password;   //PW;                  //	VARCHAR2(20 BYTE)
  String tel;                 //	VARCHAR2(11 BYTE)
  String nickname;                  //	VARCHAR2(36 BYTE)
  String gender;                  //	VARCHAR2(3 BYTE)
  String address;                 //	VARCHAR2(120 BYTE)
  Date udate;                 //	TIMESTAMP(6)
  Date cdate;                 //	TIMESTAMP(6)
  Integer codeId;                 //	VARCHAR2(6 BYTE)
  Date birthday;                  //	DATE
  String email;                 //	VARCHAR2(100 BYTE)
}

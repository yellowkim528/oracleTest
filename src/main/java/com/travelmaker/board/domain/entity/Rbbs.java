package com.travelmaker.board.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Rbbs {
  private Long rbbsId;  // RBBS_ID	NUMBER(10,0)
  private Long bbsId;  // BBS_ID	NUMBER(10,0)
  private Long managementId;  // MANAGEMENT_ID	NUMBER(10,0)
  private String nickname;  // NICKNAME	VARCHAR2(36 BYTE)
  private LocalDateTime cdate;  // CDATE	TIMESTAMP(6)
  private LocalDateTime udate;  // UDATE	TIMESTAMP(6)
  private String bContent;  // BCONTENT	CLOB
}

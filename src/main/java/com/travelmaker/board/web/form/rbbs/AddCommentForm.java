package com.travelmaker.board.web.form.rbbs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddCommentForm {
  private Long bbsId;  // BBS_ID	NUMBER(10,0)
  private Long managementId;  // MANAGEMENT_ID	NUMBER(10,0)
  private String nickname;  // NICKNAME	VARCHAR2(36 BYTE)
  private String bContent;  // BCONTENT	CLOB
}

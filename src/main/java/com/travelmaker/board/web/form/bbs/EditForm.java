package com.travelmaker.board.web.form.bbs;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class EditForm {
  private Long bbsId;
  private Long managementId;
  private String title;
  private String bContent;
  private Long planId;
}

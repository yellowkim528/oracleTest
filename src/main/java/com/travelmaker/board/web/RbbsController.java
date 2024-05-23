package com.travelmaker.board.web;

import com.travelmaker.board.domain.entity.Bbs;
import com.travelmaker.board.domain.entity.Rbbs;
import com.travelmaker.board.domain.rbbs.svc.RbbsSVC;
import com.travelmaker.board.web.form.rbbs.AddCommentForm;
import com.travelmaker.board.web.form.rbbs.EditCommentForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/{bbsId}/comment")
@RequiredArgsConstructor
public class RbbsController {

  private final RbbsSVC rbbsSVC;

  // 댓글 등록
  @PostMapping
  public ResponseEntity<String> addComment(
      @PathVariable("bbsId") Long bbsId,
      @RequestBody AddCommentForm addCommentForm) {
    Rbbs rbbs = new Rbbs();
    rbbs.setBbsId(bbsId);
    rbbs.setManagementId(addCommentForm.getManagementId());
    rbbs.setNickname(addCommentForm.getNickname());
    rbbs.setBContent(addCommentForm.getBContent());

    Long rbbsId = rbbsSVC.addRbbs(rbbs);

    return ResponseEntity.ok("등록완료");
  }

  // 댓글 목록
  @GetMapping
  public ResponseEntity<List<Rbbs>> listComment(
      @PathVariable("bbsId") Long bbsId) {
    log.info("bbsId={}",bbsId);

    List<Rbbs> list = rbbsSVC.findAll(bbsId);

    return ResponseEntity.ok(list);
  }

  // 댓글 수정
  @PatchMapping("/{rbbsId}")
  public ResponseEntity<String> editComment(
      @PathVariable("rbbsId") Long rbbsId,
      @RequestBody EditCommentForm editCommentForm
      ){
    Rbbs rbbs = new Rbbs();
    rbbs.setBContent(editCommentForm.getBContent());

    int isUpdated = rbbsSVC.updateById(rbbsId, rbbs);
    if (isUpdated==1) {
      return ResponseEntity.status(HttpStatus.OK).body("댓글 수정 완료");
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("댓글 수정 실패");
    }
  }

  // 댓글 삭제


}

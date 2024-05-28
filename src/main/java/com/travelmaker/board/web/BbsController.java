package com.travelmaker.board.web;

import com.travelmaker.board.domain.bbs.svc.BbsSVC;
import com.travelmaker.board.domain.entity.Bbs;
import com.travelmaker.board.domain.search.svc.SearchSVC;
import com.travelmaker.board.web.form.bbs.AddForm;
import com.travelmaker.board.web.form.bbs.EditForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
public class BbsController {

  private BbsSVC bbsSVC;
  private SearchSVC searchSVC;

  // 두 서비스를 모두 주입받는 단일 생성자
  public BbsController(BbsSVC bbsSVC, SearchSVC searchSVC) {
    this.bbsSVC = bbsSVC;
    this.searchSVC = searchSVC;
  }

  // 작성화면
  @GetMapping("/add")
  public String addForm(Model model) {
    model.addAttribute("addForm", new AddForm());
    return "board/boardAdd";
  }

  // 작성요청
  @PostMapping("/add")
  public ResponseEntity<String> add(@ModelAttribute
      AddForm addForm,
      Model model,
      RedirectAttributes redirectAttributes
  ) {

//    유효성검사자리 (몰?루)

    // 글 등록
    Bbs bbs = new Bbs();
    bbs.setManagementId(addForm.getManagementId());
    bbs.setTitle(addForm.getTitle());
    bbs.setNickname(addForm.getNickname());
    bbs.setBContent(addForm.getBContent());
    bbs.setPlanId(addForm.getPlanId());

    Long bbsId = bbsSVC.save(addForm.getCodeId(), bbs);


    String redirectUrl = "/board/" + bbsId + "/detail";
    return ResponseEntity.ok(redirectUrl);
  }

  // 자유게시판 목록
  @GetMapping("/free")
  public String findFreeAll(Model model) {
    List<Bbs> freeList = bbsSVC.findFreeAll();
    model.addAttribute("freeList", freeList);
    return "board/freeBoardList.html";
  }

  // 공유게시판 목록
  @GetMapping("/share")
  public String findShareAll(Model model) {
    List<Bbs> shareList = bbsSVC.findShareAll();
    model.addAttribute("shareList", shareList);
    return "board/shareBoardList.html";
  }

  // 자유게시판 검색
  @GetMapping("/free/search")
  public String freeSearch (
      @RequestParam("codeId") String codeId,
      @RequestParam("word") String word,
      Model model) {
    // 자유게시판 검색 결과
    List<Bbs> freeList = searchSVC.searchList(codeId, word);
    model.addAttribute("freeList", freeList);
    model.addAttribute("codeId", codeId);
    return "board/freeBoardList";
  }

  // 공유게시판 검색
  @GetMapping("/share/search")
  public String shareSearch(
      @RequestParam("codeId") String codeId,
      @RequestParam("word") String word,
      Model model) {
    // 공유게시판 검색 결과
    List<Bbs> shareList = searchSVC.searchList(codeId, word);
    model.addAttribute("shareList", shareList);
    model.addAttribute("codeId", codeId);
    return "board/shareBoardList";
  }


  // 조회
  @GetMapping("/{bbsId}/detail")
  public String findById(
      @PathVariable Long bbsId,
      Model model
  ) {

    Optional<Bbs> foundBbs = bbsSVC.findById(bbsId);
    Bbs bbs = foundBbs.orElseThrow();
    model.addAttribute("bbs", bbs);

    return "board/boardDetail.html";
  }

  // 삭제
  @PostMapping("/{bbsId}/del")
  public String delete(
      @PathVariable("bbsId") Long bbsId,
      RedirectAttributes redirectAttributes) {
    int deleteRowCnt = bbsSVC.deleteById(bbsId);

    redirectAttributes.addAttribute("bbsId", bbsId);
    return "redirect:/board";
  }

  // 수정 화면
  @GetMapping("{bbsId}/edit")
  public String editForm(
      @PathVariable Long bbsId,
      Model model
  ) {

    Optional<Bbs> bbs = bbsSVC.findById(bbsId);
    Bbs foundBbs = bbs.orElseThrow();

    model.addAttribute("bbs", foundBbs);
    return "board/boardEdit.html";
  }

  // 수정 처리
  @PostMapping("{bbsId}/edit")
  public String edit(
      @PathVariable("bbsId") Long bbsId,
      EditForm editForm,
      RedirectAttributes redirectAttributes,
      Model model
      ){

    // 글 수정
    Bbs bbs = new Bbs();
    bbs.setManagementId(editForm.getManagementId());
    bbs.setTitle(editForm.getTitle());
    bbs.setBContent(editForm.getBContent());
    bbs.setPlanId(editForm.getPlanId());

    int updateRowCnt = bbsSVC.updateById(bbsId, bbs);

    redirectAttributes.addAttribute("bbsId", bbsId);

    return "redirect:/board/{bbsId}/detail";
  }

}
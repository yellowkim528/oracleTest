package com.travelmaker.board.web;

import com.travelmaker.board.domain.bbs.svc.BbsSVC;
import com.travelmaker.board.domain.entity.Bbs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
public class BbsController {

  private BbsSVC bbsSVC;

  public BbsController(BbsSVC bbsSVC) {
    this.bbsSVC = bbsSVC;
  }

  @GetMapping("/")
  public String findAll(Model model) {
    List<Bbs> list = bbsSVC.findAll();
    model.addAttribute("list", list);
    return "/board/boardList";
  }

  @GetMapping("/{bbsId}/detail")
  public String findById(
      @PathVariable
      Long bbsId,
      Model model
  ) {
    Optional<Bbs> foundBbs = bbsSVC.findById(bbsId);
    Bbs bbs = foundBbs.orElseThrow();
    model.addAttribute("bbs", bbs);

    return "/board/boardDetail";
  }

}

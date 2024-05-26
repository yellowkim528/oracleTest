package com.travelmaker;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberRepository memberRepository;

  @GetMapping
  public String member(Model model){
    Optional<Member> result = memberRepository.findById(1L);
    model.addAttribute("members",result.get());
    return "member.html";

  }
}

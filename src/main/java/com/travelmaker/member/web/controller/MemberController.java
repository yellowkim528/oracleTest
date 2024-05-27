package com.travelmaker.member.web.controller;

import com.travelmaker.member.entity.Member;
import com.travelmaker.member.svc.MemberSVC;
import com.travelmaker.member.web.form.member.JoinForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/members")   // http://localhost:9080/members
@RequiredArgsConstructor
public class MemberController {

  private final MemberSVC memberSVC;

  // 회원가입 페이지
  @GetMapping("/join")      // http://localhost:9080/members/join
  public String joinForm() {
    return "join";
  }

  @PostMapping("/join")
  public String join(@ModelAttribute JoinForm joinForm) {
    log.info("join={}", joinForm);

    // codeId 기본 값 설정
    joinForm.setCodeId("M0101");

    // 회원 아이디를 설정
    String memberId = joinForm.getMemberId();

    // Member 객체 생성
    Member member = new Member();
    BeanUtils.copyProperties(joinForm, member);

    // 회원가입 서비스 호출
    Long managementId = memberSVC.joinMember(member);

    return (managementId != null) ? "redirect:/login" : "redirect:/members/join";
  }

}

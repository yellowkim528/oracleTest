package com.travelmaker.member.svc;

import com.travelmaker.member.entity.Member;

import java.util.Optional;

public interface MemberSVC {
  // 회원가입
  Long joinMember(Member member);

  // 회원 아이디 조회
  boolean existMemberId(String memberId);

  // 회원 조회
  Optional<Member> findByIdAndPw(String memberId, String pw);
  
  // 회원 수정
  
  // 회원 탈퇴

}

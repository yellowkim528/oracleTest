package com.travelmaker.member.dao;

import com.travelmaker.member.entity.Member;

import java.util.Optional;

public interface MemberDAO {

  // 회원가입
  Long inserMember(Member member);

  // 회원존재유무
  boolean existMemberId(String memberId);

  // 회원 조회
  Optional<Member> findByIdAndPw(String memberId, String pw);

//  //회원수정
//  int updateMember(String email, Member member);

//  //아이디찾기
//  Optional<String> findEmailByTel(String tel);
//
//  //비밀번호 유무확인
//  boolean hasPasswd(String email, String tel);
//
//  //비밀번호 변경
//  int changePasswd(String email, String passwd);
}

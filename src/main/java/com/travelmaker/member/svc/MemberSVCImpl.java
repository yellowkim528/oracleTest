package com.travelmaker.member.svc;

import com.travelmaker.member.dao.MemberDAO;
import com.travelmaker.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC{

  private final MemberDAO memberDAO;


  @Override
  public Long joinMember(Member member) {
    return memberDAO.inserMember(member);
  }

  @Override
  public boolean existMemberId(String memberId) {
    return memberDAO.existMemberId(memberId);
  }

  @Override
  public Optional<Member> findByIdAndPw(String memberId, String pw) {
    return memberDAO.findByIdAndPw(memberId, pw);
  }

}

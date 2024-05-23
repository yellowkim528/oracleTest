package com.travelmaker.board.domain.rbbs.svc;

import com.travelmaker.board.domain.entity.Rbbs;

import java.util.List;

public interface RbbsSVC {
  // 목록
  List<Rbbs> finaAll(Long bbsId);

  // 추가
  Long addRbbs(Rbbs rbbs);

  // 삭제
  int deleteById(Long rbbsId);

  // 수정
  int updateById(Long rbbsId, Rbbs rbbs);
}

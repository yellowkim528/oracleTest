package com.travelmaker.board.domain.bbs.svc;

import com.travelmaker.board.domain.entity.Bbs;

import java.util.List;
import java.util.Optional;

public interface BbsSVC {
  // 작성
  Long save(Bbs bbs);

  // 조회
  Optional<Bbs> findById(Long bbsId);

  // 수정
  int updateById(Long bbsId, Bbs bbs);

  // 삭제
  int deleteById(Long bbsId);

  // 목록
  List<Bbs> findAll();
}

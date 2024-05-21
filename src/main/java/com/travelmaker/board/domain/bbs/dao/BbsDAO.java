package com.travelmaker.board.domain.bbs.dao;

import com.travelmaker.board.domain.entity.Bbs;

import java.util.List;
import java.util.Optional;

public interface BbsDAO {
  // 작성
  Long save(Bbs bbs);

  // 조회
  Optional<Bbs> findById(Long bbsId);

  // 수정
  int updateById(Long postId, Bbs bbs);

  // 삭제
  int deleteById(Long bbsId);

  // 목록
  List<Bbs> findAll();
}

package com.travelmaker.board.domain.search.dao;

import com.travelmaker.board.domain.entity.Bbs;

import java.util.List;

public interface SearchDAO {
  // 자유게시판 목록
  List<Bbs> searchList(String codeId, String word);

}

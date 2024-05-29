package com.travelmaker.board.domain.search.dao;

import com.travelmaker.board.domain.entity.Bbs;

import java.util.List;

public interface SearchDAO {
  // 자유게시판 검색
  List<Bbs> searchList(String codeId, String word, int offset, int pageSize);

  // 자유게시판 페이징
  int countSearchResults(String codeId, String word);
}

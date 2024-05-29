package com.travelmaker.board.domain.search.svc;

import com.travelmaker.board.domain.entity.Bbs;
import com.travelmaker.board.domain.search.dao.SearchDAO;

import java.util.List;

public interface SearchSVC {

  List<Bbs> searchList(String codeId, String word, int offset, int pageSize);

  int countSearchResults(String codeId, String word);

}

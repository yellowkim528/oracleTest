package com.travelmaker.board.domain.search.dao;

import com.travelmaker.board.domain.entity.Bbs;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchDAOImpl implements SearchDAO {

  private final NamedParameterJdbcTemplate template;


  // 자유게시판
  @Override
  public List<Bbs> searchList(String codeId, String word) {

    StringBuffer sql = new StringBuffer();
    sql.append("    select *  ");
    sql.append("      from bbs ");
    sql.append("     where code_id = :codeId ");
    sql.append("       and title like :word ");
    sql.append("  order by bbs_id desc ");

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("word", "%" + word + "%")
        .addValue("codeId", codeId);

    List<Bbs> list = template.query(sql.toString(), param, BeanPropertyRowMapper.newInstance(Bbs.class));
    return list;
  }
}

package com.travelmaker.board.domain.bbs.dao;

import com.travelmaker.board.domain.entity.Bbs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BbsDAOImpl implements BbsDAO{
  private final NamedParameterJdbcTemplate template;

  @Override
  public Long save(Bbs bbs) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert ");
    return null;
  }

  // 조회
  @Override
  public Optional<Bbs> findById(Long bbsId) {
    StringBuffer sql = new StringBuffer();
    sql.append("select bbs_id, title, code_id, nickname, bcontent, status, hit, good, bad, plan_id, cdate, udate ");
    sql.append("  from bbs");
    sql.append(" where bbs_id = :bbsId");

    try{
      var map = Map.of("bbsId", bbsId);
      Bbs bbs = template.queryForObject(sql.toString(), map, BeanPropertyRowMapper.newInstance(Bbs.class));
      return Optional.of(bbs);
    } catch (EmptyResultDataAccessException e) {
      // 조회결과 X
      return Optional.empty();
    }
  }

  @Override
  public int updateById(Long postId, Bbs bbs) {
    return 0;
  }

  @Override
  public int deleteById(Long bbsId) {
    return 0;
  }

  // 목록
  @Override
  public List<Bbs> findAll() {
//    쿼리를 보내서 db로부터 게시글을 전부받아 반환하는 코드
    StringBuffer sql = new StringBuffer();
    sql.append("  select *  ");
    sql.append("    from bbs ");
    sql.append("order by bbs_id desc ");

    List<Bbs> list = template.query(sql.toString(), BeanPropertyRowMapper.newInstance(Bbs.class));
    return list;
  }
}

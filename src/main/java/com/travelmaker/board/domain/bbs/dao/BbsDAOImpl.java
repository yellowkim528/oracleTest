package com.travelmaker.board.domain.bbs.dao;

import com.travelmaker.board.domain.entity.Bbs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BbsDAOImpl implements BbsDAO{
  private final NamedParameterJdbcTemplate template;

  @Override
  public Long save(String codeId, Bbs bbs) {
    StringBuffer sql = new StringBuffer();
    sql.append(" insert into bbs( bbs_id, management_id, title, code_id, nickname, bcontent, status, hit, good, bad, plan_id ) ");
    sql.append("          values( bbs_bbs_id_seq.nextval ,:managementId, :title, :codeId, :nickname, :bContent, :status, :hit, :good, :bad, :planId ) ");

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("managementId", bbs.getManagementId())
        .addValue("title", bbs.getTitle())
        // F0101:자유게시판, F0102:공지사항, F0103:공유게시판
        .addValue("codeId", codeId)
        .addValue("nickname", bbs.getNickname())
        .addValue("bContent", bbs.getBContent())
        // D:삭제, W:경고, I:작성중, F:작성완료
        .addValue("status", "F")
        // 조회수 = 0
        .addValue("hit", 0)
        // 좋아요 = 0
        .addValue("good", 0)
        // 싫어요 = 0
        .addValue("bad", 0)
        .addValue("planId", bbs.getPlanId());

    KeyHolder keyHolder = new GeneratedKeyHolder();

    template.update(sql.toString(), param, keyHolder, new String[]{"bbs_id"});
    Long bbs_id = ((BigDecimal) keyHolder.getKeys().get("bbs_id")).longValue();

    return bbs_id;
  }

  // 조회
  @Override
  public Optional<Bbs> findById(Long bbsId) {
    // 쿼리문 작성
    StringBuffer sql = new StringBuffer();
    sql.append("select bbs_id, management_id, title, code_id, nickname, bcontent, status, hit, good, bad, plan_id, cdate, udate ");
    sql.append("  from bbs ");
    sql.append(" where bbs_id = :bbsId ");

    try{
      // 파라미터 변수에 값 매핑
      SqlParameterSource param = new MapSqlParameterSource()
          .addValue("bbsId", bbsId);
      Bbs bbs = template.queryForObject(sql.toString(), param, BeanPropertyRowMapper.newInstance(Bbs.class));
      // 조회결과 O
      return Optional.of(bbs);
    } catch (EmptyResultDataAccessException e) {
      // 조회결과 X
      return Optional.empty();
    }
  }

  // 수정
  @Override
  public int updateById(Long bbsId, Bbs bbs) {
    // 쿼리문 작성
    StringBuffer sql = new StringBuffer();
    sql.append("update bbs ");
    sql.append("   set title = :title, ");
    sql.append("       nickname = :nickname, ");
    sql.append("       bcontent = :bContent, ");
    sql.append("       udate = default ");
    sql.append("       plan_id = :planId");
    sql.append(" where bbs_id = :bbsId ");

    // 파라미터 변수에 값 매핑
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("title", bbs.getTitle())
        .addValue("nickname", bbs.getNickname())
        .addValue("bContent", bbs.getBContent())
        .addValue("bbsId", bbsId)
        .addValue("planId", bbs.getPlanId());
    
    // 수정된 행수 반환
    int updateRowCnt = template.update(sql.toString(), param);
    
    return updateRowCnt;
  }

  // 삭제
  @Override
  public int deleteById(Long bbsId) {
    StringBuffer sql = new StringBuffer();
    sql.append(" delete from bbs ");
    sql.append("  where bbs_id = :bbsId ");

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("bbs_id", bbsId);

    int deleteRowCnt = template.update(sql.toString(), param);

    return deleteRowCnt;
  }

  // 자유게시판 목록
  @Override
  public List<Bbs> findFreeAll() {
    // 쿼리를 보내서 db로부터 게시글을 전부받아 반환하는 코드
    StringBuffer sql = new StringBuffer();
    sql.append("    select *  ");
    sql.append("      from bbs ");
    sql.append("     where code_id = 'F0101' ");
    sql.append("  order by bbs_id desc ");

    List<Bbs> list = template.query(sql.toString(), BeanPropertyRowMapper.newInstance(Bbs.class));
    return list;
  }
  
  // 공유게시판 목록
  @Override
  public List<Bbs> findShareAll() {
    // 쿼리를 보내서 db로부터 게시글을 전부받아 반환하는 코드
    StringBuffer sql = new StringBuffer();
    sql.append("    select *  ");
    sql.append("      from bbs ");
    sql.append("     where code_id = 'F0103' ");
    sql.append("  order by bbs_id desc ");

    List<Bbs> list = template.query(sql.toString(), BeanPropertyRowMapper.newInstance(Bbs.class));
    return list;
  }
}

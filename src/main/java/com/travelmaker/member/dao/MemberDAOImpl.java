package com.travelmaker.member.dao;

import com.travelmaker.member.entity.Member;
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
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{

  private final NamedParameterJdbcTemplate template;

  // 회원가입
  @Override
  public Long inserMember(Member member) {
    // SQL 작성
    String sql = "INSERT INTO member (MANAGEMENT_ID, MEMBER_ID, PW, TEL, NICKNAME, " +
        "GENDER, ADDRESS, CODE_ID, BIRTHDAY, EMAIL) " +
        "VALUES (MEMBER_MANAGEMENT_ID.nextval, :memberId, :pw, :tel, :nickname, " +
        ":gender, :address, :codeId, :birthday, :email)";

    // 성별 매핑 (여자:f, 남자:m)
    String genderValue = null;
    if ("여".equals(member.getGender())) {
      genderValue = "f";
    } else if ("남".equals(member.getGender())) {
      genderValue = "m";
    } else {
      // 유효하지 않은 성별 값일 경우 처리
      // 여기에 예외 처리 또는 기본값 설정을 추가할 수 있습니다.
    }

    // 파라미터 확인 및 디버깅
    log.info("Inserting member: {}", member);

    // SQL 실행을 위한 매핑
    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("memberId", member.getMemberId())
        .addValue("pw", member.getPw())
        .addValue("tel", member.getTel())
        .addValue("nickname", member.getNickname())
        .addValue("gender", member.getGender())
        .addValue("address", member.getAddress())
        .addValue("codeId", member.getCodeId())
        .addValue("birthday", member.getBirthday())
        .addValue("email", member.getEmail());

    // 변경된 레코드 정보를 읽어오는 용도
    KeyHolder keyHolder = new GeneratedKeyHolder();

    // SQL 실행
    template.update(sql, param, keyHolder, new String[]{"MANAGEMENT_ID"});

    // Insert된 레코드에서 회원 번호 추출
    Long managementId = ((BigDecimal) keyHolder.getKeys().get("MANAGEMENT_ID")).longValue();

    log.info("Inserted member ID: {}", managementId);

    return managementId;
  }


  // 아이디 존재 유무
  @Override
  public boolean existMemberId(String memberId) {
    String sql = "select count(MEMBER_ID) from member where MEMBER_ID = :memberId ";

    Map param = Map.of("memberId", memberId);
    Integer cnt = template.queryForObject(sql, param, Integer.class);

    return cnt == 1 ? true : false;
  }

  // 회원 조회
  @Override
  public Optional<Member> findByIdAndPw(String memberId, String pw) {
    StringBuffer sql = new StringBuffer();
    sql.append("select * from member ");
    sql.append(" where MEMBER_ID = :memberId ");
    sql.append("   and PW = :pw ");

    Map param = Map.of("memberId", memberId, "pw", pw);
    try {
      Member member = template.queryForObject(sql.toString(), param, new BeanPropertyRowMapper<>(Member.class));
      return Optional.of(member);
    }catch(EmptyResultDataAccessException e){
      return Optional.empty();
    }
  }

//  //회원수정
//  @Override
//  public int updateMember(String email, Member member) {
//    StringBuffer sql = new StringBuffer();
//    sql.append("update member ");
//    sql.append("set tel = :tel, ");
//    sql.append("    nickname = :nickname, ");
//    sql.append("    gender = :gender, ");
//    sql.append("    hobby = :hobby, ");
//    sql.append("    region = :region ");
//    sql.append("where email = :email ");
//
//    SqlParameterSource parm = new MapSqlParameterSource()
//        .addValue("tel",member.getTel())
//        .addValue("nickname",member.getNickname())
//        .addValue("gender",member.getGender())
//        .addValue("hobby",member.getHobby())
//        .addValue("region",member.getRegion())
//        .addValue("email",email);
//
//    //rows : 업데이트된 레코드 수
//    int rows = template.update(sql.toString(), parm);
//
//    return rows;
//  }
//
//  //아이디찾기
//  @Override
//  public Optional<String> findEmailByTel(String tel) {
//    String sql = "select email from member where tel = :tel";
//
//    Map<String,String> param = Map.of("tel",tel);
//
//    try {
//      String email = template.queryForObject(sql, param, String.class);
//      return Optional.of(email);
//    } catch (EmptyResultDataAccessException e) {
//      return Optional.empty();
//    }
//  }
//
//  //비밀번호 유무확인
//  @Override
//  public boolean hasPasswd(String email, String tel) {
//    StringBuffer sql = new StringBuffer();
//    sql.append("select count(*) ");
//    sql.append("  from member ");
//    sql.append(" where email = :email ");
//    sql.append("   and tel = :tel ");
//
//    Map<String, String> param = Map.of("email", email, "tel", tel);
//    Integer cnt = template.queryForObject(sql.toString(), param, Integer.class);
//
//    return cnt == 1 ? true : false;
//  }
//
//  //비밀번호 변경
//  @Override
//  public int changePasswd(String email, String passwd) {
//    StringBuffer sql = new StringBuffer();
//    sql.append("update member ");
//    sql.append("   set passwd = :passwd ");
//    sql.append(" where email  = :email ");
//
//    Map<String, String> param = Map.of("passwd", passwd, "email", email);
//    int updatedRow = template.update(sql.toString(), param);
//    return updatedRow;
//  }
}

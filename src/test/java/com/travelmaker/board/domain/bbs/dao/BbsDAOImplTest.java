package com.travelmaker.board.domain.bbs.dao;

import com.travelmaker.board.domain.entity.Bbs;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class BbsDAOImplTest {

  @Autowired
  private BbsDAO bbsDAO;

  @Test
  void findById() {
    Long testBbsId = 1L;

    // BbsId =1 인 데이터 조회
    Optional<Bbs> bbsOptional = bbsDAO.findById(testBbsId);
    
    // 그 행이 존재하는지 확인
    assertThat(bbsOptional).isPresent();
    Bbs bbs = bbsOptional.get();
    // 그 행의 id가 1인지 확인
    assertThat(bbs.getBbsId()).isEqualTo(testBbsId);
  }

  @Test
  void findAll() {
    List<Bbs> bbsAll = bbsDAO.findFreeAll();
    assertThat(bbsAll).isNotEmpty();

    bbsAll.forEach(System.out::println);
  }
}
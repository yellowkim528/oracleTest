package com.travelmaker.board.domain.rbbs.dao;

import com.travelmaker.board.domain.entity.Rbbs;
import com.travelmaker.board.domain.rbbs.svc.RbbsSVC;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class RbbsDAOImplTest {

  @Autowired
  RbbsDAO rbbsDAO;
  @Test
  void findAll() {
    List<Rbbs> rbbsAll = rbbsDAO.findAll(1L);
    assertThat(rbbsAll).isNotEmpty();

    rbbsAll.forEach(System.out::println);
  }
}
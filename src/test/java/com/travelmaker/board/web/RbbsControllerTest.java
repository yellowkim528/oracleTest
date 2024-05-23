package com.travelmaker.board.web;

import com.travelmaker.board.domain.entity.Rbbs;
import com.travelmaker.board.domain.rbbs.svc.RbbsSVC;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RbbsControllerTest {

  @Autowired
  RbbsSVC rbbsSVC;

  @Test
  void listComment() {



    List<Rbbs> list = rbbsSVC.findAll(1L);
    ResponseEntity<List<Rbbs>> result = ResponseEntity.ok(list);
    System.out.println(result);


  }
}
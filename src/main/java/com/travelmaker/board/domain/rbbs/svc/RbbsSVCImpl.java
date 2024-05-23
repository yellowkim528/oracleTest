package com.travelmaker.board.domain.rbbs.svc;

import com.travelmaker.board.domain.entity.Rbbs;
import com.travelmaker.board.domain.rbbs.dao.RbbsDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RbbsSVCImpl implements RbbsSVC{

  private RbbsDAO rbbsDAO;

  @Override
  public List<Rbbs> findAll(Long rbbsId) {
    return rbbsDAO.findAll(rbbsId);
  }

  @Override
  public Long addRbbs(Rbbs rbbs) {
    return rbbsDAO.addRbbs(rbbs);
  }

  @Override
  public int deleteById(Long rbbsId) {
    return rbbsDAO.deleteById(rbbsId);
  }

  @Override
  public int updateById(Long rbbsId, Rbbs rbbs) {
    return rbbsDAO.updateById(rbbsId, rbbs);
  }
}

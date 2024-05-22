package com.travelmaker.board.domain.bbs.svc;

import com.travelmaker.board.domain.bbs.dao.BbsDAO;
import com.travelmaker.board.domain.entity.Bbs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BbsSVCImpl implements BbsSVC {

  private BbsDAO bbsDAO;

  public BbsSVCImpl(BbsDAO bbsDAO) {
    this.bbsDAO = bbsDAO;
  }

  @Override
  public Long save(String codeId, Bbs bbs) {
    return bbsDAO.save(codeId, bbs);
  }

  @Override
  public Optional<Bbs> findById(Long bbsId) {
    return bbsDAO.findById(bbsId);
  }

  @Override
  public int updateById(Long bbsId, Bbs bbs) {
    return bbsDAO.updateById(bbsId, bbs);
  }

  @Override
  public int deleteById(Long bbsId) {
    return bbsDAO.deleteById(bbsId);
  }

  @Override
  public List<Bbs> findFreeAll() {
    return bbsDAO.findFreeAll();
  }

  @Override
  public List<Bbs> findShareAll() {
    return bbsDAO.findShareAll();
  }
}

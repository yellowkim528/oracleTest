//package com.travelmaker.board.web;
//
//import com.travelmaker.board.domain.entity.Rbbs;
//import com.travelmaker.board.domain.rbbs.svc.RbbsSVC;
//import com.travelmaker.board.web.api.ApiResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RestController
//@RequestMapping
//@RequiredArgsConstructor
//public class RbbsController {
//
//  private final RbbsSVC rbbsSVC;
////
//  // 댓글 등록
//  @PostMapping
//  public ApiResponse<?> add(
//      @RequestBody ReqAdd reqAdd) {
//
//    Reply reply = new Reply();
//    BeanUtils.copyProperties(reqAdd, reply);
//    Long replyId = replySVC.addReply(reply);
//
//    ResAdd resAdd = new ResAdd(replyId, reqAdd.getReplyBody());
//    ApiResponse<ResAdd> res = ApiResponse.createApiResponse(ResCode.OK.getCode(), ResCode.OK.name(), resAdd);
//
//    return res;
//
//    // ...
//  }

//  // 댓글 목록
//  @GetMapping
//  public ApiResponse<?> findAll(@PathVariable("pid") Long postId) {
//    List<Reply> list = replySVC.findAll(postId);
//
//    ApiResponse<List<Reply>> res = null;
//    res = ApiResponse.createApiResponse(ResCode.OK.getCode(), ResCode.OK.name(), list);
//
//    return res;
//  }
//
//  // 댓글 수정
//  @PatchMapping("/{rid}")
//  public ApiResponse<?> update(
//      @PathVariable("rid") Long replyId,
//      @RequestBody ReqUpdate reqUpdate) {
//
//    Reply reply = new Reply();
//    BeanUtils.copyProperties(reqUpdate, reply);
//
//    int updatedCnt = replySVC.updateById(replyId, reply);
//    ApiResponse<ResUpdate> res = null;
//    if(updatedCnt == 1) {
//      ResUpdate resUpdate = new ResUpdate();
//      BeanUtils.copyProperties(reqUpdate, resUpdate);
//      res = ApiResponse.createApiResponse(ResCode.OK.getCode(), ResCode.OK.name(), resUpdate);
//    } else {
//      res = ApiResponse.createApiResponse(ResCode.FAIL.getCode(), ResCode.FAIL.name(), null);
//    }
//    // ...
//    return res;
//  }
//
//  // 댓글 삭제
//  @DeleteMapping("/{rid}")
//  public ApiResponse<?> delete(
//      @PathVariable("rid") Long replyId) {
//    int deletedCnt = replySVC.deleteById(replyId);
//    ApiResponse<ResUpdate> res = null;
//
//    if(deletedCnt == 1){
//      res = ApiResponse.createApiResponse(ResCode.OK.getCode(), ResCode.OK.name(), null);
//    }else{
//      res = ApiResponse.createApiResponse(ResCode.FAIL.getCode(), ResCode.FAIL.name(), null);
//    }
//    return res;
//  }
//
//
//}

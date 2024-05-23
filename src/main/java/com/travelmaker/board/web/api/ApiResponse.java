package com.travelmaker.board.web.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponse<T> {
  private Header header;
  private T body;
  private int totalCnt = 1;
  private int recCnt = 1;
  private int reqPage = 1;

  public ApiResponse(Header header, T body) {
    this.header = header;
    this.body = body;
  }

  @Getter
  @ToString
  @AllArgsConstructor
  private static class Header{
    String rtcd;
    String rtmsg;
    String rtdetail;

    public Header(String rtcd, String rtmsg) {
      this.rtcd = rtcd;
      this.rtmsg = rtmsg;
    }
  }
  public static <T> ApiResponse<T> createApiResponse(String rtcd, String rtmsg, T body) {
    return new ApiResponse<T>(new Header(rtcd, rtmsg), body);
  }

  public static <T> ApiResponse<T> createApiResponseDetail(String rtcd, String rtmsg, T body, String rtdetail) {
    return new ApiResponse<T>(new Header(rtcd, rtmsg, rtdetail), body);
  }

  public void setTotalCnt(int totalCnt) {
    this.totalCnt = totalCnt;
  }

  public void setRecCnt(int recCnt) {
    this.recCnt = recCnt;
  }

  public void setReqPage(int reqPage) {
    this.reqPage = reqPage;
  }
}

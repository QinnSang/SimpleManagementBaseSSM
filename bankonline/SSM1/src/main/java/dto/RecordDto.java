package dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RecordDto {

    private String cardNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date end;
    //页面大小
    private int pageSize;
    //起始页面
    private int pageNum;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}

package pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Answer {

    private long id;
    private String ansContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ansDate;
    private long qid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnsContent() {
        return ansContent;
    }

    public void setAnsContent(String ansContent) {
        this.ansContent = ansContent;
    }

    public Date getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }


    public long getQid() {
        return qid;
    }

    public void setQid(long qid) {
        this.qid = qid;
    }
}

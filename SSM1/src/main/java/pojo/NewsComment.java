package pojo;

import java.util.Date;

public class NewsComment {

    private Integer id;
    private NewsDetail newsDetail;
    private String content;
    private String author;
    private Date createdate;

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NewsDetail getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(NewsDetail newsDetail) {
        this.newsDetail = newsDetail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public NewsComment() {
    }
}

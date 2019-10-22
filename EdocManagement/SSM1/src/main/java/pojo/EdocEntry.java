package pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EdocEntry {
    private Integer id;
    private EdocCategory edocCategory;
    private String title;
    private String summary;
    private String uploadUser;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EdocCategory getEdocCategory() {
        return edocCategory;
    }

    public void setEdocCategory(EdocCategory edocCategory) {
        this.edocCategory = edocCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}

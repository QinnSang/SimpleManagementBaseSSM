package pojo;

import java.util.List;

public class EdocCategory {
    private Integer id;
    private String name;
    private List<EdocEntry> entryList;

    public List<EdocEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<EdocEntry> entryList) {
        this.entryList = entryList;
    }

    public EdocCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

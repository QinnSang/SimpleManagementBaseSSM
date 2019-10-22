package service;

import org.springframework.beans.factory.annotation.Autowired;
import pojo.EdocEntry;

import java.util.List;

public interface EdocEntryService {

    List<EdocEntry> getAll();

    List<EdocEntry> queryByCateId(int id);

    boolean addEntry(EdocEntry entry);

    boolean deleteEntry(int entryId);

    EdocEntry queryByEntryId(int entryId);

    boolean modifyEntry(EdocEntry entry);
}

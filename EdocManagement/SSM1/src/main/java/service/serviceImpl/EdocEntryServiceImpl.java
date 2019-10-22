package service.serviceImpl;

import mapper.EdocEntryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EdocEntry;
import service.EdocEntryService;

import java.util.List;

@Service("edocEntryService")
public class EdocEntryServiceImpl  implements EdocEntryService {

    @Autowired
    private EdocEntryMapper entryMapper;

    @Override
    public List<EdocEntry> getAll() {
        return entryMapper.getAll();
    }

    @Override
    public List<EdocEntry> queryByCateId(int id) {
        return entryMapper.queryByCateId(id);
    }

    @Override
    public boolean addEntry(EdocEntry entry) {
        return entryMapper.addEntry(entry)==1?true:false;
    }

    @Override
    public boolean deleteEntry(int entryId) {
        return entryMapper.deleteEntry(entryId)==1?true:false;
    }

    @Override
    public EdocEntry queryByEntryId(int entryId) {
        return entryMapper.queryByEntryId(entryId);
    }

    @Override
    public boolean modifyEntry(EdocEntry entry) {
        if(entry.getId()==null||entry.getId()==0)
            return false;
        return entryMapper.updateEntry(entry)==1?true:false;
    }
}

package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.EdocEntry;

import java.util.List;

@Mapper
public interface EdocEntryMapper {
    List<EdocEntry> getAll();

    List<EdocEntry> queryByCateId(@Param("id")int id);

    int addEntry(EdocEntry entry);

    int deleteEntry(@Param("entryId") int entryId);

    EdocEntry queryByEntryId(@Param("entryId")int entryId);

    int updateEntry(EdocEntry entry);
}

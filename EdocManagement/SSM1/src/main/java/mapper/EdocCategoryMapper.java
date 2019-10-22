package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.EdocCategory;

import java.util.List;

@Mapper
public interface EdocCategoryMapper {
    List<EdocCategory> getAll();
}

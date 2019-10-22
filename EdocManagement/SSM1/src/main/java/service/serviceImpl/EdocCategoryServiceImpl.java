package service.serviceImpl;

import mapper.EdocCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EdocCategory;
import service.EdocCategoryService;

import java.util.List;

@Service("edocCategoryService")
public class EdocCategoryServiceImpl implements EdocCategoryService {

    @Autowired
    private EdocCategoryMapper categoryMapper;

    @Override
    public List<EdocCategory> getALl() {
        return categoryMapper.getAll();
    }
}

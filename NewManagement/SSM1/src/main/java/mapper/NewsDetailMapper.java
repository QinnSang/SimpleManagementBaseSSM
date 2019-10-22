package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.NewsDetail;

import java.util.List;

public interface NewsDetailMapper {
    List<NewsDetail> getAllNews();

    List<NewsDetail> queryNewsByName(@Param("title") String title);

    int deleteById(@Param("newsid") int newsid);
}

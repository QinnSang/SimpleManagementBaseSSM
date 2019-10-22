package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.NewsComment;

import java.util.List;

public interface NewsCommentMapper {
    List<NewsComment> queryComment(@Param("newsid") int newsid);

    int addComment(NewsComment newsComment);

    void deleteById(@Param("newsid")int newsid);
}

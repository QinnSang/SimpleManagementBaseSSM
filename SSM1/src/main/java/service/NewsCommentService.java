package service;

import pojo.NewsComment;

import java.util.List;

public interface NewsCommentService {
    List<NewsComment> queryComment(int newsid);

    Boolean addComment(NewsComment newsComment);
}

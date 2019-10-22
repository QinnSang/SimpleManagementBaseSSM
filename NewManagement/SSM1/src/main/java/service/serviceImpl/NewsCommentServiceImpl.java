package service.serviceImpl;

import mapper.NewsCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.NewsComment;
import service.NewsCommentService;
import service.NewsDetailService;

import java.util.Date;
import java.util.List;

@Service("newsCommentService")
public class NewsCommentServiceImpl implements NewsCommentService {

    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Override
    public List<NewsComment> queryComment(int newsid) {
        return newsCommentMapper.queryComment(newsid);
    }

    @Override
    public Boolean addComment(NewsComment newsComment) {
        newsComment.setCreatedate(new Date());
        return newsCommentMapper.addComment(newsComment)==1?true:false;
    }
}

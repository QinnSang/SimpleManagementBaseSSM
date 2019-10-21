package service.serviceImpl;

import mapper.NewsCommentMapper;
import mapper.NewsDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.NewsDetail;
import service.NewsDetailService;

import java.util.List;

@Service("newsDetailService")
public class NewsDetailServiceImpl implements NewsDetailService {

    @Autowired
    private NewsDetailMapper newsDetailMapper;

    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Override
    public List<NewsDetail> getALlNews() {
        List<NewsDetail> list=newsDetailMapper.getAllNews();
        return list;
    }

    @Override
    public List<NewsDetail> queryNewsByName(String title) {
        return newsDetailMapper.queryNewsByName(title);
    }

    @Override
    public boolean deleteById(int newsid) {
        newsCommentMapper.deleteById(newsid);
        int row=newsDetailMapper.deleteById(newsid);
        return row==1?true:false;
    }


}

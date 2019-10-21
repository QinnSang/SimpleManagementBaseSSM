package service;

import pojo.NewsDetail;

import java.util.List;

public interface NewsDetailService {
    List<NewsDetail> getALlNews();

    List<NewsDetail> queryNewsByName(String title);

    boolean deleteById(int newsid);
}

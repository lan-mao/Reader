import com.alibaba.fastjson.JSONObject;
import dao.DaoFactory;
import dao.RedisDao;
import dao.WebsiteConfigDao;
import dao.WebsiteNovelDao;
import dbc.ConnectFactory;
import entity.*;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;
import spider.PageParse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * create at 2019-05-11 by MaXin
 */
public class Test {

    public static void main(String[] args) throws Exception {
//        Jedis jedis = ConnectFactory.connectRedis();
//        RedisDao redis = DaoFactory.getRedisDao(jedis);
//        SqlSession session = ConnectFactory.connectMysql();
//        WebsiteConfigDao websiteConfigDao = DaoFactory.getWebsiteConfigDao(session);
//        WebsiteConfigPO websiteConfigPO = websiteConfigDao.findByID(9L);
//        redis.deleteAllPage(websiteConfigPO.getWebsiteId());
//        redis.deleteAllNovel(websiteConfigPO.getWebsiteId());
//        PageParse pageParse = new PageParse(websiteConfigPO);
//        NovelDTO novelDTO = pageParse.getNovelDTO("https://m.biquge.info/10_10972/");
//        List<ChapterDTO> list = novelDTO.getChapter();
//        System.out.println(list.size());
//        String json = JSONObject.toJSONString(list);
//        System.out.println(json);
//        WebsiteNovelDao dao = DaoFactory.getWebsiteNovelDao(9l, session);
//        WebsiteNovelPO websiteNovelPO = new WebsiteNovelPO();
//        websiteNovelPO.setWebsiteNovelId(586l);
//        websiteNovelPO.setNovelId(38017L);
//        websiteNovelPO.setChapter(json);
//        websiteNovelPO.setGmtCreate(new java.sql.Date(new java.util.Date().getTime()));
//        websiteNovelPO.setGmtModified(new java.sql.Date(new java.util.Date().getTime()));
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://39.96.170.153:3306/book?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "Yeyue19961016.");
        String sql = "select chapter from website_novel_9 where novel_id=38017";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();
        String result = resultSet.getString(1);
        System.out.println(result);
        ps.executeUpdate();
        connection.close();
//        session.close();
    }

//    public static void main(String[] args) throws IOException {
//        String url = "https://www.51test.net/show/8797910.html";
//        Document document = Jsoup.parse(new URL(url), 10000);
//        Elements elements = document.select("html > body > div.container > div.main-bg > div.content-fl > div.content-text > p");
//        System.out.println(elements.size());
//        String html = elements.outerHtml();
//        System.out.println(html);
//    }
}

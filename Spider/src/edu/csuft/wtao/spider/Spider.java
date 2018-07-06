package edu.csuft.wtao.spider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 爬虫
 * 
 * @author wtao
 *
 */
public class Spider {

	/**
	 * 目标页面
	 */
	String url;

	/**
	 * 存储所有影片的列表
	 */
	List<Film> filmList = new ArrayList<>();

	/**
	 * 爬虫的构造方法
	 * 
	 * @param url 目标页面
	 */
	public Spider(String url) {
		this.url = url;
	}

	/**
	 * 执行
	 */
	public void run() {
		// 抓去数据

		try {
			Document doc = Jsoup.connect(url).get();

//			System.out.println(doc.title());
//			System.out.println(doc.text());
//			System.out.println(doc.html());

			Elements items = doc.select(".grid_view .item");
			System.out.println(items.size());

			// 遍历
			for (Element item : items) {
				Film film = new Film();
				
				film.title = item.select(".title").get(0).text();
				film.poster = item.select("img").get(0).attr("src");
				film.info = item.select(".info .bd p").get(0).text();
				film.quote = item.select("p").get(1).text();
				film.rating = item.select(".star span").last().text();
				String num = item.select(".rating_num").first().text();
				String id = item.select(".pic em").first().text();
				film.id = Integer.parseInt(id);
				film.star = Double.parseDouble(num);
				
				System.out.println(film);
				filmList.add(film);
			}
			
			
			// 存储到数据库
			
			// 建立连接
			SqlSessionFactory factory = 
					new SqlSessionFactoryBuilder().build(
							new FileReader("config.xml"));
			
			SqlSession session = factory.openSession();
			
			// 获得了接口的具体实现（反射）
			FilmMapper mapper = session.getMapper(FilmMapper.class);
			
			for (Film f : filmList) {
				mapper.insert(f);
			}
			session.commit();
			session.close();
			System.out.println("存储成功");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

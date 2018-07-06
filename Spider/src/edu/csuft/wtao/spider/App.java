package edu.csuft.wtao.spider;

/**
 * 爬虫程序的启动器
 * 
 * @author wtao
 *
 */
public class App {

	// alt + /
	public static void main(String[] args) {
		
		Spider spider = new Spider("https://movie.douban.com/top250?start=100");
		spider.run();
		
	}
	
}

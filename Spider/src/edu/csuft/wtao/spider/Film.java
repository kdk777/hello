package edu.csuft.wtao.spider;

/**
 * 影片的信息（实体类）
 * 
 * @author wtao
 *
 */
public class Film {

	/**
	 * 排名
	 */
	int id;

	/**
	 * 片名
	 */
	String title;

	/**
	 * 导演、主演
	 */
	String info;

	/**
	 * 评分
	 */
	double star;

	/**
	 * 评价
	 */
	String rating;

	/**
	 * 海报路径
	 */
	String poster;

	/**
	 * 概要
	 */
	String quote;

	public Film() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", info=" + info + ", star=" + star + ", rating=" + rating
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}

}

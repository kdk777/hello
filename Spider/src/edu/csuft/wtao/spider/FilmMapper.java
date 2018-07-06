package edu.csuft.wtao.spider;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// 注解
@Mapper
public interface FilmMapper {

	@Insert("insert into films(id,title,star,rating,info,poster,quote) values(#{id},#{title},#{star},#{rating},#{info},#{poster},#{quote})")
	void insert(Film m);

	// 反射（黑魔法）
	@Select("select * from films where id=#{pk}")
	Film load(int pk);

	@Select("select * from films")
	List<Film> find();

}

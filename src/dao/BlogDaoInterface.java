package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

public interface BlogDaoInterface{
	void insertBlog(Blog blog) throws ClassNotFoundException, SQLException ;
	@SuppressWarnings("rawtypes")
	List selectAllBlogs(); 
}
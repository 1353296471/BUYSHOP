package cn.com.single.DAO;

import java.util.List;

import cn.com.single.entity.Comment;

public interface ProCommentDAO {
	public List<Comment> findAllComment();

	public List<Comment> findByProPkid(int proPkid);

	public int commentCount(int proId);
}

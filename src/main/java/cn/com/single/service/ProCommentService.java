package cn.com.single.service;

import java.util.List;

import cn.com.single.entity.Comment;

public interface ProCommentService {
	public List<Comment> findByProPkid(int proPkid);

	public int commentCount(int proId);
}

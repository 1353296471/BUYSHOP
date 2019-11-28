package cn.com.single.service.Impl;

import java.util.List;

import cn.com.single.DAO.ProCommentDAO;
import cn.com.single.DAO.Impl.ProCommentDAOImpl;
import cn.com.single.entity.Comment;
import cn.com.single.service.ProCommentService;

public class ProCommentServiceImpl implements ProCommentService {
	private ProCommentDAO commentDAO = new ProCommentDAOImpl();

	@Override
	public int commentCount(int proId) {
		return this.commentDAO.commentCount(proId);
	}

	@Override
	public List<Comment> findByProPkid(int proPkid) {
		return this.commentDAO.findByProPkid(proPkid);
	}

}

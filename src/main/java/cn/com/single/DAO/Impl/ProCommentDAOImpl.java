package cn.com.single.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.single.DAO.ProCommentDAO;
import cn.com.single.db.DBConnection;
import cn.com.single.entity.Comment;

public class ProCommentDAOImpl implements ProCommentDAO {
	DBConnection DBConn = DBConnection.getInstance();

	@Override
	public int commentCount(int proId) {
		int count = 0;
		Connection conn = DBConn.getDBConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select commentDes from comment where proPkid=? ";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, proId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstm, rs);
		}
		return count;
	}

	@Override
	public List<Comment> findByProPkid(int proPkid) {
		List<Comment> commentList = null;
		Comment comment = null;
		Connection conn = DBConn.getDBConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from comment where proPkid=? order by commentTime desc";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, proPkid);
			rs = pstm.executeQuery();
			commentList = new ArrayList<Comment>();
			while (rs.next()) {
				comment = new Comment();
				comment.setProPkid(rs.getInt("proPkid"));
				comment.setCommentDes(rs.getString("commentDes"));
				comment.setCommentTime(rs.getString("commentTime"));
				comment.setUserPkid(rs.getInt("userPkid"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstm, rs);
		}
		return commentList;
	}

	@Override
	public List<Comment> findAllComment() {
		List<Comment> commentList = null;
		Comment comment = null;
		Connection conn = DBConn.getDBConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from comment order by commentTime desc ";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			commentList = new ArrayList<Comment>();
			while (rs.next()) {
				comment = new Comment();
				comment.setProPkid(rs.getInt("proPkid"));
				comment.setCommentDes(rs.getString("commentDes"));
				comment.setCommentTime(rs.getString("commentTime"));
				comment.setUserPkid(rs.getInt("userPkid"));
				commentList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstm, rs);
		}
		return commentList;
	}

}

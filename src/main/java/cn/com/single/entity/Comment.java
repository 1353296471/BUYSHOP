package cn.com.single.entity;

public class Comment {
	private int proPkid;
	private String commentDes;
	private int userPkid;
	private String commentTime;

	public int getUserPkid() {
		return userPkid;
	}

	public void setUserPkid(int userPkid) {
		this.userPkid = userPkid;
	}

	public int getProPkid() {
		return proPkid;
	}

	public void setProPkid(int proPkid) {
		this.proPkid = proPkid;
	}

	public String getCommentDes() {
		return commentDes;
	}

	public void setCommentDes(String commentDes) {
		this.commentDes = commentDes;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

}

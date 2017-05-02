package com.Blog.posts.model;

import java.util.Date;

public class Comment_model {
private String comment_id;
private String comment_content;
private int likes;
private int shares;
private Date date_of_comment;
private String userName;
private String postId;
public String getPostId() {
	return postId;
}
public void setPostId(String postId) {
	this.postId = postId;
}
public String getComment_id() {
	return comment_id;
}
public void setComment_id(String comment_id) {
	this.comment_id = comment_id;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getComment_content() {
	return comment_content;
}
public void setComment_content(String comment_content) {
	this.comment_content = comment_content;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public int getShares() {
	return shares;
}
public void setShares(int shares) {
	this.shares = shares;
}
public Date getDate_of_comment() {
	return date_of_comment;
}
public void setDate_of_comment(Date date_of_comment) {
	this.date_of_comment = date_of_comment;
}
@Override
public String toString(){
	return comment_content+","+userName+","+postId+","+likes+","+shares+"";
}
}


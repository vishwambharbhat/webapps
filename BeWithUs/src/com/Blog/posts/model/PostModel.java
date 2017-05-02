package com.Blog.posts.model;

import java.util.Date;
import java.util.List;

public class PostModel {
private String post_id;

private String post_title;
private String post_content;
private Date date_of_post;
private int likes;
private int shares;
private String user_name;
private List<String> commentsIds;
private List<Comment_model> comments;

public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPost_title() {
	return post_title;
}
public void setPost_title(String post_title) {
	this.post_title = post_title;
}
public String getPost_content() {
	return post_content;
}
public void setPost_content(String post_content) {
	this.post_content = post_content;
}
public Date getDate_of_post() {
	return date_of_post;
}
public void setDate_of_post(Date date_of_post) {
	this.date_of_post = date_of_post;
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
public List<Comment_model> getComments() {
	return comments;
}
public void setComments(List<Comment_model> comments) {
	this.comments = comments;
}
public List<String> getCommentsIds() {
	return commentsIds;
}
public void setCommentsIds(List<String> commentsIds) {
	this.commentsIds = commentsIds;
}
public String getPost_id() {
	return post_id;
}
public void setPost_id(String post_id) {
	this.post_id = post_id;
}
@Override
 public String toString(){
	return post_title+","+post_content+","+date_of_post+","+user_name+","+comments;
}
}

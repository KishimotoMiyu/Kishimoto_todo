package model;

import java.io.Serializable;

public class Task implements Serializable {
	
	
	private int taskNo;
	private String userName;
	private String userId;
	private String task;	
	private String importance;
	private String date;
	private String deadline;

	private String mypageUserName;
	private String profile;
	private String birthday;
	
	public Task() {}
	
	public Task(int taskNo, String userId ,String task ,String date , String deadline , String importance ){
		this.userId = userId;
		this.task = task;
		this.taskNo = taskNo;
		this.importance = importance;
		this.deadline = deadline;
		this.date = date;
	}
	
	public Task(String userId  ,String userName ,String profile ,String birthday ){
		
		this.mypageUserName = userName;
		this.userId = userId;
		this.birthday = birthday;
		this.profile = profile;
		
	}
	
	// getter
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getUserId() {
		return this.userId;
	}
		
	public int getTaskNo() {
		return this.taskNo;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getMypageUserName() {
		return this.mypageUserName;
	}
	
	public String getProfile() {
		return this.profile;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	
	public String getTask() {
		return this.task;
	}
	
	public String getDeadline() {
		return this.deadline;
	}
	
	public String getImportance() {
		return this.importance;
	}
	
	//setter

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
		
	public void setTaskNo(int taskNo) {
		this.taskNo = taskNo;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public void setImportance(String importance) {
		this.importance = importance;
	}
	
	
	public void setMypageUserName(String un) {
		this.mypageUserName = un;
	}
	
	public void setProfile(String pr) {
		this.profile = pr;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}

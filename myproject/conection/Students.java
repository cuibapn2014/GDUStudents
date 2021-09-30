package com.myproject.conection;

import java.util.*;
import java.text.*;

public class Students {
	private String fullname;
	private String username;
	private String password;
	private String gender;
	private String email;
	private String address;
	private String level;

	public Students() {
	};

	public Students(String fullname, String username, String password, String gender, String email, String address,
			String level) {
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.level = level;
	}

	protected String getFullname() {
		return fullname;
	}

	protected void setFullname(String fullname) {
		this.fullname = fullname;
	}

	protected String getUsername() {
		return username;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected String getGender() {
		return gender;
	}

	protected void setGender(String gender) {
		this.gender = gender;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	protected String getLevel() {
		return level;
	}

	protected void setLevel(String level) {
		this.level = level;
	}

	public void inputST() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập tên:");
		fullname = input.nextLine();
		System.out.println("Nhập tài khoản:");
		username = input.nextLine();
		System.out.println("Nhập mật khẩu:");
		password = input.nextLine();
		System.out.println("Nhập giới tính:");
		gender = input.nextLine();
		System.out.println("Nhập địa chỉ:");
		address = input.nextLine();
		System.out.println("Nhập email:");
		email = input.nextLine();
		System.out.println("Nhập trình độ:");
		level = input.nextLine();
		input.nextLine();
	}

	public void outputST() {
		System.out.println("id:");
		System.out.println("Họ tên: " + this.getFullname());
		System.out.println("Tài khoản: " + this.getUsername());
		System.out.println("Mật khẩu: " + this.getPassword());
		System.out.println("Giới tính: " + this.getGender());
		System.out.println("Địa chỉ: " + this.getAddress());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Trình độ: " + this.getLevel());
	}
}

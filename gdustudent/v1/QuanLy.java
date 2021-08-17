package com.gdustudent.v1;

import java.util.List;

public abstract class QuanLy<T> {
	private List ds;

	public QuanLy() {

	}

	public QuanLy(List ds) {
		this.ds = ds;
	}

	public abstract void them(T object);

	public abstract void chinhSua(T object);

	public abstract void xoa(T object);

	public abstract void timKiem(T object);

	protected List getDs() {
		return ds;
	}

	protected void setDs(List ds) {
		this.ds = ds;
	}

}

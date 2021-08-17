package com.gdustudent.v1;

import java.util.List;

public abstract class QuanLy<T> {
	public QuanLy() {

	}

	public abstract void them(T object);

	public abstract void chinhSua(T object);

	public abstract void xoa(T object);

	public abstract void timKiem(T object);

}

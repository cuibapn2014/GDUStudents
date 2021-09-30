package com.gdustudent.v1;

import java.util.List;

public abstract class QuanLy<T> {
	public QuanLy() {

	}

	public abstract List<T> hienThiDS();

	protected abstract void them(T object);

	protected abstract void chinhSua(T object);

	public abstract void xoa(T object);

	public abstract List<T> timKiem(T object);

}

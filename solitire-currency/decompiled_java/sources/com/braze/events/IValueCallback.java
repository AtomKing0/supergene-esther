package com.braze.events;

/* JADX INFO: loaded from: classes2.dex */
public interface IValueCallback<T> {
    void onError();

    void onSuccess(T t10);
}

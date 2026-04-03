package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public enum tr {
    LoadSuccess(0),
    ShowSuccess(1),
    ShowFailed(2),
    Destroyed(3),
    LoadRequest(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15474a;

    tr(int i10) {
        this.f15474a = i10;
    }

    public final int b() {
        return this.f15474a;
    }
}

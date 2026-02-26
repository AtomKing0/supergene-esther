package com.ironsource;

import com.ironsource.lg;

/* JADX INFO: loaded from: classes4.dex */
public class gr implements lg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12337b;

    public gr(String str, int i10) {
        this.f12336a = str;
        this.f12337b = i10;
    }

    @Override // com.ironsource.lg.b
    public int b() {
        return this.f12337b;
    }

    @Override // com.ironsource.lg.b
    public String c() {
        return this.f12336a;
    }
}

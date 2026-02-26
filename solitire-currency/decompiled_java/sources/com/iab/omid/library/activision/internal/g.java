package com.iab.omid.library.activision.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static g f10554b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10555a;

    private g() {
    }

    public static g b() {
        return f10554b;
    }

    public Context a() {
        return this.f10555a;
    }

    public void a(Context context) {
        this.f10555a = context != null ? context.getApplicationContext() : null;
    }
}

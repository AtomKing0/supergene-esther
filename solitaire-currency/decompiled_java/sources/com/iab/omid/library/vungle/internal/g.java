package com.iab.omid.library.vungle.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static g f11077b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11078a;

    private g() {
    }

    public static g b() {
        return f11077b;
    }

    public Context a() {
        return this.f11078a;
    }

    public void a(Context context) {
        this.f11078a = context != null ? context.getApplicationContext() : null;
    }
}

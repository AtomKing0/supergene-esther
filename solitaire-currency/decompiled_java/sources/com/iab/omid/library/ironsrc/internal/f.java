package com.iab.omid.library.ironsrc.internal;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static f f10823b = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10824a;

    private f() {
    }

    public static f b() {
        return f10823b;
    }

    public Context a() {
        return this.f10824a;
    }

    public void a(Context context) {
        this.f10824a = context != null ? context.getApplicationContext() : null;
    }
}

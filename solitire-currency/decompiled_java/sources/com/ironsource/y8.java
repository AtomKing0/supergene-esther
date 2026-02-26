package com.ironsource;

import android.app.Activity;
import android.content.MutableContextWrapper;

/* JADX INFO: loaded from: classes4.dex */
public class y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MutableContextWrapper f16265a;

    public Activity a() {
        return (Activity) this.f16265a.getBaseContext();
    }

    public synchronized void b() {
        this.f16265a = null;
    }

    public synchronized void a(Activity activity) {
        if (this.f16265a == null) {
            this.f16265a = new MutableContextWrapper(activity);
        }
        this.f16265a.setBaseContext(activity);
    }
}

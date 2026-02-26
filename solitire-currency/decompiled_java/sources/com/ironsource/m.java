package com.ironsource;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class m implements hu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f13099a;

    public m(Activity activity) {
        this.f13099a = new WeakReference<>(activity);
    }

    @Override // com.ironsource.hu
    public void a() {
        Activity activity = this.f13099a.get();
        if (activity != null) {
            activity.requestWindowFeature(1);
        }
    }
}

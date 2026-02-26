package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class y0 extends k2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.applovin.impl.sdk.j f7764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f7765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f7766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f7767h;

    public enum a {
        RECENT_ADS,
        COUNT
    }

    public y0(Context context) {
        super(context);
        this.f7766g = new AtomicBoolean();
        this.f7767h = new ArrayList();
    }

    public void a(List list, com.applovin.impl.sdk.j jVar) {
        Activity activityN0;
        this.f7764e = jVar;
        this.f7765f = list;
        if (!(this.f5532a instanceof Activity) && (activityN0 = jVar.n0()) != null) {
            this.f5532a = activityN0;
        }
        if (list != null && this.f7766g.compareAndSet(false, true)) {
            this.f7767h = a(this.f7765f);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.se
            @Override // java.lang.Runnable
            public final void run() {
                this.f7390a.notifyDataSetChanged();
            }
        });
    }

    @Override // com.applovin.impl.k2
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.k2
    protected List c(int i10) {
        return this.f7767h;
    }

    public List d() {
        return this.f7765f;
    }

    public com.applovin.impl.sdk.j e() {
        return this.f7764e;
    }

    public boolean f() {
        return this.f7767h.size() == 0;
    }

    public void g() {
        this.f7766g.compareAndSet(true, false);
    }

    public String toString() {
        return "CreativeDebuggerListAdapter{isInitialized=" + this.f7766g.get() + "}";
    }

    @Override // com.applovin.impl.k2
    protected int d(int i10) {
        return this.f7767h.size();
    }

    @Override // com.applovin.impl.k2
    protected j2 e(int i10) {
        return new j4("RECENT ADS");
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new i1((j1) it.next(), this.f5532a));
        }
        return arrayList;
    }
}

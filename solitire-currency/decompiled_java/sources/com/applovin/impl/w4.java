package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import io.sentry.protocol.TransactionInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f7677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f7678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f7679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f7680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7682f;

    public w4(String str, com.applovin.impl.sdk.j jVar) {
        this(str, jVar, false, null);
    }

    public com.applovin.impl.sdk.j b() {
        return this.f7677a;
    }

    public String c() {
        return this.f7678b;
    }

    public boolean d() {
        return this.f7682f;
    }

    public w4(String str, com.applovin.impl.sdk.j jVar, boolean z10) {
        this(str, jVar, z10, null);
    }

    public Context a() {
        return this.f7680d;
    }

    public ScheduledFuture b(final Thread thread, final long j10) {
        if (j10 <= 0) {
            return null;
        }
        return this.f7677a.j0().b(new f6(this.f7677a, "timeout:" + this.f7678b, new Runnable() { // from class: com.applovin.impl.ke
            @Override // java.lang.Runnable
            public final void run() {
                this.f5565a.a(thread, j10);
            }
        }), r5.b.TIMEOUT, j10);
    }

    public w4(String str, com.applovin.impl.sdk.j jVar, String str2) {
        this(str, jVar, false, str2);
    }

    public void a(String str) {
        this.f7681e = str;
    }

    public w4(String str, com.applovin.impl.sdk.j jVar, boolean z10, String str2) {
        this.f7678b = str;
        this.f7677a = jVar;
        this.f7679c = jVar.I();
        this.f7680d = com.applovin.impl.sdk.j.n();
        this.f7682f = z10;
        this.f7681e = str2;
    }

    public void a(boolean z10) {
        this.f7682f = z10;
    }

    public void a(Throwable th) {
        Map map = CollectionUtils.map(TransactionInfo.JsonKeys.SOURCE, this.f7678b);
        map.put("top_main_method", th.toString());
        map.put("details", StringUtils.emptyIfNull(this.f7681e));
        this.f7677a.A().d(y1.f7808t0, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Thread thread, long j10) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("name", thread.getState().name());
        if (StringUtils.isValidString(this.f7681e)) {
            mapHashMap.put("details", this.f7681e);
        }
        this.f7677a.A().a(y1.f7810u0, this.f7678b, mapHashMap);
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.k(this.f7678b, "Task has been executing for over " + TimeUnit.MILLISECONDS.toSeconds(j10) + " seconds");
        }
    }
}

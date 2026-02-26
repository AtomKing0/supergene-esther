package com.applovin.impl;

import android.os.Handler;
import android.os.HandlerThread;
import com.applovin.sdk.AppLovinSdkUtils;
import io.sentry.protocol.TransactionInfo;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final x f7706l = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f7708b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f7710d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.applovin.impl.sdk.j f7713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Thread f7714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f7715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f7716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f7717k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f7707a = new AtomicLong(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HandlerThread f7709c = new HandlerThread("AppLovinSdk:anr_detector");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f7711e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f7712f = new AtomicBoolean();

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (x.this.f7711e.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - x.this.f7707a.get();
            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > x.this.f7715i) {
                x.this.a();
                if (x.this.f7714h == null || x.this.f7714h.getStackTrace().length <= 0) {
                    str = "None";
                } else {
                    StackTraceElement stackTraceElement = x.this.f7714h.getStackTrace()[0];
                    str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
                }
                long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - com.applovin.impl.sdk.j.m());
                HashMap map = new HashMap(3);
                map.put("top_main_method", str);
                map.put(TransactionInfo.JsonKeys.SOURCE, x.this.f7713g.s0() ? "non_first_session" : "first_session");
                map.put("details", "seconds_since_app_launch=" + seconds);
                x.this.f7713g.A().d(y1.f7778e0, map);
            }
            x.this.f7710d.postDelayed(this, x.this.f7717k);
        }
    }

    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.this.f7711e.get()) {
                return;
            }
            x.this.f7707a.set(System.currentTimeMillis());
            x.this.f7708b.postDelayed(this, x.this.f7716j);
        }
    }

    private x() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f7715i = timeUnit.toMillis(4L);
        this.f7716j = timeUnit.toMillis(3L);
        this.f7717k = timeUnit.toMillis(3L);
    }

    private void a(com.applovin.impl.sdk.j jVar) {
        if (this.f7712f.compareAndSet(false, true)) {
            this.f7713g = jVar;
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.le
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5836a.b();
                }
            });
            this.f7715i = ((Long) jVar.a(l4.f5748t5)).longValue();
            this.f7716j = ((Long) jVar.a(l4.f5756u5)).longValue();
            this.f7717k = ((Long) jVar.a(l4.f5763v5)).longValue();
            this.f7708b = new Handler(com.applovin.impl.sdk.j.n().getMainLooper());
            this.f7709c.start();
            this.f7708b.post(new c());
            Handler handler = new Handler(this.f7709c.getLooper());
            this.f7710d = handler;
            handler.postDelayed(new b(), this.f7717k / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f7714h = Thread.currentThread();
    }

    public static void b(com.applovin.impl.sdk.j jVar) {
        if (jVar != null) {
            if (((Boolean) jVar.a(l4.f5740s5)).booleanValue() && !z6.c(jVar)) {
                f7706l.a(jVar);
            } else {
                f7706l.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f7712f.get()) {
            this.f7711e.set(true);
        }
    }
}

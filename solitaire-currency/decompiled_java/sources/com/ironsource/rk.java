package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class rk implements SegmentListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SegmentListener f14700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f14701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f14702c;

    private class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f14703a;

        private b() {
        }

        public Handler a() {
            return this.f14703a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.f14703a = new Handler();
            Looper.loop();
        }
    }

    public rk() {
        b bVar = new b();
        this.f14701b = bVar;
        bVar.start();
        this.f14702c = new Date().getTime();
    }

    @Override // com.ironsource.mediationsdk.sdk.SegmentListener
    public void onSegmentReceived(final String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onSegmentReceived(" + str + ")", 1);
        if (a((Object) this.f14700a)) {
            a(new Runnable() { // from class: com.ironsource.m00
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13102a.a(str);
                }
            });
        }
    }

    public void a(SegmentListener segmentListener) {
        this.f14700a = segmentListener;
    }

    protected void a(Runnable runnable) {
        Handler handlerA;
        b bVar = this.f14701b;
        if (bVar == null || (handlerA = bVar.a()) == null) {
            return;
        }
        handlerA.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14700a.onSegmentReceived(str);
    }

    protected boolean a(Object obj) {
        return (obj == null || this.f14701b == null) ? false : true;
    }
}

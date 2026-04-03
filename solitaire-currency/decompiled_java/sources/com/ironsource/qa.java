package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class qa extends Handler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14465b = "DownloadHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    hn f14466a;

    public qa(Looper looper) {
        super(looper);
    }

    public void a() {
        this.f14466a = null;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        hn hnVar = this.f14466a;
        if (hnVar == null) {
            Logger.i(f14465b, "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            int i10 = message.what;
            if (i10 == 1016) {
                hnVar.a((zf) message.obj);
            } else {
                this.f14466a.a((zf) message.obj, new rf(i10, yt.a(i10)));
            }
        } catch (Throwable th) {
            i9.d().a(th);
            Logger.i(f14465b, "handleMessage | Got exception: " + th.getMessage());
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public void a(hn hnVar) {
        if (hnVar == null) {
            throw new IllegalArgumentException();
        }
        this.f14466a = hnVar;
    }
}

package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class gc extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, hn> f12234a;

    public gc(Looper looper) {
        super(looper);
        this.f12234a = new ConcurrentHashMap<>();
    }

    void a(String str, hn hnVar) {
        if (str == null || hnVar == null) {
            return;
        }
        this.f12234a.put(str, hnVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            zf zfVar = (zf) message.obj;
            String path = zfVar.getPath();
            hn hnVar = this.f12234a.get(path);
            if (hnVar == null) {
                return;
            }
            if (a(message.what)) {
                hnVar.a(zfVar);
            } else {
                int i10 = message.what;
                hnVar.a(zfVar, new rf(i10, yt.a(i10)));
            }
            this.f12234a.remove(path);
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    private boolean a(int i10) {
        return i10 == 1016 || i10 == 1015;
    }
}

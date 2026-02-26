package com.ironsource;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class zq {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f16489c;

        a(String str, boolean z10, int i10) {
            this.f16487a = str;
            this.f16488b = z10;
            this.f16489c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            zq.c(this.f16487a, this.f16488b, this.f16489c);
        }
    }

    public static void b(String str, boolean z10, int i10) {
        Thread thread = new Thread(new a(str, z10, i10), "callAsyncRequestURL");
        thread.setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.d());
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, boolean z10, int i10) {
        try {
            new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getRequestURL(str, z10, i10)));
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NETWORK, "callRequestURL(reqUrl:" + str + ", hit:" + z10 + ")", 1);
        } catch (Throwable th) {
            i9.d().a(th);
            StringBuilder sb = new StringBuilder("callRequestURL(reqUrl:");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(", hit:");
            sb.append(z10);
            sb.append(")");
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NETWORK, sb.toString() + ", e:" + Log.getStackTraceString(th), 0);
        }
    }
}

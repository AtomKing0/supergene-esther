package com.ironsource.mediationsdk.logger;

import android.os.Looper;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.v8;

/* JADX INFO: loaded from: classes4.dex */
public class a extends IronSourceLogger {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13661c = "console";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13662d = "ironSourceSDK: ";

    private a() {
        super("console");
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i10) {
        StringBuilder sb = new StringBuilder();
        sb.append("UIThread: ");
        sb.append(Looper.getMainLooper() == Looper.myLooper());
        sb.append(" ");
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Activity: ");
        sb2.append(ContextProvider.getInstance().getCurrentActiveActivity() != null ? Integer.valueOf(ContextProvider.getInstance().getCurrentActiveActivity().hashCode()) : Boolean.FALSE);
        sb2.append(" ");
        String string2 = sb2.toString();
        if (i10 == 0) {
            Log.v(f13662d + ironSourceTag, string + string2 + str);
            return;
        }
        if (i10 == 1) {
            Log.i(f13662d + ironSourceTag, str);
            return;
        }
        if (i10 == 2) {
            Log.w(f13662d + ironSourceTag, str);
            return;
        }
        if (i10 != 3) {
            return;
        }
        Log.e(f13662d + ironSourceTag, str);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        log(ironSourceTag, str + ":stacktrace[" + Log.getStackTraceString(th) + v8.i.f15839e, 3);
    }

    public a(int i10) {
        super("console", i10);
    }
}

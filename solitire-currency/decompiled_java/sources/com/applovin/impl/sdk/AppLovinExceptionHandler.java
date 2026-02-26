package com.applovin.impl.sdk;

import android.os.Process;
import android.text.TextUtils;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.y1;
import com.ironsource.v8;
import java.lang.Thread;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AppLovinExceptionHandler f6879d = new AppLovinExceptionHandler();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f6880a = new HashSet(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f6881b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f6882c;

    private String a(Throwable th, int i10) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        return TextUtils.join("\n", (StackTraceElement[]) Arrays.copyOf(stackTrace, Math.min(i10, stackTrace.length)));
    }

    public static AppLovinExceptionHandler shared() {
        return f6879d;
    }

    public void addSdk(j jVar) {
        if (this.f6880a.contains(jVar)) {
            return;
        }
        this.f6880a.add(jVar);
    }

    public void enable() {
        if (this.f6881b.compareAndSet(false, true)) {
            this.f6882c = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        long jLongValue = 500;
        for (j jVar : this.f6880a) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("AppLovinExceptionHandler", "Detected unhandled exception");
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("top_main_method", th.toString());
            Integer num = (Integer) jVar.a(l4.W5);
            if (num.intValue() > 0) {
                mapHashMap.put("details", a(th, num.intValue()));
            }
            jVar.A().d(y1.f7794m0, mapHashMap);
            jVar.B().trackEventSynchronously(v8.h.f15788e0);
            jLongValue = ((Long) jVar.a(l4.f5595a3)).longValue();
        }
        try {
            Thread.sleep(jLongValue);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f6882c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}

package com.ironsource.mediationsdk.logger;

import com.ironsource.dk;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class IronSourceLoggerManager extends IronSourceLogger implements LogListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static IronSourceLoggerManager f13659d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<IronSourceLogger> f13660c;

    private IronSourceLoggerManager(String str) {
        super(str);
        this.f13660c = new ArrayList<>();
        c();
    }

    private IronSourceLogger a(String str) {
        for (IronSourceLogger ironSourceLogger : this.f13660c) {
            if (ironSourceLogger.b().equals(str)) {
                return ironSourceLogger;
            }
        }
        return null;
    }

    private void c() {
        this.f13660c.add(new a(0));
    }

    public static synchronized IronSourceLoggerManager getLogger() {
        if (f13659d == null) {
            f13659d = new IronSourceLoggerManager(IronSourceLoggerManager.class.getSimpleName());
        }
        return f13659d;
    }

    public void addLogger(IronSourceLogger ironSourceLogger) {
        this.f13660c.add(ironSourceLogger);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    @Deprecated(forRemoval = true, since = "8.3.0")
    public synchronized void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i10) {
        if (a(i10)) {
            return;
        }
        a(ironSourceTag, str, i10);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th == null) {
            Iterator<IronSourceLogger> it = this.f13660c.iterator();
            while (it.hasNext()) {
                it.next().log(ironSourceTag, str, 3);
            }
        } else {
            Iterator<IronSourceLogger> it2 = this.f13660c.iterator();
            while (it2.hasNext()) {
                it2.next().logException(ironSourceTag, str, th);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.logger.LogListener
    public synchronized void onLog(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i10) {
        log(ironSourceTag, str, i10);
    }

    public void setLoggerDebugLevel(String str, int i10) {
        if (str == null) {
            return;
        }
        IronSourceLogger ironSourceLoggerA = a(str);
        if (ironSourceLoggerA == null) {
            log(IronSourceLogger.IronSourceTag.NATIVE, "Failed to find logger:setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i10 + ")", 0);
            return;
        }
        if (i10 < 0 || i10 > 3) {
            this.f13660c.remove(ironSourceLoggerA);
            return;
        }
        log(IronSourceLogger.IronSourceTag.NATIVE, "setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i10 + ")", 0);
        ironSourceLoggerA.setDebugLevel(i10);
    }

    private IronSourceLoggerManager(String str, int i10) {
        super(str, i10);
        this.f13660c = new ArrayList<>();
        c();
    }

    public static synchronized IronSourceLoggerManager getLogger(int i10) {
        IronSourceLoggerManager ironSourceLoggerManager = f13659d;
        if (ironSourceLoggerManager == null) {
            f13659d = new IronSourceLoggerManager(IronSourceLoggerManager.class.getSimpleName());
        } else {
            ironSourceLoggerManager.f13655a = i10;
        }
        return f13659d;
    }

    synchronized void a(IronSourceLogger.IronSourceTag ironSourceTag, dk dkVar) {
        if (a(dkVar.a())) {
            return;
        }
        a(ironSourceTag, dkVar.c(), dkVar.a());
    }

    private void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i10) {
        for (IronSourceLogger ironSourceLogger : this.f13660c) {
            if (ironSourceLogger.a() <= i10) {
                ironSourceLogger.log(ironSourceTag, str, i10);
            }
        }
    }

    private boolean a(int i10) {
        return i10 < this.f13655a;
    }
}

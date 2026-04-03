package com.ironsource.mediationsdk.logger;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: loaded from: classes4.dex */
public class b extends IronSourceLogger {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13663e = "publisher";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LogListener f13664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13665d;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceLogger.IronSourceTag f13667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f13668c;

        a(String str, IronSourceLogger.IronSourceTag ironSourceTag, int i10) {
            this.f13666a = str;
            this.f13667b = ironSourceTag;
            this.f13668c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f13664c == null || this.f13666a == null) {
                return;
            }
            b.this.f13664c.onLog(this.f13667b, this.f13666a, this.f13668c);
        }
    }

    private b() {
        super("publisher");
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i10) {
        a aVar = new a(str, ironSourceTag, i10);
        if (this.f13665d) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(aVar);
        } else {
            IronSourceThreadManager.INSTANCE.postPublisherCallback(aVar);
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th != null) {
            log(ironSourceTag, th.getMessage(), 3);
        }
    }

    public b(LogListener logListener, int i10) {
        super("publisher", i10);
        this.f13664c = logListener;
        this.f13665d = false;
    }

    public void a(LogListener logListener) {
        this.f13664c = logListener;
    }

    public void a(boolean z10) {
        this.f13665d = z10;
    }
}

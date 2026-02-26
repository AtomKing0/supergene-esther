package com.ironsource.mediationsdk.logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IronSourceLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13656b;

    public class IronSourceLogLevel {
        public static final int ERROR = 3;
        public static final int INFO = 1;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;

        public IronSourceLogLevel() {
        }
    }

    public enum IronSourceTag {
        API,
        ADAPTER_API,
        CALLBACK,
        ADAPTER_CALLBACK,
        NETWORK,
        INTERNAL,
        NATIVE,
        EVENT
    }

    IronSourceLogger(String str) {
        this.f13656b = str;
        this.f13655a = 0;
    }

    int a() {
        return this.f13655a;
    }

    String b() {
        return this.f13656b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IronSourceLogger)) {
            return false;
        }
        IronSourceLogger ironSourceLogger = (IronSourceLogger) obj;
        String str = this.f13656b;
        return str != null && str.equals(ironSourceLogger.f13656b);
    }

    public abstract void log(IronSourceTag ironSourceTag, String str, int i10);

    public abstract void logException(IronSourceTag ironSourceTag, String str, Throwable th);

    public void setDebugLevel(int i10) {
        this.f13655a = i10;
    }

    IronSourceLogger(String str, int i10) {
        this.f13656b = str;
        this.f13655a = i10;
    }
}

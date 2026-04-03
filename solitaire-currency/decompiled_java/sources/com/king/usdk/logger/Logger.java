package com.king.usdk.logger;

import androidx.annotation.Keep;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Logger {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private boolean mEnabled;
    private long mLogState;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17199a;

        static {
            int[] iArr = new int[b.values().length];
            f17199a = iArr;
            try {
                iArr[b.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17199a[b.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17199a[b.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17199a[b.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17199a[b.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4);


        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final b[] f17205g = new b[5];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17207a;

        static {
            for (b bVar : (b[]) b.class.getEnumConstants()) {
                f17205g[bVar.f17207a] = bVar;
            }
        }

        b(int i10) {
            this.f17207a = i10;
        }

        public static b c(int i10) {
            b[] bVarArr = f17205g;
            if (i10 < bVarArr.length) {
                return bVarArr[i10];
            }
            throw new IllegalArgumentException("Invalid value for Level: " + i10);
        }

        public int d() {
            int i10 = a.f17199a[ordinal()];
            if (i10 == 1) {
                return 2;
            }
            if (i10 == 2) {
                return 3;
            }
            if (i10 == 3) {
                return 4;
            }
            if (i10 != 4) {
                return i10 != 5 ? 7 : 6;
            }
            return 5;
        }
    }

    public Logger(long j10, boolean z10) {
        this.mEnabled = z10;
        this.mLogState = j10;
    }

    private static String className() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return className.substring(className.lastIndexOf(".") + 1) + "." + Thread.currentThread().getStackTrace()[3].getMethodName();
    }

    public static native int getLogLevel(long j10);

    private static int line() {
        return Thread.currentThread().getStackTrace()[3].getLineNumber();
    }

    public static native void logd(long j10, long j11, String str, String str2);

    public static native void loge(long j10, long j11, String str, String str2);

    public static native void logi(long j10, long j11, String str, String str2);

    public static native void logw(long j10, long j11, String str, String str2);

    public void d(String str) {
        if (this.mEnabled) {
            this.lock.readLock().lock();
            try {
                long j10 = this.mLogState;
                if (j10 != 0) {
                    logd(j10, line(), className(), str);
                }
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }

    public void e(String str) {
        if (this.mEnabled) {
            this.lock.readLock().lock();
            try {
                long j10 = this.mLogState;
                if (j10 != 0) {
                    loge(j10, line(), className(), str);
                }
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }

    public long getState() {
        return this.mLogState;
    }

    public void i(String str) {
        if (this.mEnabled) {
            this.lock.readLock().lock();
            try {
                long j10 = this.mLogState;
                if (j10 != 0) {
                    logi(j10, line(), className(), str);
                }
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public b logLevel() {
        long j10 = this.mLogState;
        return j10 != 0 ? b.c(getLogLevel(j10)) : b.ERROR;
    }

    public void shutdown() {
        i("The logger is being invalidated. Value set to 0 (zero)");
        this.lock.writeLock().lock();
        try {
            this.mLogState = 0L;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void w(String str) {
        if (this.mEnabled) {
            this.lock.readLock().lock();
            try {
                long j10 = this.mLogState;
                if (j10 != 0) {
                    logw(j10, line(), className(), str);
                }
            } finally {
                this.lock.readLock().unlock();
            }
        }
    }
}

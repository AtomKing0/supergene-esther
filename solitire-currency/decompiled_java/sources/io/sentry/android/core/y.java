package io.sentry.android.core;

import android.util.Log;
import io.sentry.SentryLevel;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidLogger.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class y implements io.sentry.w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27556a;

    /* JADX INFO: compiled from: AndroidLogger.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27557a;

        static {
            int[] iArr = new int[SentryLevel.values().length];
            f27557a = iArr;
            try {
                iArr[SentryLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27557a[SentryLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27557a[SentryLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27557a[SentryLevel.FATAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27557a[SentryLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public y() {
        this("Sentry");
    }

    private int e(@NotNull SentryLevel sentryLevel) {
        int i10 = a.f27557a[sentryLevel.ordinal()];
        if (i10 == 1) {
            return 4;
        }
        if (i10 != 2) {
            return i10 != 4 ? 3 : 7;
        }
        return 5;
    }

    @Override // io.sentry.w0
    public void a(@NotNull SentryLevel sentryLevel, @Nullable Throwable th, @NotNull String str, @Nullable Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            b(sentryLevel, str, th);
        } else {
            b(sentryLevel, String.format(str, objArr), th);
        }
    }

    @Override // io.sentry.w0
    public void b(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Throwable th) {
        int i10 = a.f27557a[sentryLevel.ordinal()];
        if (i10 == 1) {
            Log.i(this.f27556a, str, th);
            return;
        }
        if (i10 == 2) {
            Log.w(this.f27556a, str, th);
            return;
        }
        if (i10 == 3) {
            Log.e(this.f27556a, str, th);
        } else if (i10 != 4) {
            Log.d(this.f27556a, str, th);
        } else {
            Log.wtf(this.f27556a, str, th);
        }
    }

    @Override // io.sentry.w0
    public void c(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            Log.println(e(sentryLevel), this.f27556a, str);
        } else {
            Log.println(e(sentryLevel), this.f27556a, String.format(str, objArr));
        }
    }

    @Override // io.sentry.w0
    public boolean d(@Nullable SentryLevel sentryLevel) {
        return true;
    }

    public y(@NotNull String str) {
        this.f27556a = str;
    }
}

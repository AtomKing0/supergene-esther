package io.sentry.android.core;

import android.util.Log;
import io.sentry.SentryLevel;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFatalLogger.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class x implements io.sentry.w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27554a;

    public x() {
        this("Sentry");
    }

    private int e(@NotNull SentryLevel sentryLevel) {
        return 7;
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
        Log.wtf(this.f27554a, str, th);
    }

    @Override // io.sentry.w0
    public void c(@NotNull SentryLevel sentryLevel, @NotNull String str, @Nullable Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            Log.println(e(sentryLevel), this.f27554a, str);
        } else {
            Log.println(e(sentryLevel), this.f27554a, String.format(str, objArr));
        }
    }

    @Override // io.sentry.w0
    public boolean d(@Nullable SentryLevel sentryLevel) {
        return true;
    }

    public x(@NotNull String str) {
        this.f27554a = str;
    }
}

package io.sentry.android.ndk;

import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.n1;
import io.sentry.ndk.NativeModuleListLoader;
import io.sentry.util.w;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DebugImagesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    protected static final io.sentry.util.a f27559c = new io.sentry.util.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final NativeModuleListLoader f27561b;

    public a(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull NativeModuleListLoader nativeModuleListLoader) {
        this.f27560a = (SentryOptions) w.c(sentryAndroidOptions, "The SentryAndroidOptions is required.");
        this.f27561b = (NativeModuleListLoader) w.c(nativeModuleListLoader, "The NativeModuleListLoader is required.");
    }
}

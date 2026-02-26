package io.sentry.cache;

import io.sentry.SentryOptions;
import io.sentry.protocol.SdkVersion;
import io.sentry.x0;
import io.sentry.x1;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistingOptionsObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27660a;

    public h(@NotNull SentryOptions sentryOptions) {
        this.f27660a = sentryOptions;
    }

    private void h(@NotNull String str) {
        d.a(this.f27660a, ".options-cache", str);
    }

    @Nullable
    public static <T> T i(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull Class<T> cls) {
        return (T) j(sentryOptions, str, cls, null);
    }

    @Nullable
    public static <T, R> T j(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull Class<T> cls, @Nullable x1<R> x1Var) {
        return (T) d.c(sentryOptions, ".options-cache", str, cls, x1Var);
    }

    private <T> void k(@NotNull T t10, @NotNull String str) {
        d.d(this.f27660a, t10, ".options-cache", str);
    }

    @Override // io.sentry.x0
    public void a(@NotNull Map<String, String> map) {
        k(map, "tags.json");
    }

    @Override // io.sentry.x0
    public void b(@Nullable String str) {
        if (str == null) {
            h("dist.json");
        } else {
            k(str, "dist.json");
        }
    }

    @Override // io.sentry.x0
    public void c(@Nullable Double d10) {
        if (d10 == null) {
            h("replay-error-sample-rate.json");
        } else {
            k(d10.toString(), "replay-error-sample-rate.json");
        }
    }

    @Override // io.sentry.x0
    public void d(@Nullable String str) {
        if (str == null) {
            h("environment.json");
        } else {
            k(str, "environment.json");
        }
    }

    @Override // io.sentry.x0
    public void e(@Nullable String str) {
        if (str == null) {
            h("proguard-uuid.json");
        } else {
            k(str, "proguard-uuid.json");
        }
    }

    @Override // io.sentry.x0
    public void f(@Nullable SdkVersion sdkVersion) {
        if (sdkVersion == null) {
            h("sdk-version.json");
        } else {
            k(sdkVersion, "sdk-version.json");
        }
    }

    @Override // io.sentry.x0
    public void g(@Nullable String str) {
        if (str == null) {
            h("release.json");
        } else {
            k(str, "release.json");
        }
    }
}

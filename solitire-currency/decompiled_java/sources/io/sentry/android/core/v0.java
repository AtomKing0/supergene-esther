package io.sentry.android.core;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AppState.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class v0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static v0 f27549c = new v0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27550a = new io.sentry.util.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Boolean f27551b = null;

    private v0() {
    }

    @NotNull
    public static v0 a() {
        return f27549c;
    }

    @Nullable
    public Boolean b() {
        return this.f27551b;
    }

    void c(boolean z10) {
        io.sentry.k1 k1VarA = this.f27550a.a();
        try {
            this.f27551b = Boolean.valueOf(z10);
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}

package io.sentry.exception;

import io.sentry.protocol.Mechanism;
import io.sentry.util.w;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExceptionMechanismException.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Mechanism f27800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Throwable f27801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Thread f27802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f27803d;

    public a(@NotNull Mechanism mechanism, @NotNull Throwable th, @NotNull Thread thread, boolean z10) {
        this.f27800a = (Mechanism) w.c(mechanism, "Mechanism is required.");
        this.f27801b = (Throwable) w.c(th, "Throwable is required.");
        this.f27802c = (Thread) w.c(thread, "Thread is required.");
        this.f27803d = z10;
    }

    @NotNull
    public Mechanism a() {
        return this.f27800a;
    }

    @NotNull
    public Thread b() {
        return this.f27802c;
    }

    @NotNull
    public Throwable c() {
        return this.f27801b;
    }

    public boolean d() {
        return this.f27803d;
    }

    public a(@NotNull Mechanism mechanism, @NotNull Throwable th, @NotNull Thread thread) {
        this(mechanism, th, thread, false);
    }
}

package io.sentry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TracesSamplingDecision.java */
/* JADX INFO: loaded from: classes5.dex */
public final class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Boolean f28491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Double f28492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Double f28493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Boolean f28494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final Double f28495e;

    public x8(@NotNull Boolean bool) {
        this(bool, null);
    }

    @Nullable
    public Double a() {
        return this.f28495e;
    }

    @NotNull
    public Boolean b() {
        return this.f28494d;
    }

    @Nullable
    public Double c() {
        return this.f28493c;
    }

    @Nullable
    public Double d() {
        return this.f28492b;
    }

    @NotNull
    public Boolean e() {
        return this.f28491a;
    }

    public x8(@NotNull Boolean bool, @Nullable Double d10) {
        this(bool, d10, null, Boolean.FALSE, null);
    }

    public x8(@NotNull Boolean bool, @Nullable Double d10, @Nullable Double d11) {
        this(bool, d10, d11, Boolean.FALSE, null);
    }

    public x8(@NotNull Boolean bool, @Nullable Double d10, @NotNull Boolean bool2, @Nullable Double d11) {
        this(bool, d10, null, bool2, d11);
    }

    public x8(@NotNull Boolean bool, @Nullable Double d10, @Nullable Double d11, @NotNull Boolean bool2, @Nullable Double d12) {
        this.f28491a = bool;
        this.f28492b = d10;
        this.f28493c = d11;
        this.f28494d = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
        this.f28495e = d12;
    }
}

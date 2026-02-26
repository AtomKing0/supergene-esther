package io.sentry;

import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SamplingContext.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final y8 f27775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Double f27776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<String, Object> f27777c;

    @ApiStatus.Internal
    public e4(@NotNull y8 y8Var, @Nullable l lVar, @NotNull Double d10, @Nullable Map<String, Object> map) {
        this.f27775a = (y8) io.sentry.util.w.c(y8Var, "transactionContexts is required");
        this.f27776b = d10;
        this.f27777c = map == null ? Collections.emptyMap() : map;
    }

    @NotNull
    public Double a() {
        return this.f27776b;
    }

    @NotNull
    public y8 b() {
        return this.f27775a;
    }
}

package com.moloco.sdk.acm.services;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final g f17480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final AtomicLong f17481b;

    public f(@NotNull g timeProviderService) {
        t.i(timeProviderService, "timeProviderService");
        this.f17480a = timeProviderService;
        this.f17481b = new AtomicLong(0L);
    }

    public final long a() {
        return this.f17480a.invoke() - this.f17481b.get();
    }

    public final void b() {
        this.f17481b.set(this.f17480a.invoke());
    }
}

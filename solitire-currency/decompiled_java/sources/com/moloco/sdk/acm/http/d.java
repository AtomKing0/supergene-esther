package com.moloco.sdk.acm.http;

import com.moloco.sdk.k;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<k.b> f17444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<k.c> f17445b;

    public d(@NotNull List<k.b> counts, @NotNull List<k.c> timers) {
        t.i(counts, "counts");
        t.i(timers, "timers");
        this.f17444a = counts;
        this.f17445b = timers;
    }

    @NotNull
    public final List<k.b> a() {
        return this.f17444a;
    }

    @NotNull
    public final List<k.c> b() {
        return this.f17445b;
    }
}

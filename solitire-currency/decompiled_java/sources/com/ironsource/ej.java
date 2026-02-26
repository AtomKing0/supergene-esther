package com.ironsource;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
final class ej implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final AtomicInteger f11916a = new AtomicInteger();

    @Override // java.util.concurrent.ThreadFactory
    @NotNull
    public Thread newThread(@NotNull Runnable r10) {
        kotlin.jvm.internal.t.i(r10, "r");
        kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
        String str = String.format(Locale.ENGLISH, "%s-%d", Arrays.copyOf(new Object[]{"IronSourceThread", Integer.valueOf(this.f11916a.incrementAndGet())}, 2));
        kotlin.jvm.internal.t.h(str, "format(locale, format, *args)");
        return new Thread(r10, str);
    }
}

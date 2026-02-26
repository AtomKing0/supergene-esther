package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class x<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final A f28376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final B f28377b;

    public x(@Nullable A a10, @Nullable B b10) {
        this.f28376a = a10;
        this.f28377b = b10;
    }

    @Nullable
    public A a() {
        return this.f28376a;
    }

    @Nullable
    public B b() {
        return this.f28377b;
    }
}

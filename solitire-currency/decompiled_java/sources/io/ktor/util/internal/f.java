package io.ktor.util.internal;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f26645a;

    public f(@NotNull String symbol) {
        t.i(symbol, "symbol");
        this.f26645a = symbol;
    }

    @NotNull
    public String toString() {
        return this.f26645a;
    }
}

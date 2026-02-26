package com.moloco.sdk.internal.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class f implements g.c<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final y9.a f18837a;

    public f(@NotNull y9.a mutex) {
        t.i(mutex, "mutex");
        this.f18837a = mutex;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && t.d(this.f18837a, ((f) obj).f18837a);
    }

    public int hashCode() {
        return this.f18837a.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReentrantMutexContextKey(mutex=" + this.f18837a + ')';
    }
}

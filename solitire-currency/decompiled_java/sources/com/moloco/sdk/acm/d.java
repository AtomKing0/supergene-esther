package com.moloco.sdk.acm;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f17321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f17322b;

    public d(@NotNull String key, @NotNull String value) {
        t.i(key, "key");
        t.i(value, "value");
        this.f17321a = key;
        this.f17322b = value;
    }

    @NotNull
    public final String a() {
        return this.f17321a;
    }

    @NotNull
    public final String b() {
        return this.f17322b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return t.d(this.f17321a, dVar.f17321a) && t.d(this.f17322b, dVar.f17322b);
    }

    public int hashCode() {
        return (this.f17321a.hashCode() * 31) + this.f17322b.hashCode();
    }

    @NotNull
    public String toString() {
        return "EventTag(key=" + this.f17321a + ", value=" + this.f17322b + ')';
    }
}

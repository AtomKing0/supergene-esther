package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class x7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private String f16141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private String f16142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f16143c;

    public x7(@NotNull String cachedAppKey, @NotNull String cachedUserId, @NotNull String cachedSettings) {
        kotlin.jvm.internal.t.i(cachedAppKey, "cachedAppKey");
        kotlin.jvm.internal.t.i(cachedUserId, "cachedUserId");
        kotlin.jvm.internal.t.i(cachedSettings, "cachedSettings");
        this.f16141a = cachedAppKey;
        this.f16142b = cachedUserId;
        this.f16143c = cachedSettings;
    }

    public static /* synthetic */ x7 a(x7 x7Var, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = x7Var.f16141a;
        }
        if ((i10 & 2) != 0) {
            str2 = x7Var.f16142b;
        }
        if ((i10 & 4) != 0) {
            str3 = x7Var.f16143c;
        }
        return x7Var.a(str, str2, str3);
    }

    @NotNull
    public final String b() {
        return this.f16142b;
    }

    @NotNull
    public final String c() {
        return this.f16143c;
    }

    @NotNull
    public final String d() {
        return this.f16141a;
    }

    @NotNull
    public final String e() {
        return this.f16143c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x7)) {
            return false;
        }
        x7 x7Var = (x7) obj;
        return kotlin.jvm.internal.t.d(this.f16141a, x7Var.f16141a) && kotlin.jvm.internal.t.d(this.f16142b, x7Var.f16142b) && kotlin.jvm.internal.t.d(this.f16143c, x7Var.f16143c);
    }

    @NotNull
    public final String f() {
        return this.f16142b;
    }

    public int hashCode() {
        return (((this.f16141a.hashCode() * 31) + this.f16142b.hashCode()) * 31) + this.f16143c.hashCode();
    }

    @NotNull
    public String toString() {
        return "CachedResponse(cachedAppKey=" + this.f16141a + ", cachedUserId=" + this.f16142b + ", cachedSettings=" + this.f16143c + ')';
    }

    @NotNull
    public final x7 a(@NotNull String cachedAppKey, @NotNull String cachedUserId, @NotNull String cachedSettings) {
        kotlin.jvm.internal.t.i(cachedAppKey, "cachedAppKey");
        kotlin.jvm.internal.t.i(cachedUserId, "cachedUserId");
        kotlin.jvm.internal.t.i(cachedSettings, "cachedSettings");
        return new x7(cachedAppKey, cachedUserId, cachedSettings);
    }

    public final void b(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f16143c = str;
    }

    public final void c(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f16142b = str;
    }

    @NotNull
    public final String a() {
        return this.f16141a;
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f16141a = str;
    }
}

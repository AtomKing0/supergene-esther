package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class xj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k1 f16192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private String f16193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16194c;

    public xj(@NotNull k1 adTools) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        this.f16192a = adTools;
        this.f16193b = "";
    }

    @NotNull
    public final k1 a() {
        return this.f16192a;
    }

    @NotNull
    public final String b() {
        return this.f16193b;
    }

    protected final boolean c() {
        return this.f16194c;
    }

    public abstract boolean d();

    public final void a(@NotNull b1 adProperties) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        this.f16192a.e().a(new v1(this.f16192a, adProperties));
    }

    public final void b(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        this.f16192a.e(callback);
    }

    public final void a(@NotNull Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        this.f16192a.d(runnable);
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f16193b = str;
    }

    protected final void a(boolean z10) {
        this.f16194c = z10;
    }
}

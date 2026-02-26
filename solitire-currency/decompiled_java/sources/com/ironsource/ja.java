package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ja f12717a = new ja();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12718b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f12719c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f12720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f12721e;

    private ja() {
    }

    public final void a(int i10) {
        f12721e = i10;
    }

    public final void b(boolean z10) {
        f12719c = z10;
    }

    public final void c(boolean z10) {
        f12718b = z10;
    }

    public final int d() {
        return f12721e;
    }

    public final void a(boolean z10) {
        f12720d = z10;
    }

    public final boolean b() {
        return f12719c;
    }

    public final boolean c() {
        return f12718b;
    }

    public final boolean a() {
        return f12720d;
    }
}

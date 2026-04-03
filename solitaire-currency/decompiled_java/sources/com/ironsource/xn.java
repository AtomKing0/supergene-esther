package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class xn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private yn f16197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16199c;

    public xn() {
        this(false, 1, null);
    }

    @Nullable
    public final yn a() {
        return this.f16197a;
    }

    @NotNull
    public abstract String b();

    public final long c() {
        return this.f16198b;
    }

    public final boolean d() {
        return this.f16199c;
    }

    public xn(boolean z10) {
        this.f16199c = z10;
    }

    public final void a(@Nullable yn ynVar) {
        this.f16197a = ynVar;
    }

    public /* synthetic */ xn(boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public final void a(boolean z10) {
        this.f16199c = z10;
        if (!z10) {
            yn ynVar = this.f16197a;
            if (ynVar != null) {
                ynVar.b(this);
                return;
            }
            return;
        }
        this.f16198b = System.currentTimeMillis();
        yn ynVar2 = this.f16197a;
        if (ynVar2 != null) {
            ynVar2.a(this);
        }
    }
}

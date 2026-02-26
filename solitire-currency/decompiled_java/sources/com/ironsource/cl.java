package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class cl extends xn {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f11588d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f11589e = "ManualTrigger";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public cl() {
        this(false, 1, null);
    }

    @Override // com.ironsource.xn
    @NotNull
    public String b() {
        return f11589e;
    }

    public final void e() {
        a(true);
    }

    public final void f() {
        a(false);
    }

    public cl(boolean z10) {
        super(z10);
    }

    public /* synthetic */ cl(boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}

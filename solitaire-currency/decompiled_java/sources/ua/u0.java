package ua;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f34825h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final byte[] f34826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f34827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f34829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f34830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public u0 f34831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public u0 f34832g;

    /* JADX INFO: compiled from: Segment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public u0() {
        this.f34826a = new byte[8192];
        this.f34830e = true;
        this.f34829d = false;
    }

    public final void a() {
        u0 u0Var = this.f34832g;
        int i10 = 0;
        if (!(u0Var != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        kotlin.jvm.internal.t.f(u0Var);
        if (u0Var.f34830e) {
            int i11 = this.f34828c - this.f34827b;
            u0 u0Var2 = this.f34832g;
            kotlin.jvm.internal.t.f(u0Var2);
            int i12 = 8192 - u0Var2.f34828c;
            u0 u0Var3 = this.f34832g;
            kotlin.jvm.internal.t.f(u0Var3);
            if (!u0Var3.f34829d) {
                u0 u0Var4 = this.f34832g;
                kotlin.jvm.internal.t.f(u0Var4);
                i10 = u0Var4.f34827b;
            }
            if (i11 > i12 + i10) {
                return;
            }
            u0 u0Var5 = this.f34832g;
            kotlin.jvm.internal.t.f(u0Var5);
            f(u0Var5, i11);
            b();
            v0.b(this);
        }
    }

    @Nullable
    public final u0 b() {
        u0 u0Var = this.f34831f;
        if (u0Var == this) {
            u0Var = null;
        }
        u0 u0Var2 = this.f34832g;
        kotlin.jvm.internal.t.f(u0Var2);
        u0Var2.f34831f = this.f34831f;
        u0 u0Var3 = this.f34831f;
        kotlin.jvm.internal.t.f(u0Var3);
        u0Var3.f34832g = this.f34832g;
        this.f34831f = null;
        this.f34832g = null;
        return u0Var;
    }

    @NotNull
    public final u0 c(@NotNull u0 segment) {
        kotlin.jvm.internal.t.i(segment, "segment");
        segment.f34832g = this;
        segment.f34831f = this.f34831f;
        u0 u0Var = this.f34831f;
        kotlin.jvm.internal.t.f(u0Var);
        u0Var.f34832g = segment;
        this.f34831f = segment;
        return segment;
    }

    @NotNull
    public final u0 d() {
        this.f34829d = true;
        return new u0(this.f34826a, this.f34827b, this.f34828c, true, false);
    }

    @NotNull
    public final u0 e(int i10) {
        u0 u0VarC;
        if (!(i10 > 0 && i10 <= this.f34828c - this.f34827b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i10 >= 1024) {
            u0VarC = d();
        } else {
            u0VarC = v0.c();
            byte[] bArr = this.f34826a;
            byte[] bArr2 = u0VarC.f34826a;
            int i11 = this.f34827b;
            kotlin.collections.o.j(bArr, bArr2, 0, i11, i11 + i10, 2, null);
        }
        u0VarC.f34828c = u0VarC.f34827b + i10;
        this.f34827b += i10;
        u0 u0Var = this.f34832g;
        kotlin.jvm.internal.t.f(u0Var);
        u0Var.c(u0VarC);
        return u0VarC;
    }

    public final void f(@NotNull u0 sink, int i10) {
        kotlin.jvm.internal.t.i(sink, "sink");
        if (!sink.f34830e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i11 = sink.f34828c;
        if (i11 + i10 > 8192) {
            if (sink.f34829d) {
                throw new IllegalArgumentException();
            }
            int i12 = sink.f34827b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f34826a;
            kotlin.collections.o.j(bArr, bArr, 0, i12, i11, 2, null);
            sink.f34828c -= sink.f34827b;
            sink.f34827b = 0;
        }
        byte[] bArr2 = this.f34826a;
        byte[] bArr3 = sink.f34826a;
        int i13 = sink.f34828c;
        int i14 = this.f34827b;
        kotlin.collections.o.d(bArr2, bArr3, i13, i14, i14 + i10);
        sink.f34828c += i10;
        this.f34827b += i10;
    }

    public u0(@NotNull byte[] data, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(data, "data");
        this.f34826a = data;
        this.f34827b = i10;
        this.f34828c = i11;
        this.f34829d = z10;
        this.f34830e = z11;
    }
}

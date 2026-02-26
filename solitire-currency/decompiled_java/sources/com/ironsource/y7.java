package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class y7 implements ud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Boolean f16262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Integer f16263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final g8 f16264c;

    public y7(@Nullable Boolean bool, @Nullable Integer num, @Nullable g8 g8Var) {
        this.f16262a = bool;
        this.f16263b = num;
        this.f16264c = g8Var;
    }

    @Override // com.ironsource.ud
    @NotNull
    public Object a() {
        y9 y9Var;
        Throwable thE = v8.t.e(new z9(this.f16262a).a());
        if (thE != null) {
            return v8.t.b(v8.u.a(thE));
        }
        Boolean bool = this.f16262a;
        if (bool != null) {
            bool.booleanValue();
            y9Var = new y9(this.f16262a.booleanValue());
        } else {
            y9Var = null;
        }
        return v8.t.b(y9Var);
    }

    @Override // com.ironsource.ud
    @NotNull
    public Object b() {
        pn pnVar;
        Integer num;
        g8 g8Var = g8.Second;
        Throwable thE = v8.t.e(a(g8Var));
        if (thE != null) {
            return v8.t.b(v8.u.a(thE));
        }
        if (!kotlin.jvm.internal.t.d(this.f16262a, Boolean.TRUE) || (num = this.f16263b) == null) {
            pnVar = null;
        } else {
            num.intValue();
            pnVar = new pn(g8Var.a(this.f16263b), null, 2, null);
        }
        return v8.t.b(pnVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    @Override // com.ironsource.ud
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c() {
        /*
            r3 = this;
            com.ironsource.g8 r0 = r3.f16264c
            java.lang.Object r0 = r3.a(r0)
            java.lang.Throwable r0 = v8.t.e(r0)
            if (r0 == 0) goto L15
            java.lang.Object r0 = v8.u.a(r0)
            java.lang.Object r0 = v8.t.b(r0)
            return r0
        L15:
            java.lang.Boolean r0 = r3.f16262a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.t.d(r0, r1)
            if (r0 == 0) goto L31
            java.lang.Integer r0 = r3.f16263b
            if (r0 == 0) goto L31
            int r0 = r0.intValue()
            com.ironsource.g8 r1 = r3.f16264c
            if (r1 == 0) goto L31
            com.ironsource.zr r2 = new com.ironsource.zr
            r2.<init>(r0, r1)
            goto L32
        L31:
            r2 = 0
        L32:
            java.lang.Object r0 = v8.t.b(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.y7.c():java.lang.Object");
    }

    @Nullable
    public final Boolean d() {
        return this.f16262a;
    }

    @Nullable
    public final Integer e() {
        return this.f16263b;
    }

    @Nullable
    public final g8 f() {
        return this.f16264c;
    }

    public /* synthetic */ y7(Boolean bool, Integer num, g8 g8Var, int i10, kotlin.jvm.internal.k kVar) {
        this(bool, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : g8Var);
    }

    private final Object a(g8 g8Var) {
        return new z7(this.f16262a, this.f16263b, g8Var).a();
    }
}

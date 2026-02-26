package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class z7 implements vd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Boolean f16391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Integer f16392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final g8 f16393c;

    public z7(@Nullable Boolean bool, @Nullable Integer num, @Nullable g8 g8Var) {
        this.f16391a = bool;
        this.f16392b = num;
        this.f16393c = g8Var;
    }

    @Override // com.ironsource.vd
    @NotNull
    public Object a() {
        Exception exc;
        Object objA;
        Boolean bool = this.f16391a;
        if (bool != null) {
            if (bool.booleanValue()) {
                Integer num = this.f16392b;
                if (num == null || num.intValue() <= 0) {
                    t.a aVar = v8.t.f35208b;
                    exc = new Exception("limit flag is not provided or invalid");
                } else if (this.f16393c == null) {
                    t.a aVar2 = v8.t.f35208b;
                    exc = new Exception("unit flag is not provided or invalid");
                } else {
                    t.a aVar3 = v8.t.f35208b;
                    objA = Boolean.TRUE;
                }
            } else {
                t.a aVar4 = v8.t.f35208b;
                objA = Boolean.FALSE;
            }
            return v8.t.b(objA);
        }
        t.a aVar5 = v8.t.f35208b;
        exc = new Exception("enabled flag is not provided or invalid");
        objA = v8.u.a(exc);
        return v8.t.b(objA);
    }
}

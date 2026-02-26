package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class z9 implements vd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Boolean f16395a;

    public z9(@Nullable Boolean bool) {
        this.f16395a = bool;
    }

    @Override // com.ironsource.vd
    @NotNull
    public Object a() {
        Boolean bool = this.f16395a;
        if (bool != null) {
            return v8.t.b(bool);
        }
        t.a aVar = v8.t.f35208b;
        return v8.t.b(v8.u.a(new Exception("enabled flag is not provided or invalid")));
    }
}

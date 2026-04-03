package com.ironsource;

import com.ironsource.wd;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ba implements wd, wd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<String, y9> f11387a = new ConcurrentHashMap<>();

    @Override // com.ironsource.wd
    @NotNull
    public f8 a(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        y9 y9Var = this.f11387a.get(identifier);
        return (y9Var == null || y9Var.a()) ? new f8(false, null, 2, null) : new f8(true, h8.Delivery);
    }

    @Override // com.ironsource.wd.a
    public void b(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
    }

    @Override // com.ironsource.wd.a
    @NotNull
    public Object a(@NotNull String identifier, @NotNull h8 cappingType, @NotNull ud cappingConfig) {
        Object objA;
        kotlin.jvm.internal.t.i(identifier, "identifier");
        kotlin.jvm.internal.t.i(cappingType, "cappingType");
        kotlin.jvm.internal.t.i(cappingConfig, "cappingConfig");
        Object objA2 = cappingConfig.a();
        if (!v8.t.h(objA2)) {
            Throwable thE = v8.t.e(objA2);
            if (thE != null) {
                objA = v8.u.a(thE);
            }
            return v8.t.b(objA);
        }
        y9 y9Var = (y9) objA2;
        if (y9Var != null) {
            this.f11387a.put(identifier, y9Var);
        }
        objA = v8.k0.f35197a;
        return v8.t.b(objA);
    }
}

package com.ironsource;

import com.ironsource.wd;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class qn implements wd, wd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k9 f14542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ne f14543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<String, pn> f14544c;

    public qn(@NotNull k9 currentTimeProvider, @NotNull ne repository) {
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.t.i(repository, "repository");
        this.f14542a = currentTimeProvider;
        this.f14543b = repository;
        this.f14544c = new LinkedHashMap();
    }

    @Override // com.ironsource.wd
    @NotNull
    public f8 a(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        pn pnVar = this.f14544c.get(identifier);
        if (pnVar != null && a(pnVar, identifier)) {
            return new f8(true, h8.Pacing);
        }
        return new f8(false, null, 2, null);
    }

    @Override // com.ironsource.wd.a
    public void b(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        if (this.f14544c.get(identifier) == null) {
            return;
        }
        this.f14543b.a(this.f14542a.a(), identifier);
    }

    @Override // com.ironsource.wd.a
    @NotNull
    public Object a(@NotNull String identifier, @NotNull h8 cappingType, @NotNull ud cappingConfig) {
        Object objA;
        kotlin.jvm.internal.t.i(identifier, "identifier");
        kotlin.jvm.internal.t.i(cappingType, "cappingType");
        kotlin.jvm.internal.t.i(cappingConfig, "cappingConfig");
        Object objB = cappingConfig.b();
        if (!v8.t.h(objB)) {
            Throwable thE = v8.t.e(objB);
            if (thE != null) {
                objA = v8.u.a(thE);
            }
            return v8.t.b(objA);
        }
        pn pnVar = (pn) objB;
        if (pnVar != null) {
            this.f14544c.put(identifier, pnVar);
        }
        objA = v8.k0.f35197a;
        return v8.t.b(objA);
    }

    @NotNull
    public final Map<String, pn> a() {
        return this.f14544c;
    }

    private final boolean a(pn pnVar, String str) {
        Long lA = this.f14543b.a(str);
        if (lA == null) {
            return false;
        }
        lA.longValue();
        return this.f14542a.a() - lA.longValue() < pnVar.a();
    }
}

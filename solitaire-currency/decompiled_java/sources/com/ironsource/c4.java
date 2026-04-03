package com.ironsource;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f11524a;

    /* JADX WARN: Multi-variable type inference failed */
    public c4() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c4 a(c4 c4Var, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = c4Var.f11524a;
        }
        return c4Var.a(map);
    }

    @NotNull
    public final Map<String, String> b() {
        return this.f11524a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c4) && kotlin.jvm.internal.t.d(this.f11524a, ((c4) obj).f11524a);
    }

    public int hashCode() {
        return this.f11524a.hashCode();
    }

    @NotNull
    public String toString() {
        return "ApplicationExternalSettings(mediationTypes=" + this.f11524a + ')';
    }

    public c4(@NotNull Map<String, String> mediationTypes) {
        kotlin.jvm.internal.t.i(mediationTypes, "mediationTypes");
        this.f11524a = mediationTypes;
    }

    @NotNull
    public final c4 a(@NotNull Map<String, String> mediationTypes) {
        kotlin.jvm.internal.t.i(mediationTypes, "mediationTypes");
        return new c4(mediationTypes);
    }

    public /* synthetic */ c4(Map map, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? kotlin.collections.r0.g() : map);
    }

    @NotNull
    public final Map<String, String> a() {
        return this.f11524a;
    }
}

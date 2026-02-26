package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private String f11866a;

    /* JADX WARN: Multi-variable type inference failed */
    public dt() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ dt a(dt dtVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = dtVar.f11866a;
        }
        return dtVar.a(str);
    }

    @Nullable
    public final String b() {
        return this.f11866a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dt) && kotlin.jvm.internal.t.d(this.f11866a, ((dt) obj).f11866a);
    }

    public int hashCode() {
        String str = this.f11866a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "TestSuiteSettings(controllerUrl=" + this.f11866a + ')';
    }

    public dt(@Nullable String str) {
        this.f11866a = str;
    }

    @NotNull
    public final dt a(@Nullable String str) {
        return new dt(str);
    }

    public final void b(@Nullable String str) {
        this.f11866a = str;
    }

    public /* synthetic */ dt(String str, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str);
    }

    @Nullable
    public final String a() {
        return this.f11866a;
    }
}

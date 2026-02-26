package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class vg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f15903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f15904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private r0 f15905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f15907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f15908f;

    public vg(@NotNull String appKey, @NotNull String userId) {
        kotlin.jvm.internal.t.i(appKey, "appKey");
        kotlin.jvm.internal.t.i(userId, "userId");
        this.f15903a = appKey;
        this.f15904b = userId;
    }

    public static /* synthetic */ vg a(vg vgVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vgVar.f15903a;
        }
        if ((i10 & 2) != 0) {
            str2 = vgVar.f15904b;
        }
        return vgVar.a(str, str2);
    }

    @NotNull
    public final String b() {
        return this.f15904b;
    }

    public final boolean c() {
        return this.f15906d;
    }

    @NotNull
    public final String d() {
        return this.f15903a;
    }

    @Nullable
    public final r0 e() {
        return this.f15905c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vg)) {
            return false;
        }
        vg vgVar = (vg) obj;
        return kotlin.jvm.internal.t.d(this.f15903a, vgVar.f15903a) && kotlin.jvm.internal.t.d(this.f15904b, vgVar.f15904b);
    }

    @Nullable
    public final String f() {
        return this.f15908f;
    }

    @Nullable
    public final String g() {
        return this.f15907e;
    }

    @NotNull
    public final String h() {
        return this.f15904b;
    }

    public int hashCode() {
        return (this.f15903a.hashCode() * 31) + this.f15904b.hashCode();
    }

    @NotNull
    public String toString() {
        return "InitConfig(appKey=" + this.f15903a + ", userId=" + this.f15904b + ')';
    }

    @NotNull
    public final vg a(@NotNull String appKey, @NotNull String userId) {
        kotlin.jvm.internal.t.i(appKey, "appKey");
        kotlin.jvm.internal.t.i(userId, "userId");
        return new vg(appKey, userId);
    }

    public final void b(@Nullable String str) {
        this.f15907e = str;
    }

    public final <T> T a(@NotNull dl<vg, T> mapper) {
        kotlin.jvm.internal.t.i(mapper, "mapper");
        return mapper.a(this);
    }

    @NotNull
    public final String a() {
        return this.f15903a;
    }

    public final void a(@Nullable r0 r0Var) {
        this.f15905c = r0Var;
    }

    public final void a(@Nullable String str) {
        this.f15908f = str;
    }

    public final void a(boolean z10) {
        this.f15906d = z10;
    }
}

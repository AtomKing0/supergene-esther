package com.ironsource;

import java.util.Calendar;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final tr f16365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final we f16366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f16367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16368d;

    public z2(@NotNull tr recordType, @NotNull we adProvider, @NotNull String adInstanceId) {
        kotlin.jvm.internal.t.i(recordType, "recordType");
        kotlin.jvm.internal.t.i(adProvider, "adProvider");
        kotlin.jvm.internal.t.i(adInstanceId, "adInstanceId");
        this.f16365a = recordType;
        this.f16366b = adProvider;
        this.f16367c = adInstanceId;
        this.f16368d = Calendar.getInstance().getTimeInMillis() / ((long) 1000);
    }

    @NotNull
    public final String a() {
        return this.f16367c;
    }

    @NotNull
    public final we b() {
        return this.f16366b;
    }

    @NotNull
    public final Map<String, Object> c() {
        return kotlin.collections.r0.j(v8.y.a(tj.f15402c, Integer.valueOf(this.f16366b.b())), v8.y.a("ts", String.valueOf(this.f16368d)));
    }

    @NotNull
    public final Map<String, Object> d() {
        return kotlin.collections.r0.j(v8.y.a(tj.f15401b, this.f16367c), v8.y.a(tj.f15402c, Integer.valueOf(this.f16366b.b())), v8.y.a("ts", String.valueOf(this.f16368d)), v8.y.a("rt", Integer.valueOf(this.f16365a.ordinal())));
    }

    @NotNull
    public final tr e() {
        return this.f16365a;
    }

    public final long f() {
        return this.f16368d;
    }
}

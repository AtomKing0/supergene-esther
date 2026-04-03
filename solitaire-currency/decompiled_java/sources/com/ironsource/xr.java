package com.ironsource;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class xr implements a8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f16201d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16202e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f16203f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f16204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f16205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final kg f16206c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public xr(@NotNull Context context, @NotNull String baseName, @NotNull kg sdkSharedPref) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(baseName, "baseName");
        kotlin.jvm.internal.t.i(sdkSharedPref, "sdkSharedPref");
        this.f16204a = context;
        this.f16205b = baseName;
        this.f16206c = sdkSharedPref;
    }

    private final Integer a(Integer num) {
        if (num != null && num.intValue() == -1) {
            return null;
        }
        return num;
    }

    @Override // com.ironsource.a8
    @Nullable
    public Long b(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        return a(Long.valueOf(this.f16206c.b(this.f16204a, new yr(identifier, this.f16205b + ".pacing_last_show_time").a(), -1L)));
    }

    @Override // com.ironsource.a8
    @Nullable
    public Integer c(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        return a(Integer.valueOf(this.f16206c.b(this.f16204a, new yr(identifier, this.f16205b + ".show_count_show_counter").a(), -1)));
    }

    public /* synthetic */ xr(Context context, String str, kg kgVar, int i10, kotlin.jvm.internal.k kVar) {
        this(context, str, (i10 & 4) != 0 ? new xq() : kgVar);
    }

    private final Long a(Long l10) {
        if (l10 != null && l10.longValue() == -1) {
            return null;
        }
        return l10;
    }

    @Override // com.ironsource.a8
    public void b(@NotNull String identifier, long j10) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        this.f16206c.a(this.f16204a, new yr(identifier, this.f16205b + ".pacing_last_show_time").a(), j10);
    }

    @Override // com.ironsource.a8
    @Nullable
    public Long a(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        return a(Long.valueOf(this.f16206c.b(this.f16204a, new yr(identifier, this.f16205b + ".show_count_threshold").a(), -1L)));
    }

    @Override // com.ironsource.a8
    public void a(@NotNull String identifier, int i10) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        this.f16206c.a(this.f16204a, new yr(identifier, this.f16205b + ".show_count_show_counter").a(), i10);
    }

    @Override // com.ironsource.a8
    public void a(@NotNull String identifier, long j10) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        this.f16206c.a(this.f16204a, new yr(identifier, this.f16205b + ".show_count_threshold").a(), j10);
    }
}

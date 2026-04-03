package com.ironsource;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class vq implements uq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final kg f15961a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f15962a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f15963b = "sessionNumber";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f15964c = "firstSessionTimestamp";

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public vq() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.eq
    public long a(@NotNull Context context, long j10) {
        kotlin.jvm.internal.t.i(context, "context");
        return this.f15961a.b(context, "firstSessionTimestamp", j10);
    }

    @Override // com.ironsource.wq
    public int b(@NotNull Context context, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        return this.f15961a.b(context, a.f15963b, i10);
    }

    public vq(@NotNull kg sdkSharedPref) {
        kotlin.jvm.internal.t.i(sdkSharedPref, "sdkSharedPref");
        this.f15961a = sdkSharedPref;
    }

    @Override // com.ironsource.wq
    public void a(@NotNull Context context, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f15961a.a(context, a.f15963b, i10);
    }

    @Override // com.ironsource.eq
    public void b(@NotNull Context context, long j10) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f15961a.a(context, "firstSessionTimestamp", j10);
    }

    public /* synthetic */ vq(kg kgVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? new xq() : kgVar);
    }
}

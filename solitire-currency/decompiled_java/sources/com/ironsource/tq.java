package com.ironsource;

import android.content.Context;
import com.ironsource.jg;
import com.ironsource.k9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class tq implements jg, jg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final uq f15459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final lq f15460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final k9 f15461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15463e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f15464a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f15465b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f15466c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f15467d = -1;

        private a() {
        }
    }

    public tq(@NotNull uq storage, @NotNull lq initResponseStorage, @NotNull k9 currentTimeProvider) {
        kotlin.jvm.internal.t.i(storage, "storage");
        kotlin.jvm.internal.t.i(initResponseStorage, "initResponseStorage");
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        this.f15459a = storage;
        this.f15460b = initResponseStorage;
        this.f15461c = currentTimeProvider;
        this.f15462d = -1;
        this.f15463e = -1L;
    }

    private final int b(Context context, uq uqVar) {
        int iB = uqVar.b(context, 0) + 1;
        uqVar.a(context, iB);
        return iB;
    }

    @Override // com.ironsource.jg
    public long a() {
        return this.f15463e;
    }

    @Override // com.ironsource.jg
    public int c() {
        return this.f15462d;
    }

    public /* synthetic */ tq(uq uqVar, lq lqVar, k9 k9Var, int i10, kotlin.jvm.internal.k kVar) {
        this(uqVar, (i10 & 2) != 0 ? new mq() : lqVar, (i10 & 4) != 0 ? new k9.a() : k9Var);
    }

    private final long a(Context context, uq uqVar) {
        long jA = uqVar.a(context, -1L);
        if (this.f15460b.a(context) || jA != -1) {
            return jA;
        }
        long jA2 = this.f15461c.a();
        IronLog.INTERNAL.verbose("set first session timestamp = " + jA2);
        uqVar.b(context, jA2);
        return jA2;
    }

    @Override // com.ironsource.jg
    @NotNull
    public String b() {
        String sessionId = IronSourceUtils.getSessionId();
        kotlin.jvm.internal.t.h(sessionId, "getSessionId()");
        return sessionId;
    }

    @Override // com.ironsource.jg.a
    public void a(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f15462d = b(context, this.f15459a);
        this.f15463e = a(context, this.f15459a);
    }
}

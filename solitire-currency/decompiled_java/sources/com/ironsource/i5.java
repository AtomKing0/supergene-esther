package com.ironsource;

import android.text.TextUtils;
import com.ironsource.i5;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i5 extends lu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final p2 f12542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final s1 f12543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final j5 f12544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final on f12545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final xm f12546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private k5 f12547j;

    public static final class a implements k5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a0 f12549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ mu f12550c;

        a(a0 a0Var, mu muVar) {
            this.f12549b = a0Var;
            this.f12550c = muVar;
        }

        @Override // com.ironsource.k5
        public void a(int i10, @NotNull String errorReason) {
            kotlin.jvm.internal.t.i(errorReason, "errorReason");
            this.f12550c.a(i10, errorReason);
        }

        @Override // com.ironsource.l4
        public void a(final int i10, @NotNull final String errorMessage, final int i11, @NotNull final String auctionFallback, final long j10) {
            kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
            kotlin.jvm.internal.t.i(auctionFallback, "auctionFallback");
            p2 p2Var = i5.this.f12542e;
            final i5 i5Var = i5.this;
            final a0 a0Var = this.f12549b;
            final mu muVar = this.f12550c;
            p2Var.a(new Runnable() { // from class: com.ironsource.sw
                @Override // java.lang.Runnable
                public final void run() {
                    i5.a.a(i5Var, a0Var, muVar, i10, errorMessage, i11, auctionFallback, j10);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(i5 this$0, a0 adInstanceFactory, mu waterfallFetcherListener, int i10, String errorMessage, int i11, String auctionFallback, long j10) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(adInstanceFactory, "$adInstanceFactory");
            kotlin.jvm.internal.t.i(waterfallFetcherListener, "$waterfallFetcherListener");
            kotlin.jvm.internal.t.i(errorMessage, "$errorMessage");
            kotlin.jvm.internal.t.i(auctionFallback, "$auctionFallback");
            this$0.f12547j = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, i10, errorMessage, i11, auctionFallback, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(i5 this$0, a0 adInstanceFactory, mu waterfallFetcherListener, List newWaterfall, String auctionId, f5 genericNotifications, JSONObject genericParams, JSONObject jSONObject, int i10, long j10, int i11, String str) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(adInstanceFactory, "$adInstanceFactory");
            kotlin.jvm.internal.t.i(waterfallFetcherListener, "$waterfallFetcherListener");
            kotlin.jvm.internal.t.i(newWaterfall, "$newWaterfall");
            kotlin.jvm.internal.t.i(auctionId, "$auctionId");
            kotlin.jvm.internal.t.i(genericNotifications, "$genericNotifications");
            kotlin.jvm.internal.t.i(genericParams, "$genericParams");
            this$0.f12547j = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, newWaterfall, auctionId, genericNotifications, genericParams, jSONObject, i10, j10, i11, str);
        }

        @Override // com.ironsource.l4
        public void a(@NotNull final List<f5> newWaterfall, @NotNull final String auctionId, @NotNull final f5 genericNotifications, @NotNull final JSONObject genericParams, @Nullable final JSONObject jSONObject, final int i10, final long j10, final int i11, @Nullable final String str) {
            kotlin.jvm.internal.t.i(newWaterfall, "newWaterfall");
            kotlin.jvm.internal.t.i(auctionId, "auctionId");
            kotlin.jvm.internal.t.i(genericNotifications, "genericNotifications");
            kotlin.jvm.internal.t.i(genericParams, "genericParams");
            p2 p2Var = i5.this.f12542e;
            final i5 i5Var = i5.this;
            final a0 a0Var = this.f12549b;
            final mu muVar = this.f12550c;
            p2Var.a(new Runnable() { // from class: com.ironsource.rw
                @Override // java.lang.Runnable
                public final void run() {
                    i5.a.a(i5Var, a0Var, muVar, newWaterfall, auctionId, genericNotifications, genericParams, jSONObject, i10, j10, i11, str);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i5(@NotNull p2 adTools, @NotNull s1 adUnitData) {
        super(adTools, adUnitData);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        this.f12542e = adTools;
        this.f12543f = adUnitData;
        j5 j5Var = new j5(adTools, adUnitData);
        this.f12544g = j5Var;
        this.f12545h = j5Var.b();
        this.f12546i = new xm(adTools, adUnitData);
    }

    @Override // com.ironsource.lu
    @NotNull
    public on a() {
        return this.f12545h;
    }

    @Override // com.ironsource.lu
    public void a(@NotNull a0 adInstanceFactory, @NotNull mu waterfallFetcherListener) {
        kotlin.jvm.internal.t.i(adInstanceFactory, "adInstanceFactory");
        kotlin.jvm.internal.t.i(waterfallFetcherListener, "waterfallFetcherListener");
        a aVar = new a(adInstanceFactory, waterfallFetcherListener);
        this.f12544g.b(aVar);
        this.f12547j = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(a0 a0Var, mu muVar, int i10, String str, int i11, String str2, long j10) {
        IronLog.INTERNAL.verbose(k1.a(this.f12542e, "Auction failed | moving to fallback waterfall (error " + i10 + " - " + str + ')', (String) null, 2, (Object) null));
        this.f12542e.e().b().a(j10, i10, str);
        this.f12546i.a(muVar, i11, str2, a0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(a0 a0Var, mu muVar, List<f5> list, String str, f5 f5Var, JSONObject jSONObject, JSONObject jSONObject2, int i10, long j10, int i11, String str2) {
        IronLog.INTERNAL.verbose(k1.a(this.f12542e, (String) null, (String) null, 3, (Object) null));
        c5 c5Var = new c5(str, jSONObject, f5Var, i10, "");
        if (!TextUtils.isEmpty(str2)) {
            this.f12542e.e().g().a(i11, str2);
        }
        a(jSONObject2);
        nu nuVarA = a(list, c5Var, a0Var);
        this.f12542e.e().a(new n4(c5Var));
        this.f12542e.e().b().a(j10, this.f12543f.w());
        this.f12542e.e().b().c(nuVarA.d());
        a(nuVarA, muVar);
    }

    private final void a(nu nuVar, mu muVar) {
        this.f12542e.i().a(nuVar);
        muVar.a(nuVar);
    }

    private final void a(JSONObject jSONObject) {
        int i10;
        try {
            if (jSONObject == null) {
                this.f12543f.b(false);
                IronLog.INTERNAL.verbose(k1.a(this.f12542e, "loading configuration from auction response is null, using the following: " + this.f12543f.w(), (String) null, 2, (Object) null));
                return;
            }
            try {
                if (jSONObject.has(com.ironsource.mediationsdk.d.f13342w) && (i10 = jSONObject.getInt(com.ironsource.mediationsdk.d.f13342w)) > 0) {
                    this.f12543f.a(i10);
                }
                if (jSONObject.has(com.ironsource.mediationsdk.d.f13343x)) {
                    this.f12543f.a(jSONObject.getBoolean(com.ironsource.mediationsdk.d.f13343x));
                }
                this.f12543f.b(jSONObject.optBoolean(com.ironsource.mediationsdk.d.f13344y, false));
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("failed to update loading configuration for" + this.f12543f.b().a() + " Error: " + e10.getMessage());
                ironLog.verbose(k1.a(this.f12542e, this.f12543f.w(), (String) null, 2, (Object) null));
            }
        } finally {
            IronLog.INTERNAL.verbose(k1.a(this.f12542e, this.f12543f.w(), (String) null, 2, (Object) null));
        }
    }
}

package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.h7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class sl extends h7<wl, AdapterAdListener> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sl(@Nullable List<? extends NetworkSettings> list, @NotNull jl configs, @Nullable String str, @NotNull lj publisherDataHolder, @Nullable IronSourceSegment ironSourceSegment) {
        super(new tl(str, list, configs), publisherDataHolder, ironSourceSegment);
        kotlin.jvm.internal.t.i(configs, "configs");
        kotlin.jvm.internal.t.i(publisherDataHolder, "publisherDataHolder");
    }

    @Override // com.ironsource.h7
    protected boolean H() {
        return false;
    }

    public final void M() {
        ut utVar;
        int iIntValue;
        sk skVar;
        IronLog.INTERNAL.verbose();
        try {
            wl wlVar = (wl) this.f12401a.d();
            if (wlVar != null) {
                Integer numR = wlVar.r();
                if (numR == null) {
                    iIntValue = this.C.a(this.f12415o.b());
                } else {
                    kotlin.jvm.internal.t.h(numR, "it.sessionDepth ?: sessi…epth(mManagerData.adUnit)");
                    iIntValue = numR.intValue();
                }
                x1 x1Var = this.f12419s;
                if (x1Var != null && (skVar = x1Var.f16108g) != null) {
                    skVar.a(iIntValue);
                }
                wlVar.P();
                this.f12401a.a(null);
                this.f12401a.b(null);
            }
            this.f12409i = null;
            a(h7.f.NONE);
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "destroyNativeAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(b(str));
            x1 x1Var2 = this.f12419s;
            if (x1Var2 == null || (utVar = x1Var2.f16112k) == null) {
                return;
            }
            utVar.f(str);
        }
    }

    @Override // com.ironsource.h7
    public /* bridge */ /* synthetic */ k7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i10, String str, f5 f5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdListener>) baseAdAdapter, i10, str, f5Var);
    }

    @NotNull
    protected wl b(@NotNull NetworkSettings providerSettings, @NotNull BaseAdAdapter<?, AdapterAdListener> adapter, int i10, @NotNull String currentAuctionId, @NotNull f5 item) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        kotlin.jvm.internal.t.i(adapter, "adapter");
        kotlin.jvm.internal.t.i(currentAuctionId, "currentAuctionId");
        kotlin.jvm.internal.t.i(item, "item");
        return new wl(this, new i1(IronSource.AD_UNIT.NATIVE_AD, this.f12415o.p(), i10, this.f12407g, currentAuctionId, this.f12405e, this.f12406f, providerSettings, this.f12415o.o()), adapter, this.f12409i, item, this);
    }

    @Override // com.ironsource.h7
    @NotNull
    protected e2 g() {
        return new ua();
    }

    @Override // com.ironsource.h7
    @NotNull
    protected String l() {
        return "NA";
    }

    @Override // com.ironsource.h7
    @NotNull
    protected String o() {
        return IronSourceConstants.OPW_NT_MANAGER_NAME;
    }

    @Override // com.ironsource.h7
    protected boolean v() {
        return false;
    }

    @Override // com.ironsource.h7, com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@NotNull u1 event) {
        kotlin.jvm.internal.t.i(event, "event");
        Map<String, Object> data = super.a(event);
        Placement placement = this.f12409i;
        if (placement != null) {
            kotlin.jvm.internal.t.h(data, "data");
            data.put("placement", placement.getPlacementName());
        }
        UUID uuid = this.f12423w;
        if (uuid != null) {
            kotlin.jvm.internal.t.h(data, "data");
            data.put("objectId", uuid);
        }
        kotlin.jvm.internal.t.h(data, "data");
        return data;
    }

    @Override // com.ironsource.h7
    @NotNull
    protected JSONObject b(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        JSONObject nativeAdSettings = providerSettings.getNativeAdSettings();
        kotlin.jvm.internal.t.h(nativeAdSettings, "providerSettings.nativeAdSettings");
        return nativeAdSettings;
    }

    @Override // com.ironsource.h7
    protected void a(@Nullable k7<?> k7Var, @Nullable AdInfo adInfo) {
        if (k7Var instanceof wl) {
            wl wlVar = (wl) k7Var;
            this.f12420t.a(wlVar.Q(), wlVar.R(), adInfo);
        }
    }

    public final void a(@NotNull InternalNativeAdListener nativeAdListener) {
        kotlin.jvm.internal.t.i(nativeAdListener, "nativeAdListener");
        a(new rl(nativeAdListener));
    }

    @Override // com.ironsource.h7
    protected void a(@Nullable IronSourceError ironSourceError) {
        this.f12420t.a(ironSourceError);
    }

    public final void a(@Nullable Placement placement) {
        String str;
        int iB;
        IronLog.INTERNAL.verbose("placement = " + placement);
        if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
            Object[] objArr = new Object[1];
            objArr[0] = placement == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load native ad - %s", Arrays.copyOf(objArr, 1));
            kotlin.jvm.internal.t.h(str, "format(format, *args)");
            iB = t1.b(this.f12415o.b());
        } else if (this.E.b(ContextProvider.getInstance().getApplicationContext(), placement, this.f12415o.b())) {
            kotlin.jvm.internal.s0 s0Var2 = kotlin.jvm.internal.s0.f29840a;
            str = String.format("placement %s is capped", Arrays.copyOf(new Object[]{placement.getPlacementName()}, 1));
            kotlin.jvm.internal.t.h(str, "format(format, *args)");
            iB = t1.f(this.f12415o.b());
        } else {
            str = null;
            iB = 510;
        }
        if (TextUtils.isEmpty(str)) {
            this.f12409i = placement;
            A();
        } else {
            IronLog.API.error(b(str));
            a(iB, str, false);
        }
    }

    @Override // com.ironsource.h7
    protected void G() {
    }
}

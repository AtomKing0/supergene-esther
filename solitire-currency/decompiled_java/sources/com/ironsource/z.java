package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class z implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f16355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final y f16356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final BaseAdAdapter<?, ?> f16357c;

    public z(@NotNull p2 adTools, @NotNull y instanceData, @Nullable BaseAdAdapter<?, ?> baseAdAdapter) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        this.f16355a = adTools;
        this.f16356b = instanceData;
        this.f16357c = baseAdAdapter;
    }

    @Override // com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@NotNull u1 event) {
        String adapterVersion;
        kotlin.jvm.internal.t.i(event, "event");
        HashMap map = new HashMap();
        try {
            BaseAdAdapter<?, ?> baseAdAdapter = this.f16357c;
            String networkSDKVersion = "";
            if (baseAdAdapter != null) {
                AdapterBaseInterface networkAdapter = baseAdAdapter.getNetworkAdapter();
                kotlin.jvm.internal.t.f(networkAdapter);
                adapterVersion = networkAdapter.getAdapterVersion();
            } else {
                adapterVersion = "";
            }
            kotlin.jvm.internal.t.h(adapterVersion, "if (adapter != null) ada…!!.adapterVersion else \"\"");
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterVersion);
            BaseAdAdapter<?, ?> baseAdAdapter2 = this.f16357c;
            if (baseAdAdapter2 != null) {
                AdapterBaseInterface networkAdapter2 = baseAdAdapter2.getNetworkAdapter();
                kotlin.jvm.internal.t.f(networkAdapter2);
                networkSDKVersion = networkAdapter2.getNetworkSDKVersion();
            }
            kotlin.jvm.internal.t.f(networkSDKVersion);
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, networkSDKVersion);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(k1.a(this.f16355a, "could not get adapter version for event data " + this.f16356b.w(), (String) null, 2, (Object) null));
        }
        String strI = this.f16356b.j().i();
        kotlin.jvm.internal.t.h(strI, "instanceData.adapterConfig.subProviderId");
        map.put("spId", strI);
        String strA = this.f16356b.j().a();
        kotlin.jvm.internal.t.h(strA, "instanceData.adapterConfig.adSourceNameForEvents");
        map.put(IronSourceConstants.EVENTS_PROVIDER, strA);
        map.put("instanceType", Integer.valueOf(this.f16356b.s()));
        String serverData = this.f16356b.n().j();
        p2 p2Var = this.f16355a;
        kotlin.jvm.internal.t.h(serverData, "serverData");
        String strH = p2Var.h(serverData);
        if (!TextUtils.isEmpty(strH)) {
            map.put("dynamicDemandSource", strH);
        }
        map.put("sessionDepth", Integer.valueOf(this.f16356b.v()));
        if (!TextUtils.isEmpty(this.f16356b.u().getCustomNetwork())) {
            String customNetwork = this.f16356b.u().getCustomNetwork();
            kotlin.jvm.internal.t.h(customNetwork, "instanceData.providerSettings.customNetwork");
            map.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, customNetwork);
        }
        return map;
    }
}

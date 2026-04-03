package com.ironsource;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class t8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Boolean f15389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ce f15390b = el.f11917p.d().f();

    private final int a(String str) {
        return Log.i("ironSourceSDK: GENERAL", str);
    }

    @NotNull
    public final ce b() {
        return this.f15390b;
    }

    private final void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            ji.i().a(new kb(IronSourceConstants.TROUBLESHOOTING_CONSENT_INTERNAL_ERROR, jSONObject));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Nullable
    public final Boolean a() {
        return this.f15389a;
    }

    private final Boolean a(NetworkSettings networkSettings) {
        return (networkSettings == null || networkSettings.isCustomNetwork()) ? this.f15389a : networkSettings.getApplicationSettings().has(u8.f15576a) ? Boolean.valueOf(networkSettings.getApplicationSettings().optBoolean(u8.f15576a)) : this.f15389a;
    }

    public final void a(int i10) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, i10 + ';' + this.f15390b.H(ContextProvider.getInstance().getApplicationContext()));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(v8.f.b(e10));
        }
        rp.i().a(new kb(42, mediationAdditionalData));
    }

    public final void a(int i10, @NotNull ConcurrentHashMap<String, NetworkSettings> providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        a("TCF Additional Consent: " + this.f15390b.H(ContextProvider.getInstance().getApplicationContext()));
        a("CMP ID: " + i10);
        a("Network Consent Reporting:");
        a("----------------------------");
        Collection<NetworkSettings> collectionValues = providerSettings.values();
        kotlin.jvm.internal.t.h(collectionValues, "providerSettings.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            boolean z10 = false;
            if (networkSettings.getProviderDefaultInstance() != null && !kotlin.jvm.internal.t.d(networkSettings.getProviderDefaultInstance(), IronSourceConstants.SUPERSONIC_CONFIG_NAME)) {
                JSONObject applicationSettings = networkSettings.getApplicationSettings();
                if (applicationSettings != null && applicationSettings.has(u8.f15576a)) {
                    z10 = true;
                }
            }
            if (z10) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList<NetworkSettings> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (hashSet.add(((NetworkSettings) obj2).getProviderDefaultInstance())) {
                arrayList2.add(obj2);
            }
        }
        for (NetworkSettings networkSettings2 : arrayList2) {
            StringBuilder sb = new StringBuilder();
            sb.append(networkSettings2.getProviderDefaultInstance());
            sb.append(": ");
            JSONObject applicationSettings2 = networkSettings2.getApplicationSettings();
            sb.append(applicationSettings2 != null ? Boolean.valueOf(applicationSettings2.optBoolean(u8.f15576a)) : null);
            a(sb.toString());
        }
    }

    public final void a(@NotNull AbstractAdapter adapter, @Nullable NetworkSettings networkSettings) {
        kotlin.jvm.internal.t.i(adapter, "adapter");
        try {
            Boolean boolA = a(networkSettings);
            if (boolA != null) {
                adapter.setNewConsent(boolA.booleanValue());
            }
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "error while setting consent of " + adapter.getProviderName() + ": " + th.getLocalizedMessage();
            b(str);
            IronLog.INTERNAL.error(str);
        }
    }

    public final void a(@NotNull AdapterBaseInterface adapter, @Nullable NetworkSettings networkSettings) {
        kotlin.jvm.internal.t.i(adapter, "adapter");
        try {
            Boolean boolA = a(networkSettings);
            if (boolA == null || !(adapter instanceof AdapterConsentInterface)) {
                return;
            }
            ((AdapterConsentInterface) adapter).setConsent(boolA.booleanValue());
        } catch (Throwable th) {
            i9.d().a(th);
            StringBuilder sb = new StringBuilder();
            sb.append("error while setting consent of ");
            sb.append(networkSettings != null ? networkSettings.getProviderName() : null);
            sb.append(": ");
            sb.append(th.getLocalizedMessage());
            String string = sb.toString();
            b(string);
            IronLog.INTERNAL.error(string);
        }
    }

    public final void a(@NotNull ConcurrentHashMap<String, AbstractAdapter> adapters, @NotNull ConcurrentHashMap<String, AdapterBaseWrapper> networkAdapters) {
        v8.k0 k0Var;
        kotlin.jvm.internal.t.i(adapters, "adapters");
        kotlin.jvm.internal.t.i(networkAdapters, "networkAdapters");
        for (AbstractAdapter adapter : adapters.values()) {
            kotlin.jvm.internal.t.h(adapter, "adapter");
            a(adapter, (NetworkSettings) null);
        }
        for (AdapterBaseWrapper adapterBaseWrapper : networkAdapters.values()) {
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
            if (adapterBaseInterface != null) {
                a(adapterBaseInterface, adapterBaseWrapper.getSettings());
                k0Var = v8.k0.f35197a;
            } else {
                k0Var = null;
            }
            if (k0Var == null) {
                IronLog.INTERNAL.error("adapter is null");
            }
        }
    }

    public final void a(boolean z10) {
        this.f15389a = Boolean.valueOf(z10);
    }
}

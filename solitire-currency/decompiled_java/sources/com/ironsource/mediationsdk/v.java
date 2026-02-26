package com.ironsource.mediationsdk;

import com.ironsource.ji;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements AdapterNetworkData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f13913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final JSONObject f13914b;

    public v(@NotNull String networkName, @NotNull JSONObject data) {
        kotlin.jvm.internal.t.i(networkName, "networkName");
        kotlin.jvm.internal.t.i(data, "data");
        this.f13913a = networkName;
        this.f13914b = new JSONObject(data.toString());
    }

    @NotNull
    public final String a() {
        return this.f13913a;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    @NotNull
    public JSONObject allData() {
        return this.f13914b;
    }

    public final void b() {
        Iterator<String> itKeys = this.f13914b.keys();
        kotlin.jvm.internal.t.h(itKeys, "networkData.keys()");
        String strR0 = d0.r0(o9.o.w(o9.m.c(itKeys)), ",", null, null, 0, null, null, 62, null);
        ji.i().a(new kb(57, IronSourceUtils.getMediationAdditionalData(false).put(IronSourceConstants.EVENTS_EXT1, this.f13913a + " - " + strR0)));
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    @Nullable
    public <T> T dataByKeyIgnoreCase(@NotNull String desiredKey, @NotNull Class<T> valueType) {
        T next;
        kotlin.jvm.internal.t.i(desiredKey, "desiredKey");
        kotlin.jvm.internal.t.i(valueType, "valueType");
        Iterator<String> itKeys = allData().keys();
        kotlin.jvm.internal.t.h(itKeys, "allData()\n          .keys()");
        Iterator<T> it = o9.m.c(itKeys).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            if (p9.q.x((String) next, desiredKey, true)) {
                break;
            }
        }
        String str = next;
        if (str == null) {
            return null;
        }
        Object objOpt = allData().opt(str);
        if (!valueType.isInstance(objOpt)) {
            objOpt = null;
        }
        if (objOpt != null) {
            return valueType.cast(objOpt);
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    @NotNull
    public JSONObject networkDataByAdUnit(@NotNull IronSource.AD_UNIT adUnit) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        JSONObject jSONObjectOptJSONObject = this.f13914b.optJSONObject(adUnit.toString());
        return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
    }

    @NotNull
    public String toString() {
        return "NetworkData(networkName=" + this.f13913a + ", networkData=" + this.f13914b + ')';
    }

    private final void a(Collection<? extends AbstractAdapter> collection) {
        List listF0 = d0.f0(collection);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listF0) {
            if (c.a(this.f13913a, (AbstractAdapter) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AbstractAdapter) it.next()).setNetworkData(this);
        }
    }

    private final void b(Collection<? extends AdapterBaseWrapper> collection) {
        List listF0 = d0.f0(collection);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listF0) {
            if (c.a(this.f13913a, (AdapterBaseWrapper) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((AdapterBaseWrapper) it.next()).getAdapterBaseInterface());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (obj2 instanceof AdapterNetworkDataInterface) {
                arrayList3.add(obj2);
            }
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            ((AdapterNetworkDataInterface) it2.next()).setNetworkData(this);
        }
    }

    public final void a(@NotNull Collection<? extends AbstractAdapter> adapters, @NotNull Collection<? extends AdapterBaseWrapper> networkAdapters) {
        kotlin.jvm.internal.t.i(adapters, "adapters");
        kotlin.jvm.internal.t.i(networkAdapters, "networkAdapters");
        try {
            a(adapters);
            b(networkAdapters);
        } catch (Exception e10) {
            IronLog.INTERNAL.error("error while setting network data: " + e10.getMessage());
        }
    }
}

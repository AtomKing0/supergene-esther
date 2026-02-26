package com.ironsource;

import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class dm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<String, JSONObject> f11849a;

    /* JADX WARN: Multi-variable type inference failed */
    public dm() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ dm a(dm dmVar, ConcurrentHashMap concurrentHashMap, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            concurrentHashMap = dmVar.f11849a;
        }
        return dmVar.a((ConcurrentHashMap<String, JSONObject>) concurrentHashMap);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dm) && kotlin.jvm.internal.t.d(this.f11849a, ((dm) obj).f11849a);
    }

    public int hashCode() {
        return this.f11849a.hashCode();
    }

    @NotNull
    public String toString() {
        return "NetworkDataStore(networkDataMap=" + this.f11849a + ')';
    }

    public dm(@NotNull ConcurrentHashMap<String, JSONObject> networkDataMap) {
        kotlin.jvm.internal.t.i(networkDataMap, "networkDataMap");
        this.f11849a = networkDataMap;
    }

    @NotNull
    public final dm a(@NotNull ConcurrentHashMap<String, JSONObject> networkDataMap) {
        kotlin.jvm.internal.t.i(networkDataMap, "networkDataMap");
        return new dm(networkDataMap);
    }

    public /* synthetic */ dm(ConcurrentHashMap concurrentHashMap, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? new ConcurrentHashMap() : concurrentHashMap);
    }

    private final ConcurrentHashMap<String, JSONObject> a() {
        return this.f11849a;
    }

    public final void a(@NotNull AbstractAdapter adapter) {
        kotlin.jvm.internal.t.i(adapter, "adapter");
        Set<Map.Entry<String, JSONObject>> setEntrySet = this.f11849a.entrySet();
        kotlin.jvm.internal.t.h(setEntrySet, "networkDataMap.entries");
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (com.ironsource.mediationsdk.c.a((String) ((Map.Entry) obj).getKey(), adapter)) {
                arrayList.add(obj);
            }
        }
        for (Map.Entry entry : arrayList) {
            Object key = entry.getKey();
            kotlin.jvm.internal.t.h(key, "it.key");
            Object value = entry.getValue();
            kotlin.jvm.internal.t.h(value, "it.value");
            adapter.setNetworkData(new com.ironsource.mediationsdk.v((String) key, (JSONObject) value));
        }
    }

    public final void a(@Nullable AdapterBaseWrapper adapterBaseWrapper) {
        Set<Map.Entry<String, JSONObject>> setEntrySet = this.f11849a.entrySet();
        kotlin.jvm.internal.t.h(setEntrySet, "networkDataMap.entries");
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (com.ironsource.mediationsdk.c.a((String) ((Map.Entry) obj).getKey(), adapterBaseWrapper)) {
                arrayList.add(obj);
            }
        }
        for (Map.Entry entry : arrayList) {
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper != null ? adapterBaseWrapper.getAdapterBaseInterface() : null;
            kotlin.jvm.internal.t.g(adapterBaseInterface, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface");
            Object key = entry.getKey();
            kotlin.jvm.internal.t.h(key, "it.key");
            Object value = entry.getValue();
            kotlin.jvm.internal.t.h(value, "it.value");
            ((AdapterNetworkDataInterface) adapterBaseInterface).setNetworkData(new com.ironsource.mediationsdk.v((String) key, (JSONObject) value));
        }
    }

    public final void a(@NotNull com.ironsource.mediationsdk.v networkData) {
        kotlin.jvm.internal.t.i(networkData, "networkData");
        if (!this.f11849a.containsKey(networkData.a())) {
            this.f11849a.put(networkData.a(), networkData.allData());
            return;
        }
        try {
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = this.f11849a;
            String strA = networkData.a();
            JSONObject jSONObject = this.f11849a.get(networkData.a());
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObjectDeepMergeJSONObjects = IronSourceUtils.deepMergeJSONObjects(jSONObject, networkData.allData());
            kotlin.jvm.internal.t.h(jSONObjectDeepMergeJSONObjects, "deepMergeJSONObjects(\n  …), networkData.allData())");
            concurrentHashMap.put(strA, jSONObjectDeepMergeJSONObjects);
        } catch (Exception e10) {
            IronLog.INTERNAL.error("error while merging network data: " + e10.getMessage());
        }
    }
}

package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface da {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Map<String, Object> f11783a;

        public a(@NotNull String providerName) {
            kotlin.jvm.internal.t.i(providerName, "providerName");
            this.f11783a = kotlin.collections.r0.l(v8.y.a(IronSourceConstants.EVENTS_PROVIDER, providerName), v8.y.a(IronSourceConstants.EVENTS_DEMAND_ONLY, 1));
        }

        @NotNull
        public final Map<String, Object> a() {
            return kotlin.collections.r0.z(this.f11783a);
        }

        public final void a(@NotNull String key, @NotNull Object value) {
            kotlin.jvm.internal.t.i(key, "key");
            kotlin.jvm.internal.t.i(value, "value");
            this.f11783a.put(key, value);
        }
    }

    public static final class b implements da {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ge f11784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final a f11785b;

        public b(@NotNull ge eventManager, @NotNull a eventBaseData) {
            kotlin.jvm.internal.t.i(eventManager, "eventManager");
            kotlin.jvm.internal.t.i(eventBaseData, "eventBaseData");
            this.f11784a = eventManager;
            this.f11785b = eventBaseData;
        }

        @Override // com.ironsource.da
        public void a(int i10, @Nullable qq qqVar) {
            Map<String, Object> mapA = this.f11785b.a();
            mapA.put(IronSourceConstants.EVENTS_EXT1, String.valueOf(qqVar));
            this.f11784a.a(new kb(i10, new JSONObject(kotlin.collections.r0.u(mapA))));
        }

        @Override // com.ironsource.da
        public void a(int i10, @NotNull String instanceId) {
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            Map<String, Object> mapA = this.f11785b.a();
            mapA.put("spId", instanceId);
            this.f11784a.a(new kb(i10, new JSONObject(kotlin.collections.r0.u(mapA))));
        }
    }

    void a(int i10, @Nullable qq qqVar);

    void a(int i10, @NotNull String str);
}

package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.ng;
import com.ironsource.sdk.controller.FeaturesManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class lr implements ng, ng.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private Map<String, v> f13060a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final hm f13061b = new hm();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ReadWriteLock f13062c = new ReentrantReadWriteLock();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13063a;

        static {
            int[] iArr = new int[kr.values().length];
            try {
                iArr[kr.CurrentlyLoadedAdsAndFullHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[kr.CurrentlyLoadedAds.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[kr.Off.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f13063a = iArr;
        }
    }

    private final void b() {
        jr configuration = FeaturesManager.getInstance().getSessionHistoryConfig();
        hm hmVar = this.f13061b;
        kotlin.jvm.internal.t.h(configuration, "configuration");
        hmVar.a(a(configuration));
        this.f13061b.a(a());
    }

    @Override // com.ironsource.ng
    public int a(@NotNull IronSource.AD_UNIT adFormat) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        this.f13062c.readLock().lock();
        try {
            v vVar = this.f13060a.get(adFormat.toString());
            return vVar != null ? vVar.a() : 0;
        } finally {
            this.f13062c.readLock().unlock();
        }
    }

    @Override // com.ironsource.ng
    @NotNull
    public List<String> a() {
        this.f13062c.readLock().lock();
        try {
            Map<String, v> map = this.f13060a;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, v> entry : map.entrySet()) {
                if (entry.getValue().b()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return kotlin.collections.d0.P0(linkedHashMap.keySet());
        } finally {
            this.f13062c.readLock().unlock();
        }
    }

    @Override // com.ironsource.ng
    @NotNull
    public Map<String, JSONObject> a(@NotNull jr configuration) {
        Map<String, JSONObject> mapL;
        kotlin.jvm.internal.t.i(configuration, "configuration");
        this.f13062c.readLock().lock();
        try {
            int i10 = a.f13063a[configuration.a().ordinal()];
            if (i10 == 1) {
                mapL = kotlin.collections.r0.l(v8.y.a(ad.f11241h1, a(vr.FullHistory)), v8.y.a(ad.f11244i1, a(vr.CurrentlyLoadedAds)));
            } else if (i10 == 2) {
                mapL = kotlin.collections.r0.l(v8.y.a(ad.f11244i1, a(vr.CurrentlyLoadedAds)));
            } else {
                if (i10 != 3) {
                    throw new v8.q();
                }
                mapL = kotlin.collections.r0.g();
            }
            return mapL;
        } finally {
            this.f13062c.readLock().unlock();
        }
    }

    @Override // com.ironsource.ng
    @NotNull
    public JSONObject a(@NotNull vr mode) {
        kotlin.jvm.internal.t.i(mode, "mode");
        this.f13062c.readLock().lock();
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, v> entry : this.f13060a.entrySet()) {
                String key = entry.getKey();
                JSONObject jSONObjectA = entry.getValue().a(mode);
                if (jSONObjectA.length() > 0) {
                    jSONObject.put(key, jSONObjectA);
                }
            }
            return jSONObject;
        } finally {
            this.f13062c.readLock().unlock();
        }
    }

    @Override // com.ironsource.ng.a
    public void a(@NotNull mr historyRecord) {
        kotlin.jvm.internal.t.i(historyRecord, "historyRecord");
        this.f13062c.writeLock().lock();
        try {
            k0 k0VarA = historyRecord.a();
            String strValueOf = String.valueOf(k0VarA != null ? k0VarA.b() : null);
            Map<String, v> map = this.f13060a;
            v vVar = map.get(strValueOf);
            if (vVar == null) {
                vVar = new v();
                map.put(strValueOf, vVar);
            }
            vVar.a(historyRecord.a(new sr()));
            this.f13062c.writeLock().unlock();
            b();
        } catch (Throwable th) {
            this.f13062c.writeLock().unlock();
            throw th;
        }
    }
}

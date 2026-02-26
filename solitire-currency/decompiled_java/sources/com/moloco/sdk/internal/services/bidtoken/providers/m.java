package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.q0;
import kotlin.collections.w;
import kotlin.jvm.internal.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18521c = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<j<?>> f18522b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(@NotNull List<? extends j<?>> signalProviders) {
        kotlin.jvm.internal.t.i(signalProviders, "signalProviders");
        this.f18522b = signalProviders;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        Iterator<j<?>> it = this.f18522b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        List<j<?>> list = this.f18522b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                boolean zB = jVar.b();
                if (zB) {
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "ClientBidTokenSignalProviderImpl", "[CBT] Signal provider " + jVar.c() + " needs refresh", null, false, 12, null);
                }
                if (zB) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return "ClientBidTokenSignalProviderImpl";
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public k d() {
        List<j<?>> list = this.f18522b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(q0.d(w.v(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(o0.b(((j) obj).getClass()), obj);
        }
        Object obj2 = linkedHashMap.get(o0.b(u.class));
        kotlin.jvm.internal.t.g(obj2, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.SDKInitStateSignalProvider");
        boolean zBooleanValue = ((u) obj2).d().booleanValue();
        Object obj3 = linkedHashMap.get(o0.b(t.class));
        kotlin.jvm.internal.t.g(obj3, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.PrivacyStateSignalProvider");
        MolocoPrivacy.PrivacySettings privacySettingsD = ((t) obj3).d();
        Object obj4 = linkedHashMap.get(o0.b(q.class));
        kotlin.jvm.internal.t.g(obj4, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.MemorySignalProvider");
        p pVarD = ((q) obj4).d();
        Object obj5 = linkedHashMap.get(o0.b(e.class));
        kotlin.jvm.internal.t.g(obj5, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AppDirInfoSignalProvider");
        d dVarD = ((e) obj5).d();
        Object obj6 = linkedHashMap.get(o0.b(s.class));
        kotlin.jvm.internal.t.g(obj6, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.NetworkInfoSignalProvider");
        r rVarD = ((s) obj6).d();
        Object obj7 = linkedHashMap.get(o0.b(i.class));
        kotlin.jvm.internal.t.g(obj7, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.BatteryInfoSignalProvider");
        h hVarD = ((i) obj7).d();
        Object obj8 = linkedHashMap.get(o0.b(c.class));
        kotlin.jvm.internal.t.g(obj8, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AdvertisingSignalProvider");
        com.moloco.sdk.internal.services.f fVarD = ((c) obj8).d();
        Object obj9 = linkedHashMap.get(o0.b(o.class));
        kotlin.jvm.internal.t.g(obj9, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.DeviceSignalProvider");
        n nVarD = ((o) obj9).d();
        Object obj10 = linkedHashMap.get(o0.b(g.class));
        kotlin.jvm.internal.t.g(obj10, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AudioSignalProvider");
        f fVarD2 = ((g) obj10).d();
        Object obj11 = linkedHashMap.get(o0.b(b.class));
        kotlin.jvm.internal.t.g(obj11, "null cannot be cast to non-null type com.moloco.sdk.internal.services.bidtoken.providers.AccessibilitySignalProvider");
        return new k(zBooleanValue, privacySettingsD, pVarD, dVarD, rVarD, hVarD, fVarD, nVarD, fVarD2, ((b) obj11).d());
    }
}

package com.moloco.sdk.internal.services.config;

import com.moloco.sdk.g;
import com.moloco.sdk.i;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18618a = "RemoteConfigService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Map<String, Object> f18619b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final Map<String, String> f18620c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<com.moloco.sdk.internal.services.config.handlers.a> f18621d = u.e(new com.moloco.sdk.internal.services.config.handlers.b());

    @Override // com.moloco.sdk.internal.services.config.a
    public void a(@NotNull i sdkInitResponse) {
        t.i(sdkInitResponse, "sdkInitResponse");
        c(sdkInitResponse);
        d(sdkInitResponse);
    }

    @Override // com.moloco.sdk.internal.services.config.a
    @Nullable
    public String b(@NotNull String featureFlagName) {
        t.i(featureFlagName, "featureFlagName");
        return this.f18620c.get(featureFlagName);
    }

    public final void c(i iVar) {
        for (com.moloco.sdk.internal.services.config.handlers.a aVar : this.f18621d) {
            Object objA = aVar.a(iVar);
            Map<String, Object> map = this.f18619b;
            String name = aVar.a().getName();
            t.h(name, "handler.getConfigType().name");
            map.put(name, objA);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f18618a, "Adding config: " + aVar.a().getName(), null, false, 12, null);
        }
        Map<String, Object> map2 = this.f18619b;
        String name2 = h.class.getName();
        t.h(name2, "MediaConfig::class.java.name");
        map2.put(name2, e(iVar));
    }

    public final void d(i iVar) {
        List<i.f> listF = iVar.f();
        t.h(listF, "sdkInitResponse.experimentalFeatureFlagsList");
        for (i.f fVar : listF) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f18618a, "Adding ExperimentalFeatureFlag: " + fVar.getName(), null, false, 12, null);
            Map<String, String> map = this.f18620c;
            String name = fVar.getName();
            t.h(name, "flag.name");
            String value = fVar.getValue();
            map.put(name, (value == null || value.length() == 0) ? null : fVar.getValue());
        }
    }

    public final h e(i iVar) {
        h hVar;
        List<i.f> listF = iVar.f();
        t.h(listF, "sdkInitResponse.experimentalFeatureFlagsList");
        ArrayList arrayList = new ArrayList(w.v(listF, 10));
        Iterator<T> it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(((i.f) it.next()).getName());
        }
        boolean zContains = arrayList.contains("ANDROID_STREAMING_ENABLED");
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, this.f18618a, "Adding StreamingEnabled: " + zContains, null, false, 12, null);
        if (iVar.i() && iVar.c().d() && iVar.c().b().d()) {
            g.c.b bVarC = iVar.c().b().c();
            hVar = new h(((int) iVar.c().b().c().d()) > 0 ? ((int) bVarC.d()) * 1024 : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a().a(), zContains, iVar.c().b().c().c() > 0.0d ? bVarC.c() : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a().c(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a().b());
        } else {
            hVar = new h(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a().a(), zContains, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a().c(), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a().b());
        }
        MolocoLogger.debug$default(molocoLogger, this.f18618a, "Parsed and adding MediaConfig: " + hVar.a() + ", " + hVar.d() + ", " + hVar.c() + ", " + hVar.b() + ' ', false, 4, null);
        return hVar;
    }

    @Override // com.moloco.sdk.internal.services.config.a
    public <T> T b(@NotNull Class<T> configType, T t10) {
        t.i(configType, "configType");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f18618a, "Retrieving config: " + configType, false, 4, null);
        T t11 = (T) this.f18619b.get(configType.getName());
        return t11 == null ? t10 : t11;
    }

    @Override // com.moloco.sdk.internal.services.config.a
    public boolean a(@NotNull String featureFlagName) {
        t.i(featureFlagName, "featureFlagName");
        return this.f18620c.containsKey(featureFlagName);
    }
}

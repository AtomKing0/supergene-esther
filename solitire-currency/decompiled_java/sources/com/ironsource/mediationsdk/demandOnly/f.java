package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.af;
import com.ironsource.da;
import com.ironsource.hi;
import com.ironsource.i9;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.xa;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class f implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final da f13453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, g> f13454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final af<ISDemandOnlyInterstitialListener> f13455c;

    public f(List<NetworkSettings> list, hi hiVar, com.ironsource.mediationsdk.c cVar, af<ISDemandOnlyInterstitialListener> afVar, String str, String str2, da daVar) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean zK = hiVar.k();
        com.ironsource.mediationsdk.f fVar = new com.ironsource.mediationsdk.f(hiVar.g(), sessionId);
        this.f13454b = new ConcurrentHashMap<>();
        this.f13453a = daVar;
        this.f13455c = afVar;
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter abstractAdapterA = cVar.a(networkSettings, networkSettings.getInterstitialSettings(), true);
                if (abstractAdapterA != null) {
                    g gVar = new g(str, str2, networkSettings, this.f13455c.a(networkSettings.getSubProviderId()), hiVar.e(), abstractAdapterA, new com.ironsource.mediationsdk.e(fVar));
                    gVar.a(zK);
                    this.f13454b.put(networkSettings.getSubProviderId(), gVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    public ConcurrentHashMap<String, g> a() {
        return this.f13454b;
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public boolean b(String str) {
        g gVar = this.f13454b.get(str);
        if (gVar != null) {
            return gVar.a();
        }
        this.f13453a.a(2500, str);
        return false;
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(@NotNull h.d dVar) {
        String strC = dVar.c();
        String strB = dVar.b();
        try {
            g gVar = this.f13454b.get(strC);
            if (gVar == null) {
                this.f13453a.a(2503, strC);
                IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
                this.f13455c.a(strC).onInterstitialAdLoadFailed(strC, ironSourceErrorBuildNonExistentInstanceError);
                return;
            }
            if (TextUtils.isEmpty(strB)) {
                gVar.c();
            } else {
                gVar.a(new o.a(IronSourceAES.decode(xa.b().c(), strB)));
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial exception " + e10.getMessage());
            IronLog.API.error(ironSourceErrorBuildLoadFailedError.getErrorMessage());
            this.f13455c.a(strC).onInterstitialAdLoadFailed(strC, ironSourceErrorBuildLoadFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(String str) {
        try {
            g gVar = this.f13454b.get(str);
            if (gVar != null) {
                gVar.b();
                return;
            }
            this.f13453a.a(2507, str);
            IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
            IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
            this.f13455c.a(str).onInterstitialAdShowFailed(str, ironSourceErrorBuildNonExistentInstanceError);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceError ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial exception " + e10.getMessage());
            IronLog.API.error(ironSourceErrorBuildShowFailedError.getErrorMessage());
            this.f13455c.a(str).onInterstitialAdShowFailed(str, ironSourceErrorBuildShowFailedError);
        }
    }
}

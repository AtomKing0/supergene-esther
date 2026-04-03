package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.af;
import com.ironsource.da;
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
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.pp;
import com.ironsource.xa;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class k implements i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final da f13518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, l> f13519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final af<ISDemandOnlyRewardedVideoListener> f13520c;

    public k(List<NetworkSettings> list, pp ppVar, com.ironsource.mediationsdk.c cVar, af<ISDemandOnlyRewardedVideoListener> afVar, String str, String str2, da daVar) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean zD = ppVar.d();
        com.ironsource.mediationsdk.f fVar = new com.ironsource.mediationsdk.f(ppVar.k(), sessionId);
        this.f13519b = new ConcurrentHashMap<>();
        this.f13518a = daVar;
        this.f13520c = afVar;
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter abstractAdapterA = cVar.a(networkSettings, networkSettings.getRewardedVideoSettings(), true);
                if (abstractAdapterA != null) {
                    l lVar = new l(str, str2, networkSettings, this.f13520c.a(networkSettings.getSubProviderId()), ppVar.i(), abstractAdapterA, new com.ironsource.mediationsdk.e(fVar));
                    lVar.a(zD);
                    this.f13519b.put(networkSettings.getSubProviderId(), lVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    public ConcurrentHashMap<String, l> a() {
        return this.f13519b;
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public void b(String str) {
        try {
            l lVar = this.f13519b.get(str);
            if (lVar != null) {
                lVar.e();
                return;
            }
            this.f13518a.a(1507, str);
            IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
            IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
            this.f13520c.a(str).onRewardedVideoAdShowFailed(str, ironSourceErrorBuildNonExistentInstanceError);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceError ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, "showRewardedVideo exception " + e10.getMessage());
            IronLog.API.error(ironSourceErrorBuildShowFailedError.getErrorMessage());
            this.f13520c.a(str).onRewardedVideoAdShowFailed(str, ironSourceErrorBuildShowFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public void a(@NotNull h.d dVar) {
        String strC = dVar.c();
        try {
            l lVar = this.f13519b.get(strC);
            if (lVar == null) {
                this.f13518a.a(1503, strC);
                IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
                this.f13520c.a(strC).onRewardedVideoAdLoadFailed(strC, ironSourceErrorBuildNonExistentInstanceError);
                return;
            }
            if (dVar.d()) {
                lVar.b(new o.a(IronSourceAES.decode(xa.b().c(), dVar.b())));
            } else {
                lVar.d();
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideo exception " + e10.getMessage());
            IronLog.API.error(ironSourceErrorBuildLoadFailedError.getErrorMessage());
            this.f13520c.a(strC).onRewardedVideoAdLoadFailed(strC, ironSourceErrorBuildLoadFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public boolean a(String str) {
        l lVar = this.f13519b.get(str);
        if (lVar != null) {
            return lVar.a();
        }
        this.f13518a.a(1500, str);
        return false;
    }
}

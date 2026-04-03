package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.da;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n6;
import com.ironsource.xa;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class c implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, d> f13401a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private da f13402b;

    public c(List<NetworkSettings> list, n6 n6Var, String str, String str2, da daVar) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean zL = n6Var.l();
        this.f13402b = daVar;
        com.ironsource.mediationsdk.e eVar = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(n6Var.d(), sessionId));
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(networkSettings, networkSettings.getBannerSettings(), true);
                if (abstractAdapterA != null) {
                    d dVar = new d(str, str2, networkSettings, n6Var.b(), abstractAdapterA, eVar);
                    dVar.a(zL);
                    this.f13401a.put(dVar.l(), dVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.a
    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        d dVar = this.f13401a.get(str);
        if (dVar != null) {
            dVar.a(iSDemandOnlyBannerLayout);
            return;
        }
        this.f13402b.a(3503, str);
        IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Banner");
        IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
        iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorBuildNonExistentInstanceError);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.a
    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        d dVar = this.f13401a.get(str);
        if (dVar != null) {
            dVar.a(iSDemandOnlyBannerLayout, new o.a(IronSourceAES.decode(xa.b().c(), str2)));
            return;
        }
        this.f13402b.a(3503, str);
        IronSourceError ironSourceErrorBuildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Banner");
        IronLog.API.error(ironSourceErrorBuildNonExistentInstanceError.getErrorMessage());
        iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorBuildNonExistentInstanceError);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.a
    public synchronized void a(String str) {
        d dVar = this.f13401a.get(str);
        if (dVar != null) {
            dVar.r();
            return;
        }
        this.f13402b.a(IronSourceConstants.BN_DO_INSTANCE_NOT_FOUND_IN_DESTROY, str);
        IronLog.API.error(ErrorBuilder.buildNonExistentInstanceError("Banner").getErrorMessage());
    }
}

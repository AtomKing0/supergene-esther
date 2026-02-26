package com.applovin.impl.mediation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.applovin.impl.a3;
import com.applovin.impl.q2;
import com.applovin.impl.r4;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdapterParametersImpl implements MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters, MaxAdapterInitializationParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f5922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f5923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f5924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f5925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f5926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f5929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f5930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f5931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaxAdFormat f5932l;

    private MaxAdapterParametersImpl() {
    }

    static MaxAdapterParametersImpl a(q2 q2Var) {
        MaxAdapterParametersImpl maxAdapterParametersImplA = a((a3) q2Var);
        maxAdapterParametersImplA.f5929i = q2Var.O();
        maxAdapterParametersImplA.f5930j = q2Var.E();
        maxAdapterParametersImplA.f5931k = q2Var.D();
        return maxAdapterParametersImplA;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
    public MaxAdFormat getAdFormat() {
        return this.f5932l;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public String getAdUnitId() {
        return this.f5921a;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public long getBidExpirationMillis() {
        return this.f5931k;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getBidResponse() {
        return this.f5930j;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    @Nullable
    public String getConsentString() {
        return this.f5927g;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getCustomParameters() {
        return this.f5924d;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Map<String, Object> getLocalExtraParameters() {
        return this.f5922b;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getServerParameters() {
        return this.f5923c;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getThirdPartyAdPlacementId() {
        return this.f5929i;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    @Nullable
    public Boolean hasUserConsent() {
        return this.f5925e;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    @Nullable
    public Boolean isAgeRestrictedUser() {
        return null;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    @Nullable
    public Boolean isDoNotSell() {
        return this.f5926f;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public boolean isTesting() {
        return this.f5928h;
    }

    static MaxAdapterParametersImpl a(r4 r4Var, String str, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl maxAdapterParametersImplA = a(r4Var);
        maxAdapterParametersImplA.f5921a = str;
        maxAdapterParametersImplA.f5932l = maxAdFormat;
        return maxAdapterParametersImplA;
    }

    static MaxAdapterParametersImpl a(a3 a3Var) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f5921a = a3Var.getAdUnitId();
        maxAdapterParametersImpl.f5925e = a3Var.n();
        maxAdapterParametersImpl.f5926f = a3Var.o();
        maxAdapterParametersImpl.f5927g = a3Var.d();
        maxAdapterParametersImpl.f5922b = a3Var.i();
        maxAdapterParametersImpl.f5923c = a3Var.l();
        maxAdapterParametersImpl.f5924d = a3Var.f();
        maxAdapterParametersImpl.f5928h = a3Var.p();
        return maxAdapterParametersImpl;
    }
}

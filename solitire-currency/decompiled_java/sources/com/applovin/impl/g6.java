package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g6 extends i6 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f5270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppLovinAdRewardListener f5271h;

    public g6(com.applovin.impl.sdk.ad.b bVar, AppLovinAdRewardListener appLovinAdRewardListener, com.applovin.impl.sdk.j jVar) {
        super("TaskValidateAppLovinReward", jVar);
        this.f5270g = bVar;
        this.f5271h = appLovinAdRewardListener;
    }

    @Override // com.applovin.impl.e6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.f5270g.getAdZone().e());
        String clCode = this.f5270g.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.e6
    public String f() {
        return "2.0/vr";
    }

    @Override // com.applovin.impl.i6
    protected boolean h() {
        return this.f5270g.O0();
    }

    @Override // com.applovin.impl.i6
    protected void a(b4 b4Var) {
        this.f5270g.a(b4Var);
        String strB = b4Var.b();
        Map<String, String> mapA = b4Var.a();
        if (strB.equals("accepted")) {
            this.f5271h.userRewardVerified(this.f5270g, mapA);
            return;
        }
        if (strB.equals("quota_exceeded")) {
            this.f5271h.userOverQuota(this.f5270g, mapA);
        } else if (strB.equals("rejected")) {
            this.f5271h.userRewardRejected(this.f5270g, mapA);
        } else {
            this.f5271h.validationRequestFailed(this.f5270g, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    @Override // com.applovin.impl.e6
    protected void a(int i10) {
        String str;
        super.a(i10);
        if (i10 >= 400 && i10 < 500) {
            this.f5271h.userRewardRejected(this.f5270g, Collections.emptyMap());
            str = "rejected";
        } else {
            this.f5271h.validationRequestFailed(this.f5270g, i10);
            str = "network_timeout";
        }
        this.f5270g.a(b4.a(str));
    }
}

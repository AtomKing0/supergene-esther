package com.ironsource;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ni {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14133a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f14138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final an f14139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14140h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14134b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14135c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private hf f14136d = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f14141i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f14142j = null;

    public ni(String str, an anVar) throws NullPointerException {
        this.f14133a = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.f14139g = (an) SDKUtils.requireNonNull(anVar, "AdListener name can't be null");
    }

    public mi a() {
        return new mi(b(), this.f14133a, this.f14134b, this.f14135c, this.f14140h, this.f14141i, this.f14142j, this.f14138f, this.f14139g, this.f14136d);
    }

    public ni b(@Nullable String str) {
        this.f14142j = str;
        return this;
    }

    public ni c() {
        this.f14134b = true;
        return this;
    }

    public ni a(hf hfVar) {
        this.f14136d = hfVar;
        return this;
    }

    public ni b(boolean z10) {
        this.f14141i = z10;
        return this;
    }

    public ni c(boolean z10) {
        this.f14140h = z10;
        return this;
    }

    public ni a(String str) {
        this.f14137e = str;
        return this;
    }

    public String b() {
        String str = this.f14137e;
        if (str != null) {
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f14133a);
            jSONObject.put("rewarded", this.f14134b);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        return (this.f14135c || this.f14140h) ? xi.a() : xi.a(jSONObject);
    }

    public ni a(Map<String, String> map) {
        this.f14138f = map;
        return this;
    }

    public ni a(boolean z10) {
        this.f14135c = z10;
        return this;
    }
}

package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.WaterfallConfiguration;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class vi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ed f15914a = new ed();

    public void a(int i10) {
        this.f15914a.a(ad.Y, Integer.valueOf(i10));
    }

    public void b(int i10) {
        if (i10 >= 0) {
            this.f15914a.a(ad.B0, Integer.valueOf(i10));
        }
    }

    public void c(int i10) {
        this.f15914a.a(ad.W, Integer.valueOf(i10));
    }

    public void d(String str) {
        this.f15914a.a(com.ironsource.mediationsdk.metadata.a.f13690i, str);
    }

    public void e(String str) {
        this.f15914a.a(ad.I0, str);
    }

    public void f(String str) {
        this.f15914a.a(ad.f11268u, str);
    }

    public void g(String str) {
        this.f15914a.a(ad.E, str);
    }

    public void h(String str) {
        this.f15914a.a("sid", str);
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f15914a.a(ad.V, str);
    }

    public void a(Context context) {
        this.f15914a.a(context);
    }

    public void b(String str) {
        this.f15914a.a(ad.f11267t0, str);
    }

    public void c(String str) {
        this.f15914a.a(ad.f11271v0, str);
    }

    public void a(@NotNull IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        JSONObject jSONObject = new JSONObject();
        if (waterfallConfiguration != null) {
            try {
                jSONObject.put(ad.f11226c1, waterfallConfiguration.getFloor());
                jSONObject.put(ad.f11229d1, waterfallConfiguration.getCeiling());
            } catch (JSONException e10) {
                i9.d().a(e10);
            }
        }
        if (jSONObject.length() == 0) {
            this.f15914a.a(ad.f11223b1, q2.a(ad_unit));
        } else {
            this.f15914a.a(ad.f11223b1, jSONObject, q2.a(ad_unit));
        }
    }

    public void b(JSONObject jSONObject) {
        this.f15914a.a(ad.N0, (Object) jSONObject);
    }

    public void a(@NotNull ue ueVar) {
        try {
            HashMap map = new HashMap();
            map.put(ad.f11274x, ueVar.a());
            map.put(ad.f11272w, ueVar.b());
            map.put(ad.M, ueVar.c());
            this.f15914a.a(map);
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }

    public void b(boolean z10) {
        this.f15914a.a("gpi", Boolean.valueOf(z10));
    }

    public void a(Boolean bool) {
        this.f15914a.a(ad.C0, bool);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f15914a.a(ad.f11275x0, str);
    }

    public void a(JSONObject jSONObject) {
        this.f15914a.a(ad.f11264s, (Object) jSONObject);
    }

    public void a(boolean z10) {
        this.f15914a.a(ad.f11279z0, Boolean.valueOf(z10));
    }
}

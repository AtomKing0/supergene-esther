package com.onetrust.otpublishers.headless.UI.mobiledatautils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.UI.UIProperty.d0;
import com.onetrust.otpublishers.headless.UI.UIProperty.k;
import com.onetrust.otpublishers.headless.UI.UIProperty.l;
import com.onetrust.otpublishers.headless.UI.UIProperty.y;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f23650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f23651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f23652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.c f23653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.c f23654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.a f23655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.UIProperty.f f23656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f23658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f23660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f23661l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f23662m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f23663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f23664o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f23665p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Context f23666q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f23667r = "";

    @NonNull
    public static com.onetrust.otpublishers.headless.UI.UIProperty.a a(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.a aVar, String str) {
        com.onetrust.otpublishers.headless.UI.UIProperty.a aVar2 = new com.onetrust.otpublishers.headless.UI.UIProperty.a();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22696b)) {
            aVar2.f22696b = aVar.f22696b;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22703i)) {
            aVar2.f22703i = aVar.f22703i;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22697c)) {
            aVar2.f22697c = aVar.f22697c;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22698d)) {
            aVar2.f22698d = aVar.f22698d;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22700f)) {
            aVar2.f22700f = aVar.f22700f;
        }
        aVar2.f22701g = com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22701g) ? "0" : aVar.f22701g;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22699e)) {
            str = aVar.f22699e;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            aVar2.f22699e = str;
        }
        aVar2.f22695a = com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22695a) ? "#2D6B6767" : aVar.f22695a;
        aVar2.f22702h = com.onetrust.otpublishers.headless.Internal.c.q(aVar.f22702h) ? "20" : aVar.f22702h;
        aVar2.f22704j = aVar.f22704j;
        return aVar2;
    }

    @NonNull
    public static com.onetrust.otpublishers.headless.UI.UIProperty.c b(@NonNull JSONObject jSONObject, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar, @NonNull String str, boolean z10) {
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = new com.onetrust.otpublishers.headless.UI.UIProperty.c();
        l lVar = cVar.f22720a;
        cVar2.f22720a = lVar;
        cVar2.f22722c = d(cVar.f22722c, "PcTextColor", jSONObject);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            cVar2.f22720a.f22783b = lVar.f22783b;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22721b)) {
            cVar2.f22721b = cVar.f22721b;
        }
        if (!z10) {
            String strOptString = cVar.f22724e;
            if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString) || strOptString == null) {
                strOptString = !com.onetrust.otpublishers.headless.Internal.c.q(str) ? jSONObject.optString(str) : "";
            }
            cVar2.f22724e = strOptString;
        }
        return cVar2;
    }

    @NonNull
    public static String d(@Nullable String str, @NonNull String str2, @NonNull JSONObject jSONObject) {
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && str != null) {
            return str;
        }
        try {
            return jSONObject.getString(str2);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while applying header text color"), "VLDataConfig", 6);
            return "";
        }
    }

    @NonNull
    public final com.onetrust.otpublishers.headless.UI.UIProperty.f c(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar) {
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = new com.onetrust.otpublishers.headless.UI.UIProperty.f();
        l lVar = fVar.f22758a;
        fVar2.f22758a = lVar;
        String strA = fVar.a();
        JSONObject jSONObject = this.f23650a;
        if (com.onetrust.otpublishers.headless.Internal.c.q(strA) || strA == null) {
            strA = !com.onetrust.otpublishers.headless.Internal.c.q("PreferenceCenterConfirmText") ? jSONObject.optString("PreferenceCenterConfirmText") : "";
        }
        fVar2.f22764g = strA;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            fVar2.f22758a.f22783b = lVar.f22783b;
        }
        fVar2.f22760c = d(fVar.c(), "PcButtonTextColor", this.f23650a);
        fVar2.f22759b = d(fVar.f22759b, "PcButtonColor", this.f23650a);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            fVar2.f22761d = fVar.f22761d;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22763f)) {
            fVar2.f22763f = fVar.f22763f;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22762e)) {
            fVar2.f22762e = fVar.f22762e;
        }
        return fVar2;
    }

    public final void e() {
        k kVar = this.f23651b.f22757t;
        if (this.f23650a.has("PCenterVendorListFilterAria")) {
            kVar.f22779a = this.f23650a.optString("PCenterVendorListFilterAria");
        }
        if (this.f23650a.has("PCVendorListFilterUnselectedAriaLabel")) {
            kVar.f22781c = this.f23650a.optString("PCVendorListFilterUnselectedAriaLabel");
        }
        if (this.f23650a.has("PCVendorListFilterSelectedAriaLabel")) {
            kVar.f22780b = this.f23650a.optString("PCVendorListFilterSelectedAriaLabel");
        }
        if (this.f23650a.has("PCenterVendorListSearch")) {
            this.f23651b.f22751n.f22703i = this.f23650a.optString("PCenterVendorListSearch");
        }
    }
}

package com.onetrust.otpublishers.headless.UI.mobiledatautils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.onetrust.otpublishers.headless.Internal.Helper.k;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.UIProperty.b0;
import com.onetrust.otpublishers.headless.UI.UIProperty.o;
import com.onetrust.otpublishers.headless.UI.UIProperty.p;
import com.onetrust.otpublishers.headless.UI.UIProperty.v;
import com.onetrust.otpublishers.headless.UI.UIProperty.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public String A;
    public com.onetrust.otpublishers.headless.UI.UIProperty.c B;
    public com.onetrust.otpublishers.headless.UI.UIProperty.c C;
    public com.onetrust.otpublishers.headless.UI.UIProperty.c D;
    public com.onetrust.otpublishers.headless.UI.UIProperty.c E;
    public com.onetrust.otpublishers.headless.UI.UIProperty.c F;
    public String G;
    public String H;
    public boolean J;
    public String M;
    public String N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f23609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f23610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23618l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23619m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23620n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f23621o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f23623q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f23624r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f23625s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f23626t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public x f23627u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public v f23628v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23629w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23630x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f23631y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f23632z;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONArray f23622p = new JSONArray();
    public String I = "";
    public boolean K = true;
    public boolean L = false;

    public static x b(@NonNull x xVar, @NonNull JSONObject jSONObject) {
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = xVar.f22859k;
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22724e) && !com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("MainText"))) {
            cVar.f22724e = jSONObject.optString("MainText");
            cVar.f22723d = String.valueOf(true);
            xVar.f22859k = cVar;
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = xVar.f22860l;
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22724e) && !com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("MainInfoText"))) {
            cVar2.f22724e = jSONObject.optString("MainInfoText");
            cVar2.f22723d = String.valueOf(true);
            xVar.f22860l = cVar2;
        }
        p pVar = xVar.A;
        if (com.onetrust.otpublishers.headless.Internal.c.q(pVar.a()) && !com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("OptanonLogo"))) {
            pVar.f22792b = jSONObject.optString("OptanonLogo");
            xVar.A = pVar;
        }
        o oVar = xVar.D;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("AboutText")) && com.onetrust.otpublishers.headless.Internal.c.q(oVar.f22787a.f22724e)) {
            oVar.f22787a.f22724e = jSONObject.optString("AboutText");
            oVar.f22787a.f22723d = String.valueOf(true);
            if (com.onetrust.otpublishers.headless.Internal.c.q(oVar.f22788b)) {
                oVar.f22788b = jSONObject.optString("AboutLink");
            }
            xVar.D = oVar;
        }
        xVar.f22870v.f22723d = String.valueOf(true);
        o oVar2 = xVar.E;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("PCenterVendorsListText")) && com.onetrust.otpublishers.headless.Internal.c.q(oVar2.f22787a.f22724e)) {
            oVar2.f22787a.f22724e = jSONObject.optString("PCenterVendorsListText");
            oVar2.f22787a.f22723d = String.valueOf(true);
            xVar.E = oVar2;
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = xVar.f22867s;
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar3.f22724e) && !com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("PreferenceCenterManagePreferencesText"))) {
            cVar3.f22724e = jSONObject.optString("PreferenceCenterManagePreferencesText");
        }
        cVar3.f22723d = String.valueOf(true);
        xVar.f22867s = cVar3;
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = xVar.f22871w;
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.a())) {
            fVar.f22764g = jSONObject.optString("ConfirmText", "");
            fVar.f22765h = com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("ConfirmText", "")) ? String.valueOf(false) : String.valueOf(true);
            xVar.f22871w = fVar;
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar2 = xVar.f22872x;
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar2.a())) {
            fVar2.f22764g = jSONObject.optString("PCenterRejectAllButtonText", "");
            fVar2.f22765h = (!jSONObject.optBoolean("PCenterShowRejectAllButton") || com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("PCenterRejectAllButtonText", ""))) ? String.valueOf(false) : String.valueOf(true);
            xVar.f22872x = fVar2;
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.f fVar3 = xVar.f22873y;
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar3.a())) {
            fVar3.f22764g = jSONObject.optString("PreferenceCenterConfirmText", "");
        }
        fVar3.f22765h = String.valueOf(true);
        xVar.f22873y = fVar3;
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    @androidx.annotation.RequiresApi(api = 17)
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(@androidx.annotation.NonNull android.widget.TextView r1, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c r2, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.UI.Helper.c r3, @androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r4) {
        /*
            java.lang.String r0 = r3.c()
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            if (r0 != 0) goto L16
            java.lang.String r0 = r3.c()
            int r0 = android.graphics.Color.parseColor(r0)
            r1.setTextColor(r0)
            goto L27
        L16:
            java.lang.String r0 = r2.f22722c
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            if (r0 != 0) goto L27
            java.lang.String r0 = r2.f22722c
            int r0 = android.graphics.Color.parseColor(r0)
            r1.setTextColor(r0)
        L27:
            java.lang.String r0 = r3.f22153p
            com.onetrust.otpublishers.headless.UI.Helper.l.q(r1, r0)
            java.lang.String r0 = r3.f22154q
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            if (r0 != 0) goto L37
            java.lang.String r2 = r3.f22154q
            goto L45
        L37:
            com.onetrust.otpublishers.headless.UI.UIProperty.l r0 = r2.f22720a
            java.lang.String r0 = r0.f22783b
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            if (r0 != 0) goto L4c
            com.onetrust.otpublishers.headless.UI.UIProperty.l r2 = r2.f22720a
            java.lang.String r2 = r2.f22783b
        L45:
            float r2 = java.lang.Float.parseFloat(r2)
            r1.setTextSize(r2)
        L4c:
            com.onetrust.otpublishers.headless.UI.UIProperty.l r2 = r3.f22758a
            java.lang.String r3 = r2.f22785d
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r3)
            if (r0 != 0) goto L62
            if (r4 == 0) goto L62
            android.graphics.Typeface r3 = r4.getOtTypeFaceMap(r3)
            if (r3 == 0) goto L62
            r1.setTypeface(r3)
            goto L82
        L62:
            int r3 = r2.f22784c
            int r3 = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(r1, r3)
            java.lang.String r4 = r2.f22782a
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.q(r4)
            if (r4 != 0) goto L77
            java.lang.String r2 = r2.f22782a
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r3)
            goto L7f
        L77:
            android.graphics.Typeface r2 = r1.getTypeface()
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r3)
        L7f:
            r1.setTypeface(r2)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.mobiledatautils.d.e(android.widget.TextView, com.onetrust.otpublishers.headless.UI.UIProperty.c, com.onetrust.otpublishers.headless.UI.Helper.c, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    public final x a() {
        return this.f23627u;
    }

    public final void c(@NonNull Context context) {
        h hVar;
        boolean z10 = false;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(this.f23627u.I) && com.ironsource.mediationsdk.metadata.a.f13688g.equals(this.f23627u.I)) {
            x xVar = this.f23627u;
            this.f23632z = xVar.I;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(xVar.J) && com.ironsource.mediationsdk.metadata.a.f13688g.equals(this.f23627u.J)) {
                x xVar2 = this.f23627u;
                this.A = xVar2.J;
                this.C = g.b(this.f23610d, xVar2.f22866r, "", false);
            }
            this.D = g.b(this.f23610d, this.f23627u.f22862n, "", false);
            this.B = g.b(this.f23610d, this.f23627u.f22861m, "", false);
            this.J = this.f23627u.L;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(this.f23627u.K) || !com.ironsource.mediationsdk.metadata.a.f13688g.equals(this.f23627u.K)) {
            return;
        }
        this.G = this.f23627u.K;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_LAST_GIVEN_CONSENT", "0");
        f((com.onetrust.otpublishers.headless.Internal.c.q(string) ? 0L : Long.parseLong(string)) != 0 ? this.f23627u.f22864p : this.f23627u.f22865q);
    }

    public final void d(@NonNull TextView textView, @Nullable OTConfiguration oTConfiguration) {
        Typeface otTypeFaceMap;
        x xVar = this.f23627u;
        if (xVar == null || !xVar.f22857i) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23627u.f22860l;
        textView.setTextColor(Color.parseColor(cVar.f22722c));
        String str = cVar.f22720a.f22783b;
        if (str != null) {
            textView.setTextSize(Float.parseFloat(str));
        }
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        String str2 = lVar.f22785d;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str2) || oTConfiguration == null || (otTypeFaceMap = oTConfiguration.getOtTypeFaceMap(str2)) == null) {
            int iA = com.onetrust.otpublishers.headless.UI.UIProperty.l.a(textView, lVar.f22784c);
            textView.setTypeface(!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22782a) ? Typeface.create(lVar.f22782a, iA) : Typeface.create(textView.getTypeface(), iA));
        } else {
            textView.setTypeface(otTypeFaceMap);
        }
        textView.setTextAlignment(k.e(textView.getContext()) ? 6 : 4);
    }

    public final void f(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar) {
        this.E = g.b(this.f23610d, cVar, "", false);
        this.F = g.b(this.f23610d, this.f23627u.f22863o, "", false);
    }

    @RequiresApi(api = 17)
    public final void g(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar, @NonNull com.onetrust.otpublishers.headless.UI.Helper.c cVar2, @NonNull String str) {
        String strValueOf;
        if (cVar2 == this.f23629w) {
            String strOptString = com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22724e) ? this.f23610d.optString("AlwaysActiveText", "") : cVar.f22724e;
            cVar2.f22760c = this.f23609c.a(cVar.f22722c, this.f23610d.optString(str), "#3860BE", "#3860BE");
            cVar2.f22764g = strOptString;
        } else {
            cVar2.f22760c = this.f23609c.a(cVar.f22722c, this.f23610d.optString(str), "#696969", "#FFFFFF");
            cVar2.f22152o = 0;
        }
        if (cVar2 == this.f23629w && com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22721b)) {
            strValueOf = "6";
        } else {
            a aVar = this.f23609c;
            String str2 = cVar.f22721b;
            aVar.getClass();
            strValueOf = !com.onetrust.otpublishers.headless.Internal.c.q(str2) ? str2 : String.valueOf(2);
        }
        cVar2.f22153p = strValueOf;
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            cVar2.f22154q = lVar.f22783b;
        }
        cVar2.f22758a = lVar;
    }

    @RequiresApi(api = 17)
    public final void h(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar, @NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2, @NonNull com.onetrust.otpublishers.headless.UI.Helper.c cVar3) {
        if (cVar3 == this.f23613g && !this.f23610d.optBoolean("IsIabEnabled") && "".equals(this.f23610d.optString("IabType"))) {
            cVar3.f22152o = 8;
        }
        if (cVar3 == this.f23614h) {
            cVar3.f22152o = cVar.f22725f;
        }
        cVar3.f22764g = cVar.f22724e;
        cVar3.f22760c = this.f23609c.a(cVar2.f22722c, this.f23610d.optString("PcTextColor"), "#696969", "#FFFFFF");
        a aVar = this.f23609c;
        String strValueOf = cVar2.f22721b;
        aVar.getClass();
        if (com.onetrust.otpublishers.headless.Internal.c.q(strValueOf)) {
            strValueOf = String.valueOf(2);
        }
        cVar3.f22153p = strValueOf;
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar2.f22720a;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            cVar3.f22154q = lVar.f22783b;
        }
        cVar3.f22758a = lVar;
    }

    public final void i(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.f fVar, @NonNull com.onetrust.otpublishers.headless.UI.Helper.c cVar) {
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = fVar.f22758a;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            cVar.f22154q = lVar.f22783b;
        }
        cVar.f22758a = lVar;
        String strA = this.f23609c.a(fVar.c(), this.f23610d.optString("PcButtonTextColor"), "#FFFFFF", "#FFFFFF");
        String strA2 = this.f23609c.a(fVar.f22759b, this.f23610d.optString("PcButtonColor"), "#6CC04A", "#80BE5A");
        if (cVar == this.f23619m) {
            strA = this.f23609c.a(fVar.c(), this.f23610d.optString("PcButtonTextColor"), "#FFFFFF", "#80BE5A");
            strA2 = this.f23609c.a(fVar.f22759b, this.f23610d.optString("PcButtonColor"), "#6CC04A", "#FFFFFF");
        }
        cVar.f22760c = strA;
        cVar.f22759b = strA2;
        cVar.f22155r = fVar;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
            cVar.f22761d = fVar.f22761d;
        }
        cVar.f22764g = fVar.a();
        if (cVar == this.f23619m) {
            cVar.f22152o = 0;
        } else {
            cVar.f22152o = fVar.f22765h.equals(String.valueOf(true)) ? 0 : 8;
        }
    }

    public final void j(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.h hVar, @NonNull com.onetrust.otpublishers.headless.UI.Helper.c cVar, @Nullable v vVar) {
        if (!com.onetrust.otpublishers.headless.Internal.b.a(hVar.f22776d)) {
            cVar.f22152o = 8;
            cVar.f22156s = 8;
            cVar.f22157t = 8;
            return;
        }
        if (!com.onetrust.otpublishers.headless.Internal.b.a(hVar.f22775c) || com.onetrust.otpublishers.headless.Internal.c.q(hVar.f22778f.a())) {
            String strA = this.f23609c.a(hVar.f22777e, this.f23610d.optString("PcTextColor"), "#FFFFFF", "#696969");
            cVar.f22152o = 0;
            cVar.f22156s = 8;
            cVar.f22157t = 8;
            cVar.f22760c = strA;
            cVar.f22764g = this.f23610d.optString("CloseText");
            return;
        }
        if (com.onetrust.otpublishers.headless.Internal.b.a(hVar.f22778f.f22765h)) {
            cVar.f22157t = 0;
            cVar.f22156s = 8;
            cVar.f22152o = 8;
            String str = hVar.f22773a;
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = hVar.f22778f;
            com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = fVar.f22758a;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
                cVar.f22154q = lVar.f22783b;
            }
            cVar.f22758a = lVar;
            String strC = fVar.c();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
                str = strC;
            }
            cVar.f22760c = this.f23609c.a(str, this.f23610d.optString("PcTextColor"), "#696969", "#FFFFFF");
            cVar.f22759b = fVar.f22759b;
            cVar.f22155r = fVar;
            if (!com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22761d)) {
                cVar.f22761d = fVar.f22761d;
            }
        } else {
            a aVar = this.f23609c;
            String strOptString = hVar.f22773a;
            JSONObject jSONObject = this.f23610d;
            aVar.getClass();
            if (strOptString == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = jSONObject != null ? jSONObject.optString("PcTextColor") : "#E8E8E8";
            }
            if (vVar != null && !com.onetrust.otpublishers.headless.Internal.c.q(vVar.f22832b)) {
                strOptString = vVar.f22832b;
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                cVar.f22760c = strOptString;
            }
            cVar.f22156s = 0;
            cVar.f22157t = 8;
            cVar.f22152o = 8;
        }
        cVar.f22764g = hVar.f22778f.a();
    }

    public final void k(@NonNull JSONObject jSONObject) {
        this.f23627u.f22874z.f22774b = jSONObject.optString("CloseText");
        this.f23627u.A.f22793c = jSONObject.optString("PCLogoScreenReader");
        this.f23627u.G.f22786a = jSONObject.optString("PCDSIDCopyAriaLabel");
        this.f23627u.D.f22790d = jSONObject.optString("PCPrivacyLinkActionAriaLabel");
    }

    @RequiresApi(api = 17)
    public final boolean l(int i10, @NonNull Context context, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        try {
            JSONObject preferenceCenterData = oTPublishersHeadlessSDK.getPreferenceCenterData();
            this.f23610d = preferenceCenterData;
            int i11 = 0;
            if (preferenceCenterData == null) {
                return false;
            }
            this.f23609c = new a(i10);
            com.onetrust.otpublishers.headless.UI.Helper.l.w(preferenceCenterData, false);
            b0 b0Var = new b0(context);
            x xVarB = b0Var.b(i10);
            this.f23627u = xVarB;
            this.f23627u = b(xVarB, this.f23610d);
            this.f23628v = b0Var.f22714a.d();
            this.f23607a = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23608b = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23611e = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23612f = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23613g = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23614h = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23615i = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23616j = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23617k = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23618l = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23619m = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23620n = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23629w = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23630x = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.f23631y = new com.onetrust.otpublishers.headless.UI.Helper.c();
            this.I = this.f23610d.optString("BConsentText");
            n(this.f23627u.f22859k, this.f23607a, "PcTextColor");
            n(this.f23627u.f22860l, this.f23608b, "PcTextColor");
            o oVar = this.f23627u.D;
            String string = this.f23610d.getString("PcLinksTextColor");
            com.onetrust.otpublishers.headless.UI.Helper.c cVar = this.f23611e;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = oVar.f22787a;
            n(cVar2, cVar, "PcLinksTextColor");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22722c)) {
                string = cVar2.f22722c;
            }
            cVar.f22760c = string;
            cVar.f22152o = com.onetrust.otpublishers.headless.Internal.b.a(oVar.f22789c) ? 0 : 8;
            n(this.f23627u.f22870v, this.f23612f, "PcTextColor");
            x xVar = this.f23627u;
            h(xVar.E.f22787a, xVar.f22868t, this.f23613g);
            x xVar2 = this.f23627u;
            h(xVar2.F.f22787a, xVar2.f22868t, this.f23614h);
            p pVar = this.f23627u.A;
            com.onetrust.otpublishers.headless.UI.Helper.c cVar3 = this.f23615i;
            cVar3.f22764g = (pVar.a() == null || pVar.a().equals("")) ? null : pVar.a();
            if (!pVar.b()) {
                i11 = 8;
            }
            cVar3.f22152o = i11;
            n(this.f23627u.f22867s, this.f23616j, "PcTextColor");
            i(this.f23627u.f22871w, this.f23617k);
            i(this.f23627u.f22872x, this.f23618l);
            i(this.f23627u.f22873y, this.f23619m);
            if (this.f23610d.has("LegIntSettings") && !this.f23610d.isNull("LegIntSettings")) {
                this.f23621o = this.f23610d.getJSONObject("LegIntSettings").getBoolean("PAllowLI");
            }
            this.f23622p = k.a(this.f23610d);
            x xVar3 = this.f23627u;
            this.f23623q = xVar3.D.f22788b;
            this.f23624r = this.f23609c.a(xVar3.f22849a, this.f23610d.optString("PcBackgroundColor"), "#FFFFFF", "#2F2F2F");
            a aVar = this.f23609c;
            String strOptString = this.f23627u.f22855g;
            JSONObject jSONObject = this.f23610d;
            aVar.getClass();
            if (strOptString == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = jSONObject != null ? jSONObject.optString("PcTextColor") : "#E8E8E8";
            }
            this.f23625s = strOptString;
            a aVar2 = this.f23609c;
            JSONObject jSONObject2 = this.f23610d;
            aVar2.getClass();
            if (com.onetrust.otpublishers.headless.Internal.c.q("") && jSONObject2 != null) {
                jSONObject2.optString("PcTextColor");
            }
            this.f23626t = this.f23609c.a(this.f23627u.f22850b, "", "#E8E8E8", "#555555");
            x xVar4 = this.f23627u;
            this.H = xVar4.f22856h;
            j(xVar4.f22874z, this.f23620n, this.f23628v);
            g(this.f23627u.f22869u, this.f23629w, "PcLinksTextColor");
            g(this.f23627u.f22868t, this.f23630x, "PcTextColor");
            g(this.f23627u.f22860l, this.f23631y, "PcTextColor");
            c(context);
            k(this.f23610d);
            this.K = this.f23627u.f22858j;
            this.L = this.f23610d.optBoolean("IsIabEnabled");
            this.M = this.f23610d.optString("IabType");
            this.N = this.f23610d.optString("PCIllusText");
            return true;
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in ui property object, error message = "), "PC Config", 6);
            return true;
        }
    }

    public final JSONArray m() {
        return this.f23622p;
    }

    @RequiresApi(api = 17)
    public final void n(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar, @NonNull com.onetrust.otpublishers.headless.UI.Helper.c cVar2, @NonNull String str) {
        if (!cVar.b() || com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22724e)) {
            cVar2.f22152o = 8;
            return;
        }
        cVar2.f22764g = cVar.f22724e;
        cVar2.f22152o = 0;
        String strA = this.f23609c.a(cVar.f22722c, this.f23610d.optString(str), "#696969", "#FFFFFF");
        if (cVar2 == this.f23611e) {
            strA = this.f23609c.a(cVar.f22722c, this.f23610d.optString(str), "#3860BE", "#3860BE");
        }
        cVar2.f22760c = strA;
        a aVar = this.f23609c;
        String strValueOf = cVar.f22721b;
        aVar.getClass();
        if (com.onetrust.otpublishers.headless.Internal.c.q(strValueOf)) {
            strValueOf = String.valueOf(2);
        }
        cVar2.f22153p = strValueOf;
        com.onetrust.otpublishers.headless.UI.UIProperty.l lVar = cVar.f22720a;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(lVar.f22783b)) {
            cVar2.f22154q = lVar.f22783b;
        }
        cVar2.f22758a = lVar;
    }
}

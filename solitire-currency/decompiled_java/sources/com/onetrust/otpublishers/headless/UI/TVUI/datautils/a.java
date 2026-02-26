package com.onetrust.otpublishers.headless.UI.TVUI.datautils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.UI.Helper.i;
import com.onetrust.otpublishers.headless.UI.UIProperty.f;
import com.onetrust.otpublishers.headless.UI.UIProperty.o;
import com.onetrust.otpublishers.headless.UI.UIProperty.p;
import com.onetrust.otpublishers.headless.UI.UIProperty.r;
import com.onetrust.otpublishers.headless.UI.UIProperty.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f22329h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f22330a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22332c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f22334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f22335f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22331b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22333d = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f22336g = new f();

    public static void c(@NonNull f fVar, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        String str4;
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.a())) {
            fVar.f22764g = str;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22759b)) {
            fVar.f22759b = str2;
        }
        b bVarA = b.a();
        if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.c())) {
            fVar.f22760c = str3;
        }
        if (bVarA.f22356s) {
            fVar.f22761d = str3;
            str4 = bVarA.f22343f;
        } else {
            str4 = "";
            fVar.f22761d = "";
        }
        fVar.f22768k = str4;
        fVar.b((!com.onetrust.otpublishers.headless.Internal.b.a(fVar.f22765h) || com.onetrust.otpublishers.headless.Internal.c.q(fVar.a())) ? 8 : 0);
        fVar.f22766i = bVarA.f22342e;
        fVar.f22767j = bVarA.f22343f;
    }

    public final void a(@NonNull Context context) {
        boolean z10;
        h hVar;
        try {
            JSONObject jSONObject = this.f22330a;
            if (jSONObject == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                    hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z10 = true;
                } else {
                    z10 = false;
                    hVar = null;
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                    new h(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                    new h(context, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                if (z10) {
                    sharedPreferences = hVar;
                }
                String string = sharedPreferences.getString("OTT_BANNER_DATA", null);
                jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : null;
            }
            this.f22330a = jSONObject;
            String strOptString = jSONObject.optString("BackgroundColor");
            this.f22331b = this.f22330a.optString("TextColor");
            String strOptString2 = this.f22330a.optString("BannerTitle");
            String strOptString3 = this.f22330a.optString("AlertNoticeText");
            String strOptString4 = this.f22330a.optString("AlertAllowCookiesText");
            String strOptString5 = this.f22330a.optString("BannerRejectAllButtonText");
            String strOptString6 = this.f22330a.optString("AlertMoreInfoText");
            String strOptString7 = this.f22330a.optString("ButtonColor");
            String strOptString8 = this.f22330a.optString("ButtonColor");
            String strOptString9 = this.f22330a.optString("BannerMPButtonColor");
            String strOptString10 = this.f22330a.optString("ButtonTextColor");
            String strOptString11 = this.f22330a.optString("BannerMPButtonTextColor");
            this.f22332c = this.f22330a.optBoolean("IsIabEnabled");
            String strOptString12 = this.f22330a.optString("BannerDPDTitle");
            String strC = i.c(this.f22330a.optString("BannerDPDDescription"));
            String strOptString13 = this.f22330a.optString("OptanonLogo");
            String strOptString14 = this.f22330a.optString("BannerAdditionalDescription");
            this.f22333d = this.f22330a.optString("BannerAdditionalDescPlacement");
            u uVarJ = new r(context).j();
            this.f22335f = uVarJ;
            if (uVarJ != null) {
                d(uVarJ.f22823h);
                c(this.f22335f.f22824i, strOptString4, strOptString7, strOptString10);
                c(this.f22335f.f22825j, strOptString5, strOptString8, strOptString10);
                c(this.f22335f.f22826k, strOptString6, strOptString9, strOptString11);
                b bVarA = b.a();
                f fVar = bVarA.f22359v;
                String strC2 = fVar.c();
                f fVar2 = this.f22335f.f22826k;
                if (!com.onetrust.otpublishers.headless.Internal.c.q(strC2)) {
                    fVar2.f22760c = strC2;
                    if (bVarA.f22356s) {
                        fVar2.f22761d = strC2;
                    }
                }
                String str = fVar.f22759b;
                if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                    fVar2.f22759b = str;
                }
                e(this.f22330a);
                if (com.onetrust.otpublishers.headless.Internal.c.q(this.f22335f.f22816a)) {
                    this.f22335f.f22816a = strOptString;
                }
                b(this.f22335f.f22818c, strOptString2);
                b(this.f22335f.f22820e, strOptString3);
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f22335f.f22819d;
                b(cVar, strOptString12);
                String str2 = cVar.f22724e;
                cVar.f22725f = (str2 == null || com.onetrust.otpublishers.headless.Internal.c.q(str2) || !this.f22332c) ? 8 : 0;
                com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f22335f.f22821f;
                b(cVar2, strC);
                String str3 = cVar2.f22724e;
                cVar2.f22725f = (str3 == null || com.onetrust.otpublishers.headless.Internal.c.q(str3) || !this.f22332c) ? 8 : 0;
                b(this.f22335f.f22822g, strOptString14);
                p pVar = this.f22335f.f22829n;
                if (com.onetrust.otpublishers.headless.Internal.c.q(pVar.a())) {
                    pVar.f22792b = strOptString13;
                }
                o oVar = this.f22335f.f22827l;
                if (com.onetrust.otpublishers.headless.Internal.c.q(oVar.f22787a.f22724e)) {
                    oVar.f22787a.f22724e = this.f22330a.optString("BannerLinkText");
                }
            }
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error while parsing Banner data, error: "), "OneTrust", 6);
        }
    }

    public final void b(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.c cVar, @NonNull String str) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c)) {
            cVar.f22722c = this.f22331b;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22724e)) {
            cVar.f22724e = str;
        }
        cVar.f22725f = com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22724e) ? 8 : cVar.f22725f;
    }

    public final void d(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.h hVar) {
        com.onetrust.otpublishers.headless.UI.Helper.c cVar;
        this.f22334e = new com.onetrust.otpublishers.headless.UI.Helper.c();
        int i10 = 8;
        if (!com.onetrust.otpublishers.headless.Internal.b.a(hVar.f22776d)) {
            com.onetrust.otpublishers.headless.UI.Helper.c cVar2 = this.f22334e;
            cVar2.f22152o = 8;
            cVar2.f22156s = 8;
            return;
        }
        if (!com.onetrust.otpublishers.headless.Internal.b.a(hVar.f22775c) || com.onetrust.otpublishers.headless.Internal.c.q(hVar.f22778f.a())) {
            f fVar = new f();
            fVar.f22766i = b.a().f22342e;
            fVar.f22767j = b.a().f22343f;
            cVar = this.f22334e;
            cVar.f22155r = fVar;
            cVar.f22152o = 0;
        } else {
            this.f22334e.f22764g = hVar.f22778f.a();
            String strOptString = hVar.f22773a;
            JSONObject jSONObject = this.f22330a;
            if (strOptString == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = jSONObject != null ? jSONObject.optString("BannerLinksTextColor") : "#E8E8E8";
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                this.f22334e.f22760c = strOptString;
            }
            f fVar2 = hVar.f22778f;
            fVar2.f22766i = b.a().f22342e;
            fVar2.f22767j = b.a().f22343f;
            fVar2.f22760c = strOptString;
            cVar = this.f22334e;
            cVar.f22155r = fVar2;
            cVar.f22152o = 8;
            i10 = 0;
        }
        cVar.f22156s = i10;
    }

    public final void e(@NonNull JSONObject jSONObject) {
        String str;
        String strOptString = jSONObject.optString("BannerIABPartnersLink");
        o oVar = this.f22335f.f22828m;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = oVar.f22787a;
        f fVar = new f();
        if (com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22724e)) {
            cVar.f22724e = strOptString;
        }
        fVar.f22764g = cVar.f22724e;
        fVar.f22769l = (com.onetrust.otpublishers.headless.Internal.b.a(oVar.f22789c) && this.f22332c) ? 0 : 8;
        b bVarA = b.a();
        f fVar2 = bVarA.f22358u;
        String strC = fVar2.c();
        if (com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
            strC = cVar.f22722c;
            if (com.onetrust.otpublishers.headless.Internal.c.q(strC)) {
                strC = jSONObject.optString("BannerLinksTextColor");
            }
        }
        fVar.f22760c = strC;
        String str2 = fVar2.f22759b;
        f fVar3 = this.f22335f.f22826k;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            str2 = fVar3.f22759b;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            fVar.f22759b = str2;
        }
        String str3 = fVar3.f22766i;
        if (str3 != null) {
            fVar.f22766i = str3;
        }
        String str4 = fVar3.f22767j;
        if (str4 != null) {
            fVar.f22767j = str4;
        }
        if (bVarA.f22356s) {
            fVar.f22761d = strC;
            str = bVarA.f22343f;
        } else {
            str = "";
            fVar.f22761d = "";
        }
        fVar.f22768k = str;
        this.f22336g = fVar;
    }
}

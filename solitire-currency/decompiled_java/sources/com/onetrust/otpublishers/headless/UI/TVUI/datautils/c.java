package com.onetrust.otpublishers.headless.UI.TVUI.datautils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.UI.Helper.l;
import com.onetrust.otpublishers.headless.UI.UIProperty.f;
import com.onetrust.otpublishers.headless.UI.UIProperty.q;
import com.onetrust.otpublishers.headless.UI.UIProperty.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static c f22360s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f22361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f22363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f22364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f22367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x f22370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f22375o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f22376p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f22377q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.onetrust.otpublishers.headless.UI.Helper.c f22378r;

    public static void f(@NonNull f fVar, @NonNull String str, @NonNull String str2, @NonNull String str3) {
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
        if (bVarA.f22357t) {
            fVar.f22761d = str3;
            str4 = bVarA.f22345h;
        } else {
            str4 = "";
            fVar.f22761d = "";
        }
        fVar.f22768k = str4;
        fVar.b((!com.onetrust.otpublishers.headless.Internal.b.a(fVar.f22765h) || com.onetrust.otpublishers.headless.Internal.c.q(fVar.a())) ? 8 : 0);
        fVar.f22766i = bVarA.f22344g;
        fVar.f22767j = bVarA.f22345h;
    }

    public static boolean i(@NonNull JSONObject jSONObject) {
        if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONObject.optJSONArray("FirstPartyCookies"))) {
            return true;
        }
        if (!jSONObject.has("SubGroups")) {
            return false;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("SubGroups");
        if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayOptJSONArray)) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayOptJSONArray.optJSONObject(i10).optJSONArray("FirstPartyCookies"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static synchronized c j() {
        if (f22360s == null) {
            f22360s = new c();
        }
        return f22360s;
    }

    @NonNull
    public static String k(@NonNull JSONObject jSONObject) {
        String strOptString = jSONObject.optString("GroupDescription");
        return (!jSONObject.has("GroupDescriptionOTT") || com.onetrust.otpublishers.headless.Internal.c.q(jSONObject.optString("GroupDescriptionOTT")) || jSONObject.isNull("GroupDescriptionOTT")) ? strOptString : jSONObject.optString("GroupDescriptionOTT");
    }

    @NonNull
    public static String n(@NonNull JSONObject jSONObject) {
        return new SpannableStringBuilder(Html.fromHtml(jSONObject.optString("DescriptionLegal"), null, new l.a())).toString().replace("\n\n", "\n\n• ").concat(ProxyConfig.MATCH_ALL_SCHEMES).replace("\n\n• *", "");
    }

    public static boolean r(@NonNull JSONObject jSONObject) {
        return (jSONObject.has("SubGroups") && jSONObject.optBoolean("ShowSubgroup")) ? false : true;
    }

    @NonNull
    public final String a() {
        String str = this.f22370j.f22849a;
        return str != null ? str : "#FFFFFF";
    }

    @NonNull
    public final String b(boolean z10) {
        return z10 ? b.a().f22353p : this.f22367g;
    }

    @NonNull
    public final JSONObject c(@Nullable JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (jSONArray.length() > 0) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    if (jSONArray.getJSONObject(i10).has("SubGroups")) {
                        String strOptString = jSONArray.getJSONObject(i10).optString("CustomGroupId");
                        JSONArray jSONArray2 = new JSONArray();
                        JSONArray jSONArray3 = jSONArray.getJSONObject(i10).getJSONArray("SubGroups");
                        jSONObject2.put(strOptString, jSONArray.getJSONObject(i10).optBoolean("ShowSubgroupToggle"));
                        for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                            jSONArray2.put(jSONArray3.getJSONObject(i11).optString("CustomGroupId"));
                            jSONObject.put(strOptString, jSONArray2);
                        }
                    }
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error in getting subgroups for a category on TV, err: "), "OneTrust", 6);
                }
            }
        }
        this.f22364d = jSONObject2;
        return jSONObject;
    }

    public final void d(@NonNull Context context) {
        h hVar;
        x xVar = this.f22370j;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = xVar.f22862n;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = xVar.f22861m;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = xVar.f22864p;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar4 = xVar.f22863o;
        com.onetrust.otpublishers.headless.UI.UIProperty.c cVar5 = xVar.f22866r;
        boolean z10 = Boolean.parseBoolean(xVar.I);
        boolean z11 = Boolean.parseBoolean(this.f22370j.K);
        boolean z12 = Boolean.parseBoolean(this.f22370j.J);
        int i10 = 8;
        boolean z13 = false;
        int i11 = z10 ? 0 : 8;
        int i12 = z11 ? 0 : 8;
        if (z12 && !com.onetrust.otpublishers.headless.Internal.c.q(this.f22370j.f22866r.f22724e)) {
            i10 = 0;
        }
        cVar.f22725f = i11;
        cVar2.f22725f = i11;
        cVar3.f22725f = i12;
        cVar4.f22725f = i12;
        cVar5.f22725f = i10;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z13 = true;
        } else {
            hVar = null;
        }
        if (z13) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_LAST_GIVEN_CONSENT", "0");
        if (0 == (com.onetrust.otpublishers.headless.Internal.c.q(string) ? 0L : Long.parseLong(string))) {
            cVar3.f22724e = this.f22370j.f22865q.f22724e;
        }
    }

    public final void e(b bVar) {
        q qVar = this.f22370j.B;
        String str = bVar.f22346i;
        qVar.f22794a = str;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            qVar.f22794a = this.f22370j.f22849a;
        }
        String str2 = bVar.f22347j;
        qVar.f22795b = str2;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            qVar.f22794a = this.f22370j.f22868t.f22722c;
        }
        qVar.f22796c = bVar.f22348k;
        qVar.f22797d = bVar.f22349l;
        qVar.f22798e = bVar.f22350m;
        qVar.f22799f = bVar.f22351n;
    }

    public final void g(@NonNull com.onetrust.otpublishers.headless.UI.UIProperty.h hVar) {
        com.onetrust.otpublishers.headless.UI.Helper.c cVar;
        this.f22378r = new com.onetrust.otpublishers.headless.UI.Helper.c();
        int i10 = 8;
        if (!com.onetrust.otpublishers.headless.Internal.b.a(hVar.f22776d)) {
            com.onetrust.otpublishers.headless.UI.Helper.c cVar2 = this.f22378r;
            cVar2.f22152o = 8;
            cVar2.f22156s = 8;
            return;
        }
        if (!com.onetrust.otpublishers.headless.Internal.b.a(hVar.f22775c) || com.onetrust.otpublishers.headless.Internal.c.q(hVar.f22778f.a())) {
            f fVar = new f();
            fVar.f22766i = b.a().f22342e;
            fVar.f22767j = b.a().f22343f;
            cVar = this.f22378r;
            cVar.f22155r = fVar;
            cVar.f22152o = 0;
        } else {
            this.f22378r.f22764g = hVar.f22778f.a();
            String strOptString = hVar.f22773a;
            JSONObject jSONObject = this.f22361a;
            if (strOptString == null || com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                strOptString = jSONObject != null ? jSONObject.optString("BannerLinksTextColor") : "#E8E8E8";
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                this.f22378r.f22760c = strOptString;
            }
            f fVar2 = hVar.f22778f;
            fVar2.f22766i = b.a().f22342e;
            fVar2.f22767j = b.a().f22343f;
            fVar2.f22760c = strOptString;
            cVar = this.f22378r;
            cVar.f22155r = fVar2;
            cVar.f22152o = 8;
            i10 = 0;
        }
        cVar.f22156s = i10;
    }

    public final boolean h(@NonNull String str) {
        JSONObject jSONObject = this.f22364d;
        if (jSONObject == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return true;
        }
        return jSONObject.optBoolean(str);
    }

    @Nullable
    public final JSONObject l(@NonNull Context context) {
        h hVar;
        JSONObject jSONObject = this.f22361a;
        if (jSONObject != null) {
            return jSONObject;
        }
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.l.a(context)) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_PC_DATA", null);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return null;
        }
        return new JSONObject(string);
    }

    @NonNull
    public final String m() {
        String str = this.f22370j.f22860l.f22722c;
        return str != null ? str : "#696969";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020f A[Catch: JSONException -> 0x0283, TryCatch #0 {JSONException -> 0x0283, blocks: (B:56:0x0207, B:58:0x020f, B:60:0x021b, B:62:0x0227, B:64:0x0233, B:69:0x0248, B:71:0x024e, B:67:0x0240, B:55:0x0202, B:54:0x01ff, B:46:0x01d1, B:48:0x01dd), top: B:81:0x01d1, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0240 A[Catch: JSONException -> 0x0283, TryCatch #0 {JSONException -> 0x0283, blocks: (B:56:0x0207, B:58:0x020f, B:60:0x021b, B:62:0x0227, B:64:0x0233, B:69:0x0248, B:71:0x024e, B:67:0x0240, B:55:0x0202, B:54:0x01ff, B:46:0x01d1, B:48:0x01dd), top: B:81:0x01d1, inners: #2 }] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v9, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.content.SharedPreferences] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(@androidx.annotation.NonNull android.content.Context r23) {
        /*
            Method dump skipped, instruction units count: 663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.TVUI.datautils.c.o(android.content.Context):void");
    }

    public final int p(@NonNull JSONObject jSONObject) {
        return (jSONObject.optString("Status").contains("always") || !h(jSONObject.optString("Parent"))) ? 8 : 0;
    }

    public final boolean q() {
        return this.f22365e || b.a().f22352o;
    }
}

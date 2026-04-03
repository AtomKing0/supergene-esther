package com.onetrust.otpublishers.headless.UI.UIProperty;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ironsource.f5;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f22801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f22802c;

    public r(@NonNull Context context) {
        this.f22802c = context;
        this.f22801b = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context).g();
        this.f22800a = 22;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.c a(int r4, @androidx.annotation.NonNull java.lang.String r5, @androidx.annotation.NonNull org.json.JSONObject r6) {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.c r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.c
            r0.<init>()
            java.lang.String r1 = "titleTextAlign"
            boolean r2 = r6.has(r1)
            if (r2 == 0) goto L17
            java.lang.String r1 = r6.getString(r1)
            java.lang.String r1 = com.onetrust.otpublishers.headless.UI.Helper.l.f(r1)
            r0.f22721b = r1
        L17:
            r0.f22724e = r5
            java.lang.String r5 = "textColor"
            java.lang.String r5 = r6.optString(r5)
            java.lang.String r1 = "textColorDark"
            java.lang.String r1 = r6.optString(r1)
            r2 = 11
            java.lang.String r3 = ""
            if (r4 != r2) goto L34
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.q(r1)
            if (r4 == 0) goto L32
            goto L3a
        L32:
            r5 = r1
            goto L3b
        L34:
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            if (r4 == 0) goto L3b
        L3a:
            r5 = r3
        L3b:
            r0.f22722c = r5
            java.lang.String r4 = "titleFontSize"
            com.onetrust.otpublishers.headless.UI.UIProperty.l r4 = e(r6, r4)
            r0.f22720a = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.a(int, java.lang.String, org.json.JSONObject):com.onetrust.otpublishers.headless.UI.UIProperty.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.c b(@androidx.annotation.NonNull org.json.JSONObject r2, int r3, @androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.NonNull java.lang.String r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.c r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.c
            r0.<init>()
            java.lang.String r4 = r2.optString(r4)
            java.lang.String r5 = r2.optString(r5)
            r1 = 11
            if (r3 != r1) goto L1a
            boolean r3 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            if (r3 == 0) goto L18
            goto L20
        L18:
            r4 = r5
            goto L22
        L1a:
            boolean r3 = com.onetrust.otpublishers.headless.Internal.c.q(r4)
            if (r3 == 0) goto L22
        L20:
            java.lang.String r4 = ""
        L22:
            r0.f22722c = r4
            com.onetrust.otpublishers.headless.UI.UIProperty.l r2 = e(r2, r6)
            r0.f22720a = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.b(org.json.JSONObject, int, java.lang.String, java.lang.String, java.lang.String):com.onetrust.otpublishers.headless.UI.UIProperty.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.c c(@androidx.annotation.NonNull org.json.JSONObject r3, @androidx.annotation.NonNull org.json.JSONObject r4, int r5, @androidx.annotation.NonNull java.lang.String r6) {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.c r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.c
            r0.<init>()
            java.lang.String r1 = "titleTextAlign"
            boolean r2 = r3.has(r1)
            if (r2 == 0) goto L17
            java.lang.String r1 = r3.getString(r1)
            java.lang.String r1 = com.onetrust.otpublishers.headless.UI.Helper.l.f(r1)
            r0.f22721b = r1
        L17:
            boolean r1 = r4.has(r6)
            if (r1 == 0) goto L23
            java.lang.String r4 = r4.getString(r6)
            r0.f22724e = r4
        L23:
            java.lang.String r4 = "titleTextColor"
            java.lang.String r4 = r3.optString(r4)
            java.lang.String r6 = "titleTextColorDark"
            java.lang.String r6 = r3.optString(r6)
            r1 = 11
            if (r5 != r1) goto L3c
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.q(r6)
            if (r4 == 0) goto L3a
            goto L42
        L3a:
            r4 = r6
            goto L44
        L3c:
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r4)
            if (r5 == 0) goto L44
        L42:
            java.lang.String r4 = ""
        L44:
            r0.f22722c = r4
            java.lang.String r4 = "titleFontSize"
            com.onetrust.otpublishers.headless.UI.UIProperty.l r3 = e(r3, r4)
            r0.f22720a = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.c(org.json.JSONObject, org.json.JSONObject, int, java.lang.String):com.onetrust.otpublishers.headless.UI.UIProperty.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.h d(int r6, @androidx.annotation.NonNull org.json.JSONObject r7) {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.h r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.h
            r0.<init>()
            java.lang.String r1 = "show"
            boolean r2 = r7.has(r1)
            if (r2 == 0) goto L13
            java.lang.String r1 = r7.getString(r1)
            r0.f22776d = r1
        L13:
            java.lang.String r1 = "showText"
            boolean r2 = r7.has(r1)
            if (r2 == 0) goto L21
            java.lang.String r1 = r7.getString(r1)
            r0.f22775c = r1
        L21:
            java.lang.String r1 = "textColor"
            java.lang.String r1 = r7.optString(r1)
            java.lang.String r2 = "textColorDark"
            java.lang.String r2 = r7.optString(r2)
            r3 = 11
            java.lang.String r4 = ""
            if (r6 != r3) goto L3c
            boolean r1 = com.onetrust.otpublishers.headless.Internal.c.q(r2)
            if (r1 == 0) goto L3a
            goto L42
        L3a:
            r1 = r2
            goto L43
        L3c:
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r1)
            if (r2 == 0) goto L43
        L42:
            r1 = r4
        L43:
            r0.f22773a = r1
            r0.f22777e = r1
            com.onetrust.otpublishers.headless.UI.UIProperty.f r1 = new com.onetrust.otpublishers.headless.UI.UIProperty.f
            r1.<init>()
            java.lang.String r2 = "color"
            java.lang.String r2 = r7.optString(r2)
            java.lang.String r5 = "colorDark"
            java.lang.String r5 = r7.optString(r5)
            if (r6 != r3) goto L63
            boolean r6 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            if (r6 == 0) goto L61
            goto L6b
        L61:
            r4 = r5
            goto L6b
        L63:
            boolean r6 = com.onetrust.otpublishers.headless.Internal.c.q(r2)
            if (r6 == 0) goto L6a
            goto L6b
        L6a:
            r4 = r2
        L6b:
            r1.f22759b = r4
            java.lang.String r6 = "fontSize"
            com.onetrust.otpublishers.headless.UI.UIProperty.l r6 = e(r7, r6)
            r1.f22758a = r6
            java.lang.String r6 = "borderRadius"
            boolean r2 = r7.has(r6)
            if (r2 == 0) goto L83
            java.lang.String r6 = r7.getString(r6)
            r1.f22763f = r6
        L83:
            java.lang.String r6 = "showAsLink"
            boolean r2 = r7.has(r6)
            if (r2 == 0) goto L97
            boolean r6 = r7.getBoolean(r6)
            r6 = r6 ^ 1
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r1.f22765h = r6
        L97:
            java.lang.String r6 = "text"
            boolean r2 = r7.has(r6)
            if (r2 == 0) goto La5
            java.lang.String r6 = r7.getString(r6)
            r1.f22764g = r6
        La5:
            r0.f22778f = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.d(int, org.json.JSONObject):com.onetrust.otpublishers.headless.UI.UIProperty.h");
    }

    @NonNull
    public static l e(@NonNull JSONObject jSONObject, @NonNull String str) {
        l lVar = new l();
        if (jSONObject.has(str)) {
            lVar.f22783b = jSONObject.getString(str);
        }
        return lVar;
    }

    @NonNull
    public static o f(int i10, JSONObject jSONObject, boolean z10) {
        o oVar = new o();
        if (jSONObject.has("url")) {
            oVar.f22788b = jSONObject.getString("url");
        }
        if (jSONObject.has(f5.f12054u)) {
            oVar.f22789c = String.valueOf(jSONObject.getBoolean(f5.f12054u));
        }
        oVar.f22787a = i.a(jSONObject, i10, z10, null);
        return oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.c i(int r5, @androidx.annotation.NonNull org.json.JSONObject r6) {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.c r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.c
            r0.<init>()
            java.lang.String r1 = "titleTextAlign"
            boolean r2 = r6.has(r1)
            if (r2 == 0) goto L17
            java.lang.String r1 = r6.getString(r1)
            java.lang.String r1 = com.onetrust.otpublishers.headless.UI.Helper.l.f(r1)
            r0.f22721b = r1
        L17:
            java.lang.String r1 = "titleText"
            boolean r2 = r6.has(r1)
            if (r2 == 0) goto L25
            java.lang.String r1 = r6.getString(r1)
            r0.f22724e = r1
        L25:
            java.lang.String r1 = "titleTextColor"
            java.lang.String r1 = r6.optString(r1)
            java.lang.String r2 = "titleTextColorDark"
            java.lang.String r2 = r6.optString(r2)
            r3 = 11
            java.lang.String r4 = ""
            if (r5 != r3) goto L40
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r2)
            if (r5 == 0) goto L3e
            goto L46
        L3e:
            r1 = r2
            goto L47
        L40:
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r1)
            if (r5 == 0) goto L47
        L46:
            r1 = r4
        L47:
            r0.f22722c = r1
            java.lang.String r5 = "titleFontSize"
            com.onetrust.otpublishers.headless.UI.UIProperty.l r5 = e(r6, r5)
            r0.f22720a = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.i(int, org.json.JSONObject):com.onetrust.otpublishers.headless.UI.UIProperty.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.c l(int r5, @androidx.annotation.NonNull org.json.JSONObject r6) {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.c r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.c
            r0.<init>()
            java.lang.String r1 = "titleTextColor"
            java.lang.String r1 = r6.optString(r1)
            java.lang.String r2 = "titleTextColorDark"
            java.lang.String r2 = r6.optString(r2)
            r3 = 11
            java.lang.String r4 = ""
            if (r5 != r3) goto L20
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r2)
            if (r5 == 0) goto L1e
            goto L26
        L1e:
            r1 = r2
            goto L27
        L20:
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r1)
            if (r5 == 0) goto L27
        L26:
            r1 = r4
        L27:
            r0.f22722c = r1
            java.lang.String r5 = "titleShow"
            boolean r1 = r6.has(r5)
            if (r1 == 0) goto L37
            java.lang.String r5 = r6.getString(r5)
            r0.f22723d = r5
        L37:
            java.lang.String r5 = "titleFontSize"
            com.onetrust.otpublishers.headless.UI.UIProperty.l r5 = e(r6, r5)
            r0.f22720a = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.l(int, org.json.JSONObject):com.onetrust.otpublishers.headless.UI.UIProperty.c");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.a m(int r5, @androidx.annotation.NonNull org.json.JSONObject r6) {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.a r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.a
            r0.<init>()
            java.lang.String r1 = "textColor"
            boolean r2 = r6.has(r1)
            r3 = 11
            java.lang.String r4 = ""
            if (r2 == 0) goto L35
            java.lang.String r1 = r6.optString(r1)
            java.lang.String r2 = "textColorDark"
            java.lang.String r2 = r6.optString(r2)
            if (r5 != r3) goto L26
            boolean r1 = com.onetrust.otpublishers.headless.Internal.c.q(r2)
            if (r1 == 0) goto L24
            goto L2c
        L24:
            r1 = r2
            goto L2d
        L26:
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r1)
            if (r2 == 0) goto L2d
        L2c:
            r1 = r4
        L2d:
            r0.f22696b = r1
            r0.f22697c = r1
            r0.f22698d = r1
            r0.f22700f = r1
        L35:
            java.lang.String r1 = "backgroundColorDark"
            boolean r2 = r6.has(r1)
            if (r2 == 0) goto L5c
            java.lang.String r2 = "backgroundColor"
            java.lang.String r2 = r6.optString(r2)
            java.lang.String r6 = r6.optString(r1)
            if (r5 != r3) goto L52
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r6)
            if (r5 == 0) goto L50
            goto L5a
        L50:
            r4 = r6
            goto L5a
        L52:
            boolean r5 = com.onetrust.otpublishers.headless.Internal.c.q(r2)
            if (r5 == 0) goto L59
            goto L5a
        L59:
            r4 = r2
        L5a:
            r0.f22695a = r4
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.m(int, org.json.JSONObject):com.onetrust.otpublishers.headless.UI.UIProperty.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0121  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.x g(int r24) {
        /*
            Method dump skipped, instruction units count: 1310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.g(int):com.onetrust.otpublishers.headless.UI.UIProperty.x");
    }

    @NonNull
    public final JSONObject h() {
        return this.f22801b.has("preferenceCenterData") ? this.f22801b.getJSONObject("preferenceCenterData") : new JSONObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0202  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.u j() {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.j():com.onetrust.otpublishers.headless.UI.UIProperty.u");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0193  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.onetrust.otpublishers.headless.UI.UIProperty.d0 k(int r21) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.r.k(int):com.onetrust.otpublishers.headless.UI.UIProperty.d0");
    }

    public r(@NonNull Context context, int i10) {
        this.f22802c = context;
        this.f22801b = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context).g();
        this.f22800a = i10;
    }
}

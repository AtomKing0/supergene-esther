package com.onetrust.otpublishers.headless.UI.UIProperty;

import androidx.annotation.NonNull;
import com.ironsource.f5;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.onetrust.otpublishers.headless.UI.UIProperty.c a(org.json.JSONObject r3, int r4, boolean r5, @androidx.annotation.Nullable android.content.Context r6) throws org.json.JSONException {
        /*
            com.onetrust.otpublishers.headless.UI.UIProperty.c r0 = new com.onetrust.otpublishers.headless.UI.UIProperty.c
            r0.<init>()
            java.lang.String r1 = "text"
            boolean r2 = r3.has(r1)
            if (r2 == 0) goto L1c
            if (r5 == 0) goto L1c
            java.lang.String r5 = r3.getString(r1)
            if (r6 != 0) goto L16
            goto L1a
        L16:
            java.lang.String r5 = com.onetrust.otpublishers.headless.UI.extensions.j.b(r6, r5)
        L1a:
            r0.f22724e = r5
        L1c:
            java.lang.String r5 = "textAlign"
            boolean r6 = r3.has(r5)
            if (r6 == 0) goto L2e
            java.lang.String r5 = r3.getString(r5)
            java.lang.String r5 = com.onetrust.otpublishers.headless.UI.Helper.l.f(r5)
            r0.f22721b = r5
        L2e:
            java.lang.String r5 = "show"
            boolean r6 = r3.has(r5)
            if (r6 == 0) goto L4a
            java.lang.String r5 = r3.getString(r5)
            r0.f22723d = r5
            java.lang.String r6 = "true"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L46
            r5 = 0
            goto L48
        L46:
            r5 = 8
        L48:
            r0.f22725f = r5
        L4a:
            java.lang.String r5 = "textColor"
            java.lang.String r5 = r3.optString(r5)
            java.lang.String r6 = "textColorDark"
            java.lang.String r6 = r3.optString(r6)
            r1 = 11
            if (r4 != r1) goto L63
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.q(r6)
            if (r4 == 0) goto L61
            goto L69
        L61:
            r5 = r6
            goto L6b
        L63:
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            if (r4 == 0) goto L6b
        L69:
            java.lang.String r5 = ""
        L6b:
            r0.f22722c = r5
            com.onetrust.otpublishers.headless.UI.UIProperty.l r3 = c(r3)
            r0.f22720a = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.UI.UIProperty.i.a(org.json.JSONObject, int, boolean, android.content.Context):com.onetrust.otpublishers.headless.UI.UIProperty.c");
    }

    public static f b(int i10, JSONObject jSONObject) {
        int i11;
        f fVar = new f();
        try {
            if (jSONObject.has(OTUXParamsKeys.OT_UX_BORDER_RADIUS)) {
                fVar.f22763f = jSONObject.getString(OTUXParamsKeys.OT_UX_BORDER_RADIUS);
            }
            if (jSONObject.has("text")) {
                fVar.f22764g = jSONObject.getString("text");
            }
            if (jSONObject.has(f5.f12054u)) {
                fVar.f22765h = jSONObject.getString(f5.f12054u);
            }
            if (jSONObject.has(v8.h.L)) {
                fVar.f22771n = jSONObject.getInt(v8.h.L);
            }
            if (jSONObject.has("positionBeforePurpose")) {
                fVar.f22771n = jSONObject.getInt("positionBeforePurpose");
            }
            if (jSONObject.has("positionAfterPurpose") && (i11 = jSONObject.getInt("positionAfterPurpose")) != 0) {
                fVar.f22771n = i11 + 10;
            }
            String strOptString = jSONObject.optString("color");
            String strOptString2 = jSONObject.optString("colorDark");
            String str = "";
            if (i10 != 11) {
                if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                    strOptString = "";
                }
                strOptString2 = strOptString;
            } else if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                strOptString2 = "";
            }
            fVar.f22759b = strOptString2;
            String strOptString3 = jSONObject.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
            String strOptString4 = jSONObject.optString("textColorDark");
            if (i10 == 11) {
                if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString4)) {
                    str = strOptString4;
                }
            } else if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                str = strOptString3;
            }
            fVar.f22760c = str;
            fVar.f22758a = c(jSONObject);
        } catch (JSONException e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(e10, new StringBuilder("Error in parsing button property :"), "OneTrust", 6);
        }
        return fVar;
    }

    @NonNull
    public static l c(@NonNull JSONObject jSONObject) {
        l lVar = new l();
        if (jSONObject.has("fontSize")) {
            lVar.f22783b = jSONObject.getString("fontSize");
        }
        return lVar;
    }
}

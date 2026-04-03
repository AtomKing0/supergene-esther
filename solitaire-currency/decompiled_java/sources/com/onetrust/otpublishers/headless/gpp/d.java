package com.onetrust.otpublishers.headless.gpp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.x;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f23793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f23794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f23795c;

    public d(@NonNull Context context) {
        this.f23794b = context;
        this.f23793a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        this.f23795c = new c(context);
    }

    public static String a(String str, String str2) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return str2;
        }
        return str2 + "~" + str;
    }

    @NonNull
    public static String b(String str, @NonNull ArrayList arrayList, int i10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return "";
        }
        arrayList.add(Integer.valueOf(i10));
        return str;
    }

    public static String c(@NonNull ArrayList<Integer> arrayList) {
        StringBuilder sb = new StringBuilder("");
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String string = arrayList.get(i10).toString();
            if (!sb.toString().equals("")) {
                sb.append("_");
            }
            sb.append(string);
        }
        return sb.toString();
    }

    public static void e(String str, int i10, boolean z10, StringBuilder sb) {
        if (str.equals(String.valueOf(i10)) && z10) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(sb.toString())) {
                sb.append("_");
            }
            sb.append(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.gpp.d.d():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0468  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(@androidx.annotation.NonNull org.json.JSONObject r33, boolean r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 1341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.gpp.d.f(org.json.JSONObject, boolean, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011b  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r12v1, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v32 */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String g(@androidx.annotation.NonNull java.util.ArrayList<java.lang.Integer> r22) {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.gpp.d.g(java.util.ArrayList):java.lang.String");
    }

    @NonNull
    @VisibleForTesting
    public final JSONObject h() {
        String string = this.f23793a.c().getString("OT_GPP_DATA_BACKUP", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e10) {
                x.a("getGppBackUpData: ", e10, "GPPStringHandler", 6);
            }
        }
        return new JSONObject();
    }

    public final boolean i() {
        Context context = this.f23794b;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
        String string = defaultSharedPreferences.getString(OTGppKeys.IAB_GPP_USP1_STRING, "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            string = defaultSharedPreferences.getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, "");
        }
        String str = com.onetrust.otpublishers.headless.Internal.c.q(string) ? "" : string;
        return (com.onetrust.otpublishers.headless.Internal.c.q(str) || str.equals("1---")) ? false : true;
    }
}

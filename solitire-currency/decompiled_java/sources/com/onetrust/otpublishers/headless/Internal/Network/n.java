package com.onetrust.otpublishers.headless.Internal.Network;

import ab.y;
import ab.z;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.ironsource.ad;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCustomConfigurator;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProxyType;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTNetworkRequestCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import ga.b0;
import ga.d0;
import ga.w;
import ga.z;
import io.sentry.protocol.ViewHierarchyNode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.c f21884d = new com.onetrust.otpublishers.headless.Internal.c();

    public n(@NonNull Context context) {
        this.f21881a = context;
        this.f21883c = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d0 d(String str, String str2, String str3, String str4, OTSdkParams oTSdkParams, w.a aVar) {
        b0.a aVarG;
        String str5;
        b0 b0VarA = aVar.a();
        b0.a aVarG2 = b0VarA.i().g("location", str).g("application", str2).g(ad.f11258p, str3).g("sdkVersion", str4);
        String string = this.f21883c.c().contains("OT_SDK_API_FETCH_TIMESTAMP") ? this.f21883c.c().getString("OT_SDK_API_FETCH_TIMESTAMP", null) : null;
        OTLogger.a("NetworkRequestHandler", 3, "Last launch timestamp : " + string);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            aVarG2 = aVarG2.g("x-onetrust-lastlaunch", string);
            OTLogger.a("NetworkRequestHandler", 3, "Added Last launch timestamp to header");
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(oTSdkParams.getOTRegionCode())) {
            aVarG2 = aVarG2.g("OT-Region-Code", oTSdkParams.getOTRegionCode());
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(oTSdkParams.getOTCountryCode())) {
            aVarG2 = aVarG2.g("OT-Country-Code", oTSdkParams.getOTCountryCode());
        }
        OTProfileSyncParams otProfileSyncParams = oTSdkParams.getOtProfileSyncParams();
        if (otProfileSyncParams == null || com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getSyncProfile()) || !Boolean.parseBoolean(otProfileSyncParams.getSyncProfile())) {
            OTLogger.a("NetworkRequestHandler", 4, "OT Profile Sync params not set, sending syncProfile false.");
            aVarG = aVarG2.g("fetchType", "APP_DATA_ONLY");
        } else {
            aVarG = aVarG2.g("fetchType", "APP_DATA_AND_SYNC_PROFILE");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getIdentifier())) {
                aVarG = aVarG.g(ViewHierarchyNode.JsonKeys.IDENTIFIER, otProfileSyncParams.getIdentifier());
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getSyncProfileAuth())) {
                aVarG = aVarG.g("syncProfileAuth", otProfileSyncParams.getSyncProfileAuth());
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getTenantId())) {
                aVarG = aVarG.g("tenantId", otProfileSyncParams.getTenantId());
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getSyncGroupId())) {
                aVarG = aVarG.g("syncGroupId", otProfileSyncParams.getSyncGroupId());
            }
            String string2 = this.f21883c.c().getString("OT_ProfileSyncETag", null);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                str5 = "Empty ETag.";
            } else {
                aVarG = aVarG.g("profileSyncETag", string2);
                str5 = "ETag set to Header = " + string2;
            }
            OTLogger.a("NetworkRequestHandler", 3, str5);
        }
        aVarG.i(b0VarA.h(), b0VarA.a());
        return aVar.b(aVarG.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(y yVar, String str, OTCallback oTCallback, Handler handler, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        OTLogger.a("NetworkRequestHandler", 4, "parsing appdata in BG thread");
        h(yVar, str, oTCallback, handler, oTPublishersHeadlessSDK, true);
    }

    public static /* synthetic */ void l(OTNetworkRequestCallback oTNetworkRequestCallback, WorkInfo workInfo) {
        if (workInfo != null) {
            WorkInfo.State state = workInfo.getState();
            if (state.isFinished()) {
                oTNetworkRequestCallback.onCompletion(state == WorkInfo.State.SUCCEEDED);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(String str, String str2, String str3, boolean z10) throws Throwable {
        if (z10) {
            return;
        }
        o(str, str2, str3, false, null);
    }

    @VisibleForTesting
    public static void p(@NonNull String str, @NonNull String str2, @NonNull JSONObject jSONObject, boolean z10, boolean z11) throws JSONException {
        String str3;
        if (jSONObject.has("consentString")) {
            jSONObject.remove("consentString");
        }
        if (z10) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "tcfeu");
            jSONObject2.put("content", str);
            jSONObject.put("consentString", jSONObject2);
            str3 = "Consent logging for IAB template, setting tc string = " + str;
        } else if (z11) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", "gpp");
            jSONObject3.put("content", str2);
            jSONObject.put("consentString", jSONObject3);
            str3 = "Consent logging for Gpp enabled template, setting consent string = " + str2;
        } else {
            str3 = "Consent logging for non-IAB template with Gpp disabled, not setting consent string";
        }
        OTLogger.a("NetworkRequestHandler", 4, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e() {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Network.n.e():java.lang.String");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:0|2|(1:4)(1:5)|6|(1:8)(34:9|(1:11)(2:12|(1:14))|16|222|17|(1:19)|20|(6:22|23|230|24|(1:26)|27)(1:28)|29|30|(30:204|32|33|216|34|35|(2:37|38)(1:39)|(1:41)|42|43|(1:45)|46|(1:48)|49|50|224|51|52|(2:54|55)(1:56)|57|(1:59)(1:60)|61|62|63|64|65|228|66|(10:68|69|210|70|71|(2:73|74)(1:75)|(1:77)|78|79|(1:81)(1:82))|83)(1:90)|91|92|93|94|(1:96)(1:97)|(1:99)|100|101|102|103|(1:105)(1:106)|(1:108)(1:109)|110|(1:112)(1:113)|114|115|(4:220|117|122|(14:124|(1:126)(1:127)|(6:129|(1:131)|132|(1:134)|135|(3:206|137|142)(2:141|142))|143|144|202|(2:146|147)(8:149|(3:151|218|152)|153|(1:155)(1:156)|157|158|214|159)|148|153|(0)(0)|157|158|214|159)(0))(3:121|122|(0)(0))|226|180|181|232|182|(8:212|184|185|208|186|187|200|201)(4:192|199|200|201))|15|16|222|17|(0)|20|(0)(0)|29|30|(0)(0)|91|92|93|94|(0)(0)|(0)|100|101|102|103|(0)(0)|(0)(0)|110|(0)(0)|114|115|(0)(0)|226|180|181|232|182|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03b3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03b4, code lost:
    
        r1 = "NetworkRequestHandler";
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03ef, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03f1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03f2, code lost:
    
        r6 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03f4, code lost:
    
        r8 = "https://cookies2-ds.dev.otdev.org/request/v1/";
        r3 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027d A[Catch: JSONException -> 0x03ab, TryCatch #13 {JSONException -> 0x03ab, blocks: (B:66:0x01ad, B:68:0x01be, B:71:0x01d6, B:73:0x01e4, B:81:0x01fc, B:82:0x0214, B:83:0x021a, B:91:0x0248, B:94:0x024f, B:96:0x025a, B:100:0x026b, B:103:0x0272, B:105:0x027d, B:110:0x0292, B:114:0x029d, B:122:0x02cd, B:124:0x02d5, B:126:0x02df, B:129:0x02f8, B:135:0x0311, B:142:0x033f, B:141:0x033a, B:140:0x0324, B:143:0x0348, B:121:0x02c8, B:120:0x02b2, B:137:0x031d, B:117:0x02ab), top: B:228:0x01ad, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c8 A[Catch: JSONException -> 0x03ab, TryCatch #13 {JSONException -> 0x03ab, blocks: (B:66:0x01ad, B:68:0x01be, B:71:0x01d6, B:73:0x01e4, B:81:0x01fc, B:82:0x0214, B:83:0x021a, B:91:0x0248, B:94:0x024f, B:96:0x025a, B:100:0x026b, B:103:0x0272, B:105:0x027d, B:110:0x0292, B:114:0x029d, B:122:0x02cd, B:124:0x02d5, B:126:0x02df, B:129:0x02f8, B:135:0x0311, B:142:0x033f, B:141:0x033a, B:140:0x0324, B:143:0x0348, B:121:0x02c8, B:120:0x02b2, B:137:0x031d, B:117:0x02ab), top: B:228:0x01ad, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d5 A[Catch: JSONException -> 0x03ab, TryCatch #13 {JSONException -> 0x03ab, blocks: (B:66:0x01ad, B:68:0x01be, B:71:0x01d6, B:73:0x01e4, B:81:0x01fc, B:82:0x0214, B:83:0x021a, B:91:0x0248, B:94:0x024f, B:96:0x025a, B:100:0x026b, B:103:0x0272, B:105:0x027d, B:110:0x0292, B:114:0x029d, B:122:0x02cd, B:124:0x02d5, B:126:0x02df, B:129:0x02f8, B:135:0x0311, B:142:0x033f, B:141:0x033a, B:140:0x0324, B:143:0x0348, B:121:0x02c8, B:120:0x02b2, B:137:0x031d, B:117:0x02ab), top: B:228:0x01ad, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c4 A[Catch: JSONException -> 0x03b3, TRY_LEAVE, TryCatch #10 {JSONException -> 0x03b3, blocks: (B:17:0x00a3, B:20:0x00be, B:22:0x00c4), top: B:222:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025a A[Catch: JSONException -> 0x03ab, TryCatch #13 {JSONException -> 0x03ab, blocks: (B:66:0x01ad, B:68:0x01be, B:71:0x01d6, B:73:0x01e4, B:81:0x01fc, B:82:0x0214, B:83:0x021a, B:91:0x0248, B:94:0x024f, B:96:0x025a, B:100:0x026b, B:103:0x0272, B:105:0x027d, B:110:0x0292, B:114:0x029d, B:122:0x02cd, B:124:0x02d5, B:126:0x02df, B:129:0x02f8, B:135:0x0311, B:142:0x033f, B:141:0x033a, B:140:0x0324, B:143:0x0348, B:121:0x02c8, B:120:0x02b2, B:137:0x031d, B:117:0x02ab), top: B:228:0x01ad, inners: #2, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(int r29, @androidx.annotation.NonNull java.lang.String r30, @androidx.annotation.NonNull java.lang.String r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1049
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Network.n.f(int, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(52:0|2|(3:4|168|5)|9|(1:11)(1:12)|(1:14)(1:15)|16|(46:(1:19)|20|(0)(1:23)|26|(1:28)(1:29)|(1:31)(1:32)|33|(1:41)(3:(1:36)|37|(0)(1:40))|42|(1:46)(1:45)|47|(1:59)(4:54|172|55|56)|60|176|61|(1:63)(1:64)|(1:66)|67|(4:174|69|74|(1:86)(5:78|79|166|80|(1:82)))(3:73|74|(2:76|86)(0))|90|(1:92)(1:93)|(1:95)|162|96|(1:98)(1:102)|103|(1:107)(1:106)|108|(3:110|164|111)|115|170|116|(1:118)|122|(1:124)(1:125)|(1:127)|128|(1:130)|131|(1:133)|134|(1:140)(1:139)|141|(1:143)(4:144|(1:146)(1:147)|(1:149)|150)|(1:155)|(1:180)(2:160|161))(1:24)|25|26|(0)(0)|(0)(0)|33|(0)(0)|42|(1:46)(0)|47|(2:49|59)(0)|60|176|61|(0)(0)|(0)|67|(0)(0)|90|(0)(0)|(0)|162|96|(0)(0)|103|(1:107)(0)|108|(0)|115|170|116|(0)|122|(0)(0)|(0)|128|(0)|131|(0)|134|(2:136|140)(0)|141|(0)(0)|(2:153|155)|(1:179)(1:178)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0222, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0223, code lost:
    
        com.onetrust.otpublishers.headless.Internal.Helper.p.a(r0, new java.lang.StringBuilder("error while getting mobile data json, err: "), "OneTrust", 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0297, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0298, code lost:
    
        com.onetrust.otpublishers.headless.Internal.Helper.p.a(r0, new java.lang.StringBuilder("Could not save or initialize CCPA params, err: "), "OneTrust", 5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e3, code lost:
    
        r36 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0245 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0288 A[Catch: JSONException -> 0x0297, TRY_LEAVE, TryCatch #4 {JSONException -> 0x0297, blocks: (B:116:0x0282, B:118:0x0288), top: B:170:0x0282 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0159 A[Catch: Exception -> 0x01e2, TryCatch #7 {Exception -> 0x01e2, blocks: (B:61:0x013a, B:63:0x0159, B:67:0x016a, B:69:0x0176, B:74:0x0198, B:76:0x01a0, B:78:0x01a8, B:73:0x0193, B:72:0x017d), top: B:176:0x013a, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0193 A[Catch: Exception -> 0x01e2, TryCatch #7 {Exception -> 0x01e2, blocks: (B:61:0x013a, B:63:0x0159, B:67:0x016a, B:69:0x0176, B:74:0x0198, B:76:0x01a0, B:78:0x01a8, B:73:0x0193, B:72:0x017d), top: B:176:0x013a, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021c A[Catch: JSONException -> 0x0222, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0222, blocks: (B:96:0x0210, B:98:0x021c), top: B:162:0x0210 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(@androidx.annotation.Nullable ab.y<java.lang.String> r32, java.lang.String r33, @androidx.annotation.Nullable final com.onetrust.otpublishers.headless.Public.OTCallback r34, android.os.Handler r35, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Network.n.h(ab.y, java.lang.String, com.onetrust.otpublishers.headless.Public.OTCallback, android.os.Handler, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK, boolean):void");
    }

    public final void i(@NonNull final y<String> yVar, final String str, @Nullable final OTCallback oTCallback, @NonNull final OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        final Handler handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() { // from class: com.onetrust.otpublishers.headless.Internal.Network.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f21862a.g(yVar, str, oTCallback, handler, oTPublishersHeadlessSDK);
            }
        }).start();
    }

    public final void j(@Nullable OTCallback oTCallback, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, @NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5) {
        String string;
        String str6;
        OTCallback cVar;
        String str7;
        OTSdkParams oTSdkParamsA = com.onetrust.otpublishers.headless.Internal.c.a(this.f21881a);
        if (com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
            StringBuilder sb = new StringBuilder("https://mobile-data.");
            String str8 = str4 == null ? "" : str4;
            str7 = "onetrust.io";
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str8)) {
                String strTrim = str8.trim();
                if (!com.onetrust.otpublishers.headless.Internal.c.q(strTrim)) {
                    str7 = "qa".equals(strTrim) ? "1trust.app" : "onetrust.io";
                    if ("dev".equals(strTrim)) {
                        str7 = "onetrust.dev";
                    }
                }
            }
            sb.append(str7);
            sb.append("/bannersdk/v2/applicationdata");
            string = sb.toString();
        } else {
            string = str5;
        }
        this.f21882b = string;
        z.a aVar = new z.a();
        String string2 = this.f21881a.getString(p6.f.f32898f);
        String oTSdkAPIVersion = oTSdkParamsA.getOTSdkAPIVersion();
        if (com.onetrust.otpublishers.headless.Internal.c.q(oTSdkAPIVersion) || string2.equals(oTSdkAPIVersion)) {
            com.onetrust.otpublishers.headless.Internal.Helper.d.a("SDK api version not overridden, using SDK version = ", string2, "NetworkRequestHandler", 4);
            str6 = string2;
        } else {
            OTLogger.a("OneTrust", 5, "API version has been overridden. This feature is for testing only. Do not go live with an overridden API version.");
            str6 = oTSdkAPIVersion;
        }
        m(str, str2, str3, oTSdkParamsA, aVar, str6);
        a aVar2 = (a) new z.b().c("https://mobile-data.onetrust.io/").a(bb.k.f()).f(aVar.b()).d().b(a.class);
        StringBuilder sb2 = new StringBuilder("Requesting OTT data parameters : ");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(str2);
        sb2.append(", ");
        sb2.append(str3);
        sb2.append(",");
        sb2.append(oTSdkParamsA.getOTCountryCode());
        sb2.append(",");
        sb2.append(oTSdkParamsA.getOTRegionCode());
        sb2.append(", ");
        sb2.append(str6);
        sb2.append(", Profile : ");
        sb2.append(oTSdkParamsA.getOtProfileSyncParams() == null ? null : oTSdkParamsA.getOtProfileSyncParams().toString());
        OTLogger.a("NetworkRequestHandler", 3, sb2.toString());
        try {
            b bVar = new b(this, oTCallback);
            String proxyDomainURLString = OTCustomConfigurator.getProxyDomainURLString(new OTProxyType.SDKDataDownload(new URL(this.f21882b)));
            if (proxyDomainURLString.isEmpty()) {
                proxyDomainURLString = this.f21882b;
                cVar = bVar;
            } else {
                cVar = new c(this, oTCallback, aVar2, str6, bVar, oTPublishersHeadlessSDK);
            }
            OTLogger.a("NetworkRequestHandler", 4, "Requesting OTT data from : " + proxyDomainURLString);
            OTLogger.a("NetworkRequestHandler", 4, " OTT data Download : Download OTT data started");
            aVar2.b(proxyDomainURLString).i0(new d(this, str6, cVar, oTPublishersHeadlessSDK));
        } catch (MalformedURLException e10) {
            OTLogger.a("NetworkRequestHandler", 6, "Error while checking for proxy during fetch of SDK data: " + e10.getMessage());
            OTResponse oTResponse = new OTResponse(OTResponseType.OT_ERROR, 7, this.f21881a.getResources().getString(p6.f.f32893a), "");
            if (oTCallback != null) {
                oTCallback.onFailure(oTResponse);
            }
        }
    }

    public final void m(@NonNull final String str, @NonNull final String str2, @NonNull final String str3, final OTSdkParams oTSdkParams, z.a aVar, final String str4) {
        aVar.a(new w() { // from class: com.onetrust.otpublishers.headless.Internal.Network.k
            @Override // ga.w
            public final d0 intercept(w.a aVar2) {
                return this.f21870a.d(str, str2, str3, str4, oTSdkParams, aVar2);
            }
        });
    }

    public final void o(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z10, final OTNetworkRequestCallback oTNetworkRequestCallback) throws Throwable {
        Data dataBuild = new Data.Builder().putString("ott_consent_log_base_url", str).putString("ott_consent_log_end_point", str2).putString("ott_payload_id", str3).putBoolean("ott_consent_isProxy", z10).build();
        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(ConsentUploadWorker.class).setInputData(dataBuild).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10000L, TimeUnit.MILLISECONDS).build();
        WorkManager workManager = WorkManager.getInstance(this.f21881a);
        workManager.enqueue(oneTimeWorkRequestBuild);
        if (oTNetworkRequestCallback != null) {
            workManager.getWorkInfoByIdLiveData(oneTimeWorkRequestBuild.getId()).observeForever(new Observer() { // from class: com.onetrust.otpublishers.headless.Internal.Network.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    n.l(oTNetworkRequestCallback, (WorkInfo) obj);
                }
            });
        }
    }

    public final void q(@NonNull JSONObject jSONObject) throws JSONException {
        String str;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        if (new com.onetrust.otpublishers.headless.Internal.Preferences.g(this.f21881a).r()) {
            Context context = this.f21881a;
            boolean z10 = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0), "OT_ENABLE_MULTI_PROFILE")) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            String string = sharedPreferences.getString("OTT_PROFILE_SYNC_PROFILE_AUTH", null);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                OTLogger.a("NetworkRequestHandler", 4, "OT Profile Sync params set, enableJWTAuthForKnownUsers is true.Setting authorization header : " + string);
                jSONObject.put("authorization", string);
                return;
            }
            str = "EnableJWTAuthForKnownUsers is true, OT Profile Sync params not set. Not setting the authorization header.";
        } else {
            str = "EnableJWTAuthForKnownUsers is set to false.Not setting the authorization header.";
        }
        OTLogger.a("NetworkRequestHandler", 4, str);
    }

    public final boolean r() {
        OTProfileSyncParams otProfileSyncParams = com.onetrust.otpublishers.headless.Internal.c.a(this.f21881a).getOtProfileSyncParams();
        if (otProfileSyncParams != null) {
            return (!com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getSyncProfile()) && Boolean.parseBoolean(otProfileSyncParams.getSyncProfile())) && !com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getSyncProfileAuth()) && new com.onetrust.otpublishers.headless.Internal.Preferences.e(this.f21881a).d();
        }
        return false;
    }
}

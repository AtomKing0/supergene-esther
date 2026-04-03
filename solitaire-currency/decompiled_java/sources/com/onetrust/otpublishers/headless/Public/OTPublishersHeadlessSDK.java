package com.onetrust.otpublishers.headless.Public;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.PlaybackException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.onetrust.otpublishers.headless.Internal.Event.a;
import com.onetrust.otpublishers.headless.Internal.Helper.b0;
import com.onetrust.otpublishers.headless.Internal.Helper.d0;
import com.onetrust.otpublishers.headless.Internal.Helper.f0;
import com.onetrust.otpublishers.headless.Internal.Helper.g0;
import com.onetrust.otpublishers.headless.Internal.Helper.j;
import com.onetrust.otpublishers.headless.Internal.Helper.j0;
import com.onetrust.otpublishers.headless.Internal.Helper.k0;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.m;
import com.onetrust.otpublishers.headless.Internal.Helper.o;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Helper.v;
import com.onetrust.otpublishers.headless.Internal.Helper.w;
import com.onetrust.otpublishers.headless.Internal.Helper.x;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Network.n;
import com.onetrust.otpublishers.headless.Internal.Preferences.g;
import com.onetrust.otpublishers.headless.Internal.b;
import com.onetrust.otpublishers.headless.Internal.profile.d;
import com.onetrust.otpublishers.headless.Internal.syncnotif.k;
import com.onetrust.otpublishers.headless.Public.DataModel.OTCache;
import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTRenameProfileParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams;
import com.onetrust.otpublishers.headless.Public.Keys.OTFragmentTags;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import com.onetrust.otpublishers.headless.UI.Helper.e;
import com.onetrust.otpublishers.headless.UI.Helper.h;
import com.onetrust.otpublishers.headless.UI.fragment.a3;
import com.onetrust.otpublishers.headless.UI.fragment.c1;
import com.onetrust.otpublishers.headless.UI.fragment.h1;
import com.onetrust.otpublishers.headless.UI.fragment.i0;
import com.onetrust.otpublishers.headless.UI.fragment.l0;
import com.onetrust.otpublishers.headless.UI.fragment.m2;
import com.onetrust.otpublishers.headless.UI.fragment.o0;
import com.onetrust.otpublishers.headless.UI.fragment.r;
import com.onetrust.otpublishers.headless.UI.fragment.z;
import com.onetrust.otpublishers.headless.UI.mobiledatautils.c;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p6.f;

/* JADX INFO: loaded from: classes4.dex */
public class OTPublishersHeadlessSDK {
    public static final String VENDOR_DETAILS_ERROR_MSG = "Error in getting vendorDetails , error = ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k0 f22016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OTVendorUtils f22017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f22018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    public String f22020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f22021g;

    public OTPublishersHeadlessSDK(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f22015a = applicationContext;
        this.f22016b = new k0(applicationContext);
        this.f22017c = new OTVendorUtils(getVendorListData(), getVendorListData("google"), getVendorListData(OTVendorListMode.GENERAL));
        this.f22021g = new a();
        this.f22018d = new w(applicationContext);
    }

    @Keep
    public static void enableOTSDKLog(int i10) {
        OTLogger.f21819a = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #0 {Exception -> 0x005d, blocks: (B:9:0x0025, B:11:0x0031, B:16:0x0052, B:18:0x0058, B:15:0x004d, B:14:0x0038), top: B:27:0x0025, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity r7, @androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r8) {
        /*
            r6 = this;
            java.lang.String r0 = "OneTrust"
            android.content.Context r1 = r6.f22015a
            java.lang.String r2 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r3 = 0
            android.content.SharedPreferences r2 = r1.getSharedPreferences(r2, r3)
            boolean r4 = com.onetrust.otpublishers.headless.Internal.Helper.l.a(r1)
            java.lang.String r5 = ""
            if (r4 == 0) goto L20
            java.lang.String r3 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r3 = r2.getString(r3, r5)
            com.onetrust.otpublishers.headless.Internal.Preferences.h r4 = new com.onetrust.otpublishers.headless.Internal.Preferences.h
            r4.<init>(r1, r2, r3)
            r3 = 1
            goto L21
        L20:
            r4 = 0
        L21:
            if (r3 == 0) goto L24
            r2 = r4
        L24:
            r1 = 6
            java.lang.String r3 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r2 = r2.getString(r3, r5)     // Catch: java.lang.Exception -> L5d
            boolean r3 = com.onetrust.otpublishers.headless.Internal.c.q(r2)     // Catch: java.lang.Exception -> L5d
            if (r3 != 0) goto L4d
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5d
            r3.<init>(r2)     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5d
            goto L52
        L37:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5d
            java.lang.String r4 = "error while returning culture domain data, err: "
            r3.<init>(r4)     // Catch: java.lang.Exception -> L5d
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Exception -> L5d
            r3.append(r2)     // Catch: java.lang.Exception -> L5d
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L5d
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r1, r2)     // Catch: java.lang.Exception -> L5d
        L4d:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5d
            r3.<init>()     // Catch: java.lang.Exception -> L5d
        L52:
            int r2 = r3.length()     // Catch: java.lang.Exception -> L5d
            if (r2 <= 0) goto L69
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Exception -> L5d
            goto L69
        L5d:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "empty data as SDK not yet initialized "
            r3.<init>(r4)
            r4 = 3
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(r2, r3, r0, r4)
        L69:
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            if (r2 != 0) goto L80
            com.onetrust.otpublishers.headless.Internal.Event.a r0 = r6.f22021g
            com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason r1 = new com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason
            r2 = 110(0x6e, float:1.54E-43)
            java.lang.String r3 = com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason.getResponseMessage(r2)
            r1.<init>(r2, r3)
            com.onetrust.otpublishers.headless.UI.Helper.e.a(r7, r0, r8, r1, r6)
            goto L8b
        L80:
            android.content.Context r7 = r6.f22015a
            int r8 = p6.f.f32915w
            java.lang.String r7 = r7.getString(r8)
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r1, r7)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.a(androidx.fragment.app.FragmentActivity, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    @Keep
    public void addEventListener(@NonNull FragmentActivity fragmentActivity, @NonNull OTEventListener oTEventListener) {
        if (!c.i(fragmentActivity, "OTPublishersHeadlessSDK")) {
            OTLogger.a("OneTrust", 5, "addEventListener: activity passed - null");
            return;
        }
        addEventListener(oTEventListener);
        a eventListenerSetter = this.f22021g;
        ArrayList arrayList = new ArrayList();
        arrayList.add(OTFragmentTags.OT_BANNER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
        arrayList.add(OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String str = (String) arrayList.get(i10);
            Fragment fragmentFindFragmentByTag = com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, str) ? fragmentActivity.getSupportFragmentManager().findFragmentByTag(str) : null;
            if (fragmentFindFragmentByTag instanceof r) {
                r rVar = (r) fragmentFindFragmentByTag;
                rVar.getClass();
                t.i(eventListenerSetter, "eventListenerSetter");
                rVar.f23510e = eventListenerSetter;
            }
            if (fragmentFindFragmentByTag instanceof l0) {
                ((l0) fragmentFindFragmentByTag).D = eventListenerSetter;
            }
            if (fragmentFindFragmentByTag instanceof i0) {
                ((i0) fragmentFindFragmentByTag).Z = eventListenerSetter;
            }
            if (fragmentFindFragmentByTag instanceof m2) {
                m2 m2Var = (m2) fragmentFindFragmentByTag;
                m2Var.getClass();
                t.i(eventListenerSetter, "eventListenerSetter");
                m2Var.f23430d = eventListenerSetter;
            }
        }
    }

    @Keep
    public void appendCustomDataElements(@NonNull JSONObject jSONObject) {
        new com.onetrust.otpublishers.headless.Internal.Models.c(this.f22015a).b(jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #0 {Exception -> 0x005d, blocks: (B:9:0x0025, B:11:0x0031, B:16:0x0052, B:18:0x0058, B:15:0x004d, B:14:0x0038), top: B:27:0x0025, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity r7, @androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r8) {
        /*
            r6 = this;
            java.lang.String r0 = "OneTrust"
            android.content.Context r1 = r6.f22015a
            java.lang.String r2 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r3 = 0
            android.content.SharedPreferences r2 = r1.getSharedPreferences(r2, r3)
            boolean r4 = com.onetrust.otpublishers.headless.Internal.Helper.l.a(r1)
            java.lang.String r5 = ""
            if (r4 == 0) goto L20
            java.lang.String r3 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r3 = r2.getString(r3, r5)
            com.onetrust.otpublishers.headless.Internal.Preferences.h r4 = new com.onetrust.otpublishers.headless.Internal.Preferences.h
            r4.<init>(r1, r2, r3)
            r3 = 1
            goto L21
        L20:
            r4 = 0
        L21:
            if (r3 == 0) goto L24
            r2 = r4
        L24:
            r1 = 6
            java.lang.String r3 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r2 = r2.getString(r3, r5)     // Catch: java.lang.Exception -> L5d
            boolean r3 = com.onetrust.otpublishers.headless.Internal.c.q(r2)     // Catch: java.lang.Exception -> L5d
            if (r3 != 0) goto L4d
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5d
            r3.<init>(r2)     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5d
            goto L52
        L37:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5d
            java.lang.String r4 = "error while returning culture domain data, err: "
            r3.<init>(r4)     // Catch: java.lang.Exception -> L5d
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Exception -> L5d
            r3.append(r2)     // Catch: java.lang.Exception -> L5d
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L5d
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r1, r2)     // Catch: java.lang.Exception -> L5d
        L4d:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5d
            r3.<init>()     // Catch: java.lang.Exception -> L5d
        L52:
            int r2 = r3.length()     // Catch: java.lang.Exception -> L5d
            if (r2 <= 0) goto L69
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Exception -> L5d
            goto L69
        L5d:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "empty data as SDK not yet initialized "
            r3.<init>(r4)
            r4 = 3
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(r2, r3, r0, r4)
        L69:
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            if (r2 != 0) goto L80
            com.onetrust.otpublishers.headless.Internal.Event.a r0 = r6.f22021g
            com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason r1 = new com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason
            r2 = 210(0xd2, float:2.94E-43)
            java.lang.String r3 = com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason.getResponseMessage(r2)
            r1.<init>(r2, r3)
            com.onetrust.otpublishers.headless.UI.Helper.h.a(r7, r0, r8, r1, r6)
            goto L8b
        L80:
            android.content.Context r7 = r6.f22015a
            int r8 = p6.f.f32915w
            java.lang.String r7 = r7.getString(r8)
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r1, r7)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.b(androidx.fragment.app.FragmentActivity, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    @VisibleForTesting
    public void callSetupUI(@NonNull FragmentActivity fragmentActivity, int i10, @Nullable OTConfiguration oTConfiguration) {
        int iShowBannerReason = showBannerReason();
        if (iShowBannerReason > -1 && i10 == 0) {
            e.a(fragmentActivity, this.f22021g, oTConfiguration, new OTUIDisplayReason(iShowBannerReason, OTUIDisplayReason.getResponseMessage(iShowBannerReason)), this);
            return;
        }
        if (iShowBannerReason <= -1 || i10 != 1) {
            OTLogger.a("OneTrust", 5, "Not Showing UI, this could be because the consent has been taken already or its configured not to show UI.");
            new k().b(fragmentActivity, oTConfiguration, this);
        } else {
            int i11 = iShowBannerReason + 100;
            h.a(fragmentActivity, this.f22021g, oTConfiguration, new OTUIDisplayReason(i11, OTUIDisplayReason.getResponseMessage(i11)), this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #0 {Exception -> 0x005d, blocks: (B:9:0x0025, B:11:0x0031, B:16:0x0052, B:18:0x0058, B:15:0x004d, B:14:0x0038), top: B:28:0x0025, inners: #1 }] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void callShowConsentPreferencesUI(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity r6, @androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r7) {
        /*
            r5 = this;
            java.lang.String r7 = "OneTrust"
            android.content.Context r0 = r5.f22015a
            java.lang.String r1 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r2 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
            boolean r3 = com.onetrust.otpublishers.headless.Internal.Helper.l.a(r0)
            java.lang.String r4 = ""
            if (r3 == 0) goto L20
            java.lang.String r2 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r2 = r1.getString(r2, r4)
            com.onetrust.otpublishers.headless.Internal.Preferences.h r3 = new com.onetrust.otpublishers.headless.Internal.Preferences.h
            r3.<init>(r0, r1, r2)
            r2 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r2 == 0) goto L24
            r1 = r3
        L24:
            r0 = 6
            java.lang.String r2 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r1 = r1.getString(r2, r4)     // Catch: java.lang.Exception -> L5d
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r1)     // Catch: java.lang.Exception -> L5d
            if (r2 != 0) goto L4d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5d
            r2.<init>(r1)     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5d
            goto L52
        L37:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5d
            java.lang.String r3 = "error while returning culture domain data, err: "
            r2.<init>(r3)     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Exception -> L5d
            r2.append(r1)     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L5d
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r7, r0, r1)     // Catch: java.lang.Exception -> L5d
        L4d:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5d
            r2.<init>()     // Catch: java.lang.Exception -> L5d
        L52:
            int r1 = r2.length()     // Catch: java.lang.Exception -> L5d
            if (r1 <= 0) goto L69
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Exception -> L5d
            goto L69
        L5d:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "empty data as SDK not yet initialized "
            r2.<init>(r3)
            r3 = 3
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(r1, r2, r7, r3)
        L69:
            boolean r1 = com.onetrust.otpublishers.headless.Internal.c.q(r4)
            if (r1 == 0) goto L7b
            android.content.Context r6 = r5.f22015a
            int r1 = p6.f.f32915w
            java.lang.String r6 = r6.getString(r1)
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r7, r0, r6)
            return
        L7b:
            com.onetrust.otpublishers.headless.UI.Helper.g.a(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.callShowConsentPreferencesUI(androidx.fragment.app.FragmentActivity, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration):void");
    }

    @Keep
    public void clearOTSDKConfigurationData() {
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(this.f22015a, "OT_SDK_APP_CONFIGURATION").a();
    }

    @Keep
    public void clearOTSDKData() {
        com.onetrust.otpublishers.headless.Internal.c.y(this.f22015a);
        reInitiateLocalVariable();
    }

    @Keep
    public void deleteProfile(@Nullable String str, @NonNull OTCallback oTCallback) {
        if (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OneTrust", 5, "Empty profileId passed to delete the profile.");
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 13, this.f22015a.getResources().getString(f.f32909q), ""));
        } else {
            new d(this.f22015a).g(oTCallback, this, str, this.f22019e, this.f22020f, this.f22015a.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).getBoolean("OT_MULTI_PROFILE_DOWNLOAD_DATA_AFTER_SWITCH", false));
            reInitiateLocalVariable();
        }
    }

    @Keep
    public void dismissUI(@NonNull FragmentActivity fragmentActivity) {
        if (!isOTUIPresent(fragmentActivity)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "No OneTrust UI is present.");
            return;
        }
        try {
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_BANNER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_BANNER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag instanceof r) {
                    ((r) fragmentFindFragmentByTag).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag2 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag2 instanceof l0) {
                    ((l0) fragmentFindFragmentByTag2).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag3 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag3 instanceof i0) {
                    ((i0) fragmentFindFragmentByTag3).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag4 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_VENDOR_LIST_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag4 instanceof m2) {
                    ((m2) fragmentFindFragmentByTag4).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag5 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_VENDOR_DETAILS_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag5 instanceof a3) {
                    ((a3) fragmentFindFragmentByTag5).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag6 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_SDK_LIST_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag6 instanceof c1) {
                    ((c1) fragmentFindFragmentByTag6).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag7 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_VENDOR_LIST_FILTER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag7 instanceof o0) {
                    ((o0) fragmentFindFragmentByTag7).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag8 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_SDK_LIST_FILTER_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag8 instanceof h1) {
                    ((h1) fragmentFindFragmentByTag8).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG)) {
                Fragment fragmentFindFragmentByTag9 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
                if (fragmentFindFragmentByTag9 instanceof com.onetrust.otpublishers.headless.UI.TVUI.fragments.k) {
                    ((com.onetrust.otpublishers.headless.UI.TVUI.fragments.k) fragmentFindFragmentByTag9).dismiss();
                }
            }
            if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_IAB_ILLUSTRATION_DETAILS_TAG)) {
                Fragment fragmentFindFragmentByTag10 = fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_IAB_ILLUSTRATION_DETAILS_TAG);
                if (fragmentFindFragmentByTag10 instanceof z) {
                    ((z) fragmentFindFragmentByTag10).dismiss();
                }
            }
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("Something went wrong while closing UI: "), "UIUtils", 6);
        }
    }

    @Keep
    public int getAgeGatePromptValue() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        int i10 = sharedPreferences.getInt("OT_AGE_GATE_USER_CONSENT_STATUS", -1);
        OTLogger.a("AgeGateConsentHandler", 3, "Default Age Gate Consent status :" + i10);
        return i10;
    }

    @Nullable
    @Keep
    public JSONObject getBannerData() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_BANNER_DATA", null);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return null;
        }
        return new JSONObject(string);
    }

    @NonNull
    @Keep
    public JSONObject getCommonData() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_CULTURE_COMMON_DATA", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while returning common data, err: "), "OneTrust", 6);
            }
        }
        return new JSONObject();
    }

    @Keep
    public int getConsentStatusForGroupId(@NonNull String str) {
        return new g(this.f22015a).a(str);
    }

    @Keep
    public int getConsentStatusForSDKId(@NonNull String str) {
        return this.f22016b.f21777g.b(str, false);
    }

    @Nullable
    @Keep
    public String getCurrentActiveProfile() {
        return this.f22015a.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).getString("OT_ACTIVE_PROFILE_ID", "");
    }

    @NonNull
    @Keep
    public JSONObject getDomainGroupData() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_CULTURE_DOMAIN_DATA", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while returning culture domain data, err: "), "OneTrust", 6);
            }
        }
        return new JSONObject();
    }

    @NonNull
    @Keep
    public JSONObject getDomainInfo() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_DOMAIN_DATA", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while returning domain data, err: "), "OneTrust", 6);
            }
        }
        return new JSONObject();
    }

    @Nullable
    @Keep
    public OTGeolocationModel getLastDataDownloadedLocation() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        OTGeolocationModel oTGeolocationModel = null;
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_DATA_DOWNLOADED_GEO_LOCATION", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            oTGeolocationModel = new OTGeolocationModel();
            try {
                JSONObject jSONObject = new JSONObject(string);
                oTGeolocationModel.country = jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY);
                oTGeolocationModel.state = jSONObject.optString("state");
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error in formatting ott data with err = "), "GLDataHandler", 6);
            }
        }
        return oTGeolocationModel;
    }

    @Nullable
    @Keep
    public OTGeolocationModel getLastUserConsentedLocation() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        OTGeolocationModel oTGeolocationModel = null;
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_CONSENTED_LOCATION", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            oTGeolocationModel = new OTGeolocationModel();
            try {
                JSONObject jSONObject = new JSONObject(string);
                oTGeolocationModel.country = jSONObject.optString(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY);
                oTGeolocationModel.state = jSONObject.optString("state");
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error in formatting ott data with err = "), "GLDataHandler", 6);
            }
        }
        return oTGeolocationModel;
    }

    @NonNull
    @Keep
    public OTCache getOTCache() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        OTCache.OTCacheBuilder oTCacheBuilderNewInstance = OTCache.OTCacheBuilder.newInstance();
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_DATA_SUBJECT_IDENTIFIER", "");
        oTCacheBuilderNewInstance.setDataSubjectIdentifier(string != null ? string : "");
        return oTCacheBuilderNewInstance.build();
    }

    @Nullable
    @Keep
    public String getOTConsentJSForWebView() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        Context context = this.f22015a;
        d0 d0Var = new d0(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        if (!"0".equals(sharedPreferences.getString("OTT_LAST_GIVEN_CONSENT", "0"))) {
            return d0Var.b(true);
        }
        OTLogger.a("WebviewConsentHelper", 3, "WebviewConsent : user is not interacted, returning default ccpa, groups values. ");
        return d0Var.b(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0113  */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.onetrust.otpublishers.headless.gcm.consent.OTGoogleConsentModeData getOTGoogleConsentModeData() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.getOTGoogleConsentModeData():com.onetrust.otpublishers.headless.gcm.consent.OTGoogleConsentModeData");
    }

    @NonNull
    @Keep
    public OTVendorUtils getOtVendorUtils() {
        return this.f22017c;
    }

    @Nullable
    @Keep
    public JSONObject getPreferenceCenterData() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:9:0x0025, B:11:0x0031, B:16:0x0053, B:18:0x0059, B:15:0x004e, B:14:0x0038), top: B:32:0x0025, inners: #1 }] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getPurposeConsentLocal(@androidx.annotation.NonNull java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "OneTrust"
            android.content.Context r1 = r6.f22015a
            java.lang.String r2 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r3 = 0
            android.content.SharedPreferences r2 = r1.getSharedPreferences(r2, r3)
            boolean r4 = com.onetrust.otpublishers.headless.Internal.Helper.l.a(r1)
            java.lang.String r5 = ""
            if (r4 == 0) goto L20
            java.lang.String r3 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r3 = r2.getString(r3, r5)
            com.onetrust.otpublishers.headless.Internal.Preferences.h r4 = new com.onetrust.otpublishers.headless.Internal.Preferences.h
            r4.<init>(r1, r2, r3)
            r3 = 1
            goto L21
        L20:
            r4 = 0
        L21:
            if (r3 == 0) goto L24
            r2 = r4
        L24:
            r1 = 3
            java.lang.String r3 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r2 = r2.getString(r3, r5)     // Catch: java.lang.Exception -> L5e
            boolean r3 = com.onetrust.otpublishers.headless.Internal.c.q(r2)     // Catch: java.lang.Exception -> L5e
            if (r3 != 0) goto L4e
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5e
            r3.<init>(r2)     // Catch: org.json.JSONException -> L37 java.lang.Exception -> L5e
            goto L53
        L37:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5e
            java.lang.String r4 = "error while returning culture domain data, err: "
            r3.<init>(r4)     // Catch: java.lang.Exception -> L5e
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Exception -> L5e
            r3.append(r2)     // Catch: java.lang.Exception -> L5e
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L5e
            r3 = 6
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r3, r2)     // Catch: java.lang.Exception -> L5e
        L4e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5e
            r3.<init>()     // Catch: java.lang.Exception -> L5e
        L53:
            int r2 = r3.length()     // Catch: java.lang.Exception -> L5e
            if (r2 <= 0) goto L69
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Exception -> L5e
            goto L69
        L5e:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "empty data as SDK not yet initialized "
            r3.<init>(r4)
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(r2, r3, r0, r1)
        L69:
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r5)
            r2 = -1
            r3 = 5
            java.lang.String r4 = "Purpose Consent Update for id "
            java.lang.String r5 = "OTPublishersHeadlessSDK"
            if (r0 == 0) goto L8a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            r0.append(r7)
            java.lang.String r7 = " : -1, SDK not finished processing"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r5, r3, r7)
            return r2
        L8a:
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r7)
            if (r0 == 0) goto L96
            java.lang.String r7 = "Empty purpose id passed to get Purpose Consent Update"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r5, r3, r7)
            return r2
        L96:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            r0.append(r7)
            java.lang.String r2 = " : "
            r0.append(r2)
            com.onetrust.otpublishers.headless.Internal.Helper.k0 r2 = r6.f22016b
            int r2 = r2.a(r7)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r5, r1, r0)
            com.onetrust.otpublishers.headless.Internal.Helper.k0 r0 = r6.f22016b
            int r7 = r0.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.getPurposeConsentLocal(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #0 {Exception -> 0x005e, blocks: (B:9:0x0025, B:11:0x0031, B:16:0x0053, B:18:0x0059, B:15:0x004e, B:14:0x0038), top: B:38:0x0025, inners: #1 }] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getPurposeLegitInterestLocal(@androidx.annotation.NonNull java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.getPurposeLegitInterestLocal(java.lang.String):int");
    }

    @Keep
    public int getUCPurposeConsent(@NonNull String str) {
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return this.f22018d.u(str);
        }
        OTLogger.a("OTPublishersHeadlessSDK", 5, "Invalid id passed to get Purposes Consent Status");
        return -1;
    }

    public w getUcpHandler() {
        return this.f22018d;
    }

    @Keep
    public int getVendorCount(@NonNull String str) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10;
        JSONObject jSONObject;
        Context context = this.f22015a;
        int i10 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_VENDOR_COUNT_FOR_CATEGORIES", "");
        OTLogger.a("IAB2V2Flow", 3, "Getting vendorCountForCategoryString = " + string);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on getting vendor count for categories : "), "OTSPUtils", 6);
                jSONObject = new JSONObject();
            }
        }
        if (jSONObject.length() == 0) {
            OTLogger.a("OneTrust", 6, "getVendorCount: Vendor count data not found");
            return -1;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(str) || !jSONObject.has(str)) {
            OTLogger.a("OneTrust", 6, "getVendorCount: Invalid group id passed ");
            return -1;
        }
        String strG = com.onetrust.otpublishers.headless.UI.Helper.l.g(jSONObject, str);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(strG) && jSONObject.has(str)) {
            i10 = Integer.parseInt(strG);
        }
        OTLogger.a("OneTrust", 4, "getVendorCount: Vendor count for group " + str + " - " + i10);
        return i10;
    }

    @Nullable
    @Keep
    @Deprecated
    public JSONObject getVendorDetails(@NonNull String str, int i10) {
        if ("google".equalsIgnoreCase(str)) {
            return getVendorDetails(str, String.valueOf(i10));
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            return getVendorDetails(i10);
        }
        return null;
    }

    @Nullable
    @Keep
    @Deprecated
    public final JSONObject getVendorListData() {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        String str;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_IAB_ACTIVE_VENDORLIST", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            str = "Vendor List is empty";
        } else {
            str = "Saved IAB Active Vendor List : " + string;
        }
        OTLogger.a("IABHelper", 3, str);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error on Json object creation, error msg = "), "OTPublishersHeadlessSDK", 6);
            return null;
        }
    }

    @Nullable
    @Keep
    public JSONObject getVendorListUI(@NonNull String str) {
        if (!"google".equalsIgnoreCase(str)) {
            return OTVendorListMode.IAB.equalsIgnoreCase(str) ? getVendorListUI() : this.f22017c.getVendorListWithUserSelection(OTVendorListMode.GENERAL);
        }
        JSONObject vendorListWithUserSelection = this.f22017c.getVendorListWithUserSelection(str);
        if (vendorListWithUserSelection.length() > 0) {
            return vendorListWithUserSelection;
        }
        JSONObject vendorListData = getVendorListData(str);
        return vendorListData == null ? new JSONObject() : vendorListData;
    }

    @Keep
    public int isBannerShown(@NonNull Context context) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        int i10 = sharedPreferences.getInt("OneTrustBannerShownToUser", -1);
        OTLogger.a("OneTrust", 4, "Banner shown status : " + i10);
        return i10;
    }

    @Keep
    public boolean isOTUIPresent(@NonNull FragmentActivity fragmentActivity) {
        return com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_BANNER_FRAGMENT_TAG) || com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG) || com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_TV_MAIN_FRAGMENT_TAG);
    }

    @VisibleForTesting
    public void loadData(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull OTCallback oTCallback, boolean z10) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        if (z10) {
            OTLogger.a("OTPublishersHeadlessSDK", 4, "Starting OT SDK network call.");
            if (!com.onetrust.otpublishers.headless.Internal.c.v(str3)) {
                OTLogger.a("OTPublishersHeadlessSDK", 5, this.f22015a.getResources().getString(f.f32916x));
            }
            new n(this.f22015a).j(oTCallback, this, str, str2, str3, this.f22019e, this.f22020f);
            return;
        }
        Context context = this.f22015a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z11 = true;
        } else {
            hVar = null;
            z11 = false;
        }
        if (z11) {
            sharedPreferences = hVar;
        }
        if (sharedPreferences.getBoolean("OTT_OFFLINE_DATA_SET_FLAG", false)) {
            OTLogger.a("OTPublishersHeadlessSDK", 4, "Load offline data flag set false. Network not reachable. Offline data set. Loading offline data.");
            if (new d(this.f22015a).h(this, oTCallback)) {
                reInitiateLocalVariable();
                return;
            }
            return;
        }
        OTLogger.a("OTPublishersHeadlessSDK", 6, "Server not reachable");
        oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 6, this.f22015a.getResources().getString(f.f32893a) + " as server was not reachable", ""));
    }

    @Keep
    public void optIntoSaleOfData() {
        new com.onetrust.otpublishers.headless.Internal.Helper.g(this.f22015a).a(OTConsentInteractionType.PC_CONFIRM);
        if (new g0(this.f22015a).d(true, true)) {
            new f0(this.f22015a).a(OTConsentInteractionType.PC_CONFIRM);
        }
    }

    @Keep
    public void optOutOfSaleOfData() {
        new com.onetrust.otpublishers.headless.Internal.Helper.g(this.f22015a).a(OTConsentInteractionType.PC_CONFIRM);
        if (new g0(this.f22015a).d(false, true)) {
            new f0(this.f22015a).a(OTConsentInteractionType.PC_CONFIRM);
        }
    }

    @Keep
    @Deprecated
    public boolean overrideDataSubjectIdentifier(@NonNull String str) {
        if (str == null) {
            OTLogger.a("OTPublishersHeadlessSDK", 4, "overrideDataSubjectIdentifier: Pass a valid identifier!!");
            return false;
        }
        d dVar = new d(this.f22015a);
        if (dVar.t()) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "This method is now deprecated and replaced with renameProfile().");
            return com.onetrust.otpublishers.headless.Internal.c.q(str) ? switchUserProfile(str) : dVar.e(OTRenameProfileParams.OTRenameProfileParamsBuilder.newInstance().setOldProfileID("").setNewProfileID(str).build());
        }
        int i10 = 2;
        if (!str.isEmpty()) {
            try {
                j0 j0Var = new j0(this.f22015a);
                j0Var.b(this.f22015a, str);
                j0Var.f21770b.c(2);
                return true;
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error in updating consent : "), "OTPublishersHeadlessSDK", 6);
                return false;
            }
        }
        Context context = this.f22015a;
        j0 j0Var2 = new j0(context);
        if (str.isEmpty()) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0);
            String string = sharedPreferences.getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                string = UUID.randomUUID().toString();
                v.a(sharedPreferences, "OT_GENERIC_PROFILE_IDENTIFIER", string);
            }
            str = string;
            com.onetrust.otpublishers.headless.Internal.Helper.d.a("Generated identifier = ", str, "OTUtils", 4);
            i10 = 1;
        }
        j0Var2.f21770b.c(i10);
        j0Var2.f21770b.s(str);
        j0Var2.a();
        return true;
    }

    public void reInitVendorArray() {
        this.f22017c = new OTVendorUtils(getVendorListData(OTVendorListMode.IAB), getVendorListData("google"), getVendorListData(OTVendorListMode.GENERAL));
    }

    public void reInitiateLocalVariable() {
        this.f22016b = new k0(this.f22015a);
        this.f22018d = new w(this.f22015a);
        reInitVendorArray();
    }

    @Keep
    public void refreshUI(@NonNull AppCompatActivity appCompatActivity) {
        if (com.onetrust.otpublishers.headless.Internal.c.k(appCompatActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
            try {
                l0 l0Var = (l0) appCompatActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
                if (l0Var != null) {
                    l0Var.a();
                } else {
                    OTLogger.a("UIUtils", 4, "OTPcFragment not attached to the activity, refreshUI call failed.");
                }
                i0 i0Var = (i0) appCompatActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
                if (i0Var != null) {
                    i0Var.a();
                } else {
                    OTLogger.a("UIUtils", 4, "OTPCDetailsFragment not attached to the activity, refreshUI call failed.");
                }
            } catch (Exception e10) {
                OTLogger.a("UIUtils", 6, "Exception on refreshing the OT UI. Error: " + e10.getMessage());
            }
        }
    }

    @Keep
    public void renameProfile(@NonNull OTRenameProfileParams oTRenameProfileParams, @NonNull OTCallback oTCallback) {
        if (new d(this.f22015a).e(oTRenameProfileParams)) {
            oTCallback.onSuccess(new OTResponse(OTResponseType.OT_SUCCESS, 16, this.f22015a.getResources().getString(f.f32912t), ""));
        } else {
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 15, this.f22015a.getResources().getString(f.f32911s), ""));
        }
    }

    @Keep
    public void resetUpdatedConsent() {
        OTLogger.a("OTPublishersHeadlessSDK", 4, "Clearing user selections/local variables.");
        reInitiateLocalVariable();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014c  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void saveConsent(@androidx.annotation.NonNull java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 908
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.saveConsent(java.lang.String):void");
    }

    @Keep
    public void setEnvironment(@NonNull String str) {
        this.f22019e = str;
    }

    @Keep
    public void setFetchDataURL(@NonNull String str) {
        this.f22020f = str;
    }

    @VisibleForTesting
    public boolean setMultiProfileConfig(@Nullable OTSdkParams oTSdkParams, @NonNull OTCallback oTCallback, @NonNull d dVar) {
        String strA = dVar.a(oTSdkParams);
        if (!dVar.r(strA)) {
            dVar.s(dVar.a(oTSdkParams));
            OTLogger.a("MultiprofileConsent", 3, "Downloading the data for dsid = " + dVar.m());
            return true;
        }
        com.onetrust.otpublishers.headless.Internal.profile.e eVar = new com.onetrust.otpublishers.headless.Internal.profile.e(this.f22015a);
        if (!eVar.f21909a.c().getBoolean("OT_MULTI_PROFILE_CONSENT_ENABLED", false)) {
            String strM = dVar.m();
            OTLogger.a("MultiprofileConsent", 4, "Multi Profile Consent is disabled.");
            if (dVar.s(dVar.a(oTSdkParams)) <= 0) {
                return true;
            }
            eVar.c(strM);
            return true;
        }
        int iQ = dVar.q();
        int i10 = eVar.f21909a.c().getInt("OT_MULTI_PROFILE_MAXIMUM_PROFILES_LIMIT", 6);
        if (iQ < i10) {
            OTLogger.a("MultiprofileConsent", 3, "setMultiProfileConfig: profile created and set to " + strA);
            dVar.s(dVar.a(oTSdkParams));
            return true;
        }
        OTLogger.a("MultiprofileConsent", 5, "Max number of profiles already created. Please delete one of the profiles to be able to add a new one.");
        OTLogger.a("MultiprofileConsent", 3, "multiProfileCount = " + iQ + ", multiProfileLimit = " + i10);
        oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 8, this.f22015a.getResources().getString(f.f32895c), ""));
        return false;
    }

    @Keep
    public boolean setOTCache(@NonNull OTCache oTCache) {
        Context context = this.f22015a;
        if (!com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0), "OT_ENABLE_MULTI_PROFILE")) {
            return com.onetrust.otpublishers.headless.Internal.c.s(context, oTCache.getDataSubjectIdentifier());
        }
        String dataSubjectIdentifier = oTCache.getDataSubjectIdentifier();
        if (dataSubjectIdentifier == null) {
            OTLogger.a("OTCacheHandler", 4, "setDataSubjectIdentifier: Pass a valid identifier.");
            return false;
        }
        OTLogger.a("OTCacheHandler", 5, "This method is now deprecated and replaced with renameProfile().");
        if (com.onetrust.otpublishers.headless.Internal.c.q(dataSubjectIdentifier)) {
            return switchUserProfile(dataSubjectIdentifier);
        }
        return new d(context).e(OTRenameProfileParams.OTRenameProfileParamsBuilder.newInstance().setOldProfileID("").setNewProfileID(dataSubjectIdentifier).build());
    }

    @Keep
    public void setOTOfflineData(@NonNull JSONObject jSONObject) {
        try {
            com.onetrust.otpublishers.headless.Internal.Network.p.a(this.f22015a, this, jSONObject);
            new g(this.f22015a).j(true);
        } catch (JSONException unused) {
            OTLogger.a("OTPublishersHeadlessSDK", 6, "Error on setting offline data.");
            OTLogger.a("OTPublishersHeadlessSDK", 3, "Setting OfflineDataSetFlag to false.");
            new g(this.f22015a).j(false);
        }
    }

    @Keep
    public boolean setOTUXParams(@NonNull OTUXParams oTUXParams) {
        return m.a(this.f22015a, oTUXParams);
    }

    @Keep
    public void setupUI(@NonNull AppCompatActivity appCompatActivity, int i10) {
        callSetupUI(appCompatActivity, i10, null);
    }

    @Keep
    public boolean shouldShowBanner() {
        return showBannerReason() > -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e A[Catch: Exception -> 0x0063, TRY_LEAVE, TryCatch #2 {Exception -> 0x0063, blocks: (B:11:0x002b, B:13:0x0037, B:18:0x0058, B:20:0x005e, B:17:0x0053, B:16:0x003e), top: B:36:0x002b, outer: #0, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int showBannerReason() {
        /*
            r8 = this;
            java.lang.String r0 = "OneTrust"
            r1 = 6
            r2 = -1
            android.content.Context r3 = r8.f22015a     // Catch: org.json.JSONException -> L91
            java.lang.String r4 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r5 = 0
            android.content.SharedPreferences r4 = r3.getSharedPreferences(r4, r5)     // Catch: org.json.JSONException -> L91
            com.onetrust.otpublishers.headless.Internal.profile.d r6 = new com.onetrust.otpublishers.headless.Internal.profile.d     // Catch: org.json.JSONException -> L91
            r6.<init>(r3)     // Catch: org.json.JSONException -> L91
            boolean r6 = r6.t()     // Catch: org.json.JSONException -> L91
            java.lang.String r7 = ""
            if (r6 == 0) goto L27
            java.lang.String r5 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r5 = r4.getString(r5, r7)     // Catch: org.json.JSONException -> L91
            com.onetrust.otpublishers.headless.Internal.Preferences.h r6 = new com.onetrust.otpublishers.headless.Internal.Preferences.h     // Catch: org.json.JSONException -> L91
            r6.<init>(r3, r4, r5)     // Catch: org.json.JSONException -> L91
            r5 = 1
            goto L28
        L27:
            r6 = 0
        L28:
            if (r5 == 0) goto L2b
            r4 = r6
        L2b:
            java.lang.String r3 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r3 = r4.getString(r3, r7)     // Catch: java.lang.Exception -> L63
            boolean r4 = com.onetrust.otpublishers.headless.Internal.c.q(r3)     // Catch: java.lang.Exception -> L63
            if (r4 != 0) goto L53
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3d java.lang.Exception -> L63
            r4.<init>(r3)     // Catch: org.json.JSONException -> L3d java.lang.Exception -> L63
            goto L58
        L3d:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L63
            java.lang.String r5 = "error while returning culture domain data, err: "
            r4.<init>(r5)     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Exception -> L63
            r4.append(r3)     // Catch: java.lang.Exception -> L63
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Exception -> L63
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r1, r3)     // Catch: java.lang.Exception -> L63
        L53:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L63
            r4.<init>()     // Catch: java.lang.Exception -> L63
        L58:
            int r3 = r4.length()     // Catch: java.lang.Exception -> L63
            if (r3 <= 0) goto L7a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> L63
            goto L7a
        L63:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L91
            java.lang.String r5 = "empty data as SDK not yet initialized "
            r4.<init>(r5)     // Catch: org.json.JSONException -> L91
            java.lang.String r3 = r3.getMessage()     // Catch: org.json.JSONException -> L91
            r4.append(r3)     // Catch: org.json.JSONException -> L91
            java.lang.String r3 = r4.toString()     // Catch: org.json.JSONException -> L91
            r4 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r4, r3)     // Catch: org.json.JSONException -> L91
        L7a:
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r7)     // Catch: org.json.JSONException -> L91
            if (r0 == 0) goto L81
            return r2
        L81:
            com.onetrust.otpublishers.headless.Internal.Models.d r0 = new com.onetrust.otpublishers.headless.Internal.Models.d     // Catch: org.json.JSONException -> L91
            android.content.Context r3 = r8.f22015a     // Catch: org.json.JSONException -> L91
            r0.<init>(r3)     // Catch: org.json.JSONException -> L91
            org.json.JSONObject r3 = r8.getBannerData()     // Catch: org.json.JSONException -> L91
            int r2 = r0.b(r3)     // Catch: org.json.JSONException -> L91
            goto L9e
        L91:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Error while computing show banner status,returning default value as false: "
            r3.<init>(r4)
            java.lang.String r4 = "OTPublishersHeadlessSDK"
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r0, r3, r4, r1)
        L9e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.showBannerReason():int");
    }

    @Keep
    public void showBannerUI(@NonNull AppCompatActivity appCompatActivity) {
        a(appCompatActivity, null);
    }

    @Keep
    public void showConsentPurposesUI(@NonNull FragmentActivity fragmentActivity) {
        callShowConsentPreferencesUI(fragmentActivity, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:9:0x0027, B:11:0x0033, B:16:0x0054, B:18:0x005a, B:15:0x004f, B:14:0x003a), top: B:46:0x0027, inners: #2 }] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void showConsentUI(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity r9, int r10, @androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r11, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Public.OTConsentUICallback r12) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.showConsentUI(androidx.fragment.app.FragmentActivity, int, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration, com.onetrust.otpublishers.headless.Public.OTConsentUICallback):void");
    }

    @Keep
    public void showPreferenceCenterUI(@NonNull AppCompatActivity appCompatActivity) {
        b(appCompatActivity, null);
    }

    @Keep
    public void startSDK(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable OTSdkParams oTSdkParams, @NonNull OTCallback oTCallback) {
        a(str, str2, str3, oTSdkParams, false, oTCallback);
    }

    @Keep
    @Deprecated
    public boolean switchUserProfile(@NonNull String str) {
        boolean zL = new d(this.f22015a).l(null, this, str, this.f22019e, this.f22020f, false);
        if (zL) {
            reInitiateLocalVariable();
        }
        return zL;
    }

    public void updateAllSDKConsentStatus(@NonNull JSONArray jSONArray, boolean z10) {
        o oVar = this.f22016b.f21777g;
        String string = oVar.f21782a.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string2 = jSONArray.get(i10).toString();
                if (jSONObject.has(string2) && 2 != jSONObject.getInt(string2)) {
                    oVar.f21784c.put(string2, z10 ? 1 : 0);
                }
            }
            OTLogger.a("SdkListHelper", 4, "Updated All SDK status for  - " + oVar.f21784c);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while updating all sdk status "), "SdkListHelper", 6);
        }
    }

    @Keep
    public void updateAllVendorsConsentLocal(@NonNull String str, boolean z10) {
        this.f22017c.updateAllVendorsConsentLocal(str, z10);
        this.f22017c.updateVendorObjectLocalState(str);
    }

    @Keep
    public void updatePurposeConsent(@NonNull String str, boolean z10) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        if (this.f22016b.q(str, z10)) {
            try {
                k0 k0Var = this.f22016b;
                OTVendorUtils oTVendorUtils = this.f22017c;
                Context context = k0Var.f21771a;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                    hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z11 = true;
                } else {
                    hVar = null;
                    z11 = false;
                }
                if ((z11 ? hVar : sharedPreferences).getBoolean("OT_GENERAL_VENDORS_CONFIGURED", false)) {
                    if (z11) {
                        sharedPreferences = hVar;
                    }
                    if (sharedPreferences.getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false)) {
                        if (com.onetrust.otpublishers.headless.Internal.c.q(k0Var.f21776f)) {
                            try {
                                k0Var.f21776f = k0Var.m();
                            } catch (JSONException unused) {
                                OTLogger.a("CustomGroupDetails", 6, "Error on creating valid consent able parent child map.");
                            }
                        }
                        oTVendorUtils.updateVendorConsentStatusBasedOnCategoryStatus(OTVendorListMode.GENERAL, str, k0Var.f21776f, z10, this);
                        return;
                    }
                }
                OTLogger.a("GeneralVendors", 5, "Cannot update consent for the Vendor ID:General Vendor data with opt-out not found in template settings");
            } catch (JSONException unused2) {
                OTLogger.a("OTPublishersHeadlessSDK", 6, "Error on updating general vendor status.");
            }
        }
    }

    @Keep
    public void updatePurposeLegitInterest(@NonNull String str, boolean z10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Empty purpose id passed to update Purpose LegitInterest method.");
            return;
        }
        if (!str.startsWith("IABV2") && !str.startsWith("IAB2V2")) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Invalid ID " + str + " passed to update Purpose LegitInterest");
            return;
        }
        k0 k0Var = this.f22016b;
        try {
            if (new JSONObject(k0Var.f21774d.getString("OTT_IAB_CONSENTABLE_PURPOSES", "")).getJSONObject("purposeLegitimateInterests").has(com.onetrust.otpublishers.headless.Internal.Helper.c.s(str))) {
                k0Var.f21773c.put(str, z10 ? 1 : 0);
                OTLogger.a("CustomGroupDetails", 4, "Legitimate Interest value updated for Purpose " + str + " with value : " + z10);
            } else {
                OTLogger.a("CustomGroupDetails", 5, "Legitimate Interest value not updated for Purpose ".concat(str));
            }
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("error in updating purpose legitimate interest status. err = "), "CustomGroupDetails", 6);
        }
    }

    public void updateSDKConsentStatus(@NonNull String str, boolean z10) {
        this.f22016b.f21777g.i(str, z10);
    }

    @Keep
    public void updateUCPurposeConsent(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str3) || com.onetrust.otpublishers.headless.Internal.c.q(str2) || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Invalid id passed to update Custom Preference Options");
            return;
        }
        if (getUCPurposeConsent(str3) < 1) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Purpose consent for " + str3 + " is disabled, thus Custom Preference cannot be enabled");
            return;
        }
        this.f22018d.g(str2, str.trim() + str3.trim() + str2.trim(), str, z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (r1.getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false) != false) goto L32;
     */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateVendorConsent(@androidx.annotation.NonNull java.lang.String r9, @androidx.annotation.NonNull java.lang.String r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "google"
            boolean r0 = r0.equalsIgnoreCase(r9)
            java.lang.String r1 = "Empty vendor id passed to updateVendorConsent method."
            r2 = 5
            if (r0 != 0) goto L67
            java.lang.String r0 = "iab"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L14
            goto L67
        L14:
            java.lang.String r0 = "general"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L78
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r10)
            java.lang.String r3 = "GeneralVendors"
            if (r0 == 0) goto L28
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r3, r2, r1)
            return
        L28:
            android.content.Context r0 = r8.f22015a
            java.lang.String r1 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r4 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r4)
            boolean r5 = com.onetrust.otpublishers.headless.Internal.Helper.l.a(r0)
            if (r5 == 0) goto L46
            java.lang.String r5 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r6 = ""
            java.lang.String r5 = r1.getString(r5, r6)
            com.onetrust.otpublishers.headless.Internal.Preferences.h r6 = new com.onetrust.otpublishers.headless.Internal.Preferences.h
            r6.<init>(r0, r1, r5)
            r0 = 1
            goto L48
        L46:
            r6 = 0
            r0 = r4
        L48:
            if (r0 == 0) goto L4c
            r5 = r6
            goto L4d
        L4c:
            r5 = r1
        L4d:
            java.lang.String r7 = "OT_GENERAL_VENDORS_CONFIGURED"
            boolean r5 = r5.getBoolean(r7, r4)
            if (r5 == 0) goto L61
            if (r0 == 0) goto L58
            r1 = r6
        L58:
            java.lang.String r0 = "OT_GENERAL_VENDORS_TOGGLE_CONFIGURED"
            boolean r0 = r1.getBoolean(r0, r4)
            if (r0 == 0) goto L61
            goto L73
        L61:
            java.lang.String r9 = "Cannot update consent for the Vendor ID:General Vendor data with opt-out not found in template settings"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r3, r2, r9)
            goto L78
        L67:
            boolean r0 = com.onetrust.otpublishers.headless.Internal.c.q(r10)
            if (r0 == 0) goto L73
            java.lang.String r9 = "OTPublishersHeadlessSDK"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r9, r2, r1)
            return
        L73:
            com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils r0 = r8.f22017c
            r0.updateVendorConsentStatus(r9, r10, r11)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK.updateVendorConsent(java.lang.String, java.lang.String, boolean):void");
    }

    @Keep
    public void updateVendorLegitInterest(@NonNull String str, @NonNull String str2, boolean z10) {
        if ("google".equalsIgnoreCase(str)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Legitimate Interest not supported for Google vendors.");
        } else {
            updateVendorLegitInterest(str2, z10);
        }
    }

    @Keep
    public void writeLogsToFile(boolean z10, boolean z11) {
        if (z10) {
            OTLogger.open(this.f22015a.getFilesDir() + "/OTPublisherHeadlessSDKLogs.log", 2, PlaybackException.CUSTOM_ERROR_CODE_BASE);
        } else if (z11 && !z10) {
            OTLogger.a("OTPublishersHeadlessSDK", 4, "Write To File Should be Enabled!");
        }
        OTLogger.f21825g = z10;
        OTLogger.f21826h = z11;
    }

    @Keep
    public int getConsentStatusForGroupId(@NonNull String str, @NonNull String str2) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            com.onetrust.otpublishers.headless.Internal.Helper.d.a("Invalid custom group Id passed - ", str, "OTPublishersHeadlessSDK", 4);
            return -1;
        }
        int iA = new g(this.f22015a).a(str);
        return iA == -1 ? AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equalsIgnoreCase(str2) ? 1 : 0 : iA;
    }

    @Nullable
    @Keep
    @Deprecated
    public JSONObject getVendorDetails(int i10) {
        try {
            JSONObject vendorListWithUserSelectionWithoutFallback = this.f22017c.getVendorListWithUserSelectionWithoutFallback(OTVendorListMode.IAB);
            if (vendorListWithUserSelectionWithoutFallback == null) {
                vendorListWithUserSelectionWithoutFallback = getVendorListData(OTVendorListMode.IAB);
            }
            if (vendorListWithUserSelectionWithoutFallback == null) {
                vendorListWithUserSelectionWithoutFallback = new JSONObject();
            }
            return b0.a(this.f22015a, i10, OTVendorUtils.getVendorsListObject(vendorListWithUserSelectionWithoutFallback, String.valueOf(i10)));
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder(VENDOR_DETAILS_ERROR_MSG), "OTPublishersHeadlessSDK", 6);
            return null;
        }
    }

    @Nullable
    @Keep
    @Deprecated
    public JSONObject getVendorListUI() {
        JSONObject vendorListWithUserSelection = this.f22017c.getVendorListWithUserSelection(OTVendorListMode.IAB);
        if ((vendorListWithUserSelection == null || vendorListWithUserSelection.length() <= 0) && (vendorListWithUserSelection = getVendorListData(OTVendorListMode.IAB)) == null) {
            vendorListWithUserSelection = new JSONObject();
        }
        OTLogger.a("OTPublishersHeadlessSDK", 3, "getVendorListUI: " + vendorListWithUserSelection.length() + "," + vendorListWithUserSelection);
        return vendorListWithUserSelection;
    }

    @Keep
    @Deprecated
    public void renameProfile(@NonNull String str, @NonNull String str2, @NonNull OTCallback oTCallback) {
        renameProfile(OTRenameProfileParams.OTRenameProfileParamsBuilder.newInstance().setOldProfileID(str).setNewProfileID(str2).build(), oTCallback);
    }

    @Keep
    public void setupUI(@NonNull FragmentActivity fragmentActivity, int i10) {
        callSetupUI(fragmentActivity, i10, null);
    }

    @Keep
    public void showBannerUI(@NonNull FragmentActivity fragmentActivity) {
        a(fragmentActivity, null);
    }

    @Keep
    public void showPreferenceCenterUI(@NonNull FragmentActivity fragmentActivity) {
        b(fragmentActivity, null);
    }

    @Keep
    public void startSDK(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable OTSdkParams oTSdkParams, boolean z10, @NonNull OTCallback oTCallback) {
        a(str, str2, str3, oTSdkParams, z10, oTCallback);
    }

    @Keep
    public void switchUserProfile(@NonNull String str, @NonNull OTCallback oTCallback) {
        if (new d(this.f22015a).l(oTCallback, this, str, this.f22019e, this.f22020f, this.f22015a.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).getBoolean("OT_MULTI_PROFILE_DOWNLOAD_DATA_AFTER_SWITCH", false))) {
            reInitiateLocalVariable();
        }
    }

    @Keep
    public void updateAllVendorsConsentLocal(boolean z10) {
        this.f22017c.updateAllVendorsConsentLocal(OTVendorListMode.IAB, z10);
    }

    @Keep
    public int getUCPurposeConsent(@NonNull String str, @NonNull String str2) {
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2) && !com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return this.f22018d.a(str, str2);
        }
        OTLogger.a("OTPublishersHeadlessSDK", 5, "Invalid id passed to get UCP Topic Consent Status");
        return -1;
    }

    @Nullable
    @Keep
    public JSONObject getVendorDetails(@NonNull String str, @NonNull String str2) {
        try {
            if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
                JSONObject vendorDetails = getVendorDetails(Integer.parseInt(str2));
                OTLogger.a("OTPublishersHeadlessSDK", 3, "Vendor mode = " + str + ", Vendor details for ID:" + str2 + " " + vendorDetails);
                return vendorDetails;
            }
            if ("google".equalsIgnoreCase(str)) {
                JSONObject vendorListWithUserSelectionWithoutFallback = this.f22017c.getVendorListWithUserSelectionWithoutFallback(str);
                if (vendorListWithUserSelectionWithoutFallback == null) {
                    vendorListWithUserSelectionWithoutFallback = getVendorListData(str);
                }
                if (vendorListWithUserSelectionWithoutFallback == null) {
                    vendorListWithUserSelectionWithoutFallback = new JSONObject();
                }
                JSONObject vendorsListObject = OTVendorUtils.getVendorsListObject(vendorListWithUserSelectionWithoutFallback, str2);
                OTLogger.a("OTPublishersHeadlessSDK", 3, "Vendor mode = " + str + ", Vendor details for ID:" + str2 + " " + vendorsListObject);
                return vendorsListObject;
            }
            JSONObject vendorListWithUserSelectionWithoutFallback2 = this.f22017c.getVendorListWithUserSelectionWithoutFallback(str);
            if (vendorListWithUserSelectionWithoutFallback2 == null) {
                vendorListWithUserSelectionWithoutFallback2 = getVendorListData(str);
            }
            if (vendorListWithUserSelectionWithoutFallback2 == null) {
                vendorListWithUserSelectionWithoutFallback2 = new JSONObject();
            }
            JSONObject vendorsListObject2 = OTVendorUtils.getVendorsListObject(vendorListWithUserSelectionWithoutFallback2, str2);
            OTLogger.a("OTPublishersHeadlessSDK", 3, "Vendor mode = " + str + ", Vendor details for ID:" + str2 + " " + vendorsListObject2);
            return vendorsListObject2;
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder(VENDOR_DETAILS_ERROR_MSG), "OTPublishersHeadlessSDK", 6);
            return null;
        }
    }

    @Keep
    public void setupUI(@NonNull FragmentActivity fragmentActivity, int i10, @NonNull OTConfiguration oTConfiguration) {
        callSetupUI(fragmentActivity, i10, oTConfiguration);
    }

    public void showBannerUI(@NonNull FragmentActivity fragmentActivity, @NonNull OTConfiguration oTConfiguration) {
        a(fragmentActivity, oTConfiguration);
    }

    @Keep
    public void showPreferenceCenterUI(@NonNull FragmentActivity fragmentActivity, @NonNull OTConfiguration oTConfiguration) {
        b(fragmentActivity, oTConfiguration);
    }

    @Keep
    @Deprecated
    public void updateVendorLegitInterest(@NonNull String str, boolean z10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Empty vendor id passed to updateVendorLegitInterest method.");
            return;
        }
        try {
            if (!getDomainGroupData().isNull("LegIntSettings")) {
                if (getDomainGroupData().getJSONObject("LegIntSettings").getBoolean("PAllowLI")) {
                    this.f22017c.updateVendorLegitInterest(OTVendorListMode.IAB, str, z10);
                } else {
                    OTLogger.a("OTPublishersHeadlessSDK", 5, "Not updated LI value for vendor ID " + str + ", LI not configured for this vendor Id.");
                }
            }
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("Error while checking LI feature toggle"), "OTPublishersHeadlessSDK", 6);
        }
    }

    @Keep
    public int getUCPurposeConsent(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str3) && !com.onetrust.otpublishers.headless.Internal.c.q(str2) && !com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return this.f22018d.b(str, str3, str2);
        }
        OTLogger.a("OTPublishersHeadlessSDK", 5, "Invalid id passed to get UCP Custom Preference Option Consent Status");
        return -1;
    }

    @Keep
    public void updateUCPurposeConsent(@NonNull String str, @NonNull String str2, boolean z10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str2) || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Invalid id passed to update Topics");
            return;
        }
        if (getUCPurposeConsent(str2) < 1) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Purpose consent for " + str2 + " is disabled, thus topic cannot be enabled");
            return;
        }
        this.f22018d.t(str.trim() + str2.trim(), str, z10);
    }

    @Keep
    @Deprecated
    public boolean deleteProfile(@Nullable String str) {
        if (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OneTrust", 5, "Empty profileId passed to delete the profile.");
            return false;
        }
        boolean zG = new d(this.f22015a).g(null, this, str, this.f22019e, this.f22020f, false);
        reInitiateLocalVariable();
        return zG;
    }

    @Keep
    public void updateUCPurposeConsent(@NonNull String str, boolean z10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Invalid id passed to update Purposes");
        } else {
            this.f22018d.j(str, z10);
        }
    }

    @Nullable
    @Keep
    public JSONObject getVendorListData(@NonNull String str) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        JSONObject jSONObject;
        Context context = this.f22015a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            if (z10) {
                sharedPreferences = hVar;
            }
            String string = sharedPreferences.getString("OT_GENERAL_VENDORS", "");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e10) {
                    x.a("Something went wrong while parsing savedGeneral Vendors: ", e10, "GeneralVendors", 3);
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
            }
            OTLogger.a("OTPublishersHeadlessSDK", 4, "Saved General Vendors : " + jSONObject);
            return jSONObject;
        }
        if ("google".equalsIgnoreCase(str)) {
            if (z10) {
                sharedPreferences = hVar;
            }
            try {
                String string2 = sharedPreferences.getString("OT_GOOGLE_ACTIVE_VENDOR_LIST", null);
                if (com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                    return null;
                }
                return new JSONObject(string2);
            } catch (JSONException e11) {
                p.a(e11, new StringBuilder("error while getting culture data json on getActiveGoogleVendors, err: "), "OneTrust", 6);
                return null;
            }
        }
        return getVendorListData();
    }

    @Keep
    public void refreshUI(@NonNull FragmentActivity fragmentActivity) {
        if (com.onetrust.otpublishers.headless.Internal.c.k(fragmentActivity, OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG)) {
            try {
                l0 l0Var = (l0) fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_FRAGMENT_TAG);
                if (l0Var != null) {
                    l0Var.a();
                } else {
                    OTLogger.a("UIUtils", 4, "OTPcFragment not attached to the activity, refreshUI call failed.");
                }
                i0 i0Var = (i0) fragmentActivity.getSupportFragmentManager().findFragmentByTag(OTFragmentTags.OT_PREFERENCE_CENTER_DETAILS_FRAGMENT_TAG);
                if (i0Var != null) {
                    i0Var.a();
                } else {
                    OTLogger.a("UIUtils", 4, "OTPCDetailsFragment not attached to the activity, refreshUI call failed.");
                }
            } catch (Exception e10) {
                OTLogger.a("UIUtils", 6, "Exception on refreshing the OT UI. Error: " + e10.getMessage());
            }
        }
    }

    public final void a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable OTSdkParams oTSdkParams, boolean z10, @NonNull OTCallback oTCallback) {
        boolean multiProfileConfig;
        OTProfileSyncParams otProfileSyncParams;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str) || com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "empty parameters passed");
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 4, this.f22015a.getResources().getString(f.f32894b), ""));
        }
        new com.onetrust.otpublishers.headless.Internal.upgrade.a(this.f22015a).c();
        Context context = this.f22015a;
        g gVar = new g(context);
        String str4 = "0";
        if (oTSdkParams != null && b.a(oTSdkParams.getCreateProfile()) && (otProfileSyncParams = oTSdkParams.getOtProfileSyncParams()) != null && b.a(otProfileSyncParams.getSyncProfile()) && !com.onetrust.otpublishers.headless.Internal.c.q(otProfileSyncParams.getSyncProfileAuth())) {
            String identifier = otProfileSyncParams.getIdentifier();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(identifier)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0), "OT_ENABLE_MULTI_PROFILE")) {
                    hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z11 = true;
                } else {
                    hVar = null;
                    z11 = false;
                }
                String string = (z11 ? hVar : sharedPreferences).getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
                String string2 = (z11 ? hVar : sharedPreferences).getString("OT_ACTIVE_PROFILE_ID", "");
                String string3 = gVar.f21893a.c().getString("OTT_LAST_GIVEN_CONSENT", "0");
                long j10 = com.onetrust.otpublishers.headless.Internal.c.q(string3) ? 0L : Long.parseLong(string3);
                if ((j10 <= 0 || com.onetrust.otpublishers.headless.Internal.c.q(string2) || string2 == null || com.onetrust.otpublishers.headless.Internal.c.q(string) || !string2.equalsIgnoreCase(string) || identifier.equalsIgnoreCase(string)) ? false : true) {
                    str4 = "1";
                } else if (j10 > 0 && !com.onetrust.otpublishers.headless.Internal.c.q(string2) && identifier.equalsIgnoreCase(string2)) {
                    String string4 = (z11 ? hVar : sharedPreferences).getString("OTT_CREATE_CONSENT_PROFILE_STRING", null);
                    String string5 = (z11 ? hVar : sharedPreferences).getString("OTT_PROFILE_SYNC_PROFILE_STRING", null);
                    if (z11) {
                        sharedPreferences = hVar;
                    }
                    String string6 = sharedPreferences.getString("OTT_PROFILE_SYNC_PROFILE_AUTH", null);
                    if (!b.a(string4) || !b.a(string5) || com.onetrust.otpublishers.headless.Internal.c.q(string6)) {
                        str4 = "2";
                    }
                }
            }
        }
        gVar.n(str4);
        com.onetrust.otpublishers.headless.Internal.c.f(this.f22015a, str, str2, str3, this);
        d dVar = new d(this.f22015a);
        if (com.onetrust.otpublishers.headless.Internal.c.q(dVar.m()) || dVar.q() == 0) {
            OTLogger.a("MultiprofileConsent", 3, "Setting first profile configuration.");
            if (dVar.s(dVar.a(oTSdkParams)) >= 0 && !dVar.t()) {
                OTLogger.a("multiProfileEnabled", 3, "startOTSDKFlow flow ,calling enableMultiProfile.");
                new d(this.f22015a).j();
                OTLogger.a("multiProfileEnabled", 3, "startOTSDKFlow flow ,reinitializing  the shared preference related variables.");
                reInitiateLocalVariable();
            }
            multiProfileConfig = true;
        } else {
            multiProfileConfig = setMultiProfileConfig(oTSdkParams, oTCallback, dVar);
        }
        if (multiProfileConfig) {
            com.onetrust.otpublishers.headless.Internal.c.d(this.f22015a, oTSdkParams, z10);
            com.onetrust.otpublishers.headless.Internal.c.z(this.f22015a);
            if (!z10) {
                loadData(str, str2, str3, oTCallback, com.onetrust.otpublishers.headless.Internal.Network.o.a(this.f22015a));
                return;
            }
            OTLogger.a("OTPublishersHeadlessSDK", 4, "Loading offline data.");
            if (new d(this.f22015a).h(this, oTCallback)) {
                reInitiateLocalVariable();
            }
        }
    }

    @Keep
    @Deprecated
    public void updateVendorConsent(@NonNull String str, boolean z10) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("OTPublishersHeadlessSDK", 5, "Empty vendor id passed to updateVendorConsent method.");
        } else {
            this.f22017c.updateVendorConsentStatus(OTVendorListMode.IAB, str, z10);
        }
    }

    @Keep
    public void updatePurposeConsent(@NonNull String str, boolean z10, boolean z11) {
        boolean z12;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z13;
        if (z11) {
            k0 k0Var = this.f22016b;
            OTVendorUtils oTVendorUtils = this.f22017c;
            if (k0Var.q(str, z10)) {
                if (com.onetrust.otpublishers.headless.Internal.c.q(k0Var.f21776f)) {
                    try {
                        k0Var.f21776f = k0Var.m();
                    } catch (JSONException unused) {
                        OTLogger.a("CustomGroupDetails", 6, "Error on creating valid consent able parent child map.");
                    }
                }
                String str2 = k0Var.f21776f;
                if (!com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has(str)) {
                            JSONArray jSONArray = jSONObject.getJSONArray(str);
                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                String string = jSONArray.get(i10).toString();
                                k0Var.q(string, z10);
                                k0Var.e(string, z10);
                            }
                        } else {
                            JSONObject jSONObject2 = new JSONObject(k0Var.f21775e.f21893a.c().getString("DOMAIN_PARENT_ID_MAP", ""));
                            String string2 = jSONObject2.has(str) ? jSONObject2.getString(str) : null;
                            if (string2 != null && !com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray(string2);
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= jSONArray2.length()) {
                                        z13 = true;
                                        break;
                                    } else {
                                        if (k0Var.a(jSONArray2.get(i11).toString()) != 1) {
                                            z13 = false;
                                            break;
                                        }
                                        i11++;
                                    }
                                }
                                k0Var.q(string2, z13);
                            }
                        }
                    } catch (JSONException e10) {
                        p.a(e10, new StringBuilder("Error on getting parent child JSON. Error message = "), "CustomGroupDetails", 6);
                    }
                }
                try {
                    Context context = k0Var.f21771a;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                    if (b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                        hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                        z12 = true;
                    } else {
                        z12 = false;
                        hVar = null;
                    }
                    if ((z12 ? hVar : sharedPreferences).getBoolean("OT_GENERAL_VENDORS_CONFIGURED", false)) {
                        if (z12) {
                            sharedPreferences = hVar;
                        }
                        if (sharedPreferences.getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false)) {
                            if (com.onetrust.otpublishers.headless.Internal.c.q(k0Var.f21776f)) {
                                try {
                                    k0Var.f21776f = k0Var.m();
                                } catch (JSONException unused2) {
                                    OTLogger.a("CustomGroupDetails", 6, "Error on creating valid consent able parent child map.");
                                }
                            }
                            oTVendorUtils.updateVendorConsentStatusBasedOnCategoryStatus(OTVendorListMode.GENERAL, str, k0Var.f21776f, z10, this);
                            return;
                        }
                    }
                    OTLogger.a("GeneralVendors", 5, "Cannot update consent for the Vendor ID:General Vendor data with opt-out not found in template settings");
                    return;
                } catch (JSONException unused3) {
                    OTLogger.a("CustomGroupDetails", 6, "Error on updating general vendor status.");
                    return;
                }
            }
            return;
        }
        updatePurposeConsent(str, z10);
    }

    @Keep
    public void addEventListener(@NonNull OTEventListener oTEventListener) {
        a aVar = this.f22021g;
        aVar.getClass();
        OTLogger.a("EventListenerSetter", 3, "clear OTEventListener.");
        aVar.f21744a.clear();
        a aVar2 = this.f22021g;
        aVar2.getClass();
        if (oTEventListener == null) {
            OTLogger.a("EventListenerSetter", 3, "OtEventListener set with null called.");
            return;
        }
        OTLogger.a("EventListenerSetter", 3, "Add OtEventListener, value = " + oTEventListener);
        aVar2.f21744a.add(oTEventListener);
    }
}

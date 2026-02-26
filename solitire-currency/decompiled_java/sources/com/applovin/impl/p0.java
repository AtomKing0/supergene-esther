package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.p0;
import com.applovin.impl.privacy.consentFlow.TermsAndPrivacyPolicyFlowSettingsImpl;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import io.sentry.protocol.Request;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p0 implements AppLovinCommunicatorSubscriber, AppLovinCommunicatorPublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u0 f6500b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6501a;

        static {
            int[] iArr = new int[AppLovinSdkConfiguration.ConsentFlowUserGeography.values().length];
            f6501a = iArr;
            try {
                iArr[AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6501a[AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6501a[AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AppLovinCmpError f6504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private o0 f6505d;

        public b() {
        }

        protected boolean a(Object obj) {
            return obj instanceof b;
        }

        public void b(boolean z10) {
            this.f6502a = z10;
        }

        public boolean c() {
            return this.f6503b;
        }

        public boolean d() {
            return this.f6502a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.a((Object) this) || d() != bVar.d() || c() != bVar.c()) {
                return false;
            }
            AppLovinCmpError appLovinCmpErrorA = a();
            AppLovinCmpError appLovinCmpErrorA2 = bVar.a();
            if (appLovinCmpErrorA != null ? !appLovinCmpErrorA.equals(appLovinCmpErrorA2) : appLovinCmpErrorA2 != null) {
                return false;
            }
            o0 o0VarB = b();
            o0 o0VarB2 = bVar.b();
            return o0VarB != null ? o0VarB.equals(o0VarB2) : o0VarB2 == null;
        }

        public int hashCode() {
            int i10 = (((d() ? 79 : 97) + 59) * 59) + (c() ? 79 : 97);
            AppLovinCmpError appLovinCmpErrorA = a();
            int iHashCode = (i10 * 59) + (appLovinCmpErrorA == null ? 43 : appLovinCmpErrorA.hashCode());
            o0 o0VarB = b();
            return (iHashCode * 59) + (o0VarB != null ? o0VarB.hashCode() : 43);
        }

        public String toString() {
            return "ConsentFlowManager.FlowCompletionStatus(termsAndPrivacyPolicyAlertShown=" + d() + ", cmpPromptShown=" + c() + ", cmpError=" + a() + ", consentFlowError=" + b() + ")";
        }

        public b(o0 o0Var) {
            this.f6505d = o0Var;
        }

        public void a(AppLovinCmpError appLovinCmpError) {
            this.f6504c = appLovinCmpError;
        }

        public o0 b() {
            return this.f6505d;
        }

        public void a(boolean z10) {
            this.f6503b = z10;
        }

        public void a(o0 o0Var) {
            this.f6505d = o0Var;
        }

        public AppLovinCmpError a() {
            return this.f6504c;
        }
    }

    public interface c {
        void a(b bVar);
    }

    public p0(com.applovin.impl.sdk.j jVar) {
        this.f6499a = jVar;
        this.f6500b = new u0(jVar);
        if (z6.i(com.applovin.impl.sdk.j.n())) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.n()).subscribe(this, "start_sdk_consent_flow");
        }
    }

    public static TermsAndPrivacyPolicyFlowSettingsImpl a(Context context) {
        if (context == null) {
            com.applovin.impl.sdk.n.h("ConsentFlowManager", "Failed to get default Terms and Privacy Policy flow settings.");
            return new TermsAndPrivacyPolicyFlowSettingsImpl(false, false, AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, null, null);
        }
        String strA = z6.a(context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName()), context, (com.applovin.impl.sdk.j) null);
        JSONObject jSONObject = JsonUtils.getJSONObject(StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject(), "consent_flow_settings", new JSONObject());
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = JsonUtils.getBoolean(jSONObject, "consent_flow_enabled", bool);
        Boolean bool3 = JsonUtils.getBoolean(jSONObject, "consent_flow_show_terms_and_privacy_policy_alert_in_gdpr", bool);
        String string = JsonUtils.getString(jSONObject, "consent_flow_debug_user_geography", "");
        String string2 = JsonUtils.getString(jSONObject, "consent_flow_terms_of_service", null);
        Uri uri = URLUtil.isValidUrl(string2) ? Uri.parse(string2) : null;
        String string3 = JsonUtils.getString(jSONObject, "consent_flow_privacy_policy", null);
        return new TermsAndPrivacyPolicyFlowSettingsImpl(bool2.booleanValue(), bool3.booleanValue(), a(string), URLUtil.isValidUrl(string3) ? Uri.parse(string3) : null, uri);
    }

    public JSONObject b() {
        TermsAndPrivacyPolicyFlowSettingsImpl termsAndPrivacyPolicyFlowSettingsImplC = c();
        Uri privacyPolicyUri = termsAndPrivacyPolicyFlowSettingsImplC.getPrivacyPolicyUri();
        Uri termsOfServiceUri = termsAndPrivacyPolicyFlowSettingsImplC.getTermsOfServiceUri();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "enabled", String.valueOf(j()));
        JsonUtils.putString(jSONObject, "privacy_policy_url", privacyPolicyUri != null ? privacyPolicyUri.toString() : "");
        JsonUtils.putString(jSONObject, "terms_of_service_url", termsOfServiceUri != null ? termsOfServiceUri.toString() : "");
        return jSONObject;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "consent_flow_manager";
    }

    public Uri h() {
        return c().getTermsOfServiceUri();
    }

    public boolean i() {
        return this.f6500b.a();
    }

    public boolean j() {
        Map<String, String> extraParameters = this.f6499a.g0().getExtraParameters();
        return extraParameters.containsKey("consent_flow_enabled") ? Boolean.parseBoolean(extraParameters.get("consent_flow_enabled")) : c().isEnabled();
    }

    public boolean k() {
        if (z6.c(this.f6499a)) {
            int i10 = a.f6501a[d().ordinal()];
            if (i10 == 1) {
                return true;
            }
            if (i10 == 2) {
                return false;
            }
        }
        return this.f6499a.t().getConsentFlowUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
    }

    public boolean l() {
        return this.f6499a.g0().getExtraParameters().containsKey("terms_flow_settings");
    }

    public boolean m() {
        return c().shouldShowTermsAndPrivacyPolicyAlertInGdpr();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f6500b.a(this.f6499a.n0(), new c() { // from class: com.applovin.impl.ec
            @Override // com.applovin.impl.p0.c
            public final void a(p0.b bVar) {
                this.f5157a.a(bVar);
            }
        });
    }

    private TermsAndPrivacyPolicyFlowSettingsImpl c() {
        return (TermsAndPrivacyPolicyFlowSettingsImpl) this.f6499a.g0().getTermsAndPrivacyPolicyFlowSettings();
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography d() {
        return c().getDebugUserGeography();
    }

    public String e() {
        Object objF = f();
        Object objH = h();
        StringBuilder sb = new StringBuilder();
        sb.append("\nConsent Flow Enabled - ");
        sb.append(j());
        sb.append("\nTerms of Service - ");
        if (objH == null) {
            objH = "undefined";
        }
        sb.append(objH);
        sb.append("\nPrivacy Policy - ");
        if (objF == null) {
            objF = "undefined";
        }
        sb.append(objF);
        return sb.toString();
    }

    public Uri f() {
        return c().getPrivacyPolicyUri();
    }

    public String g() {
        return "Migrate to the new Terms and Privacy Policy Flow by following these steps:\n\t1. Delete the 'terms_flow_settings' entry from your 'applovin_settings.xml' file.\n\t2. Follow the integration instructions in our documentation: " + a();
    }

    private void b(final Activity activity) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.dc
            @Override // java.lang.Runnable
            public final void run() {
                this.f5047a.a(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Uri uri, DialogInterface dialogInterface, int i10) {
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    public void a(Activity activity, final c cVar) {
        if (!j()) {
            cVar.a(new b(new o0(o0.f6446c, "Failed to start consent flow. Please make sure that the consent flow is enabled.")));
        } else if (c().getPrivacyPolicyUri() == null) {
            b(activity);
        } else {
            this.f6500b.a(activity, new c() { // from class: com.applovin.impl.fc
                @Override // com.applovin.impl.p0.c
                public final void a(p0.b bVar) {
                    this.f5216a.a(cVar, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c cVar, b bVar) {
        if (bVar.f6505d == null) {
            this.f6499a.b(n4.f6393o, Boolean.FALSE);
        }
        cVar.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        if (bVar.f6505d == null) {
            this.f6499a.b(n4.f6393o, Boolean.FALSE);
        }
        AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.n()).getMessagingService().publish(new AppLovinCommunicatorMessage(new Bundle(), "sdk_consent_flow_finished", this));
    }

    private static AppLovinSdkConfiguration.ConsentFlowUserGeography a(String str) {
        if ("gdpr".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
        }
        if (Request.JsonKeys.OTHER.equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER;
        }
        return AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        final Uri uriA = a();
        new AlertDialog.Builder(activity).setTitle("Missing Privacy Policy URL").setMessage("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL").setNeutralButton("Go To Documentation", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.bc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f4921a.a(uriA, dialogInterface, i10);
            }
        }).setNegativeButton("DISMISS", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.cc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                p0.b(uriA, dialogInterface, i10);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Uri uri, DialogInterface dialogInterface, int i10) {
        w6.a(uri, com.applovin.impl.sdk.j.n(), this.f6499a);
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    private Uri a() {
        return Uri.parse((String) this.f6499a.a(this.f6499a.A0() ? l4.f5637f6 : l4.f5629e6));
    }
}

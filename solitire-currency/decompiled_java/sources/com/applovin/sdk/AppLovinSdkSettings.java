package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.p0;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.z6;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinSdkSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8041b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8046g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinTermsAndPrivacyPolicyFlowSettings f8048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private j f8049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8050k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8043d = true;
    private final Map<String, Object> localSettings = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f8047h = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8042c = true;

    AppLovinSdkSettings(Context context) {
        this.f8050k = "";
        if (context == null) {
            n.h("AppLovinSdkSettings", "context cannot be null. Please provide a valid context.");
        }
        Context contextD = z6.d(context);
        this.f8040a = z6.k(contextD);
        this.f8048i = p0.a(contextD);
        this.f8050k = contextD.getPackageName();
        a(contextD);
    }

    private void a(Context context) {
        int identifier = context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName());
        if (identifier == 0) {
            return;
        }
        String strA = z6.a(identifier, context, (j) null);
        this.f8047h.putAll(JsonUtils.tryToStringMap(StringUtils.isValidString(strA) ? JsonUtils.jsonObjectFromJsonString(strA, new JSONObject()) : new JSONObject()));
    }

    public void attachAppLovinSdk(j jVar) {
        this.f8049j = jVar;
        if (StringUtils.isValidString(this.f8044e)) {
            jVar.l0().a(Arrays.asList(this.f8044e.split(",")));
            this.f8044e = null;
        }
        if (this.f8045f != null) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("AppLovinSdkSettings", "Setting user id: " + this.f8045f);
            }
            jVar.p0().a(this.f8045f);
            this.f8045f = null;
        }
        if (StringUtils.isValidString(this.f8046g)) {
            k.a(this.f8046g, jVar);
            this.f8046g = null;
        }
    }

    public Map<String, String> getExtraParameters() {
        Map<String, String> map;
        synchronized (this.f8047h) {
            map = CollectionUtils.map(this.f8047h);
        }
        return map;
    }

    public AppLovinTermsAndPrivacyPolicyFlowSettings getTermsAndPrivacyPolicyFlowSettings() {
        return this.f8048i;
    }

    @Nullable
    public String getUserIdentifier() {
        j jVar = this.f8049j;
        return jVar == null ? this.f8045f : jVar.p0().c();
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.f8042c;
    }

    public boolean isMuted() {
        return this.f8041b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f8040a;
    }

    public void setCreativeDebuggerEnabled(boolean z10) {
        n.e("AppLovinSdkSettings", "setCreativeDebuggerEnabled(creativeDebuggerEnabled=" + z10 + ")");
        if (this.f8042c == z10) {
            return;
        }
        this.f8042c = z10;
        j jVar = this.f8049j;
        if (jVar == null) {
            return;
        }
        if (z10) {
            jVar.w().l();
        } else {
            jVar.w().k();
        }
    }

    public void setExtraParameter(String str, @Nullable String str2) {
        n.e("AppLovinSdkSettings", "setExtraParameter(key=" + str + ", value=" + str2 + ")");
        if (TextUtils.isEmpty(str)) {
            n.h("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
            return;
        }
        String strTrim = str2 != null ? str2.trim() : null;
        if ("test_mode_network".equalsIgnoreCase(str)) {
            if (this.f8049j == null) {
                this.f8044e = strTrim;
            } else if (StringUtils.isValidString(strTrim)) {
                this.f8049j.l0().a(Arrays.asList(strTrim.split(",")));
            } else {
                this.f8049j.l0().a((String) null);
            }
        } else if ("fan".equals(str) || "esc".equals(str)) {
            if (!this.f8050k.startsWith("com.unity.")) {
                return;
            }
        } else if ("disable_all_logs".equals(str)) {
            n.a(Boolean.parseBoolean(strTrim));
        } else if ("package_name_override".equals(str)) {
            j jVar = this.f8049j;
            if (jVar != null) {
                k.a(strTrim, jVar);
            } else {
                this.f8046g = strTrim;
            }
        }
        this.f8047h.put(str, strTrim);
    }

    public void setMuted(boolean z10) {
        n.e("AppLovinSdkSettings", "setMuted(muted=" + z10 + ")");
        this.f8041b = z10;
    }

    public void setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(boolean z10) {
        n.e("AppLovinSdkSettings", "setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(shouldFailAdDisplayIfDontKeepActivitiesIsEnabled=" + z10 + ")");
        this.f8043d = z10;
    }

    public void setUserIdentifier(String str) {
        n.e("AppLovinSdkSettings", "setUserIdentifier(userIdentifier=" + str + ")");
        if (StringUtils.isValidString(str) && str.length() > z6.b(8)) {
            n.h("AppLovinSdk", "Provided user id longer than supported (" + str.length() + " bytes, " + z6.b(8) + " maximum)");
        }
        j jVar = this.f8049j;
        if (jVar == null) {
            this.f8045f = str;
            return;
        }
        jVar.I();
        if (n.a()) {
            this.f8049j.I().a("AppLovinSdkSettings", "Setting user id: " + str);
        }
        this.f8049j.p0().a(str);
    }

    public void setVerboseLogging(boolean z10) {
        n.e("AppLovinSdkSettings", "setVerboseLogging(isVerboseLoggingEnabled=" + z10 + ")");
        if (!z6.k()) {
            this.f8040a = z10;
            return;
        }
        n.h("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
        if (z6.k(null) != z10) {
            n.h("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
        }
    }

    public boolean shouldFailAdDisplayIfDontKeepActivitiesIsEnabled() {
        return this.f8043d;
    }

    @NonNull
    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.f8040a + ", muted=" + this.f8041b + ", creativeDebuggerEnabled=" + this.f8042c + '}';
    }
}

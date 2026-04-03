package com.applovin.impl.sdk.ad;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.applovin.impl.adview.e;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t3;
import com.applovin.impl.v4;
import com.king.amp.sa.AbmAdPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f6934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f6935l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f6936m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final t3 f6937n;

    public a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f6934k = f1();
        this.f6935l = j1();
        this.f6936m = i1();
        this.f6937n = new t3(this);
    }

    public static a a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2;
        if (jSONObject == null || (jSONObject2 = JsonUtils.getJSONObject(jSONObject, "full_response", (JSONObject) null)) == null) {
            return null;
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject2, "ads", new JSONArray()), 0, (JSONObject) null);
        if (jSONObject3 == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject3, AbmAdPlayer.HTML, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String string2 = JsonUtils.getString(jSONObject3, "video", "");
        JsonUtils.putString(jSONObject3, AbmAdPlayer.HTML, JsonUtils.getString(jSONObject, "original_html_source", ""));
        JsonUtils.putString(jSONObject3, "video", JsonUtils.getString(jSONObject, "original_video_uri_string", ""));
        a aVar = new a(jSONObject3, jSONObject2, jVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray, i10, null);
            if (objectAtIndex instanceof String) {
                String str = (String) objectAtIndex;
                if (!TextUtils.isEmpty(str)) {
                    aVar.a(Uri.parse(str));
                }
            }
        }
        aVar.b(string);
        if (StringUtils.isValidString(string2)) {
            aVar.d(Uri.parse(string2));
        }
        return aVar;
    }

    private String i1() {
        return getStringFromAdObject("stream_url", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(v4 v4Var) {
        v4Var.b(AbmAdPlayer.HTML, this.f6934k);
        v4Var.b("stream_url", this.f6936m);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean D0() {
        return getBooleanFromFullResponse("is_persisted_ad", false);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean H0() {
        return containsKeyForAdObject("stream_url");
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void J0() {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.a(new Consumer() { // from class: com.applovin.impl.sdk.ad.d
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    this.f6970a.t((v4) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, AbmAdPlayer.HTML, this.f6934k);
            JsonUtils.putString(this.adObject, "stream_url", this.f6936m);
        }
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String N() {
        return this.f6935l;
    }

    public void b(String str) {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.b(AbmAdPlayer.HTML, str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, AbmAdPlayer.HTML, str);
        }
    }

    public void d(Uri uri) {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.b("video", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "video", uri.toString());
        }
    }

    public String f1() {
        return getStringFromAdObject(AbmAdPlayer.HTML, "");
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri g0() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : j();
    }

    public float g1() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        JSONObject jSONObjectDeepCopy;
        JSONObject jSONObjectA;
        v4 v4Var = this.synchronizedFullResponse;
        if (v4Var != null) {
            jSONObjectA = v4Var.a();
        } else {
            synchronized (this.fullResponseLock) {
                jSONObjectDeepCopy = JsonUtils.deepCopy(this.fullResponse);
            }
            jSONObjectA = jSONObjectDeepCopy;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectA, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, AbmAdPlayer.HTML, this.f6934k);
            JsonUtils.putString(jSONObject, "video", this.f6935l);
            JsonUtils.putString(jSONObject, "stream_url", this.f6936m);
        }
        return jSONObjectA;
    }

    public String h1() {
        return this.f6936m;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        return p0() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public boolean isOpenMeasurementEnabled() {
        if (this.sdk.W().e()) {
            return true;
        }
        return getBooleanFromAdObject("omsdk_enabled", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j() {
        String stringFromAdObject = getStringFromAdObject("click_url", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public String j1() {
        return getStringFromAdObject("video", "");
    }

    public boolean k1() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", Boolean.FALSE);
        }
        return true;
    }

    public void l1() {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.c("stream_url");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri p0() {
        String strI1 = i1();
        if (StringUtils.isValidString(strI1)) {
            return Uri.parse(strI1);
        }
        String strJ1 = j1();
        if (StringUtils.isValidString(strJ1)) {
            return Uri.parse(strJ1);
        }
        return null;
    }

    public e.a e1() {
        return a(getIntFromAdObject("expandable_style", e.a.INVISIBLE.b()));
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public t3 getAdEventTracker() {
        return this.f6937n;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "original_html_source", this.f6934k);
        JsonUtils.putString(jSONObject, "original_video_uri_string", this.f6935l);
        JsonUtils.putString(jSONObject, "original_video_stream_uri_string", this.f6936m);
        ArrayList arrayList = new ArrayList();
        Iterator it = i().iterator();
        while (it.hasNext()) {
            arrayList.add(((Uri) it.next()).toString());
        }
        JsonUtils.putJsonArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray((Collection) arrayList));
        v4 v4Var = this.synchronizedFullResponse;
        if (v4Var != null) {
            JsonUtils.putJSONObject(jSONObject, "full_response", v4Var.a());
        } else {
            synchronized (this.fullResponseLock) {
                JsonUtils.putJSONObject(jSONObject, "full_response", this.fullResponse);
            }
        }
        return jSONObject;
    }
}

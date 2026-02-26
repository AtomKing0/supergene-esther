package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.applovin.impl.a7;
import com.applovin.impl.l4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.a;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v5;
import com.applovin.impl.w4;
import com.applovin.impl.z6;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends w4 implements a.InterfaceC0174a, AppLovinAdLoadListener {
    private final List A;
    private final List B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONObject f7202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f7203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f7204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f7206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f7207l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Double f7208m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f7209n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Uri f7210o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Uri f7211p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a7 f7212q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Uri f7213r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Uri f7214s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Uri f7215t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Uri f7216u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final List f7217v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final List f7218w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List f7219x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f7220y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f7221z;

    public b(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderNativeAd", jVar);
        this.f7205j = "";
        this.f7206k = "";
        this.f7207l = "";
        this.f7208m = null;
        this.f7209n = "";
        this.f7210o = null;
        this.f7211p = null;
        this.f7213r = null;
        this.f7214s = null;
        this.f7215t = null;
        this.f7216u = null;
        this.f7217v = new ArrayList();
        this.f7218w = new ArrayList();
        this.f7219x = new ArrayList();
        this.f7220y = new ArrayList();
        this.f7221z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.f7202g = jSONObject;
        this.f7203h = jSONObject2;
        this.f7204i = appLovinNativeAdLoadListener;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String string = JsonUtils.getString(jSONObject, "url", null);
        if (StringUtils.isValidString(string)) {
            this.f7215t = Uri.parse(string);
            if (n.a()) {
                this.f7679c.a(this.f7678b, "Processed click destination URL: " + this.f7215t);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "fallback", null);
        if (StringUtils.isValidString(string2)) {
            this.f7216u = Uri.parse(string2);
            if (n.a()) {
                this.f7679c.a(this.f7678b, "Processed click destination backup URL: " + this.f7216u);
            }
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", null);
        if (jSONArray != null) {
            if (!JsonUtils.getBoolean(this.f7202g, "use_requests_for_native_ad_click_postbacks", (Boolean) this.f7677a.a(l4.C2)).booleanValue()) {
                try {
                    this.f7217v.addAll(JsonUtils.toList(jSONArray));
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Processed click tracking URLs: " + this.f7217v);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Failed to render click tracking URLs", th);
                        return;
                    }
                    return;
                }
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray, i10, null);
                if (objectAtIndex instanceof String) {
                    String str = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str)) {
                        this.f7219x.add(new e.a(this.f7677a).b(str).b(false).a(false).h(f()).a());
                    }
                }
            }
            if (n.a()) {
                this.f7679c.a(this.f7678b, "Processed click tracking requests: " + this.f7219x);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Preparing native ad view components...");
        }
        try {
            appLovinNativeAdImpl.setUpNativeAdViewComponents();
            if (n.a()) {
                this.f7679c.a(this.f7678b, "Successfully prepared native ad view components");
            }
            appLovinNativeAdImpl.getAdEventTracker().h();
            this.f7204i.onNativeAdLoaded(appLovinNativeAdImpl);
        } catch (Throwable th) {
            if (n.a()) {
                this.f7679c.a(this.f7678b, "Failed to prepare native ad view components", th);
            }
            b(th.getMessage());
            this.f7677a.A().a(this.f7678b, "prepareNativeComponents", th);
        }
    }

    private void c(final AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f7228a.b(appLovinNativeAdImpl);
            }
        });
    }

    private boolean f() {
        return JsonUtils.getBoolean(this.f7202g, "fire_native_ad_postbacks_from_webview", (Boolean) this.f7677a.a(l4.B2)).booleanValue();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        if (n.a()) {
            this.f7679c.a(this.f7678b, "VAST ad rendered successfully");
        }
        this.f7212q = (a7) appLovinAd;
        e();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        if (n.a()) {
            this.f7679c.b(this.f7678b, "VAST ad failed to render");
        }
        e();
    }

    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // java.lang.Runnable
    public void run() {
        ?? r32 = 0;
        String string = JsonUtils.getString(this.f7202g, "privacy_icon_url", null);
        if (URLUtil.isValidUrl(string)) {
            this.f7213r = Uri.parse(string);
        }
        String string2 = JsonUtils.getString(this.f7202g, "privacy_url", null);
        if (URLUtil.isValidUrl(string2)) {
            this.f7214s = Uri.parse(string2);
        }
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f7202g, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            if (n.a()) {
                this.f7679c.b(this.f7678b, "No oRtb response provided: " + this.f7202g);
            }
            b("No oRtb response provided");
            return;
        }
        String string3 = JsonUtils.getString(jSONObject, "version", null);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "value", (JSONObject) null);
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Rendering native ad for oRTB version: " + string3);
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "native", jSONObject2);
        a(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, "assets", null);
        if (jSONArray == null || jSONArray.length() == 0) {
            if (n.a()) {
                this.f7679c.b(this.f7678b, "Unable to retrieve assets - failing ad load: " + this.f7202g);
            }
            b("Unable to retrieve assets");
            return;
        }
        String str = "";
        int i10 = 0;
        while (i10 < jSONArray.length()) {
            JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) r32);
            if (jSONObject4.has("title")) {
                this.f7205j = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "title", (JSONObject) r32), "text", r32);
                if (n.a()) {
                    this.f7679c.a(this.f7678b, "Processed title: " + this.f7205j);
                }
            } else if (jSONObject4.has("link")) {
                a(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r32));
            } else if (jSONObject4.has("img")) {
                int i11 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r32);
                int i12 = JsonUtils.getInt(jSONObject5, "type", -1);
                String string4 = JsonUtils.getString(jSONObject5, "url", r32);
                if (i12 == 1 || 3 == i11) {
                    this.f7210o = Uri.parse(string4);
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Processed icon URL: " + this.f7210o);
                    }
                } else if (i12 == 3 || 2 == i11) {
                    this.f7211p = Uri.parse(string4);
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Processed main image URL: " + this.f7211p);
                    }
                } else {
                    if (n.a()) {
                        this.f7679c.k(this.f7678b, "Unrecognized image: " + jSONObject4);
                    }
                    int i13 = JsonUtils.getInt(jSONObject5, "w", -1);
                    int i14 = JsonUtils.getInt(jSONObject5, CmcdData.Factory.STREAMING_FORMAT_HLS, -1);
                    if (i13 <= 0 || i14 <= 0) {
                        if (n.a()) {
                            this.f7679c.k(this.f7678b, "Skipping...");
                        }
                    } else if (i13 / i14 > 1.0d) {
                        if (n.a()) {
                            this.f7679c.a(this.f7678b, "Inferring main image from " + i13 + ViewHierarchyNode.JsonKeys.X + i14 + "...");
                        }
                        this.f7211p = Uri.parse(string4);
                    } else {
                        if (n.a()) {
                            this.f7679c.a(this.f7678b, "Inferring icon image from " + i13 + ViewHierarchyNode.JsonKeys.X + i14 + "...");
                        }
                        this.f7210o = Uri.parse(string4);
                    }
                }
            } else if (jSONObject4.has("video")) {
                String string5 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "video", (JSONObject) null), "vasttag", null);
                if (StringUtils.isValidString(string5)) {
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Processed VAST video");
                    }
                } else if (n.a()) {
                    this.f7679c.k(this.f7678b, "Ignoring invalid \"vasttag\" for video: " + jSONObject4);
                }
                str = string5;
            } else if (jSONObject4.has("data")) {
                int i15 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                int i16 = JsonUtils.getInt(jSONObject6, "type", -1);
                String string6 = JsonUtils.getString(jSONObject6, "value", null);
                if (i16 == 1 || i15 == 8) {
                    this.f7206k = string6;
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Processed advertiser: " + this.f7206k);
                    }
                } else if (i16 == 2 || i15 == 4) {
                    this.f7207l = string6;
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Processed body: " + this.f7207l);
                    }
                } else if (i16 == 12 || i15 == 5) {
                    this.f7209n = string6;
                    if (n.a()) {
                        this.f7679c.a(this.f7678b, "Processed cta: " + this.f7209n);
                    }
                } else if (i16 == 3 || i15 == 6) {
                    double dA = z6.a(string6, -1.0d);
                    if (dA != -1.0d) {
                        this.f7208m = Double.valueOf(dA);
                        if (n.a()) {
                            this.f7679c.a(this.f7678b, "Processed star rating: " + this.f7208m);
                        }
                    } else if (n.a()) {
                        this.f7679c.a(this.f7678b, "Received invalid star rating: " + string6);
                    }
                } else if (n.a()) {
                    this.f7679c.k(this.f7678b, "Skipping unsupported data: " + jSONObject4);
                }
            } else if (n.a()) {
                this.f7679c.b(this.f7678b, "Unsupported asset object: " + jSONObject4);
            }
            i10++;
            r32 = 0;
        }
        String string7 = JsonUtils.getString(jSONObject3, "jstracker", null);
        if (StringUtils.isValidString(string7)) {
            this.f7218w.add(string7);
            if (n.a()) {
                this.f7679c.a(this.f7678b, "Processed jstracker: " + string7);
            }
        }
        Object obj = null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "imptrackers", null);
        if (jSONArray2 != null) {
            int i17 = 0;
            while (i17 < jSONArray2.length()) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray2, i17, obj);
                if (objectAtIndex instanceof String) {
                    String str2 = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str2)) {
                        this.f7220y.add(new e.a(this.f7677a).b(str2).b(false).a(false).h(f()).a());
                        if (n.a()) {
                            this.f7679c.a(this.f7678b, "Processed imptracker URL: " + str2);
                        }
                    }
                }
                i17++;
                obj = null;
            }
        }
        ?? r33 = 0;
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", null);
        if (jSONArray3 != null) {
            int i18 = 0;
            while (i18 < jSONArray3.length()) {
                JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray3, i18, (JSONObject) r33);
                int i19 = JsonUtils.getInt(jSONObject7, NotificationCompat.CATEGORY_EVENT, -1);
                int i20 = JsonUtils.getInt(jSONObject7, "method", -1);
                String string8 = JsonUtils.getString(jSONObject7, "url", r33);
                if (!TextUtils.isEmpty(string8)) {
                    if (i20 == 1 || i20 == 2) {
                        if (i20 == 2 && string8.startsWith("<script")) {
                            this.f7218w.add(string8);
                        } else {
                            com.applovin.impl.sdk.network.e eVarA = new e.a(this.f7677a).b(string8).b(false).a(false).h(f() || i20 == 2).a();
                            if (i19 == 1) {
                                this.f7220y.add(eVarA);
                                if (n.a()) {
                                    this.f7679c.a(this.f7678b, "Processed impression URL: " + string8);
                                }
                            } else if (i19 == 2) {
                                this.f7221z.add(eVarA);
                                if (n.a()) {
                                    this.f7679c.a(this.f7678b, "Processed viewable MRC50 URL: " + string8);
                                }
                            } else if (i19 == 3) {
                                this.A.add(eVarA);
                                if (n.a()) {
                                    this.f7679c.a(this.f7678b, "Processed viewable MRC100 URL: " + string8);
                                }
                            } else if (i19 == 4) {
                                this.B.add(eVarA);
                                if (n.a()) {
                                    this.f7679c.a(this.f7678b, "Processed viewable video 50 URL: " + string8);
                                }
                            } else if (i19 == 555) {
                                if (n.a()) {
                                    this.f7679c.a(this.f7678b, "Ignoring processing of OMID URL: " + string8);
                                }
                            } else if (n.a()) {
                                this.f7679c.b(this.f7678b, "Unsupported event tracker: " + jSONObject7);
                            }
                        }
                    } else if (n.a()) {
                        this.f7679c.b(this.f7678b, "Unsupported method for event tracker: " + jSONObject7);
                    }
                }
                i18++;
                r33 = 0;
            }
        }
        if (!StringUtils.isValidString(str)) {
            e();
            return;
        }
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Processing VAST video...");
        }
        this.f7677a.j0().a(v5.a(str, JsonUtils.shallowCopy(this.f7202g), JsonUtils.shallowCopy(this.f7203h), this, this.f7677a));
    }

    private void e() {
        AppLovinNativeAdImpl appLovinNativeAdImplBuild = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.f7202g), JsonUtils.shallowCopy(this.f7203h), this.f7677a).setTitle(this.f7205j).setAdvertiser(this.f7206k).setBody(this.f7207l).setCallToAction(this.f7209n).setStarRating(this.f7208m).setIconUri(this.f7210o).setMainImageUri(this.f7211p).setPrivacyIconUri(this.f7213r).setVastAd(this.f7212q).setPrivacyDestinationUri(this.f7214s).setClickDestinationUri(this.f7215t).setClickDestinationBackupUri(this.f7216u).setClickTrackingUrls(this.f7217v).setJsTrackers(this.f7218w).setClickTrackingRequests(this.f7219x).setImpressionRequests(this.f7220y).setViewableMRC50Requests(this.f7221z).setViewableMRC100Requests(this.A).setViewableVideo50Requests(this.B).build();
        appLovinNativeAdImplBuild.getAdEventTracker().e();
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Starting cache task for type: " + appLovinNativeAdImplBuild.getType() + "...");
        }
        this.f7677a.j0().a((w4) new a(appLovinNativeAdImplBuild, this.f7677a, this), r5.b.CORE);
    }

    private void b(String str) {
        this.f7204i.onNativeAdLoadFailed(new AppLovinError(-6, str));
    }

    @Override // com.applovin.impl.sdk.nativeAd.a.InterfaceC0174a
    public void a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (n.a()) {
            this.f7679c.a(this.f7678b, "Successfully cached and loaded ad");
        }
        c(appLovinNativeAdImpl);
    }
}

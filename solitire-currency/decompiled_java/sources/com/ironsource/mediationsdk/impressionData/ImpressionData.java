package com.ironsource.mediationsdk.impressionData;

import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import java.text.DecimalFormat;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionData {
    public static final String IMPRESSION_DATA_KEY_ABTEST = "ab";
    public static final String IMPRESSION_DATA_KEY_AD_FORMAT = "adFormat";
    public static final String IMPRESSION_DATA_KEY_AD_NETWORK = "adNetwork";
    public static final String IMPRESSION_DATA_KEY_AD_UNIT = "adUnit";
    public static final String IMPRESSION_DATA_KEY_AUCTION_ID = "auctionId";
    public static final String IMPRESSION_DATA_KEY_COUNTRY = "country";
    public static final String IMPRESSION_DATA_KEY_ENCRYPTED_CPM = "encryptedCPM";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_ID = "instanceId";
    public static final String IMPRESSION_DATA_KEY_INSTANCE_NAME = "instanceName";
    public static final String IMPRESSION_DATA_KEY_LIFETIME_REVENUE = "lifetimeRevenue";
    public static final String IMPRESSION_DATA_KEY_MEDIATION_AD_UNIT_ID = "mediationAdUnitId";
    public static final String IMPRESSION_DATA_KEY_MEDIATION_AD_UNIT_NAME = "mediationAdUnitName";
    public static final String IMPRESSION_DATA_KEY_PLACEMENT = "placement";
    public static final String IMPRESSION_DATA_KEY_PRECISION = "precision";
    public static final String IMPRESSION_DATA_KEY_REVENUE = "revenue";
    public static final String IMPRESSION_DATA_KEY_SEGMENT_NAME = "segmentName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f13609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f13617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f13618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f13619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f13620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f13621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Double f13622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f13623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Double f13624p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f13625q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DecimalFormat f13626r = new DecimalFormat("#.#####");

    public ImpressionData(@NotNull ImpressionData impressionData) {
        this.f13610b = null;
        this.f13611c = null;
        this.f13612d = null;
        this.f13613e = null;
        this.f13614f = null;
        this.f13615g = null;
        this.f13616h = null;
        this.f13617i = null;
        this.f13618j = null;
        this.f13619k = null;
        this.f13620l = null;
        this.f13621m = null;
        this.f13622n = null;
        this.f13623o = null;
        this.f13624p = null;
        this.f13625q = null;
        this.f13609a = impressionData.f13609a;
        this.f13610b = impressionData.f13610b;
        this.f13611c = impressionData.f13611c;
        this.f13612d = impressionData.f13612d;
        this.f13613e = impressionData.f13613e;
        this.f13614f = impressionData.f13614f;
        this.f13615g = impressionData.f13615g;
        this.f13616h = impressionData.f13616h;
        this.f13617i = impressionData.f13617i;
        this.f13618j = impressionData.f13618j;
        this.f13619k = impressionData.f13619k;
        this.f13620l = impressionData.f13620l;
        this.f13621m = impressionData.f13621m;
        this.f13623o = impressionData.f13623o;
        this.f13625q = impressionData.f13625q;
        this.f13624p = impressionData.f13624p;
        this.f13622n = impressionData.f13622n;
    }

    public String getAb() {
        return this.f13616h;
    }

    public String getAdFormat() {
        return this.f13614f;
    }

    public String getAdNetwork() {
        return this.f13619k;
    }

    @Deprecated
    public String getAdUnit() {
        return this.f13611c;
    }

    public JSONObject getAllData() {
        return this.f13609a;
    }

    public String getAuctionId() {
        return this.f13610b;
    }

    public String getCountry() {
        return this.f13615g;
    }

    public String getEncryptedCPM() {
        return this.f13625q;
    }

    public String getInstanceId() {
        return this.f13621m;
    }

    public String getInstanceName() {
        return this.f13620l;
    }

    @Deprecated
    public Double getLifetimeRevenue() {
        return this.f13624p;
    }

    public String getMediationAdUnitId() {
        return this.f13613e;
    }

    public String getMediationAdUnitName() {
        return this.f13612d;
    }

    public String getPlacement() {
        return this.f13618j;
    }

    public String getPrecision() {
        return this.f13623o;
    }

    public Double getRevenue() {
        return this.f13622n;
    }

    public String getSegmentName() {
        return this.f13617i;
    }

    public void replaceMacroForPlacementWithValue(String str, String str2) {
        String str3 = this.f13618j;
        if (str3 != null) {
            String strReplace = str3.replace(str, str2);
            this.f13618j = strReplace;
            JSONObject jSONObject = this.f13609a;
            if (jSONObject != null) {
                try {
                    jSONObject.put("placement", strReplace);
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("auctionId: '");
        sb.append(this.f13610b);
        sb.append('\'');
        sb.append(", adUnit: '");
        sb.append(this.f13611c);
        sb.append('\'');
        sb.append(", mediationAdUnitName: '");
        sb.append(this.f13612d);
        sb.append('\'');
        sb.append(", mediationAdUnitId: '");
        sb.append(this.f13613e);
        sb.append('\'');
        sb.append(", adFormat: '");
        sb.append(this.f13614f);
        sb.append('\'');
        sb.append(", country: '");
        sb.append(this.f13615g);
        sb.append('\'');
        sb.append(", ab: '");
        sb.append(this.f13616h);
        sb.append('\'');
        sb.append(", segmentName: '");
        sb.append(this.f13617i);
        sb.append('\'');
        sb.append(", placement: '");
        sb.append(this.f13618j);
        sb.append('\'');
        sb.append(", adNetwork: '");
        sb.append(this.f13619k);
        sb.append('\'');
        sb.append(", instanceName: '");
        sb.append(this.f13620l);
        sb.append('\'');
        sb.append(", instanceId: '");
        sb.append(this.f13621m);
        sb.append('\'');
        sb.append(", revenue: ");
        Double d10 = this.f13622n;
        sb.append(d10 == null ? null : this.f13626r.format(d10));
        sb.append(", precision: '");
        sb.append(this.f13623o);
        sb.append('\'');
        sb.append(", lifetimeRevenue: ");
        Double d11 = this.f13624p;
        sb.append(d11 != null ? this.f13626r.format(d11) : null);
        sb.append(", encryptedCPM: '");
        sb.append(this.f13625q);
        sb.append('\'');
        return sb.toString();
    }

    public ImpressionData(JSONObject jSONObject) {
        Double dValueOf = null;
        this.f13610b = null;
        this.f13611c = null;
        this.f13612d = null;
        this.f13613e = null;
        this.f13614f = null;
        this.f13615g = null;
        this.f13616h = null;
        this.f13617i = null;
        this.f13618j = null;
        this.f13619k = null;
        this.f13620l = null;
        this.f13621m = null;
        this.f13622n = null;
        this.f13623o = null;
        this.f13624p = null;
        this.f13625q = null;
        if (jSONObject != null) {
            try {
                this.f13609a = jSONObject;
                this.f13610b = jSONObject.optString("auctionId", null);
                this.f13611c = jSONObject.optString("adUnit", null);
                this.f13612d = jSONObject.optString(IMPRESSION_DATA_KEY_MEDIATION_AD_UNIT_NAME, null);
                this.f13613e = jSONObject.optString("mediationAdUnitId", null);
                this.f13614f = jSONObject.optString(IMPRESSION_DATA_KEY_AD_FORMAT, null);
                this.f13615g = jSONObject.optString(IMPRESSION_DATA_KEY_COUNTRY, null);
                this.f13616h = jSONObject.optString(IMPRESSION_DATA_KEY_ABTEST, null);
                this.f13617i = jSONObject.optString(IMPRESSION_DATA_KEY_SEGMENT_NAME, null);
                this.f13618j = jSONObject.optString("placement", null);
                this.f13619k = jSONObject.optString(IMPRESSION_DATA_KEY_AD_NETWORK, null);
                this.f13620l = jSONObject.optString("instanceName", null);
                this.f13621m = jSONObject.optString("instanceId", null);
                this.f13623o = jSONObject.optString(IMPRESSION_DATA_KEY_PRECISION, null);
                this.f13625q = jSONObject.optString(IMPRESSION_DATA_KEY_ENCRYPTED_CPM, null);
                double dOptDouble = jSONObject.optDouble(IMPRESSION_DATA_KEY_LIFETIME_REVENUE);
                this.f13624p = Double.isNaN(dOptDouble) ? null : Double.valueOf(dOptDouble);
                double dOptDouble2 = jSONObject.optDouble(IMPRESSION_DATA_KEY_REVENUE);
                if (!Double.isNaN(dOptDouble2)) {
                    dValueOf = Double.valueOf(dOptDouble2);
                }
                this.f13622n = dValueOf;
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error("error parsing impression " + e10.getMessage());
            }
        }
    }
}

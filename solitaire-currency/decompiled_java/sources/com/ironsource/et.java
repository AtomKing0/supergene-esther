package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class et {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final et f11994a = new et();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f11995b = ",";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f11996c = "[";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final String f11997d = "]";

    private et() {
    }

    @NotNull
    public final AdInfo a(@NotNull LevelPlayAdInfo levelPlayAdInfo) throws JSONException {
        kotlin.jvm.internal.t.i(levelPlayAdInfo, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("auctionId", levelPlayAdInfo.getAuctionId());
        jSONObject.put("adUnit", levelPlayAdInfo.getAdFormat());
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_COUNTRY, levelPlayAdInfo.getCountry());
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_ABTEST, levelPlayAdInfo.getAb());
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_SEGMENT_NAME, levelPlayAdInfo.getSegmentName());
        jSONObject.put("placement", levelPlayAdInfo.getPlacementName());
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK, levelPlayAdInfo.getAdNetwork());
        jSONObject.put("instanceName", levelPlayAdInfo.getInstanceName());
        jSONObject.put("instanceId", levelPlayAdInfo.getInstanceId());
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_PRECISION, levelPlayAdInfo.getPrecision());
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_ENCRYPTED_CPM, levelPlayAdInfo.getEncryptedCPM());
        jSONObject.put(ImpressionData.IMPRESSION_DATA_KEY_REVENUE, levelPlayAdInfo.getRevenue());
        return new AdInfo(new ImpressionData(jSONObject));
    }

    @NotNull
    public final String b(@NotNull List<? extends Object> methodArgs) {
        kotlin.jvm.internal.t.i(methodArgs, "methodArgs");
        String str = new String();
        for (Object obj : methodArgs) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(obj instanceof List ? f11994a.a((List<?>) obj) : f11994a.a(obj));
            str = sb.toString() + ',';
        }
        return p9.r.w0(str, f11995b);
    }

    @NotNull
    public final IronSourceError a(@NotNull LevelPlayAdError levelPlayAdError) {
        kotlin.jvm.internal.t.i(levelPlayAdError, "<this>");
        return new IronSourceError(levelPlayAdError.getErrorCode(), levelPlayAdError.getErrorMessage());
    }

    private final String a(Object obj) {
        if (!(obj instanceof String)) {
            return String.valueOf(obj);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('\'');
        sb.append(obj);
        sb.append('\'');
        return sb.toString();
    }

    private final String a(List<?> list) {
        Iterator<T> it = list.iterator();
        String str = "[";
        while (it.hasNext()) {
            str = str + f11994a.a(it.next()) + ',';
        }
        return p9.r.w0(str, f11995b) + ']';
    }

    @NotNull
    public final List<Object> a(@NotNull Object... items) {
        kotlin.jvm.internal.t.i(items, "items");
        return kotlin.collections.v.n(Arrays.copyOf(items, items.length));
    }
}

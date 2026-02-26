package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    public SkuDetails(@NonNull String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString(InAppPurchaseMetaData.KEY_PRODUCT_ID))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
        }
        return false;
    }

    @NonNull
    public String getDescription() {
        return this.zzb.optString("description");
    }

    @NonNull
    public String getFreeTrialPeriod() {
        return this.zzb.optString("freeTrialPeriod");
    }

    @NonNull
    public String getIconUrl() {
        return this.zzb.optString("iconUrl");
    }

    @NonNull
    public String getIntroductoryPrice() {
        return this.zzb.optString("introductoryPrice");
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong("introductoryPriceAmountMicros");
    }

    public int getIntroductoryPriceCycles() {
        return this.zzb.optInt("introductoryPriceCycles");
    }

    @NonNull
    public String getIntroductoryPricePeriod() {
        return this.zzb.optString("introductoryPricePeriod");
    }

    @NonNull
    public String getOriginalJson() {
        return this.zza;
    }

    @NonNull
    public String getOriginalPrice() {
        return this.zzb.has("original_price") ? this.zzb.optString("original_price") : getPrice();
    }

    public long getOriginalPriceAmountMicros() {
        return this.zzb.has("original_price_micros") ? this.zzb.optLong("original_price_micros") : getPriceAmountMicros();
    }

    @NonNull
    public String getPrice() {
        return this.zzb.optString("price");
    }

    public long getPriceAmountMicros() {
        return this.zzb.optLong("price_amount_micros");
    }

    @NonNull
    public String getPriceCurrencyCode() {
        return this.zzb.optString("price_currency_code");
    }

    @NonNull
    public String getSku() {
        return this.zzb.optString(InAppPurchaseMetaData.KEY_PRODUCT_ID);
    }

    @NonNull
    public String getSubscriptionPeriod() {
        return this.zzb.optString("subscriptionPeriod");
    }

    @NonNull
    public String getTitle() {
        return this.zzb.optString("title");
    }

    @NonNull
    public String getType() {
        return this.zzb.optString("type");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @NonNull
    public String toString() {
        return "SkuDetails: ".concat(String.valueOf(this.zza));
    }

    public int zza() {
        return this.zzb.optInt("offer_type");
    }

    @NonNull
    public String zzb() {
        return this.zzb.optString("offer_id");
    }

    @NonNull
    public String zzc() {
        String strOptString = this.zzb.optString("offerIdToken");
        return strOptString.isEmpty() ? this.zzb.optString("offer_id_token") : strOptString;
    }

    @NonNull
    public final String zzd() {
        return this.zzb.optString(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME);
    }

    @NonNull
    public String zze() {
        return this.zzb.optString("serializedDocid");
    }

    final String zzf() {
        return this.zzb.optString("skuDetailsToken");
    }
}

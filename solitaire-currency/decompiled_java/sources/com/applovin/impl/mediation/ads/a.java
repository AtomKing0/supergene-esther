package com.applovin.impl.mediation.ads;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.applovin.impl.n2;
import com.applovin.impl.q2;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    protected final MaxAdFormat adFormat;
    protected MaxAdListener adListener;

    @Nullable
    protected MaxAdReviewListener adReviewListener;
    protected final String adUnitId;

    @Nullable
    protected MaxAdExpirationListener expirationListener;
    protected final com.applovin.impl.sdk.n logger;

    @Nullable
    protected MaxAdRequestListener requestListener;

    @Nullable
    protected MaxAdRevenueListener revenueListener;
    protected final com.applovin.impl.sdk.j sdk;
    protected final String tag;
    protected final Map<String, Object> localExtraParameters = Collections.synchronizedMap(new HashMap());
    protected final Map<String, Object> extraParameters = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.applovin.impl.mediation.ads.a$a, reason: collision with other inner class name */
    public interface InterfaceC0165a extends MaxAdListener, MaxAdRevenueListener, MaxAdRequestListener {
    }

    protected a(String str, MaxAdFormat maxAdFormat, String str2, com.applovin.impl.sdk.j jVar) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = jVar;
        this.tag = str2;
        this.logger = jVar.I();
    }

    void a(q2 q2Var) {
        n2 n2Var = new n2();
        n2Var.a().a("MAX Ad").a(q2Var).a();
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, n2Var.toString());
        }
    }

    protected void destroy() {
        this.localExtraParameters.clear();
        this.adListener = null;
        this.revenueListener = null;
        this.requestListener = null;
        this.expirationListener = null;
        this.adReviewListener = null;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void logApiCall(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, str);
        }
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting Ad Review creative id listener: " + maxAdReviewListener);
        }
        this.adReviewListener = maxAdReviewListener;
    }

    public void setExpirationListener(@Nullable MaxAdExpirationListener maxAdExpirationListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting expiration listener: " + maxAdExpirationListener);
        }
        this.expirationListener = maxAdExpirationListener;
    }

    public void setExtraParameter(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        if (z6.c(this.sdk) && ("amazon_ad_response".equals(str) || "amazon_ad_error".equals(str))) {
            throw new IllegalArgumentException("`setExtraParameter()` is an incorrect method for passing `amazon_ad_response` or `amazon_ad_error`. Please use the following method: `setLocalExtraParameter()`. Also note that this exception occurs in development builds only.");
        }
        if (this.adFormat.isAdViewAd() && "ad_refresh_seconds".equals(str) && StringUtils.isValidString(str2)) {
            int i10 = Integer.parseInt(str2);
            if (i10 > TimeUnit.MINUTES.toSeconds(2L)) {
                com.applovin.impl.sdk.n.h(this.tag, "Attempting to set extra parameter \"ad_refresh_seconds\" to over 2 minutes (" + i10 + "s) - this will be ignored");
            }
        }
        this.extraParameters.put(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting listener: " + maxAdListener);
        }
        this.adListener = maxAdListener;
    }

    public void setLocalExtraParameter(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        if (obj instanceof Activity) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Ignoring setting local extra parameter to Activity instance - please pass a WeakReference of it instead!");
            }
        } else {
            if ("amazon_ad_response".equals(str) || "amazon_ad_error".equals(str)) {
                setExtraParameter("is_amazon_integration", Boolean.toString(true));
            }
            this.localExtraParameters.put(str, obj);
        }
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting request listener: " + maxAdRequestListener);
        }
        this.requestListener = maxAdRequestListener;
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting revenue listener: " + maxAdRevenueListener);
        }
        this.revenueListener = maxAdRevenueListener;
    }

    public static void logApiCall(String str, String str2) {
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f7084v0;
        if (jVar == null) {
            return;
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.j.f7084v0.I().a(str, str2);
        }
    }
}

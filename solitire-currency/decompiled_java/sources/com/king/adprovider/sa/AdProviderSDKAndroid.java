package com.king.adprovider.sa;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.king.amp.sa.AbmAdProviderAdapter;
import com.king.amp.sa.AbmAdProviderAdapterListener;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.BidderTokenListener;
import com.king.amp.sa.Logging;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AdProviderSDKAndroid implements AbmAdProviderAdapterListener {
    private final String LOG_TAG;
    private long mAdProviderAddress;
    private AbmAdProviderAdapter mImpl;
    private boolean mIsInitialized = false;
    private String mProviderClassName;

    class a implements BidderTokenListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f16506a;

        a(int i10) {
            this.f16506a = i10;
        }

        @Override // com.king.amp.sa.BidderTokenListener
        public void onBidderTokenCollected(@NonNull String str) {
            Log.d(AdProviderSDKAndroid.this.LOG_TAG, "AdProviderSDKAndroid: collectBidderToken " + this.f16506a + " collected");
            AdProviderSDKAndroid.collectBidderTokenJNI(AdProviderSDKAndroid.this.mAdProviderAddress, this.f16506a, str, null);
        }

        @Override // com.king.amp.sa.BidderTokenListener
        public void onBidderTokenCollectionFailed(@NonNull String str) {
            Log.w(AdProviderSDKAndroid.this.LOG_TAG, "AdProviderSDKAndroid: collectBidderToken " + this.f16506a + " error " + str);
            AdProviderSDKAndroid.collectBidderTokenJNI(AdProviderSDKAndroid.this.mAdProviderAddress, this.f16506a, null, str);
        }
    }

    public AdProviderSDKAndroid(String str, String str2, Activity activity) {
        this.LOG_TAG = "ads_provider_" + str;
        this.mProviderClassName = str2;
        try {
            AbmAdProviderAdapter abmAdProviderAdapter = (AbmAdProviderAdapter) AbmAdProviderAdapter.class.cast(Class.forName(str2).getConstructor(new Class[0]).newInstance(new Object[0]));
            this.mImpl = abmAdProviderAdapter;
            abmAdProviderAdapter.setLogTag(str);
            this.mImpl.setActivity(activity);
            this.mImpl.setListener(this);
        } catch (Exception e10) {
            Log.i(this.LOG_TAG, "AbmAdProviderSDK: the provider adapter is not available : " + e10);
        }
    }

    public static native void collectBidderTokenJNI(long j10, int i10, @Nullable String str, @Nullable String str2);

    public static native void onSDKInitializedJNI(long j10, boolean z10, String str);

    public void collectBidderToken(int i10) {
        Log.d(this.LOG_TAG, "AdProviderSDKAndroid: collectBidderToken " + i10);
        AbmAdProviderAdapter abmAdProviderAdapter = this.mImpl;
        if (abmAdProviderAdapter == null) {
            collectBidderTokenJNI(this.mAdProviderAddress, i10, null, "Cannot get bidder token, null impl");
            return;
        }
        try {
            abmAdProviderAdapter.collectBidderToken(new a(i10));
        } catch (Exception e10) {
            collectBidderTokenJNI(this.mAdProviderAddress, i10, null, String.format(Locale.ROOT, "Exception occurred trying to collect bidder token: %s", e10.toString()));
        }
    }

    public void destroy() {
        this.mImpl = null;
        this.mAdProviderAddress = 0L;
    }

    public String getVersion() {
        AbmAdProviderAdapter abmAdProviderAdapter = this.mImpl;
        return abmAdProviderAdapter != null ? abmAdProviderAdapter.getProviderVersion() : "";
    }

    public void init(long j10, String[] strArr) {
        this.mAdProviderAddress = j10;
        Log.d(this.LOG_TAG, "AdProviderSDKAndroid: init " + Arrays.toString(strArr));
        if (this.mImpl == null) {
            onSDKInitFailed("AdProviderSDKAndroid: null Impl!");
            return;
        }
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        int i10 = 0;
        while (i10 < strArr.length) {
            String str = strArr[i10];
            int i11 = i10 + 1;
            adProviderNameValuePairs.add(str, strArr[i11]);
            i10 = i11 + 1;
        }
        this.mImpl.initSDK(adProviderNameValuePairs);
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapterListener
    public void logBreadcrumb(String str, String str2) {
        Logging.logBreadcrumb(str, str2);
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapterListener
    public void onSDKInitFailed(String str) {
        long j10 = this.mAdProviderAddress;
        if (j10 != 0) {
            this.mIsInitialized = false;
            onSDKInitializedJNI(j10, false, str);
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapterListener
    public void onSDKInitSucceeded() {
        long j10 = this.mAdProviderAddress;
        if (j10 != 0) {
            this.mIsInitialized = true;
            onSDKInitializedJNI(j10, true, "");
        }
    }

    @Override // com.king.amp.sa.AbmAdProviderAdapterListener
    public void onSDKInitialized(boolean z10, String str) {
        long j10 = this.mAdProviderAddress;
        if (j10 != 0) {
            this.mIsInitialized = z10;
            onSDKInitializedJNI(j10, z10, str);
        }
    }

    public void updateConsent(boolean z10) {
        AbmAdProviderAdapter abmAdProviderAdapter = this.mImpl;
        if (abmAdProviderAdapter != null) {
            abmAdProviderAdapter.updateConsent(z10);
        }
    }
}

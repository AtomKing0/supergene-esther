package com.king.unity;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.c3;
import com.ironsource.v8;
import com.king.amp.sa.AbmAdProviderRewardAd;
import com.king.amp.sa.AdProviderNameValuePairs;
import com.king.amp.sa.o;
import com.king.amp.sa.p;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class AbmAdProviderRewardAdUnityRV implements AbmAdProviderRewardAd {
    private String LOG_TAG;
    private Activity mActivity;
    private p mListener;
    private String mObjectId;
    private HashMap<String, String> mObjectIdMap = new HashMap<>();
    private String mPlacementId;

    class a implements IUnityAdsLoadListener {
        a() {
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsAdLoaded(String str) {
            if (str.equals(AbmAdProviderRewardAdUnityRV.this.mPlacementId)) {
                synchronized (this) {
                    AbmAdProviderRewardAdUnityRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdUnityRV.this.LOG_TAG, "Internal Unity RV - onUnityAdsAdLoaded to onAdLoaded " + AbmAdProviderRewardAdUnityRV.this.mPlacementId);
                    AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
                    adProviderNameValuePairs.add(v8.f15659j, str);
                    AbmAdProviderRewardAdUnityRV.this.mListener.onAdLoaded(adProviderNameValuePairs);
                }
            }
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
            AbmAdProviderRewardAdUnityRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdUnityRV.this.LOG_TAG, "Internal Unity RV - onUnityAdsFailedToLoad to onLoadFailed " + AbmAdProviderRewardAdUnityRV.this.mPlacementId);
            AbmAdProviderRewardAdUnityRV.this.mListener.onLoadFailed(AbmAdProviderRewardAdUnityRV.getMediationErrorCode(unityAdsLoadError), str2);
        }
    }

    class b implements IUnityAdsShowListener {
        b() {
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowClick(String str) {
            AbmAdProviderRewardAdUnityRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdUnityRV.this.LOG_TAG, "External Unity RV IUnityAdsShowListener - onUnityAdsShowClick " + AbmAdProviderRewardAdUnityRV.this.mPlacementId);
            AbmAdProviderRewardAdUnityRV.this.mListener.onEndCardInfoClicked();
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.COMPLETED) {
                AbmAdProviderRewardAdUnityRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdUnityRV.this.LOG_TAG, "External Unity RV IUnityAdsShowListener - onUnityAdsShowComplete " + AbmAdProviderRewardAdUnityRV.this.mPlacementId);
                AbmAdProviderRewardAdUnityRV.this.mListener.onPlayCompleted();
                AbmAdProviderRewardAdUnityRV.this.mListener.onClosed(true);
                return;
            }
            if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.SKIPPED) {
                AbmAdProviderRewardAdUnityRV.this.mListener.onClosed(false);
                return;
            }
            Log.e(AbmAdProviderRewardAdUnityRV.this.LOG_TAG, "Unhandled UnityAdsShowCompletionState: " + unityAdsShowCompletionState.toString() + "placementID" + AbmAdProviderRewardAdUnityRV.this.mPlacementId);
            AbmAdProviderRewardAdUnityRV.this.mListener.onClosed(false);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            AbmAdProviderRewardAdUnityRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdUnityRV.this.LOG_TAG, "External Unity RV IUnityAdsShowListener - onUnityAdsShowFailure " + AbmAdProviderRewardAdUnityRV.this.mPlacementId);
            AbmAdProviderRewardAdUnityRV.this.mListener.onShowFailed(AbmAdProviderRewardAdUnityRV.getMediationErrorCode(unityAdsShowError), str2);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowStart(String str) {
            AbmAdProviderRewardAdUnityRV.this.mListener.logBreadcrumb(AbmAdProviderRewardAdUnityRV.this.LOG_TAG, "External Unity RV IUnityAdsShowListener - onUnityAdsShowStart " + AbmAdProviderRewardAdUnityRV.this.mPlacementId);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f17167b;

        static {
            int[] iArr = new int[UnityAds.UnityAdsShowError.values().length];
            f17167b = iArr;
            try {
                iArr[UnityAds.UnityAdsShowError.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17167b[UnityAds.UnityAdsShowError.NOT_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17167b[UnityAds.UnityAdsShowError.VIDEO_PLAYER_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17167b[UnityAds.UnityAdsShowError.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17167b[UnityAds.UnityAdsShowError.NO_CONNECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17167b[UnityAds.UnityAdsShowError.ALREADY_SHOWING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17167b[UnityAds.UnityAdsShowError.INTERNAL_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[UnityAds.UnityAdsLoadError.values().length];
            f17166a = iArr2;
            try {
                iArr2[UnityAds.UnityAdsLoadError.INITIALIZE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17166a[UnityAds.UnityAdsLoadError.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17166a[UnityAds.UnityAdsLoadError.INVALID_ARGUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17166a[UnityAds.UnityAdsLoadError.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17166a[UnityAds.UnityAdsLoadError.TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static int getMediationErrorCode(@NonNull UnityAds.UnityAdsLoadError unityAdsLoadError) {
        int i10 = c.f17166a[unityAdsLoadError.ordinal()];
        if (i10 == 1) {
            return 401;
        }
        if (i10 == 2) {
            return TypedValues.CycleType.TYPE_VISIBILITY;
        }
        if (i10 == 3) {
            return 403;
        }
        if (i10 == 4) {
            return c3.a.b.f11495d;
        }
        if (i10 != 5) {
            return 400;
        }
        return c3.a.b.f11496e;
    }

    public void destroy() {
        this.mListener = null;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public /* synthetic */ String getProperty(String str) {
        return o.a(this, str);
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void load(AdProviderNameValuePairs adProviderNameValuePairs) {
        String str = "";
        this.mPlacementId = (String) adProviderNameValuePairs.getValue("adUnitId", "");
        Object value = adProviderNameValuePairs.getValue("targetingKeyValues");
        if (value != null) {
            this.mListener.logBreadcrumb(this.LOG_TAG, "fetch payload from config");
            String[] strArr = (String[]) value;
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= strArr.length) {
                    break;
                }
                if (strArr[i10].equals("unity_bid_payload")) {
                    str = strArr[i11];
                    break;
                }
                i10 += 2;
            }
        }
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String string = UUID.randomUUID().toString();
        this.mObjectId = string;
        this.mObjectIdMap.put(string, this.mPlacementId);
        unityAdsLoadOptions.setAdMarkup(str);
        unityAdsLoadOptions.setObjectId(this.mObjectId);
        UnityAds.load(this.mPlacementId, unityAdsLoadOptions, new a());
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setListener(p pVar) {
        this.mListener = pVar;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void setLogTag(String str) {
        this.LOG_TAG = "ads_provider_" + str;
    }

    @Override // com.king.amp.sa.AbmAdProviderRewardAd
    public void show() {
        UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
        unityAdsShowOptions.setObjectId(this.mObjectId);
        UnityAds.show(this.mActivity, this.mPlacementId, unityAdsShowOptions, new b());
    }

    static int getMediationErrorCode(@NonNull UnityAds.UnityAdsShowError unityAdsShowError) {
        switch (c.f17167b[unityAdsShowError.ordinal()]) {
            case 1:
                return 501;
            case 2:
                return 502;
            case 3:
                return TypedValues.PositionType.TYPE_PERCENT_WIDTH;
            case 4:
                return TypedValues.PositionType.TYPE_PERCENT_HEIGHT;
            case 5:
                return 505;
            case 6:
                return 506;
            case 7:
                return TypedValues.PositionType.TYPE_PERCENT_Y;
            default:
                return 500;
        }
    }
}

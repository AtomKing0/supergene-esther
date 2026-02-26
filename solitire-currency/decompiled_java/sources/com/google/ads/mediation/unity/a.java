package com.google.ads.mediation.unity;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import com.ironsource.c3;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.UnityBannerSize;
import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: compiled from: UnityAdsAdapterUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.google.ads.mediation.unity.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UnityAdsAdapterUtils.java */
    static /* synthetic */ class C0188a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f8353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f8354d;

        static {
            int[] iArr = new int[UnityAds.UnityAdsShowError.values().length];
            f8354d = iArr;
            try {
                iArr[UnityAds.UnityAdsShowError.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8354d[UnityAds.UnityAdsShowError.NOT_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8354d[UnityAds.UnityAdsShowError.VIDEO_PLAYER_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8354d[UnityAds.UnityAdsShowError.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8354d[UnityAds.UnityAdsShowError.NO_CONNECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8354d[UnityAds.UnityAdsShowError.ALREADY_SHOWING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8354d[UnityAds.UnityAdsShowError.INTERNAL_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[UnityAds.UnityAdsLoadError.values().length];
            f8353c = iArr2;
            try {
                iArr2[UnityAds.UnityAdsLoadError.INITIALIZE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8353c[UnityAds.UnityAdsLoadError.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8353c[UnityAds.UnityAdsLoadError.INVALID_ARGUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8353c[UnityAds.UnityAdsLoadError.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8353c[UnityAds.UnityAdsLoadError.TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[UnityAds.UnityAdsInitializationError.values().length];
            f8352b = iArr3;
            try {
                iArr3[UnityAds.UnityAdsInitializationError.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8352b[UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8352b[UnityAds.UnityAdsInitializationError.AD_BLOCKER_DETECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr4 = new int[BannerErrorCode.values().length];
            f8351a = iArr4;
            try {
                iArr4[BannerErrorCode.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8351a[BannerErrorCode.NATIVE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f8351a[BannerErrorCode.WEBVIEW_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f8351a[BannerErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* JADX INFO: compiled from: UnityAdsAdapterUtils.java */
    public enum b {
        LOADED,
        OPENED,
        CLICKED,
        CLOSED,
        LEFT_APPLICATION,
        IMPRESSION,
        VIDEO_START,
        REWARD,
        VIDEO_COMPLETE
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    @NonNull
    static AdError b(int i10, @NonNull String str) {
        return new AdError(i10, str, "com.unity3d.ads");
    }

    @NonNull
    static AdError c(@NonNull UnityAds.UnityAdsInitializationError unityAdsInitializationError, @NonNull String str) {
        return b(f(unityAdsInitializationError), str);
    }

    @NonNull
    static AdError d(@NonNull UnityAds.UnityAdsLoadError unityAdsLoadError, @NonNull String str) {
        return b(g(unityAdsLoadError), str);
    }

    @NonNull
    static AdError e(@NonNull UnityAds.UnityAdsShowError unityAdsShowError, @NonNull String str) {
        return b(h(unityAdsShowError), str);
    }

    static int f(@NonNull UnityAds.UnityAdsInitializationError unityAdsInitializationError) {
        int i10 = C0188a.f8352b[unityAdsInitializationError.ordinal()];
        if (i10 == 1) {
            return 301;
        }
        if (i10 == 2) {
            return 302;
        }
        if (i10 != 3) {
            return AnimationConstants.DefaultDurationMillis;
        }
        return 303;
    }

    static int g(@NonNull UnityAds.UnityAdsLoadError unityAdsLoadError) {
        int i10 = C0188a.f8353c[unityAdsLoadError.ordinal()];
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

    static int h(@NonNull UnityAds.UnityAdsShowError unityAdsShowError) {
        switch (C0188a.f8354d[unityAdsShowError.ordinal()]) {
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

    static int i(@NonNull BannerErrorInfo bannerErrorInfo) {
        int i10 = C0188a.f8351a[bannerErrorInfo.errorCode.ordinal()];
        if (i10 == 1) {
            return 201;
        }
        if (i10 == 2) {
            return 202;
        }
        if (i10 != 3) {
            return i10 != 4 ? 200 : 204;
        }
        return 203;
    }

    @Nullable
    public static UnityBannerSize j(@NonNull Context context, @NonNull AdSize adSize) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AdSize.BANNER);
        arrayList.add(AdSize.LEADERBOARD);
        AdSize adSizeFindClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (adSizeFindClosestSize != null) {
            return new UnityBannerSize(adSizeFindClosestSize.getWidth(), adSizeFindClosestSize.getHeight());
        }
        return null;
    }

    public static void k(int i10, @NonNull Context context) throws JSONException {
        MetaData metaData = new MetaData(context);
        if (i10 == 0) {
            metaData.set("user.nonbehavioral", Boolean.FALSE);
        } else {
            metaData.set("user.nonbehavioral", Boolean.TRUE);
        }
        metaData.commit();
    }
}

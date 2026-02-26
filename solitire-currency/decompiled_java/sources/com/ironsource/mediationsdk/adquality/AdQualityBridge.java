package com.ironsource.mediationsdk.adquality;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.datasource.cache.ContentMetadata;
import com.ironsource.adqualitysdk.sdk.ISAdQualityConfig;
import com.ironsource.adqualitysdk.sdk.ISAdQualityDeviceIdType;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitError;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener;
import com.ironsource.adqualitysdk.sdk.ISAdQualityLogLevel;
import com.ironsource.adqualitysdk.sdk.ISAdQualitySegment;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.e1;
import com.ironsource.i9;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.rp;
import com.ironsource.xc;
import com.ironsource.yc;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p9.f;
import p9.q;
import p9.r;

/* JADX INFO: loaded from: classes4.dex */
public final class AdQualityBridge {

    @NotNull
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAdQualitySdkVersion() {
            if (!isGetVersionMethodExist()) {
                return new String();
            }
            String sDKVersion = IronSourceAdQuality.getSDKVersion();
            t.h(sDKVersion, "getSDKVersion()");
            return sDKVersion;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isGetVersionMethodExist() throws JSONException {
            try {
                return Class.forName("com.ironsource.adqualitysdk.sdk.IronSourceAdQuality").getDeclaredMethods().length >= 10;
            } catch (Throwable th) {
                i9.d().a(th);
                logEvent$default(this, 84, null, null, 6, null);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logEvent(int i10, Integer num, String str) throws JSONException {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
            if (num != null) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, num.intValue());
            }
            if (str != null) {
                mediationAdditionalData.put("reason", str);
            }
            rp.i().a(new kb(i10, mediationAdditionalData));
        }

        static /* synthetic */ void logEvent$default(Companion companion, int i10, Integer num, String str, int i11, Object obj) throws JSONException {
            if ((i11 & 2) != 0) {
                num = null;
            }
            if ((i11 & 4) != 0) {
                str = null;
            }
            companion.logEvent(i10, num, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int versionCompare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return -1;
            }
            int i10 = 0;
            String[] strArr = (String[]) r.C0(new f("[^0-9.]").b(str, ""), new String[]{"."}, false, 0, 6, null).toArray(new String[0]);
            String[] strArr2 = (String[]) r.C0(new f("[^0-9.]").b(str2, ""), new String[]{"."}, false, 0, 6, null).toArray(new String[0]);
            while (i10 < strArr.length && i10 < strArr2.length && t.d(strArr[i10], strArr2[i10])) {
                i10++;
            }
            if (i10 >= strArr.length || i10 >= strArr2.length) {
                return Integer.signum(strArr.length - strArr2.length);
            }
            int iIntValue = Integer.valueOf(strArr[i10]).intValue();
            Integer numValueOf = Integer.valueOf(strArr2[i10]);
            t.h(numValueOf, "valueOf(vals2[i])");
            return Integer.signum(t.k(iIntValue, numValueOf.intValue()));
        }

        public final boolean adQualityAvailable() {
            return versionCompare(getAdQualitySdkVersion(), "7.9.0") >= 0;
        }
    }

    public AdQualityBridge(@NotNull Context context, @NotNull String appKey, @Nullable String str, @NotNull e1 adQualityDataProvider, int i10) throws JSONException {
        t.i(context, "context");
        t.i(appKey, "appKey");
        t.i(adQualityDataProvider, "adQualityDataProvider");
        ISAdQualityConfig.Builder deviceIdType = new ISAdQualityConfig.Builder().setInitializationSource("LevelPlay").setLogLevel(convertToAdQualityLogLevel(i10)).setAdQualityInitListener(new ISAdQualityInitListener() { // from class: com.ironsource.mediationsdk.adquality.AdQualityBridge$configBuilder$1
            public void adQualitySdkInitFailed(@NotNull ISAdQualityInitError isAdQualityInitError, @NotNull String message) throws JSONException {
                t.i(isAdQualityInitError, "isAdQualityInitError");
                t.i(message, "message");
                AdQualityBridge.Companion.logEvent(isAdQualityInitError == ISAdQualityInitError.AD_QUALITY_ALREADY_INITIALIZED ? 82 : 83, Integer.valueOf(isAdQualityInitError.getValue()), message);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Ad Quality failed to initialize: " + message, 3);
            }

            public void adQualitySdkInitSuccess() throws JSONException {
                AdQualityBridge.Companion.logEvent$default(AdQualityBridge.Companion, 81, null, null, 6, null);
            }
        }).setCoppa(getCoppaValue()).setDeviceIdType(getDeviceIdType());
        if (!TextUtils.isEmpty(str)) {
            deviceIdType.setUserId(str);
        }
        Companion companion = Companion;
        if (companion.versionCompare(companion.getAdQualitySdkVersion(), "7.14.1") >= 0) {
            JSONObject jSONObjectA = adQualityDataProvider.a();
            if (jSONObjectA.length() > 0) {
                deviceIdType.setMetaData(jSONObjectA);
            }
        }
        Companion.logEvent$default(companion, 80, null, null, 6, null);
        IronSourceAdQuality.getInstance().initialize(context, appKey, deviceIdType.build());
    }

    public static final boolean adQualityAvailable() {
        return Companion.adQualityAvailable();
    }

    private final ISAdQualityLogLevel convertToAdQualityLogLevel(int i10) {
        return i10 != 0 ? i10 != 2 ? i10 != 3 ? ISAdQualityLogLevel.INFO : ISAdQualityLogLevel.ERROR : ISAdQualityLogLevel.WARNING : ISAdQualityLogLevel.VERBOSE;
    }

    private static final String getAdQualitySdkVersion() {
        return Companion.getAdQualitySdkVersion();
    }

    private final boolean getCoppaValue() {
        String strA = xc.a().a("is_coppa");
        return strA != null && Boolean.parseBoolean(strA);
    }

    private final ISAdQualityDeviceIdType getDeviceIdType() {
        return !TextUtils.isEmpty(xc.a().a(yc.N)) ? ISAdQualityDeviceIdType.NONE : ISAdQualityDeviceIdType.GAID;
    }

    private static final boolean isGetVersionMethodExist() {
        return Companion.isGetVersionMethodExist();
    }

    private static final void logEvent(int i10, Integer num, String str) throws JSONException {
        Companion.logEvent(i10, num, str);
    }

    private static final int versionCompare(String str, String str2) {
        return Companion.versionCompare(str, str2);
    }

    public final void changeUserId(@NotNull String userId) {
        t.i(userId, "userId");
        IronSourceAdQuality.getInstance().changeUserId(userId);
    }

    public final void setSegment(@NotNull IronSourceSegment segment) {
        t.i(segment, "segment");
        ISAdQualitySegment.Builder builder = new ISAdQualitySegment.Builder();
        if (segment.getSegmentName() != null) {
            builder.setSegmentName(segment.getSegmentName());
        }
        if (segment.getAge() > -1) {
            builder.setAge(segment.getAge());
        }
        if (segment.getGender() != null) {
            builder.setGender(segment.getGender());
        }
        if (segment.getLevel() > -1) {
            builder.setLevel(segment.getLevel());
        }
        if (segment.getIsPaying() != null) {
            builder.setIsPaying(segment.getIsPaying().get());
        }
        if (segment.getIapt() > -1.0d) {
            builder.setInAppPurchasesTotal(segment.getIapt());
        }
        if (segment.getUcd() > 0) {
            builder.setUserCreationDate(segment.getUcd());
        }
        for (Pair<String, String> pair : segment.getSegmentData()) {
            String key = (String) pair.first;
            String str = (String) pair.second;
            t.h(key, "key");
            if (q.K(key, ContentMetadata.KEY_CUSTOM_PREFIX, false, 2, null)) {
                builder.setCustomData(r.v0(key, ContentMetadata.KEY_CUSTOM_PREFIX), str);
            }
        }
        IronSourceAdQuality.getInstance().setSegment(builder.build());
    }
}

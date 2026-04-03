package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.m7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IronSource.AD_UNIT, m1> f12902a = new HashMap();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12904b;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            f12904b = iArr;
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12904b[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12904b[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12904b[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[IronSource.AD_UNIT.values().length];
            f12903a = iArr2;
            try {
                iArr2[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12903a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12903a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12903a[IronSource.AD_UNIT.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IronSource.AD_UNIT f12905a;

        public b(IronSource.AD_UNIT ad_unit) {
            this.f12905a = ad_unit;
        }

        private String b() {
            IronSource.AD_UNIT ad_unit = this.f12905a;
            return ad_unit != null ? ad_unit.name() : "";
        }

        public String a() {
            return a(null);
        }

        public String a(String str) {
            return a(str, null);
        }

        public String a(String str, String str2) {
            String str3;
            StringBuilder sb = new StringBuilder();
            sb.append(b());
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = " - " + str2;
            }
            sb.append(str3);
            String string = sb.toString();
            if (TextUtils.isEmpty(str)) {
                return string;
            }
            return string + " - " + str;
        }
    }

    public static k2 a(s1 s1Var, int i10) {
        return a(s1Var).a(s1Var.b().b(), s1Var.n(), i10);
    }

    public static int b(IronSource.AD_UNIT ad_unit) {
        int i10 = a.f12903a[ad_unit.ordinal()];
        return (i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? m7.e.NOT_SUPPORTED : m7.e.BANNER : m7.e.NATIVE_AD : m7.e.INTERSTITIAL : m7.e.REWARDED_VIDEO).a();
    }

    public static b a(IronSource.AD_UNIT ad_unit) {
        return new b(ad_unit);
    }

    private static m1 a(s1 s1Var) {
        Map<IronSource.AD_UNIT, m1> map = f12902a;
        if (map.containsKey(s1Var.b().a())) {
            return map.get(s1Var.b().a());
        }
        m1 m1Var = new m1();
        map.put(s1Var.b().a(), m1Var);
        return m1Var;
    }

    public static IronSourceSegment a() {
        return com.ironsource.mediationsdk.p.m().t();
    }

    public static String a(LevelPlay.AdFormat adFormat) {
        int i10 = a.f12904b[adFormat.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "" : kq.f12892i : "banner" : "interstitial" : "rewarded";
    }

    public static void a(int i10, JSONObject jSONObject) {
        rp.i().a(new kb(i10, hj.a(IronSourceUtils.getMediationAdditionalData(false), jSONObject)));
    }

    public static void a(Throwable th) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "SafeRunnable", th);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", th.getMessage());
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        a(IronSourceConstants.TROUBLESHOOTING_SDK_INTERNAL_ERROR, jSONObject);
    }

    public static boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }
}

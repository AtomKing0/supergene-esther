package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.BasePlacement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.qe;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class fo implements qe, qe.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f12147a = "CappingManager.IS_DELIVERY_ENABLED";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12148b = "CappingManager.IS_CAPPING_ENABLED";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12149c = "CappingManager.IS_PACING_ENABLED";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12150d = "CappingManager.MAX_NUMBER_OF_SHOWS";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12151e = "CappingManager.CAPPING_TYPE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f12152f = "CappingManager.SECONDS_BETWEEN_SHOWS";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12153g = "CappingManager.CURRENT_NUMBER_OF_SHOWS";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f12154h = "CappingManager.CAPPING_TIME_THRESHOLD";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f12155i = "CappingManager.TIME_OF_THE_PREVIOUS_SHOW";

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12156a;

        static {
            int[] iArr = new int[go.values().length];
            f12156a = iArr;
            try {
                iArr[go.PER_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12156a[go.PER_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    private long a(go goVar) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i10 = a.f12156a[goVar.ordinal()];
        if (i10 == 1) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        } else if (i10 == 2) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    private b b(Context context, String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, f12147a, str2), true)) {
            return b.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, f12149c, str2), false)) {
            if (jCurrentTimeMillis - IronSourceUtils.getLongFromSharedPrefs(context, a(str, f12155i, str2), 0L) < IronSourceUtils.getIntFromSharedPrefs(context, a(str, f12152f, str2), 0) * 1000) {
                return b.CAPPED_PER_PACE;
            }
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, f12148b, str2), false)) {
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a(str, f12150d, str2), 0);
            String strA = a(str, f12153g, str2);
            int intFromSharedPrefs2 = IronSourceUtils.getIntFromSharedPrefs(context, strA, 0);
            String strA2 = a(str, f12154h, str2);
            if (jCurrentTimeMillis >= IronSourceUtils.getLongFromSharedPrefs(context, strA2, 0L)) {
                IronSourceUtils.saveIntToSharedPrefs(context, strA, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, strA2, 0L);
            } else if (intFromSharedPrefs2 >= intFromSharedPrefs) {
                return b.CAPPED_PER_COUNT;
            }
        }
        return b.NOT_CAPPED;
    }

    @Override // com.ironsource.qe.a
    public synchronized void c(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        if (context == null || basePlacement == null) {
            return;
        }
        co placementAvailabilitySettings = basePlacement.getPlacementAvailabilitySettings();
        if (placementAvailabilitySettings == null) {
            return;
        }
        a(context, a(ad_unit), basePlacement.getPlacementName(), placementAvailabilitySettings);
    }

    @Override // com.ironsource.qe
    public synchronized b a(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        if (context == null) {
            return b.NOT_CAPPED;
        }
        if (basePlacement == null) {
            return b.NOT_CAPPED;
        }
        String strA = a(ad_unit);
        if (basePlacement.getPlacementName() == null) {
            return b.NOT_CAPPED;
        }
        if (basePlacement.getPlacementAvailabilitySettings() == null) {
            return b.NOT_CAPPED;
        }
        return b(context, strA, basePlacement.getPlacementName());
    }

    @Override // com.ironsource.qe
    public synchronized boolean b(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit) {
        return a(context, basePlacement, ad_unit) != b.NOT_CAPPED;
    }

    private String a(IronSource.AD_UNIT ad_unit) {
        return ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO ? IronSourceConstants.REWARDED_VIDEO_AD_UNIT : ad_unit == IronSource.AD_UNIT.INTERSTITIAL ? "Interstitial" : ad_unit == IronSource.AD_UNIT.BANNER ? "Banner" : ad_unit == IronSource.AD_UNIT.NATIVE_AD ? IronSourceConstants.NATIVE_AD_UNIT : ad_unit.toString();
    }

    private String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    @Override // com.ironsource.qe.a
    public synchronized void a(Context context, String str, IronSource.AD_UNIT ad_unit) {
        if (context == null) {
            return;
        }
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, a(ad_unit), str);
    }

    private void a(Context context, String str, String str2) {
        go goVar;
        int i10 = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, f12149c, str2), false)) {
            IronSourceUtils.saveLongToSharedPrefs(context, a(str, f12155i, str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, f12148b, str2), false)) {
            String strA = a(str, f12153g, str2);
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, strA, 0);
            if (intFromSharedPrefs == 0) {
                String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(context, a(str, f12151e, str2), go.PER_DAY.toString());
                go[] goVarArrValues = go.values();
                int length = goVarArrValues.length;
                while (true) {
                    if (i10 >= length) {
                        goVar = null;
                        break;
                    }
                    goVar = goVarArrValues[i10];
                    if (goVar.f12323a.equals(stringFromSharedPrefs)) {
                        break;
                    } else {
                        i10++;
                    }
                }
                IronSourceUtils.saveLongToSharedPrefs(context, a(str, f12154h, str2), a(goVar));
            }
            IronSourceUtils.saveIntToSharedPrefs(context, strA, intFromSharedPrefs + 1);
        }
    }

    private void a(Context context, String str, String str2, co coVar) {
        boolean zE = coVar.e();
        IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, f12147a, str2), zE);
        if (zE) {
            boolean zD = coVar.d();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, f12148b, str2), zD);
            if (zD) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, f12150d, str2), coVar.b());
                IronSourceUtils.saveStringToSharedPrefs(context, a(str, f12151e, str2), coVar.a().toString());
            }
            boolean zF = coVar.f();
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, f12149c, str2), zF);
            if (zF) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, f12152f, str2), coVar.c());
            }
        }
    }
}

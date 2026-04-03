package com.ironsource;

import com.ironsource.cr;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.ironsourceads.IronSourceAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class dh {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11832a;

        static {
            int[] iArr = new int[IronSourceAds.AdFormat.values().length];
            try {
                iArr[IronSourceAds.AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSourceAds.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSourceAds.AdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11832a = iArr;
        }
    }

    @NotNull
    public final IronSourceError a(@NotNull dq error) {
        kotlin.jvm.internal.t.i(error, "error");
        return (error.c() == 2070 || error.c() == 2110) ? hb.f12462a.b() : (error.c() == 2080 || error.c() == 2100) ? hb.f12462a.c() : error.c() == 2090 ? hb.f12462a.a() : new IronSourceError(510, error.d());
    }

    public final void b(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        ve.f15889a.a(callback);
    }

    public final void a(long j10, @NotNull cr.a responseOrigin) {
        kotlin.jvm.internal.t.i(responseOrigin, "responseOrigin");
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(true);
        try {
            mediationAdditionalData.put("isMultipleAdObjects", 1);
            mediationAdditionalData.put("duration", j10);
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, responseOrigin.a());
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        rp.i().a(new kb(IronSourceConstants.SDK_INIT_SUCCESS, mediationAdditionalData));
    }

    public final void a(@NotNull dq error, long j10) {
        kotlin.jvm.internal.t.i(error, "error");
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(true);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, error.c());
            mediationAdditionalData.put("reason", error.d());
            mediationAdditionalData.put("duration", j10);
            mediationAdditionalData.put("isMultipleAdObjects", 1);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        rp.i().a(new kb(IronSourceConstants.SDK_INIT_FAILED, mediationAdditionalData));
    }

    public final void a(@NotNull Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        ve.a(ve.f15889a, runnable, 0L, 2, null);
    }

    @NotNull
    public final IronSource.AD_UNIT[] a(@NotNull List<? extends IronSourceAds.AdFormat> adFormats) {
        IronSource.AD_UNIT ad_unit;
        kotlin.jvm.internal.t.i(adFormats, "adFormats");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = adFormats.iterator();
        while (it.hasNext()) {
            int i10 = a.f11832a[((IronSourceAds.AdFormat) it.next()).ordinal()];
            if (i10 == 1) {
                ad_unit = IronSource.AD_UNIT.BANNER;
            } else if (i10 == 2) {
                ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
            } else if (i10 == 3) {
                ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
            }
            arrayList.add(ad_unit);
        }
        return (IronSource.AD_UNIT[]) arrayList.toArray(new IronSource.AD_UNIT[0]);
    }
}

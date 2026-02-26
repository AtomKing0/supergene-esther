package r1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.ironsource.IronSourceMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IronSourceAdapterUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static AdError a(int i10, @NonNull String str) {
        return new AdError(i10, str, IronSourceMediationAdapter.ADAPTER_ERROR_DOMAIN);
    }

    public static AdError b(int i10, @NonNull String str) {
        return new AdError(i10, str, IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
    }

    public static <T> boolean c(@NonNull String str, @NonNull ConcurrentHashMap<String, WeakReference<T>> concurrentHashMap) {
        WeakReference<T> weakReference = concurrentHashMap.get(str);
        return weakReference == null || weakReference.get() == null;
    }

    public static String d() {
        return "8.4.0.0";
    }

    @Nullable
    public static ISBannerSize e(@NonNull Context context, @NonNull AdSize adSize) {
        ArrayList arrayList = new ArrayList();
        AdSize adSize2 = AdSize.BANNER;
        arrayList.add(adSize2);
        AdSize adSize3 = AdSize.MEDIUM_RECTANGLE;
        arrayList.add(adSize3);
        AdSize adSize4 = AdSize.LARGE_BANNER;
        arrayList.add(adSize4);
        AdSize adSizeFindClosestSize = MediationUtils.findClosestSize(context, adSize, arrayList);
        if (adSizeFindClosestSize == null) {
            return null;
        }
        return adSize2.equals(adSizeFindClosestSize) ? ISBannerSize.BANNER : adSize3.equals(adSizeFindClosestSize) ? ISBannerSize.RECTANGLE : adSize4.equals(adSizeFindClosestSize) ? ISBannerSize.LARGE : new ISBannerSize(adSizeFindClosestSize.getWidth(), adSizeFindClosestSize.getHeight());
    }

    public static AdError f(@NonNull Context context, @NonNull String str) {
        if (!(context instanceof Activity)) {
            return new AdError(102, "IronSource requires an Activity context to load ads.", IronSourceMediationAdapter.ADAPTER_ERROR_DOMAIN);
        }
        if (TextUtils.isEmpty(str)) {
            return new AdError(101, "Missing or invalid instance ID.", IronSourceMediationAdapter.ADAPTER_ERROR_DOMAIN);
        }
        return null;
    }
}

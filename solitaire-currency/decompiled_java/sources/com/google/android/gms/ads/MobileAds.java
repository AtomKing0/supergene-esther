package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbte;
import com.google.android.gms.internal.ads.zzbym;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class MobileAds {

    @NonNull
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(@NonNull Context context) {
        zzej.zzf().zzl(context);
    }

    @Nullable
    public static InitializationStatus getInitializationStatus() {
        return zzej.zzf().zze();
    }

    @KeepForSdk
    private static String getInternalVersion() {
        return zzej.zzf().zzh();
    }

    @NonNull
    public static RequestConfiguration getRequestConfiguration() {
        return zzej.zzf().zzc();
    }

    @NonNull
    public static VersionInfo getVersion() {
        zzej.zzf();
        String[] strArrSplit = TextUtils.split("23.3.0", "\\.");
        if (strArrSplit.length != 3) {
            return new VersionInfo(0, 0, 0);
        }
        try {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        } catch (NumberFormatException unused) {
            return new VersionInfo(0, 0, 0);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(@NonNull Context context) {
        zzej.zzf().zzm(context, null, null);
    }

    public static void openAdInspector(@NonNull Context context, @NonNull OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzej.zzf().zzp(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(@NonNull Context context, @NonNull String str) {
        zzej.zzf().zzq(context, str);
    }

    public static boolean putPublisherFirstPartyIdEnabled(boolean z10) {
        return zzej.zzf().zzx(z10);
    }

    @Nullable
    public static CustomTabsSession registerCustomTabsSession(@NonNull Context context, @NonNull CustomTabsClient customTabsClient, @NonNull String str, @Nullable CustomTabsCallback customTabsCallback) {
        zzej.zzf();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbym zzbymVarZza = zzbte.zza(context);
        if (zzbymVarZza == null) {
            zzm.zzg("Internal error, query info generator is null.");
            return null;
        }
        try {
            return (CustomTabsSession) ObjectWrapper.unwrap(zzbymVarZza.zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(customTabsClient), str, ObjectWrapper.wrap(customTabsCallback)));
        } catch (RemoteException | IllegalArgumentException e10) {
            zzm.zzh("Unable to register custom tabs session. Error: ", e10);
            return null;
        }
    }

    @KeepForSdk
    public static void registerRtbAdapter(@NonNull Class<? extends RtbAdapter> cls) {
        zzej.zzf().zzr(cls);
    }

    public static void registerWebView(@NonNull WebView webView) {
        zzej.zzf();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (webView == null) {
            zzm.zzg("The webview to be registered cannot be null.");
            return;
        }
        zzbym zzbymVarZza = zzbte.zza(webView.getContext());
        if (zzbymVarZza == null) {
            zzm.zzg("Internal error, query info generator is null.");
            return;
        }
        try {
            zzbymVarZza.zzj(ObjectWrapper.wrap(webView));
        } catch (RemoteException e10) {
            zzm.zzh("", e10);
        }
    }

    public static void setAppMuted(boolean z10) {
        zzej.zzf().zzs(z10);
    }

    public static void setAppVolume(float f10) {
        zzej.zzf().zzt(f10);
    }

    @KeepForSdk
    private static void setPlugin(String str) {
        zzej.zzf().zzu(str);
    }

    public static void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        zzej.zzf().zzv(requestConfiguration);
    }

    public static void initialize(@NonNull Context context, @NonNull OnInitializationCompleteListener onInitializationCompleteListener) {
        zzej.zzf().zzm(context, null, onInitializationCompleteListener);
    }
}

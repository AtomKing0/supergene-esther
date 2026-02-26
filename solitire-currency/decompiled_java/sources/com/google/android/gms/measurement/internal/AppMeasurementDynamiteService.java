package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzqv;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import io.sentry.protocol.App;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzdg {

    @VisibleForTesting
    zzho zza = null;

    @GuardedBy("listenerMap")
    private final Map<Integer, zzix> zzb = new ArrayMap();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
    class zza implements zziu {
        private com.google.android.gms.internal.measurement.zzdj zza;

        zza(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
            this.zza = zzdjVar;
        }

        @Override // com.google.android.gms.measurement.internal.zziu
        public final void interceptEvent(String str, String str2, Bundle bundle, long j10) {
            try {
                this.zza.zza(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                zzho zzhoVar = AppMeasurementDynamiteService.this.zza;
                if (zzhoVar != null) {
                    zzhoVar.zzj().zzu().zza("Event interceptor threw exception", e10);
                }
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
    class zzb implements zzix {
        private com.google.android.gms.internal.measurement.zzdj zza;

        zzb(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
            this.zza = zzdjVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzix
        public final void onEvent(String str, String str2, Bundle bundle, long j10) {
            try {
                this.zza.zza(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                zzho zzhoVar = AppMeasurementDynamiteService.this.zza;
                if (zzhoVar != null) {
                    zzhoVar.zzj().zzu().zza("Event listener threw exception", e10);
                }
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void beginAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        zza();
        this.zza.zze().zza(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void clearMeasurementEnabled(long j10) throws RemoteException {
        zza();
        this.zza.zzp().zza((Boolean) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void endAdUnitExposure(@NonNull String str, long j10) throws RemoteException {
        zza();
        this.zza.zze().zzb(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void generateEventId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        long jZzm = this.zza.zzt().zzm();
        zza();
        this.zza.zzt().zza(zzdiVar, jZzm);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzh(this, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzae());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzk(this, zzdiVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzaf());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzag());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zza(zzdiVar, this.zza.zzp().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzp();
        Preconditions.checkNotEmpty(str);
        zza();
        this.zza.zzt().zza(zzdiVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getSessionId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        zziy zziyVarZzp = this.zza.zzp();
        zziyVarZzp.zzl().zzb(new zzka(zziyVarZzp, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getTestFlag(com.google.android.gms.internal.measurement.zzdi zzdiVar, int i10) throws RemoteException {
        zza();
        if (i10 == 0) {
            this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzai());
            return;
        }
        if (i10 == 1) {
            this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzad().longValue());
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzac().intValue());
                return;
            } else {
                if (i10 != 4) {
                    return;
                }
                this.zza.zzt().zza(zzdiVar, this.zza.zzp().zzaa().booleanValue());
                return;
            }
        }
        zznt zzntVarZzt = this.zza.zzt();
        double dDoubleValue = this.zza.zzp().zzab().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, dDoubleValue);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            zzntVarZzt.zzu.zzj().zzu().zza("Error returning double value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getUserProperties(String str, String str2, boolean z10, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzi(this, zzdiVar, str, str2, z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void initForTests(@NonNull Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j10) throws RemoteException {
        zzho zzhoVar = this.zza;
        if (zzhoVar == null) {
            this.zza = zzho.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdqVar, Long.valueOf(j10));
        } else {
            zzhoVar.zzj().zzu().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws RemoteException {
        zza();
        this.zza.zzl().zzb(new zzm(this, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z10, boolean z11, long j10) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, bundle, z10, z11, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) throws RemoteException {
        zza();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", App.TYPE);
        this.zza.zzl().zzb(new zzj(this, zzdiVar, new zzbf(str2, new zzba(bundle), App.TYPE, j10), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logHealthData(int i10, @NonNull String str, @NonNull IObjectWrapper iObjectWrapper, @NonNull IObjectWrapper iObjectWrapper2, @NonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        this.zza.zzj().zza(i10, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityCreated(@NonNull IObjectWrapper iObjectWrapper, @NonNull Bundle bundle, long j10) throws RemoteException {
        zza();
        zzkl zzklVar = this.zza.zzp().zza;
        if (zzklVar != null) {
            this.zza.zzp().zzak();
            zzklVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityDestroyed(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zza();
        zzkl zzklVar = this.zza.zzp().zza;
        if (zzklVar != null) {
            this.zza.zzp().zzak();
            zzklVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityPaused(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zza();
        zzkl zzklVar = this.zza.zzp().zza;
        if (zzklVar != null) {
            this.zza.zzp().zzak();
            zzklVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityResumed(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zza();
        zzkl zzklVar = this.zza.zzp().zza;
        if (zzklVar != null) {
            this.zza.zzp().zzak();
            zzklVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) throws RemoteException {
        zza();
        zzkl zzklVar = this.zza.zzp().zza;
        Bundle bundle = new Bundle();
        if (zzklVar != null) {
            this.zza.zzp().zzak();
            zzklVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zza.zzj().zzu().zza("Error returning bundle value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityStarted(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zza();
        zzkl zzklVar = this.zza.zzp().zza;
        if (zzklVar != null) {
            this.zza.zzp().zzak();
            zzklVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityStopped(@NonNull IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        zza();
        zzkl zzklVar = this.zza.zzp().zza;
        if (zzklVar != null) {
            this.zza.zzp().zzak();
            zzklVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) throws RemoteException {
        zza();
        zzdiVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws RemoteException {
        zzix zzbVar;
        zza();
        synchronized (this.zzb) {
            zzbVar = this.zzb.get(Integer.valueOf(zzdjVar.zza()));
            if (zzbVar == null) {
                zzbVar = new zzb(zzdjVar);
                this.zzb.put(Integer.valueOf(zzdjVar.zza()), zzbVar);
            }
        }
        this.zza.zzp().zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void resetAnalyticsData(long j10) throws RemoteException {
        zza();
        zziy zziyVarZzp = this.zza.zzp();
        zziyVarZzp.zza((String) null);
        zziyVarZzp.zzl().zzb(new zzjx(zziyVarZzp, j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j10) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.zza.zzp().zza(bundle, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConsent(@NonNull final Bundle bundle, final long j10) throws RemoteException {
        zza();
        final zziy zziyVarZzp = this.zza.zzp();
        zziyVarZzp.zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzje
            @Override // java.lang.Runnable
            public final void run() {
                zziy zziyVar = zziyVarZzp;
                Bundle bundle2 = bundle;
                long j11 = j10;
                if (TextUtils.isEmpty(zziyVar.zzg().zzae())) {
                    zziyVar.zza(bundle2, 0, j11);
                } else {
                    zziyVar.zzj().zzv().zza("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConsentThirdParty(@NonNull Bundle bundle, long j10) throws RemoteException {
        zza();
        this.zza.zzp().zza(bundle, -20, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setCurrentScreen(@NonNull IObjectWrapper iObjectWrapper, @NonNull String str, @NonNull String str2, long j10) throws RemoteException {
        zza();
        this.zza.zzq().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setDataCollectionEnabled(boolean z10) throws RemoteException {
        zza();
        zziy zziyVarZzp = this.zza.zzp();
        zziyVarZzp.zzu();
        zziyVarZzp.zzl().zzb(new zzjm(zziyVarZzp, z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        zza();
        final zziy zziyVarZzp = this.zza.zzp();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zziyVarZzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjf
            @Override // java.lang.Runnable
            public final void run() {
                zziyVarZzp.zza(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws RemoteException {
        zza();
        zza zzaVar = new zza(zzdjVar);
        if (this.zza.zzl().zzg()) {
            this.zza.zzp().zza(zzaVar);
        } else {
            this.zza.zzl().zzb(new zzl(this, zzaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdo zzdoVar) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setMeasurementEnabled(boolean z10, long j10) throws RemoteException {
        zza();
        this.zza.zzp().zza(Boolean.valueOf(z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setMinimumSessionDuration(long j10) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setSessionTimeoutDuration(long j10) throws RemoteException {
        zza();
        zziy zziyVarZzp = this.zza.zzp();
        zziyVarZzp.zzl().zzb(new zzjo(zziyVarZzp, j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        zza();
        zziy zziyVarZzp = this.zza.zzp();
        if (zzqv.zza() && zziyVarZzp.zze().zzf(null, zzbh.zzbu)) {
            Uri data = intent.getData();
            if (data == null) {
                zziyVarZzp.zzj().zzn().zza("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                zziyVarZzp.zzj().zzn().zza("Preview Mode was not enabled.");
                zziyVarZzp.zze().zzi(null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zziyVarZzp.zzj().zzn().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zziyVarZzp.zze().zzi(queryParameter2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setUserId(@NonNull final String str, long j10) throws RemoteException {
        zza();
        final zziy zziyVarZzp = this.zza.zzp();
        if (str != null && TextUtils.isEmpty(str)) {
            zziyVarZzp.zzu.zzj().zzu().zza("User ID must be non-empty or null");
        } else {
            zziyVarZzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjj
                @Override // java.lang.Runnable
                public final void run() {
                    zziy zziyVar = zziyVarZzp;
                    if (zziyVar.zzg().zzb(str)) {
                        zziyVar.zzg().zzag();
                    }
                }
            });
            zziyVarZzp.zza((String) null, "_id", (Object) str, true, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull IObjectWrapper iObjectWrapper, boolean z10, long j10) throws RemoteException {
        zza();
        this.zza.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws RemoteException {
        zzix zzixVarRemove;
        zza();
        synchronized (this.zzb) {
            zzixVarRemove = this.zzb.remove(Integer.valueOf(zzdjVar.zza()));
        }
        if (zzixVarRemove == null) {
            zzixVarRemove = new zzb(zzdjVar);
        }
        this.zza.zzp().zzb(zzixVarRemove);
    }

    private final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str) {
        zza();
        this.zza.zzt().zza(zzdiVar, str);
    }
}

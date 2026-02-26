package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpa {
    private final Context zza;
    private final Executor zzb;
    private final zzfoh zzc;
    private final zzfoj zzd;
    private final zzfoz zze;
    private final zzfoz zzf;
    private Task zzg;
    private Task zzh;

    @VisibleForTesting
    zzfpa(Context context, Executor executor, zzfoh zzfohVar, zzfoj zzfojVar, zzfox zzfoxVar, zzfoy zzfoyVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfohVar;
        this.zzd = zzfojVar;
        this.zze = zzfoxVar;
        this.zzf = zzfoyVar;
    }

    public static zzfpa zze(@NonNull Context context, @NonNull Executor executor, @NonNull zzfoh zzfohVar, @NonNull zzfoj zzfojVar) {
        final zzfpa zzfpaVar = new zzfpa(context, executor, zzfohVar, zzfojVar, new zzfox(), new zzfoy());
        if (zzfpaVar.zzd.zzd()) {
            zzfpaVar.zzg = zzfpaVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfou
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc();
                }
            });
        } else {
            zzfpaVar.zzg = Tasks.forResult(zzfpaVar.zze.zza());
        }
        zzfpaVar.zzh = zzfpaVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfov
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        });
        return zzfpaVar;
    }

    private static zzasj zzg(@NonNull Task task, @NonNull zzasj zzasjVar) {
        return !task.isSuccessful() ? zzasjVar : (zzasj) task.getResult();
    }

    private final Task zzh(@NonNull Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfow
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zza.zzf(exc);
            }
        });
    }

    public final zzasj zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzasj zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    final /* synthetic */ zzasj zzc() throws Exception {
        zzaro zzaroVarZza = zzasj.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID uuidFromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
            byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zzaroVarZza.zzs(id);
            zzaroVarZza.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zzaroVarZza.zzab(6);
        }
        return (zzasj) zzaroVarZza.zzbr();
    }

    final /* synthetic */ zzasj zzd() throws Exception {
        Context context = this.zza;
        return zzfop.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}

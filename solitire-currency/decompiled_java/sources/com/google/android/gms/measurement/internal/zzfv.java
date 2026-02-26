package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzrb;
import com.google.android.gms.measurement.internal.zziq;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfv extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    zzfv(zzho zzhoVar, long j10) {
        super(zzhoVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j10;
    }

    @VisibleForTesting
    @WorkerThread
    private final String zzah() {
        if (zzrb.zza() && zze().zza(zzbh.zzbk)) {
            zzj().zzp().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    zzj().zzv().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzj().zzw().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @WorkerThread
    final int zzaa() {
        zzu();
        return this.zzj;
    }

    @WorkerThread
    final int zzab() {
        zzu();
        return this.zzc;
    }

    @WorkerThread
    final String zzac() {
        zzu();
        return this.zzl;
    }

    @WorkerThread
    final String zzad() {
        zzu();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    @WorkerThread
    final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    @WorkerThread
    final List<String> zzaf() {
        return this.zzh;
    }

    @WorkerThread
    final void zzag() {
        String str;
        zzt();
        if (zzk().zzn().zza(zziq.zza.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzq().zzv().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzgd zzgdVarZzc = zzj().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzgdVarZzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = zzb().currentTimeMillis();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfu zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zziy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkv zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzla zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzmi zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:0|2|(1:4)(23:87|6|(1:10)(2:11|(1:13))|85|14|(4:16|(1:18)(1:20)|89|21)|26|(1:31)(1:30)|32|SW:33|(1:45)(1:46)|47|(1:49)|91|50|(1:52)(1:53)|54|(1:56)|(3:58|(1:60)(1:61)|62)|66|(3:68|(1:70)(3:72|(3:75|(1:94)(1:95)|73)|93)|71)|(1:79)|(2:81|82)(2:83|84))|5|26|(2:28|31)(0)|32|SW:33|(0)(0)|47|(0)|91|50|(0)(0)|54|(0)|(0)|66|(0)|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01cb, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01cc, code lost:
    
        zzj().zzg().zza("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgb.zza(r0), r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0195 A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c2, B:62:0x01c7, B:61:0x01c5), top: B:91:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ae A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:50:0x0170, B:54:0x018d, B:56:0x0195, B:58:0x01ae, B:60:0x01c2, B:62:0x01c7, B:61:0x01c5), top: B:91:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022f  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzx() {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfv.zzx():void");
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020b  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final com.google.android.gms.measurement.internal.zzn zza(java.lang.String r51) {
        /*
            Method dump skipped, instruction units count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfv.zza(java.lang.String):com.google.android.gms.measurement.internal.zzn");
    }

    final boolean zzb(String str) {
        String str2 = this.zzo;
        boolean z10 = (str2 == null || str2.equals(str)) ? false : true;
        this.zzo = str;
        return z10;
    }
}

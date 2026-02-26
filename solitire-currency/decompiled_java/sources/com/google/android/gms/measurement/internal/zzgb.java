package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzoz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgb extends zzil {
    private char zza;
    private long zzb;

    @GuardedBy("this")
    private String zzc;
    private final zzgd zzd;
    private final zzgd zze;
    private final zzgd zzf;
    private final zzgd zzg;
    private final zzgd zzh;
    private final zzgd zzi;
    private final zzgd zzj;
    private final zzgd zzk;
    private final zzgd zzl;

    zzgb(zzho zzhoVar) {
        super(zzhoVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzgd(this, 6, false, false);
        this.zze = new zzgd(this, 6, true, false);
        this.zzf = new zzgd(this, 6, false, true);
        this.zzg = new zzgd(this, 5, false, false);
        this.zzh = new zzgd(this, 5, true, false);
        this.zzi = new zzgd(this, 5, false, true);
        this.zzj = new zzgd(this, 4, false, false);
        this.zzk = new zzgd(this, 3, false, false);
        this.zzl = new zzgd(this, 2, false, false);
    }

    @VisibleForTesting
    private final String zzy() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                this.zzc = this.zzu.zzw() != null ? this.zzu.zzw() : "FA";
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }

    public final zzgd zzc() {
        return this.zzk;
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

    public final zzgd zzg() {
        return this.zzd;
    }

    public final zzgd zzh() {
        return this.zzf;
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

    public final zzgd zzm() {
        return this.zze;
    }

    public final zzgd zzn() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    protected final boolean zzo() {
        return false;
    }

    public final zzgd zzp() {
        return this.zzl;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final zzgd zzu() {
        return this.zzg;
    }

    public final zzgd zzv() {
        return this.zzi;
    }

    public final zzgd zzw() {
        return this.zzh;
    }

    public final String zzx() {
        Pair<String, Long> pairZza;
        if (zzk().zzb == null || (pairZza = zzk().zzb.zza()) == null || pairZza == zzgm.zza) {
            return null;
        }
        return String.valueOf(pairZza.second) + ":" + ((String) pairZza.first);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @VisibleForTesting
    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            return (zzoz.zza() && zzbh.zzcc.zza(null).booleanValue()) ? "" : str;
        }
        return str.substring(0, iLastIndexOf);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    protected static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzgc(str);
    }

    static String zza(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZza = zza(z10, obj);
        String strZza2 = zza(z10, obj2);
        String strZza3 = zza(z10, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZza)) {
            sb.append(str2);
            sb.append(strZza);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZza2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strZza2);
        }
        if (!TextUtils.isEmpty(strZza3)) {
            sb.append(str3);
            sb.append(strZza3);
        }
        return sb.toString();
    }

    @VisibleForTesting
    private static String zza(boolean z10, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i10 = 0;
        if (obj instanceof Long) {
            if (!z10) {
                return String.valueOf(obj);
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb = new StringBuilder(z10 ? th.getClass().getName() : th.toString());
            String strZzb = zzb(zzho.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i10];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(strZzb)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
                i10++;
            }
            return sb.toString();
        }
        if (obj instanceof zzgc) {
            return ((zzgc) obj).zza;
        }
        return z10 ? "-" : String.valueOf(obj);
    }

    protected final void zza(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z10 && zza(i10)) {
            zza(i10, zza(false, str, obj, obj2, obj3));
        }
        if (z11 || i10 < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzhh zzhhVarZzo = this.zzu.zzo();
        if (zzhhVarZzo == null) {
            zza(6, "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!zzhhVarZzo.zzaf()) {
            zza(6, "Scheduler not initialized. Not logging error/warn");
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 >= 9) {
            i10 = 8;
        }
        zzhhVarZzo.zzb(new zzga(this, i10, str, obj, obj2, obj3));
    }

    @VisibleForTesting
    protected final void zza(int i10, String str) {
        Log.println(i10, zzy(), str);
    }

    @VisibleForTesting
    protected final boolean zza(int i10) {
        return Log.isLoggable(zzy(), i10);
    }
}

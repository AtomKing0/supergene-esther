package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgr extends zzcs implements zzed {
    private static final zzcy zzb = new zzgl();
    private static final zzgr zzd;
    private int zze;
    private int zzg;
    private zzgk zzj;
    private boolean zzk;
    private boolean zzl;
    private String zzf = "";
    private zzcx zzh = zzcs.zzn();
    private zzcz zzi = zzcs.zzo();

    static {
        zzgr zzgrVar = new zzgr();
        zzd = zzgrVar;
        zzcs.zzt(zzgr.class, zzgrVar);
    }

    private zzgr() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    protected final Object zzx(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcs.zzq(zzd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zze", "zzf", "zzg", zzgq.zza, "zzh", zzgn.zza, "zzi", zzhh.class, "zzj", "zzk", "zzl"});
        }
        if (i11 == 3) {
            return new zzgr();
        }
        zzgl zzglVar = null;
        if (i11 == 4) {
            return new zzgp(zzglVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzd;
    }
}

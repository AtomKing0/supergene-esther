package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzge extends zzcs implements zzed {
    private static final zzge zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        zzge zzgeVar = new zzge();
        zzb = zzgeVar;
        zzcs.zzt(zzge.class, zzgeVar);
    }

    private zzge() {
    }

    static /* synthetic */ void zzA(zzge zzgeVar, zzhb zzhbVar) {
        zzhbVar.getClass();
        zzgeVar.zzf = zzhbVar;
        zzgeVar.zze = 2;
    }

    static /* synthetic */ void zzB(zzge zzgeVar, int i10) {
        zzgeVar.zzg = i10 - 1;
        zzgeVar.zzd |= 1;
    }

    public static zzgd zzy() {
        return (zzgd) zzb.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    protected final Object zzx(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcs.zzq(zzb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzgb.zza, zzhb.class, zzho.class});
        }
        if (i11 == 3) {
            return new zzge();
        }
        zzgc zzgcVar = null;
        if (i11 == 4) {
            return new zzgd(zzgcVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}

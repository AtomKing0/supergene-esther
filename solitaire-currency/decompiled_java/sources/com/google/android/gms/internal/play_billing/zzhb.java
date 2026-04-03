package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhb extends zzcs implements zzed {
    private static final zzhb zzb;
    private int zzd;
    private int zze;

    static {
        zzhb zzhbVar = new zzhb();
        zzb = zzhbVar;
        zzcs.zzt(zzhb.class, zzhbVar);
    }

    private zzhb() {
    }

    static /* synthetic */ void zzA(zzhb zzhbVar, int i10) {
        zzhbVar.zze = i10 - 1;
        zzhbVar.zzd |= 1;
    }

    public static zzgz zzy() {
        return (zzgz) zzb.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    protected final Object zzx(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcs.zzq(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzha.zza});
        }
        if (i11 == 3) {
            return new zzhb();
        }
        zzgy zzgyVar = null;
        if (i11 == 4) {
            return new zzgz(zzgyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}

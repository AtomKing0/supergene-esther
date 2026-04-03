package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzho extends zzcs implements zzed {
    private static final zzho zzb;
    private int zzd;
    private int zze;

    static {
        zzho zzhoVar = new zzho();
        zzb = zzhoVar;
        zzcs.zzt(zzho.class, zzhoVar);
    }

    private zzho() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzcs
    protected final Object zzx(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcs.zzq(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i11 == 3) {
            return new zzho();
        }
        zzhm zzhmVar = null;
        if (i11 == 4) {
            return new zzhn(zzhmVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}

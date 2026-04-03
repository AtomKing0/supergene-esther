package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbi implements zzgye {
    static final zzgye zza = new zzhbi();

    private zzhbi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgye
    public final boolean zza(int i10) {
        if (i10 != 0 && i10 != 1 && i10 != 2 && i10 != 1999) {
            switch (i10) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                case 1010:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}

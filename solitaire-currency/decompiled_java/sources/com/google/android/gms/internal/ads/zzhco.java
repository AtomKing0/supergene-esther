package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhco extends zzgxy implements zzgzk {
    private static final zzhco zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgwm zzd;
    private zzgwm zze;
    private zzgwm zzf;

    static {
        zzhco zzhcoVar = new zzhco();
        zza = zzhcoVar;
        zzgxy.zzcb(zzhco.class, zzhcoVar);
    }

    private zzhco() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zzd = zzgwmVar;
        this.zze = zzgwmVar;
        this.zzf = zzgwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhco();
            case NEW_BUILDER:
                return new zzhcn(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzhco.class) {
                        zzgxtVar = zzb;
                        if (zzgxtVar == null) {
                            zzgxtVar = new zzgxt(zza);
                            zzb = zzgxtVar;
                        }
                        break;
                    }
                }
                return zzgxtVar;
            default:
                throw new UnsupportedOperationException();
        }
    }
}

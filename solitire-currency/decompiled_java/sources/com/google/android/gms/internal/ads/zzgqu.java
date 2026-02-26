package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgqu extends zzgxy implements zzgzk {
    private static final zzgqu zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgra zze;
    private zzgsl zzf;

    static {
        zzgqu zzgquVar = new zzgqu();
        zza = zzgquVar;
        zzgxy.zzcb(zzgqu.class, zzgquVar);
    }

    private zzgqu() {
    }

    public static zzgqt zzc() {
        return (zzgqt) zza.zzaZ();
    }

    public static zzgqu zze(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgqu) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzi(zzgqu zzgquVar, zzgra zzgraVar) {
        zzgraVar.getClass();
        zzgquVar.zze = zzgraVar;
        zzgquVar.zzc |= 1;
    }

    static /* synthetic */ void zzj(zzgqu zzgquVar, zzgsl zzgslVar) {
        zzgslVar.getClass();
        zzgquVar.zzf = zzgslVar;
        zzgquVar.zzc |= 2;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgqs zzgqsVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgqu();
            case NEW_BUILDER:
                return new zzgqt(zzgqsVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgqu.class) {
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

    public final zzgra zzf() {
        zzgra zzgraVar = this.zze;
        return zzgraVar == null ? zzgra.zze() : zzgraVar;
    }

    public final zzgsl zzg() {
        zzgsl zzgslVar = this.zzf;
        return zzgslVar == null ? zzgsl.zze() : zzgslVar;
    }
}

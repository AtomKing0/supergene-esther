package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgtv extends zzgxy implements zzgzk {
    private static final zzgtv zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgty zze;

    static {
        zzgtv zzgtvVar = new zzgtv();
        zza = zzgtvVar;
        zzgxy.zzcb(zzgtv.class, zzgtvVar);
    }

    private zzgtv() {
    }

    public static zzgtu zzc() {
        return (zzgtu) zza.zzaZ();
    }

    public static zzgtv zze(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgtv) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzg() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzh(zzgtv zzgtvVar, zzgty zzgtyVar) {
        zzgtyVar.getClass();
        zzgtvVar.zze = zzgtyVar;
        zzgtvVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgtt zzgttVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgtv();
            case NEW_BUILDER:
                return new zzgtu(zzgttVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgtv.class) {
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

    public final zzgty zzf() {
        zzgty zzgtyVar = this.zze;
        return zzgtyVar == null ? zzgty.zze() : zzgtyVar;
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgsb extends zzgxy implements zzgzk {
    private static final zzgsb zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;

    static {
        zzgsb zzgsbVar = new zzgsb();
        zza = zzgsbVar;
        zzgxy.zzcb(zzgsb.class, zzgsbVar);
    }

    private zzgsb() {
    }

    public static zzgsa zzd() {
        return (zzgsa) zza.zzaZ();
    }

    public static zzgsb zzf(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgsb) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgrz zzgrzVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzd", "zzc"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgsb();
            case NEW_BUILDER:
                return new zzgsa(zzgrzVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgsb.class) {
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

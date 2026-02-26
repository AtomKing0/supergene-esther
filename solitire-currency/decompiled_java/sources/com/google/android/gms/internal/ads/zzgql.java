package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgql extends zzgxy implements zzgzk {
    private static final zzgql zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgwm zze = zzgwm.zzb;
    private zzgqr zzf;

    static {
        zzgql zzgqlVar = new zzgql();
        zza = zzgqlVar;
        zzgxy.zzcb(zzgql.class, zzgqlVar);
    }

    private zzgql() {
    }

    public static zzgqk zzc() {
        return (zzgqk) zza.zzaZ();
    }

    public static zzgql zze(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgql) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzj(zzgql zzgqlVar, zzgqr zzgqrVar) {
        zzgqrVar.getClass();
        zzgqlVar.zzf = zzgqrVar;
        zzgqlVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgqj zzgqjVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgql();
            case NEW_BUILDER:
                return new zzgqk(zzgqjVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgql.class) {
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

    public final zzgqr zzf() {
        zzgqr zzgqrVar = this.zzf;
        return zzgqrVar == null ? zzgqr.zze() : zzgqrVar;
    }

    public final zzgwm zzg() {
        return this.zze;
    }
}

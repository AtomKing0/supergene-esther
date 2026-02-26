package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgrs extends zzgxy implements zzgzk {
    private static final zzgrs zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgwm zzd = zzgwm.zzb;

    static {
        zzgrs zzgrsVar = new zzgrs();
        zza = zzgrsVar;
        zzgxy.zzcb(zzgrs.class, zzgrsVar);
    }

    private zzgrs() {
    }

    public static zzgrr zzc() {
        return (zzgrr) zza.zzaZ();
    }

    public static zzgrs zze(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgrs) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzg() {
        return zza.zzbN();
    }

    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgrq zzgrqVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzc", "zzd"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgrs();
            case NEW_BUILDER:
                return new zzgrr(zzgrqVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgrs.class) {
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

    public final zzgwm zzf() {
        return this.zzd;
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgsh extends zzgxy implements zzgzk {
    private static final zzgsh zza;
    private static volatile zzgzr zzb;

    static {
        zzgsh zzgshVar = new zzgsh();
        zza = zzgshVar;
        zzgxy.zzcb(zzgsh.class, zzgshVar);
    }

    private zzgsh() {
    }

    public static zzgsh zzc() {
        return zza;
    }

    public static zzgsh zzd(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgsh) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgsf zzgsfVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0000", null);
            case NEW_MUTABLE_INSTANCE:
                return new zzgsh();
            case NEW_BUILDER:
                return new zzgsg(zzgsfVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgsh.class) {
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

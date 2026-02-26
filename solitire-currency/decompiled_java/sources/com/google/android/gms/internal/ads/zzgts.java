package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgts extends zzgxy implements zzgzk {
    private static final zzgts zza;
    private static volatile zzgzr zzb;
    private String zzc = "";

    static {
        zzgts zzgtsVar = new zzgts();
        zza = zzgtsVar;
        zzgxy.zzcb(zzgts.class, zzgtsVar);
    }

    private zzgts() {
    }

    public static zzgtr zza() {
        return (zzgtr) zza.zzaZ();
    }

    public static zzgts zzd() {
        return zza;
    }

    public static zzgts zze(zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        return (zzgts) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    static /* synthetic */ void zzg(zzgts zzgtsVar, String str) {
        str.getClass();
        zzgtsVar.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgtq zzgtqVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgts();
            case NEW_BUILDER:
                return new zzgtr(zzgtqVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgts.class) {
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

    public final String zzf() {
        return this.zzc;
    }
}

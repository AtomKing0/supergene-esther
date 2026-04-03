package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgsr extends zzgxy implements zzgzk {
    private static final zzgsr zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;

    static {
        zzgsr zzgsrVar = new zzgsr();
        zza = zzgsrVar;
        zzgxy.zzcb(zzgsr.class, zzgsrVar);
    }

    private zzgsr() {
    }

    public static zzgsq zzd() {
        return (zzgsq) zza.zzaZ();
    }

    public static zzgsr zzf() {
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzgsi zzc() {
        int i10 = this.zzc;
        zzgsi zzgsiVar = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? null : zzgsi.SHA224 : zzgsi.SHA512 : zzgsi.SHA256 : zzgsi.SHA384 : zzgsi.SHA1 : zzgsi.UNKNOWN_HASH;
        return zzgsiVar == null ? zzgsi.UNRECOGNIZED : zzgsiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgsp zzgspVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzc", "zzd"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgsr();
            case NEW_BUILDER:
                return new zzgsq(zzgspVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgsr.class) {
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

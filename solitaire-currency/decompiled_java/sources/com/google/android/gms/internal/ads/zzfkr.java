package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkr extends zzgxy implements zzgzk {
    private static final zzfkr zza;
    private static volatile zzgzr zzb;
    private zzgyk zzc = zzgxy.zzbK();

    static {
        zzfkr zzfkrVar = new zzfkr();
        zza = zzfkrVar;
        zzgxy.zzcb(zzfkr.class, zzfkrVar);
    }

    private zzfkr() {
    }

    public static zzfko zzc() {
        return (zzfko) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzfkr zzfkrVar, zzfkq zzfkqVar) {
        zzfkqVar.getClass();
        zzgyk zzgykVar = zzfkrVar.zzc;
        if (!zzgykVar.zzc()) {
            zzfkrVar.zzc = zzgxy.zzbL(zzgykVar);
        }
        zzfkrVar.zzc.add(zzfkqVar);
    }

    public final int zza() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzfkn zzfknVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfkq.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzfkr();
            case NEW_BUILDER:
                return new zzfko(zzfknVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzfkr.class) {
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

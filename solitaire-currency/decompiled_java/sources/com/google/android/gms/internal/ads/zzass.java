package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzass extends zzgxy implements zzgzk {
    private static final zzass zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zzd;
    private String zze = "";
    private zzgwm zzf = zzgwm.zzb;

    static {
        zzass zzassVar = new zzass();
        zza = zzassVar;
        zzgxy.zzcb(zzass.class, zzassVar);
    }

    private zzass() {
    }

    public static zzass zzd() {
        return zza;
    }

    public final long zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzarn zzarnVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzass();
            case NEW_BUILDER:
                return new zzasr(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzass.class) {
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

    public final boolean zze() {
        return (this.zzc & 1) != 0;
    }
}

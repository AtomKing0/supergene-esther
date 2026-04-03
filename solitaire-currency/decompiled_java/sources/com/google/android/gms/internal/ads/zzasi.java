package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzasi extends zzgxy implements zzgzk {
    private static final zzasi zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzasi zzasiVar = new zzasi();
        zza = zzasiVar;
        zzgxy.zzcb(zzasi.class, zzasiVar);
    }

    private zzasi() {
    }

    public static zzash zza() {
        return (zzash) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzasi zzasiVar, long j10) {
        zzasiVar.zzc |= 1;
        zzasiVar.zzd = j10;
    }

    static /* synthetic */ void zze(zzasi zzasiVar, long j10) {
        zzasiVar.zzc |= 4;
        zzasiVar.zzf = j10;
    }

    static /* synthetic */ void zzf(zzasi zzasiVar, long j10) {
        zzasiVar.zzc |= 8;
        zzasiVar.zzg = j10;
    }

    static /* synthetic */ void zzg(zzasi zzasiVar, long j10) {
        zzasiVar.zzc |= 16;
        zzasiVar.zzh = j10;
    }

    static /* synthetic */ void zzh(zzasi zzasiVar, long j10) {
        zzasiVar.zzc |= 32;
        zzasiVar.zzi = j10;
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
                return zzgxy.zzbS(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case NEW_MUTABLE_INSTANCE:
                return new zzasi();
            case NEW_BUILDER:
                return new zzash(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzasi.class) {
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

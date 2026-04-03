package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzasw extends zzgxy implements zzgzk {
    private static final zzasw zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgyk zzd = zzgxy.zzbK();
    private zzgwm zze = zzgwm.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzasw zzaswVar = new zzasw();
        zza = zzaswVar;
        zzgxy.zzcb(zzasw.class, zzaswVar);
    }

    private zzasw() {
    }

    public static zzasv zza() {
        return (zzasv) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzasw zzaswVar, zzgwm zzgwmVar) {
        zzgyk zzgykVar = zzaswVar.zzd;
        if (!zzgykVar.zzc()) {
            zzaswVar.zzd = zzgxy.zzbL(zzgykVar);
        }
        zzaswVar.zzd.add(zzgwmVar);
    }

    static /* synthetic */ void zze(zzasw zzaswVar, zzgwm zzgwmVar) {
        zzaswVar.zzc |= 1;
        zzaswVar.zze = zzgwmVar;
    }

    static /* synthetic */ void zzf(zzasw zzaswVar, int i10) {
        zzaswVar.zzg = 4;
        zzaswVar.zzc = 4 | zzaswVar.zzc;
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
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzasq.zza, "zzg", zzaso.zza});
            case NEW_MUTABLE_INSTANCE:
                return new zzasw();
            case NEW_BUILDER:
                return new zzasv(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzasw.class) {
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

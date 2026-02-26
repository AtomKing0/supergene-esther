package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgsv extends zzgxy implements zzgzk {
    private static final zzgsv zza;
    private static volatile zzgzr zzb;
    private String zzc = "";
    private zzgwm zzd = zzgwm.zzb;
    private int zze;

    static {
        zzgsv zzgsvVar = new zzgsv();
        zza = zzgsvVar;
        zzgxy.zzcb(zzgsv.class, zzgsvVar);
    }

    private zzgsv() {
    }

    public static zzgst zza() {
        return (zzgst) zza.zzaZ();
    }

    public static zzgsv zze() {
        return zza;
    }

    static /* synthetic */ void zzh(zzgsv zzgsvVar, String str) {
        str.getClass();
        zzgsvVar.zzc = str;
    }

    static /* synthetic */ void zzi(zzgsv zzgsvVar, zzgwm zzgwmVar) {
        zzgwmVar.getClass();
        zzgsvVar.zzd = zzgwmVar;
    }

    public final zzgsu zzc() {
        int i10 = this.zze;
        zzgsu zzgsuVar = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? null : zzgsu.REMOTE : zzgsu.ASYMMETRIC_PUBLIC : zzgsu.ASYMMETRIC_PRIVATE : zzgsu.SYMMETRIC : zzgsu.UNKNOWN_KEYMATERIAL;
        return zzgsuVar == null ? zzgsu.UNRECOGNIZED : zzgsuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgss zzgssVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgsv();
            case NEW_BUILDER:
                return new zzgst(zzgssVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzgsv.class) {
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

    public final String zzg() {
        return this.zzc;
    }
}

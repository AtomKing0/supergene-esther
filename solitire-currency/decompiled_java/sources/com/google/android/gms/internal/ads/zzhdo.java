package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhdo extends zzgxy implements zzgzk {
    private static final zzhdo zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzhcp zzf;
    private zzhct zzg;
    private int zzh;
    private int zzk;
    private byte zzm = 2;
    private String zze = "";
    private zzgyg zzi = zzgxy.zzbG();
    private String zzj = "";
    private zzgyk zzl = zzgxy.zzbK();

    static {
        zzhdo zzhdoVar = new zzhdo();
        zza = zzhdoVar;
        zzgxy.zzcb(zzhdo.class, zzhdoVar);
    }

    private zzhdo() {
    }

    public static zzhdn zzd() {
        return (zzhdn) zza.zzaZ();
    }

    static /* synthetic */ void zzg(zzhdo zzhdoVar, int i10) {
        zzhdoVar.zzc |= 1;
        zzhdoVar.zzd = i10;
    }

    static /* synthetic */ void zzh(zzhdo zzhdoVar, String str) {
        str.getClass();
        zzhdoVar.zzc |= 2;
        zzhdoVar.zze = str;
    }

    static /* synthetic */ void zzi(zzhdo zzhdoVar, zzhcp zzhcpVar) {
        zzhcpVar.getClass();
        zzhdoVar.zzf = zzhcpVar;
        zzhdoVar.zzc |= 4;
    }

    static /* synthetic */ void zzj(zzhdo zzhdoVar, String str) {
        str.getClass();
        zzgyk zzgykVar = zzhdoVar.zzl;
        if (!zzgykVar.zzc()) {
            zzhdoVar.zzl = zzgxy.zzbL(zzgykVar);
        }
        zzhdoVar.zzl.add(str);
    }

    static /* synthetic */ void zzk(zzhdo zzhdoVar, int i10) {
        zzhdoVar.zzk = i10 - 1;
        zzhdoVar.zzc |= 64;
    }

    public final int zzc() {
        return this.zzl.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    protected final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzm);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzm = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzhdl.zza, "zzl"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdo();
            case NEW_BUILDER:
                return new zzhdn(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzhdo.class) {
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
        return this.zze;
    }
}

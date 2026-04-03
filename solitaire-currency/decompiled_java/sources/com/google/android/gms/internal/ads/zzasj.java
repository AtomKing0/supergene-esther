package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzasj extends zzgxy implements zzgzk {
    private static final zzasj zza;
    private static volatile zzgzr zzb;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private long zzI;
    private long zzJ;
    private long zzK;
    private long zzM;
    private zzasl zzP;
    private zzase zzaF;
    private long zzaL;
    private zzarw zzaO;
    private zzary zzaP;
    private int zzaS;
    private long zzaT;
    private boolean zzaW;
    private long zzaY;
    private zzass zzaZ;
    private zzasg zzah;
    private zzasi zzaj;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzasu zzax;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzu;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zzf = "";
    private String zzg = "";
    private String zzv = "";
    private String zzF = "";
    private String zzG = "D";
    private String zzH = "";
    private String zzL = "";
    private long zzN = -1;
    private long zzO = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private long zzV = -1;
    private String zzW = "D";
    private String zzX = "D";
    private long zzY = -1;
    private int zzZ = 1000;
    private int zzaa = 1000;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private long zzaf = -1;
    private int zzag = 1000;
    private zzgyk zzai = zzgxy.zzbK();
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private long zzar = -1;
    private String zzas = "D";
    private long zzat = -1;
    private long zzay = -1;
    private int zzaz = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzgyk zzaC = zzgxy.zzbK();
    private int zzaD = 1000;
    private zzgyk zzaE = zzgxy.zzbK();
    private String zzaG = "";
    private long zzaH = -1;
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaM = -1;
    private String zzaN = "";
    private long zzaQ = -1;
    private long zzaR = -1;
    private String zzaU = "";
    private int zzaV = 2;
    private String zzaX = "";
    private long zzba = -1;
    private String zzbb = "";

    static {
        zzasj zzasjVar = new zzasj();
        zza = zzasjVar;
        zzgxy.zzcb(zzasj.class, zzasjVar);
    }

    private zzasj() {
    }

    static /* synthetic */ void zzA(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= C.BUFFER_FLAG_FIRST_SAMPLE;
        zzasjVar.zzK = j10;
    }

    static /* synthetic */ void zzB(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 268435456;
        zzasjVar.zzL = str;
    }

    static /* synthetic */ void zzC(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 536870912;
        zzasjVar.zzM = j10;
    }

    static /* synthetic */ void zzD(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 1073741824;
        zzasjVar.zzN = j10;
    }

    static /* synthetic */ void zzE(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= Integer.MIN_VALUE;
        zzasjVar.zzO = j10;
    }

    static /* synthetic */ void zzF(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 2;
        zzasjVar.zzQ = j10;
    }

    static /* synthetic */ void zzG(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 4;
        zzasjVar.zzR = j10;
    }

    static /* synthetic */ void zzH(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 8;
        zzasjVar.zzS = j10;
    }

    static /* synthetic */ void zzI(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 16;
        zzasjVar.zzT = j10;
    }

    static /* synthetic */ void zzJ(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 32;
        zzasjVar.zzU = j10;
    }

    static /* synthetic */ void zzK(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 64;
        zzasjVar.zzV = j10;
    }

    static /* synthetic */ void zzL(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzd |= 128;
        zzasjVar.zzW = str;
    }

    static /* synthetic */ void zzM(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzd |= 256;
        zzasjVar.zzX = str;
    }

    static /* synthetic */ void zzN(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 4096;
        zzasjVar.zzab = j10;
    }

    static /* synthetic */ void zzO(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 8192;
        zzasjVar.zzac = j10;
    }

    static /* synthetic */ void zzP(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 16384;
        zzasjVar.zzad = j10;
    }

    static /* synthetic */ void zzQ(zzasj zzasjVar, zzasg zzasgVar) {
        zzasgVar.getClass();
        zzasjVar.zzah = zzasgVar;
        zzasjVar.zzd |= 262144;
    }

    static /* synthetic */ void zzR(zzasj zzasjVar, zzasg zzasgVar) {
        zzasgVar.getClass();
        zzgyk zzgykVar = zzasjVar.zzai;
        if (!zzgykVar.zzc()) {
            zzasjVar.zzai = zzgxy.zzbL(zzgykVar);
        }
        zzasjVar.zzai.add(zzasgVar);
    }

    static /* synthetic */ void zzT(zzasj zzasjVar, zzasi zzasiVar) {
        zzasiVar.getClass();
        zzasjVar.zzaj = zzasiVar;
        zzasjVar.zzd |= 524288;
    }

    static /* synthetic */ void zzU(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 2097152;
        zzasjVar.zzal = j10;
    }

    static /* synthetic */ void zzV(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 4194304;
        zzasjVar.zzam = j10;
    }

    static /* synthetic */ void zzW(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= 8388608;
        zzasjVar.zzan = j10;
    }

    static /* synthetic */ void zzX(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzasjVar.zzaq = j10;
    }

    static /* synthetic */ void zzY(zzasj zzasjVar, long j10) {
        zzasjVar.zzd |= C.BUFFER_FLAG_FIRST_SAMPLE;
        zzasjVar.zzar = j10;
    }

    static /* synthetic */ void zzZ(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzd |= 268435456;
        zzasjVar.zzas = str;
    }

    public static zzaro zza() {
        return (zzaro) zza.zzaZ();
    }

    static /* synthetic */ void zzaa(zzasj zzasjVar, long j10) {
        zzasjVar.zze |= 512;
        zzasjVar.zzaH = j10;
    }

    static /* synthetic */ void zzab(zzasj zzasjVar, long j10) {
        zzasjVar.zze |= 1024;
        zzasjVar.zzaI = j10;
    }

    static /* synthetic */ void zzac(zzasj zzasjVar, long j10) {
        zzasjVar.zze |= 2048;
        zzasjVar.zzaJ = j10;
    }

    static /* synthetic */ void zzad(zzasj zzasjVar, long j10) {
        zzasjVar.zze |= 4096;
        zzasjVar.zzaK = j10;
    }

    static /* synthetic */ void zzae(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zze |= 32768;
        zzasjVar.zzaN = str;
    }

    static /* synthetic */ void zzaf(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zze |= 4194304;
        zzasjVar.zzaU = str;
    }

    static /* synthetic */ void zzag(zzasj zzasjVar, boolean z10) {
        zzasjVar.zze |= 16777216;
        zzasjVar.zzaW = z10;
    }

    static /* synthetic */ void zzah(zzasj zzasjVar, long j10) {
        zzasjVar.zze |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzasjVar.zzaY = j10;
    }

    static /* synthetic */ void zzam(zzasj zzasjVar, int i10) {
        zzasjVar.zzZ = i10 - 1;
        zzasjVar.zzd |= 1024;
    }

    static /* synthetic */ void zzan(zzasj zzasjVar, int i10) {
        zzasjVar.zzaa = i10 - 1;
        zzasjVar.zzd |= 2048;
    }

    static /* synthetic */ void zzao(zzasj zzasjVar, int i10) {
        zzasjVar.zzag = i10 - 1;
        zzasjVar.zzd |= 131072;
    }

    static /* synthetic */ void zzap(zzasj zzasjVar, int i10) {
        zzasjVar.zzaz = i10 - 1;
        zzasjVar.zze |= 8;
    }

    static /* synthetic */ void zzaq(zzasj zzasjVar, int i10) {
        zzasjVar.zzaA = i10 - 1;
        zzasjVar.zze |= 16;
    }

    static /* synthetic */ void zzar(zzasj zzasjVar, int i10) {
        zzasjVar.zzaS = i10 - 1;
        zzasjVar.zze |= 1048576;
    }

    static /* synthetic */ void zzas(zzasj zzasjVar, int i10) {
        zzasjVar.zzaV = 5;
        zzasjVar.zze |= 8388608;
    }

    public static zzasj zzd() {
        return zza;
    }

    public static zzasj zze(byte[] bArr, zzgxi zzgxiVar) throws zzgyn {
        return (zzasj) zzgxy.zzbx(zza, bArr, zzgxiVar);
    }

    static /* synthetic */ void zzi(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 1;
        zzasjVar.zzf = str;
    }

    static /* synthetic */ void zzj(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 2;
        zzasjVar.zzg = str;
    }

    static /* synthetic */ void zzk(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 4;
        zzasjVar.zzh = j10;
    }

    static /* synthetic */ void zzl(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 16;
        zzasjVar.zzj = j10;
    }

    static /* synthetic */ void zzm(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 32;
        zzasjVar.zzk = j10;
    }

    static /* synthetic */ void zzn(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 1024;
        zzasjVar.zzp = j10;
    }

    static /* synthetic */ void zzo(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 2048;
        zzasjVar.zzu = j10;
    }

    static /* synthetic */ void zzp(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 8192;
        zzasjVar.zzw = j10;
    }

    static /* synthetic */ void zzq(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 16384;
        zzasjVar.zzx = j10;
    }

    static /* synthetic */ void zzr(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 32768;
        zzasjVar.zzy = j10;
    }

    static /* synthetic */ void zzs(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 65536;
        zzasjVar.zzz = j10;
    }

    static /* synthetic */ void zzt(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 524288;
        zzasjVar.zzC = j10;
    }

    static /* synthetic */ void zzu(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 1048576;
        zzasjVar.zzD = j10;
    }

    static /* synthetic */ void zzv(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 2097152;
        zzasjVar.zzE = j10;
    }

    static /* synthetic */ void zzw(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 4194304;
        zzasjVar.zzF = str;
    }

    static /* synthetic */ void zzx(zzasj zzasjVar, String str) {
        str.getClass();
        zzasjVar.zzc |= 16777216;
        zzasjVar.zzH = str;
    }

    static /* synthetic */ void zzy(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= 33554432;
        zzasjVar.zzI = j10;
    }

    static /* synthetic */ void zzz(zzasj zzasjVar, long j10) {
        zzasjVar.zzc |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzasjVar.zzJ = j10;
    }

    public final boolean zzai() {
        return this.zzaW;
    }

    public final boolean zzaj() {
        return (this.zzc & 4194304) != 0;
    }

    public final boolean zzak() {
        return (this.zze & C.BUFFER_FLAG_FIRST_SAMPLE) != 0;
    }

    public final int zzal() {
        int iZza = zzart.zza(this.zzaV);
        if (iZza == 0) {
            return 3;
        }
        return iZza;
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
                zzgye zzgyeVar = zzasp.zza;
                return zzgxy.zzbS(zza, "\u0001a\u0000\u0003\u0001Įa\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂU\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈV\u0019ဂZ\u001a᠌W\u001bဈ\u0016\u001cဇX\u001dဈ\u0018\u001eဈY\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌@EဉAFဂBGဂ8Hဂ9I᠌CJဂ)Kဈ\u0017L᠌DMဈEN\u001bO᠌FP\u001bQဉGRဈHSဂITဂJUဂKVဂLWဂMXဂNYဈOZဉP[ဉQ\\ဂR]ဂS^᠌TÉဉ[ĭဂ\\Įဈ]", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzaT", "zzD", "zzE", "zzaU", "zzaY", "zzaV", zzars.zza, "zzF", "zzaW", "zzH", "zzaX", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzai", zzasg.class, "zzU", "zzV", "zzW", "zzX", "zzZ", zzgyeVar, "zzaa", zzgyeVar, "zzah", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", zzgyeVar, "zzaj", "zzak", "zzal", "zzam", "zzan", "zzaq", "zzar", "zzat", "zzau", zzaso.zza, "zzav", zzasq.zza, "zzas", "zzaw", zzarp.zza, "zzax", "zzay", "zzao", "zzap", "zzaz", zzgyeVar, "zzY", "zzG", "zzaA", zzgyeVar, "zzaB", "zzaC", zzasc.class, "zzaD", zzgyeVar, "zzaE", zzarr.class, "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaN", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", zzarz.zza, "zzaZ", "zzba", "zzbb"});
            case NEW_MUTABLE_INSTANCE:
                return new zzasj();
            case NEW_BUILDER:
                return new zzaro(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgxtVar = zzb;
                if (zzgxtVar == null) {
                    synchronized (zzasj.class) {
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

    public final zzass zzf() {
        zzass zzassVar = this.zzaZ;
        return zzassVar == null ? zzass.zzd() : zzassVar;
    }

    public final String zzg() {
        return this.zzaU;
    }

    public final String zzh() {
        return this.zzF;
    }
}

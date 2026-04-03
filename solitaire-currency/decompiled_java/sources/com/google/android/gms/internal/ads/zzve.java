package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzve implements zzyt, zztx {
    final /* synthetic */ zzvj zza;
    private final Uri zzc;
    private final zzgt zzd;
    private final zzuy zze;
    private final zzacn zzf;
    private final zzdm zzg;
    private volatile boolean zzi;
    private long zzk;

    @Nullable
    private zzadp zzm;
    private boolean zzn;
    private final zzadf zzh = new zzadf();
    private boolean zzj = true;
    private final long zzb = zztz.zza();
    private zzfy zzl = zzi(0);

    public zzve(zzvj zzvjVar, Uri uri, zzfs zzfsVar, zzuy zzuyVar, zzacn zzacnVar, zzdm zzdmVar) {
        this.zza = zzvjVar;
        this.zzc = uri;
        this.zzd = new zzgt(zzfsVar);
        this.zze = zzuyVar;
        this.zzf = zzacnVar;
        this.zzg = zzdmVar;
    }

    static /* bridge */ /* synthetic */ void zzf(zzve zzveVar, long j10, long j11) {
        zzveVar.zzh.zza = j10;
        zzveVar.zzk = j11;
        zzveVar.zzj = true;
        zzveVar.zzn = false;
    }

    private final zzfy zzi(long j10) {
        zzfw zzfwVar = new zzfw();
        zzfwVar.zzd(this.zzc);
        zzfwVar.zzc(j10);
        zzfwVar.zza(6);
        zzfwVar.zzb(zzvj.zzb);
        return zzfwVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zztx
    public final void zza(zzek zzekVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(zzvj.zzr(this.zza, true), this.zzk);
        int iZzb = zzekVar.zzb();
        zzadp zzadpVar = this.zzm;
        zzadpVar.getClass();
        zzadn.zzb(zzadpVar, zzekVar, iZzb);
        zzadpVar.zzs(jMax, 1, iZzb, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[LOOP:0: B:3:0x0004->B:138:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01e3 A[EDGE_INSN: B:139:0x01e3->B:92:0x01e3 BREAK  A[LOOP:1: B:80:0x01a0->B:142:0x01a0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:16:0x003c, B:17:0x0041, B:20:0x0057, B:21:0x005d, B:30:0x0093, B:32:0x009e, B:34:0x00aa, B:36:0x00b4, B:38:0x00c0, B:40:0x00ca, B:42:0x00d6, B:44:0x00e0, B:46:0x00f2, B:48:0x00fc, B:49:0x0102, B:58:0x0132, B:59:0x0139, B:61:0x0146, B:63:0x014e, B:65:0x016b, B:52:0x010c, B:55:0x0120, B:25:0x0069, B:28:0x007f), top: B:121:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:16:0x003c, B:17:0x0041, B:20:0x0057, B:21:0x005d, B:30:0x0093, B:32:0x009e, B:34:0x00aa, B:36:0x00b4, B:38:0x00c0, B:40:0x00ca, B:42:0x00d6, B:44:0x00e0, B:46:0x00f2, B:48:0x00fc, B:49:0x0102, B:58:0x0132, B:59:0x0139, B:61:0x0146, B:63:0x014e, B:65:0x016b, B:52:0x010c, B:55:0x0120, B:25:0x0069, B:28:0x007f), top: B:121:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:16:0x003c, B:17:0x0041, B:20:0x0057, B:21:0x005d, B:30:0x0093, B:32:0x009e, B:34:0x00aa, B:36:0x00b4, B:38:0x00c0, B:40:0x00ca, B:42:0x00d6, B:44:0x00e0, B:46:0x00f2, B:48:0x00fc, B:49:0x0102, B:58:0x0132, B:59:0x0139, B:61:0x0146, B:63:0x014e, B:65:0x016b, B:52:0x010c, B:55:0x0120, B:25:0x0069, B:28:0x007f), top: B:121:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:16:0x003c, B:17:0x0041, B:20:0x0057, B:21:0x005d, B:30:0x0093, B:32:0x009e, B:34:0x00aa, B:36:0x00b4, B:38:0x00c0, B:40:0x00ca, B:42:0x00d6, B:44:0x00e0, B:46:0x00f2, B:48:0x00fc, B:49:0x0102, B:58:0x0132, B:59:0x0139, B:61:0x0146, B:63:0x014e, B:65:0x016b, B:52:0x010c, B:55:0x0120, B:25:0x0069, B:28:0x007f), top: B:121:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fc A[Catch: all -> 0x0208, TRY_LEAVE, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:16:0x003c, B:17:0x0041, B:20:0x0057, B:21:0x005d, B:30:0x0093, B:32:0x009e, B:34:0x00aa, B:36:0x00b4, B:38:0x00c0, B:40:0x00ca, B:42:0x00d6, B:44:0x00e0, B:46:0x00f2, B:48:0x00fc, B:49:0x0102, B:58:0x0132, B:59:0x0139, B:61:0x0146, B:63:0x014e, B:65:0x016b, B:52:0x010c, B:55:0x0120, B:25:0x0069, B:28:0x007f), top: B:121:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0132 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:16:0x003c, B:17:0x0041, B:20:0x0057, B:21:0x005d, B:30:0x0093, B:32:0x009e, B:34:0x00aa, B:36:0x00b4, B:38:0x00c0, B:40:0x00ca, B:42:0x00d6, B:44:0x00e0, B:46:0x00f2, B:48:0x00fc, B:49:0x0102, B:58:0x0132, B:59:0x0139, B:61:0x0146, B:63:0x014e, B:65:0x016b, B:52:0x010c, B:55:0x0120, B:25:0x0069, B:28:0x007f), top: B:121:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0146 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000b, B:16:0x003c, B:17:0x0041, B:20:0x0057, B:21:0x005d, B:30:0x0093, B:32:0x009e, B:34:0x00aa, B:36:0x00b4, B:38:0x00c0, B:40:0x00ca, B:42:0x00d6, B:44:0x00e0, B:46:0x00f2, B:48:0x00fc, B:49:0x0102, B:58:0x0132, B:59:0x0139, B:61:0x0146, B:63:0x014e, B:65:0x016b, B:52:0x010c, B:55:0x0120, B:25:0x0069, B:28:0x007f), top: B:121:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0186 A[Catch: all -> 0x0205, TryCatch #1 {all -> 0x0205, blocks: (B:67:0x017b, B:69:0x0186, B:70:0x018b, B:72:0x018f), top: B:119:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018f A[Catch: all -> 0x0205, TRY_LEAVE, TryCatch #1 {all -> 0x0205, blocks: (B:67:0x017b, B:69:0x0186, B:70:0x018b, B:72:0x018f), top: B:119:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e8  */
    @Override // com.google.android.gms.internal.ads.zzyt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzh():void");
    }
}

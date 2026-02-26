package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzro implements zzsa {
    private final zzfvk zza;
    private final zzfvk zzb;
    private boolean zzc;

    public zzro(int i10) {
        zzrm zzrmVar = new zzrm(i10);
        zzrn zzrnVar = new zzrn(i10);
        this.zza = zzrmVar;
        this.zzb = zzrnVar;
        this.zzc = true;
    }

    static /* synthetic */ HandlerThread zza(int i10) {
        return new HandlerThread(zzrq.zzs(i10, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i10) {
        return new HandlerThread(zzrq.zzs(i10, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d A[Catch: Exception -> 0x006a, TryCatch #1 {Exception -> 0x006a, blocks: (B:4:0x001d, B:6:0x0021, B:11:0x002e, B:13:0x0036, B:15:0x004d, B:14:0x003d), top: B:31:0x001d }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzrp] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzrq] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzrq zzc(com.google.android.gms.internal.ads.zzrz r7) throws java.lang.Exception {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzsf r0 = r7.zza
            java.lang.String r0 = r0.zza
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6c
            r2.<init>()     // Catch: java.lang.Exception -> L6c
            java.lang.String r3 = "createCodec:"
            r2.append(r3)     // Catch: java.lang.Exception -> L6c
            r2.append(r0)     // Catch: java.lang.Exception -> L6c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L6c
            android.os.Trace.beginSection(r2)     // Catch: java.lang.Exception -> L6c
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch: java.lang.Exception -> L6c
            boolean r2 = r6.zzc     // Catch: java.lang.Exception -> L6a
            if (r2 == 0) goto L3d
            com.google.android.gms.internal.ads.zzaf r2 = r7.zzc     // Catch: java.lang.Exception -> L6a
            int r3 = com.google.android.gms.internal.ads.zzet.zza     // Catch: java.lang.Exception -> L6a
            r4 = 34
            if (r3 >= r4) goto L2a
            goto L3d
        L2a:
            r4 = 35
            if (r3 >= r4) goto L36
            java.lang.String r2 = r2.zzm     // Catch: java.lang.Exception -> L6a
            boolean r2 = com.google.android.gms.internal.ads.zzbn.zzi(r2)     // Catch: java.lang.Exception -> L6a
            if (r2 == 0) goto L3d
        L36:
            com.google.android.gms.internal.ads.zztf r2 = new com.google.android.gms.internal.ads.zztf     // Catch: java.lang.Exception -> L6a
            r2.<init>(r0)     // Catch: java.lang.Exception -> L6a
            r3 = 4
            goto L4d
        L3d:
            com.google.android.gms.internal.ads.zzru r2 = new com.google.android.gms.internal.ads.zzru     // Catch: java.lang.Exception -> L6a
            com.google.android.gms.internal.ads.zzfvk r3 = r6.zzb     // Catch: java.lang.Exception -> L6a
            com.google.android.gms.internal.ads.zzrn r3 = (com.google.android.gms.internal.ads.zzrn) r3     // Catch: java.lang.Exception -> L6a
            int r3 = r3.zza     // Catch: java.lang.Exception -> L6a
            android.os.HandlerThread r3 = zzb(r3)     // Catch: java.lang.Exception -> L6a
            r2.<init>(r0, r3)     // Catch: java.lang.Exception -> L6a
            r3 = 0
        L4d:
            com.google.android.gms.internal.ads.zzrq r4 = new com.google.android.gms.internal.ads.zzrq     // Catch: java.lang.Exception -> L6a
            com.google.android.gms.internal.ads.zzfvk r5 = r6.zza     // Catch: java.lang.Exception -> L6a
            com.google.android.gms.internal.ads.zzrm r5 = (com.google.android.gms.internal.ads.zzrm) r5     // Catch: java.lang.Exception -> L6a
            int r5 = r5.zza     // Catch: java.lang.Exception -> L6a
            android.os.HandlerThread r5 = zza(r5)     // Catch: java.lang.Exception -> L6a
            r4.<init>(r0, r5, r2, r1)     // Catch: java.lang.Exception -> L6a
            android.os.Trace.endSection()     // Catch: java.lang.Exception -> L67
            android.media.MediaFormat r2 = r7.zzb     // Catch: java.lang.Exception -> L67
            android.view.Surface r7 = r7.zzd     // Catch: java.lang.Exception -> L67
            com.google.android.gms.internal.ads.zzrq.zzh(r4, r2, r7, r1, r3)     // Catch: java.lang.Exception -> L67
            return r4
        L67:
            r7 = move-exception
            r1 = r4
            goto L6e
        L6a:
            r7 = move-exception
            goto L6e
        L6c:
            r7 = move-exception
            r0 = r1
        L6e:
            if (r1 != 0) goto L76
            if (r0 == 0) goto L79
            r0.release()
            goto L79
        L76:
            r1.zzl()
        L79:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzro.zzc(com.google.android.gms.internal.ads.zzrz):com.google.android.gms.internal.ads.zzrq");
    }

    @Override // com.google.android.gms.internal.ads.zzsa
    public final /* bridge */ /* synthetic */ zzsc zzd(zzrz zzrzVar) throws IOException {
        throw null;
    }

    public final void zze(boolean z10) {
        this.zzc = true;
    }
}

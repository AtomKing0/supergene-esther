package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ironsource.v8;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzof {

    @VisibleForTesting
    static final zzfxu zzb;
    private final SparseArray zzd;
    private final int zze;
    public static final zzof zza = new zzof(zzfxr.zzn(zzod.zza));

    @SuppressLint({"InlinedApi"})
    private static final zzfxr zzc = zzfxr.zzp(2, 5, 6);

    static {
        zzfxt zzfxtVar = new zzfxt();
        zzfxtVar.zza(5, 6);
        zzfxtVar.zza(17, 6);
        zzfxtVar.zza(7, 6);
        zzfxtVar.zza(30, 10);
        zzfxtVar.zza(18, 6);
        zzfxtVar.zza(6, 8);
        zzfxtVar.zza(8, 8);
        zzfxtVar.zza(14, 8);
        zzb = zzfxtVar.zzc();
    }

    @Nullable
    static Uri zza() {
        if (zzf()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    @SuppressLint({"UnprotectedReceiver"})
    static zzof zzc(Context context, zzh zzhVar, @Nullable zzon zzonVar) {
        return zzd(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzhVar, zzonVar);
    }

    @SuppressLint({"InlinedApi"})
    static zzof zzd(Context context, @Nullable Intent intent, zzh zzhVar, @Nullable zzon zzonVar) {
        Object systemService = context.getSystemService("audio");
        systemService.getClass();
        AudioManager audioManager = (AudioManager) systemService;
        if (zzonVar == null) {
            zzonVar = zzet.zza >= 33 ? zzoc.zzb(audioManager, zzhVar) : null;
        }
        int i10 = zzet.zza;
        if (i10 >= 33 && (zzet.zzN(context) || zzet.zzJ(context))) {
            return zzoc.zza(audioManager, zzhVar);
        }
        if (i10 >= 23 && zzoa.zza(audioManager, zzonVar)) {
            return zza;
        }
        zzfxv zzfxvVar = new zzfxv();
        zzfxvVar.zzf((Object) 2);
        if (i10 >= 29 && (zzet.zzN(context) || zzet.zzJ(context))) {
            zzfxvVar.zzh(zzob.zzb(zzhVar));
            return new zzof(zze(zzgap.zzh(zzfxvVar.zzi()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z10 = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z10 || zzf()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            zzfxvVar.zzh(zzc);
        }
        if (intent == null || z10 || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new zzof(zze(zzgap.zzh(zzfxvVar.zzi()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            zzfxvVar.zzh(zzgap.zzg(intArrayExtra));
        }
        return new zzof(zze(zzgap.zzh(zzfxvVar.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    private static zzfxr zze(@Nullable int[] iArr, int i10) {
        zzfxo zzfxoVar = new zzfxo();
        for (int i11 : iArr) {
            zzfxoVar.zzf(new zzod(i11, i10));
        }
        return zzfxoVar.zzi();
    }

    private static boolean zzf() {
        String str = zzet.zzc;
        return "Amazon".equals(str) || "Xiaomi".equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L4
            return r0
        L4:
            boolean r1 = r9 instanceof com.google.android.gms.internal.ads.zzof
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            com.google.android.gms.internal.ads.zzof r9 = (com.google.android.gms.internal.ads.zzof) r9
            android.util.SparseArray r1 = r8.zzd
            android.util.SparseArray r3 = r9.zzd
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            r5 = 31
            if (r4 < r5) goto L1d
            boolean r1 = androidx.media3.common.util.i.a(r1, r3)
            if (r1 == 0) goto L46
            goto L3f
        L1d:
            int r4 = r1.size()
            int r5 = r3.size()
            if (r4 != r5) goto L46
            r5 = r2
        L28:
            if (r5 >= r4) goto L3f
            int r6 = r1.keyAt(r5)
            java.lang.Object r7 = r1.valueAt(r5)
            java.lang.Object r6 = r3.get(r6)
            boolean r6 = java.util.Objects.equals(r7, r6)
            if (r6 == 0) goto L46
            int r5 = r5 + 1
            goto L28
        L3f:
            int r1 = r8.zze
            int r9 = r9.zze
            if (r1 != r9) goto L46
            return r0
        L46:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzof.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iContentHashCode;
        int i10 = zzet.zza;
        SparseArray sparseArray = this.zzd;
        if (i10 >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iKeyAt = 17;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i11)) * 31) + Objects.hashCode(sparseArray.valueAt(i11));
            }
            iContentHashCode = iKeyAt;
        }
        return this.zze + (iContentHashCode * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.zze + ", audioProfiles=" + this.zzd.toString() + v8.i.f15839e;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[PHI: r0
      0x003a: PHI (r0v3 int) = (r0v2 int), (r0v7 int) binds: [B:11:0x002c, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair zzb(com.google.android.gms.internal.ads.zzaf r9, com.google.android.gms.internal.ads.zzh r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.zzm
            r0.getClass()
            java.lang.String r1 = r9.zzj
            int r0 = com.google.android.gms.internal.ads.zzbn.zza(r0, r1)
            com.google.android.gms.internal.ads.zzfxu r1 = com.google.android.gms.internal.ads.zzof.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L19
            goto Lc3
        L19:
            r1 = 7
            r2 = 6
            r3 = 8
            r4 = 18
            if (r0 != r4) goto L2c
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzet.zzH(r0, r4)
            if (r0 != 0) goto L2b
            r0 = r2
            goto L47
        L2b:
            r0 = r4
        L2c:
            if (r0 != r3) goto L3a
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzet.zzH(r0, r3)
            if (r0 == 0) goto L38
            r0 = r3
            goto L3a
        L38:
            r0 = r1
            goto L47
        L3a:
            r5 = 30
            if (r0 != r5) goto L47
            android.util.SparseArray r6 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzet.zzH(r6, r5)
            if (r5 != 0) goto L47
            goto L38
        L47:
            android.util.SparseArray r5 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzet.zzH(r5, r0)
            if (r5 == 0) goto Lc3
            android.util.SparseArray r5 = r8.zzd
            java.lang.Object r5 = r5.get(r0)
            com.google.android.gms.internal.ads.zzod r5 = (com.google.android.gms.internal.ads.zzod) r5
            r5.getClass()
            int r6 = r9.zzz
            r7 = -1
            if (r6 == r7) goto L7e
            if (r0 != r4) goto L62
            goto L7e
        L62:
            java.lang.String r9 = r9.zzm
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L77
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            r10 = 33
            if (r9 >= r10) goto L77
            r9 = 10
            if (r6 <= r9) goto L89
            goto Lc3
        L77:
            boolean r9 = r5.zzb(r6)
            if (r9 != 0) goto L89
            goto Lc3
        L7e:
            int r9 = r9.zzA
            if (r9 != r7) goto L85
            r9 = 48000(0xbb80, float:6.7262E-41)
        L85:
            int r6 = r5.zza(r9, r10)
        L89:
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            r10 = 28
            if (r9 > r10) goto L9d
            if (r6 != r1) goto L93
            r2 = r3
            goto L9e
        L93:
            r10 = 3
            if (r6 == r10) goto L9e
            r10 = 4
            if (r6 == r10) goto L9e
            r10 = 5
            if (r6 != r10) goto L9d
            goto L9e
        L9d:
            r2 = r6
        L9e:
            r10 = 26
            if (r9 > r10) goto Lb0
            java.lang.String r9 = "fugu"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzet.zzb
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto Lb0
            r9 = 1
            if (r2 != r9) goto Lb0
            r2 = 2
        Lb0:
            int r9 = com.google.android.gms.internal.ads.zzet.zzh(r2)
            if (r9 == 0) goto Lc3
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r9 = android.util.Pair.create(r10, r9)
            return r9
        Lc3:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzof.zzb(com.google.android.gms.internal.ads.zzaf, com.google.android.gms.internal.ads.zzh):android.util.Pair");
    }

    private zzof(List list) {
        this.zzd = new SparseArray();
        for (int i10 = 0; i10 < list.size(); i10++) {
            zzod zzodVar = (zzod) list.get(i10);
            this.zzd.put(zzodVar.zzb, zzodVar);
        }
        int iMax = 0;
        for (int i11 = 0; i11 < this.zzd.size(); i11++) {
            iMax = Math.max(iMax, ((zzod) this.zzd.valueAt(i11)).zzc);
        }
        this.zze = iMax;
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcdw extends zzcbb implements zzgu, zzlq {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcdh zzc;
    private final zzxt zzd;
    private final zzcbj zze;
    private final WeakReference zzf;
    private final zzvm zzg;

    @Nullable
    private zzih zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcba zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;

    @Nullable
    private Integer zzr;
    private final ArrayList zzs;

    @Nullable
    private volatile zzcdj zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcdw(android.content.Context r4, com.google.android.gms.internal.ads.zzcbj r5, com.google.android.gms.internal.ads.zzcbk r6, @androidx.annotation.Nullable java.lang.Integer r7) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdw.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcbj, com.google.android.gms.internal.ads.zzcbk, java.lang.Integer):void");
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzcbb.zzD().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzA() {
        if (zzad()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j10 = this.zzn;
                Map mapZze = ((zzgp) this.zzs.remove(0)).zze();
                long j11 = 0;
                if (mapZze != null) {
                    Iterator it = mapZze.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (entry.getKey() != null && zzfuf.zzc("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                    j11 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j10 + j11;
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    @Nullable
    public final Integer zzC() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z10) {
        zzuk zzuxVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z10;
            int length = uriArr.length;
            if (length == 1) {
                zzuxVar = zzaa(uriArr[0]);
            } else {
                zzuk[] zzukVarArr = new zzuk[length];
                for (int i10 = 0; i10 < uriArr.length; i10++) {
                    zzukVarArr[i10] = zzaa(uriArr[i10]);
                }
                zzuxVar = new zzux(false, false, new zztt(), zzukVarArr);
            }
            this.zzh.zzB(zzuxVar);
            this.zzh.zzp();
            zzcbb.zzE().incrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzH() {
        zzih zzihVar = this.zzh;
        if (zzihVar != null) {
            zzihVar.zzA(this);
            this.zzh.zzz();
            this.zzh = null;
            zzcbb.zzE().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzI(long j10) {
        zzj zzjVar = (zzj) this.zzh;
        zzjVar.zza(zzjVar.zzd(), j10, 5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzJ(int i10) {
        this.zzc.zzk(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzK(int i10) {
        this.zzc.zzl(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzL(zzcba zzcbaVar) {
        this.zzk = zzcbaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzM(int i10) {
        this.zzc.zzm(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzN(int i10) {
        this.zzc.zzn(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzO(boolean z10) {
        this.zzh.zzq(z10);
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzP(@Nullable Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzQ(boolean z10) {
        if (this.zzh == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            this.zzh.zzx();
            if (i10 >= 2) {
                return;
            }
            zzxt zzxtVar = this.zzd;
            zzxg zzxgVarZzc = zzxtVar.zzf().zzc();
            zzxgVarZzc.zzp(i10, !z10);
            zzxtVar.zzl(zzxgVarZzc);
            i10++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzR(int i10) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcdg zzcdgVar = (zzcdg) ((WeakReference) it.next()).get();
            if (zzcdgVar != null) {
                zzcdgVar.zzm(i10);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzS(Surface surface, boolean z10) {
        zzih zzihVar = this.zzh;
        if (zzihVar != null) {
            zzihVar.zzr(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzT(float f10, boolean z10) {
        zzih zzihVar = this.zzh;
        if (zzihVar != null) {
            zzihVar.zzs(f10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final void zzU() {
        this.zzh.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final boolean zzV() {
        return this.zzh != null;
    }

    final /* synthetic */ zzfs zzW(String str, boolean z10) {
        zzcdw zzcdwVar = true != z10 ? null : this;
        zzcbj zzcbjVar = this.zze;
        return new zzcdz(str, zzcdwVar, zzcbjVar.zzd, zzcbjVar.zze, zzcbjVar.zzm, zzcbjVar.zzn);
    }

    final /* synthetic */ zzfs zzX(String str, boolean z10) {
        zzcdw zzcdwVar = true != z10 ? null : this;
        zzcbj zzcbjVar = this.zze;
        zzcdg zzcdgVar = new zzcdg(str, zzcdwVar, zzcbjVar.zzd, zzcbjVar.zze, zzcbjVar.zzh);
        this.zzu.add(new WeakReference(zzcdgVar));
        return zzcdgVar;
    }

    final /* synthetic */ zzfs zzY(String str, boolean z10) {
        zzgb zzgbVar = new zzgb();
        zzgbVar.zzf(str);
        zzgbVar.zze(true != z10 ? null : this);
        zzgbVar.zzc(this.zze.zzd);
        zzgbVar.zzd(this.zze.zze);
        zzgbVar.zzb(true);
        return zzgbVar.zza();
    }

    final /* synthetic */ zzfs zzZ(zzfr zzfrVar) {
        zzfs zzfsVarZza = zzfrVar.zza();
        zzcdu zzcduVar = new zzcdu(this);
        return new zzcdj(this.zzb, zzfsVarZza, this.zzo, this.zzp, this, zzcduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zza(zzfs zzfsVar, zzfy zzfyVar, boolean z10, int i10) {
        this.zzl += i10;
    }

    @VisibleForTesting
    final zzuk zzaa(Uri uri) {
        zzam zzamVar = new zzam();
        zzamVar.zzb(uri);
        zzbc zzbcVarZzc = zzamVar.zzc();
        zzvm zzvmVar = this.zzg;
        zzvmVar.zza(this.zze.zzf);
        return zzvmVar.zzb(zzbcVarZzc);
    }

    final /* synthetic */ void zzab(boolean z10, long j10) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzi(z10, j10);
        }
    }

    final /* synthetic */ zzle[] zzac(Handler handler, zzaay zzaayVar, zzpe zzpeVar, zzwl zzwlVar, zztg zztgVar) {
        zzsq zzsqVar = zzsq.zza;
        Context context = this.zzb;
        zzqv zzqvVar = new zzqv(context, new zzry(context), zzsqVar, false, handler, zzpeVar, new zzqb(context).zzc());
        Context context2 = this.zzb;
        return new zzle[]{zzqvVar, new zzaaa(context2, new zzry(context2), zzsqVar, 0L, false, handler, zzaayVar, -1, 30.0f)};
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzd(zzfs zzfsVar, zzfy zzfyVar, boolean z10) {
        if (zzfsVar instanceof zzgp) {
            synchronized (this.zzq) {
                this.zzs.add((zzgp) zzfsVar);
            }
        } else if (zzfsVar instanceof zzcdj) {
            this.zzt = (zzcdj) zzfsVar;
            final zzcbk zzcbkVar = (zzcbk) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue() && zzcbkVar != null && this.zzt.zzn()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcds
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i10 = zzcdw.zza;
                        zzcbkVar.zzd("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zze(zzlo zzloVar, zzaf zzafVar, @Nullable zzho zzhoVar) {
        zzcbk zzcbkVar = (zzcbk) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue() || zzcbkVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzafVar.zzl;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzafVar.zzm;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzafVar.zzj;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzcbkVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzh(zzlo zzloVar, int i10, long j10) {
        this.zzm += i10;
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzj(zzlo zzloVar, zztz zztzVar, zzue zzueVar, IOException iOException, boolean z10) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            if (this.zze.zzj) {
                zzcbaVar.zzl("onLoadException", iOException);
            } else {
                zzcbaVar.zzk("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzk(zzlo zzloVar, int i10) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzm(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzl(zzlo zzloVar, zzbp zzbpVar) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzk("onPlayerError", zzbpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzn(zzlo zzloVar, Object obj, long j10) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzp(zzlo zzloVar, zzaf zzafVar, @Nullable zzho zzhoVar) {
        zzcbk zzcbkVar = (zzcbk) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue() || zzcbkVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzafVar.zzt));
        map.put("bitRate", String.valueOf(zzafVar.zzi));
        map.put("resolution", zzafVar.zzr + ViewHierarchyNode.JsonKeys.X + zzafVar.zzs);
        String str = zzafVar.zzl;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzafVar.zzm;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzafVar.zzj;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzcbkVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzq(zzlo zzloVar, zzcp zzcpVar) {
        zzcba zzcbaVar = this.zzk;
        if (zzcbaVar != null) {
            zzcbaVar.zzD(zzcpVar.zzb, zzcpVar.zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final int zzr() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final int zzt() {
        return this.zzh.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzv() {
        return this.zzh.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzw() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min(this.zzl, this.zzt.zzk());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzy() {
        return this.zzh.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcbb
    public final long zzz() {
        return this.zzh.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzg(zzlo zzloVar, zzue zzueVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzi(zzbw zzbwVar, zzlp zzlpVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzo(zzlo zzloVar, zzhn zzhnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzb(zzfs zzfsVar, zzfy zzfyVar, boolean z10) {
    }

    @Override // com.google.android.gms.internal.ads.zzgu
    public final void zzc(zzfs zzfsVar, zzfy zzfyVar, boolean z10) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzf(zzlo zzloVar, int i10, long j10, long j11) {
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final /* synthetic */ void zzm(zzlo zzloVar, zzbv zzbvVar, zzbv zzbvVar2, int i10) {
    }
}

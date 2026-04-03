package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.unity3d.services.UnityAdsConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccc extends zzcaq implements TextureView.SurfaceTextureListener, zzcba {
    private final zzcbk zzc;
    private final zzcbl zzd;
    private final zzcbj zze;
    private zzcap zzf;
    private Surface zzg;
    private zzcbb zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl;
    private zzcbi zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzccc(Context context, zzcbl zzcblVar, zzcbk zzcbkVar, boolean z10, boolean z11, zzcbj zzcbjVar) {
        super(context);
        this.zzl = 1;
        this.zzc = zzcbkVar;
        this.zzd = zzcblVar;
        this.zzn = z10;
        this.zze = zzcbjVar;
        setSurfaceTextureListener(this);
        zzcblVar.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        return str + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzU() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzQ(true);
        }
    }

    private final void zzV() {
        if (this.zzo) {
            return;
        }
        this.zzo = true;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzccb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzI();
            }
        });
        zzn();
        this.zzd.zzb();
        if (this.zzp) {
            zzp();
        }
    }

    private final void zzW(boolean z10, @Nullable Integer num) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null && !z10) {
            zzcbbVar.zzP(num);
            return;
        }
        if (this.zzi == null || this.zzg == null) {
            return;
        }
        if (z10) {
            if (!zzad()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcbbVar.zzU();
                zzY();
            }
        }
        if (this.zzi.startsWith("cache:")) {
            zzccv zzccvVarZzp = this.zzc.zzp(this.zzi);
            if (zzccvVarZzp instanceof zzcde) {
                zzcbb zzcbbVarZza = ((zzcde) zzccvVarZzp).zza();
                this.zzh = zzcbbVarZza;
                zzcbbVarZza.zzP(num);
                if (!this.zzh.zzV()) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzccvVarZzp instanceof zzcdb)) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
                zzcdb zzcdbVar = (zzcdb) zzccvVarZzp;
                String strZzF = zzF();
                ByteBuffer byteBufferZzk = zzcdbVar.zzk();
                boolean zZzl = zzcdbVar.zzl();
                String strZzi = zzcdbVar.zzi();
                if (strZzi == null) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Stream cache URL is null.");
                    return;
                } else {
                    zzcbb zzcbbVarZzE = zzE(num);
                    this.zzh = zzcbbVarZzE;
                    zzcbbVarZzE.zzG(new Uri[]{Uri.parse(strZzi)}, strZzF, byteBufferZzk, zZzl);
                }
            }
        } else {
            this.zzh = zzE(num);
            String strZzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzj.length];
            int i10 = 0;
            while (true) {
                String[] strArr = this.zzj;
                if (i10 >= strArr.length) {
                    break;
                }
                uriArr[i10] = Uri.parse(strArr[i10]);
                i10++;
            }
            this.zzh.zzF(uriArr, strZzF2);
        }
        this.zzh.zzL(this);
        zzZ(this.zzg, false);
        if (this.zzh.zzV()) {
            int iZzt = this.zzh.zzt();
            this.zzl = iZzt;
            if (iZzt == 3) {
                zzV();
            }
        }
    }

    private final void zzX() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ(null, true);
            zzcbb zzcbbVar = this.zzh;
            if (zzcbbVar != null) {
                zzcbbVar.zzL(null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z10) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcbbVar.zzS(surface, z10);
        } catch (IOException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e10);
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i10, int i11) {
        float f10 = i11 > 0 ? i10 / i11 : 1.0f;
        if (this.zzs != f10) {
            this.zzs = f10;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcbb zzcbbVar = this.zzh;
        return (zzcbbVar == null || !zzcbbVar.zzV() || this.zzk) ? false : true;
    }

    @Override // android.view.View
    protected final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f10 = this.zzs;
        if (f10 != 0.0f && this.zzm == null) {
            float f11 = measuredWidth;
            float f12 = f11 / measuredHeight;
            if (f10 > f12) {
                measuredHeight = (int) (f11 / f10);
            }
            if (f10 < f12) {
                measuredWidth = (int) (measuredHeight * f10);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        if (this.zzn) {
            zzcbi zzcbiVar = new zzcbi(getContext());
            this.zzm = zzcbiVar;
            zzcbiVar.zzd(surfaceTexture, i10, i11);
            this.zzm.start();
            SurfaceTexture surfaceTextureZzb = this.zzm.zzb();
            if (surfaceTextureZzb != null) {
                surfaceTexture = surfaceTextureZzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i10, i11);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcby
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ(null, true);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzN();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i10, final int i11) {
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zzc(i10, i11);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbt
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzO(i10, i11);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i10) {
        com.google.android.gms.ads.internal.util.zze.zza("AdExoPlayerView3 window visibility changed to " + i10);
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzQ(i10);
            }
        });
        super.onWindowVisibilityChanged(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzA(int i10) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzN(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzB(int i10) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzR(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzC(@Nullable String str, @Nullable String[] strArr, @Nullable Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzj = new String[]{str};
        } else {
            this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzi;
        boolean z10 = this.zze.zzk && str2 != null && !str.equals(str2) && this.zzl == 4;
        this.zzi = str;
        zzW(z10, num);
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzD(int i10, int i11) {
        this.zzq = i10;
        this.zzr = i11;
        zzaa();
    }

    final zzcbb zzE(@Nullable Integer num) {
        zzcbj zzcbjVar = this.zze;
        zzcbk zzcbkVar = this.zzc;
        zzcdw zzcdwVar = new zzcdw(zzcbkVar.getContext(), zzcbjVar, zzcbkVar, num);
        com.google.android.gms.ads.internal.util.client.zzm.zzi("ExoPlayerAdapter initialized.");
        return zzcdwVar;
    }

    final String zzF() {
        zzcbk zzcbkVar = this.zzc;
        return com.google.android.gms.ads.internal.zzu.zzp().zzc(zzcbkVar.getContext(), zzcbkVar.zzn().afmaVersion);
    }

    final /* synthetic */ void zzG(String str) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzb("ExoPlayerAdapter error", str);
        }
    }

    final /* synthetic */ void zzH() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zza();
        }
    }

    final /* synthetic */ void zzI() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzf();
        }
    }

    final /* synthetic */ void zzJ(boolean z10, long j10) {
        this.zzc.zzv(z10, j10);
    }

    final /* synthetic */ void zzK(String str) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzc("ExoPlayerAdapter exception", str);
        }
    }

    final /* synthetic */ void zzL() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzg();
        }
    }

    final /* synthetic */ void zzM() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzh();
        }
    }

    final /* synthetic */ void zzN() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzi();
        }
    }

    final /* synthetic */ void zzO(int i10, int i11) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzj(i10, i11);
        }
    }

    final /* synthetic */ void zzP() {
        float fZza = this.zzb.zza();
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcbbVar.zzT(fZza, false);
        } catch (IOException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e10);
        }
    }

    final /* synthetic */ void zzQ(int i10) {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.onWindowVisibilityChanged(i10);
        }
    }

    final /* synthetic */ void zzR() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zzd();
        }
    }

    final /* synthetic */ void zzS() {
        zzcap zzcapVar = this.zzf;
        if (zzcapVar != null) {
            zzcapVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zzb() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzr();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zzd() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final int zze() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final long zzf() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzx();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final long zzg() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzA();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final long zzh() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzB();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzi(final boolean z10, final long j10) {
        if (this.zzc != null) {
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzJ(z10, j10);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzk(String str, Exception exc) {
        final String strZzT = zzT(str, exc);
        com.google.android.gms.ads.internal.util.client.zzm.zzj("ExoPlayerAdapter error: ".concat(strZzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(strZzT);
            }
        });
        com.google.android.gms.ads.internal.zzu.zzo().zzv(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzl(String str, Exception exc) {
        final String strZzT = zzT("onLoadException", exc);
        com.google.android.gms.ads.internal.util.client.zzm.zzj("ExoPlayerAdapter exception: ".concat(strZzT));
        com.google.android.gms.ads.internal.zzu.zzo().zzv(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK(strZzT);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzm(int i10) {
        if (this.zzl != i10) {
            this.zzl = i10;
            if (i10 == 3) {
                zzV();
                return;
            }
            if (i10 != 4) {
                return;
            }
            if (this.zze.zza) {
                zzX();
            }
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcca
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzH();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq, com.google.android.gms.internal.ads.zzcbn
    public final void zzn() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzP();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbx
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzR();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzp() {
        if (!zzac()) {
            this.zzp = true;
            return;
        }
        if (this.zze.zza) {
            zzU();
        }
        this.zzh.zzO(true);
        this.zzd.zzc();
        this.zzb.zzb();
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzS();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzq(int i10) {
        if (zzac()) {
            this.zzh.zzI(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzr(zzcap zzcapVar) {
        this.zzf = zzcapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzs(@Nullable String str) {
        if (str != null) {
            zzC(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzu(float f10, float f11) {
        zzcbi zzcbiVar = this.zzm;
        if (zzcbiVar != null) {
            zzcbiVar.zzf(f10, f11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzv() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzL();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    @Nullable
    public final Integer zzw() {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            return zzcbbVar.zzC();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzx(int i10) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzJ(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzy(int i10) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzK(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaq
    public final void zzz(int i10) {
        zzcbb zzcbbVar = this.zzh;
        if (zzcbbVar != null) {
            zzcbbVar.zzM(i10);
        }
    }
}

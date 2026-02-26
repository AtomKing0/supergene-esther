package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.v8;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcay extends FrameLayout implements zzcap {

    @VisibleForTesting
    final zzcbm zza;
    private final zzcbk zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbcl zze;
    private final long zzf;

    @Nullable
    private final zzcaq zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcay(Context context, zzcbk zzcbkVar, int i10, boolean z10, zzbcl zzbclVar, zzcbj zzcbjVar) {
        super(context);
        this.zzb = zzcbkVar;
        this.zze = zzbclVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzcbkVar.zzj());
        zzcar zzcarVar = zzcbkVar.zzj().zza;
        zzcaq zzcccVar = i10 == 2 ? new zzccc(context, new zzcbl(context, zzcbkVar.zzn(), zzcbkVar.zzdi(), zzbclVar, zzcbkVar.zzk()), zzcbkVar, z10, zzcar.zza(zzcbkVar), zzcbjVar) : new zzcao(context, zzcbkVar, z10, zzcar.zza(zzcbkVar), zzcbjVar, new zzcbl(context, zzcbkVar.zzn(), zzcbkVar.zzdi(), zzbclVar, zzcbkVar.zzk()));
        this.zzg = zzcccVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcccVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzz)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzw)).booleanValue()) {
            zzn();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzB)).longValue();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzy)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbclVar != null) {
            zzbclVar.zzd("spinner_used", true != zBooleanValue ? "0" : "1");
        }
        this.zza = new zzcbm(this);
        zzcccVar.zzr(this);
    }

    private final void zzJ() {
        if (this.zzb.zzi() == null || !this.zzi || this.zzj) {
            return;
        }
        this.zzb.zzi().getWindow().clearFlags(128);
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzK(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zzd("onVideoEvent", map);
    }

    private final boolean zzL() {
        return this.zzq.getParent() != null;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzcaq zzcaqVar = this.zzg;
            if (zzcaqVar != null) {
                zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcas
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcaqVar.zzt();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcau
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzq(z10);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcap
    public final void onWindowVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            this.zza.zzb();
            z10 = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z10 = false;
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcax(this, z10));
    }

    public final void zzA(int i10) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzz(i10);
    }

    public final void zzB(int i10) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzA(i10);
    }

    public final void zzC(int i10) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzz)).booleanValue()) {
            this.zzc.setBackgroundColor(i10);
            this.zzd.setBackgroundColor(i10);
        }
    }

    public final void zzD(int i10) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzB(i10);
    }

    public final void zzE(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzF(int i10, int i11, int i12, int i13) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Set video bounds to x:" + i10 + ";y:" + i11 + ";w:" + i12 + ";h:" + i13);
        }
        if (i12 == 0 || i13 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i12, i13);
        layoutParams.setMargins(i10, i11, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzG(float f10) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzb.zze(f10);
        zzcaqVar.zzn();
    }

    public final void zzH(float f10, float f11) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null) {
            zzcaqVar.zzu(f10, f11);
        }
    }

    public final void zzI() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzb.zzd(false);
        zzcaqVar.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbI)).booleanValue()) {
            this.zza.zza();
        }
        zzK(v8.h.f15792g0, new String[0]);
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzb(String str, @Nullable String str2) {
        zzK("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzc(String str, @Nullable String str2) {
        zzK("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzd() {
        zzK("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbI)).booleanValue()) {
            this.zza.zzb();
        }
        if (this.zzb.zzi() != null && !this.zzi) {
            boolean z10 = (this.zzb.zzi().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z10;
            if (!z10) {
                this.zzb.zzi().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzf() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null && this.zzm == 0) {
            float fZzc = zzcaqVar.zzc();
            zzcaq zzcaqVar2 = this.zzg;
            zzK("canplaythrough", "duration", String.valueOf(fZzc / 1000.0f), "videoWidth", String.valueOf(zzcaqVar2.zze()), "videoHeight", String.valueOf(zzcaqVar2.zzd()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzg() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcat
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzp();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzh() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcav(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzi() {
        if (this.zzr && this.zzp != null && !zzL()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzc.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzc.bringChildToFront(this.zzq);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcaw(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzj(int i10, int i11) {
        if (this.zzk) {
            zzbbn zzbbnVar = zzbbw.zzA;
            int iMax = Math.max(i10 / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).intValue(), 1);
            int iMax2 = Math.max(i11 / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcap
    public final void zzk() {
        if (this.zzh && zzL()) {
            this.zzc.removeView(this.zzq);
        }
        if (this.zzg == null || this.zzp == null) {
            return;
        }
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
        if (this.zzg.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Spinner frame grab took " + jElapsedRealtime2 + "ms");
        }
        if (jElapsedRealtime2 > this.zzf) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbcl zzbclVar = this.zze;
            if (zzbclVar != null) {
                zzbclVar.zzd("spinner_jank", Long.toString(jElapsedRealtime2));
            }
        }
    }

    @Nullable
    public final Integer zzl() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null) {
            return zzcaqVar.zzw();
        }
        return null;
    }

    public final void zzn() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        TextView textView = new TextView(zzcaqVar.getContext());
        Resources resourcesZze = com.google.android.gms.ads.internal.zzu.zzo().zze();
        textView.setText(String.valueOf(resourcesZze == null ? "AdMob - " : resourcesZze.getString(R.string.watermark_label_prefix)).concat(this.zzg.zzj()));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(-256);
        this.zzc.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzc.bringChildToFront(textView);
    }

    public final void zzo() {
        this.zza.zza();
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar != null) {
            zzcaqVar.zzt();
        }
        zzJ();
    }

    final /* synthetic */ void zzp() {
        zzK("firstFrameRendered", new String[0]);
    }

    final /* synthetic */ void zzq(boolean z10) {
        zzK("windowFocusChanged", "hasWindowFocus", String.valueOf(z10));
    }

    public final void zzr(Integer num) {
        if (this.zzg == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzK("no_src", new String[0]);
        } else {
            this.zzg.zzC(this.zzn, this.zzo, num);
        }
    }

    public final void zzs() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzb.zzd(true);
        zzcaqVar.zzn();
    }

    final void zzt() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        long jZza = zzcaqVar.zza();
        if (this.zzl == jZza || jZza <= 0) {
            return;
        }
        float f10 = jZza / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue()) {
            zzK("timeupdate", "time", String.valueOf(f10), "totalBytes", String.valueOf(this.zzg.zzh()), "qoeCachedBytes", String.valueOf(this.zzg.zzf()), "qoeLoadedBytes", String.valueOf(this.zzg.zzg()), "droppedFrames", String.valueOf(this.zzg.zzb()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis()));
        } else {
            zzK("timeupdate", "time", String.valueOf(f10));
        }
        this.zzl = jZza;
    }

    public final void zzu() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzo();
    }

    public final void zzv() {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzp();
    }

    public final void zzw(int i10) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzq(i10);
    }

    public final void zzx(MotionEvent motionEvent) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzy(int i10) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzx(i10);
    }

    public final void zzz(int i10) {
        zzcaq zzcaqVar = this.zzg;
        if (zzcaqVar == null) {
            return;
        }
        zzcaqVar.zzy(i10);
    }
}

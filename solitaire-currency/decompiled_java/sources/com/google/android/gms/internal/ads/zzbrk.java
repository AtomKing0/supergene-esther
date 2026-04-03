package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.util.CollectionUtils;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbrk extends zzbrq {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcej zzj;
    private final Activity zzk;
    private zzcgd zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbrr zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.setOf(v8.e.f15739c, v8.e.f15738b, "top-center", TtmlNode.CENTER, v8.e.f15741e, v8.e.f15740d, "bottom-center");
    }

    public zzbrk(zzcej zzcejVar, zzbrr zzbrrVar) {
        super(zzcejVar, "resize");
        this.zza = v8.e.f15738b;
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzcejVar;
        this.zzk = zzcejVar.zzi();
        this.zzo = zzbrrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzc(boolean z10) {
        this.zzp.dismiss();
        this.zzq.removeView((View) this.zzj);
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            this.zzr.addView((View) this.zzj);
            this.zzj.zzaj(this.zzl);
        }
        if (z10) {
            zzl("default");
            zzbrr zzbrrVar = this.zzo;
            if (zzbrrVar != null) {
                zzbrrVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    public final void zza(final boolean z10) {
        synchronized (this.zzi) {
            if (this.zzp != null) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjU)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzc(z10);
                } else {
                    zzbzo.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbri
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzc(z10);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:129:0x025e A[Catch: all -> 0x047d, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00ef, B:46:0x00f3, B:48:0x00fb, B:51:0x0103, B:55:0x0129, B:61:0x0135, B:129:0x025e, B:130:0x0263, B:132:0x0265, B:134:0x0285, B:136:0x0289, B:138:0x0296, B:140:0x02d2, B:172:0x038b, B:179:0x03ba, B:180:0x03d2, B:181:0x03f3, B:183:0x03fb, B:184:0x0402, B:185:0x0429, B:188:0x042c, B:190:0x0451, B:191:0x0466, B:173:0x0392, B:174:0x0399, B:175:0x03a0, B:176:0x03a7, B:177:0x03ad, B:178:0x03b4, B:139:0x02cf, B:193:0x0468, B:194:0x046d, B:62:0x013c, B:64:0x0140, B:92:0x0193, B:100:0x01e3, B:102:0x01ee, B:104:0x01f1, B:106:0x01f4, B:108:0x01f8, B:111:0x01fe, B:93:0x019e, B:95:0x01b4, B:97:0x01bf, B:94:0x01a9, B:96:0x01b7, B:98:0x01c4, B:99:0x01d8, B:101:0x01e6, B:112:0x020f, B:118:0x0239, B:124:0x0249, B:121:0x023f, B:123:0x0247, B:115:0x0231, B:117:0x0237, B:125:0x0250, B:126:0x0256, B:196:0x046f, B:197:0x0474, B:199:0x0476, B:200:0x047b), top: B:205:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0265 A[Catch: all -> 0x047d, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00ef, B:46:0x00f3, B:48:0x00fb, B:51:0x0103, B:55:0x0129, B:61:0x0135, B:129:0x025e, B:130:0x0263, B:132:0x0265, B:134:0x0285, B:136:0x0289, B:138:0x0296, B:140:0x02d2, B:172:0x038b, B:179:0x03ba, B:180:0x03d2, B:181:0x03f3, B:183:0x03fb, B:184:0x0402, B:185:0x0429, B:188:0x042c, B:190:0x0451, B:191:0x0466, B:173:0x0392, B:174:0x0399, B:175:0x03a0, B:176:0x03a7, B:177:0x03ad, B:178:0x03b4, B:139:0x02cf, B:193:0x0468, B:194:0x046d, B:62:0x013c, B:64:0x0140, B:92:0x0193, B:100:0x01e3, B:102:0x01ee, B:104:0x01f1, B:106:0x01f4, B:108:0x01f8, B:111:0x01fe, B:93:0x019e, B:95:0x01b4, B:97:0x01bf, B:94:0x01a9, B:96:0x01b7, B:98:0x01c4, B:99:0x01d8, B:101:0x01e6, B:112:0x020f, B:118:0x0239, B:124:0x0249, B:121:0x023f, B:123:0x0247, B:115:0x0231, B:117:0x0237, B:125:0x0250, B:126:0x0256, B:196:0x046f, B:197:0x0474, B:199:0x0476, B:200:0x047b), top: B:205:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(java.util.Map r18) {
        /*
            Method dump skipped, instruction units count: 1204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrk.zzb(java.util.Map):void");
    }

    public final void zzd(int i10, int i11, boolean z10) {
        synchronized (this.zzi) {
            this.zzc = i10;
            this.zzd = i11;
        }
    }

    public final void zze(int i10, int i11) {
        this.zzc = i10;
        this.zzd = i11;
    }

    public final boolean zzf() {
        boolean z10;
        synchronized (this.zzi) {
            z10 = this.zzp != null;
        }
        return z10;
    }
}

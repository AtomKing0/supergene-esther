package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.webkit.internal.AssetHelper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdve;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzau {
    private final Context zza;
    private final zzdvi zzb;
    private String zzc;
    private String zzd;
    private String zze;

    @Nullable
    private String zzf;
    private int zzg;
    private int zzh;
    private PointF zzi;
    private PointF zzj;
    private Handler zzk;
    private Runnable zzl;

    public zzau(Context context) {
        this.zzg = 0;
        this.zzl = new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzah
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg();
            }
        };
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzu.zzt().zzb();
        this.zzk = com.google.android.gms.ads.internal.zzu.zzt().zza();
        this.zzb = com.google.android.gms.ads.internal.zzu.zzs().zza();
    }

    private final void zzs(Context context) {
        ArrayList arrayList = new ArrayList();
        int iZzu = zzu(arrayList, "None", true);
        final int iZzu2 = zzu(arrayList, "Shake", true);
        final int iZzu3 = zzu(arrayList, "Flick", true);
        int iOrdinal = this.zzb.zza().ordinal();
        final int i10 = iOrdinal != 1 ? iOrdinal != 2 ? iZzu : iZzu3 : iZzu2;
        com.google.android.gms.ads.internal.zzu.zzp();
        AlertDialog.Builder builderZzK = zzt.zzK(context);
        final AtomicInteger atomicInteger = new AtomicInteger(i10);
        builderZzK.setTitle("Setup gesture");
        builderZzK.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i10, new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                atomicInteger.set(i11);
            }
        });
        builderZzK.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzaq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.zza.zzr();
            }
        });
        builderZzK.setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzar
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.zza.zzh(atomicInteger, i10, iZzu2, iZzu3, dialogInterface, i11);
            }
        });
        builderZzK.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.ads.internal.util.zzas
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.zza.zzr();
            }
        });
        builderZzK.create().show();
    }

    private final boolean zzt(float f10, float f11, float f12, float f13) {
        return Math.abs(this.zzi.x - f10) < ((float) this.zzh) && Math.abs(this.zzi.y - f11) < ((float) this.zzh) && Math.abs(this.zzj.x - f12) < ((float) this.zzh) && Math.abs(this.zzj.y - f13) < ((float) this.zzh);
    }

    private static final int zzu(List list, String str, boolean z10) {
        if (!z10) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzd);
        sb.append("}");
        return sb.toString();
    }

    final /* synthetic */ void zza() {
        zzs(this.zza);
    }

    final /* synthetic */ void zzb() {
        zzs(this.zza);
    }

    final /* synthetic */ void zzc(zzgcu zzgcuVar) {
        if (com.google.android.gms.ads.internal.zzu.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzan
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzu.zzs().zzd(this.zza, this.zzd, this.zze);
        }
    }

    final /* synthetic */ void zzd(zzgcu zzgcuVar) {
        if (com.google.android.gms.ads.internal.zzu.zzs().zzj(this.zza, this.zzd, this.zze)) {
            zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzam
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf();
                }
            });
        } else {
            com.google.android.gms.ads.internal.zzu.zzs().zzd(this.zza, this.zzd, this.zze);
        }
    }

    final /* synthetic */ void zze() {
        com.google.android.gms.ads.internal.zzu.zzs().zzc(this.zza);
    }

    final /* synthetic */ void zzf() {
        com.google.android.gms.ads.internal.zzu.zzs().zzc(this.zza);
    }

    final /* synthetic */ void zzg() {
        this.zzg = 4;
        zzr();
    }

    final /* synthetic */ void zzh(AtomicInteger atomicInteger, int i10, int i11, int i12, DialogInterface dialogInterface, int i13) {
        if (atomicInteger.get() != i10) {
            if (atomicInteger.get() == i11) {
                this.zzb.zzm(zzdve.SHAKE);
            } else if (atomicInteger.get() == i12) {
                this.zzb.zzm(zzdve.FLICK);
            } else {
                this.zzb.zzm(zzdve.NONE);
            }
        }
        zzr();
    }

    final /* synthetic */ void zzi(String str, DialogInterface dialogInterface, int i10) {
        com.google.android.gms.ads.internal.zzu.zzp();
        zzt.zzT(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType(AssetHelper.DEFAULT_MIME_TYPE).putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    final /* synthetic */ void zzj(int i10, int i11, int i12, int i13, int i14, DialogInterface dialogInterface, int i15) {
        if (i15 != i10) {
            if (i15 == i11) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Debug mode [Creative Preview] selected.");
                zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzai
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzl();
                    }
                });
                return;
            }
            if (i15 == i12) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Debug mode [Troubleshooting] selected.");
                zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzag
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzk();
                    }
                });
                return;
            }
            if (i15 == i13) {
                zzdvi zzdviVar = this.zzb;
                final zzgcu zzgcuVar = zzbzo.zze;
                zzgcu zzgcuVar2 = zzbzo.zza;
                if (zzdviVar.zzq()) {
                    zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzat
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze();
                        }
                    });
                    return;
                } else {
                    zzgcuVar2.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzaf
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzd(zzgcuVar);
                        }
                    });
                    return;
                }
            }
            if (i15 == i14) {
                zzdvi zzdviVar2 = this.zzb;
                final zzgcu zzgcuVar3 = zzbzo.zze;
                zzgcu zzgcuVar4 = zzbzo.zza;
                if (zzdviVar2.zzq()) {
                    zzgcuVar3.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzae
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zza();
                        }
                    });
                    return;
                } else {
                    zzgcuVar4.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzal
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzc(zzgcuVar3);
                        }
                    });
                    return;
                }
            }
            return;
        }
        if (!(this.zza instanceof Activity)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzi("Can not create dialog without Activity Context");
            return;
        }
        String str = this.zzc;
        final String str2 = "No debug information";
        if (!TextUtils.isEmpty(str)) {
            Uri uriBuild = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
            StringBuilder sb = new StringBuilder();
            com.google.android.gms.ads.internal.zzu.zzp();
            Map mapZzP = zzt.zzP(uriBuild);
            for (String str3 : mapZzP.keySet()) {
                sb.append(str3);
                sb.append(" = ");
                sb.append((String) mapZzP.get(str3));
                sb.append("\n\n");
            }
            String strTrim = sb.toString().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                str2 = strTrim;
            }
        }
        com.google.android.gms.ads.internal.zzu.zzp();
        AlertDialog.Builder builderZzK = zzt.zzK(this.zza);
        builderZzK.setMessage(str2);
        builderZzK.setTitle("Ad Information");
        builderZzK.setPositiveButton("Share", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzaj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i16) {
                this.zza.zzi(str2, dialogInterface2, i16);
            }
        });
        builderZzK.setNegativeButton("Close", new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzak
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface2, int i16) {
            }
        });
        builderZzK.create().show();
    }

    final /* synthetic */ void zzk() {
        zzay zzayVarZzs = com.google.android.gms.ads.internal.zzu.zzs();
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zZzm = zzayVarZzs.zzm();
        Context context = this.zza;
        zzayVarZzs.zzh(zzayVarZzs.zzj(context, str, str2));
        if (!zzayVarZzs.zzm()) {
            zzayVarZzs.zzd(context, str, str2);
            return;
        }
        if (!zZzm && !TextUtils.isEmpty(str3)) {
            zzayVarZzs.zze(context, str2, str3, str);
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Device is linked for debug signals.");
        zzayVarZzs.zzi(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    final /* synthetic */ void zzl() {
        zzay zzayVarZzs = com.google.android.gms.ads.internal.zzu.zzs();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzayVarZzs.zzk(context, str, str2)) {
            zzayVarZzs.zzi(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(zzayVarZzs.zza)) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Creative is not pushed for this device.");
            zzayVarZzs.zzi(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(zzayVarZzs.zza)) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("The app is not linked for creative preview.");
            zzayVarZzs.zzd(context, str, str2);
        } else if ("0".equals(zzayVarZzs.zza)) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Device is linked for in app preview.");
            zzayVarZzs.zzi(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zzm(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i10 = this.zzg;
        if (i10 == -1) {
            return;
        }
        if (i10 == 0) {
            if (actionMasked == 5) {
                this.zzg = 5;
                this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.zzk.postDelayed(this.zzl, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeg)).longValue());
                return;
            }
            return;
        }
        if (i10 == 5) {
            if (pointerCount == 2) {
                if (actionMasked != 2) {
                    return;
                }
                boolean z10 = false;
                for (int i11 = 0; i11 < historySize; i11++) {
                    z10 |= !zzt(motionEvent.getHistoricalX(0, i11), motionEvent.getHistoricalY(0, i11), motionEvent.getHistoricalX(1, i11), motionEvent.getHistoricalY(1, i11));
                }
                if (zzt(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z10) {
                    return;
                }
            }
            this.zzg = -1;
            this.zzk.removeCallbacks(this.zzl);
        }
    }

    public final void zzn(String str) {
        this.zzd = str;
    }

    public final void zzo(String str) {
        this.zze = str;
    }

    public final void zzp(String str) {
        this.zzc = str;
    }

    public final void zzq(String str) {
        this.zzf = str;
    }

    public final void zzr() {
        try {
            if (!(this.zza instanceof Activity)) {
                com.google.android.gms.ads.internal.util.client.zzm.zzi("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(com.google.android.gms.ads.internal.zzu.zzs().zzb())) {
                str = "Creative preview";
            }
            String str2 = true != com.google.android.gms.ads.internal.zzu.zzs().zzm() ? "Troubleshooting" : "Troubleshooting (enabled)";
            ArrayList arrayList = new ArrayList();
            final int iZzu = zzu(arrayList, "Ad information", true);
            final int iZzu2 = zzu(arrayList, str, true);
            final int iZzu3 = zzu(arrayList, str2, true);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzip)).booleanValue();
            final int iZzu4 = zzu(arrayList, "Open ad inspector", zBooleanValue);
            final int iZzu5 = zzu(arrayList, "Ad inspector settings", zBooleanValue);
            com.google.android.gms.ads.internal.zzu.zzp();
            AlertDialog.Builder builderZzK = zzt.zzK(this.zza);
            builderZzK.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.ads.internal.util.zzao
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.zza.zzj(iZzu, iZzu2, iZzu3, iZzu4, iZzu5, dialogInterface, i10);
                }
            });
            builderZzK.create().show();
        } catch (WindowManager.BadTokenException e10) {
            zze.zzb("", e10);
        }
    }

    public zzau(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}

package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbbw;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzs extends FrameLayout implements View.OnClickListener {
    private final ImageButton zza;
    private final zzae zzb;

    public zzs(Context context, zzr zzrVar, @Nullable zzae zzaeVar) {
        super(context);
        this.zzb = zzaeVar;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        zzc();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzay.zzb();
        int iZzy = com.google.android.gms.ads.internal.util.client.zzf.zzy(context, zzrVar.zza);
        zzay.zzb();
        int iZzy2 = com.google.android.gms.ads.internal.util.client.zzf.zzy(context, 0);
        zzay.zzb();
        int iZzy3 = com.google.android.gms.ads.internal.util.client.zzf.zzy(context, zzrVar.zzb);
        zzay.zzb();
        imageButton.setPadding(iZzy, iZzy2, iZzy3, com.google.android.gms.ads.internal.util.client.zzf.zzy(context, zzrVar.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzay.zzb();
        int iZzy4 = com.google.android.gms.ads.internal.util.client.zzf.zzy(context, zzrVar.zzd + zzrVar.zza + zzrVar.zzb);
        zzay.zzb();
        addView(imageButton, new FrameLayout.LayoutParams(iZzy4, com.google.android.gms.ads.internal.util.client.zzf.zzy(context, zzrVar.zzd + zzrVar.zzc), 17));
        long jLongValue = ((Long) zzba.zzc().zza(zzbbw.zzaT)).longValue();
        if (jLongValue <= 0) {
            return;
        }
        zzq zzqVar = ((Boolean) zzba.zzc().zza(zzbbw.zzaU)).booleanValue() ? new zzq(this) : null;
        imageButton.setAlpha(0.0f);
        imageButton.animate().alpha(1.0f).setDuration(jLongValue).setListener(zzqVar);
    }

    private final void zzc() {
        String str = (String) zzba.zzc().zza(zzbbw.zzaS);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || "default".equals(str)) {
            this.zza.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Resources resourcesZze = com.google.android.gms.ads.internal.zzu.zzo().zze();
        if (resourcesZze == null) {
            this.zza.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Drawable drawable = null;
        try {
            if ("white".equals(str)) {
                drawable = resourcesZze.getDrawable(com.google.android.gms.ads.impl.R.drawable.admob_close_button_white_circle_black_cross);
            } else if ("black".equals(str)) {
                drawable = resourcesZze.getDrawable(com.google.android.gms.ads.impl.R.drawable.admob_close_button_black_circle_white_cross);
            }
        } catch (Resources.NotFoundException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Close button resource not found, falling back to default.");
        }
        if (drawable == null) {
            this.zza.setImageResource(R.drawable.btn_dialog);
        } else {
            this.zza.setImageDrawable(drawable);
            this.zza.setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzae zzaeVar = this.zzb;
        if (zzaeVar != null) {
            zzaeVar.zzj();
        }
    }

    public final void zzb(boolean z10) {
        if (!z10) {
            this.zza.setVisibility(0);
            return;
        }
        this.zza.setVisibility(8);
        if (((Long) zzba.zzc().zza(zzbbw.zzaT)).longValue() > 0) {
            this.zza.animate().cancel();
            this.zza.clearAnimation();
        }
    }
}

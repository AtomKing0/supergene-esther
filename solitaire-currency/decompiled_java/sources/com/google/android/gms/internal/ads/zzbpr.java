package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbpr extends zzbpa {
    private final NativeAdMapper zza;

    public zzbpr(NativeAdMapper nativeAdMapper) {
        this.zza = nativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzA() {
        return this.zza.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzB() {
        return this.zza.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final double zze() {
        if (this.zza.getStarRating() != null) {
            return this.zza.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzf() {
        return this.zza.getMediaContentAspectRatio();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzg() {
        return this.zza.getCurrentTime();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzh() {
        return this.zza.getDuration();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final Bundle zzi() {
        return this.zza.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    @Nullable
    public final zzbew zzk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    @Nullable
    public final zzbfd zzl() {
        NativeAd.Image icon = this.zza.getIcon();
        if (icon != null) {
            return new zzbeq(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.zzb(), icon.zza());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    @Nullable
    public final IObjectWrapper zzm() {
        View adChoicesContent = this.zza.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    @Nullable
    public final IObjectWrapper zzn() {
        View viewZza = this.zza.zza();
        if (viewZza == null) {
            return null;
        }
        return ObjectWrapper.wrap(viewZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    @Nullable
    public final IObjectWrapper zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzp() {
        return this.zza.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzq() {
        return this.zza.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzr() {
        return this.zza.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzs() {
        return this.zza.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzt() {
        return this.zza.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzu() {
        return this.zza.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final List zzv() {
        List<NativeAd.Image> images = this.zza.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzbeq(image.getDrawable(), image.getUri(), image.getScale(), image.zzb(), image.zza()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zza.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzx() {
        this.zza.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        HashMap map = (HashMap) ObjectWrapper.unwrap(iObjectWrapper2);
        HashMap map2 = (HashMap) ObjectWrapper.unwrap(iObjectWrapper3);
        this.zza.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), map, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zza.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}

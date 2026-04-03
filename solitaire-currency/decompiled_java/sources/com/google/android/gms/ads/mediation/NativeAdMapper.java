package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAdMapper {
    private String zza;
    private List zzb;
    private String zzc;
    private NativeAd.Image zzd;
    private String zze;
    private String zzf;
    private Double zzg;
    private String zzh;
    private String zzi;
    private boolean zzj;
    private View zzk;
    private View zzl;
    private Bundle zzm = new Bundle();
    private boolean zzn;
    private boolean zzo;
    private float zzp;

    @NonNull
    public View getAdChoicesContent() {
        return this.zzk;
    }

    @NonNull
    public final String getAdvertiser() {
        return this.zzf;
    }

    @NonNull
    public final String getBody() {
        return this.zzc;
    }

    @NonNull
    public final String getCallToAction() {
        return this.zze;
    }

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    @NonNull
    public final Bundle getExtras() {
        return this.zzm;
    }

    @NonNull
    public final String getHeadline() {
        return this.zza;
    }

    @NonNull
    public final NativeAd.Image getIcon() {
        return this.zzd;
    }

    @NonNull
    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public float getMediaContentAspectRatio() {
        return this.zzp;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzo;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzn;
    }

    @NonNull
    public final String getPrice() {
        return this.zzi;
    }

    @NonNull
    public final Double getStarRating() {
        return this.zzg;
    }

    @NonNull
    public final String getStore() {
        return this.zzh;
    }

    public boolean hasVideoContent() {
        return this.zzj;
    }

    public void setAdChoicesContent(@NonNull View view) {
        this.zzk = view;
    }

    public final void setAdvertiser(@NonNull String str) {
        this.zzf = str;
    }

    public final void setBody(@NonNull String str) {
        this.zzc = str;
    }

    public final void setCallToAction(@NonNull String str) {
        this.zze = str;
    }

    public final void setExtras(@NonNull Bundle bundle) {
        this.zzm = bundle;
    }

    public void setHasVideoContent(boolean z10) {
        this.zzj = z10;
    }

    public final void setHeadline(@NonNull String str) {
        this.zza = str;
    }

    public final void setIcon(@NonNull NativeAd.Image image) {
        this.zzd = image;
    }

    public final void setImages(@NonNull List<NativeAd.Image> list) {
        this.zzb = list;
    }

    public void setMediaContentAspectRatio(float f10) {
        this.zzp = f10;
    }

    public void setMediaView(@NonNull View view) {
        this.zzl = view;
    }

    public final void setOverrideClickHandling(boolean z10) {
        this.zzo = z10;
    }

    public final void setOverrideImpressionRecording(boolean z10) {
        this.zzn = z10;
    }

    public final void setPrice(@NonNull String str) {
        this.zzi = str;
    }

    public final void setStarRating(@NonNull Double d10) {
        this.zzg = d10;
    }

    public final void setStore(@NonNull String str) {
        this.zzh = str;
    }

    @NonNull
    public final View zza() {
        return this.zzl;
    }

    public void recordImpression() {
    }

    public void handleClick(@NonNull View view) {
    }

    public void untrackView(@NonNull View view) {
    }

    public void trackViews(@NonNull View view, @NonNull Map<String, View> map, @NonNull Map<String, View> map2) {
    }
}

package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class ReportingInfo {
    private final zzbtk zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    @KeepForSdk
    public static final class Builder {
        private final zzbtj zza;

        @KeepForSdk
        public Builder(@NonNull View view) {
            zzbtj zzbtjVar = new zzbtj();
            this.zza = zzbtjVar;
            zzbtjVar.zzb(view);
        }

        @NonNull
        @KeepForSdk
        public ReportingInfo build() {
            return new ReportingInfo(this, null);
        }

        @NonNull
        @KeepForSdk
        public Builder setAssetViews(@NonNull Map<String, View> map) {
            this.zza.zzc(map);
            return this;
        }
    }

    /* synthetic */ ReportingInfo(Builder builder, zzb zzbVar) {
        this.zza = new zzbtk(builder.zza);
    }

    @KeepForSdk
    public void recordClick(@NonNull List<Uri> list) {
        this.zza.zza(list);
    }

    @KeepForSdk
    public void recordImpression(@NonNull List<Uri> list) {
        this.zza.zzb(list);
    }

    @KeepForSdk
    public void reportTouchEvent(@NonNull MotionEvent motionEvent) {
        this.zza.zzc(motionEvent);
    }

    @KeepForSdk
    public void updateClickUrl(@NonNull Uri uri, @NonNull UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzd(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public void updateImpressionUrls(@NonNull List<Uri> list, @NonNull UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zze(list, updateImpressionUrlsCallback);
    }
}

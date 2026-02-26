package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.Nullable;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.m;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeep {

    @Nullable
    private MeasurementManagerFutures zza;
    private final Context zzb;

    zzeep(Context context) {
        this.zzb = context;
    }

    public final m zza() {
        try {
            MeasurementManagerFutures measurementManagerFuturesFrom = MeasurementManagerFutures.from(this.zzb);
            this.zza = measurementManagerFuturesFrom;
            return measurementManagerFuturesFrom == null ? zzgcj.zzg(new IllegalStateException("MeasurementManagerFutures is null")) : measurementManagerFuturesFrom.getMeasurementApiStatusAsync();
        } catch (Exception e10) {
            return zzgcj.zzg(e10);
        }
    }

    public final m zzb(Uri uri, InputEvent inputEvent) {
        try {
            MeasurementManagerFutures measurementManagerFutures = this.zza;
            Objects.requireNonNull(measurementManagerFutures);
            return measurementManagerFutures.registerSourceAsync(uri, inputEvent);
        } catch (Exception e10) {
            return zzgcj.zzg(e10);
        }
    }
}

package com.google.android.gms.ads;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractAdRequestBuilder<T extends AbstractAdRequestBuilder<T>> {
    protected final zzdw zza;

    protected AbstractAdRequestBuilder() {
        zzdw zzdwVar = new zzdw();
        this.zza = zzdwVar;
        zzdwVar.zzt("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    @NonNull
    @Deprecated
    public T addCustomEventExtrasBundle(@NonNull Class<? extends CustomEvent> cls, @NonNull Bundle bundle) {
        this.zza.zzo(cls, bundle);
        return (T) self();
    }

    @NonNull
    public T addKeyword(@NonNull String str) {
        this.zza.zzq(str);
        return (T) self();
    }

    @NonNull
    public T addNetworkExtrasBundle(@NonNull Class<? extends MediationExtrasReceiver> cls, @NonNull Bundle bundle) {
        this.zza.zzr(cls, bundle);
        if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            this.zza.zzu("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return (T) self();
    }

    @NonNull
    protected abstract T self();

    @NonNull
    public T setAdString(@NonNull String str) {
        this.zza.zzv(str);
        return (T) self();
    }

    @NonNull
    public T setContentUrl(@NonNull String str) {
        Preconditions.checkNotNull(str, "Content URL must be non-null.");
        Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
        int length = str.length();
        Preconditions.checkArgument(length <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
        this.zza.zzw(str);
        return (T) self();
    }

    @NonNull
    public T setHttpTimeoutMillis(int i10) {
        this.zza.zzx(i10);
        return (T) self();
    }

    @NonNull
    public T setNeighboringContentUrls(@NonNull List<String> list) {
        if (list == null) {
            zzm.zzj("neighboring content URLs list should not be null");
            return (T) self();
        }
        this.zza.zzz(list);
        return (T) self();
    }

    @NonNull
    public T setRequestAgent(@NonNull String str) {
        this.zza.zzB(str);
        return (T) self();
    }

    @NonNull
    @Deprecated
    public final AbstractAdRequestBuilder zza(@NonNull String str) {
        this.zza.zzt(str);
        return self();
    }

    @NonNull
    @Deprecated
    public final AbstractAdRequestBuilder zzb(boolean z10) {
        this.zza.zzy(z10);
        return self();
    }

    @NonNull
    @Deprecated
    public final AbstractAdRequestBuilder zzc(boolean z10) {
        this.zza.zzC(z10);
        return self();
    }
}

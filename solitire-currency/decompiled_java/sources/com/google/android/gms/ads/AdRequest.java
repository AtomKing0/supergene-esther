package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class AdRequest {

    @NonNull
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_APP_ID_MISSING = 8;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_AD_STRING = 11;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_MEDIATION_NO_FILL = 9;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int ERROR_CODE_REQUEST_ID_MISMATCH = 10;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    protected final zzdx zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public static class Builder extends AbstractAdRequestBuilder<Builder> {
        @NonNull
        public AdRequest build() {
            return new AdRequest(this);
        }

        @Override // com.google.android.gms.ads.AbstractAdRequestBuilder
        @NonNull
        public Builder self() {
            return this;
        }
    }

    protected AdRequest(@NonNull AbstractAdRequestBuilder abstractAdRequestBuilder) {
        this.zza = new zzdx(abstractAdRequestBuilder.zza, null);
    }

    @Nullable
    public String getAdString() {
        return this.zza.zzj();
    }

    @NonNull
    public String getContentUrl() {
        return this.zza.zzk();
    }

    @Nullable
    @Deprecated
    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(@NonNull Class<T> cls) {
        return this.zza.zzd(cls);
    }

    @NonNull
    public Bundle getCustomTargeting() {
        return this.zza.zze();
    }

    @NonNull
    public Set<String> getKeywords() {
        return this.zza.zzp();
    }

    @NonNull
    public List<String> getNeighboringContentUrls() {
        return this.zza.zzn();
    }

    @Nullable
    public <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(@NonNull Class<T> cls) {
        return this.zza.zzf(cls);
    }

    @NonNull
    public String getRequestAgent() {
        return this.zza.zzm();
    }

    public boolean isTestDevice(@NonNull Context context) {
        return this.zza.zzs(context);
    }

    public final zzdx zza() {
        return this.zza;
    }
}

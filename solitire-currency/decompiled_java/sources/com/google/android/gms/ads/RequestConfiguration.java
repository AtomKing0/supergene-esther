package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class RequestConfiguration {

    @NonNull
    public static final String MAX_AD_CONTENT_RATING_T = "T";

    @NonNull
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final List zze;
    private final PublisherPrivacyPersonalizationState zzf;

    @NonNull
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";

    @NonNull
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";

    @NonNull
    public static final String MAX_AD_CONTENT_RATING_G = "G";

    @NonNull
    public static final List zza = Arrays.asList(MAX_AD_CONTENT_RATING_MA, "T", MAX_AD_CONTENT_RATING_PG, MAX_AD_CONTENT_RATING_G);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public static class Builder {
        private int zza = -1;
        private int zzb = -1;
        private String zzc = null;
        private final List zzd = new ArrayList();
        private PublisherPrivacyPersonalizationState zze = PublisherPrivacyPersonalizationState.DEFAULT;

        @NonNull
        public RequestConfiguration build() {
            return new RequestConfiguration(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
        }

        @NonNull
        public Builder setMaxAdContentRating(String str) {
            if (str == null || "".equals(str)) {
                this.zzc = null;
            } else if (RequestConfiguration.MAX_AD_CONTENT_RATING_G.equals(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_PG.equals(str) || "T".equals(str) || RequestConfiguration.MAX_AD_CONTENT_RATING_MA.equals(str)) {
                this.zzc = str;
            } else {
                zzm.zzj("Invalid value passed to setMaxAdContentRating: ".concat(str));
            }
            return this;
        }

        @NonNull
        public Builder setPublisherPrivacyPersonalizationState(@NonNull PublisherPrivacyPersonalizationState publisherPrivacyPersonalizationState) {
            this.zze = publisherPrivacyPersonalizationState;
            return this;
        }

        @NonNull
        public Builder setTagForChildDirectedTreatment(int i10) {
            if (i10 == -1 || i10 == 0 || i10 == 1) {
                this.zza = i10;
            } else {
                zzm.zzj("Invalid value passed to setTagForChildDirectedTreatment: " + i10);
            }
            return this;
        }

        @NonNull
        public Builder setTagForUnderAgeOfConsent(int i10) {
            if (i10 == -1 || i10 == 0 || i10 == 1) {
                this.zzb = i10;
            } else {
                zzm.zzj("Invalid value passed to setTagForUnderAgeOfConsent: " + i10);
            }
            return this;
        }

        @NonNull
        public Builder setTestDeviceIds(List<String> list) {
            this.zzd.clear();
            if (list != null) {
                this.zzd.addAll(list);
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    public enum PublisherPrivacyPersonalizationState {
        DEFAULT(0),
        ENABLED(1),
        DISABLED(2);

        private final int zzb;

        PublisherPrivacyPersonalizationState(int i10) {
            this.zzb = i10;
        }

        public int getValue() {
            return this.zzb;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    /* synthetic */ RequestConfiguration(int i10, int i11, String str, List list, PublisherPrivacyPersonalizationState publisherPrivacyPersonalizationState, zzh zzhVar) {
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = str;
        this.zze = list;
        this.zzf = publisherPrivacyPersonalizationState;
    }

    @NonNull
    public String getMaxAdContentRating() {
        String str = this.zzd;
        return str == null ? "" : str;
    }

    @NonNull
    public PublisherPrivacyPersonalizationState getPublisherPrivacyPersonalizationState() {
        return this.zzf;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzb;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzc;
    }

    @NonNull
    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zze);
    }

    @NonNull
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setTagForChildDirectedTreatment(this.zzb);
        builder.setTagForUnderAgeOfConsent(this.zzc);
        builder.setMaxAdContentRating(this.zzd);
        builder.setTestDeviceIds(this.zze);
        return builder;
    }
}

package com.google.android.ump;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ConsentRequestParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f9959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ConsentDebugSettings f9960c;

    /* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private String f9962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private ConsentDebugSettings f9963c;

        @RecentlyNonNull
        public ConsentRequestParameters build() {
            return new ConsentRequestParameters(this, null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAdMobAppId(@Nullable String str) {
            this.f9962b = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setConsentDebugSettings(@Nullable ConsentDebugSettings consentDebugSettings) {
            this.f9963c = consentDebugSettings;
            return this;
        }

        @RecentlyNonNull
        public Builder setTagForUnderAgeOfConsent(boolean z10) {
            this.f9961a = z10;
            return this;
        }
    }

    /* synthetic */ ConsentRequestParameters(Builder builder, zzb zzbVar) {
        this.f9958a = builder.f9961a;
        this.f9959b = builder.f9962b;
        this.f9960c = builder.f9963c;
    }

    @RecentlyNullable
    public ConsentDebugSettings getConsentDebugSettings() {
        return this.f9960c;
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.f9958a;
    }

    @RecentlyNullable
    public final String zza() {
        return this.f9959b;
    }
}

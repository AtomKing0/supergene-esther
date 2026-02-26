package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class OTCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21957a;

    public static class OTCacheBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21958a;

        @NonNull
        public static OTCacheBuilder newInstance() {
            return new OTCacheBuilder();
        }

        @NonNull
        public OTCache build() {
            return new OTCache(this);
        }

        @NonNull
        @Deprecated
        public OTCacheBuilder setDataSubjectIdentifier(@NonNull String str) {
            this.f21958a = str;
            return this;
        }
    }

    public OTCache(@NonNull OTCacheBuilder oTCacheBuilder) {
        this.f21957a = oTCacheBuilder.f21958a;
    }

    @Nullable
    public String getDataSubjectIdentifier() {
        return this.f21957a;
    }

    @NonNull
    public String toString() {
        return "OTCache{dataSubjectIdentifier='" + this.f21957a + "'}";
    }
}

package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class OTProfileSyncParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f21981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f21982f;

    public static class OTProfileSyncParamsBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f21984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f21985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f21986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f21987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f21988f;

        @NonNull
        public static OTProfileSyncParamsBuilder newInstance() {
            return new OTProfileSyncParamsBuilder();
        }

        @NonNull
        public OTProfileSyncParams build() {
            return new OTProfileSyncParams(this);
        }

        public OTProfileSyncParamsBuilder setIdentifier(@NonNull String str) {
            this.f21984b = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setIdentifierType(@NonNull String str) {
            this.f21985c = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setSyncGroupId(@NonNull String str) {
            this.f21988f = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setSyncProfile(@NonNull String str) {
            this.f21983a = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setSyncProfileAuth(@NonNull String str) {
            this.f21986d = str;
            return this;
        }

        public OTProfileSyncParamsBuilder setTenantId(@NonNull String str) {
            this.f21987e = str;
            return this;
        }
    }

    public OTProfileSyncParams(@NonNull OTProfileSyncParamsBuilder oTProfileSyncParamsBuilder) {
        this.f21977a = oTProfileSyncParamsBuilder.f21983a;
        this.f21978b = oTProfileSyncParamsBuilder.f21984b;
        this.f21979c = oTProfileSyncParamsBuilder.f21985c;
        this.f21980d = oTProfileSyncParamsBuilder.f21986d;
        this.f21981e = oTProfileSyncParamsBuilder.f21987e;
        this.f21982f = oTProfileSyncParamsBuilder.f21988f;
    }

    @Nullable
    public String getIdentifier() {
        return this.f21978b;
    }

    @Nullable
    public String getIdentifierType() {
        return this.f21979c;
    }

    @Nullable
    public String getSyncGroupId() {
        return this.f21982f;
    }

    @Nullable
    public String getSyncProfile() {
        return this.f21977a;
    }

    @Nullable
    public String getSyncProfileAuth() {
        return this.f21980d;
    }

    @Nullable
    public String getTenantId() {
        return this.f21981e;
    }

    @NonNull
    public String toString() {
        return "OTProfileSyncParams{syncProfile=" + this.f21977a + ", identifier='" + this.f21978b + "', identifierType='" + this.f21979c + "', syncProfileAuth='" + this.f21980d + "', tenantId='" + this.f21981e + "', syncGroupId='" + this.f21982f + "'}";
    }
}

package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class OTRenameProfileParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21991c;

    public static class OTRenameProfileParamsBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f21993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f21994c;

        @NonNull
        public static OTRenameProfileParamsBuilder newInstance() {
            return new OTRenameProfileParamsBuilder();
        }

        @NonNull
        public OTRenameProfileParams build() {
            return new OTRenameProfileParams(this);
        }

        public OTRenameProfileParamsBuilder setIdentifierType(@NonNull String str) {
            this.f21994c = str;
            return this;
        }

        public OTRenameProfileParamsBuilder setNewProfileID(@NonNull String str) {
            this.f21993b = str;
            return this;
        }

        public OTRenameProfileParamsBuilder setOldProfileID(@NonNull String str) {
            this.f21992a = str;
            return this;
        }
    }

    public OTRenameProfileParams(@NonNull OTRenameProfileParamsBuilder oTRenameProfileParamsBuilder) {
        this.f21989a = oTRenameProfileParamsBuilder.f21992a;
        this.f21990b = oTRenameProfileParamsBuilder.f21993b;
        this.f21991c = oTRenameProfileParamsBuilder.f21994c;
    }

    @Nullable
    public String getIdentifierType() {
        return this.f21991c;
    }

    @Nullable
    public String getNewProfileID() {
        return this.f21990b;
    }

    @Nullable
    public String getOldProfileID() {
        return this.f21989a;
    }

    @NonNull
    public String toString() {
        return "OTProfileSyncParams{oldProfileID=" + this.f21989a + ", newProfileID='" + this.f21990b + "', identifierType='" + this.f21991c + "'}";
    }
}

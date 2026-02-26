package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OTUXParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f22011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22012b;

    public static class OTUXParamsBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f22014b;

        @NonNull
        public static OTUXParamsBuilder newInstance() {
            return new OTUXParamsBuilder();
        }

        @NonNull
        public OTUXParams build() {
            return new OTUXParams(this);
        }

        @NonNull
        public OTUXParamsBuilder setOTSDKTheme(String str) {
            this.f22013a = str;
            return this;
        }

        @NonNull
        public OTUXParamsBuilder setUXParams(@NonNull JSONObject jSONObject) {
            this.f22014b = jSONObject;
            return this;
        }
    }

    public OTUXParams(@NonNull OTUXParamsBuilder oTUXParamsBuilder) {
        this.f22011a = oTUXParamsBuilder.f22014b;
        this.f22012b = oTUXParamsBuilder.f22013a;
    }

    @Nullable
    public String getOTSDKTheme() {
        return this.f22012b;
    }

    @Nullable
    public JSONObject getUxParam() {
        return this.f22011a;
    }

    @NonNull
    public String toString() {
        return "OTUXParams{uxParam=" + this.f22011a + ", otSDKTheme='" + this.f22012b + "'}";
    }
}

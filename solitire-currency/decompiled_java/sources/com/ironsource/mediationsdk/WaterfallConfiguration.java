package com.ironsource.mediationsdk;

import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class WaterfallConfiguration {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Double f13272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Double f13273b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final WaterfallConfigurationBuilder builder() {
            return new WaterfallConfigurationBuilder();
        }

        @NotNull
        public final WaterfallConfiguration empty() {
            return builder().build();
        }
    }

    public static final class WaterfallConfigurationBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Double f13274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Double f13275b;

        @NotNull
        public final WaterfallConfiguration build() {
            return new WaterfallConfiguration(this, null);
        }

        @Nullable
        public final Double getCeiling$mediationsdk_release() {
            return this.f13275b;
        }

        @Nullable
        public final Double getFloor$mediationsdk_release() {
            return this.f13274a;
        }

        @NotNull
        public final WaterfallConfigurationBuilder setCeiling(double d10) {
            this.f13275b = Double.valueOf(d10);
            return this;
        }

        public final void setCeiling$mediationsdk_release(@Nullable Double d10) {
            this.f13275b = d10;
        }

        @NotNull
        public final WaterfallConfigurationBuilder setFloor(double d10) {
            this.f13274a = Double.valueOf(d10);
            return this;
        }

        public final void setFloor$mediationsdk_release(@Nullable Double d10) {
            this.f13274a = d10;
        }
    }

    private WaterfallConfiguration(WaterfallConfigurationBuilder waterfallConfigurationBuilder) {
        this.f13272a = waterfallConfigurationBuilder.getFloor$mediationsdk_release();
        this.f13273b = waterfallConfigurationBuilder.getCeiling$mediationsdk_release();
    }

    @NotNull
    public static final WaterfallConfigurationBuilder builder() {
        return Companion.builder();
    }

    @NotNull
    public static final WaterfallConfiguration empty() {
        return Companion.empty();
    }

    @Nullable
    public final Double getCeiling() {
        return this.f13273b;
    }

    @Nullable
    public final Double getFloor() {
        return this.f13272a;
    }

    @NotNull
    public final String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ceiling", this.f13273b);
            jSONObject.put("floor", this.f13272a);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.getMessage());
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.t.h(string, "json.toString()");
        return string;
    }

    @NotNull
    public String toString() {
        return "WaterfallConfiguration" + toJsonString();
    }

    public /* synthetic */ WaterfallConfiguration(WaterfallConfigurationBuilder waterfallConfigurationBuilder, kotlin.jvm.internal.k kVar) {
        this(waterfallConfigurationBuilder);
    }
}

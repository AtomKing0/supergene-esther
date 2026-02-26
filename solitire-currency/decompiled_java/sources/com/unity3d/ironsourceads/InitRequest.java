package com.unity3d.ironsourceads;

import com.unity3d.ironsourceads.IronSourceAds;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InitRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<IronSourceAds.AdFormat> f23829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final LogLevel f23830c;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f23831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private List<? extends IronSourceAds.AdFormat> f23832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private LogLevel f23833c;

        public Builder(@NotNull String appKey) {
            t.i(appKey, "appKey");
            this.f23831a = appKey;
        }

        @NotNull
        public final InitRequest build() {
            String str = this.f23831a;
            List<? extends IronSourceAds.AdFormat> listL = this.f23832b;
            if (listL == null) {
                listL = v.l();
            }
            LogLevel logLevel = this.f23833c;
            if (logLevel == null) {
                logLevel = LogLevel.NONE;
            }
            return new InitRequest(str, listL, logLevel, null);
        }

        @NotNull
        public final String getAppKey() {
            return this.f23831a;
        }

        @NotNull
        public final Builder withLegacyAdFormats(@NotNull List<? extends IronSourceAds.AdFormat> legacyAdFormats) {
            t.i(legacyAdFormats, "legacyAdFormats");
            this.f23832b = legacyAdFormats;
            return this;
        }

        @NotNull
        public final Builder withLogLevel(@NotNull LogLevel logLevel) {
            t.i(logLevel, "logLevel");
            this.f23833c = logLevel;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InitRequest(String str, List<? extends IronSourceAds.AdFormat> list, LogLevel logLevel) {
        this.f23828a = str;
        this.f23829b = list;
        this.f23830c = logLevel;
    }

    @NotNull
    public final String getAppKey() {
        return this.f23828a;
    }

    @NotNull
    public final List<IronSourceAds.AdFormat> getLegacyAdFormats() {
        return this.f23829b;
    }

    @NotNull
    public final LogLevel getLogLevel() {
        return this.f23830c;
    }

    public /* synthetic */ InitRequest(String str, List list, LogLevel logLevel, k kVar) {
        this(str, list, logLevel);
    }
}

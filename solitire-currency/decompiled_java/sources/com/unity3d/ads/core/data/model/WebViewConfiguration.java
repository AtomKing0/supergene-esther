package com.unity3d.ads.core.data.model;

import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WebViewConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WebViewConfiguration {

    @NotNull
    private final List<String> additionalFiles;

    @NotNull
    private final String entryPoint;
    private final int version;

    public WebViewConfiguration(int i10, @NotNull String entryPoint, @NotNull List<String> additionalFiles) {
        t.i(entryPoint, "entryPoint");
        t.i(additionalFiles, "additionalFiles");
        this.version = i10;
        this.entryPoint = entryPoint;
        this.additionalFiles = additionalFiles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebViewConfiguration copy$default(WebViewConfiguration webViewConfiguration, int i10, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = webViewConfiguration.version;
        }
        if ((i11 & 2) != 0) {
            str = webViewConfiguration.entryPoint;
        }
        if ((i11 & 4) != 0) {
            list = webViewConfiguration.additionalFiles;
        }
        return webViewConfiguration.copy(i10, str, list);
    }

    public final int component1() {
        return this.version;
    }

    @NotNull
    public final String component2() {
        return this.entryPoint;
    }

    @NotNull
    public final List<String> component3() {
        return this.additionalFiles;
    }

    @NotNull
    public final WebViewConfiguration copy(int i10, @NotNull String entryPoint, @NotNull List<String> additionalFiles) {
        t.i(entryPoint, "entryPoint");
        t.i(additionalFiles, "additionalFiles");
        return new WebViewConfiguration(i10, entryPoint, additionalFiles);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebViewConfiguration)) {
            return false;
        }
        WebViewConfiguration webViewConfiguration = (WebViewConfiguration) obj;
        return this.version == webViewConfiguration.version && t.d(this.entryPoint, webViewConfiguration.entryPoint) && t.d(this.additionalFiles, webViewConfiguration.additionalFiles);
    }

    @NotNull
    public final List<String> getAdditionalFiles() {
        return this.additionalFiles;
    }

    @NotNull
    public final String getEntryPoint() {
        return this.entryPoint;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((this.version * 31) + this.entryPoint.hashCode()) * 31) + this.additionalFiles.hashCode();
    }

    @NotNull
    public String toString() {
        return "WebViewConfiguration(version=" + this.version + ", entryPoint=" + this.entryPoint + ", additionalFiles=" + this.additionalFiles + ')';
    }
}

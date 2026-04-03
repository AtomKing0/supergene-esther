package com.moloco.sdk.internal.services.bidtoken;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f18449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f18450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18451e;

    public h(@NotNull String language, @NotNull String osVersion, @NotNull String make, @NotNull String model, @NotNull String hardwareVersion) {
        kotlin.jvm.internal.t.i(language, "language");
        kotlin.jvm.internal.t.i(osVersion, "osVersion");
        kotlin.jvm.internal.t.i(make, "make");
        kotlin.jvm.internal.t.i(model, "model");
        kotlin.jvm.internal.t.i(hardwareVersion, "hardwareVersion");
        this.f18447a = language;
        this.f18448b = osVersion;
        this.f18449c = make;
        this.f18450d = model;
        this.f18451e = hardwareVersion;
    }

    @NotNull
    public final String a() {
        return this.f18448b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return kotlin.jvm.internal.t.d(this.f18447a, hVar.f18447a) && kotlin.jvm.internal.t.d(this.f18448b, hVar.f18448b) && kotlin.jvm.internal.t.d(this.f18449c, hVar.f18449c) && kotlin.jvm.internal.t.d(this.f18450d, hVar.f18450d) && kotlin.jvm.internal.t.d(this.f18451e, hVar.f18451e);
    }

    public int hashCode() {
        return (((((((this.f18447a.hashCode() * 31) + this.f18448b.hashCode()) * 31) + this.f18449c.hashCode()) * 31) + this.f18450d.hashCode()) * 31) + this.f18451e.hashCode();
    }

    @NotNull
    public String toString() {
        return "BidTokenDeviceRequestInfo(language=" + this.f18447a + ", osVersion=" + this.f18448b + ", make=" + this.f18449c + ", model=" + this.f18450d + ", hardwareVersion=" + this.f18451e + ')';
    }
}

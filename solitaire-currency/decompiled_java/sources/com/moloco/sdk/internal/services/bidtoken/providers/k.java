package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final MolocoPrivacy.PrivacySettings f18510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final p f18511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final d f18512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final r f18513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final h f18514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.f f18515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final n f18516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final f f18517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final a f18518j;

    public k(boolean z10, @NotNull MolocoPrivacy.PrivacySettings privacySettings, @NotNull p memoryInfo, @NotNull d appDirInfo, @NotNull r networkInfoSignal, @NotNull h batteryInfoSignal, @NotNull com.moloco.sdk.internal.services.f adDataSignal, @NotNull n deviceSignal, @NotNull f audioSignal, @NotNull a accessibilitySignal) {
        kotlin.jvm.internal.t.i(privacySettings, "privacySettings");
        kotlin.jvm.internal.t.i(memoryInfo, "memoryInfo");
        kotlin.jvm.internal.t.i(appDirInfo, "appDirInfo");
        kotlin.jvm.internal.t.i(networkInfoSignal, "networkInfoSignal");
        kotlin.jvm.internal.t.i(batteryInfoSignal, "batteryInfoSignal");
        kotlin.jvm.internal.t.i(adDataSignal, "adDataSignal");
        kotlin.jvm.internal.t.i(deviceSignal, "deviceSignal");
        kotlin.jvm.internal.t.i(audioSignal, "audioSignal");
        kotlin.jvm.internal.t.i(accessibilitySignal, "accessibilitySignal");
        this.f18509a = z10;
        this.f18510b = privacySettings;
        this.f18511c = memoryInfo;
        this.f18512d = appDirInfo;
        this.f18513e = networkInfoSignal;
        this.f18514f = batteryInfoSignal;
        this.f18515g = adDataSignal;
        this.f18516h = deviceSignal;
        this.f18517i = audioSignal;
        this.f18518j = accessibilitySignal;
    }

    @NotNull
    public final a a() {
        return this.f18518j;
    }

    @NotNull
    public final com.moloco.sdk.internal.services.f b() {
        return this.f18515g;
    }

    @NotNull
    public final d c() {
        return this.f18512d;
    }

    @NotNull
    public final f d() {
        return this.f18517i;
    }

    @NotNull
    public final h e() {
        return this.f18514f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f18509a == kVar.f18509a && kotlin.jvm.internal.t.d(this.f18510b, kVar.f18510b) && kotlin.jvm.internal.t.d(this.f18511c, kVar.f18511c) && kotlin.jvm.internal.t.d(this.f18512d, kVar.f18512d) && kotlin.jvm.internal.t.d(this.f18513e, kVar.f18513e) && kotlin.jvm.internal.t.d(this.f18514f, kVar.f18514f) && kotlin.jvm.internal.t.d(this.f18515g, kVar.f18515g) && kotlin.jvm.internal.t.d(this.f18516h, kVar.f18516h) && kotlin.jvm.internal.t.d(this.f18517i, kVar.f18517i) && kotlin.jvm.internal.t.d(this.f18518j, kVar.f18518j);
    }

    @NotNull
    public final n f() {
        return this.f18516h;
    }

    @NotNull
    public final p g() {
        return this.f18511c;
    }

    @NotNull
    public final r h() {
        return this.f18513e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public int hashCode() {
        boolean z10 = this.f18509a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (((((((((((((((((r02 * 31) + this.f18510b.hashCode()) * 31) + this.f18511c.hashCode()) * 31) + this.f18512d.hashCode()) * 31) + this.f18513e.hashCode()) * 31) + this.f18514f.hashCode()) * 31) + this.f18515g.hashCode()) * 31) + this.f18516h.hashCode()) * 31) + this.f18517i.hashCode()) * 31) + this.f18518j.hashCode();
    }

    @NotNull
    public final MolocoPrivacy.PrivacySettings i() {
        return this.f18510b;
    }

    public final boolean j() {
        return this.f18509a;
    }

    @NotNull
    public String toString() {
        return "ClientSignals(sdkInitialized=" + this.f18509a + ", privacySettings=" + this.f18510b + ", memoryInfo=" + this.f18511c + ", appDirInfo=" + this.f18512d + ", networkInfoSignal=" + this.f18513e + ", batteryInfoSignal=" + this.f18514f + ", adDataSignal=" + this.f18515g + ", deviceSignal=" + this.f18516h + ", audioSignal=" + this.f18517i + ", accessibilitySignal=" + this.f18518j + ')';
    }
}

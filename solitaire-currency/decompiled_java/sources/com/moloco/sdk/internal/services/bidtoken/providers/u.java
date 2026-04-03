package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.Moloco;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class u implements j<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18546b = "SDKInitStateSignalProvider";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18547c = Moloco.isInitialized();

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18547c = Moloco.isInitialized();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        StringBuilder sb;
        boolean z10 = this.f18547c;
        boolean zIsInitialized = Moloco.isInitialized();
        boolean z11 = z10 != zIsInitialized;
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str = this.f18546b;
        if (z11) {
            sb = new StringBuilder();
            sb.append("[CBT] sdkInitialized updated from ");
            sb.append(z10);
            sb.append(" to ");
            sb.append(zIsInitialized);
        } else {
            sb = new StringBuilder();
            sb.append("[CBT] sdkInitialized didn't change (before: ");
            sb.append(z10);
            sb.append(", after: ");
            sb.append(zIsInitialized);
            sb.append(')');
        }
        MolocoLogger.debugBuildLog$default(molocoLogger, str, sb.toString(), false, 4, null);
        return z11;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return this.f18546b;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean d() {
        return Boolean.valueOf(this.f18547c);
    }
}

package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class f4 implements sd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final je f12045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private g4 f12046b;

    public static final class a {
        @NotNull
        public final g4 a(@Nullable d4 d4Var, @NotNull je featureAvailabilityService) {
            kotlin.jvm.internal.t.i(featureAvailabilityService, "featureAvailabilityService");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("isAndroidxApplicationLifecycleAvailable: " + featureAvailabilityService.a());
            StringBuilder sb = new StringBuilder();
            sb.append("isAndroidxApplicationLifecycleEnabled: ");
            sb.append(d4Var != null ? Boolean.valueOf(d4Var.k()) : null);
            ironLog.verbose(sb.toString());
            boolean z10 = false;
            if (featureAvailabilityService.a()) {
                rp.i().a(new kb(IronSourceConstants.TROUBLESHOOTING_ANDROIDX_PROCESS_LIFECYCLE_OWNER_AVAILABLE, IronSourceUtils.getMediationAdditionalData(false)));
            }
            if ((d4Var != null ? d4Var.k() : false) && featureAvailabilityService.a()) {
                z10 = true;
            }
            ironLog.verbose("isAndroidxEnabled: " + z10);
            return z10 ? new o3() : new xe();
        }
    }

    public f4(@NotNull je featureAvailabilityService) {
        kotlin.jvm.internal.t.i(featureAvailabilityService, "featureAvailabilityService");
        this.f12045a = featureAvailabilityService;
    }

    @Override // com.ironsource.sd
    public void a(@Nullable d4 d4Var) {
        if (this.f12046b == null) {
            this.f12046b = new a().a(d4Var, this.f12045a);
        }
    }

    @Override // com.ironsource.g4
    public void b(@NotNull ij observer) {
        kotlin.jvm.internal.t.i(observer, "observer");
        g4 g4Var = this.f12046b;
        if (g4Var != null) {
            g4Var.b(observer);
        }
    }

    @Override // com.ironsource.g4
    public void a(@NotNull ij observer) {
        kotlin.jvm.internal.t.i(observer, "observer");
        g4 g4Var = this.f12046b;
        if (g4Var != null) {
            g4Var.a(observer);
        }
    }
}

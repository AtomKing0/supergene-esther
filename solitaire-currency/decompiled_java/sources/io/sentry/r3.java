package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PerformanceCollectionData.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private m2 f28139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private k f28140b = null;

    public void a(@Nullable k kVar) {
        if (kVar != null) {
            this.f28140b = kVar;
        }
    }

    public void b(@Nullable m2 m2Var) {
        if (m2Var != null) {
            this.f28139a = m2Var;
        }
    }

    @Nullable
    public k c() {
        return this.f28140b;
    }

    @Nullable
    public m2 d() {
        return this.f28139a;
    }
}

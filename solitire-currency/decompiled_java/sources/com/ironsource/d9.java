package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface d9 {

    public static final class a implements d9 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f11779a;

        public a(boolean z10) {
            this.f11779a = z10;
        }

        @Override // com.ironsource.d9
        public void a() {
            xf.a(vp.f15956x, new sf().a(nb.f14127y, Boolean.valueOf(this.f11779a)).a());
        }
    }

    public static final class b implements d9 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f11780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final k9 f11782c;

        public b(boolean z10, long j10, @NotNull k9 currentTimeProvider) {
            kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
            this.f11780a = z10;
            this.f11781b = j10;
            this.f11782c = currentTimeProvider;
        }

        @Override // com.ironsource.d9
        public void a() {
            sf sfVarA = new sf().a(nb.f14127y, Boolean.valueOf(this.f11780a));
            if (this.f11781b > 0) {
                sfVarA.a(nb.B, Long.valueOf(this.f11782c.a() - this.f11781b));
            }
            xf.a(vp.f15955w, sfVarA.a());
        }

        @NotNull
        public final k9 b() {
            return this.f11782c;
        }
    }

    void a();
}

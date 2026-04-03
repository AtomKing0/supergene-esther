package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface jd {

    public static final class a implements jd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final ld f12732a;

        public a(@NotNull ld strategy) {
            kotlin.jvm.internal.t.i(strategy, "strategy");
            this.f12732a = strategy;
        }

        @Override // com.ironsource.jd
        @NotNull
        public String a() {
            return "WebView is unavailable";
        }

        @Override // com.ironsource.jd
        @NotNull
        public ld b() {
            return this.f12732a;
        }

        @NotNull
        public final ld c() {
            return this.f12732a;
        }
    }

    @NotNull
    String a();

    @NotNull
    ld b();
}

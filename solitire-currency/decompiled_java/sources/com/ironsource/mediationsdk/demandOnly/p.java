package com.ironsource.mediationsdk.demandOnly;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface p {

    public static class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f13549a;

        public a(@NotNull String plumbus) {
            t.i(plumbus, "plumbus");
            this.f13549a = plumbus;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.p
        @NotNull
        public String value() {
            return this.f13549a;
        }
    }

    public static final class b extends a {
        public b() {
            super("");
        }
    }

    @NotNull
    String value();
}

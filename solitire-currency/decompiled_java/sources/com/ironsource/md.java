package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface md {

    public static final class a implements md {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final jd f13241a;

        public a(@NotNull jd failure) {
            kotlin.jvm.internal.t.i(failure, "failure");
            this.f13241a = failure;
        }

        @NotNull
        public final jd a() {
            return this.f13241a;
        }

        @NotNull
        public final jd b() {
            return this.f13241a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.t.d(this.f13241a, ((a) obj).f13241a);
        }

        public int hashCode() {
            return this.f13241a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failure(failure=" + this.f13241a + ')';
        }

        @NotNull
        public final a a(@NotNull jd failure) {
            kotlin.jvm.internal.t.i(failure, "failure");
            return new a(failure);
        }

        public static /* synthetic */ a a(a aVar, jd jdVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                jdVar = aVar.f13241a;
            }
            return aVar.a(jdVar);
        }

        @Override // com.ironsource.md
        public void a(@NotNull nd handler) {
            kotlin.jvm.internal.t.i(handler, "handler");
            handler.a(this.f13241a);
        }
    }

    void a(@NotNull nd ndVar);
}

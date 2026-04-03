package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.dl;
import com.ironsource.za;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface o extends za<String> {

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f13548a;

        public a(@NotNull String rowAdm) {
            t.i(rowAdm, "rowAdm");
            this.f13548a = rowAdm;
        }

        @Override // com.ironsource.za
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a() {
            return this.f13548a;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.o
        public <T> T a(@NotNull dl<String, T> mapper) {
            t.i(mapper, "mapper");
            return mapper.a(this.f13548a);
        }
    }

    <T> T a(@NotNull dl<String, T> dlVar);
}

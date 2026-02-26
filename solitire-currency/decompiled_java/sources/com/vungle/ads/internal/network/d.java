package com.vungle.ads.internal.network;

import ga.d0;
import ga.e0;
import ga.u;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d<T> {

    @NotNull
    public static final a Companion = new a(null);

    @Nullable
    private final T body;

    @Nullable
    private final e0 errorBody;

    @NotNull
    private final d0 rawResponse;

    /* JADX INFO: compiled from: Response.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final <T> d<T> error(@Nullable e0 e0Var, @NotNull d0 rawResponse) {
            t.i(rawResponse, "rawResponse");
            if (!(!rawResponse.O())) {
                throw new IllegalArgumentException("rawResponse should not be successful response".toString());
            }
            k kVar = null;
            return new d<>(rawResponse, kVar, e0Var, kVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final <T> d<T> success(@Nullable T t10, @NotNull d0 rawResponse) {
            t.i(rawResponse, "rawResponse");
            if (rawResponse.O()) {
                return new d<>(rawResponse, t10, null, 0 == true ? 1 : 0);
            }
            throw new IllegalArgumentException("rawResponse must be successful response".toString());
        }
    }

    public /* synthetic */ d(d0 d0Var, Object obj, e0 e0Var, k kVar) {
        this(d0Var, obj, e0Var);
    }

    @Nullable
    public final T body() {
        return this.body;
    }

    public final int code() {
        return this.rawResponse.q();
    }

    @Nullable
    public final e0 errorBody() {
        return this.errorBody;
    }

    @NotNull
    public final u headers() {
        return this.rawResponse.L();
    }

    public final boolean isSuccessful() {
        return this.rawResponse.O();
    }

    @NotNull
    public final String message() {
        return this.rawResponse.R();
    }

    @NotNull
    public final d0 raw() {
        return this.rawResponse;
    }

    @NotNull
    public String toString() {
        return this.rawResponse.toString();
    }

    private d(d0 d0Var, T t10, e0 e0Var) {
        this.rawResponse = d0Var;
        this.body = t10;
        this.errorBody = e0Var;
    }
}

package com.google.protobuf;

import com.google.protobuf.Int64Value;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Int64ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Int64ValueKt {

    @NotNull
    public static final Int64ValueKt INSTANCE = new Int64ValueKt();

    /* JADX INFO: compiled from: Int64ValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Int64Value.Builder _builder;

        /* JADX INFO: compiled from: Int64ValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Int64Value.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(Int64Value.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Int64Value _build() {
            Int64Value int64ValueBuild = this._builder.build();
            t.h(int64ValueBuild, "_builder.build()");
            return int64ValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final long getValue() {
            return this._builder.getValue();
        }

        public final void setValue(long j10) {
            this._builder.setValue(j10);
        }

        private Dsl(Int64Value.Builder builder) {
            this._builder = builder;
        }
    }

    private Int64ValueKt() {
    }
}

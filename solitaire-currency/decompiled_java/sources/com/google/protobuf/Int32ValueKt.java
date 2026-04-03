package com.google.protobuf;

import com.google.protobuf.Int32Value;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Int32ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Int32ValueKt {

    @NotNull
    public static final Int32ValueKt INSTANCE = new Int32ValueKt();

    /* JADX INFO: compiled from: Int32ValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Int32Value.Builder _builder;

        /* JADX INFO: compiled from: Int32ValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Int32Value.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(Int32Value.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Int32Value _build() {
            Int32Value int32ValueBuild = this._builder.build();
            t.h(int32ValueBuild, "_builder.build()");
            return int32ValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final int getValue() {
            return this._builder.getValue();
        }

        public final void setValue(int i10) {
            this._builder.setValue(i10);
        }

        private Dsl(Int32Value.Builder builder) {
            this._builder = builder;
        }
    }

    private Int32ValueKt() {
    }
}

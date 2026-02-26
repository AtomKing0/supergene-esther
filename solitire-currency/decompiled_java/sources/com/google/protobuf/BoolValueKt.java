package com.google.protobuf;

import com.google.protobuf.BoolValue;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BoolValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BoolValueKt {

    @NotNull
    public static final BoolValueKt INSTANCE = new BoolValueKt();

    /* JADX INFO: compiled from: BoolValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BoolValue.Builder _builder;

        /* JADX INFO: compiled from: BoolValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BoolValue.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BoolValue.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BoolValue _build() {
            BoolValue boolValueBuild = this._builder.build();
            t.h(boolValueBuild, "_builder.build()");
            return boolValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final boolean getValue() {
            return this._builder.getValue();
        }

        public final void setValue(boolean z10) {
            this._builder.setValue(z10);
        }

        private Dsl(BoolValue.Builder builder) {
            this._builder = builder;
        }
    }

    private BoolValueKt() {
    }
}

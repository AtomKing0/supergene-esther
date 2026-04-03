package com.google.protobuf;

import com.google.protobuf.FloatValue;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FloatValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FloatValueKt {

    @NotNull
    public static final FloatValueKt INSTANCE = new FloatValueKt();

    /* JADX INFO: compiled from: FloatValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final FloatValue.Builder _builder;

        /* JADX INFO: compiled from: FloatValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(FloatValue.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(FloatValue.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ FloatValue _build() {
            FloatValue floatValueBuild = this._builder.build();
            t.h(floatValueBuild, "_builder.build()");
            return floatValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final float getValue() {
            return this._builder.getValue();
        }

        public final void setValue(float f10) {
            this._builder.setValue(f10);
        }

        private Dsl(FloatValue.Builder builder) {
            this._builder = builder;
        }
    }

    private FloatValueKt() {
    }
}

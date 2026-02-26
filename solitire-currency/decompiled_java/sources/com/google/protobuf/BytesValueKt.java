package com.google.protobuf;

import com.google.protobuf.BytesValue;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BytesValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BytesValueKt {

    @NotNull
    public static final BytesValueKt INSTANCE = new BytesValueKt();

    /* JADX INFO: compiled from: BytesValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BytesValue.Builder _builder;

        /* JADX INFO: compiled from: BytesValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BytesValue.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BytesValue.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BytesValue _build() {
            BytesValue bytesValueBuild = this._builder.build();
            t.h(bytesValueBuild, "_builder.build()");
            return bytesValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @NotNull
        public final ByteString getValue() {
            ByteString value = this._builder.getValue();
            t.h(value, "_builder.getValue()");
            return value;
        }

        public final void setValue(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setValue(value);
        }

        private Dsl(BytesValue.Builder builder) {
            this._builder = builder;
        }
    }

    private BytesValueKt() {
    }
}

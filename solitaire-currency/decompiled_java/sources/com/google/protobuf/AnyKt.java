package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnyKt {

    @NotNull
    public static final AnyKt INSTANCE = new AnyKt();

    /* JADX INFO: compiled from: AnyKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Any.Builder _builder;

        /* JADX INFO: compiled from: AnyKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Any.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(Any.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Any _build() {
            Any anyBuild = this._builder.build();
            t.h(anyBuild, "_builder.build()");
            return anyBuild;
        }

        public final void clearTypeUrl() {
            this._builder.clearTypeUrl();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @NotNull
        public final String getTypeUrl() {
            String typeUrl = this._builder.getTypeUrl();
            t.h(typeUrl, "_builder.getTypeUrl()");
            return typeUrl;
        }

        @NotNull
        public final ByteString getValue() {
            ByteString value = this._builder.getValue();
            t.h(value, "_builder.getValue()");
            return value;
        }

        public final void setTypeUrl(@NotNull String value) {
            t.i(value, "value");
            this._builder.setTypeUrl(value);
        }

        public final void setValue(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setValue(value);
        }

        private Dsl(Any.Builder builder) {
            this._builder = builder;
        }
    }

    private AnyKt() {
    }
}

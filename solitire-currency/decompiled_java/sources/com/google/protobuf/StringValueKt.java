package com.google.protobuf;

import com.google.protobuf.StringValue;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StringValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StringValueKt {

    @NotNull
    public static final StringValueKt INSTANCE = new StringValueKt();

    /* JADX INFO: compiled from: StringValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final StringValue.Builder _builder;

        /* JADX INFO: compiled from: StringValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(StringValue.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(StringValue.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ StringValue _build() {
            StringValue stringValueBuild = this._builder.build();
            t.h(stringValueBuild, "_builder.build()");
            return stringValueBuild;
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @NotNull
        public final String getValue() {
            String value = this._builder.getValue();
            t.h(value, "_builder.getValue()");
            return value;
        }

        public final void setValue(@NotNull String value) {
            t.i(value, "value");
            this._builder.setValue(value);
        }

        private Dsl(StringValue.Builder builder) {
            this._builder = builder;
        }
    }

    private StringValueKt() {
    }
}

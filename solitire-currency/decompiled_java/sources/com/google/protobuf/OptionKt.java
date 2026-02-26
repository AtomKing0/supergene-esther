package com.google.protobuf;

import com.google.protobuf.Option;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OptionKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OptionKt {

    @NotNull
    public static final OptionKt INSTANCE = new OptionKt();

    /* JADX INFO: compiled from: OptionKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Option.Builder _builder;

        /* JADX INFO: compiled from: OptionKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Option.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(Option.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Option _build() {
            Option optionBuild = this._builder.build();
            t.h(optionBuild, "_builder.build()");
            return optionBuild;
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @NotNull
        public final String getName() {
            String name = this._builder.getName();
            t.h(name, "_builder.getName()");
            return name;
        }

        @NotNull
        public final Any getValue() {
            Any value = this._builder.getValue();
            t.h(value, "_builder.getValue()");
            return value;
        }

        public final boolean hasValue() {
            return this._builder.hasValue();
        }

        public final void setName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setName(value);
        }

        public final void setValue(@NotNull Any value) {
            t.i(value, "value");
            this._builder.setValue(value);
        }

        private Dsl(Option.Builder builder) {
            this._builder = builder;
        }
    }

    private OptionKt() {
    }
}

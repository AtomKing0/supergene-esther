package com.google.protobuf;

import com.google.protobuf.Value;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ValueKt {

    @NotNull
    public static final ValueKt INSTANCE = new ValueKt();

    /* JADX INFO: compiled from: ValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Value.Builder _builder;

        /* JADX INFO: compiled from: ValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Value.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(Value.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Value _build() {
            Value valueBuild = this._builder.build();
            t.h(valueBuild, "_builder.build()");
            return valueBuild;
        }

        public final void clearBoolValue() {
            this._builder.clearBoolValue();
        }

        public final void clearKind() {
            this._builder.clearKind();
        }

        public final void clearListValue() {
            this._builder.clearListValue();
        }

        public final void clearNullValue() {
            this._builder.clearNullValue();
        }

        public final void clearNumberValue() {
            this._builder.clearNumberValue();
        }

        public final void clearStringValue() {
            this._builder.clearStringValue();
        }

        public final void clearStructValue() {
            this._builder.clearStructValue();
        }

        public final boolean getBoolValue() {
            return this._builder.getBoolValue();
        }

        @NotNull
        public final Value.KindCase getKindCase() {
            Value.KindCase kindCase = this._builder.getKindCase();
            t.h(kindCase, "_builder.getKindCase()");
            return kindCase;
        }

        @NotNull
        public final ListValue getListValue() {
            ListValue listValue = this._builder.getListValue();
            t.h(listValue, "_builder.getListValue()");
            return listValue;
        }

        @NotNull
        public final NullValue getNullValue() {
            NullValue nullValue = this._builder.getNullValue();
            t.h(nullValue, "_builder.getNullValue()");
            return nullValue;
        }

        public final double getNumberValue() {
            return this._builder.getNumberValue();
        }

        @NotNull
        public final String getStringValue() {
            String stringValue = this._builder.getStringValue();
            t.h(stringValue, "_builder.getStringValue()");
            return stringValue;
        }

        @NotNull
        public final Struct getStructValue() {
            Struct structValue = this._builder.getStructValue();
            t.h(structValue, "_builder.getStructValue()");
            return structValue;
        }

        public final boolean hasBoolValue() {
            return this._builder.hasBoolValue();
        }

        public final boolean hasListValue() {
            return this._builder.hasListValue();
        }

        public final boolean hasNullValue() {
            return this._builder.hasNullValue();
        }

        public final boolean hasNumberValue() {
            return this._builder.hasNumberValue();
        }

        public final boolean hasStringValue() {
            return this._builder.hasStringValue();
        }

        public final boolean hasStructValue() {
            return this._builder.hasStructValue();
        }

        public final void setBoolValue(boolean z10) {
            this._builder.setBoolValue(z10);
        }

        public final void setListValue(@NotNull ListValue value) {
            t.i(value, "value");
            this._builder.setListValue(value);
        }

        public final void setNullValue(@NotNull NullValue value) {
            t.i(value, "value");
            this._builder.setNullValue(value);
        }

        public final void setNumberValue(double d10) {
            this._builder.setNumberValue(d10);
        }

        public final void setStringValue(@NotNull String value) {
            t.i(value, "value");
            this._builder.setStringValue(value);
        }

        public final void setStructValue(@NotNull Struct value) {
            t.i(value, "value");
            this._builder.setStructValue(value);
        }

        private Dsl(Value.Builder builder) {
            this._builder = builder;
        }
    }

    private ValueKt() {
    }
}

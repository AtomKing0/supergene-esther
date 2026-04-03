package com.google.protobuf;

import com.google.protobuf.ListValue;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ListValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ListValueKt {

    @NotNull
    public static final ListValueKt INSTANCE = new ListValueKt();

    /* JADX INFO: compiled from: ListValueKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final ListValue.Builder _builder;

        /* JADX INFO: compiled from: ListValueKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(ListValue.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: ListValueKt.kt */
        public static final class ValuesProxy extends DslProxy {
            private ValuesProxy() {
            }
        }

        public /* synthetic */ Dsl(ListValue.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ ListValue _build() {
            ListValue listValueBuild = this._builder.build();
            t.h(listValueBuild, "_builder.build()");
            return listValueBuild;
        }

        public final /* synthetic */ void addAllValues(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllValues(values);
        }

        public final /* synthetic */ void addValues(DslList dslList, Value value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addValues(value);
        }

        public final /* synthetic */ void clearValues(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearValues();
        }

        public final /* synthetic */ DslList getValues() {
            List<Value> valuesList = this._builder.getValuesList();
            t.h(valuesList, "_builder.getValuesList()");
            return new DslList(valuesList);
        }

        public final /* synthetic */ void plusAssignAllValues(DslList<Value, ValuesProxy> dslList, Iterable<Value> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllValues(dslList, values);
        }

        public final /* synthetic */ void plusAssignValues(DslList<Value, ValuesProxy> dslList, Value value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addValues(dslList, value);
        }

        public final /* synthetic */ void setValues(DslList dslList, int i10, Value value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setValues(i10, value);
        }

        private Dsl(ListValue.Builder builder) {
            this._builder = builder;
        }
    }

    private ListValueKt() {
    }
}

package com.google.protobuf;

import com.google.protobuf.Type;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TypeKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeKt {

    @NotNull
    public static final TypeKt INSTANCE = new TypeKt();

    /* JADX INFO: compiled from: TypeKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Type.Builder _builder;

        /* JADX INFO: compiled from: TypeKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Type.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: TypeKt.kt */
        public static final class FieldsProxy extends DslProxy {
            private FieldsProxy() {
            }
        }

        /* JADX INFO: compiled from: TypeKt.kt */
        public static final class OneofsProxy extends DslProxy {
            private OneofsProxy() {
            }
        }

        /* JADX INFO: compiled from: TypeKt.kt */
        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Type.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Type _build() {
            Type typeBuild = this._builder.build();
            t.h(typeBuild, "_builder.build()");
            return typeBuild;
        }

        public final /* synthetic */ void addAllFields(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllFields(values);
        }

        public final /* synthetic */ void addAllOneofs(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllOneofs(values);
        }

        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllOptions(values);
        }

        public final /* synthetic */ void addFields(DslList dslList, Field value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addFields(value);
        }

        public final /* synthetic */ void addOneofs(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addOneofs(value);
        }

        public final /* synthetic */ void addOptions(DslList dslList, Option value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addOptions(value);
        }

        public final /* synthetic */ void clearFields(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearFields();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final /* synthetic */ void clearOneofs(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearOneofs();
        }

        public final /* synthetic */ void clearOptions(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final void clearSourceContext() {
            this._builder.clearSourceContext();
        }

        public final void clearSyntax() {
            this._builder.clearSyntax();
        }

        public final /* synthetic */ DslList getFields() {
            List<Field> fieldsList = this._builder.getFieldsList();
            t.h(fieldsList, "_builder.getFieldsList()");
            return new DslList(fieldsList);
        }

        @NotNull
        public final String getName() {
            String name = this._builder.getName();
            t.h(name, "_builder.getName()");
            return name;
        }

        @NotNull
        public final DslList<String, OneofsProxy> getOneofs() {
            List<String> oneofsList = this._builder.getOneofsList();
            t.h(oneofsList, "_builder.getOneofsList()");
            return new DslList<>(oneofsList);
        }

        public final /* synthetic */ DslList getOptions() {
            List<Option> optionsList = this._builder.getOptionsList();
            t.h(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
        }

        @NotNull
        public final SourceContext getSourceContext() {
            SourceContext sourceContext = this._builder.getSourceContext();
            t.h(sourceContext, "_builder.getSourceContext()");
            return sourceContext;
        }

        @NotNull
        public final Syntax getSyntax() {
            Syntax syntax = this._builder.getSyntax();
            t.h(syntax, "_builder.getSyntax()");
            return syntax;
        }

        public final boolean hasSourceContext() {
            return this._builder.hasSourceContext();
        }

        public final /* synthetic */ void plusAssignAllFields(DslList<Field, FieldsProxy> dslList, Iterable<Field> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllFields(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllOneofs(DslList<String, OneofsProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllOneofs(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllOptions(dslList, values);
        }

        public final /* synthetic */ void plusAssignFields(DslList<Field, FieldsProxy> dslList, Field value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addFields(dslList, value);
        }

        public final /* synthetic */ void plusAssignOneofs(DslList<String, OneofsProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addOneofs(dslList, value);
        }

        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addOptions(dslList, value);
        }

        public final /* synthetic */ void setFields(DslList dslList, int i10, Field value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setFields(i10, value);
        }

        public final void setName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setName(value);
        }

        public final /* synthetic */ void setOneofs(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setOneofs(i10, value);
        }

        public final /* synthetic */ void setOptions(DslList dslList, int i10, Option value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setOptions(i10, value);
        }

        public final void setSourceContext(@NotNull SourceContext value) {
            t.i(value, "value");
            this._builder.setSourceContext(value);
        }

        public final void setSyntax(@NotNull Syntax value) {
            t.i(value, "value");
            this._builder.setSyntax(value);
        }

        private Dsl(Type.Builder builder) {
            this._builder = builder;
        }
    }

    private TypeKt() {
    }
}

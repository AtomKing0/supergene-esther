package com.google.protobuf;

import com.google.protobuf.Enum;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnumKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EnumKt {

    @NotNull
    public static final EnumKt INSTANCE = new EnumKt();

    /* JADX INFO: compiled from: EnumKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Enum.Builder _builder;

        /* JADX INFO: compiled from: EnumKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Enum.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: EnumKt.kt */
        public static final class EnumvalueProxy extends DslProxy {
            private EnumvalueProxy() {
            }
        }

        /* JADX INFO: compiled from: EnumKt.kt */
        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Enum.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Enum _build() {
            Enum enumBuild = this._builder.build();
            t.h(enumBuild, "_builder.build()");
            return enumBuild;
        }

        public final /* synthetic */ void addAllEnumvalue(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllEnumvalue(values);
        }

        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllOptions(values);
        }

        public final /* synthetic */ void addEnumvalue(DslList dslList, EnumValue value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addEnumvalue(value);
        }

        public final /* synthetic */ void addOptions(DslList dslList, Option value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addOptions(value);
        }

        public final /* synthetic */ void clearEnumvalue(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearEnumvalue();
        }

        public final void clearName() {
            this._builder.clearName();
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

        public final /* synthetic */ DslList getEnumvalue() {
            List<EnumValue> enumvalueList = this._builder.getEnumvalueList();
            t.h(enumvalueList, "_builder.getEnumvalueList()");
            return new DslList(enumvalueList);
        }

        @NotNull
        public final String getName() {
            String name = this._builder.getName();
            t.h(name, "_builder.getName()");
            return name;
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

        public final /* synthetic */ void plusAssignAllEnumvalue(DslList<EnumValue, EnumvalueProxy> dslList, Iterable<EnumValue> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllEnumvalue(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllOptions(dslList, values);
        }

        public final /* synthetic */ void plusAssignEnumvalue(DslList<EnumValue, EnumvalueProxy> dslList, EnumValue value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addEnumvalue(dslList, value);
        }

        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addOptions(dslList, value);
        }

        public final /* synthetic */ void setEnumvalue(DslList dslList, int i10, EnumValue value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setEnumvalue(i10, value);
        }

        public final void setName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setName(value);
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

        private Dsl(Enum.Builder builder) {
            this._builder = builder;
        }
    }

    private EnumKt() {
    }
}

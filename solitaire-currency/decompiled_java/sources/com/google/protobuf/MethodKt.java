package com.google.protobuf;

import com.google.protobuf.Method;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MethodKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MethodKt {

    @NotNull
    public static final MethodKt INSTANCE = new MethodKt();

    /* JADX INFO: compiled from: MethodKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Method.Builder _builder;

        /* JADX INFO: compiled from: MethodKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Method.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: MethodKt.kt */
        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Method.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Method _build() {
            Method methodBuild = this._builder.build();
            t.h(methodBuild, "_builder.build()");
            return methodBuild;
        }

        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllOptions(values);
        }

        public final /* synthetic */ void addOptions(DslList dslList, Option value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addOptions(value);
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final /* synthetic */ void clearOptions(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final void clearRequestStreaming() {
            this._builder.clearRequestStreaming();
        }

        public final void clearRequestTypeUrl() {
            this._builder.clearRequestTypeUrl();
        }

        public final void clearResponseStreaming() {
            this._builder.clearResponseStreaming();
        }

        public final void clearResponseTypeUrl() {
            this._builder.clearResponseTypeUrl();
        }

        public final void clearSyntax() {
            this._builder.clearSyntax();
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

        public final boolean getRequestStreaming() {
            return this._builder.getRequestStreaming();
        }

        @NotNull
        public final String getRequestTypeUrl() {
            String requestTypeUrl = this._builder.getRequestTypeUrl();
            t.h(requestTypeUrl, "_builder.getRequestTypeUrl()");
            return requestTypeUrl;
        }

        public final boolean getResponseStreaming() {
            return this._builder.getResponseStreaming();
        }

        @NotNull
        public final String getResponseTypeUrl() {
            String responseTypeUrl = this._builder.getResponseTypeUrl();
            t.h(responseTypeUrl, "_builder.getResponseTypeUrl()");
            return responseTypeUrl;
        }

        @NotNull
        public final Syntax getSyntax() {
            Syntax syntax = this._builder.getSyntax();
            t.h(syntax, "_builder.getSyntax()");
            return syntax;
        }

        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllOptions(dslList, values);
        }

        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addOptions(dslList, value);
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

        public final void setRequestStreaming(boolean z10) {
            this._builder.setRequestStreaming(z10);
        }

        public final void setRequestTypeUrl(@NotNull String value) {
            t.i(value, "value");
            this._builder.setRequestTypeUrl(value);
        }

        public final void setResponseStreaming(boolean z10) {
            this._builder.setResponseStreaming(z10);
        }

        public final void setResponseTypeUrl(@NotNull String value) {
            t.i(value, "value");
            this._builder.setResponseTypeUrl(value);
        }

        public final void setSyntax(@NotNull Syntax value) {
            t.i(value, "value");
            this._builder.setSyntax(value);
        }

        private Dsl(Method.Builder builder) {
            this._builder = builder;
        }
    }

    private MethodKt() {
    }
}

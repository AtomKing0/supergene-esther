package com.google.protobuf;

import com.google.protobuf.Struct;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StructKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StructKt {

    @NotNull
    public static final StructKt INSTANCE = new StructKt();

    /* JADX INFO: compiled from: StructKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Struct.Builder _builder;

        /* JADX INFO: compiled from: StructKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Struct.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: StructKt.kt */
        public static final class FieldsProxy extends DslProxy {
            private FieldsProxy() {
            }
        }

        public /* synthetic */ Dsl(Struct.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Struct _build() {
            Struct structBuild = this._builder.build();
            t.h(structBuild, "_builder.build()");
            return structBuild;
        }

        public final /* synthetic */ void clearFields(DslMap dslMap) {
            t.i(dslMap, "<this>");
            this._builder.clearFields();
        }

        public final /* synthetic */ DslMap getFieldsMap() {
            Map<String, Value> fieldsMap = this._builder.getFieldsMap();
            t.h(fieldsMap, "_builder.getFieldsMap()");
            return new DslMap(fieldsMap);
        }

        public final /* synthetic */ void putAllFields(DslMap dslMap, Map map) {
            t.i(dslMap, "<this>");
            t.i(map, "map");
            this._builder.putAllFields(map);
        }

        public final void putFields(@NotNull DslMap<String, Value, FieldsProxy> dslMap, @NotNull String key, @NotNull Value value) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            t.i(value, "value");
            this._builder.putFields(key, value);
        }

        public final /* synthetic */ void removeFields(DslMap dslMap, String key) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            this._builder.removeFields(key);
        }

        public final /* synthetic */ void setFields(DslMap<String, Value, FieldsProxy> dslMap, String key, Value value) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            t.i(value, "value");
            putFields(dslMap, key, value);
        }

        private Dsl(Struct.Builder builder) {
            this._builder = builder;
        }
    }

    private StructKt() {
    }
}

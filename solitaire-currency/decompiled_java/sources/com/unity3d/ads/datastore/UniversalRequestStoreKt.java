package com.unity3d.ads.datastore;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UniversalRequestStoreKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalRequestStoreKt {

    @NotNull
    public static final UniversalRequestStoreKt INSTANCE = new UniversalRequestStoreKt();

    /* JADX INFO: compiled from: UniversalRequestStoreKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final UniversalRequestStoreOuterClass.UniversalRequestStore.Builder _builder;

        /* JADX INFO: compiled from: UniversalRequestStoreKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: UniversalRequestStoreKt.kt */
        public static final class UniversalRequestMapProxy extends DslProxy {
            private UniversalRequestMapProxy() {
            }
        }

        public /* synthetic */ Dsl(UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ UniversalRequestStoreOuterClass.UniversalRequestStore _build() {
            UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStoreBuild = this._builder.build();
            t.h(universalRequestStoreBuild, "_builder.build()");
            return universalRequestStoreBuild;
        }

        public final /* synthetic */ void clearUniversalRequestMap(DslMap dslMap) {
            t.i(dslMap, "<this>");
            this._builder.clearUniversalRequestMap();
        }

        public final /* synthetic */ DslMap getUniversalRequestMapMap() {
            Map<String, ByteString> universalRequestMapMap = this._builder.getUniversalRequestMapMap();
            t.h(universalRequestMapMap, "_builder.getUniversalRequestMapMap()");
            return new DslMap(universalRequestMapMap);
        }

        public final /* synthetic */ void putAllUniversalRequestMap(DslMap dslMap, Map map) {
            t.i(dslMap, "<this>");
            t.i(map, "map");
            this._builder.putAllUniversalRequestMap(map);
        }

        public final void putUniversalRequestMap(@NotNull DslMap<String, ByteString, UniversalRequestMapProxy> dslMap, @NotNull String key, @NotNull ByteString value) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            t.i(value, "value");
            this._builder.putUniversalRequestMap(key, value);
        }

        public final /* synthetic */ void removeUniversalRequestMap(DslMap dslMap, String key) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            this._builder.removeUniversalRequestMap(key);
        }

        public final /* synthetic */ void setUniversalRequestMap(DslMap<String, ByteString, UniversalRequestMapProxy> dslMap, String key, ByteString value) {
            t.i(dslMap, "<this>");
            t.i(key, "key");
            t.i(value, "value");
            putUniversalRequestMap(dslMap, key, value);
        }

        private Dsl(UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder) {
            this._builder = builder;
        }
    }

    private UniversalRequestStoreKt() {
    }
}

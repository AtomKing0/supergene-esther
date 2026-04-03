package com.unity3d.ads.datastore;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ByteStringStoreKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ByteStringStoreKt {

    @NotNull
    public static final ByteStringStoreKt INSTANCE = new ByteStringStoreKt();

    /* JADX INFO: compiled from: ByteStringStoreKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final ByteStringStoreOuterClass.ByteStringStore.Builder _builder;

        /* JADX INFO: compiled from: ByteStringStoreKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(ByteStringStoreOuterClass.ByteStringStore.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(ByteStringStoreOuterClass.ByteStringStore.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ ByteStringStoreOuterClass.ByteStringStore _build() {
            ByteStringStoreOuterClass.ByteStringStore byteStringStoreBuild = this._builder.build();
            t.h(byteStringStoreBuild, "_builder.build()");
            return byteStringStoreBuild;
        }

        public final void clearData() {
            this._builder.clearData();
        }

        @NotNull
        public final ByteString getData() {
            ByteString data = this._builder.getData();
            t.h(data, "_builder.getData()");
            return data;
        }

        public final void setData(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setData(value);
        }

        private Dsl(ByteStringStoreOuterClass.ByteStringStore.Builder builder) {
            this._builder = builder;
        }
    }

    private ByteStringStoreKt() {
    }
}

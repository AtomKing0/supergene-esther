package com.google.protobuf;

import com.google.protobuf.Mixin;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MixinKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MixinKt {

    @NotNull
    public static final MixinKt INSTANCE = new MixinKt();

    /* JADX INFO: compiled from: MixinKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Mixin.Builder _builder;

        /* JADX INFO: compiled from: MixinKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Mixin.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(Mixin.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Mixin _build() {
            Mixin mixinBuild = this._builder.build();
            t.h(mixinBuild, "_builder.build()");
            return mixinBuild;
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearRoot() {
            this._builder.clearRoot();
        }

        @NotNull
        public final String getName() {
            String name = this._builder.getName();
            t.h(name, "_builder.getName()");
            return name;
        }

        @NotNull
        public final String getRoot() {
            String root = this._builder.getRoot();
            t.h(root, "_builder.getRoot()");
            return root;
        }

        public final void setName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setName(value);
        }

        public final void setRoot(@NotNull String value) {
            t.i(value, "value");
            this._builder.setRoot(value);
        }

        private Dsl(Mixin.Builder builder) {
            this._builder = builder;
        }
    }

    private MixinKt() {
    }
}

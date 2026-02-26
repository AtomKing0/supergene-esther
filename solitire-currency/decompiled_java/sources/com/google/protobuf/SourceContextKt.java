package com.google.protobuf;

import com.google.protobuf.SourceContext;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SourceContextKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SourceContextKt {

    @NotNull
    public static final SourceContextKt INSTANCE = new SourceContextKt();

    /* JADX INFO: compiled from: SourceContextKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final SourceContext.Builder _builder;

        /* JADX INFO: compiled from: SourceContextKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(SourceContext.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(SourceContext.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ SourceContext _build() {
            SourceContext sourceContextBuild = this._builder.build();
            t.h(sourceContextBuild, "_builder.build()");
            return sourceContextBuild;
        }

        public final void clearFileName() {
            this._builder.clearFileName();
        }

        @NotNull
        public final String getFileName() {
            String fileName = this._builder.getFileName();
            t.h(fileName, "_builder.getFileName()");
            return fileName;
        }

        public final void setFileName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setFileName(value);
        }

        private Dsl(SourceContext.Builder builder) {
            this._builder = builder;
        }
    }

    private SourceContextKt() {
    }
}

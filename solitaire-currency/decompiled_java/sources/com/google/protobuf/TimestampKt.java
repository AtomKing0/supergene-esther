package com.google.protobuf;

import com.google.protobuf.Timestamp;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TimestampKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimestampKt {

    @NotNull
    public static final TimestampKt INSTANCE = new TimestampKt();

    /* JADX INFO: compiled from: TimestampKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final Timestamp.Builder _builder;

        /* JADX INFO: compiled from: TimestampKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Timestamp.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(Timestamp.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ Timestamp _build() {
            Timestamp timestampBuild = this._builder.build();
            t.h(timestampBuild, "_builder.build()");
            return timestampBuild;
        }

        public final void clearNanos() {
            this._builder.clearNanos();
        }

        public final void clearSeconds() {
            this._builder.clearSeconds();
        }

        public final int getNanos() {
            return this._builder.getNanos();
        }

        public final long getSeconds() {
            return this._builder.getSeconds();
        }

        public final void setNanos(int i10) {
            this._builder.setNanos(i10);
        }

        public final void setSeconds(long j10) {
            this._builder.setSeconds(j10);
        }

        private Dsl(Timestamp.Builder builder) {
            this._builder = builder;
        }
    }

    private TimestampKt() {
    }
}

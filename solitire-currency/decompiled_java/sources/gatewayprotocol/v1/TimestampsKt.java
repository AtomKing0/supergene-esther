package gatewayprotocol.v1;

import com.google.protobuf.Timestamp;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.TimestampsOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TimestampsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimestampsKt {

    @NotNull
    public static final TimestampsKt INSTANCE = new TimestampsKt();

    /* JADX INFO: compiled from: TimestampsKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final TimestampsOuterClass.Timestamps.Builder _builder;

        /* JADX INFO: compiled from: TimestampsKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(TimestampsOuterClass.Timestamps.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(TimestampsOuterClass.Timestamps.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ TimestampsOuterClass.Timestamps _build() {
            TimestampsOuterClass.Timestamps timestampsBuild = this._builder.build();
            t.h(timestampsBuild, "_builder.build()");
            return timestampsBuild;
        }

        public final void clearSessionTimestamp() {
            this._builder.clearSessionTimestamp();
        }

        public final void clearTimestamp() {
            this._builder.clearTimestamp();
        }

        public final long getSessionTimestamp() {
            return this._builder.getSessionTimestamp();
        }

        @NotNull
        public final Timestamp getTimestamp() {
            Timestamp timestamp = this._builder.getTimestamp();
            t.h(timestamp, "_builder.getTimestamp()");
            return timestamp;
        }

        public final boolean hasTimestamp() {
            return this._builder.hasTimestamp();
        }

        public final void setSessionTimestamp(long j10) {
            this._builder.setSessionTimestamp(j10);
        }

        public final void setTimestamp(@NotNull Timestamp value) {
            t.i(value, "value");
            this._builder.setTimestamp(value);
        }

        private Dsl(TimestampsOuterClass.Timestamps.Builder builder) {
            this._builder = builder;
        }
    }

    private TimestampsKt() {
    }
}

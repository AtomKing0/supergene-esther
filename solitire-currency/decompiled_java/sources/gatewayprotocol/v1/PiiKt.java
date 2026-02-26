package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.PiiOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PiiKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PiiKt {

    @NotNull
    public static final PiiKt INSTANCE = new PiiKt();

    /* JADX INFO: compiled from: PiiKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final PiiOuterClass.Pii.Builder _builder;

        /* JADX INFO: compiled from: PiiKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(PiiOuterClass.Pii.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(PiiOuterClass.Pii.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ PiiOuterClass.Pii _build() {
            PiiOuterClass.Pii piiBuild = this._builder.build();
            t.h(piiBuild, "_builder.build()");
            return piiBuild;
        }

        public final void clearAdvertisingId() {
            this._builder.clearAdvertisingId();
        }

        public final void clearOpenAdvertisingTrackingId() {
            this._builder.clearOpenAdvertisingTrackingId();
        }

        public final void clearVendorId() {
            this._builder.clearVendorId();
        }

        @NotNull
        public final ByteString getAdvertisingId() {
            ByteString advertisingId = this._builder.getAdvertisingId();
            t.h(advertisingId, "_builder.getAdvertisingId()");
            return advertisingId;
        }

        @NotNull
        public final ByteString getOpenAdvertisingTrackingId() {
            ByteString openAdvertisingTrackingId = this._builder.getOpenAdvertisingTrackingId();
            t.h(openAdvertisingTrackingId, "_builder.getOpenAdvertisingTrackingId()");
            return openAdvertisingTrackingId;
        }

        @NotNull
        public final ByteString getVendorId() {
            ByteString vendorId = this._builder.getVendorId();
            t.h(vendorId, "_builder.getVendorId()");
            return vendorId;
        }

        public final void setAdvertisingId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setAdvertisingId(value);
        }

        public final void setOpenAdvertisingTrackingId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setOpenAdvertisingTrackingId(value);
        }

        public final void setVendorId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setVendorId(value);
        }

        private Dsl(PiiOuterClass.Pii.Builder builder) {
            this._builder = builder;
        }
    }

    private PiiKt() {
    }
}

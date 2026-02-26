package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PublisherKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PublisherKt {

    @NotNull
    public static final PublisherKt INSTANCE = new PublisherKt();

    /* JADX INFO: compiled from: PublisherKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.Publisher.Builder _builder;

        /* JADX INFO: compiled from: PublisherKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.Publisher.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.Publisher.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.Publisher _build() {
            BidRequestEventOuterClass.Publisher publisherBuild = this._builder.build();
            t.h(publisherBuild, "_builder.build()");
            return publisherBuild;
        }

        public final void clearDomain() {
            this._builder.clearDomain();
        }

        public final void clearId() {
            this._builder.clearId();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        @NotNull
        public final String getDomain() {
            String domain = this._builder.getDomain();
            t.h(domain, "_builder.getDomain()");
            return domain;
        }

        @NotNull
        public final String getId() {
            String id = this._builder.getId();
            t.h(id, "_builder.getId()");
            return id;
        }

        @NotNull
        public final String getName() {
            String name = this._builder.getName();
            t.h(name, "_builder.getName()");
            return name;
        }

        public final boolean hasDomain() {
            return this._builder.hasDomain();
        }

        public final boolean hasId() {
            return this._builder.hasId();
        }

        public final boolean hasName() {
            return this._builder.hasName();
        }

        public final void setDomain(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDomain(value);
        }

        public final void setId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setId(value);
        }

        public final void setName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setName(value);
        }

        private Dsl(BidRequestEventOuterClass.Publisher.Builder builder) {
            this._builder = builder;
        }
    }

    private PublisherKt() {
    }
}

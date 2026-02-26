package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UserKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UserKt {

    @NotNull
    public static final UserKt INSTANCE = new UserKt();

    /* JADX INFO: compiled from: UserKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.User.Builder _builder;

        /* JADX INFO: compiled from: UserKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.User.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.User.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.User _build() {
            BidRequestEventOuterClass.User userBuild = this._builder.build();
            t.h(userBuild, "_builder.build()");
            return userBuild;
        }

        public final void clearConsent() {
            this._builder.clearConsent();
        }

        public final void clearId() {
            this._builder.clearId();
        }

        @NotNull
        public final String getConsent() {
            String consent = this._builder.getConsent();
            t.h(consent, "_builder.getConsent()");
            return consent;
        }

        @NotNull
        public final String getId() {
            String id = this._builder.getId();
            t.h(id, "_builder.getId()");
            return id;
        }

        public final boolean hasConsent() {
            return this._builder.hasConsent();
        }

        public final boolean hasId() {
            return this._builder.hasId();
        }

        public final void setConsent(@NotNull String value) {
            t.i(value, "value");
            this._builder.setConsent(value);
        }

        public final void setId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setId(value);
        }

        private Dsl(BidRequestEventOuterClass.User.Builder builder) {
            this._builder = builder;
        }
    }

    private UserKt() {
    }
}

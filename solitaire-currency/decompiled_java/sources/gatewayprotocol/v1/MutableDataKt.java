package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.MutableDataOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MutableDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MutableDataKt {

    @NotNull
    public static final MutableDataKt INSTANCE = new MutableDataKt();

    /* JADX INFO: compiled from: MutableDataKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final MutableDataOuterClass.MutableData.Builder _builder;

        /* JADX INFO: compiled from: MutableDataKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(MutableDataOuterClass.MutableData.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(MutableDataOuterClass.MutableData.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ MutableDataOuterClass.MutableData _build() {
            MutableDataOuterClass.MutableData mutableDataBuild = this._builder.build();
            t.h(mutableDataBuild, "_builder.build()");
            return mutableDataBuild;
        }

        public final void clearAllowedPii() {
            this._builder.clearAllowedPii();
        }

        public final void clearCache() {
            this._builder.clearCache();
        }

        public final void clearCurrentState() {
            this._builder.clearCurrentState();
        }

        public final void clearPrivacy() {
            this._builder.clearPrivacy();
        }

        public final void clearPrivacyFsm() {
            this._builder.clearPrivacyFsm();
        }

        public final void clearSessionCounters() {
            this._builder.clearSessionCounters();
        }

        public final void clearSessionToken() {
            this._builder.clearSessionToken();
        }

        @NotNull
        public final AllowedPiiOuterClass.AllowedPii getAllowedPii() {
            AllowedPiiOuterClass.AllowedPii allowedPii = this._builder.getAllowedPii();
            t.h(allowedPii, "_builder.getAllowedPii()");
            return allowedPii;
        }

        @Nullable
        public final AllowedPiiOuterClass.AllowedPii getAllowedPiiOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return MutableDataKtKt.getAllowedPiiOrNull(dsl._builder);
        }

        @NotNull
        public final ByteString getCache() {
            ByteString cache = this._builder.getCache();
            t.h(cache, "_builder.getCache()");
            return cache;
        }

        @NotNull
        public final ByteString getCurrentState() {
            ByteString currentState = this._builder.getCurrentState();
            t.h(currentState, "_builder.getCurrentState()");
            return currentState;
        }

        @NotNull
        public final ByteString getPrivacy() {
            ByteString privacy = this._builder.getPrivacy();
            t.h(privacy, "_builder.getPrivacy()");
            return privacy;
        }

        @NotNull
        public final ByteString getPrivacyFsm() {
            ByteString privacyFsm = this._builder.getPrivacyFsm();
            t.h(privacyFsm, "_builder.getPrivacyFsm()");
            return privacyFsm;
        }

        @NotNull
        public final SessionCountersOuterClass.SessionCounters getSessionCounters() {
            SessionCountersOuterClass.SessionCounters sessionCounters = this._builder.getSessionCounters();
            t.h(sessionCounters, "_builder.getSessionCounters()");
            return sessionCounters;
        }

        @Nullable
        public final SessionCountersOuterClass.SessionCounters getSessionCountersOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return MutableDataKtKt.getSessionCountersOrNull(dsl._builder);
        }

        @NotNull
        public final ByteString getSessionToken() {
            ByteString sessionToken = this._builder.getSessionToken();
            t.h(sessionToken, "_builder.getSessionToken()");
            return sessionToken;
        }

        public final boolean hasAllowedPii() {
            return this._builder.hasAllowedPii();
        }

        public final boolean hasCache() {
            return this._builder.hasCache();
        }

        public final boolean hasCurrentState() {
            return this._builder.hasCurrentState();
        }

        public final boolean hasPrivacy() {
            return this._builder.hasPrivacy();
        }

        public final boolean hasPrivacyFsm() {
            return this._builder.hasPrivacyFsm();
        }

        public final boolean hasSessionCounters() {
            return this._builder.hasSessionCounters();
        }

        public final boolean hasSessionToken() {
            return this._builder.hasSessionToken();
        }

        public final void setAllowedPii(@NotNull AllowedPiiOuterClass.AllowedPii value) {
            t.i(value, "value");
            this._builder.setAllowedPii(value);
        }

        public final void setCache(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setCache(value);
        }

        public final void setCurrentState(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setCurrentState(value);
        }

        public final void setPrivacy(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setPrivacy(value);
        }

        public final void setPrivacyFsm(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setPrivacyFsm(value);
        }

        public final void setSessionCounters(@NotNull SessionCountersOuterClass.SessionCounters value) {
            t.i(value, "value");
            this._builder.setSessionCounters(value);
        }

        public final void setSessionToken(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setSessionToken(value);
        }

        private Dsl(MutableDataOuterClass.MutableData.Builder builder) {
            this._builder = builder;
        }
    }

    private MutableDataKt() {
    }
}

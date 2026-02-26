package com.unity3d.ads.core.data.model;

import com.google.protobuf.ByteString;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SessionChange.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class SessionChange {

    /* JADX INFO: compiled from: SessionChange.kt */
    public static final class PrivacyFsmChange extends SessionChange {

        @NotNull
        private final ByteString value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivacyFsmChange(@NotNull ByteString value) {
            super(null);
            t.i(value, "value");
            this.value = value;
        }

        public static /* synthetic */ PrivacyFsmChange copy$default(PrivacyFsmChange privacyFsmChange, ByteString byteString, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                byteString = privacyFsmChange.value;
            }
            return privacyFsmChange.copy(byteString);
        }

        @NotNull
        public final ByteString component1() {
            return this.value;
        }

        @NotNull
        public final PrivacyFsmChange copy(@NotNull ByteString value) {
            t.i(value, "value");
            return new PrivacyFsmChange(value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PrivacyFsmChange) && t.d(this.value, ((PrivacyFsmChange) obj).value);
        }

        @NotNull
        public final ByteString getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "PrivacyFsmChange(value=" + this.value + ')';
        }
    }

    /* JADX INFO: compiled from: SessionChange.kt */
    public static final class UserConsentChange extends SessionChange {

        @NotNull
        private final ByteString value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserConsentChange(@NotNull ByteString value) {
            super(null);
            t.i(value, "value");
            this.value = value;
        }

        public static /* synthetic */ UserConsentChange copy$default(UserConsentChange userConsentChange, ByteString byteString, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                byteString = userConsentChange.value;
            }
            return userConsentChange.copy(byteString);
        }

        @NotNull
        public final ByteString component1() {
            return this.value;
        }

        @NotNull
        public final UserConsentChange copy(@NotNull ByteString value) {
            t.i(value, "value");
            return new UserConsentChange(value);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserConsentChange) && t.d(this.value, ((UserConsentChange) obj).value);
        }

        @NotNull
        public final ByteString getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return "UserConsentChange(value=" + this.value + ')';
        }
    }

    private SessionChange() {
    }

    public /* synthetic */ SessionChange(k kVar) {
        this();
    }
}

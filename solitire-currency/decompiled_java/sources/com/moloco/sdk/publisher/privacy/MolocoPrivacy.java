package com.moloco.sdk.publisher.privacy;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class MolocoPrivacy {

    @NotNull
    public static final MolocoPrivacy INSTANCE = new MolocoPrivacy();

    @NotNull
    private static PrivacySettings privacySettings = new PrivacySettings(null, null, null, 7, null);
    public static final int $stable = 8;

    @StabilityInferred(parameters = 0)
    public static final class PrivacySettings {
        public static final int $stable = 8;

        @Nullable
        private String TCFConsent;

        @Nullable
        private final Boolean isAgeRestrictedUser;

        @Nullable
        private final Boolean isDoNotSell;

        @Nullable
        private final Boolean isUserConsent;

        public PrivacySettings() {
            this(null, null, null, 7, null);
        }

        private final String get_usPrivacy() {
            Boolean bool = this.isDoNotSell;
            return MolocoPrivacyKt.getUSPrivacyConsentString(bool == null ? "1---" : t.d(bool, Boolean.TRUE) ? "1-Y-" : "1-N-");
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrivacySettings)) {
                return false;
            }
            PrivacySettings privacySettings = (PrivacySettings) obj;
            return t.d(this.isUserConsent, privacySettings.isUserConsent) && t.d(this.isAgeRestrictedUser, privacySettings.isAgeRestrictedUser) && t.d(this.isDoNotSell, privacySettings.isDoNotSell) && t.d(this.TCFConsent, privacySettings.TCFConsent);
        }

        @Nullable
        public final String getTCFConsent() {
            return this.TCFConsent;
        }

        @NotNull
        public final String getUsPrivacy() {
            return get_usPrivacy();
        }

        public int hashCode() {
            Boolean bool = this.isUserConsent;
            int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Boolean bool2 = this.isAgeRestrictedUser;
            int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Boolean bool3 = this.isDoNotSell;
            int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            String str = this.TCFConsent;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        @Nullable
        public final Boolean isAgeRestrictedUser() {
            return this.isAgeRestrictedUser;
        }

        @Nullable
        public final Boolean isDoNotSell() {
            return this.isDoNotSell;
        }

        @Nullable
        public final Boolean isUserConsent() {
            return this.isUserConsent;
        }

        public PrivacySettings(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
            this.isUserConsent = bool;
            this.isAgeRestrictedUser = bool2;
            this.isDoNotSell = bool3;
        }

        public /* synthetic */ PrivacySettings(Boolean bool, Boolean bool2, Boolean bool3, int i10, k kVar) {
            this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : bool2, (i10 & 4) != 0 ? null : bool3);
        }

        public PrivacySettings(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str) {
            this(bool, bool2, bool3);
            this.TCFConsent = str;
        }
    }

    private MolocoPrivacy() {
    }

    public static final void setPrivacy(@NotNull PrivacySettings privacySettings2) {
        t.i(privacySettings2, "privacySettings");
        privacySettings = privacySettings2;
    }

    @NotNull
    public final PrivacySettings getPrivacySettings() {
        PrivacySettings privacySettings2 = privacySettings;
        Boolean boolGdprApplies = MolocoPrivacyKt.gdprApplies();
        PrivacySettings privacySettings3 = new PrivacySettings(boolGdprApplies == null ? privacySettings2.isUserConsent() : boolGdprApplies, privacySettings2.isAgeRestrictedUser(), privacySettings2.isDoNotSell(), MolocoPrivacyKt.getTCFConsent());
        if (boolGdprApplies != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoPrivacy", "PrivacySettings (isUserConsent/gdpr): " + boolGdprApplies + ", (isAgeRestrictedUser/coppa): " + privacySettings3.isAgeRestrictedUser() + ", (isDoNotSell/ccpa): " + privacySettings3.isDoNotSell(), null, false, 12, null);
        } else {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoPrivacy", "PrivacySettings (isUserConsent/gdpr): " + privacySettings3.isUserConsent() + ", (isAgeRestrictedUser/coppa): " + privacySettings3.isAgeRestrictedUser() + ", (isDoNotSell/ccpa): " + privacySettings3.isDoNotSell(), null, false, 12, null);
        }
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "MolocoPrivacy", "PrivacySettings (TCF): " + privacySettings3.getTCFConsent(), null, false, 12, null);
        return privacySettings3;
    }
}

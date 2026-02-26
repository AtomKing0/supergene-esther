package q7;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.k;
import com.vungle.ads.internal.model.g;
import com.vungle.ads.internal.util.p;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: PrivacyManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    @Nullable
    private static q7.b ccpaConsent;

    @Nullable
    private static com.vungle.ads.internal.persistence.b filePreferences;

    @Nullable
    private static String gdprConsent;

    @Nullable
    private static String gdprConsentMessageVersion;

    @Nullable
    private static String gdprConsentSource;

    @Nullable
    private static Long gdprConsentTimestamp;

    @Nullable
    private static SharedPreferences sharedPreferences;

    @NotNull
    public static final c INSTANCE = new c();

    @NotNull
    private static final AtomicReference<Boolean> disableAdId = new AtomicReference<>();

    @NotNull
    private static final AtomicReference<Boolean> coppaStatus = new AtomicReference<>();

    @NotNull
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    /* JADX INFO: compiled from: PrivacyManager.kt */
    public enum a {
        ALLOW_ID,
        DISABLE_ID,
        FALLBACK
    }

    /* JADX INFO: compiled from: PrivacyManager.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.DISABLE_ID.ordinal()] = 1;
            iArr[a.FALLBACK.ordinal()] = 2;
            iArr[a.ALLOW_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[g.h.c.values().length];
            iArr2[g.h.c.DISABLE_ID.ordinal()] = 1;
            iArr2[g.h.c.ALLOW_ID.ordinal()] = 2;
            iArr2[g.h.c.LEGACY.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private c() {
    }

    private final void saveCcpaConsent(q7.b bVar) {
        com.vungle.ads.internal.persistence.b bVarPut;
        com.vungle.ads.internal.persistence.b bVar2 = filePreferences;
        if (bVar2 == null || (bVarPut = bVar2.put("ccpa_status", bVar.getValue())) == null) {
            return;
        }
        bVarPut.apply();
    }

    private final void saveCoppaConsent(boolean z10) {
        com.vungle.ads.internal.persistence.b bVarPut;
        com.vungle.ads.internal.persistence.b bVar = filePreferences;
        if (bVar == null || (bVarPut = bVar.put("is_coppa", z10)) == null) {
            return;
        }
        bVarPut.apply();
    }

    private final void saveGdprConsent(String str, String str2, String str3, long j10) {
        com.vungle.ads.internal.persistence.b bVarPut;
        com.vungle.ads.internal.persistence.b bVarPut2;
        com.vungle.ads.internal.persistence.b bVarPut3;
        com.vungle.ads.internal.persistence.b bVarPut4;
        com.vungle.ads.internal.persistence.b bVar = filePreferences;
        if (bVar == null || (bVarPut = bVar.put("gdpr_status", str)) == null || (bVarPut2 = bVarPut.put("gdpr_source", str2)) == null || (bVarPut3 = bVarPut2.put("gdpr_message_version", str3)) == null || (bVarPut4 = bVarPut3.put("gdpr_timestamp", j10)) == null) {
            return;
        }
        bVarPut4.apply();
    }

    @NotNull
    public final a allowDeviceIDFromTCF() {
        Boolean gdprAppliesFromPreferences = getGdprAppliesFromPreferences();
        if (!t.d(gdprAppliesFromPreferences, Boolean.TRUE)) {
            return gdprAppliesFromPreferences == null ? a.FALLBACK : a.ALLOW_ID;
        }
        g.h.c tcfStatus = k.INSTANCE.getTcfStatus();
        int i10 = tcfStatus == null ? -1 : b.$EnumSwitchMapping$1[tcfStatus.ordinal()];
        if (i10 != -1) {
            if (i10 == 1) {
                return a.DISABLE_ID;
            }
            if (i10 == 2) {
                return a.ALLOW_ID;
            }
            if (i10 != 3) {
                throw new q();
            }
        }
        return a.FALLBACK;
    }

    @NotNull
    public final String getCcpaStatus() {
        String value;
        q7.b bVar = ccpaConsent;
        return (bVar == null || (value = bVar.getValue()) == null) ? q7.b.OPT_IN.getValue() : value;
    }

    @NotNull
    public final String getConsentMessageVersion() {
        String str = gdprConsentMessageVersion;
        return str == null ? "" : str;
    }

    @NotNull
    public final String getConsentSource() {
        String str = gdprConsentSource;
        return str == null ? "no_interaction" : str;
    }

    @NotNull
    public final String getConsentStatus() {
        String str = gdprConsent;
        return str == null ? "unknown" : str;
    }

    public final long getConsentTimestamp() {
        Long l10 = gdprConsentTimestamp;
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    @NotNull
    public final q7.a getCoppaStatus() {
        AtomicReference<Boolean> atomicReference = coppaStatus;
        return atomicReference.get() == null ? q7.a.COPPA_NOTSET : t.d(atomicReference.get(), Boolean.TRUE) ? q7.a.COPPA_ENABLED : t.d(atomicReference.get(), Boolean.FALSE) ? q7.a.COPPA_DISABLED : q7.a.COPPA_NOTSET;
    }

    @VisibleForTesting
    @Nullable
    public final Boolean getDisableAdId$vungle_ads_release() {
        return disableAdId.get();
    }

    @Nullable
    public final Boolean getGdprAppliesFromPreferences() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        Integer numValueOf = sharedPreferences2 != null ? Integer.valueOf(sharedPreferences2.getInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, -1)) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return Boolean.TRUE;
        }
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return Boolean.FALSE;
        }
        return null;
    }

    @NotNull
    public final String getIABTCFString() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        String string = sharedPreferences2 != null ? sharedPreferences2.getString("IABTCF_TCString", "") : null;
        return string == null ? "" : string;
    }

    @Nullable
    public final String getPreviousTcfToken() {
        com.vungle.ads.internal.persistence.b bVar = filePreferences;
        if (bVar != null) {
            return bVar.getString("previous_tcf_token", "");
        }
        return null;
    }

    @Nullable
    public final SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public final synchronized void init(@NotNull Context context) {
        t.i(context, "context");
        AtomicBoolean atomicBoolean = initialized;
        if (atomicBoolean.get()) {
            p.Companion.w("PrivacyManager", "PrivacyManager already initialized");
            return;
        }
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        com.vungle.ads.internal.persistence.b bVar = (com.vungle.ads.internal.persistence.b) ServiceLocator.Companion.getInstance(context).getService(com.vungle.ads.internal.persistence.b.class);
        filePreferences = bVar;
        AtomicReference<Boolean> atomicReference = disableAdId;
        Boolean bool = atomicReference.get();
        if (bool != null) {
            saveDisableAdId(bool.booleanValue());
        } else {
            Boolean bool2 = bVar.getBoolean("disable_ad_id");
            if (bool2 != null) {
                atomicReference.set(Boolean.valueOf(bool2.booleanValue()));
            }
        }
        String str = gdprConsent;
        if (str != null) {
            String str2 = gdprConsentSource;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            String str4 = gdprConsentMessageVersion;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = str4;
            Long l10 = gdprConsentTimestamp;
            saveGdprConsent(str, str3, str5, l10 != null ? l10.longValue() : 0L);
        } else {
            String string = bVar.getString("gdpr_status");
            q7.b bVar2 = q7.b.OPT_IN;
            if (t.d(string, bVar2.getValue())) {
                string = bVar2.getValue();
            } else {
                q7.b bVar3 = q7.b.OPT_OUT;
                if (t.d(string, bVar3.getValue())) {
                    string = bVar3.getValue();
                }
            }
            gdprConsent = string;
            gdprConsentSource = bVar.getString("gdpr_source");
            gdprConsentMessageVersion = bVar.getString("gdpr_message_version");
            gdprConsentTimestamp = Long.valueOf(bVar.getLong("gdpr_timestamp", 0L));
        }
        q7.b bVar4 = ccpaConsent;
        if (bVar4 != null) {
            saveCcpaConsent(bVar4);
        } else {
            String string2 = bVar.getString("ccpa_status");
            q7.b bVar5 = q7.b.OPT_OUT;
            if (!t.d(bVar5.getValue(), string2)) {
                bVar5 = q7.b.OPT_IN;
            }
            ccpaConsent = bVar5;
        }
        AtomicReference<Boolean> atomicReference2 = coppaStatus;
        Boolean bool3 = atomicReference2.get();
        if (bool3 != null) {
            saveCoppaConsent(bool3.booleanValue());
        } else {
            Boolean bool4 = bVar.getBoolean("is_coppa");
            if (bool4 != null) {
                atomicReference2.set(Boolean.valueOf(bool4.booleanValue()));
            }
        }
        atomicBoolean.set(true);
    }

    @VisibleForTesting
    public final void saveDisableAdId(boolean z10) {
        com.vungle.ads.internal.persistence.b bVarPut;
        com.vungle.ads.internal.persistence.b bVar = filePreferences;
        if (bVar == null || (bVarPut = bVar.put("disable_ad_id", z10)) == null) {
            return;
        }
        bVarPut.apply();
    }

    public final void setPreviousTcfToken(@Nullable String str) {
        com.vungle.ads.internal.persistence.b bVar;
        com.vungle.ads.internal.persistence.b bVarPut;
        if ((str == null || str.length() == 0) || (bVar = filePreferences) == null || (bVarPut = bVar.put("previous_tcf_token", str)) == null) {
            return;
        }
        bVarPut.apply();
    }

    public final void setSharedPreferences(@Nullable SharedPreferences sharedPreferences2) {
        sharedPreferences = sharedPreferences2;
    }

    public final boolean shouldReturnTrueForLegacy$vungle_ads_release() {
        String iABTCFString = getIABTCFString();
        if (t.d(getPreviousTcfToken(), iABTCFString)) {
            return false;
        }
        setPreviousTcfToken(iABTCFString);
        return true;
    }

    public final boolean shouldSendAdIds() {
        int i10 = b.$EnumSwitchMapping$0[allowDeviceIDFromTCF().ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2 && i10 != 3) {
            throw new q();
        }
        Boolean disableAdId$vungle_ads_release = getDisableAdId$vungle_ads_release();
        return (disableAdId$vungle_ads_release == null || disableAdId$vungle_ads_release.booleanValue()) ? false : true;
    }

    public final boolean shouldSendTCFString() {
        if (!t.d(getGdprAppliesFromPreferences(), Boolean.TRUE)) {
            return false;
        }
        g.h.c tcfStatus = k.INSTANCE.getTcfStatus();
        int i10 = tcfStatus == null ? -1 : b.$EnumSwitchMapping$1[tcfStatus.ordinal()];
        if (i10 != -1) {
            if (i10 == 1 || i10 == 2) {
                return true;
            }
            if (i10 != 3) {
                throw new q();
            }
        }
        return shouldReturnTrueForLegacy$vungle_ads_release();
    }

    public final void updateCcpaConsent(@NotNull q7.b consent) {
        t.i(consent, "consent");
        ccpaConsent = consent;
        saveCcpaConsent(consent);
    }

    public final void updateCoppaConsent(boolean z10) {
        coppaStatus.set(Boolean.valueOf(z10));
        saveCoppaConsent(z10);
    }

    public final void updateDisableAdId(boolean z10) {
        disableAdId.set(Boolean.valueOf(z10));
        saveDisableAdId(z10);
    }

    public final void updateGdprConsent(@NotNull String consent, @NotNull String source, @Nullable String str) {
        t.i(consent, "consent");
        t.i(source, "source");
        gdprConsent = consent;
        gdprConsentSource = source;
        gdprConsentMessageVersion = str;
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        gdprConsentTimestamp = Long.valueOf(jCurrentTimeMillis);
        String str2 = gdprConsentMessageVersion;
        if (str2 == null) {
            str2 = "";
        }
        saveGdprConsent(consent, source, str2, jCurrentTimeMillis);
    }
}

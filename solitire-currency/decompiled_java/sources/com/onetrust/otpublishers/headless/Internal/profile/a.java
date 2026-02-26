package com.onetrust.otpublishers.headless.Internal.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21899a;

    public a(@NonNull Context context) {
        this.f21899a = context;
    }

    public final void a(@NonNull SharedPreferences sharedPreferences, @NonNull SharedPreferences.Editor editor, @Nullable SharedPreferences.Editor editor2) {
        HashMap map = new com.onetrust.otpublishers.headless.gpp.c(this.f21899a).f23791b;
        if (map.keySet().isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                Integer num = (Integer) map.get(str);
                if (Objects.equals(num, com.onetrust.otpublishers.headless.gpp.c.f23788d)) {
                    if (sharedPreferences.contains(str)) {
                        editor.putInt(str, sharedPreferences.getInt(str, -1));
                        if (editor2 != null) {
                            editor2.remove(str);
                        }
                    }
                } else if (Objects.equals(num, com.onetrust.otpublishers.headless.gpp.c.f23789e) && sharedPreferences.contains(str)) {
                    editor.putString(str, sharedPreferences.getString(str, ""));
                    if (editor2 != null) {
                        editor2.remove(str);
                    }
                }
            }
        }
    }

    public final void b(@NonNull SharedPreferences sharedPreferences, @NonNull SharedPreferences.Editor editor, @Nullable SharedPreferences.Editor editor2, boolean z10, boolean z11, boolean z12, boolean z13) {
        if (z10) {
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_CMPSDKID)) {
                editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKID, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_CMPSDKID, -1));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_CMPSDKID);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_CMPSDKVERSION)) {
                editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKVERSION, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_CMPSDKVERSION, -1));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_CMPSDKVERSION);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_POLICYVERSION)) {
                editor.putInt(OTIABTCFKeys.IABTCF_POLICYVERSION, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_POLICYVERSION, -1));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_POLICYVERSION);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_GDPRAPPLIES)) {
                editor.putInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, -1));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_GDPRAPPLIES);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT)) {
                editor.putInt(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT, -1));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCC)) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCC, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCC, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCC);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCC)) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCC, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCC, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCC);
                }
            }
            if (sharedPreferences.contains("IABTCF_TCString")) {
                editor.putString("IABTCF_TCString", sharedPreferences.getString("IABTCF_TCString", ""));
                if (editor2 != null) {
                    editor2.remove("IABTCF_TCString");
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_VENDORCONSENTS)) {
                editor.putString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_VENDORCONSENTS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS)) {
                editor.putString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PURPOSECONSENTS)) {
                editor.putString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PURPOSECONSENTS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS)) {
                editor.putString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS)) {
                editor.putString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT)) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS)) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS)) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS)) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, sharedPreferences.getString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT)) {
                editor.putString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, sharedPreferences.getString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, ""));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT);
                }
            }
            for (int i10 = 1; i10 <= 11; i10++) {
                String str = OTIABTCFKeys.IABTCF_PUBLISHERRESTRICTIONS + String.valueOf(i10);
                if (sharedPreferences.contains(str)) {
                    editor.putString(str, sharedPreferences.getString(str, ""));
                    if (editor2 != null) {
                        editor2.remove(str);
                    }
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS)) {
                editor.putInt(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS, -1));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS);
                }
            }
            if (sharedPreferences.contains(OTIABTCFKeys.IABTCF_USENONSTANDARDTEXTS)) {
                editor.putInt(OTIABTCFKeys.IABTCF_USENONSTANDARDTEXTS, sharedPreferences.getInt(OTIABTCFKeys.IABTCF_USENONSTANDARDTEXTS, -1));
                if (editor2 != null) {
                    editor2.remove(OTIABTCFKeys.IABTCF_USENONSTANDARDTEXTS);
                }
            }
        }
        if (z11 && sharedPreferences.contains(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING)) {
            editor.putString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, sharedPreferences.getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, ""));
            if (editor2 != null) {
                editor2.remove(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING);
            }
        }
        if (z12) {
            a(sharedPreferences, editor, editor2);
        } else if (z13) {
            e(sharedPreferences, editor, null);
        }
    }

    @VisibleForTesting
    public final void c(@NonNull String str, boolean z10, boolean z11, boolean z12) {
        if (z10) {
            com.onetrust.otpublishers.headless.Internal.Helper.d.a("Restore of default shared preference data, profile id = ", str, "DefaultSPHelper", 3);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21899a);
            SharedPreferences sharedPreferences = this.f21899a.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new d(this.f21899a).n(str.toLowerCase(Locale.US)), 0);
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            b(sharedPreferences, editorEdit, null, true, z11, z12, false);
            if (z12) {
                a(sharedPreferences, editorEdit, null);
            }
            editorEdit.apply();
        }
    }

    @VisibleForTesting
    public final void d(@Nullable String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        if (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            OTLogger.a("DefaultSPHelper", 3, "backupData called with empty currentActiveProfileId, back up failed.");
            return;
        }
        if (z10) {
            OTLogger.a("DefaultSPHelper", 3, "Taking backup of default shared preference data, profile id = ".concat(str));
            OTLogger.a("DefaultSPHelper", 3, "Clearing default shared preference keys after the back up completes. Flag = " + z11);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21899a);
            SharedPreferences.Editor editorEdit = this.f21899a.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new d(this.f21899a).n(str.toLowerCase(Locale.US)), 0).edit();
            SharedPreferences.Editor editorEdit2 = z11 ? defaultSharedPreferences.edit() : null;
            b(defaultSharedPreferences, editorEdit, editorEdit2, z12, z13, z14, z15);
            editorEdit.apply();
            if (editorEdit2 != null) {
                editorEdit2.apply();
            }
        }
    }

    public final void e(@NonNull SharedPreferences sharedPreferences, @NonNull SharedPreferences.Editor editor, @Nullable SharedPreferences.Editor editor2) {
        HashMap map = new com.onetrust.otpublishers.headless.gpp.c(this.f21899a).f23791b;
        if (map.keySet().isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                if (!com.onetrust.otpublishers.headless.Internal.c.q(str) && str.startsWith("IABGPP_TCFEU2_")) {
                    Integer num = (Integer) map.get(str);
                    if (Objects.equals(num, com.onetrust.otpublishers.headless.gpp.c.f23788d)) {
                        if (sharedPreferences.contains(str)) {
                            editor.putInt(str, sharedPreferences.getInt(str, -1));
                            if (editor2 != null) {
                                editor2.remove(str);
                            }
                        }
                    } else if (Objects.equals(num, com.onetrust.otpublishers.headless.gpp.c.f23789e) && sharedPreferences.contains(str)) {
                        editor.putString(str, sharedPreferences.getString(str, ""));
                        if (editor2 != null) {
                            editor2.remove(str);
                        }
                    }
                }
            }
        }
    }
}

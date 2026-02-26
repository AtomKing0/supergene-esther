package com.king.firebaseanalytics;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import androidx.preference.PreferenceManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class ComplianceDMA {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SharedPreferences f17052a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f17053b = "-";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static String f17054c = "-";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static String f17055d = "-";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static String f17056e = "-";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static boolean f17057f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static boolean f17058g = false;

        private static boolean a(String str, int i10) {
            return i10 < str.length() && str.charAt(i10) == '1';
        }

        private static int b(String str) {
            return f17052a.getInt(str, -1);
        }

        private static String c(String str) {
            return f17052a.getString(str, "-");
        }

        private static Map<FirebaseAnalytics.b, FirebaseAnalytics.a> d() {
            EnumMap enumMap = new EnumMap(FirebaseAnalytics.b.class);
            FirebaseAnalytics.b bVar = FirebaseAnalytics.b.ANALYTICS_STORAGE;
            FirebaseAnalytics.a aVar = FirebaseAnalytics.a.GRANTED;
            enumMap.put(bVar, aVar);
            enumMap.put(FirebaseAnalytics.b.AD_STORAGE, aVar);
            enumMap.put(FirebaseAnalytics.b.AD_USER_DATA, aVar);
            enumMap.put(FirebaseAnalytics.b.AD_PERSONALIZATION, aVar);
            return enumMap;
        }

        private static Map<FirebaseAnalytics.b, FirebaseAnalytics.a> e() {
            EnumMap enumMap = new EnumMap(FirebaseAnalytics.b.class);
            FirebaseAnalytics.b bVar = FirebaseAnalytics.b.ANALYTICS_STORAGE;
            FirebaseAnalytics.a aVar = FirebaseAnalytics.a.GRANTED;
            enumMap.put(bVar, aVar);
            enumMap.put(FirebaseAnalytics.b.AD_STORAGE, aVar);
            enumMap.put(FirebaseAnalytics.b.AD_USER_DATA, aVar);
            enumMap.put(FirebaseAnalytics.b.AD_PERSONALIZATION, g(f17053b, 2));
            return enumMap;
        }

        private static Map<FirebaseAnalytics.b, FirebaseAnalytics.a> f() {
            EnumMap enumMap = new EnumMap(FirebaseAnalytics.b.class);
            FirebaseAnalytics.b bVar = FirebaseAnalytics.b.ANALYTICS_STORAGE;
            FirebaseAnalytics.a aVar = FirebaseAnalytics.a.DENIED;
            enumMap.put(bVar, aVar);
            FirebaseAnalytics.b bVar2 = FirebaseAnalytics.b.AD_STORAGE;
            enumMap.put(bVar2, aVar);
            FirebaseAnalytics.b bVar3 = FirebaseAnalytics.b.AD_USER_DATA;
            enumMap.put(bVar3, aVar);
            FirebaseAnalytics.b bVar4 = FirebaseAnalytics.b.AD_PERSONALIZATION;
            enumMap.put(bVar4, aVar);
            if (a(f17056e, 754)) {
                enumMap.put(bVar, FirebaseAnalytics.a.GRANTED);
            }
            if (a(f17055d, 754)) {
                boolean zA = a(f17054c, 0);
                boolean zA2 = a(f17054c, 2);
                boolean zA3 = a(f17054c, 3);
                boolean zA4 = a(f17054c, 6);
                if (zA) {
                    enumMap.put(bVar2, FirebaseAnalytics.a.GRANTED);
                }
                if (zA2 && zA3) {
                    enumMap.put(bVar4, FirebaseAnalytics.a.GRANTED);
                }
                if (zA4 && zA) {
                    enumMap.put(bVar3, FirebaseAnalytics.a.GRANTED);
                }
            }
            return enumMap;
        }

        private static FirebaseAnalytics.a g(String str, int i10) {
            return i10 >= str.length() ? FirebaseAnalytics.a.DENIED : str.charAt(i10) == 'Y' ? FirebaseAnalytics.a.DENIED : FirebaseAnalytics.a.GRANTED;
        }

        private static void h(Context context) {
            f17052a = PreferenceManager.getDefaultSharedPreferences(context);
            f17057f = b(OTIABTCFKeys.IABTCF_GDPRAPPLIES) == 1;
            f17053b = c(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING);
            f17054c = c(OTIABTCFKeys.IABTCF_PURPOSECONSENTS);
            f17055d = c(OTIABTCFKeys.IABTCF_VENDORCONSENTS);
            f17056e = c(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS);
            f17058g = f17053b.matches("1...");
        }

        public static Map<FirebaseAnalytics.b, FirebaseAnalytics.a> i(Context context) {
            h(context);
            return f17057f ? f() : f17058g ? e() : d();
        }
    }
}

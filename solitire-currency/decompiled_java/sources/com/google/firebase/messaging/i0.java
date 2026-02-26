package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Tasks;
import com.ironsource.v8;
import d6.a;
import io.sentry.protocol.TransactionInfo;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: MessagingAnalytics.java */
/* JADX INFO: loaded from: classes3.dex */
public class i0 {
    public static boolean A(Intent intent) {
        if (intent == null || r(intent)) {
            return false;
        }
        return a();
    }

    public static boolean B(Intent intent) {
        if (intent == null || r(intent)) {
            return false;
        }
        return C(intent.getExtras());
    }

    public static boolean C(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            i5.e.k();
            Context contextJ = i5.e.k().j();
            SharedPreferences sharedPreferences = contextJ.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = contextJ.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextJ.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    static d6.a b(a.b bVar, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        a.C0540a c0540aH = d6.a.p().m(p(extras)).e(bVar).f(f(extras)).i(m()).k(a.d.ANDROID).h(k(extras));
        String strH = h(extras);
        if (strH != null) {
            c0540aH.g(strH);
        }
        String strO = o(extras);
        if (strO != null) {
            c0540aH.l(strO);
        }
        String strC = c(extras);
        if (strC != null) {
            c0540aH.c(strC);
        }
        String strI = i(extras);
        if (strI != null) {
            c0540aH.b(strI);
        }
        String strE = e(extras);
        if (strE != null) {
            c0540aH.d(strE);
        }
        long jN = n(extras);
        if (jN > 0) {
            c0540aH.j(jN);
        }
        return c0540aH.a();
    }

    @Nullable
    static String c(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    @Nullable
    static String d(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    @Nullable
    static String e(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    @NonNull
    static String f(Bundle bundle) {
        String string = bundle.getString("google.to");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) Tasks.await(com.google.firebase.installations.c.q(i5.e.k()).getId());
        } catch (InterruptedException | ExecutionException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Nullable
    static String g(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    @Nullable
    static String h(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        return string == null ? bundle.getString("message_id") : string;
    }

    @Nullable
    static String i(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    @Nullable
    static String j(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    @NonNull
    static a.c k(Bundle bundle) {
        return (bundle == null || !k0.t(bundle)) ? a.c.DATA_MESSAGE : a.c.DISPLAY_NOTIFICATION;
    }

    @NonNull
    static String l(Bundle bundle) {
        return (bundle == null || !k0.t(bundle)) ? "data" : v8.h.f15785d;
    }

    @NonNull
    static String m() {
        return i5.e.k().j().getPackageName();
    }

    @Nullable
    static long n(Bundle bundle) {
        if (bundle.containsKey("google.c.sender.id")) {
            try {
                return Long.parseLong(bundle.getString("google.c.sender.id"));
            } catch (NumberFormatException e10) {
                Log.w("FirebaseMessaging", "error parsing project number", e10);
            }
        }
        i5.e eVarK = i5.e.k();
        String strD = eVarK.m().d();
        if (strD != null) {
            try {
                return Long.parseLong(strD);
            } catch (NumberFormatException e11) {
                Log.w("FirebaseMessaging", "error parsing sender ID", e11);
            }
        }
        String strC = eVarK.m().c();
        if (strC.startsWith("1:")) {
            String[] strArrSplit = strC.split(":");
            if (strArrSplit.length < 2) {
                return 0L;
            }
            String str = strArrSplit[1];
            if (str.isEmpty()) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e12) {
                Log.w("FirebaseMessaging", "error parsing app ID", e12);
            }
        } else {
            try {
                return Long.parseLong(strC);
            } catch (NumberFormatException e13) {
                Log.w("FirebaseMessaging", "error parsing app ID", e13);
            }
        }
        return 0L;
    }

    @Nullable
    static String o(Bundle bundle) {
        String string = bundle.getString(TypedValues.TransitionType.S_FROM);
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    @NonNull
    static int p(Bundle bundle) {
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    @Nullable
    static String q(Bundle bundle) {
        if (bundle.containsKey("google.c.a.udt")) {
            return bundle.getString("google.c.a.udt");
        }
        return null;
    }

    private static boolean r(Intent intent) {
        return FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction());
    }

    public static void s(Intent intent) {
        x("_nd", intent.getExtras());
    }

    public static void t(Intent intent) {
        x("_nf", intent.getExtras());
    }

    public static void u(Bundle bundle) {
        z(bundle);
        x("_no", bundle);
    }

    public static void v(Intent intent) {
        if (B(intent)) {
            x("_nr", intent.getExtras());
        }
        if (A(intent)) {
            w(a.b.MESSAGE_DELIVERED, intent, FirebaseMessaging.getTransportFactory());
        }
    }

    private static void w(a.b bVar, Intent intent, @Nullable w1.i iVar) {
        if (iVar == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        d6.a aVarB = b(bVar, intent);
        if (aVarB == null) {
            return;
        }
        try {
            iVar.a("FCM_CLIENT_EVENT_LOGGING", d6.b.class, w1.c.b("proto"), new w1.g() { // from class: com.google.firebase.messaging.h0
                @Override // w1.g
                public final Object apply(Object obj) {
                    return ((d6.b) obj).c();
                }
            }).a(w1.d.f(d6.b.b().b(aVarB).a(), w1.f.b(Integer.valueOf(intent.getIntExtra("google.product_id", 111881503)))));
        } catch (RuntimeException e10) {
            Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e10);
        }
    }

    @VisibleForTesting
    static void x(String str, Bundle bundle) {
        try {
            i5.e.k();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String strD = d(bundle);
            if (strD != null) {
                bundle2.putString("_nmid", strD);
            }
            String strE = e(bundle);
            if (strE != null) {
                bundle2.putString("_nmn", strE);
            }
            String strI = i(bundle);
            if (!TextUtils.isEmpty(strI)) {
                bundle2.putString("label", strI);
            }
            String strG = g(bundle);
            if (!TextUtils.isEmpty(strG)) {
                bundle2.putString("message_channel", strG);
            }
            String strO = o(bundle);
            if (strO != null) {
                bundle2.putString("_nt", strO);
            }
            String strJ = j(bundle);
            if (strJ != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(strJ));
                } catch (NumberFormatException e10) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e10);
                }
            }
            String strQ = q(bundle);
            if (strQ != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(strQ));
                } catch (NumberFormatException e11) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e11);
                }
            }
            String strL = l(bundle);
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", strL);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            j5.a aVar = (j5.a) i5.e.k().i(j5.a.class);
            if (aVar != null) {
                aVar.a(AppMeasurement.FCM_ORIGIN, str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    static void y(boolean z10) {
        i5.e.k().j().getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", z10).apply();
    }

    private static void z(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!"1".equals(bundle.getString("google.c.a.tc"))) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                return;
            }
            return;
        }
        j5.a aVar = (j5.a) i5.e.k().i(j5.a.class);
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
        }
        if (aVar == null) {
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            return;
        }
        String string = bundle.getString("google.c.a.c_id");
        aVar.b(AppMeasurement.FCM_ORIGIN, "_ln", string);
        Bundle bundle2 = new Bundle();
        bundle2.putString(TransactionInfo.JsonKeys.SOURCE, "Firebase");
        bundle2.putString("medium", "notification");
        bundle2.putString("campaign", string);
        aVar.a(AppMeasurement.FCM_ORIGIN, "_cmp", bundle2);
    }
}

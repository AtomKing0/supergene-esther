package z5;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.messaging.FirebaseMessaging;
import i5.e;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IidStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f37579c = {ProxyConfig.MATCH_ALL_SCHEMES, FirebaseMessaging.INSTANCE_ID_SCOPE, CodePackage.GCM, ""};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("iidPrefs")
    private final SharedPreferences f37580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f37581b;

    public b(@NonNull e eVar) {
        this.f37580a = eVar.j().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f37581b = b(eVar);
    }

    private String a(@NonNull String str, @NonNull String str2) {
        return "|T|" + str + "|" + str2;
    }

    private static String b(e eVar) {
        String strD = eVar.m().d();
        if (strD != null) {
            return strD;
        }
        String strC = eVar.m().c();
        if (!strC.startsWith("1:") && !strC.startsWith("2:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(":");
        if (strArrSplit.length != 4) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    @Nullable
    private static String c(@NonNull PublicKey publicKey) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e10) {
            Log.w("ContentValues", "Invalid key stored " + e10);
            return null;
        }
    }

    @Nullable
    private String g() {
        String string;
        synchronized (this.f37580a) {
            string = this.f37580a.getString("|S|id", null);
        }
        return string;
    }

    @Nullable
    private String h() {
        synchronized (this.f37580a) {
            String string = this.f37580a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            PublicKey publicKeyE = e(string);
            if (publicKeyE == null) {
                return null;
            }
            return c(publicKeyE);
        }
    }

    @Nullable
    public String f() {
        synchronized (this.f37580a) {
            String strG = g();
            if (strG != null) {
                return strG;
            }
            return h();
        }
    }

    @Nullable
    public String i() {
        synchronized (this.f37580a) {
            for (String str : f37579c) {
                String string = this.f37580a.getString(a(this.f37581b, str), null);
                if (string != null && !string.isEmpty()) {
                    if (string.startsWith("{")) {
                        string = d(string);
                    }
                    return string;
                }
            }
            return null;
        }
    }
}

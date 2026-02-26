package com.king.amp.sa;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: NetworkObstructionChecker.java */
/* JADX INFO: loaded from: classes4.dex */
public class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static b f16843a = new b() { // from class: com.king.amp.sa.m1
        @Override // com.king.amp.sa.o1.b
        public final Enumeration get() {
            return NetworkInterface.getNetworkInterfaces();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    static c f16844b = new c() { // from class: com.king.amp.sa.n1
        @Override // com.king.amp.sa.o1.c
        public final HttpURLConnection a(URL url) {
            return o1.e(url);
        }
    };

    /* JADX INFO: compiled from: NetworkObstructionChecker.java */
    public interface a {
        void a(boolean z10, boolean z11);
    }

    /* JADX INFO: compiled from: NetworkObstructionChecker.java */
    @VisibleForTesting
    interface b {
        Enumeration<NetworkInterface> get() throws Exception;
    }

    /* JADX INFO: compiled from: NetworkObstructionChecker.java */
    @VisibleForTesting
    interface c {
        HttpURLConnection a(URL url) throws Exception;
    }

    public static void b(@NonNull a aVar) {
        if (!c()) {
            l1.d("NetObstructionCheck", "Internet is not reachable");
            aVar.a(false, false);
            return;
        }
        boolean zD = d();
        l1.a("NetObstructionCheck", "VPN: " + zD);
        aVar.a(true, zD);
    }

    public static boolean c() {
        HttpURLConnection httpURLConnectionA = null;
        try {
            try {
                httpURLConnectionA = f16844b.a(new URL("https://www.gstatic.com/generate_204"));
                httpURLConnectionA.setConnectTimeout(500);
                httpURLConnectionA.setReadTimeout(1000);
                httpURLConnectionA.setRequestMethod("GET");
                int responseCode = httpURLConnectionA.getResponseCode();
                boolean z10 = responseCode == 204;
                if (!z10) {
                    l1.d("NetObstructionCheck", "Unexpected response code: " + responseCode);
                }
                httpURLConnectionA.disconnect();
                return z10;
            } catch (Exception e10) {
                l1.e("NetObstructionCheck", "Internet connectivity check failed", e10);
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                return false;
            }
        } catch (Throwable th) {
            if (httpURLConnectionA != null) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    public static boolean d() {
        try {
            Iterator it = Collections.list(f16843a.get()).iterator();
            while (it.hasNext()) {
                String name = ((NetworkInterface) it.next()).getName();
                if (name.startsWith("tun") || name.startsWith("ppp") || name.startsWith("ipsec") || name.startsWith("utun") || name.startsWith("wg") || name.contains("vpn")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            l1.e("NetObstructionCheck", "Unable to check interfaces", e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HttpURLConnection e(URL url) throws Exception {
        return (HttpURLConnection) url.openConnection();
    }
}

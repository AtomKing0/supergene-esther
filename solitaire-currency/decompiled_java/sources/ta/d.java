package ta;

import androidx.webkit.ProxyConfig;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;
import p9.r;
import ua.b1;

/* JADX INFO: compiled from: OkHostnameVerifier.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f34196a = new d();

    private d() {
    }

    private final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale US = Locale.US;
        t.h(US, "US");
        String lowerCase = str.toLowerCase(US);
        t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> c(X509Certificate x509Certificate, int i10) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return v.l();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && t.d(list.get(0), Integer.valueOf(i10)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return v.l();
        }
    }

    private final boolean d(String str) {
        return str.length() == ((int) b1.b(str, 0, 0, 3, null));
    }

    private final boolean f(String str, String str2) {
        if (!(str == null || str.length() == 0) && !q.K(str, ".", false, 2, null) && !q.w(str, "..", false, 2, null)) {
            if (!(str2 == null || str2.length() == 0) && !q.K(str2, ".", false, 2, null) && !q.w(str2, "..", false, 2, null)) {
                if (!q.w(str, ".", false, 2, null)) {
                    str = t.r(str, ".");
                }
                String str3 = str;
                if (!q.w(str2, ".", false, 2, null)) {
                    str2 = t.r(str2, ".");
                }
                String strB = b(str2);
                if (!r.P(strB, ProxyConfig.MATCH_ALL_SCHEMES, false, 2, null)) {
                    return t.d(str3, strB);
                }
                if (!q.K(strB, "*.", false, 2, null) || r.d0(strB, '*', 1, false, 4, null) != -1 || str3.length() < strB.length() || t.d("*.", strB)) {
                    return false;
                }
                String strSubstring = strB.substring(1);
                t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                if (!q.w(str3, strSubstring, false, 2, null)) {
                    return false;
                }
                int length = str3.length() - strSubstring.length();
                return length <= 0 || r.j0(str3, '.', length + (-1), false, 4, null) == -1;
            }
        }
        return false;
    }

    private final boolean g(String str, X509Certificate x509Certificate) {
        String strB = b(str);
        List<String> listC = c(x509Certificate, 2);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            if (f34196a.f(strB, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(String str, X509Certificate x509Certificate) {
        String strE = ha.a.e(str);
        List<String> listC = c(x509Certificate, 7);
        if ((listC instanceof Collection) && listC.isEmpty()) {
            return false;
        }
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            if (t.d(strE, ha.a.e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<String> a(@NotNull X509Certificate certificate) {
        t.i(certificate, "certificate");
        return d0.A0(c(certificate, 7), c(certificate, 2));
    }

    public final boolean e(@NotNull String host, @NotNull X509Certificate certificate) {
        t.i(host, "host");
        t.i(certificate, "certificate");
        return ha.d.i(host) ? h(host, certificate) : g(host, certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        t.i(host, "host");
        t.i(session, "session");
        if (!d(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return e(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}

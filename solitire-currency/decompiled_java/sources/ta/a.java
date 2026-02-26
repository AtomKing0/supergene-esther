package ta;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final C0698a f34192c = new C0698a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final e f34193b;

    /* JADX INFO: renamed from: ta.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
    public static final class C0698a {
        private C0698a() {
        }

        public /* synthetic */ C0698a(k kVar) {
            this();
        }
    }

    public a(@NotNull e trustRootIndex) {
        t.i(trustRootIndex, "trustRootIndex");
        this.f34193b = trustRootIndex;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!t.d(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // ta.c
    @NotNull
    public List<Certificate> a(@NotNull List<? extends Certificate> chain, @NotNull String hostname) throws SSLPeerUnverifiedException {
        t.i(chain, "chain");
        t.i(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        t.h(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        int i10 = 0;
        boolean z10 = false;
        while (i10 < 9) {
            i10++;
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateA = this.f34193b.a(x509Certificate);
            if (x509CertificateA == null) {
                Iterator it = arrayDeque.iterator();
                t.h(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (b(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException(t.r("Failed to find a trusted cert that signed ", x509Certificate));
            }
            if (arrayList.size() > 1 || !t.d(x509Certificate, x509CertificateA)) {
                arrayList.add(x509CertificateA);
            }
            if (b(x509CertificateA, x509CertificateA)) {
                return arrayList;
            }
            z10 = true;
        }
        throw new SSLPeerUnverifiedException(t.r("Certificate chain too long: ", arrayList));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && t.d(((a) obj).f34193b, this.f34193b);
    }

    public int hashCode() {
        return this.f34193b.hashCode();
    }
}

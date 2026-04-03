package ga;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.f;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final b f26060c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final g f26061d = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Set<c> f26062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final ta.c f26063b;

    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<c> f26064a = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final g a() {
            return new g(kotlin.collections.d0.T0(this.f26064a), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final String a(@NotNull Certificate certificate) {
            kotlin.jvm.internal.t.i(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return kotlin.jvm.internal.t.r("sha256/", c((X509Certificate) certificate).a());
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        @NotNull
        public final ua.f b(@NotNull X509Certificate x509Certificate) {
            kotlin.jvm.internal.t.i(x509Certificate, "<this>");
            f.a aVar = ua.f.f34755d;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.t.h(encoded, "publicKey.encoded");
            return f.a.g(aVar, encoded, 0, 0, 3, null).z();
        }

        @NotNull
        public final ua.f c(@NotNull X509Certificate x509Certificate) {
            kotlin.jvm.internal.t.i(x509Certificate, "<this>");
            f.a aVar = ua.f.f34755d;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            kotlin.jvm.internal.t.h(encoded, "publicKey.encoded");
            return f.a.g(aVar, encoded, 0, 0, 3, null).A();
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f26065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f26066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final ua.f f26067c;

        @NotNull
        public final ua.f a() {
            return this.f26067c;
        }

        @NotNull
        public final String b() {
            return this.f26066b;
        }

        public final boolean c(@NotNull String hostname) {
            kotlin.jvm.internal.t.i(hostname, "hostname");
            if (p9.q.K(this.f26065a, "**.", false, 2, null)) {
                int length = this.f26065a.length() - 3;
                int length2 = hostname.length() - length;
                if (!p9.q.B(hostname, hostname.length() - length, this.f26065a, 3, length, false, 16, null)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!p9.q.K(this.f26065a, "*.", false, 2, null)) {
                    return kotlin.jvm.internal.t.d(hostname, this.f26065a);
                }
                int length3 = this.f26065a.length() - 1;
                int length4 = hostname.length() - length3;
                if (!p9.q.B(hostname, hostname.length() - length3, this.f26065a, 1, length3, false, 16, null) || p9.r.j0(hostname, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.t.d(this.f26065a, cVar.f26065a) && kotlin.jvm.internal.t.d(this.f26066b, cVar.f26066b) && kotlin.jvm.internal.t.d(this.f26067c, cVar.f26067c);
        }

        public int hashCode() {
            return (((this.f26065a.hashCode() * 31) + this.f26066b.hashCode()) * 31) + this.f26067c.hashCode();
        }

        @NotNull
        public String toString() {
            return this.f26066b + '/' + this.f26067c.a();
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    static final class d extends kotlin.jvm.internal.v implements h9.a<List<? extends X509Certificate>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List<Certificate> f26069h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f26070i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(List<? extends Certificate> list, String str) {
            super(0);
            this.f26069h = list;
            this.f26070i = str;
        }

        @Override // h9.a
        @NotNull
        public final List<? extends X509Certificate> invoke() {
            ta.c cVarD = g.this.d();
            List<Certificate> listA = cVarD == null ? null : cVarD.a(this.f26069h, this.f26070i);
            if (listA == null) {
                listA = this.f26069h;
            }
            List<Certificate> list = listA;
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((X509Certificate) ((Certificate) it.next()));
            }
            return arrayList;
        }
    }

    public g(@NotNull Set<c> pins, @Nullable ta.c cVar) {
        kotlin.jvm.internal.t.i(pins, "pins");
        this.f26062a = pins;
        this.f26063b = cVar;
    }

    public final void a(@NotNull String hostname, @NotNull List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.t.i(hostname, "hostname");
        kotlin.jvm.internal.t.i(peerCertificates, "peerCertificates");
        b(hostname, new d(peerCertificates, hostname));
    }

    public final void b(@NotNull String hostname, @NotNull h9.a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        kotlin.jvm.internal.t.i(hostname, "hostname");
        kotlin.jvm.internal.t.i(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<c> listC = c(hostname);
        if (listC.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            ua.f fVarC = null;
            ua.f fVarB = null;
            for (c cVar : listC) {
                String strB = cVar.b();
                if (kotlin.jvm.internal.t.d(strB, "sha256")) {
                    if (fVarC == null) {
                        fVarC = f26060c.c(x509Certificate);
                    }
                    if (kotlin.jvm.internal.t.d(cVar.a(), fVarC)) {
                        return;
                    }
                } else {
                    if (!kotlin.jvm.internal.t.d(strB, "sha1")) {
                        throw new AssertionError(kotlin.jvm.internal.t.r("unsupported hashAlgorithm: ", cVar.b()));
                    }
                    if (fVarB == null) {
                        fVarB = f26060c.b(x509Certificate);
                    }
                    if (kotlin.jvm.internal.t.d(cVar.a(), fVarB)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(f26060c.a(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (c cVar2 : listC) {
            sb.append("\n    ");
            sb.append(cVar2);
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    @NotNull
    public final List<c> c(@NotNull String hostname) {
        kotlin.jvm.internal.t.i(hostname, "hostname");
        Set<c> set = this.f26062a;
        List<c> listL = kotlin.collections.v.l();
        for (Object obj : set) {
            if (((c) obj).c(hostname)) {
                if (listL.isEmpty()) {
                    listL = new ArrayList<>();
                }
                t0.c(listL).add(obj);
            }
        }
        return listL;
    }

    @Nullable
    public final ta.c d() {
        return this.f26063b;
    }

    @NotNull
    public final g e(@NotNull ta.c certificateChainCleaner) {
        kotlin.jvm.internal.t.i(certificateChainCleaner, "certificateChainCleaner");
        return kotlin.jvm.internal.t.d(this.f26063b, certificateChainCleaner) ? this : new g(this.f26062a, certificateChainCleaner);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (kotlin.jvm.internal.t.d(gVar.f26062a, this.f26062a) && kotlin.jvm.internal.t.d(gVar.f26063b, this.f26063b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.f26062a.hashCode()) * 41;
        ta.c cVar = this.f26063b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public /* synthetic */ g(Set set, ta.c cVar, int i10, kotlin.jvm.internal.k kVar) {
        this(set, (i10 & 2) != 0 ? null : cVar);
    }
}

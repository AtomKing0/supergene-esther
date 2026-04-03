package ga;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Handshake.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f26205e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g0 f26206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f26207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<Certificate> f26208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final v8.l f26209d;

    /* JADX INFO: compiled from: Handshake.kt */
    public static final class a {

        /* JADX INFO: renamed from: ga.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Handshake.kt */
        static final class C0567a extends kotlin.jvm.internal.v implements h9.a<List<? extends Certificate>> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ List<Certificate> f26210g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0567a(List<? extends Certificate> list) {
                super(0);
                this.f26210g = list;
            }

            @Override // h9.a
            @NotNull
            public final List<? extends Certificate> invoke() {
                return this.f26210g;
            }
        }

        /* JADX INFO: compiled from: Handshake.kt */
        static final class b extends kotlin.jvm.internal.v implements h9.a<List<? extends Certificate>> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ List<Certificate> f26211g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(List<? extends Certificate> list) {
                super(0);
                this.f26211g = list;
            }

            @Override // h9.a
            @NotNull
            public final List<? extends Certificate> invoke() {
                return this.f26211g;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final List<Certificate> c(Certificate[] certificateArr) {
            return certificateArr != null ? ha.d.w(Arrays.copyOf(certificateArr, certificateArr.length)) : kotlin.collections.v.l();
        }

        @NotNull
        public final t a(@NotNull g0 tlsVersion, @NotNull i cipherSuite, @NotNull List<? extends Certificate> peerCertificates, @NotNull List<? extends Certificate> localCertificates) {
            kotlin.jvm.internal.t.i(tlsVersion, "tlsVersion");
            kotlin.jvm.internal.t.i(cipherSuite, "cipherSuite");
            kotlin.jvm.internal.t.i(peerCertificates, "peerCertificates");
            kotlin.jvm.internal.t.i(localCertificates, "localCertificates");
            return new t(tlsVersion, cipherSuite, ha.d.T(localCertificates), new C0567a(ha.d.T(peerCertificates)));
        }

        @NotNull
        public final t b(@NotNull SSLSession sSLSession) throws IOException {
            List<Certificate> listL;
            kotlin.jvm.internal.t.i(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (kotlin.jvm.internal.t.d(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : kotlin.jvm.internal.t.d(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(kotlin.jvm.internal.t.r("cipherSuite == ", cipherSuite));
            }
            i iVarB = i.f26083b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (kotlin.jvm.internal.t.d("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            g0 g0VarA = g0.f26071b.a(protocol);
            try {
                listL = c(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listL = kotlin.collections.v.l();
            }
            return new t(g0VarA, iVarB, c(sSLSession.getLocalCertificates()), new b(listL));
        }
    }

    /* JADX INFO: compiled from: Handshake.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.a<List<? extends Certificate>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h9.a<List<Certificate>> f26212g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(h9.a<? extends List<? extends Certificate>> aVar) {
            super(0);
            this.f26212g = aVar;
        }

        @Override // h9.a
        @NotNull
        public final List<? extends Certificate> invoke() {
            try {
                return this.f26212g.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return kotlin.collections.v.l();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(@NotNull g0 tlsVersion, @NotNull i cipherSuite, @NotNull List<? extends Certificate> localCertificates, @NotNull h9.a<? extends List<? extends Certificate>> peerCertificatesFn) {
        kotlin.jvm.internal.t.i(tlsVersion, "tlsVersion");
        kotlin.jvm.internal.t.i(cipherSuite, "cipherSuite");
        kotlin.jvm.internal.t.i(localCertificates, "localCertificates");
        kotlin.jvm.internal.t.i(peerCertificatesFn, "peerCertificatesFn");
        this.f26206a = tlsVersion;
        this.f26207b = cipherSuite;
        this.f26208c = localCertificates;
        this.f26209d = v8.n.a(new b(peerCertificatesFn));
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        kotlin.jvm.internal.t.h(type, "type");
        return type;
    }

    @NotNull
    public final i a() {
        return this.f26207b;
    }

    @NotNull
    public final List<Certificate> c() {
        return this.f26208c;
    }

    @NotNull
    public final List<Certificate> d() {
        return (List) this.f26209d.getValue();
    }

    @NotNull
    public final g0 e() {
        return this.f26206a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (tVar.f26206a == this.f26206a && kotlin.jvm.internal.t.d(tVar.f26207b, this.f26207b) && kotlin.jvm.internal.t.d(tVar.d(), d()) && kotlin.jvm.internal.t.d(tVar.f26208c, this.f26208c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26206a.hashCode()) * 31) + this.f26207b.hashCode()) * 31) + d().hashCode()) * 31) + this.f26208c.hashCode();
    }

    @NotNull
    public String toString() {
        List<Certificate> listD = d();
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(listD, 10));
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.f26206a);
        sb.append(" cipherSuite=");
        sb.append(this.f26207b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f26208c;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(b((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}

package ta;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BasicTrustRootIndex.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<X500Principal, Set<X509Certificate>> f34194a;

    public b(@NotNull X509Certificate... caCerts) {
        t.i(caCerts, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = caCerts.length;
        int i10 = 0;
        while (i10 < length) {
            X509Certificate x509Certificate = caCerts[i10];
            i10++;
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            t.h(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.f34194a = linkedHashMap;
    }

    @Override // ta.e
    @Nullable
    public X509Certificate a(@NotNull X509Certificate cert) {
        boolean z10;
        t.i(cert, "cert");
        Set<X509Certificate> set = this.f34194a.get(cert.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            try {
                cert.verify(((X509Certificate) next).getPublicKey());
                z10 = true;
            } catch (Exception unused) {
                z10 = false;
            }
            if (z10) {
                obj = next;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof b) && t.d(((b) obj).f34194a, this.f34194a));
    }

    public int hashCode() {
        return this.f34194a.hashCode();
    }
}

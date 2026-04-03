package e5;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Predicates.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: compiled from: Predicates.java */
    private static class b<T> implements p<T>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<? extends p<? super T>> f25155a;

        @Override // e5.p
        public boolean apply(T t10) {
            for (int i10 = 0; i10 < this.f25155a.size(); i10++) {
                if (!this.f25155a.get(i10).apply(t10)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f25155a.equals(((b) obj).f25155a);
            }
            return false;
        }

        public int hashCode() {
            return this.f25155a.hashCode() + 306654252;
        }

        public String toString() {
            return q.d("and", this.f25155a);
        }

        private b(List<? extends p<? super T>> list) {
            this.f25155a = list;
        }
    }

    public static <T> p<T> b(p<? super T> pVar, p<? super T> pVar2) {
        return new b(c((p) o.j(pVar), (p) o.j(pVar2)));
    }

    private static <T> List<p<? super T>> c(p<? super T> pVar, p<? super T> pVar2) {
        return Arrays.asList(pVar, pVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z10 = true;
        for (Object obj : iterable) {
            if (!z10) {
                sb.append(',');
            }
            sb.append(obj);
            z10 = false;
        }
        sb.append(')');
        return sb.toString();
    }
}

package x2;

import a4.c0;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Atom.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35729a;

    /* JADX INFO: renamed from: x2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Atom.java */
    static final class C0730a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<b> f35731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<C0730a> f35732d;

        public C0730a(int i10, long j10) {
            super(i10);
            this.f35730b = j10;
            this.f35731c = new ArrayList();
            this.f35732d = new ArrayList();
        }

        public void d(C0730a c0730a) {
            this.f35732d.add(c0730a);
        }

        public void e(b bVar) {
            this.f35731c.add(bVar);
        }

        @Nullable
        public C0730a f(int i10) {
            int size = this.f35732d.size();
            for (int i11 = 0; i11 < size; i11++) {
                C0730a c0730a = this.f35732d.get(i11);
                if (c0730a.f35729a == i10) {
                    return c0730a;
                }
            }
            return null;
        }

        @Nullable
        public b g(int i10) {
            int size = this.f35731c.size();
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = this.f35731c.get(i11);
                if (bVar.f35729a == i10) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // x2.a
        public String toString() {
            return a.a(this.f35729a) + " leaves: " + Arrays.toString(this.f35731c.toArray()) + " containers: " + Arrays.toString(this.f35732d.toArray());
        }
    }

    /* JADX INFO: compiled from: Atom.java */
    static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f35733b;

        public b(int i10, c0 c0Var) {
            super(i10);
            this.f35733b = c0Var;
        }
    }

    public a(int i10) {
        this.f35729a = i10;
    }

    public static String a(int i10) {
        return "" + ((char) ((i10 >> 24) & 255)) + ((char) ((i10 >> 16) & 255)) + ((char) ((i10 >> 8) & 255)) + ((char) (i10 & 255));
    }

    public static int b(int i10) {
        return i10 & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static int c(int i10) {
        return (i10 >> 24) & 255;
    }

    public String toString() {
        return a(this.f35729a);
    }
}

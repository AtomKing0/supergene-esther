package e5;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: Joiner.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25144a;

    private h(String str) {
        this.f25144a = (String) o.j(str);
    }

    public static h f(char c10) {
        return new h(String.valueOf(c10));
    }

    public static h g(String str) {
        return new h(str);
    }

    public <A extends Appendable> A a(A a10, Iterator<? extends Object> it) throws IOException {
        o.j(a10);
        if (it.hasNext()) {
            a10.append(h(it.next()));
            while (it.hasNext()) {
                a10.append(this.f25144a);
                a10.append(h(it.next()));
            }
        }
        return a10;
    }

    public final StringBuilder b(StringBuilder sb, Iterable<? extends Object> iterable) {
        return c(sb, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public final String d(Iterable<? extends Object> iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator<? extends Object> it) {
        return c(new StringBuilder(), it).toString();
    }

    CharSequence h(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}

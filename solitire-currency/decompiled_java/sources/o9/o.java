package o9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.u;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public class o extends n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Iterables.kt */
    public static final class a<T> implements Iterable<T>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f32070a;

        public a(g gVar) {
            this.f32070a = gVar;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return this.f32070a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Sequences.kt */
    static final class b<T> extends v implements h9.l<T, Boolean> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f32071g = new b();

        b() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(@Nullable T t10) {
            return Boolean.valueOf(t10 == null);
        }
    }

    @NotNull
    public static <T> Iterable<T> h(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        return new a(gVar);
    }

    public static <T> int i(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                kotlin.collections.v.t();
            }
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> g<T> j(@NotNull g<? extends T> gVar, int i10) {
        t.i(gVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? gVar : gVar instanceof c ? ((c) gVar).a(i10) : new o9.b(gVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @NotNull
    public static <T> g<T> k(@NotNull g<? extends T> gVar, @NotNull h9.l<? super T, Boolean> predicate) {
        t.i(gVar, "<this>");
        t.i(predicate, "predicate");
        return new e(gVar, true, predicate);
    }

    @NotNull
    public static final <T> g<T> l(@NotNull g<? extends T> gVar, @NotNull h9.l<? super T, Boolean> predicate) {
        t.i(gVar, "<this>");
        t.i(predicate, "predicate");
        return new e(gVar, false, predicate);
    }

    @NotNull
    public static final <T> g<T> m(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        g<T> gVarL = l(gVar, b.f32071g);
        t.g(gVarL, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return gVarL;
    }

    @Nullable
    public static <T> T n(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @NotNull
    public static final <T, A extends Appendable> A o(@NotNull g<? extends T> gVar, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable h9.l<? super T, ? extends CharSequence> lVar) throws IOException {
        t.i(gVar, "<this>");
        t.i(buffer, "buffer");
        t.i(separator, "separator");
        t.i(prefix, "prefix");
        t.i(postfix, "postfix");
        t.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : gVar) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            p9.i.a(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @NotNull
    public static final <T> String p(@NotNull g<? extends T> gVar, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable h9.l<? super T, ? extends CharSequence> lVar) {
        t.i(gVar, "<this>");
        t.i(separator, "separator");
        t.i(prefix, "prefix");
        t.i(postfix, "postfix");
        t.i(truncated, "truncated");
        String string = ((StringBuilder) o(gVar, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        t.h(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String q(g gVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, h9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return p(gVar, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static <T> T r(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @NotNull
    public static <T, R> g<R> s(@NotNull g<? extends T> gVar, @NotNull h9.l<? super T, ? extends R> transform) {
        t.i(gVar, "<this>");
        t.i(transform, "transform");
        return new r(gVar, transform);
    }

    @NotNull
    public static <T, R> g<R> t(@NotNull g<? extends T> gVar, @NotNull h9.l<? super T, ? extends R> transform) {
        t.i(gVar, "<this>");
        t.i(transform, "transform");
        return m(new r(gVar, transform));
    }

    @Nullable
    public static <T extends Comparable<? super T>> T u(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @NotNull
    public static <T> g<T> v(@NotNull g<? extends T> gVar, int i10) {
        t.i(gVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? m.e() : gVar instanceof c ? ((c) gVar).b(i10) : new q(gVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @NotNull
    public static <T> List<T> w(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        Iterator<? extends T> it = gVar.iterator();
        if (!it.hasNext()) {
            return kotlin.collections.v.l();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return u.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}

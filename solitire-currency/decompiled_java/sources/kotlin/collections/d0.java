package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Collections.kt */
/* JADX INFO: loaded from: classes5.dex */
public class d0 extends c0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements o9.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f29772a;

        public a(Iterable iterable) {
            this.f29772a = iterable;
        }

        @Override // o9.g
        @NotNull
        public Iterator<T> iterator() {
            return this.f29772a.iterator();
        }
    }

    @NotNull
    public static <T> List<T> A0(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            a0.B(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    @NotNull
    public static <T> List<T> B0(@NotNull Collection<? extends T> collection, T t10) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    @NotNull
    public static <T> List<T> C0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return P0(iterable);
        }
        List<T> listQ0 = Q0(iterable);
        c0.Z(listQ0);
        return listQ0;
    }

    public static <T> T D0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) E0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T E0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @Nullable
    public static <T> T F0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @NotNull
    public static <T> List<T> G0(@NotNull List<? extends T> list, @NotNull n9.i indices) {
        kotlin.jvm.internal.t.i(list, "<this>");
        kotlin.jvm.internal.t.i(indices, "indices");
        return indices.isEmpty() ? v.l() : P0(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static <T extends Comparable<? super T>> List<T> H0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listQ0 = Q0(iterable);
            z.z(listQ0);
            return listQ0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return P0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        o.z((Comparable[]) array);
        return o.c(array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> I0(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listQ0 = Q0(iterable);
            z.A(listQ0, comparator);
            return listQ0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return P0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        o.A(array, comparator);
        return o.c(array);
    }

    @NotNull
    public static <T> List<T> J0(@NotNull Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return v.l();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return P0(iterable);
            }
            if (i10 == 1) {
                return u.e(h0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return v.r(arrayList);
    }

    @NotNull
    public static boolean[] K0(@NotNull Collection<Boolean> collection) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            zArr[i10] = it.next().booleanValue();
            i10++;
        }
        return zArr;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C L0(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @NotNull
    public static float[] M0(@NotNull Collection<Float> collection) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            fArr[i10] = it.next().floatValue();
            i10++;
        }
        return fArr;
    }

    @NotNull
    public static <T> HashSet<T> N0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        return (HashSet) L0(iterable, new HashSet(q0.d(w.v(iterable, 12))));
    }

    @NotNull
    public static int[] O0(@NotNull Collection<Integer> collection) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    @NotNull
    public static <T> List<T> P0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return v.r(Q0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return v.l();
        }
        if (size != 1) {
            return R0(collection);
        }
        return u.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final <T> List<T> Q0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        return iterable instanceof Collection ? R0((Collection) iterable) : (List) L0(iterable, new ArrayList());
    }

    @NotNull
    public static <T> List<T> R0(@NotNull Collection<? extends T> collection) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        return new ArrayList(collection);
    }

    @NotNull
    public static <T> Set<T> S0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) L0(iterable, new LinkedHashSet());
    }

    @NotNull
    public static <T> Set<T> T0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return z0.g((Set) L0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z0.e();
        }
        if (size != 1) {
            return (Set) L0(iterable, new LinkedHashSet(q0.d(collection.size())));
        }
        return y0.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final <T, R> List<R> U0(@NotNull Iterable<? extends T> iterable, int i10, int i11, boolean z10, @NotNull h9.l<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(transform, "transform");
        b1.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = b1.b(iterable.iterator(), i10, i11, z10, true);
            while (itB.hasNext()) {
                arrayList.add(transform.invoke((List) itB.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i11) + (size % i11 == 0 ? 0 : 1));
        u0 u0Var = new u0(list);
        int i12 = 0;
        while (true) {
            if (!(i12 >= 0 && i12 < size)) {
                break;
            }
            int iJ = n9.o.j(i10, size - i12);
            if (!z10 && iJ < i10) {
                break;
            }
            u0Var.a(i12, iJ + i12);
            arrayList2.add(transform.invoke(u0Var));
            i12 += i11;
        }
        return arrayList2;
    }

    public static /* synthetic */ List V0(Iterable iterable, int i10, int i11, boolean z10, h9.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return U0(iterable, i10, i11, z10, lVar);
    }

    @NotNull
    public static <T, R> List<v8.s<T, R>> W0(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> other) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(w.v(iterable, 10), w.v(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(v8.y.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static <T> o9.g<T> a0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> boolean b0(@NotNull Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t10) : m0(iterable, t10) >= 0;
    }

    @NotNull
    public static <T> List<T> c0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        return P0(S0(iterable));
    }

    @NotNull
    public static <T> List<T> d0(@NotNull Iterable<? extends T> iterable, int i10) {
        ArrayList arrayList;
        kotlin.jvm.internal.t.i(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return P0(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i10;
            if (size <= 0) {
                return v.l();
            }
            if (size == 1) {
                return u.e(s0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i10 < size2) {
                        arrayList.add(((List) iterable).get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t10 : iterable) {
            if (i11 >= i10) {
                arrayList.add(t10);
            } else {
                i11++;
            }
        }
        return v.r(arrayList);
    }

    @NotNull
    public static <T> List<T> e0(@NotNull List<? extends T> list, int i10) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (i10 >= 0) {
            return J0(list, n9.o.e(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @NotNull
    public static <T> List<T> f0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        return (List) g0(iterable, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C g0(@NotNull Iterable<? extends T> iterable, @NotNull C destination) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        for (T t10 : iterable) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static <T> T h0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) i0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T i0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    @Nullable
    public static <T> T j0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Nullable
    public static <T> T k0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static <T> T l0(@NotNull List<? extends T> list, int i10) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (i10 < 0 || i10 > v.m(list)) {
            return null;
        }
        return list.get(i10);
    }

    public static final <T> int m0(@NotNull Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                v.u();
            }
            if (kotlin.jvm.internal.t.d(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> int n0(@NotNull List<? extends T> list, T t10) {
        kotlin.jvm.internal.t.i(list, "<this>");
        return list.indexOf(t10);
    }

    @NotNull
    public static final <T, A extends Appendable> A o0(@NotNull Iterable<? extends T> iterable, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable h9.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(buffer, "buffer");
        kotlin.jvm.internal.t.i(separator, "separator");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        kotlin.jvm.internal.t.i(postfix, "postfix");
        kotlin.jvm.internal.t.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : iterable) {
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

    public static /* synthetic */ Appendable p0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, h9.l lVar, int i11, Object obj) {
        return o0(iterable, appendable, (charSequence & 2) != 0 ? ", " : charSequence, (charSequence & 4) != 0 ? "" : charSequence2, (charSequence & 8) == 0 ? charSequence3 : "", (charSequence & 16) != 0 ? -1 : i10, (charSequence & 32) != 0 ? "..." : charSequence4, (charSequence & 64) != 0 ? null : lVar);
    }

    @NotNull
    public static final <T> String q0(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable h9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(separator, "separator");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        kotlin.jvm.internal.t.i(postfix, "postfix");
        kotlin.jvm.internal.t.i(truncated, "truncated");
        String string = ((StringBuilder) o0(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.t.h(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String r0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, h9.l lVar, int i11, Object obj) {
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
        return q0(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static final <T> T s0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) t0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T t0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(v.m(list));
    }

    @Nullable
    public static <T> T u0(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @Nullable
    public static Float v0(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @Nullable
    public static <T extends Comparable<? super T>> T w0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @Nullable
    public static Float x0(@NotNull Iterable<Float> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @NotNull
    public static <T> List<T> y0(@NotNull Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        ArrayList arrayList = new ArrayList(w.v(iterable, 10));
        boolean z10 = false;
        for (T t11 : iterable) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.t.d(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(t11);
            }
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> z0(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        if (iterable instanceof Collection) {
            return A0((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        a0.B(arrayList, iterable);
        a0.B(arrayList, elements);
        return arrayList;
    }
}

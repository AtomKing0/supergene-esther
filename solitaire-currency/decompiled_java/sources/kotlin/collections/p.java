package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes5.dex */
public class p extends o {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements o9.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f29789a;

        public a(Object[] objArr) {
            this.f29789a = objArr;
        }

        @Override // o9.g
        @NotNull
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.c.a(this.f29789a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: _Arrays.kt */
    static final class b<T> extends kotlin.jvm.internal.v implements h9.a<Iterator<? extends T>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ T[] f29790g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(T[] tArr) {
            super(0);
            this.f29790g = tArr;
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<T> invoke() {
            return kotlin.jvm.internal.c.a(this.f29790g);
        }
    }

    @NotNull
    public static <T> o9.g<T> C(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        return tArr.length == 0 ? o9.m.e() : new a(tArr);
    }

    public static boolean D(@NotNull byte[] bArr, byte b10) {
        kotlin.jvm.internal.t.i(bArr, "<this>");
        return U(bArr, b10) >= 0;
    }

    public static boolean E(@NotNull char[] cArr, char c10) {
        kotlin.jvm.internal.t.i(cArr, "<this>");
        return V(cArr, c10) >= 0;
    }

    public static boolean F(@NotNull int[] iArr, int i10) {
        kotlin.jvm.internal.t.i(iArr, "<this>");
        return W(iArr, i10) >= 0;
    }

    public static boolean G(@NotNull long[] jArr, long j10) {
        kotlin.jvm.internal.t.i(jArr, "<this>");
        return X(jArr, j10) >= 0;
    }

    public static <T> boolean H(@NotNull T[] tArr, T t10) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        return Y(tArr, t10) >= 0;
    }

    public static boolean I(@NotNull short[] sArr, short s10) {
        kotlin.jvm.internal.t.i(sArr, "<this>");
        return Z(sArr, s10) >= 0;
    }

    @NotNull
    public static <T> List<T> J(@NotNull T[] tArr, int i10) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (i10 >= 0) {
            return m0(tArr, n9.o.e(tArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    @NotNull
    public static <T> List<T> K(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        return (List) L(tArr, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C L(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static int M(@NotNull int[] iArr) {
        kotlin.jvm.internal.t.i(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[0];
    }

    public static <T> T N(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    @Nullable
    public static <T> T O(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    @NotNull
    public static n9.i P(@NotNull int[] iArr) {
        kotlin.jvm.internal.t.i(iArr, "<this>");
        return new n9.i(0, Q(iArr));
    }

    public static final int Q(@NotNull int[] iArr) {
        kotlin.jvm.internal.t.i(iArr, "<this>");
        return iArr.length - 1;
    }

    public static int R(@NotNull long[] jArr) {
        kotlin.jvm.internal.t.i(jArr, "<this>");
        return jArr.length - 1;
    }

    public static <T> int S(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        return tArr.length - 1;
    }

    @Nullable
    public static <T> T T(@NotNull T[] tArr, int i10) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (i10 < 0 || i10 > S(tArr)) {
            return null;
        }
        return tArr[i10];
    }

    public static final int U(@NotNull byte[] bArr, byte b10) {
        kotlin.jvm.internal.t.i(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b10 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int V(@NotNull char[] cArr, char c10) {
        kotlin.jvm.internal.t.i(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int W(@NotNull int[] iArr, int i10) {
        kotlin.jvm.internal.t.i(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final int X(@NotNull long[] jArr, long j10) {
        kotlin.jvm.internal.t.i(jArr, "<this>");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (j10 == jArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static <T> int Y(@NotNull T[] tArr, T t10) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.t.d(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final int Z(@NotNull short[] sArr, short s10) {
        kotlin.jvm.internal.t.i(sArr, "<this>");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (s10 == sArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T, A extends Appendable> A a0(@NotNull T[] tArr, @NotNull A buffer, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable h9.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        kotlin.jvm.internal.t.i(buffer, "buffer");
        kotlin.jvm.internal.t.i(separator, "separator");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        kotlin.jvm.internal.t.i(postfix, "postfix");
        kotlin.jvm.internal.t.i(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : tArr) {
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
    public static final <T> String c0(@NotNull T[] tArr, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable h9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        kotlin.jvm.internal.t.i(separator, "separator");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        kotlin.jvm.internal.t.i(postfix, "postfix");
        kotlin.jvm.internal.t.i(truncated, "truncated");
        String string = ((StringBuilder) a0(tArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        kotlin.jvm.internal.t.h(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static /* synthetic */ String d0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, h9.l lVar, int i11, Object obj) {
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
        return c0(objArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static int e0(@NotNull int[] iArr) {
        kotlin.jvm.internal.t.i(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[Q(iArr)];
    }

    public static <T> T f0(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[S(tArr)];
    }

    public static <T> int g0(@NotNull T[] tArr, T t10) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (t10 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i11 = length2 - 1;
                    if (kotlin.jvm.internal.t.d(t10, tArr[length2])) {
                        return length2;
                    }
                    if (i11 < 0) {
                        break;
                    }
                    length2 = i11;
                }
            }
        }
        return -1;
    }

    public static char h0(@NotNull char[] cArr) {
        kotlin.jvm.internal.t.i(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static <T> T i0(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static <T> List<T> j0(@NotNull T[] tArr, @NotNull n9.i indices) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        kotlin.jvm.internal.t.i(indices, "indices");
        return indices.isEmpty() ? v.l() : o.c(o.p(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final <T> T[] k0(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        kotlin.jvm.internal.t.i(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.t.h(tArr2, "copyOf(this, size)");
        o.A(tArr2, comparator);
        return tArr2;
    }

    @NotNull
    public static <T> List<T> l0(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        kotlin.jvm.internal.t.i(comparator, "comparator");
        return o.c(k0(tArr, comparator));
    }

    @NotNull
    public static final <T> List<T> m0(@NotNull T[] tArr, int i10) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return v.l();
        }
        int length = tArr.length;
        if (i10 >= length) {
            return o0(tArr);
        }
        if (i10 == 1) {
            return u.e(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(tArr[i11]);
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C n0(@NotNull T[] tArr, @NotNull C destination) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        for (T t10 : tArr) {
            destination.add(t10);
        }
        return destination;
    }

    @NotNull
    public static <T> List<T> o0(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? q0(tArr) : u.e(tArr[0]) : v.l();
    }

    @NotNull
    public static List<Integer> p0(@NotNull int[] iArr) {
        kotlin.jvm.internal.t.i(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    @NotNull
    public static <T> List<T> q0(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        return new ArrayList(v.g(tArr));
    }

    @NotNull
    public static final <T> Set<T> r0(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) n0(tArr, new LinkedHashSet(q0.d(tArr.length))) : y0.c(tArr[0]) : z0.e();
    }

    @NotNull
    public static <T> Iterable<i0<T>> s0(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        return new j0(new b(tArr));
    }
}

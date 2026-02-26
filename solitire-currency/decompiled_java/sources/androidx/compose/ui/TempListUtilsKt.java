package androidx.compose.ui;

import h9.l;
import h9.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;

/* JADX INFO: compiled from: TempListUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TempListUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void appendElement(Appendable appendable, T t10, l<? super T, ? extends CharSequence> lVar) throws IOException {
        if (lVar != null) {
            appendable.append(lVar.invoke(t10));
            return;
        }
        if (t10 == 0 ? true : t10 instanceof CharSequence) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }

    @NotNull
    public static final <T, K, V> Map<K, V> fastAssociate(@NotNull List<? extends T> list, @NotNull l<? super T, ? extends s<? extends K, ? extends V>> transform) {
        t.i(list, "<this>");
        t.i(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            s<? extends K, ? extends V> sVarInvoke = transform.invoke(list.get(i10));
            linkedHashMap.put(sVarInvoke.c(), sVarInvoke.d());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, A extends Appendable> A fastJoinTo(List<? extends T> list, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) throws IOException {
        a10.append(charSequence2);
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            T t10 = list.get(i12);
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            appendElement(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    @NotNull
    public static final <T> String fastJoinToString(@NotNull List<? extends T> list, @NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i10, @NotNull CharSequence truncated, @Nullable l<? super T, ? extends CharSequence> lVar) {
        t.i(list, "<this>");
        t.i(separator, "separator");
        t.i(prefix, "prefix");
        t.i(postfix, "postfix");
        t.i(truncated, "truncated");
        String string = ((StringBuilder) fastJoinTo(list, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
        t.h(string, "fastJoinTo(StringBuilder…form)\n        .toString()");
        return string;
    }

    public static /* synthetic */ String fastJoinToString$default(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
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
        return fastJoinToString(list, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @NotNull
    public static final <T, R> List<R> fastMapNotNull(@NotNull List<? extends T> list, @NotNull l<? super T, ? extends R> transform) {
        t.i(list, "<this>");
        t.i(transform, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            R rInvoke = transform.invoke(list.get(i10));
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    public static final <S, T extends S> S fastReduce(@NotNull List<? extends T> list, @NotNull p<? super S, ? super T, ? extends S> operation) {
        t.i(list, "<this>");
        t.i(operation, "operation");
        if (list.isEmpty()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S sMo4invoke = (Object) d0.i0(list);
        int iM = v.m(list);
        int i10 = 1;
        if (1 <= iM) {
            while (true) {
                sMo4invoke = operation.mo4invoke(sMo4invoke, list.get(i10));
                if (i10 == iM) {
                    break;
                }
                i10++;
            }
        }
        return sMo4invoke;
    }

    @NotNull
    public static final <T, R, V> List<V> fastZip(@NotNull List<? extends T> list, @NotNull List<? extends R> other, @NotNull p<? super T, ? super R, ? extends V> transform) {
        t.i(list, "<this>");
        t.i(other, "other");
        t.i(transform, "transform");
        int iMin = Math.min(list.size(), other.size());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.mo4invoke(list.get(i10), other.get(i10)));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> fastZipWithNext(@NotNull List<? extends T> list, @NotNull p<? super T, ? super T, ? extends R> transform) {
        t.i(list, "<this>");
        t.i(transform, "transform");
        if (list.size() == 0 || list.size() == 1) {
            return v.l();
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        a0.c cVar = list.get(0);
        int iM = v.m(list);
        while (i10 < iM) {
            i10++;
            T t10 = list.get(i10);
            arrayList.add(transform.mo4invoke(cVar, t10));
            cVar = t10;
        }
        return arrayList;
    }
}

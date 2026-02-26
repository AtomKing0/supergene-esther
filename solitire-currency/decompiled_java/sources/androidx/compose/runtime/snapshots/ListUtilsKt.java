package androidx.compose.runtime.snapshots;

import h9.l;
import h9.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ListUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListUtilsKt {
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

    public static final <T> boolean fastAll(@NotNull List<? extends T> list, @NotNull l<? super T, Boolean> predicate) {
        t.i(list, "<this>");
        t.i(predicate, "predicate");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!predicate.invoke(list.get(i10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean fastAny(@NotNull List<? extends T> list, @NotNull l<? super T, Boolean> predicate) {
        t.i(list, "<this>");
        t.i(predicate, "predicate");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (predicate.invoke(list.get(i10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <T> List<T> fastFilterIndexed(@NotNull List<? extends T> list, @NotNull p<? super Integer, ? super T, Boolean> predicate) {
        t.i(list, "<this>");
        t.i(predicate, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            T t10 = list.get(i10);
            if (predicate.mo4invoke(Integer.valueOf(i10), t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final <T> void fastForEach(@NotNull List<? extends T> list, @NotNull l<? super T, k0> action) {
        t.i(list, "<this>");
        t.i(action, "action");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.invoke(list.get(i10));
        }
    }

    public static final <T> void fastForEachIndexed(@NotNull List<? extends T> list, @NotNull p<? super Integer, ? super T, k0> action) {
        t.i(list, "<this>");
        t.i(action, "action");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo4invoke(Integer.valueOf(i10), list.get(i10));
        }
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> fastGroupBy(@NotNull List<? extends T> list, @NotNull l<? super T, ? extends K> keySelector) {
        t.i(list, "<this>");
        t.i(keySelector, "keySelector");
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            T t10 = list.get(i10);
            K kInvoke = keySelector.invoke(t10);
            Object arrayList = map.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(kInvoke, arrayList);
            }
            ((ArrayList) arrayList).add(t10);
        }
        return map;
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
    public static final <T, R> List<R> fastMap(@NotNull List<? extends T> list, @NotNull l<? super T, ? extends R> transform) {
        t.i(list, "<this>");
        t.i(transform, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(transform.invoke(list.get(i10)));
        }
        return arrayList;
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

    @NotNull
    public static final <T> Set<T> fastToSet(@NotNull List<? extends T> list) {
        t.i(list, "<this>");
        HashSet hashSet = new HashSet(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            hashSet.add(list.get(i10));
        }
        return hashSet;
    }
}

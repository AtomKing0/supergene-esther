package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImageVector.kt */
/* JADX INFO: loaded from: classes.dex */
final class Stack<T> {

    @NotNull
    private final ArrayList<T> backing;

    private /* synthetic */ Stack(ArrayList arrayList) {
        this.backing = arrayList;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Stack m2111boximpl(ArrayList arrayList) {
        return new Stack(arrayList);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> ArrayList<T> m2112constructorimpl(@NotNull ArrayList<T> backing) {
        t.i(backing, "backing");
        return backing;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ ArrayList m2113constructorimpl$default(ArrayList arrayList, int i10, k kVar) {
        if ((i10 & 1) != 0) {
            arrayList = new ArrayList();
        }
        return m2112constructorimpl(arrayList);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2114equalsimpl(ArrayList<T> arrayList, Object obj) {
        return (obj instanceof Stack) && t.d(arrayList, ((Stack) obj).m2122unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2115equalsimpl0(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        return t.d(arrayList, arrayList2);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final int m2116getSizeimpl(ArrayList<T> arrayList) {
        return arrayList.size();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2117hashCodeimpl(ArrayList<T> arrayList) {
        return arrayList.hashCode();
    }

    /* JADX INFO: renamed from: peek-impl, reason: not valid java name */
    public static final T m2118peekimpl(ArrayList<T> arrayList) {
        return arrayList.get(m2116getSizeimpl(arrayList) - 1);
    }

    /* JADX INFO: renamed from: pop-impl, reason: not valid java name */
    public static final T m2119popimpl(ArrayList<T> arrayList) {
        return arrayList.remove(m2116getSizeimpl(arrayList) - 1);
    }

    /* JADX INFO: renamed from: push-impl, reason: not valid java name */
    public static final boolean m2120pushimpl(ArrayList<T> arrayList, T t10) {
        return arrayList.add(t10);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2121toStringimpl(ArrayList<T> arrayList) {
        return "Stack(backing=" + arrayList + ')';
    }

    public boolean equals(Object obj) {
        return m2114equalsimpl(this.backing, obj);
    }

    public int hashCode() {
        return m2117hashCodeimpl(this.backing);
    }

    public String toString() {
        return m2121toStringimpl(this.backing);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ ArrayList m2122unboximpl() {
        return this.backing;
    }
}

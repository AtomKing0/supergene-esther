package w8;

import com.ironsource.v8;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    @NotNull
    public static final <E> E[] d(int i10) {
        if (i10 >= 0) {
            return (E[]) new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @NotNull
    public static final <T> T[] e(@NotNull T[] tArr, int i10) {
        t.i(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i10);
        t.h(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    public static final <E> void f(@NotNull E[] eArr, int i10) {
        t.i(eArr, "<this>");
        eArr[i10] = null;
    }

    public static final <E> void g(@NotNull E[] eArr, int i10, int i11) {
        t.i(eArr, "<this>");
        while (i10 < i11) {
            f(eArr, i10);
            i10++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i10, int i11, List<?> list) {
        if (i11 != list.size()) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (!t.d(tArr[i10 + i12], list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i10, int i11) {
        int iHashCode = 1;
        for (int i12 = 0; i12 < i11; i12++) {
            T t10 = tArr[i10 + i12];
            iHashCode = (iHashCode * 31) + (t10 != null ? t10.hashCode() : 0);
        }
        return iHashCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i10, int i11) {
        StringBuilder sb = new StringBuilder((i11 * 3) + 2);
        sb.append(v8.i.f15837d);
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i10 + i12]);
        }
        sb.append(v8.i.f15839e);
        String string = sb.toString();
        t.h(string, "sb.toString()");
        return string;
    }
}

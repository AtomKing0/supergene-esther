package j2;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.HashMap;
import w1.e;

/* JADX INFO: compiled from: PriorityMapping.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray<e> f28627a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<e, Integer> f28628b;

    static {
        HashMap<e, Integer> map = new HashMap<>();
        f28628b = map;
        map.put(e.DEFAULT, 0);
        f28628b.put(e.VERY_LOW, 1);
        f28628b.put(e.HIGHEST, 2);
        for (e eVar : f28628b.keySet()) {
            f28627a.append(f28628b.get(eVar).intValue(), eVar);
        }
    }

    public static int a(@NonNull e eVar) {
        Integer num = f28628b.get(eVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + eVar);
    }

    @NonNull
    public static e b(int i10) {
        e eVar = f28627a.get(i10);
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}

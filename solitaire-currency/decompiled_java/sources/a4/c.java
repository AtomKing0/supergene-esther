package a4;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k2.h;

/* JADX INFO: compiled from: BundleableUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private c() {
    }

    public static void a(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) o0.j(c.class.getClassLoader()));
        }
    }

    public static <T extends k2.h> com.google.common.collect.y<T> b(h.a<T> aVar, List<Bundle> list) {
        y.a aVarK = com.google.common.collect.y.k();
        for (int i10 = 0; i10 < list.size(); i10++) {
            aVarK.a(aVar.fromBundle((Bundle) a.e(list.get(i10))));
        }
        return aVarK.k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends k2.h> SparseArray<T> c(h.a<T> aVar, SparseArray<Bundle> sparseArray) {
        SparseArray<T> sparseArray2 = (SparseArray<T>) new SparseArray(sparseArray.size());
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            sparseArray2.put(sparseArray.keyAt(i10), aVar.fromBundle(sparseArray.valueAt(i10)));
        }
        return sparseArray2;
    }

    public static <T extends k2.h> ArrayList<Bundle> d(Collection<T> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBundle());
        }
        return arrayList;
    }

    public static <T extends k2.h> SparseArray<Bundle> e(SparseArray<T> sparseArray) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            sparseArray2.put(sparseArray.keyAt(i10), sparseArray.valueAt(i10).toBundle());
        }
        return sparseArray2;
    }
}

package androidx.media3.common.util;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.collect.a0;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class BundleCollectionUtil {
    private BundleCollectionUtil() {
    }

    public static HashMap<String, String> bundleToStringHashMap(Bundle bundle) {
        HashMap<String, String> map = new HashMap<>();
        if (bundle == Bundle.EMPTY) {
            return map;
        }
        for (String str : bundle.keySet()) {
            String string = bundle.getString(str);
            if (string != null) {
                map.put(str, string);
            }
        }
        return map;
    }

    public static a0<String, String> bundleToStringImmutableMap(Bundle bundle) {
        return bundle == Bundle.EMPTY ? a0.k() : a0.c(bundleToStringHashMap(bundle));
    }

    public static void ensureClassLoader(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) Util.castNonNull(BundleCollectionUtil.class.getClassLoader()));
        }
    }

    public static <T> y<T> fromBundleList(e5.g<Bundle, T> gVar, List<Bundle> list) {
        y.a aVarK = y.k();
        for (int i10 = 0; i10 < list.size(); i10++) {
            aVarK.a(gVar.apply((Bundle) Assertions.checkNotNull(list.get(i10))));
        }
        return aVarK.k();
    }

    public static <T> SparseArray<T> fromBundleSparseArray(e5.g<Bundle, T> gVar, SparseArray<Bundle> sparseArray) {
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            sparseArray2.put(sparseArray.keyAt(i10), gVar.apply(sparseArray.valueAt(i10)));
        }
        return sparseArray2;
    }

    public static Bundle getBundleWithDefault(Bundle bundle, String str, Bundle bundle2) {
        Bundle bundle3 = bundle.getBundle(str);
        return bundle3 != null ? bundle3 : bundle2;
    }

    public static ArrayList<Integer> getIntegerArrayListWithDefault(Bundle bundle, String str, ArrayList<Integer> arrayList) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(str);
        return integerArrayList != null ? integerArrayList : arrayList;
    }

    public static Bundle stringMapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    public static <T> ArrayList<Bundle> toBundleArrayList(Collection<T> collection, e5.g<T, Bundle> gVar) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.apply(it.next()));
        }
        return arrayList;
    }

    public static <T> y<Bundle> toBundleList(List<T> list, e5.g<T, Bundle> gVar) {
        y.a aVarK = y.k();
        for (int i10 = 0; i10 < list.size(); i10++) {
            aVarK.a(gVar.apply(list.get(i10)));
        }
        return aVarK.k();
    }

    public static <T> SparseArray<Bundle> toBundleSparseArray(SparseArray<T> sparseArray, e5.g<T, Bundle> gVar) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            sparseArray2.put(sparseArray.keyAt(i10), gVar.apply(sparseArray.valueAt(i10)));
        }
        return sparseArray2;
    }
}

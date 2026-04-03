package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues = new SparseIntArray();
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners = new HashMap<>();

    public interface SharedValuesListener {
        void onNewValue(int i10, int i11, int i12);
    }

    public void addListener(int i10, SharedValuesListener sharedValuesListener) {
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.mValuesListeners.get(Integer.valueOf(i10));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.mValuesListeners.put(Integer.valueOf(i10), hashSet);
        }
        hashSet.add(new WeakReference<>(sharedValuesListener));
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public void fireNewValue(int i10, int i11) {
        int i12 = this.mValues.get(i10, -1);
        if (i12 == i11) {
            return;
        }
        this.mValues.put(i10, i11);
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.mValuesListeners.get(Integer.valueOf(i10));
        if (hashSet == null) {
            return;
        }
        Iterator<WeakReference<SharedValuesListener>> it = hashSet.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            SharedValuesListener sharedValuesListener = it.next().get();
            if (sharedValuesListener != null) {
                sharedValuesListener.onNewValue(i10, i11, i12);
            } else {
                z10 = true;
            }
        }
        if (z10) {
            ArrayList arrayList = new ArrayList();
            for (WeakReference<SharedValuesListener> weakReference : hashSet) {
                if (weakReference.get() == null) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public int getValue(int i10) {
        return this.mValues.get(i10, -1);
    }

    public void removeListener(int i10, SharedValuesListener sharedValuesListener) {
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.mValuesListeners.get(Integer.valueOf(i10));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference<SharedValuesListener> weakReference : hashSet) {
            SharedValuesListener sharedValuesListener2 = weakReference.get();
            if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        Iterator<Integer> it = this.mValuesListeners.keySet().iterator();
        while (it.hasNext()) {
            removeListener(it.next().intValue(), sharedValuesListener);
        }
    }
}

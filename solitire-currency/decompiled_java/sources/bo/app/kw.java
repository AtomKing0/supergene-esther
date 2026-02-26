package bo.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class kw {
    public static final HashSet a(ConcurrentHashMap concurrentHashMap, Class cls, ReentrantLock reentrantLock) {
        reentrantLock.lock();
        try {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) concurrentHashMap.get(cls);
            if (copyOnWriteArraySet == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet(copyOnWriteArraySet);
            ArrayList arrayList = new ArrayList();
            Iterator it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next();
            }
            copyOnWriteArraySet.removeAll(kotlin.collections.d0.T0(arrayList));
            concurrentHashMap.put(cls, copyOnWriteArraySet);
            return hashSet;
        } finally {
            reentrantLock.unlock();
        }
    }
}

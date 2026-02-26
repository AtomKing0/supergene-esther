package a4;

import androidx.annotation.GuardedBy;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CopyOnWriteMultiset.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f172a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final Map<E, Integer> f173b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private Set<E> f174c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private List<E> f175d = Collections.emptyList();

    public void a(E e10) {
        synchronized (this.f172a) {
            ArrayList arrayList = new ArrayList(this.f175d);
            arrayList.add(e10);
            this.f175d = Collections.unmodifiableList(arrayList);
            Integer num = this.f173b.get(e10);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f174c);
                hashSet.add(e10);
                this.f174c = Collections.unmodifiableSet(hashSet);
            }
            this.f173b.put(e10, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public int b(E e10) {
        int iIntValue;
        synchronized (this.f172a) {
            iIntValue = this.f173b.containsKey(e10) ? this.f173b.get(e10).intValue() : 0;
        }
        return iIntValue;
    }

    public void d(E e10) {
        synchronized (this.f172a) {
            Integer num = this.f173b.get(e10);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f175d);
            arrayList.remove(e10);
            this.f175d = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.f173b.remove(e10);
                HashSet hashSet = new HashSet(this.f174c);
                hashSet.remove(e10);
                this.f174c = Collections.unmodifiableSet(hashSet);
            } else {
                this.f173b.put(e10, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f172a) {
            set = this.f174c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f172a) {
            it = this.f175d.iterator();
        }
        return it;
    }
}

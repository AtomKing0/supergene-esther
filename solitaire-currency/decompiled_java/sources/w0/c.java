package w0;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: DiskCacheWriteLocker.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f35284a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f35285b = new b();

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f35286a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35287b;

        a() {
        }
    }

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<a> f35288a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVarPoll;
            synchronized (this.f35288a) {
                aVarPoll = this.f35288a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void b(a aVar) {
            synchronized (this.f35288a) {
                if (this.f35288a.size() < 10) {
                    this.f35288a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.f35284a.get(str);
            if (aVarA == null) {
                aVarA = this.f35285b.a();
                this.f35284a.put(str, aVarA);
            }
            aVarA.f35287b++;
        }
        aVarA.f35286a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) o1.j.d(this.f35284a.get(str));
            int i10 = aVar.f35287b;
            if (i10 < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f35287b);
            }
            int i11 = i10 - 1;
            aVar.f35287b = i11;
            if (i11 == 0) {
                a aVarRemove = this.f35284a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.f35285b.b(aVarRemove);
            }
        }
        aVar.f35286a.unlock();
    }
}

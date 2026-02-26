package a4;

import java.util.Collections;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: PriorityTaskManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f155a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PriorityQueue<Integer> f156b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f157c = Integer.MIN_VALUE;

    public void a(int i10) {
        synchronized (this.f155a) {
            this.f156b.add(Integer.valueOf(i10));
            this.f157c = Math.max(this.f157c, i10);
        }
    }

    public void b(int i10) {
        synchronized (this.f155a) {
            this.f156b.remove(Integer.valueOf(i10));
            this.f157c = this.f156b.isEmpty() ? Integer.MIN_VALUE : ((Integer) o0.j(this.f156b.peek())).intValue();
            this.f155a.notifyAll();
        }
    }
}

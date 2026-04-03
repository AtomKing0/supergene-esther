package a4;

import a4.p;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SystemHandlerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
final class j0 implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("messagePool")
    private static final List<b> f183b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f184a;

    /* JADX INFO: compiled from: SystemHandlerWrapper.java */
    private static final class b implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Message f185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private j0 f186b;

        private b() {
        }

        private void a() {
            this.f185a = null;
            this.f186b = null;
            j0.d(this);
        }

        public boolean b(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) a4.a.e(this.f185a));
            a();
            return zSendMessageAtFrontOfQueue;
        }

        public b c(Message message, j0 j0Var) {
            this.f185a = message;
            this.f186b = j0Var;
            return this;
        }

        @Override // a4.p.a
        public void sendToTarget() {
            ((Message) a4.a.e(this.f185a)).sendToTarget();
            a();
        }
    }

    public j0(Handler handler) {
        this.f184a = handler;
    }

    private static b c() {
        b bVar;
        List<b> list = f183b;
        synchronized (list) {
            bVar = list.isEmpty() ? new b() : list.remove(list.size() - 1);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(b bVar) {
        List<b> list = f183b;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(bVar);
            }
        }
    }

    @Override // a4.p
    public boolean a(p.a aVar) {
        return ((b) aVar).b(this.f184a);
    }

    @Override // a4.p
    public boolean hasMessages(int i10) {
        return this.f184a.hasMessages(i10);
    }

    @Override // a4.p
    public p.a obtainMessage(int i10) {
        return c().c(this.f184a.obtainMessage(i10), this);
    }

    @Override // a4.p
    public boolean post(Runnable runnable) {
        return this.f184a.post(runnable);
    }

    @Override // a4.p
    public void removeCallbacksAndMessages(@Nullable Object obj) {
        this.f184a.removeCallbacksAndMessages(obj);
    }

    @Override // a4.p
    public void removeMessages(int i10) {
        this.f184a.removeMessages(i10);
    }

    @Override // a4.p
    public boolean sendEmptyMessage(int i10) {
        return this.f184a.sendEmptyMessage(i10);
    }

    @Override // a4.p
    public boolean sendEmptyMessageAtTime(int i10, long j10) {
        return this.f184a.sendEmptyMessageAtTime(i10, j10);
    }

    @Override // a4.p
    public p.a obtainMessage(int i10, @Nullable Object obj) {
        return c().c(this.f184a.obtainMessage(i10, obj), this);
    }

    @Override // a4.p
    public p.a obtainMessage(int i10, int i11, int i12) {
        return c().c(this.f184a.obtainMessage(i10, i11, i12), this);
    }

    @Override // a4.p
    public p.a obtainMessage(int i10, int i11, int i12, @Nullable Object obj) {
        return c().c(this.f184a.obtainMessage(i10, i11, i12, obj), this);
    }
}

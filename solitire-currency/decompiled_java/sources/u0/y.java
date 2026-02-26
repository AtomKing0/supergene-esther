package u0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: ResourceRecycler.java */
/* JADX INFO: loaded from: classes2.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f34439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f34440b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: ResourceRecycler.java */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).recycle();
            return true;
        }
    }

    y() {
    }

    synchronized void a(v<?> vVar) {
        if (this.f34439a) {
            this.f34440b.obtainMessage(1, vVar).sendToTarget();
        } else {
            this.f34439a = true;
            vVar.recycle();
            this.f34439a = false;
        }
    }
}

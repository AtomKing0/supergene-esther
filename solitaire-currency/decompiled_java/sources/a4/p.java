package a4;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: HandlerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public interface p {

    /* JADX INFO: compiled from: HandlerWrapper.java */
    public interface a {
        void sendToTarget();
    }

    boolean a(a aVar);

    boolean hasMessages(int i10);

    a obtainMessage(int i10);

    a obtainMessage(int i10, int i11, int i12);

    a obtainMessage(int i10, int i11, int i12, @Nullable Object obj);

    a obtainMessage(int i10, @Nullable Object obj);

    boolean post(Runnable runnable);

    void removeCallbacksAndMessages(@Nullable Object obj);

    void removeMessages(int i10);

    boolean sendEmptyMessage(int i10);

    boolean sendEmptyMessageAtTime(int i10, long j10);
}

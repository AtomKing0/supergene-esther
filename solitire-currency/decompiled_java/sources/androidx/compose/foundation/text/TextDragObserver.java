package androidx.compose.foundation.text;

/* JADX INFO: compiled from: LongPressTextDragObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public interface TextDragObserver {
    void onCancel();

    /* JADX INFO: renamed from: onDown-k-4lQ0M */
    void mo709onDownk4lQ0M(long j10);

    /* JADX INFO: renamed from: onDrag-k-4lQ0M */
    void mo710onDragk4lQ0M(long j10);

    /* JADX INFO: renamed from: onStart-k-4lQ0M */
    void mo711onStartk4lQ0M(long j10);

    void onStop();

    void onUp();
}

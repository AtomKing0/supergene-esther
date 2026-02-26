package androidx.customview.poolingcontainer;

import androidx.annotation.UiThread;

/* JADX INFO: compiled from: PoolingContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PoolingContainerListener {
    @UiThread
    void onRelease();
}

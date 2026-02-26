package androidx.lifecycle;

import androidx.annotation.MainThread;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataKt {
    @MainThread
    @NotNull
    public static final <T> Observer<T> observe(@NotNull LiveData<T> liveData, @NotNull LifecycleOwner lifecycleOwner, @NotNull final h9.l<? super T, k0> lVar) {
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t10) {
                lVar.invoke(t10);
            }
        };
        liveData.observe(lifecycleOwner, observer);
        return observer;
    }
}

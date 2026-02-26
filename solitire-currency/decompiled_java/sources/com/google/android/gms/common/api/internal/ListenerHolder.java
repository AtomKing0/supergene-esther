package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class ListenerHolder<L> {
    private final Executor zaa;

    @Nullable
    private volatile Object zab;

    @Nullable
    private volatile ListenerKey zac;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public static final class ListenerKey<L> {
        private final Object zaa;
        private final String zab;

        @KeepForSdk
        ListenerKey(L l10, String str) {
            this.zaa = l10;
            this.zab = str;
        }

        @KeepForSdk
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
        }

        @KeepForSdk
        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }

        @NonNull
        @KeepForSdk
        public String toIdString() {
            return this.zab + "@" + System.identityHashCode(this.zaa);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(@NonNull L l10);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    @KeepForSdk
    ListenerHolder(@NonNull Looper looper, @NonNull L l10, @NonNull String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = Preconditions.checkNotNull(l10, "Listener must not be null");
        this.zac = new ListenerKey(l10, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    @Nullable
    @KeepForSdk
    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    @KeepForSdk
    public boolean hasListener() {
        return this.zab != null;
    }

    @KeepForSdk
    public void notifyListener(@NonNull final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                this.zaa.zaa(notifier);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zaa(Notifier notifier) {
        Object obj = this.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e10) {
            notifier.onNotifyListenerFailed();
            throw e10;
        }
    }

    @KeepForSdk
    ListenerHolder(@NonNull Executor executor, @NonNull L l10, @NonNull String str) {
        this.zaa = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zab = Preconditions.checkNotNull(l10, "Listener must not be null");
        this.zac = new ListenerKey(l10, Preconditions.checkNotEmpty(str));
    }
}

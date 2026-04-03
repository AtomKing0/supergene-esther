package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback;
import java.util.Arrays;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MultiInstanceInvalidationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$callback$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInvalidation$lambda$0(MultiInstanceInvalidationClient this$0, String[] tables) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(tables, "$tables");
        this$0.getInvalidationTracker().notifyObserversByTableNames((String[]) Arrays.copyOf(tables, tables.length));
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public void onInvalidation(@NotNull final String[] tables) {
        kotlin.jvm.internal.t.i(tables, "tables");
        Executor executor = this.this$0.getExecutor();
        final MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
        executor.execute(new Runnable() { // from class: androidx.room.f
            @Override // java.lang.Runnable
            public final void run() {
                MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0(multiInstanceInvalidationClient, tables);
            }
        });
    }
}

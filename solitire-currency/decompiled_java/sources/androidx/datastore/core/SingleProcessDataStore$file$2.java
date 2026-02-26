package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import h9.a;
import java.io.File;
import java.util.Set;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
final class SingleProcessDataStore$file$2 extends v implements a<File> {
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$file$2(SingleProcessDataStore<T> singleProcessDataStore) {
        super(0);
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final File invoke() {
        File file = (File) ((SingleProcessDataStore) this.this$0).produceFile.invoke();
        String it = file.getAbsolutePath();
        SingleProcessDataStore.Companion companion = SingleProcessDataStore.Companion;
        synchronized (companion.getActiveFilesLock$datastore_core()) {
            if (!(!companion.getActiveFiles$datastore_core().contains(it))) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            Set<String> activeFiles$datastore_core = companion.getActiveFiles$datastore_core();
            t.h(it, "it");
            activeFiles$datastore_core.add(it);
        }
        return file;
    }
}

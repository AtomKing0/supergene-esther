package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
final class SingleProcessDataStore$actor$1 extends v implements l<Throwable, k0> {
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$actor$1(SingleProcessDataStore<T> singleProcessDataStore) {
        super(1);
        this.this$0 = singleProcessDataStore;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        if (th != null) {
            ((SingleProcessDataStore) this.this$0).downstreamFlow.setValue(new Final(th));
        }
        SingleProcessDataStore.Companion companion = SingleProcessDataStore.Companion;
        Object activeFilesLock$datastore_core = companion.getActiveFilesLock$datastore_core();
        SingleProcessDataStore<T> singleProcessDataStore = this.this$0;
        synchronized (activeFilesLock$datastore_core) {
            companion.getActiveFiles$datastore_core().remove(singleProcessDataStore.getFile().getAbsolutePath());
            k0 k0Var = k0.f35197a;
        }
    }
}

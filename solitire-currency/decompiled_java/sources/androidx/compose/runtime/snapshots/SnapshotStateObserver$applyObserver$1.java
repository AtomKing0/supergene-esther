package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import h9.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnapshotStateObserver$applyObserver$1 extends v implements p<Set<? extends Object>, Snapshot, k0> {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotStateObserver.kt */
    static final class AnonymousClass2 extends v implements h9.a<k0> {
        final /* synthetic */ SnapshotStateObserver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SnapshotStateObserver snapshotStateObserver) {
            super(0);
            this.this$0 = snapshotStateObserver;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.callOnChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$applyObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(2);
        this.this$0 = snapshotStateObserver;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Set<? extends Object> set, Snapshot snapshot) {
        invoke2(set, snapshot);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Set<? extends Object> applied, @NotNull Snapshot snapshot) {
        int i10;
        t.i(applied, "applied");
        t.i(snapshot, "<anonymous parameter 1>");
        MutableVector mutableVector = this.this$0.applyMaps;
        SnapshotStateObserver snapshotStateObserver = this.this$0;
        synchronized (mutableVector) {
            MutableVector mutableVector2 = snapshotStateObserver.applyMaps;
            int size = mutableVector2.getSize();
            i10 = 0;
            if (size > 0) {
                Object[] content = mutableVector2.getContent();
                int i11 = 0;
                do {
                    SnapshotStateObserver.ApplyMap applyMap = (SnapshotStateObserver.ApplyMap) content[i10];
                    HashSet<Object> invalidated = applyMap.getInvalidated();
                    IdentityScopeMap map = applyMap.getMap();
                    Iterator<? extends Object> it = applied.iterator();
                    while (it.hasNext()) {
                        int iFind = map.find(it.next());
                        if (iFind >= 0) {
                            Iterator<T> it2 = map.scopeSetAt(iFind).iterator();
                            while (it2.hasNext()) {
                                invalidated.add(it2.next());
                                i11 = 1;
                            }
                        }
                    }
                    i10++;
                } while (i10 < size);
                i10 = i11;
            }
            k0 k0Var = k0.f35197a;
        }
        if (i10 != 0) {
            this.this$0.onChangedExecutor.invoke(new AnonymousClass2(this.this$0));
        }
    }
}

package androidx.compose.runtime;

import h9.q;
import java.util.List;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposerImpl$insertMovableContentReferences$1$1$2$1 extends v implements h9.a<k0> {
    final /* synthetic */ List<q<Applier<?>, SlotWriter, RememberManager, k0>> $offsetChanges;
    final /* synthetic */ SlotReader $reader;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentReferences$1$1$2$1(ComposerImpl composerImpl, List<q<Applier<?>, SlotWriter, RememberManager, k0>> list, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.this$0 = composerImpl;
        this.$offsetChanges = list;
        this.$reader = slotReader;
        this.$to = movableContentStateReference;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ComposerImpl composerImpl = this.this$0;
        List<q<Applier<?>, SlotWriter, RememberManager, k0>> list = this.$offsetChanges;
        SlotReader slotReader = this.$reader;
        MovableContentStateReference movableContentStateReference = this.$to;
        List list2 = composerImpl.changes;
        try {
            composerImpl.changes = list;
            SlotReader slotReader2 = composerImpl.reader;
            int[] iArr = composerImpl.nodeCountOverrides;
            composerImpl.nodeCountOverrides = null;
            try {
                composerImpl.reader = slotReader;
                composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals$runtime_release(), movableContentStateReference.getParameter$runtime_release(), true);
                k0 k0Var = k0.f35197a;
            } finally {
                composerImpl.reader = slotReader2;
                composerImpl.nodeCountOverrides = iArr;
            }
        } finally {
            composerImpl.changes = list2;
        }
    }
}

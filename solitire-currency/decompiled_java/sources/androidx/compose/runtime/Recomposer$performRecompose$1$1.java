package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.Iterator;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Recomposer$performRecompose$1$1 extends v implements h9.a<k0> {
    final /* synthetic */ ControlledComposition $composition;
    final /* synthetic */ IdentityArraySet<Object> $modifiedValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$performRecompose$1$1(IdentityArraySet<Object> identityArraySet, ControlledComposition controlledComposition) {
        super(0);
        this.$modifiedValues = identityArraySet;
        this.$composition = controlledComposition;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        IdentityArraySet<Object> identityArraySet = this.$modifiedValues;
        ControlledComposition controlledComposition = this.$composition;
        Iterator<Object> it = identityArraySet.iterator();
        while (it.hasNext()) {
            controlledComposition.recordWriteOf(it.next());
        }
    }
}

package androidx.compose.ui.node;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ModifierLocalConsumerEntity.kt */
/* JADX INFO: loaded from: classes.dex */
final class ModifierLocalConsumerEntity$Companion$onReadValuesChanged$1 extends v implements l<ModifierLocalConsumerEntity, k0> {
    public static final ModifierLocalConsumerEntity$Companion$onReadValuesChanged$1 INSTANCE = new ModifierLocalConsumerEntity$Companion$onReadValuesChanged$1();

    ModifierLocalConsumerEntity$Companion$onReadValuesChanged$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(ModifierLocalConsumerEntity modifierLocalConsumerEntity) {
        invoke2(modifierLocalConsumerEntity);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ModifierLocalConsumerEntity node) {
        t.i(node, "node");
        node.notifyConsumerOfChanges();
    }
}

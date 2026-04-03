package androidx.datastore.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {TypedValues.PositionType.TYPE_PERCENT_WIDTH, 337, 339}, m = "updateData")
final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessDataStore$readAndInit$api$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$readAndInit$api$1$updateData$1(SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1, z8.d<? super SingleProcessDataStore$readAndInit$api$1$updateData$1> dVar) {
        super(dVar);
        this.this$0 = singleProcessDataStore$readAndInit$api$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateData(null, this);
    }
}

package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: SwipeToDismiss.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class DismissState extends SwipeableState<DismissValue> {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: androidx.compose.material.DismissState$1, reason: invalid class name */
    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    static final class AnonymousClass1 extends v implements l<DismissValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull DismissValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<DismissState, DismissValue> Saver(@NotNull l<? super DismissValue, Boolean> confirmStateChange) {
            t.i(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(DismissState$Companion$Saver$1.INSTANCE, new DismissState$Companion$Saver$2(confirmStateChange));
        }
    }

    public /* synthetic */ DismissState(DismissValue dismissValue, l lVar, int i10, k kVar) {
        this(dismissValue, (i10 & 2) != 0 ? AnonymousClass1.INSTANCE : lVar);
    }

    @Nullable
    public final Object dismiss(@NotNull DismissDirection dismissDirection, @NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    @Nullable
    public final DismissDirection getDismissDirection() {
        if (getOffset().getValue().floatValue() == 0.0f) {
            return null;
        }
        return getOffset().getValue().floatValue() > 0.0f ? DismissDirection.StartToEnd : DismissDirection.EndToStart;
    }

    public final boolean isDismissed(@NotNull DismissDirection direction) {
        t.i(direction, "direction");
        return getCurrentValue() == (direction == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart);
    }

    @Nullable
    public final Object reset(@NotNull d<? super k0> dVar) {
        Object objAnimateTo$default = SwipeableState.animateTo$default(this, DismissValue.Default, null, dVar, 2, null);
        return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissState(@NotNull DismissValue initialValue, @NotNull l<? super DismissValue, Boolean> confirmStateChange) {
        super(initialValue, null, confirmStateChange, 2, null);
        t.i(initialValue, "initialValue");
        t.i(confirmStateChange, "confirmStateChange");
    }
}

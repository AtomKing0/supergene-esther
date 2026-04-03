package androidx.compose.ui.platform;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.WindowInfoKt$WindowFocusObserver$1$1", f = "WindowInfo.kt", l = {47}, m = "invokeSuspend")
final class WindowInfoKt$WindowFocusObserver$1$1 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {
    final /* synthetic */ State<h9.l<Boolean, v8.k0>> $callback;
    final /* synthetic */ WindowInfo $windowInfo;
    int label;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.WindowInfoKt$WindowFocusObserver$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInfo.kt */
    static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.a<Boolean> {
        final /* synthetic */ WindowInfo $windowInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WindowInfo windowInfo) {
            super(0);
            this.$windowInfo = windowInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(this.$windowInfo.isWindowFocused());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    WindowInfoKt$WindowFocusObserver$1$1(WindowInfo windowInfo, State<? extends h9.l<? super Boolean, v8.k0>> state, z8.d<? super WindowInfoKt$WindowFocusObserver$1$1> dVar) {
        super(2, dVar);
        this.$windowInfo = windowInfo;
        this.$callback = state;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new WindowInfoKt$WindowFocusObserver$1$1(this.$windowInfo, this.$callback, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            v8.u.b(obj);
            s9.h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new AnonymousClass1(this.$windowInfo));
            final State<h9.l<Boolean, v8.k0>> state = this.$callback;
            s9.i<Boolean> iVar = new s9.i<Boolean>() { // from class: androidx.compose.ui.platform.WindowInfoKt$WindowFocusObserver$1$1.2
                @Override // s9.i
                public /* bridge */ /* synthetic */ Object emit(Boolean bool, z8.d dVar) {
                    return emit(bool.booleanValue(), (z8.d<? super v8.k0>) dVar);
                }

                @Nullable
                public final Object emit(boolean z10, @NotNull z8.d<? super v8.k0> dVar) {
                    v8.k0 k0VarInvoke = state.getValue().invoke(kotlin.coroutines.jvm.internal.b.a(z10));
                    return k0VarInvoke == a9.d.e() ? k0VarInvoke : v8.k0.f35197a;
                }
            };
            this.label = 1;
            if (hVarSnapshotFlow.collect(iVar, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
        }
        return v8.k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
        return ((WindowInfoKt$WindowFocusObserver$1$1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
    }
}

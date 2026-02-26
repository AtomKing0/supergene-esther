package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewCompositionStrategy_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ViewCompositionStrategy_androidKt$installForLifecycle$2, reason: invalid class name */
    /* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ LifecycleEventObserver $observer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            super(0);
            this.$lifecycle = lifecycle;
            this.$observer = lifecycleEventObserver;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            invoke2();
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$lifecycle.removeObserver(this.$observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h9.a<v8.k0> installForLifecycle(final AbstractComposeView abstractComposeView, Lifecycle lifecycle) {
        if (lifecycle.getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) {
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.z1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ViewCompositionStrategy_androidKt.m3215installForLifecycle$lambda1(abstractComposeView, lifecycleOwner, event);
                }
            };
            lifecycle.addObserver(lifecycleEventObserver);
            return new AnonymousClass2(lifecycle, lifecycleEventObserver);
        }
        throw new IllegalStateException(("Cannot configure " + abstractComposeView + " to disposeComposition at Lifecycle ON_DESTROY: " + lifecycle + "is already destroyed").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: installForLifecycle$lambda-1, reason: not valid java name */
    public static final void m3215installForLifecycle$lambda1(AbstractComposeView view, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        kotlin.jvm.internal.t.i(view, "$view");
        kotlin.jvm.internal.t.i(lifecycleOwner, "<anonymous parameter 0>");
        kotlin.jvm.internal.t.i(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            view.disposeComposition();
        }
    }
}

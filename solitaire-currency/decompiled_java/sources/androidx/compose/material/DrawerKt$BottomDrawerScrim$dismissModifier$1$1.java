package androidx.compose.material;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$1$1", f = "Drawer.kt", l = {634}, m = "invokeSuspend")
final class DrawerKt$BottomDrawerScrim$dismissModifier$1$1 extends l implements p<PointerInputScope, d<? super k0>, Object> {
    final /* synthetic */ a<k0> $onDismiss;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Drawer.kt */
    static final class AnonymousClass1 extends v implements h9.l<Offset, k0> {
        final /* synthetic */ a<k0> $onDismiss;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(a<k0> aVar) {
            super(1);
            this.$onDismiss = aVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
            m1009invokek4lQ0M(offset.m1377unboximpl());
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m1009invokek4lQ0M(long j10) {
            this.$onDismiss.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawerScrim$dismissModifier$1$1(a<k0> aVar, d<? super DrawerKt$BottomDrawerScrim$dismissModifier$1$1> dVar) {
        super(2, dVar);
        this.$onDismiss = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        DrawerKt$BottomDrawerScrim$dismissModifier$1$1 drawerKt$BottomDrawerScrim$dismissModifier$1$1 = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(this.$onDismiss, dVar);
        drawerKt$BottomDrawerScrim$dismissModifier$1$1.L$0 = obj;
        return drawerKt$BottomDrawerScrim$dismissModifier$1$1;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
        return ((DrawerKt$BottomDrawerScrim$dismissModifier$1$1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onDismiss);
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, anonymousClass1, this, 7, null) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }
}

package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import com.ironsource.c3;
import h9.q;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
final class DragLogic {

    @NotNull
    private final MutableState<DragInteraction.Start> dragStartInteraction;

    @Nullable
    private final MutableInteractionSource interactionSource;

    @NotNull
    private final q<o0, Offset, z8.d<? super k0>, Object> onDragStarted;

    @NotNull
    private final q<o0, Float, z8.d<? super k0>, Object> onDragStopped;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragLogic$processDragCancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", l = {c3.a.b.f11499h, c3.a.b.f11502k}, m = "processDragCancel")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragLogic.this.processDragCancel(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragLogic$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", l = {390, 393, 395}, m = "processDragStart")
    static final class C08391 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C08391(z8.d<? super C08391> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragLogic.this.processDragStart(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragLogic$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", l = {400, 403}, m = "processDragStop")
    static final class C08401 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C08401(z8.d<? super C08401> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragLogic.this.processDragStop(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DragLogic(@NotNull q<? super o0, ? super Offset, ? super z8.d<? super k0>, ? extends Object> onDragStarted, @NotNull q<? super o0, ? super Float, ? super z8.d<? super k0>, ? extends Object> onDragStopped, @NotNull MutableState<DragInteraction.Start> dragStartInteraction, @Nullable MutableInteractionSource mutableInteractionSource) {
        t.i(onDragStarted, "onDragStarted");
        t.i(onDragStopped, "onDragStopped");
        t.i(dragStartInteraction, "dragStartInteraction");
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.dragStartInteraction = dragStartInteraction;
        this.interactionSource = mutableInteractionSource;
    }

    @NotNull
    public final MutableState<DragInteraction.Start> getDragStartInteraction() {
        return this.dragStartInteraction;
    }

    @Nullable
    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @NotNull
    public final q<o0, Offset, z8.d<? super k0>, Object> getOnDragStarted() {
        return this.onDragStarted;
    }

    @NotNull
    public final q<o0, Float, z8.d<? super k0>, Object> getOnDragStopped() {
        return this.onDragStopped;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragCancel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.o0 r8, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.DragLogic.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.DragLogic$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragLogic.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragLogic$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragCancel$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            v8.u.b(r9)
            goto L80
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.o0 r8 = (kotlinx.coroutines.o0) r8
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DragLogic r2 = (androidx.compose.foundation.gestures.DragLogic) r2
            v8.u.b(r9)
            goto L65
        L41:
            v8.u.b(r9)
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r9 = r7.dragStartInteraction
            java.lang.Object r9 = r9.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            if (r9 == 0) goto L6b
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r7.interactionSource
            if (r2 == 0) goto L64
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r9)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r2.emit(r6, r0)
            if (r9 != r1) goto L64
            return r1
        L64:
            r2 = r7
        L65:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r9 = r2.dragStartInteraction
            r9.setValue(r5)
            goto L6c
        L6b:
            r2 = r7
        L6c:
            h9.q<kotlinx.coroutines.o0, java.lang.Float, z8.d<? super v8.k0>, java.lang.Object> r9 = r2.onDragStopped
            r2 = 0
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.b.c(r2)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r9.invoke(r8, r2, r0)
            if (r8 != r1) goto L80
            return r1
        L80:
            v8.k0 r8 = v8.k0.f35197a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragCancel(kotlinx.coroutines.o0, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStart(@org.jetbrains.annotations.NotNull kotlinx.coroutines.o0 r9, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.DragEvent.DragStarted r10, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r11) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragStart(kotlinx.coroutines.o0, androidx.compose.foundation.gestures.DragEvent$DragStarted, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStop(@org.jetbrains.annotations.NotNull kotlinx.coroutines.o0 r9, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.DragEvent.DragStopped r10, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DragLogic.C08401
            if (r0 == 0) goto L13
            r0 = r11
            androidx.compose.foundation.gestures.DragLogic$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragLogic.C08401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragLogic$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragStop$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L48
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            v8.u.b(r11)
            goto L8e
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            java.lang.Object r9 = r0.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStopped r9 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r9
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.o0 r10 = (kotlinx.coroutines.o0) r10
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DragLogic r2 = (androidx.compose.foundation.gestures.DragLogic) r2
            v8.u.b(r11)
            r7 = r10
            r10 = r9
            r9 = r7
            goto L6e
        L48:
            v8.u.b(r11)
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r11 = r8.dragStartInteraction
            java.lang.Object r11 = r11.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = (androidx.compose.foundation.interaction.DragInteraction.Start) r11
            if (r11 == 0) goto L74
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L6d
            androidx.compose.foundation.interaction.DragInteraction$Stop r6 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r6.<init>(r11)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = r2.emit(r6, r0)
            if (r11 != r1) goto L6d
            return r1
        L6d:
            r2 = r8
        L6e:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r11 = r2.dragStartInteraction
            r11.setValue(r5)
            goto L75
        L74:
            r2 = r8
        L75:
            h9.q<kotlinx.coroutines.o0, java.lang.Float, z8.d<? super v8.k0>, java.lang.Object> r11 = r2.onDragStopped
            float r10 = r10.getVelocity()
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.b.c(r10)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r9 = r11.invoke(r9, r10, r0)
            if (r9 != r1) goto L8e
            return r1
        L8e:
            v8.k0 r9 = v8.k0.f35197a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragStop(kotlinx.coroutines.o0, androidx.compose.foundation.gestures.DragEvent$DragStopped, z8.d):java.lang.Object");
    }
}

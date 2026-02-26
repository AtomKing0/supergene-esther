package androidx.compose.foundation.text;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: TextFieldGestureModifiers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldGestureModifiersKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldGestureModifiersKt$longPressDragGestureFilter$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldGestureModifiers.kt */
    @f(c = "androidx.compose.foundation.text.TextFieldGestureModifiersKt$longPressDragGestureFilter$1", f = "TextFieldGestureModifiers.kt", l = {35}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TextDragObserver textDragObserver, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                TextDragObserver textDragObserver = this.$observer;
                this.label = 1;
                if (LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver(pointerInputScope, textDragObserver, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldGestureModifiersKt$mouseDragGestureDetector$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TextFieldGestureModifiers.kt */
    @f(c = "androidx.compose.foundation.text.TextFieldGestureModifiersKt$mouseDragGestureDetector$1", f = "TextFieldGestureModifiers.kt", l = {56}, m = "invokeSuspend")
    static final class C09101 extends l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ MouseSelectionObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09101(MouseSelectionObserver mouseSelectionObserver, d<? super C09101> dVar) {
            super(2, dVar);
            this.$observer = mouseSelectionObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09101 c09101 = new C09101(this.$observer, dVar);
            c09101.L$0 = obj;
            return c09101;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((C09101) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                MouseSelectionObserver mouseSelectionObserver = this.$observer;
                this.label = 1;
                if (TextSelectionMouseDetectorKt.mouseSelectionDetector(pointerInputScope, mouseSelectionObserver, this) == objE) {
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

    @NotNull
    public static final Modifier longPressDragGestureFilter(@NotNull Modifier modifier, @NotNull TextDragObserver observer, boolean z10) {
        t.i(modifier, "<this>");
        t.i(observer, "observer");
        return z10 ? SuspendingPointerInputFilterKt.pointerInput(modifier, observer, new AnonymousClass1(observer, null)) : modifier;
    }

    @NotNull
    public static final Modifier mouseDragGestureDetector(@NotNull Modifier modifier, @NotNull MouseSelectionObserver observer, boolean z10) {
        t.i(modifier, "<this>");
        t.i(observer, "observer");
        return z10 ? SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, observer, new C09101(observer, null)) : modifier;
    }

    @NotNull
    public static final Modifier textFieldFocusModifier(@NotNull Modifier modifier, boolean z10, @NotNull FocusRequester focusRequester, @Nullable MutableInteractionSource mutableInteractionSource, @NotNull h9.l<? super FocusState, k0> onFocusChanged) {
        t.i(modifier, "<this>");
        t.i(focusRequester, "focusRequester");
        t.i(onFocusChanged, "onFocusChanged");
        return FocusableKt.focusable(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), onFocusChanged), z10, mutableInteractionSource);
    }
}

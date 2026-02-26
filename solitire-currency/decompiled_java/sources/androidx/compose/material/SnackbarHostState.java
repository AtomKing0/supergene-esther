package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;
import y9.a;
import y9.c;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class SnackbarHostState {

    @NotNull
    private final a mutex = c.b(false, 1, null);

    @NotNull
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: compiled from: SnackbarHost.kt */
    @Stable
    private static final class SnackbarDataImpl implements SnackbarData {

        @Nullable
        private final String actionLabel;

        @NotNull
        private final o<SnackbarResult> continuation;

        @NotNull
        private final SnackbarDuration duration;

        @NotNull
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public SnackbarDataImpl(@NotNull String message, @Nullable String str, @NotNull SnackbarDuration duration, @NotNull o<? super SnackbarResult> continuation) {
            t.i(message, "message");
            t.i(duration, "duration");
            t.i(continuation, "continuation");
            this.message = message;
            this.actionLabel = str;
            this.duration = duration;
            this.continuation = continuation;
        }

        @Override // androidx.compose.material.SnackbarData
        public void dismiss() {
            if (this.continuation.isActive()) {
                o<SnackbarResult> oVar = this.continuation;
                t.a aVar = v8.t.f35208b;
                oVar.resumeWith(v8.t.b(SnackbarResult.Dismissed));
            }
        }

        @Override // androidx.compose.material.SnackbarData
        @Nullable
        public String getActionLabel() {
            return this.actionLabel;
        }

        @Override // androidx.compose.material.SnackbarData
        @NotNull
        public SnackbarDuration getDuration() {
            return this.duration;
        }

        @Override // androidx.compose.material.SnackbarData
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // androidx.compose.material.SnackbarData
        public void performAction() {
            if (this.continuation.isActive()) {
                o<SnackbarResult> oVar = this.continuation;
                t.a aVar = v8.t.f35208b;
                oVar.resumeWith(v8.t.b(SnackbarResult.ActionPerformed));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarHostState$showSnackbar$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnackbarHost.kt */
    @f(c = "androidx.compose.material.SnackbarHostState", f = "SnackbarHost.kt", l = {379, 382}, m = "showSnackbar")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return SnackbarHostState.this.showSnackbar(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(str, str2, snackbarDuration, dVar);
    }

    @Nullable
    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object showSnackbar(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.NotNull androidx.compose.material.SnackbarDuration r11, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.material.SnackbarResult> r12) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostState.showSnackbar(java.lang.String, java.lang.String, androidx.compose.material.SnackbarDuration, z8.d):java.lang.Object");
    }
}

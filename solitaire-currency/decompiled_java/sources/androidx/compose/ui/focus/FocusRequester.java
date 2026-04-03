package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusRequester.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FocusRequester {

    @NotNull
    private final MutableVector<FocusRequesterModifierLocal> focusRequesterModifierLocals = new MutableVector<>(new FocusRequesterModifierLocal[16], 0);

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = MutableVector.$stable;

    @NotNull
    private static final FocusRequester Default = new FocusRequester();

    /* JADX INFO: compiled from: FocusRequester.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: FocusRequester.kt */
        @StabilityInferred(parameters = 0)
        @ExperimentalComposeUiApi
        public static final class FocusRequesterFactory {
            public static final int $stable = 0;

            @NotNull
            public static final FocusRequesterFactory INSTANCE = new FocusRequesterFactory();

            private FocusRequesterFactory() {
            }

            @NotNull
            public final FocusRequester component1() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component10() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component11() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component12() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component13() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component14() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component15() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component16() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component2() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component3() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component4() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component5() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component6() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component7() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component8() {
                return new FocusRequester();
            }

            @NotNull
            public final FocusRequester component9() {
                return new FocusRequester();
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @ExperimentalComposeUiApi
        @NotNull
        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }

        @NotNull
        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }
    }

    public final boolean captureFocus() {
        if (!this.focusRequesterModifierLocals.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        MutableVector<FocusRequesterModifierLocal> mutableVector = this.focusRequesterModifierLocals;
        int size = mutableVector.getSize();
        int i10 = 0;
        if (size <= 0) {
            return false;
        }
        FocusRequesterModifierLocal[] content = mutableVector.getContent();
        boolean z10 = false;
        do {
            FocusModifier focusModifierFindFocusNode = content[i10].findFocusNode();
            if (focusModifierFindFocusNode != null && FocusTransactionsKt.captureFocus(focusModifierFindFocusNode)) {
                z10 = true;
            }
            i10++;
        } while (i10 < size);
        return z10;
    }

    public final boolean freeFocus() {
        if (!this.focusRequesterModifierLocals.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        MutableVector<FocusRequesterModifierLocal> mutableVector = this.focusRequesterModifierLocals;
        int size = mutableVector.getSize();
        int i10 = 0;
        if (size <= 0) {
            return false;
        }
        FocusRequesterModifierLocal[] content = mutableVector.getContent();
        boolean z10 = false;
        do {
            FocusModifier focusModifierFindFocusNode = content[i10].findFocusNode();
            if (focusModifierFindFocusNode != null && FocusTransactionsKt.freeFocus(focusModifierFindFocusNode)) {
                z10 = true;
            }
            i10++;
        } while (i10 < size);
        return z10;
    }

    @NotNull
    public final MutableVector<FocusRequesterModifierLocal> getFocusRequesterModifierLocals$ui_release() {
        return this.focusRequesterModifierLocals;
    }

    public final void requestFocus() {
        if (!this.focusRequesterModifierLocals.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        MutableVector<FocusRequesterModifierLocal> mutableVector = this.focusRequesterModifierLocals;
        int size = mutableVector.getSize();
        if (size > 0) {
            FocusRequesterModifierLocal[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                FocusModifier focusModifierFindFocusNode = content[i10].findFocusNode();
                if (focusModifierFindFocusNode != null) {
                    FocusTransactionsKt.requestFocus(focusModifierFindFocusNode);
                }
                i10++;
            } while (i10 < size);
        }
    }
}

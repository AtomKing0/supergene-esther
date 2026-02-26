package androidx.compose.ui.text.input;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VisualTransformation.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface VisualTransformation {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    TransformedText filter(@NotNull AnnotatedString annotatedString);

    /* JADX INFO: compiled from: VisualTransformation.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final VisualTransformation None = new VisualTransformation() { // from class: androidx.compose.ui.text.input.b
            @Override // androidx.compose.ui.text.input.VisualTransformation
            public final TransformedText filter(AnnotatedString annotatedString) {
                return VisualTransformation.Companion.m3513None$lambda0(annotatedString);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: None$lambda-0, reason: not valid java name */
        public static final TransformedText m3513None$lambda0(AnnotatedString text) {
            t.i(text, "text");
            return new TransformedText(text, OffsetMapping.Companion.getIdentity());
        }

        @NotNull
        public final VisualTransformation getNone() {
            return None;
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }
    }
}

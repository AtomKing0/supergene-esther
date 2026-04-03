package androidx.compose.ui.text.platform.extensions;

import android.text.style.TtsSpan;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: TtsAnnotationExtensions.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TtsAnnotationExtensions_androidKt {
    @NotNull
    public static final TtsSpan toSpan(@NotNull TtsAnnotation ttsAnnotation) {
        t.i(ttsAnnotation, "<this>");
        if (ttsAnnotation instanceof VerbatimTtsAnnotation) {
            return toSpan((VerbatimTtsAnnotation) ttsAnnotation);
        }
        throw new q();
    }

    @NotNull
    public static final TtsSpan toSpan(@NotNull VerbatimTtsAnnotation verbatimTtsAnnotation) {
        t.i(verbatimTtsAnnotation, "<this>");
        TtsSpan ttsSpanBuild = new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.getVerbatim()).build();
        t.h(ttsSpanBuild, "builder.build()");
        return ttsSpanBuild;
    }
}

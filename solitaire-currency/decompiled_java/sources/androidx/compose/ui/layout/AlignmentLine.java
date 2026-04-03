package androidx.compose.ui.layout;

import androidx.compose.runtime.Immutable;
import h9.p;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class AlignmentLine {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int Unspecified = Integer.MIN_VALUE;

    @NotNull
    private final p<Integer, Integer, Integer> merger;

    /* JADX INFO: compiled from: AlignmentLine.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public /* synthetic */ AlignmentLine(p pVar, kotlin.jvm.internal.k kVar) {
        this(pVar);
    }

    @NotNull
    public final p<Integer, Integer, Integer> getMerger$ui_release() {
        return this.merger;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AlignmentLine(p<? super Integer, ? super Integer, Integer> pVar) {
        this.merger = pVar;
    }
}

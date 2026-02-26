package androidx.compose.ui.text.platform.extensions;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpannableExtensions.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class SpanRange {
    private final int end;

    @NotNull
    private final Object span;
    private final int start;

    public SpanRange(@NotNull Object span, int i10, int i11) {
        t.i(span, "span");
        this.span = span;
        this.start = i10;
        this.end = i11;
    }

    public static /* synthetic */ SpanRange copy$default(SpanRange spanRange, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 1) != 0) {
            obj = spanRange.span;
        }
        if ((i12 & 2) != 0) {
            i10 = spanRange.start;
        }
        if ((i12 & 4) != 0) {
            i11 = spanRange.end;
        }
        return spanRange.copy(obj, i10, i11);
    }

    @NotNull
    public final Object component1() {
        return this.span;
    }

    public final int component2() {
        return this.start;
    }

    public final int component3() {
        return this.end;
    }

    @NotNull
    public final SpanRange copy(@NotNull Object span, int i10, int i11) {
        t.i(span, "span");
        return new SpanRange(span, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanRange)) {
            return false;
        }
        SpanRange spanRange = (SpanRange) obj;
        return t.d(this.span, spanRange.span) && this.start == spanRange.start && this.end == spanRange.end;
    }

    public final int getEnd() {
        return this.end;
    }

    @NotNull
    public final Object getSpan() {
        return this.span;
    }

    public final int getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((this.span.hashCode() * 31) + this.start) * 31) + this.end;
    }

    @NotNull
    public String toString() {
        return "SpanRange(span=" + this.span + ", start=" + this.start + ", end=" + this.end + ')';
    }
}

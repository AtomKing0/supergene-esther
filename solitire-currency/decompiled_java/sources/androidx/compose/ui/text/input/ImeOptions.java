package androidx.compose.ui.text.input;

import androidx.compose.foundation.e;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImeOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ImeOptions {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, 31, null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;
    private final boolean singleLine;

    /* JADX INFO: compiled from: ImeOptions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }
    }

    public /* synthetic */ ImeOptions(boolean z10, int i10, boolean z11, int i11, int i12, k kVar) {
        this(z10, i10, z11, i11, i12);
    }

    /* JADX INFO: renamed from: copy-uxg59PA$default, reason: not valid java name */
    public static /* synthetic */ ImeOptions m3471copyuxg59PA$default(ImeOptions imeOptions, boolean z10, int i10, boolean z11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            z10 = imeOptions.singleLine;
        }
        if ((i13 & 2) != 0) {
            i10 = imeOptions.capitalization;
        }
        int i14 = i10;
        if ((i13 & 4) != 0) {
            z11 = imeOptions.autoCorrect;
        }
        boolean z12 = z11;
        if ((i13 & 8) != 0) {
            i11 = imeOptions.keyboardType;
        }
        int i15 = i11;
        if ((i13 & 16) != 0) {
            i12 = imeOptions.imeAction;
        }
        return imeOptions.m3472copyuxg59PA(z10, i14, z12, i15, i12);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-uxg59PA, reason: not valid java name */
    public final ImeOptions m3472copyuxg59PA(boolean z10, int i10, boolean z11, int i11, int i12) {
        return new ImeOptions(z10, i10, z11, i11, i12, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) obj;
        return this.singleLine == imeOptions.singleLine && KeyboardCapitalization.m3481equalsimpl0(this.capitalization, imeOptions.capitalization) && this.autoCorrect == imeOptions.autoCorrect && KeyboardType.m3492equalsimpl0(this.keyboardType, imeOptions.keyboardType) && ImeAction.m3459equalsimpl0(this.imeAction, imeOptions.imeAction);
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name */
    public final int m3473getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name */
    public final int m3474getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name */
    public final int m3475getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public int hashCode() {
        return (((((((e.a(this.singleLine) * 31) + KeyboardCapitalization.m3482hashCodeimpl(this.capitalization)) * 31) + e.a(this.autoCorrect)) * 31) + KeyboardType.m3493hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m3460hashCodeimpl(this.imeAction);
    }

    @NotNull
    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + ((Object) KeyboardCapitalization.m3483toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m3494toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m3461toStringimpl(this.imeAction)) + ')';
    }

    private ImeOptions(boolean z10, int i10, boolean z11, int i11, int i12) {
        this.singleLine = z10;
        this.capitalization = i10;
        this.autoCorrect = z11;
        this.keyboardType = i11;
        this.imeAction = i12;
    }

    public /* synthetic */ ImeOptions(boolean z10, int i10, boolean z11, int i11, int i12, int i13, k kVar) {
        this((i13 & 1) != 0 ? false : z10, (i13 & 2) != 0 ? KeyboardCapitalization.Companion.m3486getNoneIUNYP9k() : i10, (i13 & 4) != 0 ? true : z11, (i13 & 8) != 0 ? KeyboardType.Companion.m3503getTextPjHm6EE() : i11, (i13 & 16) != 0 ? ImeAction.Companion.m3463getDefaulteUduSuo() : i12, null);
    }
}

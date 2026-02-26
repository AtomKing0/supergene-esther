package androidx.compose.foundation.text;

import androidx.compose.foundation.e;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KeyboardOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class KeyboardOptions {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final KeyboardOptions Default = new KeyboardOptions(0, false, 0, 0, 15, null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;

    /* JADX INFO: compiled from: KeyboardOptions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }
    }

    public /* synthetic */ KeyboardOptions(int i10, boolean z10, int i11, int i12, k kVar) {
        this(i10, z10, i11, i12);
    }

    /* JADX INFO: renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m675copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i10, boolean z10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = keyboardOptions.capitalization;
        }
        if ((i13 & 2) != 0) {
            z10 = keyboardOptions.autoCorrect;
        }
        if ((i13 & 4) != 0) {
            i11 = keyboardOptions.keyboardType;
        }
        if ((i13 & 8) != 0) {
            i12 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m676copy3m2b7yw(i10, z10, i11, i12);
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = ImeOptions.Companion.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z10);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-3m2b7yw, reason: not valid java name */
    public final KeyboardOptions m676copy3m2b7yw(int i10, boolean z10, int i11, int i12) {
        return new KeyboardOptions(i10, z10, i11, i12, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        return KeyboardCapitalization.m3481equalsimpl0(this.capitalization, keyboardOptions.capitalization) && this.autoCorrect == keyboardOptions.autoCorrect && KeyboardType.m3492equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m3459equalsimpl0(this.imeAction, keyboardOptions.imeAction);
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* JADX INFO: renamed from: getCapitalization-IUNYP9k, reason: not valid java name */
    public final int m677getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* JADX INFO: renamed from: getImeAction-eUduSuo, reason: not valid java name */
    public final int m678getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* JADX INFO: renamed from: getKeyboardType-PjHm6EE, reason: not valid java name */
    public final int m679getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public int hashCode() {
        return (((((KeyboardCapitalization.m3482hashCodeimpl(this.capitalization) * 31) + e.a(this.autoCorrect)) * 31) + KeyboardType.m3493hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m3460hashCodeimpl(this.imeAction);
    }

    @NotNull
    public final ImeOptions toImeOptions$foundation_release(boolean z10) {
        return new ImeOptions(z10, this.capitalization, this.autoCorrect, this.keyboardType, this.imeAction, null);
    }

    @NotNull
    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m3483toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m3494toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m3461toStringimpl(this.imeAction)) + ')';
    }

    private KeyboardOptions(int i10, boolean z10, int i11, int i12) {
        this.capitalization = i10;
        this.autoCorrect = z10;
        this.keyboardType = i11;
        this.imeAction = i12;
    }

    public /* synthetic */ KeyboardOptions(int i10, boolean z10, int i11, int i12, int i13, k kVar) {
        this((i13 & 1) != 0 ? KeyboardCapitalization.Companion.m3486getNoneIUNYP9k() : i10, (i13 & 2) != 0 ? true : z10, (i13 & 4) != 0 ? KeyboardType.Companion.m3503getTextPjHm6EE() : i11, (i13 & 8) != 0 ? ImeAction.Companion.m3463getDefaulteUduSuo() : i12, null);
    }
}

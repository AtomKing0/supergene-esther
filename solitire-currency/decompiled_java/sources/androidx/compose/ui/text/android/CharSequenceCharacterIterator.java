package androidx.compose.ui.text.android;

import java.text.CharacterIterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CharSequenceCharacterIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CharSequenceCharacterIterator implements CharacterIterator {

    @NotNull
    private final CharSequence charSequence;
    private final int end;
    private int index;
    private final int start;

    public CharSequenceCharacterIterator(@NotNull CharSequence charSequence, int i10, int i11) {
        t.i(charSequence, "charSequence");
        this.charSequence = charSequence;
        this.start = i10;
        this.end = i11;
        this.index = i10;
    }

    @Override // java.text.CharacterIterator
    @NotNull
    public Object clone() {
        try {
            Object objClone = super.clone();
            t.h(objClone, "{\n            @Suppress(…  super.clone()\n        }");
            return objClone;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int i10 = this.index;
        if (i10 == this.end) {
            return (char) 65535;
        }
        return this.charSequence.charAt(i10);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.index = this.start;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.start;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.index;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int i10 = this.start;
        int i11 = this.end;
        if (i10 == i11) {
            this.index = i11;
            return (char) 65535;
        }
        int i12 = i11 - 1;
        this.index = i12;
        return this.charSequence.charAt(i12);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int i10 = this.index + 1;
        this.index = i10;
        int i11 = this.end;
        if (i10 < i11) {
            return this.charSequence.charAt(i10);
        }
        this.index = i11;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i10 = this.index;
        if (i10 <= this.start) {
            return (char) 65535;
        }
        int i11 = i10 - 1;
        this.index = i11;
        return this.charSequence.charAt(i11);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i10) {
        int i11 = this.start;
        boolean z10 = false;
        if (i10 <= this.end && i11 <= i10) {
            z10 = true;
        }
        if (!z10) {
            throw new IllegalArgumentException("invalid position");
        }
        this.index = i10;
        return current();
    }
}

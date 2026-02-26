package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import h9.r;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ h9.l<Editable, k0> $afterTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, k0> $beforeTextChanged;
    final /* synthetic */ r<CharSequence, Integer, Integer, Integer, k0> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(h9.l<? super Editable, k0> lVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, k0> rVar, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, k0> rVar2) {
        this.$afterTextChanged = lVar;
        this.$beforeTextChanged = rVar;
        this.$onTextChanged = rVar2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }
}

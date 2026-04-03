package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import h9.r;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt {

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextView.kt */
    public static final class AnonymousClass1 extends v implements r<CharSequence, Integer, Integer, Integer, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(4);
        }

        public final void invoke(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$2, reason: invalid class name */
    /* JADX INFO: compiled from: TextView.kt */
    public static final class AnonymousClass2 extends v implements r<CharSequence, Integer, Integer, Integer, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(4);
        }

        public final void invoke(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$3, reason: invalid class name */
    /* JADX INFO: compiled from: TextView.kt */
    public static final class AnonymousClass3 extends v implements h9.l<Editable, k0> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Editable editable) {
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Editable editable) {
            invoke2(editable);
            return k0.f35197a;
        }
    }

    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull TextView textView, @NotNull r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, k0> rVar, @NotNull r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, k0> rVar2, @NotNull h9.l<? super Editable, k0> lVar) {
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(lVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, r rVar, r rVar2, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            rVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            rVar2 = AnonymousClass2.INSTANCE;
        }
        if ((i10 & 4) != 0) {
            lVar = AnonymousClass3.INSTANCE;
        }
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(lVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @NotNull
    public static final TextWatcher doAfterTextChanged(@NotNull TextView textView, @NotNull final h9.l<? super Editable, k0> lVar) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                lVar.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doBeforeTextChanged(@NotNull TextView textView, @NotNull final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, k0> rVar) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
                rVar.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doOnTextChanged(@NotNull TextView textView, @NotNull final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, k0> rVar) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
                rVar.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}

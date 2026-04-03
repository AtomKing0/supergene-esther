package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidAutofill.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class AutofillApi26Helper {

    @NotNull
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    private AutofillApi26Helper() {
    }

    @DoNotInline
    @RequiresApi(26)
    @Nullable
    public final AutofillId getAutofillId(@NotNull ViewStructure structure) {
        t.i(structure, "structure");
        return structure.getAutofillId();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isDate(@NotNull AutofillValue value) {
        t.i(value, "value");
        return value.isDate();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isList(@NotNull AutofillValue value) {
        t.i(value, "value");
        return value.isList();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isText(@NotNull AutofillValue value) {
        t.i(value, "value");
        return value.isText();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isToggle(@NotNull AutofillValue value) {
        t.i(value, "value");
        return value.isToggle();
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillHints(@NotNull ViewStructure structure, @NotNull String[] hints) {
        t.i(structure, "structure");
        t.i(hints, "hints");
        structure.setAutofillHints(hints);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillId(@NotNull ViewStructure structure, @NotNull AutofillId parent, int i10) {
        t.i(structure, "structure");
        t.i(parent, "parent");
        structure.setAutofillId(parent, i10);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillType(@NotNull ViewStructure structure, int i10) {
        t.i(structure, "structure");
        structure.setAutofillType(i10);
    }

    @DoNotInline
    @RequiresApi(26)
    @NotNull
    public final CharSequence textValue(@NotNull AutofillValue value) {
        t.i(value, "value");
        CharSequence textValue = value.getTextValue();
        t.h(textValue, "value.textValue");
        return textValue;
    }
}

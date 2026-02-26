package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StaticLayoutFactory.kt */
/* JADX INFO: loaded from: classes.dex */
interface StaticLayoutFactoryImpl {
    @DoNotInline
    @NotNull
    StaticLayout create(@NotNull StaticLayoutParams staticLayoutParams);
}

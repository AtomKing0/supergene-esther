package androidx.compose.ui;

import androidx.compose.runtime.ComposableTargetMarker;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: UiComposable.kt */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@ComposableTargetMarker(description = "UI Composable")
@Retention(RetentionPolicy.CLASS)
public @interface UiComposable {
}

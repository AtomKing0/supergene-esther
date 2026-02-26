package androidx.compose.ui;

import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Modifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b {
    public static boolean a(Modifier.Element element, @NotNull l predicate) {
        t.i(predicate, "predicate");
        return ((Boolean) predicate.invoke(element)).booleanValue();
    }

    public static boolean b(Modifier.Element element, @NotNull l predicate) {
        t.i(predicate, "predicate");
        return ((Boolean) predicate.invoke(element)).booleanValue();
    }

    public static Object c(Modifier.Element element, Object obj, @NotNull p operation) {
        t.i(operation, "operation");
        return operation.mo4invoke(obj, element);
    }

    public static Object d(Modifier.Element element, Object obj, @NotNull p operation) {
        t.i(operation, "operation");
        return operation.mo4invoke(element, obj);
    }
}

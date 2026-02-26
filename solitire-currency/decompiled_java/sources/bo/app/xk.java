package bo.app;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes2.dex */
public enum xk {
    INTEGER(TypedValues.Custom.S_INT),
    COLOR("color"),
    BOOLEAN("bool"),
    STRING(TypedValues.Custom.S_STRING),
    DRAWABLE_IDENTIFIER("drawable"),
    STRING_ARRAY("array");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4288a;

    xk(String str) {
        this.f4288a = str;
    }
}
